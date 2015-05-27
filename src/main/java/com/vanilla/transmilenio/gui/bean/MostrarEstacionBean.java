/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.entidad.Estacion;
import com.vanilla.transmilenio.servicio.EstacionServicio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Sebastian
 */
@Named(value = "mostrarEstacionBean")
@RequestScoped
public class MostrarEstacionBean {
    private int estacionId;
    private EstacionDTO estacionDTO;
    private EstacionServicio estacionServicio;

    public void obtener() {
        estacionServicio = new EstacionServicio();
        estacionDTO = estacionServicio.obtenerPorId(estacionId);
    }

    public int getEstacionId() {
        return estacionId;
    }

    public void setEstacionId(int estacionId) {
        this.estacionId = estacionId;
    }

    public EstacionDTO getEstacionDTO() {
        return estacionDTO;
    }

    public void setEstacionDTO(EstacionDTO estacionDTO) {
        this.estacionDTO = estacionDTO;
    }
}
