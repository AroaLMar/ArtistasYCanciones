package com.example.persistencia.controller;


import com.example.persistencia.Entities.Artista;
import com.example.persistencia.Excepciones.ArtistaEncontrado;
import com.example.persistencia.Excepciones.ArtistaNoEncontrado;
import com.example.persistencia.Repositories.ArtistaRepository;
import com.example.persistencia.Services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArtistaController {


    @Autowired

    private ArtistaService artistaService;


    @PostMapping("/api/artistas")
    public ResponseEntity<String> aniadirArtista(@Valid @RequestBody Artista codartista) {

        try {

            artistaService.aniadirArtista(codartista);
            return ResponseEntity.status(HttpStatus.CREATED).build();


        } catch (ArtistaEncontrado ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();

        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping("/api/artistas")

    public ResponseEntity<List<Artista>> getAllArtistasYCanciones() {
        try {
            List<Artista> listaArtistasYCanciones= artistaService.getAllArtistasYCanciones();
            return ResponseEntity.ok(listaArtistasYCanciones);
        } catch (ArtistaNoEncontrado e2) {
            e2.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

}
