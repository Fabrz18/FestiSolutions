package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findAllByAnfitrion_IdAndEstado(Integer idAnfitrion, String abierto);

    List<Chat> findAllByProveedor_IdAndEstado(Integer idProveedor, String abierto);

    List<Chat> findAllByAnfitrion_IdAndProveedor_Id(Integer idAnfitrion, Integer idProveedor);
}
