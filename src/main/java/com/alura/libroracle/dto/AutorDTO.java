package com.alura.libroracle.dto;

import com.alura.libroracle.model.Autor;
import com.alura.libroracle.model.Idioma;

import java.util.List;

public record AutorDTO(
        Long id,
        String nombre,
        int nacimiento,
        int deceso) {
}
