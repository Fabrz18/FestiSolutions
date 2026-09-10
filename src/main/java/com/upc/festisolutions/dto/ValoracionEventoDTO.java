package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ValoracionEventoDTO {
    private Integer id;
    @NotNull(message = "El campo anfitrion no puede ser nulo.")
    private Anfitrion anfitrion;
    @NotNull(message = "El campo evento no puede ser nulo.")
    private Evento evento;
    private Boolean favorito = false;
}
