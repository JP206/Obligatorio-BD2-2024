package com.bd2.api.repositories;

import com.bd2.api.dto.AlumnoDTO;
import com.bd2.api.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRepository implements IUsuarioRepository {
    
    @Override
    @Async
    public LinkedList<UsuarioDTO> getUsuarios() {
        LinkedList<UsuarioDTO> listaResultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios WHERE NOT borrado");
            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setCorreo(rs.getString(4));
                listaResultado.add(usuario);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaResultado;
    }

    @Override
    @Async
    public UsuarioDTO getUsuario(int id) {
        UsuarioDTO usuario = new UsuarioDTO();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios WHERE id = " + id + " AND NOT borrado");
            rs.next();
            usuario.setId(rs.getInt(1));
            usuario.setNombre(rs.getString(2));
            usuario.setApellido(rs.getString(3));
            usuario.setCorreo(rs.getString(4));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }

    @Override
    @Async
    public boolean editarUsuario(UsuarioDTO usuario) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            String query = "UPDATE Usuarios SET nombre = ?, apellido = ?, correo = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.setInt(4, usuario.getId());

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
    public boolean borrarUsuario(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            String query = "UPDATE Usuarios SET borrado = true WHERE id = ?";
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
    public boolean crearUsuarioAdministrador(UsuarioDTO usuario) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");
            //la query es de esta forma porque al insertar usuario se le asigna un id automaticamente porque tiene auto_increment, para insertar en la segunda tabla se precisa el id generado en la primera
            String query = "INSERT INTO Usuarios (nombre, apellido, correo, contrasenia, borrado) VALUES (?, ?, ?, ?, false);";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.setString(4, usuario.getContrasenia());
            
            
            int rs = pstmt.executeUpdate();
            
            query = "INSERT INTO Administradores (id) SELECT id FROM Usuarios ORDER BY id DESC LIMIT 1";
            pstmt = con.prepareStatement(query);
            int rs2 = pstmt.executeUpdate();
            con.close();
            return (rs + rs2) != 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    @Override
    @Async
    public boolean crearUsuarioAlumno(AlumnoDTO alumno) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/obligatorio", "user", "password");            
            String query = "INSERT INTO Usuarios (nombre, apellido, correo, contrasenia, borrado) VALUES (?, ?, ?, ?, false);";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getApellido());
            pstmt.setString(3, alumno.getCorreo());
            pstmt.setString(4, alumno.getContrasenia());
            int rs = pstmt.executeUpdate();
            
            query = "INSERT INTO Alumnos (id, campeon, subcampeon) SELECT id, ?, ? FROM Usuarios ORDER BY id DESC LIMIT 1";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, alumno.getCampeon());
            pstmt.setString(2, alumno.getSubcampeon());
            int rs2 = pstmt.executeUpdate();
            
            query = "INSERT INTO Cursa (nombre_carrera, id_alumno, borrado) SELECT ?, id, false FROM Alumnos ORDER BY id DESC LIMIT 1";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, alumno.getCarrera());
            int rs3 = pstmt.executeUpdate();
            
            con.close();
            return (rs + rs2 + rs3) != 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
