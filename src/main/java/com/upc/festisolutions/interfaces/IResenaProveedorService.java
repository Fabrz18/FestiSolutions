package com.upc.festisolutions.interfaces;
import com.upc.festisolutions.dto.ResenaEventoDTO;
import com.upc.festisolutions.dto.ResenaProveedorDTO;
import java.util.List;

public interface IResenaProveedorService {
    public ResenaProveedorDTO registrarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO);
    public ResenaProveedorDTO actualizarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO);
    public void eliminarResenaProveedor(Integer idResenaProveedor);
    public List<ResenaProveedorDTO> listarResenaProveedor();
    public void calcularValoracionSegunProveedor (Integer idProveedor);
    public List<ResenaProveedorDTO> listarResenaProveedorSegunProveedor (Integer idProveedor);
    public List<ResenaProveedorDTO> listarResenaProveedorSegunAnfitrionYProveedor (Integer idAnfitrion, Integer idProveedor);
}
