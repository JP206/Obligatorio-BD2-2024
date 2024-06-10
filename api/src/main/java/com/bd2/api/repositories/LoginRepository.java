package com.bd2.api.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LoginRepository implements ILoginRepository{

    @Override
    @Async
    public boolean login(String correo, String contrasenia) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios WHERE correo LIKE '" + correo + "%' AND contrasenia LIKE '" + contrasenia + "%' AND NOT borrado");
            
            boolean resultado = rs.next();
            con.close();
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
