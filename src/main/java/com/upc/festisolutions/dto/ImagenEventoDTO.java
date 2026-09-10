package com.upc.festisolutions.dto;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "Imagen_evento")
public class ImagenEventoDTO {
    private Integer id;
    private byte[] imagen;
    private EventoDTO evento;
}
