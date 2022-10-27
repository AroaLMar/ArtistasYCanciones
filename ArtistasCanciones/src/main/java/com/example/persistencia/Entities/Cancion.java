package com.example.persistencia.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name="canciones")
public class Cancion {

    //ATRIBUTOS


    @Id
    private String codcancion;
    @NotBlank(message="El titulo esta vacio")
    @NotNull(message = "El titulo es nulo")
    private String titulo;
    private boolean favorito;
    private String codartista;

    //CONSTRUCTOR

    public Cancion() {
    }

    public Cancion(String codcancion, String titulo, boolean favorito, String codartista) {
        this.codcancion = codcancion;
        this.titulo = titulo;
        this.favorito = favorito;
        this.codartista = codartista;
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


    //TOSTRING


    @Override
    public String toString() {
        return "Cancion{" +
                "codcancion='" + codcancion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", favorito=" + favorito +
                ", codartista='" + codartista + '\'' +
                '}';
    }



}
