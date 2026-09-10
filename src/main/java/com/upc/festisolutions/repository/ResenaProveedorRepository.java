package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Resenaproveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResenaProveedorRepository extends JpaRepository<Resenaproveedor, Integer> {

    boolean existsByProveedorIdAndAnfitrionId(Integer idProveedor, Integer idAnfitrion);

    @Query("SELECT r FROM Resenaproveedor r WHERE r.proveedor.id = :idProveedor AND r.proveedor.estado = true")
    List<Resenaproveedor> encontrarResenasPorProveedor(Integer idProveedor);

    @Query("SELECT AVG(r.valoracion) FROM Resenaproveedor r WHERE r.proveedor.id = :idProveedor AND r.proveedor.estado = true")
    Double calcularPromedioPorProveedor(@Param("idProveedor") Integer idProveedor);

    List<Resenaproveedor> findAllByAnfitrion_IdAndProveedor_Id(Integer idAnfitrion, Integer idProveedor);
}
