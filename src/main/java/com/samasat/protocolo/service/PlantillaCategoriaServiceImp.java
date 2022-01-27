package com.samasat.protocolo.service;

import com.samasat.protocolo.model.Plantilla;
import com.samasat.protocolo.model.PlantillaCategoria;
import com.samasat.protocolo.repository.PlantillaCategoriaRepository;
import com.samasat.protocolo.service.interfaces.IPlantillaCategoria;
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
public class PlantillaCategoriaServiceImp implements IPlantillaCategoria {

    @Autowired
    PlantillaCategoriaRepository plantillaCategoriaRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<PlantillaCategoria> findAll() {
        return plantillaCategoriaRepository.findAll();
    }

    @Override
    public PlantillaCategoria findById(Long id) {
        return plantillaCategoriaRepository.findById(id).orElse(null);
    }

    @Override
    public PlantillaCategoria save(PlantillaCategoria entidad) {
        return plantillaCategoriaRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        plantillaCategoriaRepository.deleteById(id);
    }

    @Override
    public List<PlantillaCategoria> buscarPorPlantilla(Long id) {
        return plantillaCategoriaRepository.busquedaPorPlantilla(id);
    }

    @Override
    public List<PlantillaCategoria> buscarPorCategoría(Long id) {
        return plantillaCategoriaRepository.busquedaPorCategoriaPregunta(id);
    }
}
