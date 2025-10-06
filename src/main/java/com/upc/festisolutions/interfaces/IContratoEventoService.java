package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.*;

import java.util.List;

public interface IContratoEventoService {
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorFechaMasAntigua(Integer idAnfitrion);
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorFechaMasReciente(Integer idAnfitrion);
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMayorPresupuesto(Integer idAnfitrion);
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMenorPresupuesto(Integer idAnfitrion);
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMejorValoracion(Integer idAnfitrion);
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorPeorValoracion(Integer idAnfitrion);
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorFechaMasReciente(Integer idProveedor);
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorFechaMasAntigua(Integer idProveedor);
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMayorPresupuesto(Integer idProveedor);
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMenorPresupuesto(Integer idProveedor);
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMejorValoracion(Integer idProveedor);
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorPeorValoracion(Integer idProveedor);
    public ContratoEventoDTO eventoContratado(ContratoEventoDTO contratoEventoDTO);
    public ContratoEventoDTO eventoFinalizado(ContratoEventoDTO contratoEventoDTO);
    public List<ContratoEventoDTO> verEventosContratados(Integer idAnfitrion);
    public List<ContratoEventoDTO> verContratosContrarados(Integer idProveedor);
}
