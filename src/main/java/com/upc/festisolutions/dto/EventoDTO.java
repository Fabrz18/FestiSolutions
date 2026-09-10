package com.upc.festisolutions.dto;


import com.upc.festisolutions.entities.Distrito;
import com.upc.festisolutions.entities.Proveedor;
import com.upc.festisolutions.entities.Tipoevento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "evento")
public class EventoDTO {
    private Integer id;
    @NotBlank(message = "El titulo no puede ser nulo.")
    private String titulo;
    @NotBlank(message = "La descripción no puede ser nulo.")
    private String descripcion;
    @NotNull(message = "El campo proveedor no puede ser nulo.")
    private Proveedor proveedor;
    @NotNull(message = "El campo tipoevento no puede ser nulo.")
    private Tipoevento tipoevento;
    @NotNull(message = "La fecha de inicio no puede ser nula.")
    //@Future(message = "La fecha de inicio debe ser posterior a ahora.")
    private LocalDate fechainicio;
    @NotNull(message = "La fecha fin no puede ser nula.")
    private LocalDate fechafin;
    @NotNull(message = "El presupuesto no puede ser nulo.")
    private Double presupuesto;
    private String estado;
    private Double valoracion = 0.0;
    @NotNull(message = "El aforo no puede ser nulo.")
    private Integer aforo;
    @NotNull(message = "El campo distrito no puede ser nulo.")
    private Distrito distrito;
}
