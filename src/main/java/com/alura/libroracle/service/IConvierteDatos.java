package com.alura.libroracle.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
