package com.example.persistencia.controller;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CancionOutput {

    //ATRIBUTOS


    @NotBlank(message="El codigo de cancion esta vacio")
    @NotNull(message = "El codigo de cancion es nulo")
    private String codcancion;
    @NotBlank(message="El titulo esta vacio")
    @NotNull(message = "El titulo es nulo")
    private String titulo;
    private boolean favorito;



    //CONSTRUCTOR

    public CancionOutput() {
    }

    public CancionOutput(String codcancion, String titulo,boolean favorito) {
        this.codcancion = codcancion;
        this.titulo = titulo;
        this.favorito=favorito;

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
}
