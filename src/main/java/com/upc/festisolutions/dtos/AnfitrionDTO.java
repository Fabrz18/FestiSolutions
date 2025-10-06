package com.upc.festisolutions.dtos;

import com.upc.festisolutions.security.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @Min(value = 10000000, message = "El DNI debe tener un valor mínimo de 10000000")
    @Max(value = 99999999, message = "El DNI debe tener un valor máximo de 10000000")
    private String dni;
    @NotBlank(message = "El Email no puede ser nulo.")
    @Email(message = "El email debe tener el formato de Email.")
    private String email;
    @NotBlank(message = "El telefono no puede ser nulo.")
    private String telefono;
    @NotBlank(message = "La contraseña no puede ser nula.")
    private String contrasena;
    private String foto;
    private Boolean estado;
    private Role role;
}
