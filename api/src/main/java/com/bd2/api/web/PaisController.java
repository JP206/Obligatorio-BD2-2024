package com.bd2.api.web;

import com.bd2.api.dto.PaisDTO;
import com.bd2.api.repositories.IPaisRepository;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
class PaisController {
    
    private final IPaisRepository paisRepository;
    
    @Autowired
    public PaisController(final IPaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }
    
    @GetMapping(path = "/paises")
    public @ResponseBody LinkedList<PaisDTO> getPaises() {
        return paisRepository.getPaises();
    }
    
    @GetMapping(path = "/{nombre}")
    public @ResponseBody PaisDTO getPais(@PathVariable String nombre) {
        return paisRepository.getPais(nombre);
    }
}