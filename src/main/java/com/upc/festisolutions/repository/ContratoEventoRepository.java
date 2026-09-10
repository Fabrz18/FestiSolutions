package com.upc.festisolutions.repository;

import com.upc.festisolutions.dto.HistorialContratoDTO;
import com.upc.festisolutions.dto.HistorialEventoDTO;
import com.upc.festisolutions.entities.Contratoevento;
import com.upc.festisolutions.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratoEventoRepository extends JpaRepository<Contratoevento, Integer> {

    String estado(String estado);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' " +
            "ORDER BY c.fechacontrato ASC")
    List<Contratoevento> historialEventosPrimerFiltro(@Param("idAnfitrion") Integer idAnfitrion);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' " +
            "ORDER BY c.fechacontrato DESC")
    List<Contratoevento> historialEventosSegundoFiltro(@Param("idAnfitrion") Integer idAnfitrion);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.presupuesto DESC")
    List<Contratoevento> historialEventosTercerFiltro(@Param("idAnfitrion") Integer idAnfitrion);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.presupuesto ASC")
    List<Contratoevento> historialEventosCuartoFiltro(@Param("idAnfitrion") Integer idAnfitrion);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.valoracion DESC")
    List<Contratoevento> historialEventosQuintoFiltro(@Param("idAnfitrion") Integer idAnfitrion);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.valoracion ASC")
    List<Contratoevento> historialEventosSextoFiltro(@Param("idAnfitrion") Integer idAnfitrion);


// PROVEEDOR

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.fechainicio ASC")
    List<Contratoevento> historialContratosPrimerFiltro(@Param("idProveedor") Integer idProveedor);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.fechainicio DESC")
    List<Contratoevento> historialContratosSegundoFiltro(@Param("idProveedor") Integer idProveedor);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.presupuesto DESC")
    List<Contratoevento> historialContratosTercerFiltro(@Param("idProveedor") Integer idProveedor);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.presupuesto ASC")
    List<Contratoevento> historialContratosCuartoFiltro(@Param("idProveedor") Integer idProveedor);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.valoracion DESC")
    List<Contratoevento> historialContratosQuintoFiltro(@Param("idProveedor") Integer idProveedor);

    @Query("SELECT c FROM Contratoevento c " +
            "WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' " +
            "ORDER BY c.evento.valoracion ASC")
    List<Contratoevento> historialContratosSextoFiltro(@Param("idProveedor") Integer idProveedor);

    List<Contratoevento> findAllByAnfitrion_IdAndEstado(Integer idAnfitrion, String enCurso);
    @Query("SELECT c from Contratoevento c where c.evento.proveedor.id = :idAnfitrion AND c.estado = 'En curso'")
    List<Contratoevento> contratosActuales(Integer idAnfitrion, String enCurso);
}
