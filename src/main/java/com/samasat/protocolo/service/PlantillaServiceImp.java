package com.samasat.protocolo.service;

import com.samasat.protocolo.model.Plantilla;
import com.samasat.protocolo.repository.PlantillaRepository;
import com.samasat.protocolo.service.interfaces.IPlantilla;
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
public class PlantillaServiceImp implements IPlantilla {

    @Autowired
    PlantillaRepository plantillaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Plantilla> findAll() {
        return plantillaRepository.findAll();
    }

    @Override
    public Plantilla findById(Long id) {
        return plantillaRepository.findById(id).orElse(null);
    }

    @Override
    public Plantilla save(Plantilla entidad) {
        return plantillaRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        plantillaRepository.deleteById(id);
    }

}
