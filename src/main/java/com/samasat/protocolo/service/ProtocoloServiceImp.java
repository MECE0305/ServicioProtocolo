package com.samasat.protocolo.service;

import com.samasat.protocolo.model.Protocolo;
import com.samasat.protocolo.repository.ProtocoloRepository;
import com.samasat.protocolo.service.interfaces.IProtocolo;
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
public class ProtocoloServiceImp implements IProtocolo {

    @Autowired
    ProtocoloRepository protocoloRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Protocolo> findAll() {
        return protocoloRepository.findAll();
    }

    @Override
    public Protocolo findById(Long id) {
        return protocoloRepository.findById(id).orElse(null);
    }

    @Override
    public Protocolo save(Protocolo entidad) {
        return protocoloRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        protocoloRepository.deleteById(id);
    }
}
