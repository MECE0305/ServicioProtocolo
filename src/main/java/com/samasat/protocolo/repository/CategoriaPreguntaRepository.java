package com.samasat.protocolo.repository;

import com.samasat.protocolo.model.CategoriaPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaPreguntaRepository extends JpaRepository<CategoriaPregunta, Long> {

    @Query(value = "SELECT i FROM CategoriaPregunta i WHERE i.pregunta.id =  :id ORDER BY i.id desc ")
    public List<CategoriaPregunta> busquedaPorPregunta(Long id);

    @Query(value = "SELECT i FROM CategoriaPregunta i WHERE i.categoria.id =  :id ORDER BY i.id desc ")
    public List<CategoriaPregunta> busquedaPorCategoria(Long id);
}