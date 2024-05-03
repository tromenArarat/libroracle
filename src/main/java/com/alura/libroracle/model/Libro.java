package com.alura.libroracle.model;

import jakarta.persistence.*;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Double descargas;

    public Libro() {
    }

    public Libro(Long id, String titulo, Autor autor, Idioma idioma, Double descargas) {
        id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.descargas = descargas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idiomas=" + idioma +
                ", descargas=" + descargas +
                '}';
    }
}
