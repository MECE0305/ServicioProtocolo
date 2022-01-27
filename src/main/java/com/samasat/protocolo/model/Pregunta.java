/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasat.protocolo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tani_pregunta",schema = "protocolo")

public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pre_id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "pre_enunciado")
    private String enunciado;

    @Basic(optional = false)
    @Column(name = "pre_activo")
    private Boolean activo;

    @Basic(optional = false)
    @Column(name = "pre_fecha_crea")
    @Temporal(TemporalType.DATE)
    private Date fechaCrea;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pregunta", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<CategoriaPregunta> categoriaPreguntaList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "subPregunta", fetch = FetchType.LAZY)
    @JsonBackReference("referenceSubPr")
    private List<Pregunta> preguntaList;

    @JoinColumn(name = "pre_subpregunta_id", referencedColumnName = "pre_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pregunta subPregunta;

}
