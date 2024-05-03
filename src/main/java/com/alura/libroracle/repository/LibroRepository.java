package com.alura.libroracle.repository;

import com.alura.libroracle.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findByTituloContainingIgnoreCase(String nombreLibro);
}
