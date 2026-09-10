package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Valoracionevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ValoracionEventoRepository extends JpaRepository<Valoracionevento, Integer> {
    Valoracionevento findByAnfitrion_IdAndEvento_Id(Integer idAnfitrion, Integer idEvento);
    List<Valoracionevento> findAllByAnfitrion_IdAndFavoritoTrue(Integer idAnfitrion);
}
