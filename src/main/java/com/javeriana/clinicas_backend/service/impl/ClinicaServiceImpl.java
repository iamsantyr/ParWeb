package com.javeriana.clinicas_backend.service.impl;

import com.javeriana.clinicas_backend.dto.ClinicaDto;
import com.javeriana.clinicas_backend.model.Clinica;
import com.javeriana.clinicas_backend.repository.ClinicaRepository;
import com.javeriana.clinicas_backend.service.ClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicaServiceImpl implements ClinicaService {

    private final ClinicaRepository clinicaRepository;
    private final ModelMapper modelMapper;

    public ClinicaServiceImpl(ClinicaRepository clinicaRepository, ModelMapper modelMapper) {
        this.clinicaRepository = clinicaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClinicaDto> listarTodas() {
        return clinicaRepository.findAll()
                .stream()
                .map(clinica -> modelMapper.map(clinica, ClinicaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClinicaDto buscarPorId(Long id) {
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica no encontrada"));
        return modelMapper.map(clinica, ClinicaDto.class);
    }

    @Override
    public ClinicaDto crear(ClinicaDto clinicaDto) {
        Clinica clinica = modelMapper.map(clinicaDto, Clinica.class);
        Clinica guardada = clinicaRepository.save(clinica);
        return modelMapper.map(guardada, ClinicaDto.class);
    }

    @Override
    public ClinicaDto actualizar(Long id, ClinicaDto clinicaDto) {
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica no encontrada"));

        clinica.setNombre(clinicaDto.getNombre());
        clinica.setDireccion(clinicaDto.getDireccion());
        clinica.setTelefono(clinicaDto.getTelefono());
        clinica.setCiudad(clinicaDto.getCiudad());

        Clinica actualizada = clinicaRepository.save(clinica);
        return modelMapper.map(actualizada, ClinicaDto.class);
    }

    @Override
    public void eliminar(Long id) {
        clinicaRepository.deleteById(id);
    }
}
