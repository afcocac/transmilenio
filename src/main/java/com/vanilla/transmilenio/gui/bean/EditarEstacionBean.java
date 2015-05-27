/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Troncal;
import com.vanilla.transmilenio.servicio.AmazonServicio;
import com.vanilla.transmilenio.servicio.EstacionServicio;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Sebastian
 */
@ManagedBean
@ViewScoped
public class EditarEstacionBean {

    private int estacionId;
    private int idTroncal;
    private String nombreEstacion;
    private String direccionEstacion;
    private String planoEstacion;
    private EstacionDTO estacionDTO;
    private EstacionServicio estacionServicio;
    private UploadedFile files;

    public EditarEstacionBean() {
    }

    public void obtener() {
        estacionServicio = new EstacionServicio();
        estacionDTO = estacionServicio.obtenerPorId(estacionId);
        try{
        
        
        nombreEstacion = estacionDTO.getNombre();
        direccionEstacion=estacionDTO.getDireccion();
        
        }catch(Exception e){
        
            
        }

    }

    public String actualizar() throws Exception {
      
        Troncal t = new Troncal();

        t.setId(idTroncal);
        estacionServicio = new EstacionServicio();
        estacionDTO = estacionServicio.obtenerPorId(estacionId);
        estacionDTO.setNombre(nombreEstacion);
        estacionDTO.setDireccion(direccionEstacion);
        
        if (files.getSize() != 0) {
            AmazonServicio amz = new AmazonServicio();
            estacionDTO.setPlano(amz.guardarArchivo(files.getInputstream(), files.getFileName()));
        }
        
        estacionDTO.setEstado(1);
        estacionDTO.setTroncal(t);
        estacionServicio.actualizarEstacion(estacionDTO);

        return "lista";
    }

    public int getEstacionId() {
        return estacionId;
    }

    public void setEstacionId(int estacionId) {
        this.estacionId = estacionId;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getDireccionEstacion() {
        return direccionEstacion;
    }

    public void setDireccionEstacion(String direccionEstacion) {
        this.direccionEstacion = direccionEstacion;
    }

    public String getPlanoEstacion() {
        return planoEstacion;
    }

    public void setPlanoEstacion(String planoEstacion) {
        this.planoEstacion = planoEstacion;
    }

    public EstacionDTO getEstacionDTO() {
        return estacionDTO;
    }

    public void setEstacionDTO(EstacionDTO estacionDTO) {
        this.estacionDTO = estacionDTO;
    }

    public int getIdTroncal() {
        return idTroncal;
    }

    public void setIdTroncal(int idTroncal) {
        this.idTroncal = idTroncal;
    }

    public UploadedFile getFiles() {
        return files;
    }

    public void setFiles(UploadedFile files) {
        this.files = files;
    }

}
