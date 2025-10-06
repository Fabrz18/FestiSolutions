package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.GananciaProveedorDTO;
import com.upc.festisolutions.dto.ReporteProveedorDTO;

import java.util.List;

public interface IReporteProveedorService {
    public ReporteProveedorDTO registrarReporte(ReporteProveedorDTO reporteProveedorDTO);
    public void eliminarReporte(Integer id);
    public ReporteProveedorDTO actualizarReporte(ReporteProveedorDTO reporteProveedorDTO);
    public List<ReporteProveedorDTO> listarReporte();
    public List<GananciaProveedorDTO> reporteUltimoAnio(Integer idProveedor);
    public List<GananciaProveedorDTO> reporteUltimoMes(Integer idProveedor);
    public List<GananciaProveedorDTO> reporteUltimoTresMeses(Integer idProveedor);
    public List<GananciaProveedorDTO> reporteUltimoSeisMeses(Integer idProveedor);
}
