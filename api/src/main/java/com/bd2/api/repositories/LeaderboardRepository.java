package com.bd2.api.repositories;

import com.bd2.api.dto.LeaderboardDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardRepository implements ILeaderboardRepository {

    @Override
    @Async
    public LinkedList<LeaderboardDTO> getLeaderboard() {
        LinkedList<LeaderboardDTO> listaResultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("""
                                             SELECT nombre, apellido, SUM(puntaje) AS puntaje
                                             FROM Predicciones
                                             INNER JOIN Usuarios on Predicciones.id_alumno = Usuarios.id
                                             INNER JOIN Puntajes on Predicciones.tipo_puntaje = Puntajes.tipo
                                             GROUP BY nombre, apellido
                                             ORDER BY puntaje DESC""");
            while (rs.next()) {
                LeaderboardDTO leaderboard = new LeaderboardDTO();
                leaderboard.setNombre(rs.getString(1));
                leaderboard.setApellido(rs.getString(2));
                leaderboard.setPuntaje(rs.getInt(3));
                listaResultado.add(leaderboard);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaResultado;
    }
    
    
}
