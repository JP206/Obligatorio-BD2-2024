package com.bd2.api.web;

import com.bd2.api.dto.GoodbyeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
@RequestMapping("/api")
public class GoodbyeController {

    @GetMapping(path = "/goodbye")
    public String goodbye() {
        String result = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password"); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Carreras");
            while (rs.next()) {
                result += rs.getString(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}