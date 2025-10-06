package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.GananciaEventoDTO;
import com.upc.festisolutions.entities.Gananciaevento;
import com.upc.festisolutions.interfaces.IGananciaEventoService;
import com.upc.festisolutions.repository.GananciaEventoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GananciaEventoService implements IGananciaEventoService {
    @Autowired
    private GananciaEventoRepository gananciaEventoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public GananciaEventoDTO registrarGananciaEvento(GananciaEventoDTO gananciaEventoDTO) {
        if (gananciaEventoDTO.getId() == null) {
            Gananciaevento gananciaevento = modelMapper.map(gananciaEventoDTO, Gananciaevento.class);
            gananciaevento.setGanancia(gananciaevento.getEvento().getPresupuesto());
            gananciaEventoRepository.save(gananciaevento);
        }
        return null;
    }
}
