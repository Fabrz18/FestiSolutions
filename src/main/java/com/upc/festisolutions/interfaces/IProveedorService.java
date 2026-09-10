package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.ProveedorDTO;

import java.util.List;

public interface IProveedorService {
    public ProveedorDTO registrarProveedor(ProveedorDTO proveedorDTO);
    public void eliminarProveedor(Integer id);
    public ProveedorDTO actualizarProveedor(ProveedorDTO proveedorDTO);
    public List<ProveedorDTO> listarProveedor();
    public ProveedorDTO buscarProveedorPorId(Integer id);
    public ProveedorDTO buscarProveedorPorCorreo(String correo);
    public Integer calcularCantidadResenasPorProveedor(Integer id);
}
