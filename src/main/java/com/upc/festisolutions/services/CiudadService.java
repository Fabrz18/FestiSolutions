package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.CiudadDTO;
import com.upc.festisolutions.entities.Ciudad;
import com.upc.festisolutions.interfaces.ICiudadService;
import com.upc.festisolutions.repository.CiudadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService implements ICiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CiudadDTO registrarCiudad(CiudadDTO ciudadDTO) {
        if (ciudadDTO.getId() == null) {
            Ciudad ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
            ciudadRepository.save(ciudad);
            return modelMapper.map(ciudad, CiudadDTO.class);
        }
        return null;
    }

    @Override
    public List<CiudadDTO> listarCiudad() {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        return ciudades.stream().map(ciudad -> modelMapper.map(ciudad, CiudadDTO.class)).toList();
    }

    @Override
    public void eliminarCiudad(Integer idCiudad) {
        ciudadRepository.deleteById(idCiudad);
    }

    @Override
    public CiudadDTO actualizarCiudad(CiudadDTO ciudadDTO) {
        if (ciudadDTO.getId() != null) {
            Ciudad ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
            ciudadRepository.save(ciudad);
            return modelMapper.map(ciudad, CiudadDTO.class);
        }
        return null;
    }
}
