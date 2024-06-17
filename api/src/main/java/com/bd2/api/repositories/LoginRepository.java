package com.bd2.api.repositories;

import com.bd2.api.dto.LoginResponseDTO;
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
    public LoginResponseDTO login(String correo, String contrasenia) {
        LoginResponseDTO loginResponse = new LoginResponseDTO();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios WHERE correo = '" + correo + "' AND contrasenia = '" + contrasenia + "' AND NOT borrado");
            
            boolean loginExitoso = rs.next();
            if (loginExitoso) {
                loginResponse.setLoginExitoso(loginExitoso);
                int id = rs.getInt(1);
                rs = stmt.executeQuery("SELECT * FROM Administradores WHERE id = " + id);
                if (rs.next()) {
                    loginResponse.setEsAdmin(true);
                }
                else {
                    loginResponse.setEsAdmin(false);
                }
            }
            else {
                loginResponse.setEsAdmin(false);
                loginResponse.setLoginExitoso(false);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return loginResponse;
    }
}
