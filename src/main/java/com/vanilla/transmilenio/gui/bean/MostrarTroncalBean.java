/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Sebastian
 */
@Named(value = "mostrarTroncalBean")
@RequestScoped
public class MostrarTroncalBean {

    private int troncalId;
    private TroncalDTO troncalDTO;
    private TroncalServicio troncalServicio;

    public void obtener() {
        troncalServicio = new TroncalServicio();
        troncalDTO = troncalServicio.obtenerPorId(troncalId);
    }

    public int getTroncalId() {
        return troncalId;
    }

    public void setTroncalId(int troncalId) {
        this.troncalId = troncalId;
    }

    public TroncalDTO getTroncalDTO() {
        return troncalDTO;
    }

    public void setTroncalDTO(TroncalDTO troncalDTO) {
        this.troncalDTO = troncalDTO;
    }
    
    
    
}
