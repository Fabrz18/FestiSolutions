package com.upc.festisolutions.dto;


import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter

@Getter
@Table (name = "ReseñaEvento")
public class ResenaEventoDTO {
    private Integer id;
    @NotNull(message = "El campo evento no puede ser nulo.")
    private Evento evento;
    @NotNull(message = "El campo anfitrion no puede ser nulo.")
    private Anfitrion anfitrion;
    @NotBlank(message = "La observación de la reseña no puede ser nulo.")
    private String observacion;
    private Double valoracion;
}


