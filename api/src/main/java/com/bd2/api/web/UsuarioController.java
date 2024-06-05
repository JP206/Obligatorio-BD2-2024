package com.bd2.api.web;

import com.bd2.api.dto.AlumnoDTO;
import com.bd2.api.dto.UsuarioDTO;
import com.bd2.api.repositories.IUsuarioRepository;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
 
    private final IUsuarioRepository usuarioRepository;
    
    @Autowired
    public UsuarioController(final IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @GetMapping(path = "/usuarios")
    public @ResponseBody LinkedList<UsuarioDTO> getUsuarios() {
        return usuarioRepository.getUsuarios();
    }
    
    @GetMapping(path = "/{id}")
    public @ResponseBody UsuarioDTO getUsuario(@PathVariable int id) { //@PathVariable es para sacar el id de la url pasada como parametro
        return usuarioRepository.getUsuario(id);
    }
    
    @PutMapping(path = "/editar")
    public boolean editarUsuario(@RequestBody UsuarioDTO usuario) { //@RequestBody arma un PartidoDTO con los datos del body
        return usuarioRepository.editarUsuario(usuario);
    }
    
    @PutMapping(path = "/eliminar/{id}")
    public boolean borrarUsuario(@PathVariable int id) {
        return usuarioRepository.borrarUsuario(id);
    }
    
    @PostMapping(path = "/crearadmin")
    public boolean crearUsuarioAdministrador(@RequestBody UsuarioDTO usuario) {
        return usuarioRepository.crearUsuarioAdministrador(usuario);
    }
    
    @PostMapping(path = "/crearalumno")
    public boolean crearUsuarioAlumno(@RequestBody AlumnoDTO alumno) {
        return usuarioRepository.crearUsuarioAlumno(alumno);
    }
}
