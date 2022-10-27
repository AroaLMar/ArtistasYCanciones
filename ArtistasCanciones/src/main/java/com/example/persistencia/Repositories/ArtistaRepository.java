package com.example.persistencia.Repositories;

import com.example.persistencia.Entities.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, String> {


    boolean existsByCodArtista(Artista codartista);
}
