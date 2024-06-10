package com.bd2.api.repositories;

import com.bd2.api.dto.PaisDTO;
import java.util.LinkedList;

public interface IPaisRepository {
    
    public LinkedList<PaisDTO> getPaises();
    public PaisDTO getPais(String nombre);
}
