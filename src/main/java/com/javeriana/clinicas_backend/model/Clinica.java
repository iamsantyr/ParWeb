package com.javeriana.clinicas_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clinicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;               // identificador (PK)

    @Column(nullable = false)
    private String nombre;

    private String direccion;

    @Column(name = "cantidad_camas")
    private Integer cantidadCamas;

    private String telefono;

    private String ciudad;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    // Relación 1 (Clínica)  -> N (Doctores)
    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> doctores = new ArrayList<>();
}
