package com.bd2.api.web;

import com.bd2.api.dto.PartidoDTO;
import com.bd2.api.repositories.PartidoRepository;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partido")
class PartidoController {
    
    private final PartidoRepository partidoRepository;
    
    @Autowired //@Autowired sirve para inyectar automaticamente
    public PartidoController(final PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }
    
    @GetMapping(path = "/partidos")
    public @ResponseBody LinkedList<PartidoDTO> getPartidos() { //@ResponseBody serializa JSON en el body del response
        return partidoRepository.getPartidos();
    }
    
    @GetMapping(path = "/{id}")
    public @ResponseBody PartidoDTO getPartido(@PathVariable long id) { //@PathVariable es para sacar el id de la url pasada como parametro
        return partidoRepository.getPartido(id);
    }
}
