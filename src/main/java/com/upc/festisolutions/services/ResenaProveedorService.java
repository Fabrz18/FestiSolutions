package com.upc.festisolutions.services;
import com.upc.festisolutions.dto.ResenaEventoDTO;
import com.upc.festisolutions.dto.ResenaProveedorDTO;
import com.upc.festisolutions.entities.Proveedor;
import com.upc.festisolutions.entities.Resenaproveedor;
import com.upc.festisolutions.interfaces.IResenaProveedorService;
import com.upc.festisolutions.repository.ProveedorRepository;
import com.upc.festisolutions.repository.ResenaProveedorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ResenaProveedorService implements IResenaProveedorService {

    @Autowired
    private ResenaProveedorRepository resenaProveedorRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public ResenaProveedorDTO registrarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO) {
        Integer idProveedor = resenaProveedorDTO.getProveedor().getId();
        Integer idAnfitrion = resenaProveedorDTO.getAnfitrion().getId();
        Proveedor proveedor = proveedorRepository.findById(idProveedor)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + idProveedor));
        if (Boolean.FALSE.equals(proveedor.getEstado())) {
            throw new RuntimeException("No se puede registrar una reseña en un proveedor eliminado.");
        }
        if (resenaProveedorDTO.getId() == null) {
            if (resenaProveedorRepository.existsByProveedorIdAndAnfitrionId(idProveedor, idAnfitrion)) {
                throw new RuntimeException("El anfitrión ya ha realizado una reseña a este proveedor.");
            }
            Resenaproveedor resenaProveedor = modelMapper.map(resenaProveedorDTO, Resenaproveedor.class);
            resenaProveedorRepository.save(resenaProveedor);
            calcularValoracionSegunProveedor(resenaProveedor.getProveedor().getId());
            return modelMapper.map(resenaProveedor, ResenaProveedorDTO.class);
        }
        return null;
    }

    @Override
    public ResenaProveedorDTO actualizarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO) {
        if (resenaProveedorDTO.getId() != null) {
            Resenaproveedor resenaProveedor = resenaProveedorRepository.findById(resenaProveedorDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Reseña no encontrada con ID: " + resenaProveedorDTO.getId()));
            Proveedor proveedor = proveedorRepository.findById(resenaProveedor.getProveedor().getId())
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + resenaProveedor.getProveedor().getId()));
            if (Boolean.FALSE.equals(proveedor.getEstado())) {
                throw new RuntimeException("No se puede actualizar una reseña de un proveedor eliminado.");
            }
            resenaProveedor.setDescripcion(resenaProveedorDTO.getDescripcion());
            resenaProveedor.setValoracion(resenaProveedorDTO.getValoracion());
            resenaProveedorRepository.save(resenaProveedor);
            calcularValoracionSegunProveedor(resenaProveedor.getProveedor().getId());
            return modelMapper.map(resenaProveedor, ResenaProveedorDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarResenaProveedor(Integer idResenaProveedor) {
        Resenaproveedor resenaProveedor = resenaProveedorRepository.findById(idResenaProveedor)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con ID: " + idResenaProveedor));
        Proveedor proveedor = proveedorRepository.findById(resenaProveedor.getProveedor().getId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + resenaProveedor.getProveedor().getId()));
        if (Boolean.FALSE.equals(proveedor.getEstado())) {
            throw new RuntimeException("No se puede eliminar una reseña de un proveedor inactivo.");
        }
        Integer idProveedor = resenaProveedor.getProveedor().getId();
        resenaProveedorRepository.deleteById(idResenaProveedor);
        calcularValoracionSegunProveedor(idProveedor);
    }

    @Override
    public List<ResenaProveedorDTO> listarResenaProveedor() {
        List<Resenaproveedor> resenas = resenaProveedorRepository.findAll();
        return resenas.stream()
                .filter(resena -> resena.getProveedor() != null && Boolean.TRUE.equals(resena.getProveedor().getEstado()))
                .map(resena -> modelMapper.map(resena, ResenaProveedorDTO.class))
                .toList();
    }

    @Override
    public void calcularValoracionSegunProveedor(Integer idProveedor) {
        Double promedio = resenaProveedorRepository.calcularPromedioPorProveedor(idProveedor);
        Double valoracionFinal;
        if (promedio != null) {
            valoracionFinal = Math.round(promedio * 100.0) / 100.0;
        } else {
            valoracionFinal = 0.0;
        }
        Proveedor proveedor = proveedorRepository.findById(idProveedor)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + idProveedor));
        proveedor.setValoracion(valoracionFinal);
        proveedorRepository.save(proveedor);
    }

    @Override
    public List<ResenaProveedorDTO> listarResenaProveedorSegunProveedor(Integer idProveedor) {
        List<Resenaproveedor> resenas = resenaProveedorRepository.encontrarResenasPorProveedor(idProveedor);
        return resenas.stream()
                .map(resena -> modelMapper.map(resena, ResenaProveedorDTO.class))
                .toList();
    }

    @Override
    public List<ResenaProveedorDTO> listarResenaProveedorSegunAnfitrionYProveedor(Integer idAnfitrion, Integer idProveedor) {
        List<Resenaproveedor> resenas = resenaProveedorRepository.findAllByAnfitrion_IdAndProveedor_Id(idAnfitrion, idProveedor);
        return resenas.stream().map(resena -> modelMapper.map(resena, ResenaProveedorDTO.class)).toList();
    }
}
