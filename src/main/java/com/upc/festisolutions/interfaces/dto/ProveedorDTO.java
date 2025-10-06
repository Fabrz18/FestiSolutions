package com.upc.festisolutions.interfaces.dto;

import com.upc.festisolutions.entities.Especializacion;
import com.upc.festisolutions.security.entities.Role;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table (name = "proveedor")
public class ProveedorDTO {
    private Integer id;
    private Especializacion especializacion;
    @Email(message = "El email debe tener formato de Email.")
    @NotBlank(message = "El email no puede ser nulo.")
    private String email;
    @NotBlank(message = "El RUC no puede ser nulo.")
    private String ruc;
    @NotBlank(message = "El número de contacto no puede ser nulo.")
    private String numerocontacto;
    @NotBlank(message = "El nombre de la organización no puede ser nulo.")
    private String nombreorganizacion;
    @NotBlank(message = "La contraseña no puede ser nula.")
    private String contrasena;
    @NotBlank(message = "La dirección de su organización no puede ser nula.")
    private String direccion;
    private String foto;
    private Double ganancia = 0.0;
    private Boolean estado;
    private Role role;
}