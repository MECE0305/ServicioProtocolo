package com.samasat.protocolo.service.interfaces;


import com.samasat.protocolo.model.Plantilla;

import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/
public interface IPlantilla {

    public List<Plantilla> findAll();

    public Plantilla findById(Long id);

    public Plantilla save(Plantilla entidad);

    public void delete(Long id);
}
