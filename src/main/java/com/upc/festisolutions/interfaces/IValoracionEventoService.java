package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.ValoracionEventoDTO;

import java.util.List;

public interface IValoracionEventoService {
    public ValoracionEventoDTO agregarValoracionEvento(ValoracionEventoDTO valoracioneventoDTO);
    public void eliminarValoracionEvento(Integer id);
    public ValoracionEventoDTO actualizarValoracionEvento(ValoracionEventoDTO valoracioneventoDTO);
    public List<ValoracionEventoDTO> listarValoracionEvento();

}
