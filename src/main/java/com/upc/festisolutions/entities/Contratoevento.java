package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "contratoevento")
public class Contratoevento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontratoevento", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idanfitrion", nullable = false)
    private Anfitrion anfitrion;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idevento", nullable = false)
    private Evento evento;

    @NotNull
    @Column(name = "fechacontrato", nullable = false)
    private LocalDate fechacontrato;

    @NotNull
    @Column(name = "fechafinalizacion", nullable = false)
    private LocalDate fechafinalizacion;

    @Size(max = 10)
    @NotNull
    @Column(name = "estado", nullable = false, length = 10)
    private String estado;

}