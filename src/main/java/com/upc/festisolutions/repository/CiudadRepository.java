package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
}
