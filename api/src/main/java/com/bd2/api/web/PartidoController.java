package com.bd2.api.web;

import com.bd2.api.dto.PartidoDTO;
import com.bd2.api.repositories.IPartidoRepository;
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
@RequestMapping("/partido")
class PartidoController {
    
    private final IPartidoRepository partidoRepository;
    
    @Autowired //@Autowired sirve para inyectar automaticamente
    public PartidoController(final IPartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }
    
    @GetMapping(path = "/partidos")
    public @ResponseBody LinkedList<PartidoDTO> getPartidos() { //@ResponseBody serializa JSON en el body del response
        return partidoRepository.getPartidos();
    }
    
    @GetMapping(path = "/{id}")
    public @ResponseBody PartidoDTO getPartido(@PathVariable int id) { //@PathVariable es para sacar el id de la url pasada como parametro
        return partidoRepository.getPartido(id);
    }
    
    @PutMapping(path = "/editar")
    public boolean editarPartido(@RequestBody PartidoDTO partido) { //@RequestBody arma un PartidoDTO con los datos del body
        return partidoRepository.editarPartido(partido);
    }
    
    @PutMapping(path = "/eliminar/{id}")
    public boolean borrarPartido(@PathVariable int id) {
        return partidoRepository.borrarPartido(id);
    }
    
    @PostMapping(path = "/crear")
    public boolean crearPartido(@RequestBody PartidoDTO partido) {
        return partidoRepository.crearPartido(partido);
    }
}