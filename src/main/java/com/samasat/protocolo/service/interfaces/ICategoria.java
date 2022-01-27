package com.samasat.protocolo.service.interfaces;

import com.samasat.protocolo.model.Categoria;

import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/
public interface ICategoria {

    public List<Categoria> findAll();

    public Categoria findById(Long id);

    public Categoria save(Categoria entidad);

    public void delete(Long id);

    public List<Categoria> findByPlantilla(Long idPlantilla);
}
