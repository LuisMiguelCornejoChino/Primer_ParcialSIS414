package com.ejemplo.entrenadores.repository;

import com.ejemplo.entrenadores.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}
