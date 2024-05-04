package com.alura.libroracle.dto;

import com.alura.libroracle.model.Autor;

public record LibroDTO(
        Long Id,
        String titulo,
        Autor autor,
        String idioma,
        Double descargas

) {
}
