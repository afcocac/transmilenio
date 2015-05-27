/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.RutaDTO;
import com.vanilla.transmilenio.servicio.AmazonServicio;
import com.vanilla.transmilenio.servicio.EstacionServicio;
import com.vanilla.transmilenio.servicio.RutaServicio;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import org.primefaces.model.UploadedFile;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andco
 */
@ManagedBean
@ViewScoped
public class RutaBean implements Serializable {

    private Integer id;
    private UploadedFile file;
    private RutaDTO rutaDTO;
    private DualListModel<EstacionDTO> estaciones;
    private EstacionServicio estacionServicio;
    private RutaServicio rutaServicio;
    private List<RutaDTO> listaRutas;
    private List<String> listaEstaciones;
    private String buscar;

    public RutaBean() {
        estacionServicio = new EstacionServicio();
        rutaServicio = new RutaServicio();

        List<EstacionDTO> estacionesOrigen = estacionServicio.obtenerLista();
        List<EstacionDTO> estacionesDestino = new ArrayList<EstacionDTO>();

        estaciones = new DualListModel<EstacionDTO>(estacionesOrigen, estacionesDestino);
    }

    public void obtener() {
        if (this.id == null) {
            this.rutaDTO = new RutaDTO();
        } else {
            this.rutaDTO = rutaServicio.obtenerPorId(id);
        }
    }

    public void guardarRuta() {
        try {

            if (file.getSize() != 0) {
                AmazonServicio amazonServicio = new AmazonServicio();
                rutaDTO.setImagen(amazonServicio.guardarArchivo(file.getInputstream(), file.getFileName()));
            }

            rutaDTO.setEstado(1);

            /*
             List<EstacionDTO> est = new ArrayList<EstacionDTO>();
             EstacionDTO estacion = new EstacionDTO();
             estacion.setId(1);
             est.add(estacion);
             */
            rutaDTO.setEstacionDTOList(estaciones.getTarget());
            System.out.println(estaciones.getTarget());

            if (this.id == null) {

                rutaServicio.insertarRuta(this.rutaDTO);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Ruta Ingresada: " + rutaDTO.getNumero()));

            } else {
                rutaServicio.actualizarRuta(this.rutaDTO);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Ruta Actualizada: " + rutaDTO.getNumero()));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(e.getMessage()));
        }
    }

    public void buscarEstacion() {

        int idEncontrado = -1;
        for (int i = 0; i < rutaServicio.obtenerLista().size(); i++) {
            if (buscar.equals(rutaServicio.obtenerLista().get(i).getNumero())) {
                idEncontrado = rutaServicio.obtenerLista().get(i).getId();
                break;
            }
        }
        if(idEncontrado>-1)
        listaEstaciones = rutaServicio.buscarEstacion(idEncontrado);
        else
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La ruta ingresada no se encontró", ""));

    }

    public List<RutaDTO> getListaRutas() {
        rutaServicio = new RutaServicio();
        listaRutas = rutaServicio.obtenerLista();
        return listaRutas;
    }

    public String borrarRuta(int id) {

        rutaServicio.eliminarRuta(id);
        return "lista";
    }

    public void setListaRutas(List<RutaDTO> listaRutas) {
        this.listaRutas = listaRutas;
    }

    public DualListModel<EstacionDTO> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(DualListModel<EstacionDTO> estaciones) {
        this.estaciones = estaciones;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public RutaDTO getRutaDTO() {
        return rutaDTO;
    }

    public void setRutaDTO(RutaDTO rutaDTO) {
        this.rutaDTO = rutaDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getListaEstaciones() {
        return listaEstaciones;
    }

    public void setListaEstaciones(List<String> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

}
