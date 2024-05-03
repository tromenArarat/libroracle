package com.alura.libroracle.model;

public enum Idioma {
    ESPANOL("es","Español"),
    PORTUGUES("pr","Portugués"),
    ITALIANO("it","italiano"),
    INGLES("en","inglés"),
    FRANCES("fr","francés");

    private String idiomaGutendex;
    private String idiomaEspanol;

    Idioma (String idiomaGutendex, String idiomaEspanol){

        this.idiomaGutendex = idiomaGutendex;
        this.idiomaEspanol = idiomaEspanol;
    }

    public static Idioma fromString(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.idiomaGutendex.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningún idioma encontrado: "+text);
    }
    public static Idioma fromEspanol(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.idiomaEspanol.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna categoría encontrada: "+text);
    }

}
