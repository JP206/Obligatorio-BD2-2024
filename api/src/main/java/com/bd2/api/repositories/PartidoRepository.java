package com.bd2.api.repositories;

import com.bd2.api.dto.PartidoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service //@Service hace que se inyecte directamente en el controller
public class PartidoRepository implements IPartidoRepository {

    @Override
    @Async
    public LinkedList<PartidoDTO> getPartidos() {
        LinkedList<PartidoDTO> listaResultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Partidos WHERE NOT borrado");
            while (rs.next()) {
                PartidoDTO partido = new PartidoDTO();
                partido.setId(rs.getInt(1));
                partido.setEquipo1(rs.getString(2));
                partido.setEquipo2(rs.getString(3));
                partido.setGolesEquipo1(rs.getInt(4));
                partido.setGolesEquipo2(rs.getInt(5));
                partido.setEtapa(rs.getString(6));
                partido.setFecha(rs.getDate(7));
                partido.setHora(rs.getTime(8));
                partido.setEstadio(rs.getString(9));
                partido.setPosicionFormulario(rs.getInt(11));
                listaResultado.add(partido);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaResultado;
    }

    @Override
    @Async
    public PartidoDTO getPartido(int id) {
        PartidoDTO partido = new PartidoDTO();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Partidos WHERE id = " + id + " AND NOT borrado");
            rs.next();
            partido.setId(rs.getInt(1));
            partido.setEquipo1(rs.getString(2));
            partido.setEquipo2(rs.getString(3));
            partido.setGolesEquipo1(rs.getInt(4));
            partido.setGolesEquipo2(rs.getInt(5));
            partido.setEtapa(rs.getString(6));
            partido.setFecha(rs.getDate(7));
            partido.setHora(rs.getTime(8));
            partido.setEstadio(rs.getString(9));
            partido.setPosicionFormulario(rs.getInt(11));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return partido;
    }

    @Override
    @Async
    public boolean editarPartido(PartidoDTO[] partidos) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");

            for (PartidoDTO partido : partidos) {
                String query = "UPDATE Partidos SET equipo_1 = ?, equipo_2 = ?, goles_equipo_1 = ?, goles_equipo_2 = ?, etapa = ?, fecha = ?, hora = ?, estadio = ?, posicion_formulario = ? WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);

                pstmt.setString(1, partido.getEquipo1());
                pstmt.setString(2, partido.getEquipo2());
                pstmt.setInt(3, partido.getGolesEquipo1());
                pstmt.setInt(4, partido.getGolesEquipo2());
                pstmt.setString(5, partido.getEtapa());
                pstmt.setDate(6, partido.getFecha());
                pstmt.setTime(7, partido.getHora());
                pstmt.setString(8, partido.getEstadio());
                pstmt.setInt(9, partido.getPosicionFormulario());
                pstmt.setInt(10, partido.getId());
                
                resultado += pstmt.executeUpdate();
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado != 0;
    }

    @Override
    @Async
    public boolean borrarPartido(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            String query = "UPDATE Partidos SET borrado = true WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, id);

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
    public boolean crearPartido(PartidoDTO partido) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            String query = "INSERT INTO Partidos (equipo_1, equipo_2, goles_equipo_1, goles_equipo_2, etapa, fecha, hora, estadio, borrado, posicion_formulario) VALUES ("
                    + "?, ?, -1, -1, ?, ?, ?, ?, false, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, partido.getEquipo1());
            pstmt.setString(2, partido.getEquipo2());
            pstmt.setString(3, partido.getEtapa());
            pstmt.setDate(4, partido.getFecha());
            pstmt.setTime(5, partido.getHora());
            pstmt.setString(6, partido.getEstadio());
            pstmt.setInt(7, partido.getPosicionFormulario());

            int rs = pstmt.executeUpdate();
            con.close();
            return rs != 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
