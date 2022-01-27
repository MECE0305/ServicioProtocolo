package com.samasat.protocolo.controller;

import com.samasat.protocolo.exception.ErrorMessage;
import com.samasat.protocolo.model.Plantilla;
import com.samasat.protocolo.model.PlantillaCategoria;
import com.samasat.protocolo.model.Respuesta;
import com.samasat.protocolo.service.PlantillaCategoriaServiceImp;
import com.samasat.protocolo.service.PlantillaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/plantilla")
public class PlantillaController {

    @Autowired
    private PlantillaServiceImp plantillaService;

    @Autowired
    private PlantillaCategoriaServiceImp plantillaCategoriaService;

    @GetMapping("/listar")
    public List<Plantilla> findAll(){
        return plantillaService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Plantilla findById(@Valid @PathVariable Long id) throws EntityNotFoundException {
        return plantillaService.findById(id);
    }

    @PostMapping("/crear")
    public Plantilla save(@Valid @RequestBody Plantilla entidad){
        return plantillaService.save(entidad);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ErrorMessage> delete(@PathVariable Long id) {
        try {

            String cadena = "";
            Plantilla plantilla = plantillaService.findById(id);
            if (plantilla == null) {
                throw new javax.persistence.EntityNotFoundException("Plantilla con id " + id + "no encontrado");
            } else {

                //BUSCANDO REGISTROS DE RESPUESTAS RELACIONADAS AL PROTOCOLO A ELIMINAR
                List<PlantillaCategoria> listaPlantillaCategoria = plantillaCategoriaService.buscarPorCategoría(plantilla.getId());

                if (listaPlantillaCategoria.size() > 0) {
                    cadena = "Plantilla a eliminar tiene " + listaPlantillaCategoria.size() + " registros de respuestas asociadas ";
                    return new ResponseEntity(new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), HttpStatus.CONFLICT.name(), cadena), HttpStatus.NOT_FOUND);

                } else {
                    plantillaService.delete(id);
                    return new ResponseEntity<>(HttpStatus.OK);
                }

            }

        } catch (Exception e) {
            return new ResponseEntity(new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), HttpStatus.NOT_FOUND.name(),  e.getMessage()), HttpStatus.NOT_FOUND);

        }
    }
}
