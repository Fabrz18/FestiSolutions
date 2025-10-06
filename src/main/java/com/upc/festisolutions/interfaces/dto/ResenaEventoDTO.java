package com.upc.festisolutions.interfaces.dto;


import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter

@Getter
@Table (name = "ReseñaEvento")
public class ResenaEventoDTO {
    private Integer id;
    private Evento evento;
    private Anfitrion anfitrion;
    @NotBlank(message = "La observación de la reseña no puede ser nulo.")
    private String observacion;
    private Double valoracion;
}


