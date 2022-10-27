package com.example.persistencia.controller;



import com.example.persistencia.Excepciones.CancionEncontrada;
import com.example.persistencia.Excepciones.CancionNoEncontrada;
import com.example.persistencia.Services.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CancionController {

    @Autowired

    private CancionService cancionService;


    @PostMapping("/api/canciones")
    public ResponseEntity<String> aniadirCancion(@RequestBody CancionInput codcancion) {
        try {
            cancionService.aniadirCancion(codcancion);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (CancionEncontrada e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/api/canciones/{codcancion}")
    public ResponseEntity<String> marcarFavorito(@PathVariable String codcancion) {
        try {
            cancionService.marcarFavorito(codcancion);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (CancionNoEncontrada e) {
            return ResponseEntity.notFound().build();
        }
    }

}
