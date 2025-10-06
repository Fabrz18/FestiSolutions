package com.upc.festisolutions.repository;

import com.upc.festisolutions.dto.HistorialContratoDTO;
import com.upc.festisolutions.dto.HistorialEventoDTO;
import com.upc.festisolutions.entities.Contratoevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratoEventoRepository extends JpaRepository<Contratoevento, Integer> {

    String estado(String estado);

    @Query("SELECT new com.upc.festisolutions.dto.HistorialEventoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.evento.fechainicio, c.fechafinalizacion, c.evento.valoracion,c.estado) " +
            "from Contratoevento c WHERE c.anfitrion.id = :idAnfitrion and c.estado = 'Finalizado' order by c.fechacontrato ASC")
    List<HistorialEventoDTO> historialEventosPrimerFiltro(@Param(value = "idAnfitrion") Integer idAnfitrion);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialEventoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.evento.fechainicio, c.fechafinalizacion, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' ORDER BY c.fechacontrato DESC")
    List<HistorialEventoDTO> historialEventosSegundoFiltro(@Param(value = "idAnfitrion") Integer idAnfitrion);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialEventoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.evento.fechainicio, c.fechafinalizacion, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' ORDER BY c.evento.presupuesto DESC")
    List<HistorialEventoDTO> historialEventosTercerFiltro(@Param(value = "idAnfitrion") Integer idAnfitrion);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialEventoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.evento.fechainicio, c.fechafinalizacion, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' ORDER BY c.evento.presupuesto ASC")
    List<HistorialEventoDTO> historialEventosCuartoFiltro(@Param(value = "idAnfitrion") Integer idAnfitrion);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialEventoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.evento.fechainicio, c.fechafinalizacion, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' ORDER BY c.evento.valoracion DESC")
    List<HistorialEventoDTO> historialEventosQuintoFiltro(@Param(value = "idAnfitrion") Integer idAnfitrion);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialEventoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.evento.fechainicio, c.fechafinalizacion, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.anfitrion.id = :idAnfitrion AND c.estado = 'Finalizado' ORDER BY c.evento.valoracion ASC")
    List<HistorialEventoDTO> historialEventosSextoFiltro(@Param(value = "idAnfitrion") Integer idAnfitrion);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialContratoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.evento.fechainicio, c.fechafinalizacion, c.anfitrion.nombre, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' ORDER BY c.evento.fechainicio ASC")
    List<HistorialContratoDTO> historialContratosPrimerFiltro(@Param(value = "idProveedor") Integer idProveedor);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialContratoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.fechacontrato, c.fechafinalizacion, c.anfitrion.nombre, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' ORDER BY c.evento.fechainicio DESC")
    List<HistorialContratoDTO> historialContratosSegundoFiltro(@Param(value = "idProveedor") Integer idProveedor);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialContratoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.fechacontrato, c.fechafinalizacion, c.anfitrion.nombre, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' ORDER BY c.evento.presupuesto DESC")
    List<HistorialContratoDTO> historialContratosTercerFiltro(@Param(value = "idProveedor") Integer idProveedor);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialContratoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.fechacontrato, c.fechafinalizacion, c.anfitrion.nombre, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' ORDER BY c.evento.presupuesto ASC")
    List<HistorialContratoDTO> historialContratosCuartoFiltro(@Param(value = "idProveedor") Integer idProveedor);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialContratoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.fechacontrato, c.fechafinalizacion, c.anfitrion.nombre, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' ORDER BY c.evento.valoracion DESC")
    List<HistorialContratoDTO> historialContratosQuintoFiltro(@Param(value = "idProveedor") Integer idProveedor);
    @Query("SELECT new com.upc.festisolutions.dto.HistorialContratoDTO(c.id, c.evento.titulo, c.evento.tipoevento.nombre, c.evento.descripcion, c.evento.presupuesto, c.evento.aforo, c.fechacontrato, c.fechafinalizacion, c.anfitrion.nombre, c.evento.valoracion, c.estado) " +
            "FROM Contratoevento c WHERE c.evento.proveedor.id = :idProveedor AND c.estado = 'Finalizado' ORDER BY c.evento.valoracion ASC")
    List<HistorialContratoDTO> historialContratosSextoFiltro(@Param(value = "idProveedor") Integer idProveedor);

    List<Contratoevento> findAllByAnfitrion_IdAndEstado(Integer idAnfitrion, String enCurso);
    @Query("SELECT c from Contratoevento c where c.evento.proveedor.id = :idAnfitrion AND c.estado = 'En curso'")
    List<Contratoevento> contratosActuales(Integer idAnfitrion, String enCurso);
}
