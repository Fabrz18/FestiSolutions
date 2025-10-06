package com.upc.festisolutions.repository;

import com.upc.festisolutions.dto.FiltradoEventoDTO;
import com.upc.festisolutions.entities.Distrito;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.entities.Tipoevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query("select new com.upc.festisolutions.dto.FiltradoEventoDTO(e.distrito, e.tipoevento, e.fechainicio, e.fechafin, e.aforo, e.presupuesto) from Evento e " +
            "WHERE e.distrito = :distrito AND e.tipoevento = :tipoEvento AND e.fechainicio >= :fechaInicio AND e.fechafin <= :fechaFin " +
            "AND e.aforo >= :aforo AND e.presupuesto <= :presupuesto AND e.estado = 'Disponible'")
    List<FiltradoEventoDTO> listarPorFiltros(@Param(value = "distrito") Distrito distrito,
                                             @Param(value = "tipoEvento") Tipoevento tipoEvento,
                                             @Param(value = "fechaInicio") LocalDate fechaInicio,
                                             @Param(value = "fechaFin") LocalDate fechaFin,
                                             @Param(value = "aforo") Integer aforo,
                                             @Param(value = "presupuesto") Double presupuesto);

    List<Evento> findByDistrito_IdAndAforoGreaterThanEqualAndFechainicioGreaterThanEqualAndEstado(Integer idDistrito, Integer aforo, LocalDate fechainicio, String disponible);

    List<Evento> findAllByEstadoEquals(String disponible);
}
