package com.upc.festisolutions.dtos;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ValoracionEventoDTO {
    private Integer id;
    private Anfitrion anfitrion;
    private Evento evento;
    private Boolean favorito = false;
}
