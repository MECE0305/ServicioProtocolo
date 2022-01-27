package com.samasat.protocolo.service;

import com.samasat.protocolo.model.Categoria;
import com.samasat.protocolo.repository.CategoriaRepository;
import com.samasat.protocolo.service.interfaces.ICategoria;
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
public class CategoriaServiceImp implements ICategoria {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria entidad) {
        return categoriaRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public List<Categoria> findByPlantilla(Long idPlantilla) {
        return categoriaRepository.findByPlantilla(idPlantilla);
    }
}
