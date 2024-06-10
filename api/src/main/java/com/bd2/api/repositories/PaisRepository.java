package com.bd2.api.repositories;

import com.bd2.api.dto.PaisDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service //@Service hace que se inyecte directamente en el controller
public class PaisRepository implements IPaisRepository {

    @Override
    @Async
    public LinkedList<PaisDTO> getPaises() {
        LinkedList<PaisDTO> listaResultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Paises");
            while (rs.next()) {
                PaisDTO pais = new PaisDTO();
                pais.setNombre(rs.getString(1));
                pais.setBandera(rs.getString(2));
                listaResultado.add(pais);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaResultado;
    }

    @Override
    @Async
    public PaisDTO getPais(String nombre) {
        PaisDTO pais = new PaisDTO();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Paises WHERE nombre LIKE '" + nombre + "%'");
            rs.next();
            pais.setNombre(rs.getString(1));
            pais.setBandera(rs.getString(2));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return pais;
    }
}
