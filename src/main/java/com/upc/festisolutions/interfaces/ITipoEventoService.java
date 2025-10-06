package com.upc.festisolutions.interfaces;


import com.upc.festisolutions.dto.TipoEventoDTO;

import java.util.List;

public interface ITipoEventoService  {
    public TipoEventoDTO registrarTipoEvento(TipoEventoDTO tipoevento);
    public TipoEventoDTO actualizarTipoEvento(TipoEventoDTO tipoevento);
    public void eliminarTipoEvento(Integer id);
    public List<TipoEventoDTO> listarTipoEvento();
}