package com.alura.libroracle.service;

import com.alura.libroracle.dto.AutorDTO;
import com.alura.libroracle.dto.LibroDTO;
import com.alura.libroracle.model.Autor;
import com.alura.libroracle.model.Libro;
import com.alura.libroracle.repository.AutorRepository;
import com.alura.libroracle.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepository repository;

    public List<AutorDTO> obtenerTodosLosAutores() {
        return convierteDatos(repository.findAll());
    }

    public List<AutorDTO> convierteDatos(List<Autor> autor) {
        return autor.stream()
                .map(a -> new AutorDTO(
                        a.getId(),
                        a.getNombre(),
                        a.getNacimiento(),
                        a.getDeceso()
                ))
                .collect(Collectors.toList());
    }
}
