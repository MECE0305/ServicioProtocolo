package com.samasat.protocolo.repository;

import com.samasat.protocolo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


    /**
     * Lista de categorías correspondientes a una plantilla
     * @return
     */
    @Query(value = "SELECT c FROM Categoria c INNER JOIN " +
            " CategoriaPregunta cp ON cp.categoria.id = c.id INNER JOIN" +
            " PlantillaCategoria pc ON pc.categoriaPregunta.id = cp.id INNER JOIN" +
            " Plantilla  p on p.id = pc.plantilla.id" +
            " WHERE c.activo = true and p.id  = :id ORDER BY c.id desc ")
    public List<Categoria> findByPlantilla(Long id);


}