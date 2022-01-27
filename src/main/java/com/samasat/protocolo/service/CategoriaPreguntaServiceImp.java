package com.samasat.protocolo.service;

import com.samasat.protocolo.model.CategoriaPregunta;
import com.samasat.protocolo.repository.CategoriaPreguntaRepository;
import com.samasat.protocolo.service.interfaces.ICategoriaPregunta;
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
public class CategoriaPreguntaServiceImp implements ICategoriaPregunta {

    @Autowired
    private CategoriaPreguntaRepository categoriaPreguntaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CategoriaPregunta> findAll() {
        return categoriaPreguntaRepository.findAll();
    }

    @Override
    public CategoriaPregunta findById(Long id) {
        return categoriaPreguntaRepository.findById(id).orElse(null);
    }

    @Override
    public CategoriaPregunta save(CategoriaPregunta entidad) {
        return categoriaPreguntaRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        categoriaPreguntaRepository.deleteById(id);
    }

    @Override
    public List<CategoriaPregunta> buscarPorPregunta(Long id) {
        return categoriaPreguntaRepository.busquedaPorPregunta(id);
    }

    @Override
    public List<CategoriaPregunta> buscarPorCategoria(Long id) {
        return categoriaPreguntaRepository.busquedaPorCategoria(id);
    }
}
