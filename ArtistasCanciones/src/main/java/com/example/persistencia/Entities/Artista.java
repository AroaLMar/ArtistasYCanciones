package com.example.persistencia.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name="artistas")
public class Artista {

        //ATRIBUTOS

        @Id
        private String codartista;
        @NotBlank(message="El nombre esta vacio")
        @NotNull(message = "El nombre es nulo")
        private String nombre;
        private List<Cancion> canciones;


        //CONSTRUCTOR
        public Artista() {
        }

        public Artista(String codartista, String nombre) {
                this.codartista = codartista;
                this.nombre = nombre;
        }

        public Artista(String codartista, String nombre, List<Cancion> canciones) {
                this.codartista = codartista;
                this.nombre = nombre;
                this.canciones = canciones;
        }

        //GETTERS Y SETTERS

        public String getCodartista() {
                return codartista;
        }

        public void setCodartista(String codartista) {
                this.codartista = codartista;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public List<Cancion> getCanciones() {
                return canciones;
        }

        public void setCanciones(List<Cancion> canciones) {
                this.canciones = canciones;
        }

        //TOSTRING
        @Override
        public String toString() {
                return "Artista{" +
                        "codartista='" + codartista + '\'' +
                        ", nombre='" + nombre + '\'' +
                        '}';
        }


}
