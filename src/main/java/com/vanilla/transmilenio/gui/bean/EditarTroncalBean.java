/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author andco
 */
@ManagedBean
@ViewScoped
public class EditarTroncalBean {

    private int troncalId;
    private TroncalDTO troncalDTO;
    private TroncalServicio troncalServicio;
    
    private String nombreTroncal;
    public String getNombreTroncal() {
        return nombreTroncal;
    }

    public void setNombreTroncal(String nombreTroncal) {
        this.nombreTroncal = nombreTroncal;
    }
    

  
    public EditarTroncalBean() {
    }
        
    public void obtener() {
        troncalServicio = new TroncalServicio();
        troncalDTO = troncalServicio.obtenerPorId(troncalId);
        try{
        nombreTroncal=troncalDTO.getNombre();
        }catch (Exception e){
        }
        
        
    }
    
    public String actualizar() {
        troncalServicio = new TroncalServicio();
        troncalDTO = troncalServicio.obtenerPorId(troncalId);
        troncalDTO.setNombre(nombreTroncal);
        
         boolean encontroTroncal=false;
       
for(int i=0;i<troncalServicio.obtenerLista().size();i++){
    if(troncalDTO.getNombre().equals(troncalServicio.obtenerLista().get(i).getNombre())){
        encontroTroncal=true;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,"La troncal "+troncalDTO.getNombre()+" ya se encuentra en la base de datos, no se puede registrar",""  ));
        return "";

    }
}
        if(encontroTroncal==false){
        troncalServicio = new TroncalServicio();
        troncalServicio.actualizarTroncal(troncalDTO);
        }
        return "lista";
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
