package com.samasat.protocolo.controller;

import com.samasat.protocolo.exception.ErrorMessage;
import com.samasat.protocolo.model.Protocolo;
import com.samasat.protocolo.model.Respuesta;
import com.samasat.protocolo.service.ProtocoloServiceImp;
import com.samasat.protocolo.service.RespuestaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/protocolo")
public class ProtocoloController {

    @Autowired
    private ProtocoloServiceImp protocoloService;

    @Autowired
    private RespuestaServiceImp respuestaService;
    
    @GetMapping("/listar")
    public List<Protocolo> findAll(){
        return protocoloService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Protocolo findById(@Valid @PathVariable Long id) throws EntityNotFoundException {
        return protocoloService.findById(id);
    }

    @PostMapping("/crear")
    public Protocolo save(@Valid @RequestBody Protocolo entidad){
        return protocoloService.save(entidad);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ErrorMessage> delete(@PathVariable Long id) {
        try {

            String cadena = "";
            Protocolo protocolo = protocoloService.findById(id);
            if (protocolo == null) {
                throw new javax.persistence.EntityNotFoundException("Protocolo con id " + id + "no encontrado");
            } else {

                //BUSCANDO REGISTROS DE RESPUESTAS RELACIONADAS AL PROTOCOLO A ELIMINAR
                List<Respuesta> listaRespuestas = respuestaService.listaRespuestasPorProtocolo(protocolo.getId());

                if (listaRespuestas.size() > 0) {
                    cadena = "Protocolo a eliminar tiene " + listaRespuestas.size() + " registros de respuestas asociadas ";
                    return new ResponseEntity(new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), HttpStatus.CONFLICT.name(), cadena), HttpStatus.NOT_FOUND);

                } else {
                    protocoloService.delete(id);
                    return new ResponseEntity<>(HttpStatus.OK);
                }

            }

        } catch (Exception e) {
            return new ResponseEntity(new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), HttpStatus.NOT_FOUND.name(),  e.getMessage()), HttpStatus.NOT_FOUND);

        }
    }
}
