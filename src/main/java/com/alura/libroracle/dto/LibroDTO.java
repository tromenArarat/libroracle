package com.alura.libroracle.dto;

import com.alura.libroracle.model.Autor;
import com.alura.libroracle.model.Idioma;

public record LibroDTO(
        Long Id,
        String titulo,
        Autor autor,
        Idioma idioma,
        Double descargas

) {
}
