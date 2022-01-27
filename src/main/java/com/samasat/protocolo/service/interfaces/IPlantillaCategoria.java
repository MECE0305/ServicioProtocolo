package com.samasat.protocolo.service.interfaces;


import com.samasat.protocolo.model.Plantilla;
import com.samasat.protocolo.model.PlantillaCategoria;

import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/
public interface IPlantillaCategoria {
    public List<PlantillaCategoria> findAll();

    public PlantillaCategoria findById(Long id);

    public PlantillaCategoria save(PlantillaCategoria entidad);

    public void delete(Long id);

    public List<PlantillaCategoria> buscarPorPlantilla(Long id);
    public List<PlantillaCategoria> buscarPorCategoría(Long id);
}
