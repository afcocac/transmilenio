/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.dto;

import java.util.List;

/**
 *
 * @author ANDCO
 */
public class RutaDTO {
    private Integer id;
    private String numero;
    private String horarioLunVie;
    private String horarioSab;
    private String horarioDomFes;
    private String imagen;
    private int estado;
    private List<EstacionDTO> estacionDTOList;

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

    public List<EstacionDTO> getEstacionDTOList() {
        return estacionDTOList;
    }

    public void setEstacionDTOList(List<EstacionDTO> estacionDTOList) {
        this.estacionDTOList = estacionDTOList;
    }
    
}
