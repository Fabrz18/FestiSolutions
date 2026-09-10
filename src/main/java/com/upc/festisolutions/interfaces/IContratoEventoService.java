package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.entities.Contratoevento;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IContratoEventoService {
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorFechaMasAntigua(Integer idAnfitrion);
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorFechaMasReciente(Integer idAnfitrion);
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorMayorPresupuesto(Integer idAnfitrion);
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorMenorPresupuesto(Integer idAnfitrion);
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorMejorValoracion(Integer idAnfitrion);
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorPeorValoracion(Integer idAnfitrion);
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorFechaMasReciente(Integer idProveedor);
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorFechaMasAntigua(Integer idProveedor);
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorMayorPresupuesto(Integer idProveedor);
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorMenorPresupuesto(Integer idProveedor);
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorMejorValoracion(Integer idProveedor);
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorPeorValoracion(Integer idProveedor);
    public ContratoEventoDTO eventoContratado(ContratoEventoDTO contratoEventoDTO);
    public ContratoEventoDTO eventoFinalizado(ContratoEventoDTO contratoEventoDTO);
    public List<ContratoEventoDTO> verEventosContratados(Integer idAnfitrion);
    public List<ContratoEventoDTO> verContratosContrarados(Integer idProveedor);
}
