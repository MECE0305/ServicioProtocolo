package com.samasat.protocolo.service;

import com.samasat.protocolo.model.Respuesta;
import com.samasat.protocolo.repository.RespuestaRepository;
import com.samasat.protocolo.service.interfaces.IRespuesta;
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
public class RespuestaServiceImp implements IRespuesta {

    @Autowired
    RespuestaRepository respuestaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Respuesta> findAll() {
        return respuestaRepository.findAll();
    }

    @Override
    public Respuesta findById(Long id) {
        return respuestaRepository.findById(id).orElse(null);
    }

    @Override
    public Respuesta save(Respuesta entidad) {
        return respuestaRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        respuestaRepository.deleteById(id);
    }

    @Override
    public List<Respuesta> listaRespuestasPorProtocolo(Long id) {
        return respuestaRepository.buscarRespuestasPorProtocolo(id);
    }
}
