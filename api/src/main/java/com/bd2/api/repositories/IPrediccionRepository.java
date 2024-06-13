package com.bd2.api.repositories;

import com.bd2.api.dto.HacerPrediccionDTO;
import com.bd2.api.dto.PrediccionDTO;
import java.util.LinkedList;

public interface IPrediccionRepository {
    
    public LinkedList<PrediccionDTO> getPredicciones(String nombreUsuario);
    public boolean hacerPrediccion(HacerPrediccionDTO hacerPrediccion);
}
