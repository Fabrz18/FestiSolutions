package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Chat;
import com.upc.festisolutions.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    List<Mensaje> findByChat(Chat chat);
}
