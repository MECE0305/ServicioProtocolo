/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasat.protocolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "tani_protocolo",schema = "protocolo")

public class Protocolo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "pro_fecha_crea")
    @Temporal(TemporalType.DATE)
    private Date fechaCrea;

    @Basic(optional = false)
    @Column(name = "pro_activo")
    private Boolean activo;

    @Basic(optional = false)
    @Column(name = "pro_puntaje")
    private float puntaje;

    @Basic(optional = false)
    @Column(name = "pro_aprueba")
    private Boolean aprueba;

    @Basic(optional = false)
    @Column(name = "pro_empresa")
    private Long empresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "protocolo", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Respuesta> respuestaList;

    @JoinColumn(name = "tani_plantilla_pla_id", referencedColumnName = "pla_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Plantilla plantilla;

}
