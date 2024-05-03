package com.alura.libroracle.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int nacimiento;
    private int deceso;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;
    public Autor() {
    }

    public Autor(Long id, String nombre, int nacimiento, int deceso) {
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.deceso = deceso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getDeceso() {
        return deceso;
    }

    public void setDeceso(int deceso) {
        this.deceso = deceso;
    }

// Getters and setters

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", deceso=" + deceso +
                '}';
    }
}
