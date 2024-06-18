package com.bd2.api.repositories;

import com.bd2.api.dto.PartidoDTO;

public interface IActualizarPuntajesRepository {
    
    public boolean actualizarPuntajes(PartidoDTO[] partidos);
}
