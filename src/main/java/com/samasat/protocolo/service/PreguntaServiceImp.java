package com.samasat.protocolo.service;

import com.samasat.protocolo.model.Pregunta;
import com.samasat.protocolo.repository.PreguntaRepository;
import com.samasat.protocolo.service.interfaces.IPregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/

@Service
public class PreguntaServiceImp implements IPregunta {

    @Autowired
    PreguntaRepository preguntaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pregunta> findAll() {
        return preguntaRepository.findAll();
    }

    @Override
    public Pregunta findById(Long id) {
        return preguntaRepository.findById(id).orElse(null);
    }

    @Override
    public Pregunta save(Pregunta entidad) {
        return preguntaRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        preguntaRepository.deleteById(id);
    }
}
