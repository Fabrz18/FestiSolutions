package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.ResenaEventoDTO;

import java.util.List;

public interface IResenaEventoService {
    public ResenaEventoDTO registrarResenaEvento (ResenaEventoDTO resenaEventoDTO);
    public ResenaEventoDTO actualizarResenaEvento (ResenaEventoDTO resenaEventoDTO);
    public void eliminarResenaEvento (Integer idResenaEvento);
    public List<ResenaEventoDTO> listarResenaEvento();
    public void calcularValoracionSegunEvento (Integer idEvento);
    public List<ResenaEventoDTO> listarResenaEventoSegunEvento (Integer idEvento);
}
