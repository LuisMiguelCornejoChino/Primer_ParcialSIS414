package com.ejemplo.entrenadores.controller;

import com.ejemplo.entrenadores.model.Entrenador;
import com.ejemplo.entrenadores.repository.EntrenadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    private final EntrenadorRepository repository;

    public EntrenadorController(EntrenadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Entrenador> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador guardar(@RequestBody Entrenador entrenador) {
        return repository.save(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizar(
            @PathVariable Long id,
            @RequestBody Entrenador datos) {

        return repository.findById(id)
                .map(entrenador -> {
                    entrenador.setNombre(datos.getNombre());
                    entrenador.setEspecialidad(datos.getEspecialidad());
                    entrenador.setExperiencia(datos.getExperiencia());
                    entrenador.setTelefono(datos.getTelefono());

                    Entrenador actualizado = repository.save(entrenador);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
