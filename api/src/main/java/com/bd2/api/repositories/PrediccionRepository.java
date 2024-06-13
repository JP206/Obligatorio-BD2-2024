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
    public LinkedList<PrediccionDTO> getPredicciones(String nombreUsuario) {
        LinkedList<PrediccionDTO> listaResultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Predicciones.prediccion_equipo_1, Predicciones.prediccion_equipo_2, Partidos.equipo_1, Partidos.equipo_2, Puntajes.puntaje\n" +
                                            "FROM Predicciones\n" +
                                            "INNER JOIN Partidos on Predicciones.id_partido = Partidos.id\n" +
                                            "INNER JOIN Puntajes on Predicciones.tipo_puntaje = Puntajes.tipo\n" +
                                            "WHERE Predicciones.id_alumno = (SELECT id FROM Usuarios WHERE nombre = '" + nombreUsuario + "')");
            while (rs.next()) {
                PrediccionDTO prediccion = new PrediccionDTO();
                prediccion.setPrediccionEquipo1(rs.getInt(1));
                prediccion.setPrediccionEquipo2(rs.getInt(2));
                prediccion.setEquipo1(rs.getString(3));
                prediccion.setEquipo2(rs.getString(4));
                prediccion.setPuntaje(rs.getInt(5));
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
            String query = "INSERT INTO Predicciones (prediccion_equipo_1, prediccion_equipo_2, id_partido, id_alumno, tipo_puntaje) VALUES (?, ?, \n" +
                                            "(SELECT id FROM Partidos WHERE posicion_formulario = ?), \n" +
                                            "(SELECT id FROM Usuarios WHERE nombre = ?), \n" +
                                            "'No determinado')";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, hacerPrediccion.getPrediccionEquipo1());
            pstmt.setInt(2, hacerPrediccion.getPrediccionEquipo2());
            pstmt.setInt(3, hacerPrediccion.getPosicionFormulario());
            pstmt.setString(4, hacerPrediccion.getNombreUsuario());
            
            int rs = pstmt.executeUpdate();
            con.close();
            return rs != 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
