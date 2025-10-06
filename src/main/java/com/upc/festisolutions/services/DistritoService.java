package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.DistritoDTO;
import com.upc.festisolutions.entities.Distrito;
import com.upc.festisolutions.interfaces.IDistritoService;
import com.upc.festisolutions.repository.DistritoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService implements IDistritoService {
    @Autowired
    private DistritoRepository distritoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DistritoDTO registrarDistrito(DistritoDTO distritoDTO) {
        if (distritoDTO.getId() == null) {
            Distrito distrito = modelMapper.map(distritoDTO, Distrito.class);
            distritoRepository.save(distrito);
            return modelMapper.map(distrito, DistritoDTO.class);
        }
        return null;
    }

    @Override
    public List<DistritoDTO> listarDistritos() {
        List<Distrito> distritos = distritoRepository.findAll();
        return distritos.stream().map(distrito -> modelMapper.map(distrito, DistritoDTO.class)).toList();
    }

    @Override
    public void eliminarDistrito(Integer idDistrito) {
        distritoRepository.deleteById(idDistrito);
    }

    @Override
    public DistritoDTO actualizarDistrito(DistritoDTO distritoDTO) {
        if (distritoDTO.getId() != null) {
            Distrito distrito = modelMapper.map(distritoDTO, Distrito.class);
            distritoRepository.save(distrito);
            return modelMapper.map(distrito, DistritoDTO.class);
        }
        return null;
    }
}
