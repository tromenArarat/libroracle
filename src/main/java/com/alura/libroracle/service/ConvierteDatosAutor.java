package com.alura.libroracle.service;

import com.alura.libroracle.model.Autor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ConvierteDatosAutor implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // Parse JSON string to JsonNode
            JsonNode rootNode = objectMapper.readTree(json);

            // Get the results array
            JsonNode resultsArray = rootNode.get("results");

            // If results array is not null and has at least one element
            if (resultsArray != null && resultsArray.size() > 0) {
                // Get the first object in the results array
                JsonNode firstResult = resultsArray.get(0).get("authors").get(0);

                // Convert the first result to the specified class
                return objectMapper.treeToValue(firstResult, clase);
            } else {
                // Handle case where no results were found
                throw new RuntimeException("No se encontraron resultados en el JSON.");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obtenerDatosArray(String json, Class<T> clase) {
        try {
            // Parse JSON string to JsonNode
            JsonNode rootNode = objectMapper.readTree(json);

            // Get the results array
            JsonNode resultsArray = rootNode.get("results");
            // If results array is not null and has at least one element
            if (resultsArray != null && resultsArray.size() > 0) {
                // Convert results array to a list of objects
                List<T> resultList = new ArrayList<>();
                for (int i = 0; i < resultsArray.size(); i++) {
                    JsonNode firstResult = resultsArray.get(0).get("authors").get(0);
                    T result = objectMapper.treeToValue(firstResult, clase);
                    resultList.add(result);
                }
                return resultList;
            } else {
                // Handle case where no results were found
                throw new RuntimeException("No se encontraron resultados en el JSON.");

            }
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
