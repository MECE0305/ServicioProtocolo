package com.samasat.protocolo.repository;

import com.samasat.protocolo.model.Protocolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {
}