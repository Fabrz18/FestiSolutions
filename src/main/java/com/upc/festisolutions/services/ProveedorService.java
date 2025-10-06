package com.upc.festisolutions.services;


import com.upc.festisolutions.dto.ProveedorDTO;
import com.upc.festisolutions.entities.Proveedor;
import com.upc.festisolutions.interfaces.IProveedorService;
import com.upc.festisolutions.repository.ProveedorRepository;
import com.upc.festisolutions.security.entities.Role;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProveedorService implements IProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProveedorDTO registrarProveedor(ProveedorDTO proveedorDTO){
        if (proveedorDTO.getId() == null){
            Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
            proveedor.setEstado(true);
            Role rol = new Role();
            rol.setId(3L);
            rol.setName("ROLE_PROVEEDOR");
            proveedor.setRole(rol);
            proveedorRepository.save(proveedor);
            return modelMapper.map(proveedor, ProveedorDTO.class);
        }
        return null;
    }
    @Override
    public void eliminarProveedor(Integer id){
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if (proveedor != null){
            proveedor.setEstado(false);
            proveedorRepository.save(proveedor);
        }
    }
    @Override
    public ProveedorDTO actualizarProveedor(ProveedorDTO proveedorDTO){
        if (proveedorDTO.getId() != null){
            Proveedor proveedor = proveedorRepository.findById(proveedorDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
            Double ganancia = proveedor.getGanancia();
            Boolean estado = proveedor.getEstado();
            modelMapper.map(proveedorDTO, proveedor);
            proveedor.setGanancia(ganancia);
            proveedor.setEstado(estado);
            Role rol = new Role();
            rol.setId(3L);
            rol.setName("ROLE_PROVEEDOR");
            proveedorRepository.save(proveedor);
            return modelMapper.map(proveedor, ProveedorDTO.class);
        }
        return null;
    }
    @Override
    public List<ProveedorDTO> listarProveedor(){
        List<Proveedor> proveedores = proveedorRepository.findAllByEstadoEquals(true);
        return proveedores.stream().map(proveedor  -> modelMapper.map(proveedor, ProveedorDTO.class)).collect(Collectors.toList());
    }
    @Override
    public ProveedorDTO buscarProveedorPorId(Integer id){
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        return modelMapper.map(proveedor, ProveedorDTO.class);
    }
}
