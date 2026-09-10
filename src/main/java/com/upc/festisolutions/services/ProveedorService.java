package com.upc.festisolutions.services;


import com.upc.festisolutions.dto.ProveedorDTO;
import com.upc.festisolutions.dto.ResenaProveedorDTO;
import com.upc.festisolutions.entities.Proveedor;
import com.upc.festisolutions.interfaces.IProveedorService;
import com.upc.festisolutions.repository.ProveedorRepository;
import com.upc.festisolutions.repository.ResenaProveedorRepository;
import com.upc.festisolutions.security.entities.Role;
import com.upc.festisolutions.security.entities.User;
import com.upc.festisolutions.security.repository.RoleRepository;
import com.upc.festisolutions.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ResenaProveedorService resenaProveedorService;

    @Override
    public ProveedorDTO registrarProveedor(ProveedorDTO proveedorDTO){
        if (proveedorDTO.getId() == null){
            User user = new User();
            user.setUsername(proveedorDTO.getEmail());
            user.setPassword(passwordEncoder.encode(proveedorDTO.getContrasena()));
            Role role = roleRepository.findById(2)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            user.getRoles().add(role);
            userRepository.save(user);
            Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
            proveedor.setEstado(true);
            proveedor.setValoracion(0.0);
            Role rol = new Role();
            rol.setId(2L);
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
            rol.setId(2L);
            rol.setName("ROLE_PROVEEDOR");
            if (proveedor.getDescripcion() == null) {
                proveedor.setDescripcion("");
            }
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

    @Override
    public ProveedorDTO buscarProveedorPorCorreo(String correo) {
        Proveedor proveedor = proveedorRepository.findByEmailAndEstadoTrue(correo);
        return modelMapper.map(proveedor, ProveedorDTO.class);
    }

    @Override
    public Integer calcularCantidadResenasPorProveedor(Integer id) {
        List<ResenaProveedorDTO> resenas = resenaProveedorService.listarResenaProveedorSegunProveedor(id);
        return resenas.size();
    }
}
