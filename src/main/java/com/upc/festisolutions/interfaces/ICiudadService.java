package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.CiudadDTO;

import java.util.List;

public interface ICiudadService {
    public CiudadDTO registrarCiudad(CiudadDTO ciudadDTO);
    public List<CiudadDTO> listarCiudad();
    public void eliminarCiudad(Integer idCiudad);
    public CiudadDTO actualizarCiudad(CiudadDTO ciudadDTO);
}
