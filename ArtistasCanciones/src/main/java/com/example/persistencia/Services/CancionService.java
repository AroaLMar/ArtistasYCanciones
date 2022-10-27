package com.example.persistencia.Services;

import com.example.persistencia.Entities.Cancion;
import com.example.persistencia.Excepciones.CancionEncontrada;
import com.example.persistencia.Excepciones.CancionNoEncontrada;
import com.example.persistencia.Repositories.ArtistaRepository;
import com.example.persistencia.Repositories.CancionRepository;
import com.example.persistencia.controller.CancionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Service
public class CancionService {

    @Autowired
    private ArtistaRepository artistaRepository;
    @Autowired
    private CancionRepository cancionRepository;


    public void aniadirCancion(CancionInput cancion) throws CancionEncontrada {
        if (cancionRepository.existsByCodCancion(cancion.getCodcancion())) throw new CancionEncontrada("La cancion ya existe");
        cancionRepository.save(new Cancion(cancion.getCodcancion(),cancion.getTitulo(),cancion.isFavorito(),cancion.getCodartista()));
    }


    public void marcarFavorito(@PathVariable String codcancion)  throws CancionNoEncontrada {

        if (cancionRepository.existsByCodCancion(codcancion)) {
            Optional<Cancion> cancionUpdate = cancionRepository.findByCodCancion(codcancion);
            if (cancionUpdate.get().isFavorito() == false) {
                cancionUpdate.get().setFavorito(true);
            }
            cancionRepository.save(cancionUpdate.get());
        }else{
            throw new CancionNoEncontrada("La cancion no existe.");
        }

    }
}
