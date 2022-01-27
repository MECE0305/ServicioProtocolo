package com.samasat.protocolo.service.interfaces;


import com.samasat.protocolo.model.CategoriaPregunta;

import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/
public interface ICategoriaPregunta {

    public List<CategoriaPregunta> findAll();

    public CategoriaPregunta findById(Long id);

    public CategoriaPregunta save(CategoriaPregunta entidad);

    public void delete(Long id);

    public List<CategoriaPregunta> buscarPorPregunta(Long id);
    public List<CategoriaPregunta> buscarPorCategoria(Long id);
}
