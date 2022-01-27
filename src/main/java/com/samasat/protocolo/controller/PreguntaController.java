package com.samasat.protocolo.controller;

import com.samasat.protocolo.exception.ErrorMessage;
import com.samasat.protocolo.model.CategoriaPregunta;
import com.samasat.protocolo.model.Pregunta;
import com.samasat.protocolo.service.CategoriaPreguntaServiceImp;
import com.samasat.protocolo.service.PreguntaServiceImp;
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
@RequestMapping("/pregunta")
public class PreguntaController {

    @Autowired
    private PreguntaServiceImp preguntaService;

    @Autowired
    private CategoriaPreguntaServiceImp categoriaPreguntaServicio;

    @GetMapping("/listar")
    public List<Pregunta> findAll(){
        return preguntaService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Pregunta findById(@Valid @PathVariable Long id) throws EntityNotFoundException {
        return preguntaService.findById(id);
    }

    @PostMapping("/crear")
    public Pregunta save(@Valid @RequestBody Pregunta entidad){
        return preguntaService.save(entidad);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ErrorMessage> delete(@PathVariable Long id) {
        try {

            String cadena = "";
            Pregunta pregunta = preguntaService.findById(id);
            if (pregunta == null) {
                throw new javax.persistence.EntityNotFoundException("Pregunta con id " + id + "no encontrado");
            } else {

                //BUSCANDO REGISTROS DE CATEGORÌA-PREGUNTA RELACIONADAS AL PROTOCOLO A ELIMINAR
                List<CategoriaPregunta> listaCategoríaRespuesta = categoriaPreguntaServicio.buscarPorPregunta(pregunta.getId());

                if (listaCategoríaRespuesta.size() > 0) {
                    cadena = "Pregunta a eliminar tiene " + listaCategoríaRespuesta.size() + " registros relacionados a categoría ";
                    return new ResponseEntity(new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), HttpStatus.CONFLICT.name(), cadena), HttpStatus.NOT_FOUND);

                } else {
                    preguntaService.delete(id);
                    return new ResponseEntity<>(HttpStatus.OK);
                }

            }

        } catch (Exception e) {
            return new ResponseEntity(new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), HttpStatus.NOT_FOUND.name(),  e.getMessage()), HttpStatus.NOT_FOUND);

        }
    }
}
