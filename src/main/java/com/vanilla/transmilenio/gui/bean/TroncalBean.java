/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dao.TroncalDAO;
import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Troncal;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author andco
 */
@Named(value = "troncalBean")
@RequestScoped
public class TroncalBean implements Serializable {

    private List<TroncalDTO> listaTroncales;
    private TroncalServicio troncalServicio;
    private TroncalDTO troncalDTO;
    private List<String> listaRutas;
    private String nombreTab;
    
    public TroncalBean() {
        troncalServicio = new TroncalServicio();
        troncalDTO = new TroncalDTO();
        troncalDTO.setEstado(1);
    }

    public void guardarTroncal() {
       boolean encontroTroncal=troncalServicio.verificarTroncal(troncalServicio.obtenerLista(), troncalDTO.getNombre());
      
       
     
/*for(int i=0;i<troncalServicio.obtenerLista().size();i++){
    if(troncalDTO.getNombre().equals(troncalServicio.obtenerLista().get(i).getNombre())){
        encontroTroncal=true;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,"La troncal "+troncalDTO.getNombre()+" ya se encuentra en la base de datos, no se puede registrar",""  ));
        break;

    }
}*/
        if(encontroTroncal==false){
        troncalServicio.insertarTroncal(troncalDTO);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Troncal Ingresada: " + troncalDTO.getNombre()));
       }
        else{
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,"La troncal "+troncalDTO.getNombre()+" ya se encuentra en la base de datos, no se puede registrar",""  ));
        }
    }

    public String borrarTroncal(int id) {

        troncalServicio.eliminarTroncal(id);
        return "lista";
    }

    public List<TroncalDTO> getListaTroncales() {
        troncalServicio = new TroncalServicio();
        listaTroncales = troncalServicio.obtenerLista();
        return listaTroncales;
    }

    public void setListaTroncales(List<TroncalDTO> listaTroncales) {
        this.listaTroncales = listaTroncales;
    }

    public TroncalDTO getTroncalDTO() {
        return troncalDTO;
    }

    public void setTroncalDTO(TroncalDTO troncalDTO) {
        this.troncalDTO = troncalDTO;
    }

    public List<String> getListaRutas() {
        TroncalServicio es=new TroncalServicio();
        int idEncontrado=0;
        for (int i = 0; i <listaTroncales.size(); i++) {
            if(listaTroncales.get(i).getNombre().equals(nombreTab)){
            idEncontrado=listaTroncales.get(i).getId();
            break;
            }
        }
        listaRutas=es.buscar_Ruta_Por_Troncal(idEncontrado);
        
        return listaRutas;
    }

    public void setListaRutas(List<String> listaRutas) {
        this.listaRutas = listaRutas;
    }

    public String getNombreTab() {
        return nombreTab;
    }

    public void setNombreTab(String nombreTab) {
        this.nombreTab = nombreTab;
    }

  
  
}
