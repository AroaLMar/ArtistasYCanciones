package com.example.persistencia.Services;

import com.example.persistencia.Entities.Artista;
import com.example.persistencia.Entities.Cancion;
import com.example.persistencia.Excepciones.ArtistaEncontrado;
import com.example.persistencia.Excepciones.ArtistaNoEncontrado;
import com.example.persistencia.Repositories.ArtistaRepository;
import com.example.persistencia.Repositories.CancionRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistaService {


    @Autowired
    ArtistaRepository artistaRepository;

    @Autowired
    private CancionRepository cancionRepository;


    public List<Artista> getAllArtistasYCanciones() throws ArtistaNoEncontrado {


        List<Artista> listaAyC = new ArrayList<>();
        List<Artista> listaArtistas = artistaRepository.findAll();
        if (listaArtistas.isEmpty()) throw new ArtistaNoEncontrado("No hay artistas en sistema");
        for (Artista artista : listaArtistas) {
            List<Cancion> listaCanciones = cancionRepository.findAllByCodArtista(artista.getCodartista());
            listaAyC.add(new Artista(artista.getCodartista(), artista.getNombre(), listaCanciones));
        }
        return listaAyC;

    }

    public void aniadirArtista(Artista codartista) throws ArtistaEncontrado {

         if(artistaRepository.existsByCodArtista(codartista)) {
          throw new ArtistaEncontrado("El artista ya existe");

          }else {

             artistaRepository.save(codartista);
         }

    }

}
