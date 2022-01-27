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
@Table(name = "tani_categoria",schema = "protocolo")

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "cat_nombre")
    private String nombre;

    @Column(name = "cat_descripcion")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "cat_activo")
    private Boolean activo;

    @Basic(optional = false)
    @Column(name = "cat_fecha_crea")
    @Temporal(TemporalType.DATE)
    private Date fechaCrea;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "subcategoria", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Categoria> categoriaList;

    @JoinColumn(name = "cat_subcategoria_id", referencedColumnName = "cat_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria subcategoria;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "categoria", fetch = FetchType.LAZY)
    @JsonManagedReference("referenceCategoria")
    private List<CategoriaPregunta> categoriaPreguntaList;

}
