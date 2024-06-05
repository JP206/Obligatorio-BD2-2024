package com.bd2.api.repositories;

import com.bd2.api.dto.AlumnoDTO;
import com.bd2.api.dto.UsuarioDTO;
import java.util.LinkedList;

public interface IUsuarioRepository {
    
    public LinkedList<UsuarioDTO> getUsuarios();
    public UsuarioDTO getUsuario(int id);
    public boolean editarUsuario(UsuarioDTO usuario);
    public boolean borrarUsuario(int id);
    public boolean crearUsuarioAdministrador(UsuarioDTO usuario);
    public boolean crearUsuarioAlumno(AlumnoDTO alumno);
}
