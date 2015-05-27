/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ANDCO
 */
@Entity
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findById", query = "SELECT r FROM Ruta r WHERE r.id = :id"),
    @NamedQuery(name = "Ruta.findByNumero", query = "SELECT r FROM Ruta r WHERE r.numero = :numero"),
    @NamedQuery(name = "Ruta.findByHorarioLunVie", query = "SELECT r FROM Ruta r WHERE r.horarioLunVie = :horarioLunVie"),
    @NamedQuery(name = "Ruta.findByHorarioSab", query = "SELECT r FROM Ruta r WHERE r.horarioSab = :horarioSab"),
    @NamedQuery(name = "Ruta.findByHorarioDomFes", query = "SELECT r FROM Ruta r WHERE r.horarioDomFes = :horarioDomFes"),
    @NamedQuery(name = "Ruta.findByImagen", query = "SELECT r FROM Ruta r WHERE r.imagen = :imagen"),
    @NamedQuery(name = "Ruta.findByEstado", query = "SELECT r FROM Ruta r WHERE r.estado = :estado")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "numero")
    private String numero;
    @Size(max = 200)
    @Column(name = "horario_lun_vie")
    private String horarioLunVie;
    @Size(max = 200)
    @Column(name = "horario_sab")
    private String horarioSab;
    @Size(max = 200)
    @Column(name = "horario_dom_fes")
    private String horarioDomFes;
    @Size(max = 2083)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @ManyToMany
    @JoinTable(
            name = "estacion_has_ruta", joinColumns = {
                @JoinColumn(name = "ruta_id")
            }, inverseJoinColumns = {
                @JoinColumn(name = "estacion_id")
            }
    )
    private List<Estacion> estacionList;

    public Ruta() {
    }

    public Ruta(Integer id) {
        this.id = id;
    }

    public Ruta(Integer id, String numero, int estado) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getHorarioLunVie() {
        return horarioLunVie;
    }

    public void setHorarioLunVie(String horarioLunVie) {
        this.horarioLunVie = horarioLunVie;
    }

    public String getHorarioSab() {
        return horarioSab;
    }

    public void setHorarioSab(String horarioSab) {
        this.horarioSab = horarioSab;
    }

    public String getHorarioDomFes() {
        return horarioDomFes;
    }

    public void setHorarioDomFes(String horarioDomFes) {
        this.horarioDomFes = horarioDomFes;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Estacion> getEstacionList() {
        return estacionList;
    }

    public void setEstacionList(List<Estacion> estacionList) {
        this.estacionList = estacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vanilla.transmilenio.entidad.Ruta[ id=" + id + " ]";
    }

}
