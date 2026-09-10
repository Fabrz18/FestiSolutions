package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.entities.Distrito;
import com.upc.festisolutions.entities.Tipoevento;
import jdk.jfr.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface IEventoService {
    public EventoDTO registrarEvento(EventoDTO eventoDTO);
    public void eliminarEvento(Integer id);
    public EventoDTO actualizarEvento(EventoDTO eventoDTO);
    public List<EventoDTO> listarEvento();
    public EventoDTO  buscarEventoPorId(Integer id);
    public List<EventoDTO> listarEventosAleatorios();
    public List<EventoDTO> listarEventoFiltroAvanzado(Integer distritoId, Integer tipoEventoId, LocalDate fechaInicio, LocalDate fechaFin, Integer aforoMin, Integer aforoMax, Double presupuestoMin, Double presupuestoMax);
    public List<EventoDTO> listarEventoFiltroBasico(Integer idDistrito, Integer aforo, LocalDate fechainicio);
    public List<EventoDTO> listarEventoPorProveedor(Integer idProveedor);
    public Integer calcularCantidadResenasPorEvento(Integer id);
}
