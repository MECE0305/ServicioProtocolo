/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasat.protocolo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tani_respuesta",schema = "protocolo")

public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "res_valor")
    private int valor;

    @Basic(optional = false)
    @Column(name = "res_fecha_crea")
    @Temporal(TemporalType.DATE)
    private Date fechaCrea;

    @Basic(optional = false)
    @Column(name = "res_activo")
    private Boolean activo;

    @Column(name = "res_valor_str")
    private String valorStr;

    @Basic(optional = false)
    @Column(name = "res_pregunta_id")
    private Long preguntaId;

    @JoinColumn(name = "tani_protocolo_pro_id", referencedColumnName = "pro_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Protocolo protocolo;


}
