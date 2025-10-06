package com.upc.festisolutions.interfaces.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ReseñaEvento")
public class ResenaProveedorDTO {
    private Integer id;
    private Anfitrion anfitrion;
    private Proveedor proveedor;
    @NotBlank(message = "La descripción de su reseña no puede ser nulo.")
    private String descripcion;
    private Double valoracion;
}
