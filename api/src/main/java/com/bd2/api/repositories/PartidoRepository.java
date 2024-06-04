package com.bd2.api.repositories;

import com.bd2.api.dto.PartidoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
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
        LinkedList<PartidoDTO> listaResultado = new LinkedList<PartidoDTO>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password"); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Partidos");
            rs.next(); //para ir al primer registro, cuando se crea no apunta a nada y da excepcion
            while (rs.next()) {
                //si es true, significa que esta borrado y no hay que devolverlo
                if (!rs.getBoolean(8)) {
                    PartidoDTO partido = new PartidoDTO();
                    partido.setId(rs.getInt(1));
                    partido.setEquipo1(rs.getString(2));
                    partido.setEquipo2(rs.getString(3));
                    partido.setGolesEquipo1(rs.getInt(4));
                    partido.setGolesEquipo2(rs.getInt(5));
                    partido.setEtapa(rs.getString(6));
                    partido.setFecha(rs.getDate(7));
                    listaResultado.add(partido);
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaResultado;
    }

    @Override
    @Async
    public PartidoDTO getPartido(long id) {
        PartidoDTO partido = new PartidoDTO();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password"); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Partidos where id = " + id);
            rs.next();
            if (!rs.getBoolean(8)) {
                partido.setId(rs.getInt(1));
                partido.setEquipo1(rs.getString(2));
                partido.setEquipo2(rs.getString(3));
                partido.setGolesEquipo1(rs.getInt(4));
                partido.setGolesEquipo2(rs.getInt(5));
                partido.setEtapa(rs.getString(6));
                partido.setFecha(rs.getDate(7));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return partido;
    }

    @Override
    @Async
    public void updatePartido(PartidoDTO partido) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password"); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("update Partidos set equipo_1 = " + partido.getEquipo1() + 
                    ", equipo_2 = " + partido.getEquipo2() + 
                    ", goles_equipo_1 = " + partido.getGolesEquipo1() + 
                    ", goles_equipo_2 = " + partido.getGolesEquipo2() +
                    ", etapa = " + partido.getEtapa() + 
                    ", fecha = " + partido.getFecha() + 
                    " where id = " + partido.getId());
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @Async
    public void deletePartido(long id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password"); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("update Partidos set borrado = " + true +
                    " where id = " +id);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @Async
    public void createPartido(PartidoDTO partido) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password"); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("insert into Partidos (equipo_1, equipo_2, goles_equipo_1, goles_equipo_2, etapa, fecha, borrado) values ("
                    + partido.getEquipo1() + 
                    ", " + partido.getEquipo2() + 
                    ", " + partido.getGolesEquipo1() + 
                    ", " + partido.getGolesEquipo2() +
                    ", " + partido.getEtapa() + 
                    ", " + partido.getFecha() + 
                    ")");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}