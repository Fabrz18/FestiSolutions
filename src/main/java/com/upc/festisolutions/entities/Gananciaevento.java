package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "gananciaevento")
public class Gananciaevento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgananciaevento", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "ganancia", nullable = false)
    private Double ganancia;

    @NotNull
    @Column(name = "fechaobtencion", nullable = false)
    private LocalDate fechaobtencion;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idevento", nullable = false)
    private Evento evento;

}