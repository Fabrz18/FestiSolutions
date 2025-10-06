package com.upc.festisolutions.entities;

import com.upc.festisolutions.security.entities.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idespecializacion", nullable = false)
    private Especializacion especializacion;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 15)
    @NotNull
    @Column(name = "ruc", nullable = false, length = 15)
    private String ruc;

    @Size(max = 15)
    @NotNull
    @Column(name = "numerocontacto", nullable = false, length = 15)
    private String numerocontacto;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombreorganizacion", nullable = false, length = 100)
    private String nombreorganizacion;

    @Size(max = 100)
    @NotNull
    @Column(name = "contraseña", nullable = false, length = 100)
    private String contrasena;

    @Size(max = 100)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @NotNull
    @Column(name = "foto", nullable = false)
    private String foto;

    @Column(name = "ganancia")
    private Double ganancia;

    @Column(name = "estado")
    private Boolean estado;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}