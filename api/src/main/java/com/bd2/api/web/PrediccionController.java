package com.bd2.api.web;

import com.bd2.api.dto.HacerPrediccionDTO;
import com.bd2.api.dto.PrediccionDTO;
import com.bd2.api.repositories.IPrediccionRepository;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prediccion")
public class PrediccionController {
    
    private final IPrediccionRepository prediccionRepository;
    
    @Autowired
    public PrediccionController(IPrediccionRepository prediccionRepository) {
        this.prediccionRepository = prediccionRepository;
    }
    
    @GetMapping(path = "/{nombreUsuario}")
    public @ResponseBody LinkedList<PrediccionDTO> getPredicciones(@PathVariable String nombreUsuario) {
        return prediccionRepository.getPredicciones(nombreUsuario);
    }
    
    @PostMapping(path = "/crear")
    public boolean hacerPrediccion(@RequestBody HacerPrediccionDTO hacerPrediccion) {
        return prediccionRepository.hacerPrediccion(hacerPrediccion);
    }
}
