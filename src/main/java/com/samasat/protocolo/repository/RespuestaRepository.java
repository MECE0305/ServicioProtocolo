package com.samasat.protocolo.repository;

import com.samasat.protocolo.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {


    @Query(value = "SELECT i FROM Respuesta i WHERE i.protocolo.id =  :id ORDER BY i.id desc ")
    public List<Respuesta> buscarRespuestasPorProtocolo(Long id);
}