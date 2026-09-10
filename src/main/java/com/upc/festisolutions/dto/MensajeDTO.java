package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Chat;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table (name = "Mensaje")
public class MensajeDTO {
    private Integer id;
    @NotBlank(message = "El contenido de un mensaje no puede ser nulo.")
    private String contenido;
    private LocalDateTime fechaenvio;
    @NotNull(message = "El campo chat no puede ser nulo.")
    private Chat chat;
    private Boolean esPropio;
}
