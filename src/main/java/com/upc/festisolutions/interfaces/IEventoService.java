package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface IEventoService {
    public EventoDTO registrarEvento(EventoDTO eventoDTO);
    public void eliminarEvento(Integer id);
    public EventoDTO actualizarEvento(EventoDTO eventoDTO);
    public List<EventoDTO> listarEvento();
    public EventoDTO  buscarEventoPorId(Integer id);
    public List<EventoDTO> listarEventosAleatorios();
    public List<FiltradoEventoDTO> listarEventoFiltroAvanzado(Integer distritoId, Integer tipoEventoId, LocalDate fechaInicio, LocalDate fechaFin, Integer aforo, Double presupuesto);
    public List<EventoDTO> listarEventoFiltroBasico(Integer idDistrito, Integer aforo, LocalDate fechainicio);
}
