package com.bd2.api.repositories;

import com.bd2.api.dto.PartidoDTO;
import java.util.LinkedList;

public interface IPartidoRepository {
    
    public LinkedList<PartidoDTO> getPartidos();
    public PartidoDTO getPartido(int id);
    public boolean editarPartido(PartidoDTO[] partidos);
    public boolean borrarPartido(int id);
    public boolean crearPartido(PartidoDTO partido);
}
