package com.samasat.protocolo.controller;

import com.samasat.protocolo.exception.ErrorMessage;
import com.samasat.protocolo.model.Categoria;
import com.samasat.protocolo.model.CategoriaPregunta;
import com.samasat.protocolo.service.CategoriaPreguntaServiceImp;
import com.samasat.protocolo.service.CategoriaServiceImp;
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
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImp categoriaService;

    @Autowired
    private CategoriaPreguntaServiceImp categoriaPreguntaService;

    @GetMapping("/listar")
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Categoria findById(@Valid @PathVariable Long id) throws EntityNotFoundException {
        return categoriaService.findById(id);
    }

    @PostMapping("/crear")
    public Categoria save(@Valid @RequestBody Categoria entidad){
        return categoriaService.save(entidad);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ErrorMessage> delete(@PathVariable Long id) {
        try {

            String cadena = "";
            Categoria categoria = categoriaService.findById(id);
            if (categoria == null) {
                throw new javax.persistence.EntityNotFoundException("Categoria con id " + id + "no encontrado");
            } else {

                //BUSCANDO REGISTROS DE PREGUNTAS RELACIONADAS A LA CATEGORIA A ELIMINAR
                List<CategoriaPregunta> listaRespuestas = categoriaPreguntaService.buscarPorCategoria(categoria.getId());

                if (listaRespuestas.size() > 0) {
                    cadena = "Categoria a eliminar tiene " + listaRespuestas.size() + " preguntas asociadas ";
                    return new ResponseEntity(new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), HttpStatus.CONFLICT.name(), cadena), HttpStatus.NOT_FOUND);

                } else {
                    categoriaService.delete(id);
                    return new ResponseEntity<>(HttpStatus.OK);
                }

            }

        } catch (Exception e) {
            return new ResponseEntity(new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), HttpStatus.NOT_FOUND.name(),  e.getMessage()), HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping("/findByPlantilla/{id}")
    public List<Categoria> findByPlantilla(@PathVariable Long id){
        return categoriaService.findByPlantilla(id);
    }

}
