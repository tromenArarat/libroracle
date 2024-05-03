package com.alura.libroracle.principal;

import com.alura.libroracle.model.Autor;
import com.alura.libroracle.model.DatosAutor;
import com.alura.libroracle.model.DatosLibro;
import com.alura.libroracle.model.Libro;
import com.alura.libroracle.repository.LibroRepository;
import com.alura.libroracle.service.ConsumoAPI;
import com.alura.libroracle.service.ConvierteDatos;
import com.alura.libroracle.service.ConvierteDatosAutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private ConvierteDatosAutor conversorAutor = new ConvierteDatosAutor();
    private final String URL_BASE = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);
    private LibroRepository repositorio;

    private Optional<Libro> libroBuscado;


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elija la tarea a través de su número:
                    1- buscar libro por título 
                    2- listar libros registrados
                    3- listar autorxs registrados
                    4- listar autorxs vivos en un determinado año
                    5- listar libros por idioma                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
//                    buscarLibroPorTitulo();
                    break;
                case 2:
//                    buscarLibrosRegistrados();
                    break;
                case 3:
//                    mostrarAutorxsRegistradxs();
                    break;
                case 4:
//                    mostrarAutorxsVivxsEnUnDeterminadoAno();
                    break;
                case 5:
//                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }
    private DatosLibro getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+ nombreLibro.replace(" ", "+"));
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }
    private DatosAutor getDatosAutor(String nombreLibro) {
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+ nombreLibro.replace(" ", "+"));
        DatosAutor datos = conversorAutor.obtenerDatos(json, DatosAutor.class);
        return datos;
    }

//    public void buscarLibroPorTitulo(){
//        DatosLibro datos = getDatosLibro();
//        if (datos != null) {
//            Libro libro = new Libro();
//            libro.setTitulo(datos.titulo());
//
////            DatosAutor datosAutor = getDatosAutor(datos.titulo());
////
////            Autor autor = new Autor();
////            autor.setNombre(datosAutor.nombre());
////            autor.setNacimiento(datosAutor.nacimiento());
////            autor.setDeceso(datosAutor.deceso());
////
////            libro.setAutor(autor);
//
//            libro.setAutor(datos.autor());
//
//            libro.setIdioma(datos.idioma());
//
//            libro.setDescargas(datos.descargas());
//
//            repositorio.save(libro);
//            System.out.println("Libro guardado exitosamente");
//        } else {
//            System.out.println("Libro no encontrado o título no especificado");
//        }
//
//    }


}
