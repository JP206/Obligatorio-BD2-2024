package com.bd2.api.repositories;

import com.bd2.api.dto.HacerPrediccionDTO;
import com.bd2.api.dto.PrediccionDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PrediccionRepository implements IPrediccionRepository{
    
    @Override
    @Async
    public LinkedList<PrediccionDTO> getPredicciones(String correoUsuario) {
        LinkedList<PrediccionDTO> listaResultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("""
                                             SELECT Predicciones.prediccion_equipo_1, Predicciones.prediccion_equipo_2, Partidos.equipo_1, Partidos.equipo_2, Partidos.fecha, Partidos.hora, Puntajes.puntaje
                                             FROM Predicciones
                                             INNER JOIN Partidos on Predicciones.id_partido = Partidos.id
                                             INNER JOIN Puntajes on Predicciones.tipo_puntaje = Puntajes.tipo
                                             WHERE Predicciones.id_alumno = (SELECT id FROM Usuarios WHERE correo = '""" + correoUsuario + "')");
            while (rs.next()) {
                PrediccionDTO prediccion = new PrediccionDTO();
                prediccion.setPrediccionEquipo1(rs.getInt(1));
                prediccion.setPrediccionEquipo2(rs.getInt(2));
                prediccion.setEquipo1(rs.getString(3));
                prediccion.setEquipo2(rs.getString(4));
                prediccion.setFecha(rs.getDate(5));
                prediccion.setHora(rs.getTime(6));
                prediccion.setPuntaje(rs.getInt(7));
                listaResultado.add(prediccion);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaResultado;
    }
    
    @Override
    @Async
    public boolean hacerPrediccion(HacerPrediccionDTO hacerPrediccion) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            String query = """
                           INSERT INTO Predicciones (prediccion_equipo_1, prediccion_equipo_2, id_partido, id_alumno, tipo_puntaje) VALUES (
                                   ?,
                                   ?,
                                   (SELECT id FROM Partidos WHERE equipo_1 like ? AND equipo_2 like ?),
                                   (SELECT id FROM Usuarios WHERE correo = ?),
                                   'No determinado')""";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, hacerPrediccion.getPrediccionEquipo1());
            pstmt.setInt(2, hacerPrediccion.getPrediccionEquipo2());
            pstmt.setString(3, hacerPrediccion.getEquipo1() + '%');
            pstmt.setString(4, hacerPrediccion.getEquipo2() + '%');
            pstmt.setString(5, hacerPrediccion.getEquipo2() + '%');
            pstmt.setString(6, hacerPrediccion.getEquipo1() + '%');
            pstmt.setString(7, hacerPrediccion.getCorreoUsuario());
            
            int rs = pstmt.executeUpdate();
            con.close();
            return rs != 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    @Override
    @Async
    public boolean actualizarPrediccion(HacerPrediccionDTO hacerPrediccion) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            String query = """
                           UPDATE Predicciones SET prediccion_equipo_1 = ?, prediccion_equipo_2 = ?
                           WHERE id_alumno = (SELECT id FROM Usuarios WHERE correo = ?) AND id_partido = (SELECT id FROM Partidos WHERE equipo_1 like ? and equipo_2 like ?)""";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, hacerPrediccion.getPrediccionEquipo1());
            pstmt.setInt(2, hacerPrediccion.getPrediccionEquipo2());
            pstmt.setString(3, hacerPrediccion.getCorreoUsuario());
            pstmt.setString(4, hacerPrediccion.getEquipo1() + '%');
            pstmt.setString(5, hacerPrediccion.getEquipo2() + '%');
            pstmt.setString(6, hacerPrediccion.getEquipo2() + '%');
            pstmt.setString(7, hacerPrediccion.getEquipo1() + '%');
            
            int rs = pstmt.executeUpdate();
            con.close();
            return rs != 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
