package com.samasat.protocolo.service.interfaces;

import com.samasat.protocolo.model.Protocolo;

import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/
public interface IProtocolo {
    public List<Protocolo> findAll();

    public Protocolo findById(Long id);

    public Protocolo save(Protocolo entidad);

    public void delete(Long id);
}
