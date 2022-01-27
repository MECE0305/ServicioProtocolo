/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasat.protocolo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mariana Cuadrado - 12/1/2022
 * @version 1.0
 * @project protocolo
 **/

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tani_plantilla",schema = "protocolo")

public class Plantilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pla_id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "pla_nombre")
    private String nombre;

    @Column(name = "pla_descripcion")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "pla_activo")
    private Boolean activo;

    @Basic(optional = false)
    @Column(name = "pla_fecha_crea")
    @Temporal(TemporalType.DATE)
    private Date fechaCrea;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantilla", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PlantillaCategoria> plantillaCategoriaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantilla", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Protocolo> protocoloList;

}
