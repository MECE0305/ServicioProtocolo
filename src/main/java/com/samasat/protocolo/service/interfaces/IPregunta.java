package com.samasat.protocolo.service.interfaces;

import com.samasat.protocolo.model.Pregunta;

import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/
public interface IPregunta {

    public List<Pregunta> findAll();

    public Pregunta findById(Long id);

    public Pregunta save(Pregunta entidad);

    public void delete(Long id);
}
