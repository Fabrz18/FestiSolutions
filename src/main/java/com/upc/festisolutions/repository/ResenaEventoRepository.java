package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Resenaevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResenaEventoRepository extends JpaRepository<Resenaevento, Integer> {
    @Query("SELECT AVG(r.valoracion) FROM Resenaevento r WHERE r.evento.id = :idEvento AND r.evento.estado != 'Eliminado'")
    Double calcularPromedioPorEvento(@Param(value = "idEvento") Integer idEvento);
    boolean existsByEventoIdAndAnfitrionId(Integer idEvento, Integer idAnfitrion);
    @Query("SELECT r from Resenaevento r where r.evento.id = :idEvento and r.evento.estado != 'Eliminado'")
    List<Resenaevento> encontrarResenas(@Param("idEvento") Integer idEvento);
}
