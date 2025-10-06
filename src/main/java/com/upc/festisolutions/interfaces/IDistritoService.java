package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.DistritoDTO;

import java.util.List;

public interface IDistritoService {
    public DistritoDTO registrarDistrito(DistritoDTO distritoDTO);
    public List<DistritoDTO> listarDistritos();
    public void eliminarDistrito(Integer idDistrito);
    public DistritoDTO actualizarDistrito(DistritoDTO distritoDTO);
}
