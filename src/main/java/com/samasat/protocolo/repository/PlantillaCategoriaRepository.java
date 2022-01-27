package com.samasat.protocolo.repository;

import com.samasat.protocolo.model.CategoriaPregunta;
import com.samasat.protocolo.model.PlantillaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantillaCategoriaRepository extends JpaRepository<PlantillaCategoria, Long> {

    @Query(value = "SELECT i FROM PlantillaCategoria i WHERE i.categoriaPregunta =  :id ORDER BY i.id desc ")
    public List<PlantillaCategoria> busquedaPorCategoriaPregunta(Long id);

    @Query(value = "SELECT i FROM PlantillaCategoria i WHERE i.plantilla.id =  :id ORDER BY i.id desc ")
    public List<PlantillaCategoria> busquedaPorPlantilla(Long id);

}