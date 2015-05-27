/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dao.EstacionDAO;
import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.RutaDTO;
import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Estacion;
import com.vanilla.transmilenio.entidad.Ruta;
import com.vanilla.transmilenio.servicio.AmazonServicio;
import com.vanilla.transmilenio.servicio.EstacionServicio;
import com.vanilla.transmilenio.servicio.RutaServicio;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author andco
 */
@Named(value = "estacionBean")
@SessionScoped
public class EstacionBean implements Serializable {

    private List<EstacionDTO> listaEstaciones;
    private EstacionServicio estacionServicio;
    private EstacionDTO estacionDTO;
    private int idTroncal;
    private UploadedFile file;
    private List<String> listaRutas;
    private String nombreRuta;
    private String nombreEstacion;

    private List<String> lista;

    public EstacionDTO getEstacionDTO() {
        return estacionDTO;
    }

    public void setEstacionDTO(EstacionDTO estacionDTO) {
        this.estacionDTO = estacionDTO;
    }

    public EstacionBean() {

        estacionServicio = new EstacionServicio();
        estacionDTO = new EstacionDTO();
        estacionDTO.setNombre(estacionDTO.getNombre());
        estacionDTO.setDireccion(estacionDTO.getDireccion());
        estacionDTO.setEstado(1);
        estacionDTO.setTroncal(estacionDTO.getTroncal());
    }

    public void guardarEstacion() throws Exception {

        if (file.getSize() != 0) {
            AmazonServicio amz = new AmazonServicio();
            estacionDTO.setPlano(amz.guardarArchivo(file.getInputstream(), file.getFileName()));
        }

        estacionServicio.insertarEstacion(estacionDTO);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Estacion Ingresada: " + estacionDTO.getNombre()));

    }

    public void buscarRuta() {

        EstacionServicio es = new EstacionServicio();
        boolean estacionEncontrada = false;
        int idEncontrado = 0;
        for (int i = 0; i < estacionServicio.obtenerLista().size(); i++) {
            if (estacionDTO.getNombre().equals(estacionServicio.obtenerLista().get(i).getNombre())) {
                idEncontrado = estacionServicio.obtenerLista().get(i).getId();
                estacionEncontrada = true;
                break;
            }
        }

        if (estacionEncontrada) {
            lista = es.buscarRuta(idEncontrado);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La estación ingresada no se encontró", ""));
        }

    }

    public List<EstacionDTO> getListaEstaciones() {
        estacionServicio = new EstacionServicio();
        listaEstaciones = estacionServicio.obtenerLista();
        return listaEstaciones;
    }

    public void setListaEstaciones(List<EstacionDTO> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }

    public String borrarEstacion(int id) {

        estacionServicio.eliminarEstacion(id);
        return "lista";
    }

    public int getIdTroncal() {
        return idTroncal;
    }

    public void setIdTroncal(int idTroncal) {
        this.idTroncal = idTroncal;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<String> getListaRutas() {

        return listaRutas;
    }

    public void setListaRutas(List<String> listaRutas) {
        this.listaRutas = listaRutas;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

}
