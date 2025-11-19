package com.javeriana.clinicas_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicaDto {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
}
