package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ReseñaEvento")
public class ResenaProveedorDTO {
    private Integer id;
    @NotNull(message = "El campo anfitrion no puede ser nulo.")
    private Anfitrion anfitrion;
    @NotNull(message = "El campo proveedor no puede ser nulo.")
    private Proveedor proveedor;
    @NotBlank(message = "La descripción de su reseña no puede ser nulo.")
    private String descripcion;
    private Double valoracion;
}
