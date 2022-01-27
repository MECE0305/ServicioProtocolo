package com.samasat.protocolo.service.interfaces;

import com.samasat.protocolo.model.Respuesta;

import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/
public interface IRespuesta {
    public List<Respuesta> findAll();

    public Respuesta findById(Long id);

    public Respuesta save(Respuesta entidad);

    public void delete(Long id);

    public List<Respuesta> listaRespuestasPorProtocolo(Long id);

}
