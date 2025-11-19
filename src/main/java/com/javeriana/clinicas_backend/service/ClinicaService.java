package com.javeriana.clinicas_backend.service;

import com.javeriana.clinicas_backend.dto.ClinicaDto;

import java.util.List;

public interface ClinicaService {

    List<ClinicaDto> listarTodas();

    ClinicaDto buscarPorId(Long id);

    ClinicaDto crear(ClinicaDto clinicaDto);

    ClinicaDto actualizar(Long id, ClinicaDto clinicaDto);

    void eliminar(Long id);
}
