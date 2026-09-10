package com.upc.festisolutions.repository;

import com.upc.festisolutions.dto.DistritoDTO;
import com.upc.festisolutions.dto.EventoDTO;
import com.upc.festisolutions.dto.FiltradoEventoDTO;
import com.upc.festisolutions.dto.TipoEventoDTO;
import com.upc.festisolutions.entities.Distrito;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.entities.Tipoevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query("SELECT e FROM Evento e " +
            "WHERE e.distrito = :distrito " +
            "AND e.tipoevento = :tipoEvento " +
            "AND e.fechainicio >= :fechaInicio " +
            "AND e.fechafin <= :fechaFin " +
            "AND e.aforo >= :aforoMin " +
            "AND e.aforo <= :aforoMax " +
            "AND e.presupuesto >= :presupuestoMin " +
            "AND e.presupuesto <= :presupuestoMax " +
            "AND e.estado = 'Disponible'")
    List<Evento> listarPorFiltros(@Param("distrito") Distrito distrito,
                                     @Param("tipoEvento") Tipoevento tipoEvento,
                                     @Param("fechaInicio") LocalDate fechaInicio,
                                     @Param("fechaFin") LocalDate fechaFin,
                                     @Param("aforoMin") Integer aforoMin,
                                     @Param("aforoMax") Integer aforoMax,
                                     @Param("presupuestoMin") Double presupuestoMin,
                                     @Param("presupuestoMax") Double presupuestoMax);

    List<Evento> findAllByEstadoEquals(String disponible);

    List<Evento> findAllByProveedor_IdAndEstadoNot(Integer idProveedor, String eliminado);

    List<Evento> findByDistrito_IdAndAforoGreaterThanEqualAndFechainicioGreaterThanEqualAndEstado(Integer idDistrito, Integer aforo, LocalDate fechainicio, String disponible);
}
