package com.upc.festisolutions.repository;

import com.upc.festisolutions.dto.GananciaProveedorDTO;
import com.upc.festisolutions.entities.Reporteproveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReporteProveedorRepository extends JpaRepository<Reporteproveedor, Integer> {
    @Query("select new com.upc.festisolutions.dto.GananciaProveedorDTO(YEAR(g.fechaobtencion), MONTH(g.fechaobtencion), SUM(g.ganancia)) " +
            "from Gananciaevento g WHERE g.evento.proveedor.id = :idProveedor AND g.fechaobtencion >= :fechaInicio GROUP BY " +
            "YEAR(g.fechaobtencion), MONTH(g.fechaobtencion) ORDER BY YEAR(g.fechaobtencion), MONTH(g.fechaobtencion)")
    List<GananciaProveedorDTO> obtenerGananciasPorMes(@Param(value="idProveedor") Integer idProveedor, @Param(value="fechaInicio") LocalDate fechaInicio);
}
