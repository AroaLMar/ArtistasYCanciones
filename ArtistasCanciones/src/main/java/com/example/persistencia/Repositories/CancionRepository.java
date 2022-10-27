package com.example.persistencia.Repositories;


import com.example.persistencia.Entities.Cancion;
import com.example.persistencia.controller.CancionOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, String> {


    boolean existsByCodCancion(String codcancion);

    Optional<Cancion> findByCodCancion(String codcancion);

    List<Cancion> findAllByCodArtista(String codartista);
}
