package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.AnfitrionDTO;
import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.interfaces.IAnfitrionService;
import com.upc.festisolutions.repository.AnfitrionRepository;
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

@Service
@Transactional
public class AnfitrionService implements IAnfitrionService {
    @Autowired
    private AnfitrionRepository anfitrionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AnfitrionDTO registrarAnfitrion(AnfitrionDTO anfitrionDTO) {
        if (anfitrionDTO.getId() == null) {
            User user = new User();
            user.setUsername(anfitrionDTO.getEmail());
            user.setPassword(passwordEncoder.encode(anfitrionDTO.getContrasena()));
            Role role = roleRepository.findById(3)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            user.getRoles().add(role);
            userRepository.save(user);
            Anfitrion anfitrion = modelMapper.map(anfitrionDTO, Anfitrion.class);
            anfitrion.setEstado(true);
            Role rol = new Role();
            rol.setId(3L);
            rol.setName("ROLE_ANFITRION");
            anfitrion.setRole(rol);
            if (anfitrion.getDescripcion() == null) {
                anfitrion.setDescripcion("");
            }
            Anfitrion guardado = anfitrionRepository.save(anfitrion);
            return modelMapper.map(guardado, AnfitrionDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarAnfitrion(Integer id) {
        Anfitrion anfitrion = anfitrionRepository.findById(id).orElse(null);
        if (anfitrion != null){
            anfitrion.setEstado(false);
            anfitrionRepository.save(anfitrion);
        }
    }
    @Override
    public AnfitrionDTO actualizarAnfitrion(AnfitrionDTO anfitrionDTO){
        if (anfitrionDTO.getId() != null){
            Anfitrion anfitrion = modelMapper.map(anfitrionDTO, Anfitrion.class);
            anfitrion.setEstado(true);
            Role rol = new Role();
            rol.setId(3L);
            rol.setName("ROLE_ANFITRION");
            anfitrion.setRole(rol);
            anfitrionRepository.save(anfitrion);
            return modelMapper.map(anfitrion, AnfitrionDTO.class);
        }
        return null;
    }
    @Override
    public List<AnfitrionDTO> listarAnfitrion(){
        List<Anfitrion> anfitriones = anfitrionRepository.findByEstadoTrue();
        return anfitriones.stream().map(anfitrion  -> modelMapper.map(anfitrion, AnfitrionDTO.class)).toList();
    }
    @Override
    public AnfitrionDTO buscarAnfitrionPorId(Integer id){
        Anfitrion anfitrion = anfitrionRepository.findById(id).orElse(null);
        return modelMapper.map(anfitrion, AnfitrionDTO.class);
    }

    @Override
    public AnfitrionDTO buscarAnfitrionPorCorreo(String correo) {
        Anfitrion anfitrion = anfitrionRepository.findByEmailAndEstadoTrue(correo);
        return modelMapper.map(anfitrion, AnfitrionDTO.class);
    }
}
