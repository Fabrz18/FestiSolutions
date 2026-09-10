package com.upc.festisolutions.dto;

import com.upc.festisolutions.security.entities.Role;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnfitrionDTO {
    private Integer id;
    @NotBlank(message = "El nombre no puede ser nulo.")
    private String nombre;
    @NotBlank(message = "El apellido no puede ser nulo.")
    private String apellido;
    @NotBlank(message = "El DNI no puede ser nulo.")
    private String dni;
    @NotBlank(message = "El Email no puede ser nulo.")
    @Email(message = "El email debe tener el formato de Email.")
    private String email;
    @NotBlank(message = "El telefono no puede ser nulo.")
    private String telefono;
    @NotBlank(message = "La contraseña no puede ser nula.")
    private String contrasena;
    private byte[] foto;
    private Boolean estado;
    private Role role;
    private String descripcion;
}
