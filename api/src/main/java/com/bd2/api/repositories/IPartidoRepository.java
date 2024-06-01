package com.bd2.api.repositories;

import com.bd2.api.dto.PartidoDTO;
import java.util.LinkedList;

public interface IPartidoRepository {
    
    public LinkedList<PartidoDTO> getPartidos();
    public PartidoDTO getPartido(long id);
    public void updatePartido(PartidoDTO partido);
    public void deletePartido(long id);
    public void createPartido(PartidoDTO partido);
}
