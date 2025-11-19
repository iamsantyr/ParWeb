package com.javeriana.clinicas_backend.controller;

import com.javeriana.clinicas_backend.dto.ClinicaDto;
import com.javeriana.clinicas_backend.service.ClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinicas")
@CrossOrigin(origins = "http://localhost:4200") // para permitir el frontend Angular
public class ClinicaController {

    private final ClinicaService clinicaService;

    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    @GetMapping
    public ResponseEntity<List<ClinicaDto>> listar() {
        return ResponseEntity.ok(clinicaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicaDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(clinicaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClinicaDto> crear(@RequestBody ClinicaDto clinicaDto) {
        ClinicaDto creada = clinicaService.crear(clinicaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicaDto> actualizar(@PathVariable Long id,
                                                 @RequestBody ClinicaDto clinicaDto) {
        return ResponseEntity.ok(clinicaService.actualizar(id, clinicaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
