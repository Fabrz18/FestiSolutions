package com.upc.festisolutions.security.repository;

import com.upc.festisolutions.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
