package com.example.persistencia.controller;

import com.example.persistencia.Entities.Cancion;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CancionInput {

    //ATRIBUTOS

    @NotBlank(message="El codigo de cancion esta vacio")
    @NotNull(message = "El codigo de cancion es nulo")
    private String codcancion;
    @NotBlank(message="El titulo esta vacio")
    @NotNull(message = "El titulo es nulo")
    private String titulo;
    private boolean favorito;
    private String codartista;

    //CONSTRUCTOR

    public CancionInput() {
    }

    public CancionInput(String codcancion, String titulo, boolean favorito, String codartista) {
        this.codcancion = codcancion;
        this.titulo = titulo;
        this.favorito = favorito;
        this.codartista = codartista;
    }

    public Cancion toDomain(){


        return new Cancion(this.codcancion,this.titulo,this.favorito,this.codartista);


    }

    //GETTERS Y SETTERS

    public String getCodcancion() {
        return codcancion;
    }

    public void setCodcancion(String codcancion) {
        this.codcancion = codcancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getCodartista() {
        return codartista;
    }

    public void setCodartista(String codartista) {
        this.codartista = codartista;
    }


}
