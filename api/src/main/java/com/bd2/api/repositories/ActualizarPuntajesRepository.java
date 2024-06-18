package com.bd2.api.repositories;

import com.bd2.api.dto.PartidoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ActualizarPuntajesRepository implements IActualizarPuntajesRepository {
    
    @Override
    @Async
    public boolean actualizarPuntajes(PartidoDTO[] partidos) {
        boolean exacto = false, correcto = false, incorrecto = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");

            // Partidos exactos.
            for (PartidoDTO partido : partidos) {
                String query = """
                               UPDATE Predicciones
                               SET tipo_puntaje = 'Exacto'
                               WHERE id_partido = (SELECT id FROM Partidos WHERE equipo_1 LIKE ? AND equipo_2 LIKE ?)
                               AND prediccion_equipo_1 = (SELECT goles_equipo_1 FROM Partidos WHERE equipo_1 LIKE ? AND equipo_2 LIKE ?)
                               AND prediccion_equipo_2 = (SELECT goles_equipo_2 FROM Partidos WHERE equipo_1 LIKE ? AND equipo_2 LIKE ?)""";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, partido.getEquipo1() + "%");
                pstmt.setString(2, partido.getEquipo2() + "%");
                pstmt.setString(3, partido.getEquipo1() + "%");
                pstmt.setString(4, partido.getEquipo2() + "%");
                pstmt.setString(5, partido.getEquipo1() + "%");
                pstmt.setString(6, partido.getEquipo2() + "%");
                
                
                int resultadoExacto = pstmt.executeUpdate();
                if (resultadoExacto > 0) {
                    exacto = true;
                }
                
                // Para los resultados correctos hay que ver la relación entre los goles.
                String operador = "";
                if (partido.getGolesEquipo1() > partido.getGolesEquipo2()) {
                    operador = ">";
                }
                else if (partido.getGolesEquipo1() < partido.getGolesEquipo2()) {
                    operador = "<";
                }
                else {
                    operador = "=";
                }
                query = """
                        UPDATE Predicciones
                        SET tipo_puntaje = 'Correcto'
                        WHERE id_partido = (SELECT id FROM Partidos WHERE equipo_1 LIKE ? AND equipo_2 LIKE ?)
                        AND NOT (prediccion_equipo_1 = (SELECT goles_equipo_1 FROM Partidos WHERE equipo_1 LIKE ? AND equipo_2 LIKE ?)
                                AND prediccion_equipo_2 = (SELECT goles_equipo_2 FROM Partidos WHERE equipo_1 LIKE ? AND equipo_2 LIKE ?))
                        AND prediccion_equipo_1""" + operador + "prediccion_equipo_2";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, partido.getEquipo1() + "%");
                pstmt.setString(2, partido.getEquipo2() + "%");
                pstmt.setString(3, partido.getEquipo1() + "%");
                pstmt.setString(4, partido.getEquipo2() + "%");
                pstmt.setString(5, partido.getEquipo1() + "%");
                pstmt.setString(6, partido.getEquipo2() + "%");
                
                int resultadoCorrecto = pstmt.executeUpdate();
                if (resultadoCorrecto > 0) {
                    correcto = true;
                }
                
                // Para los resultados incorrectos, se verifica que no sea correcto ni exacto.
                query = """
                        UPDATE Predicciones
                        SET tipo_puntaje = 'Incorrecto'
                        WHERE id_partido = (SELECT id FROM Partidos WHERE equipo_1 LIKE ? AND equipo_2 LIKE ?)
                        AND NOT tipo_puntaje = 'Correcto'
                        AND NOT tipo_puntaje = 'Exacto'""";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, partido.getEquipo1() + "%");
                pstmt.setString(2, partido.getEquipo2() + "%");
                
                int resultadoIncorrecto = pstmt.executeUpdate();
                if (resultadoIncorrecto > 0) {
                    incorrecto = true;
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exacto || correcto || incorrecto;
    }
}
