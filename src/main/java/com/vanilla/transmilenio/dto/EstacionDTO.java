/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.dto;

import com.vanilla.transmilenio.entidad.Troncal;

/**
 *
 * @author andco
 */
public class EstacionDTO {
    
    private Integer id;
    private String nombre;
    private String direccion;
    private String plano;
    private int estado;
    private TroncalDTO troncalDTO;
    private Troncal troncal;
    private int idTroncal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public TroncalDTO getTroncalDTO() {
        return troncalDTO;
    }

    public void setTroncalDTO(TroncalDTO troncalDTO) {
        this.troncalDTO = troncalDTO;
    }

    public Troncal getTroncal() {
        return troncal;
    }

    public void setTroncal(Troncal troncal) {
        this.troncal = troncal;
    }

    public int getIdTroncal() {
        return idTroncal;
    }

    public void setIdTroncal(int idTroncal) {
        this.idTroncal = idTroncal;
    }
    
    
}
