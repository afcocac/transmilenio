/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.vanilla.transmilenio.dao.EstacionDAO;
import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Estacion;
import com.vanilla.transmilenio.entidad.Troncal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andco
 */
public class EstacionServicio {

    private EstacionDAO estacionDAO;
    private List<EstacionDTO> estacionDTOs;

    public EstacionServicio() {
        estacionDAO = new EstacionDAO();
    }

    public List<EstacionDTO> obtenerLista() {
        estacionDTOs = new ArrayList<EstacionDTO>();
        List<Estacion> estaciones = estacionDAO.obtenerLista();
        for (Estacion estacion : estaciones) {
            EstacionDTO estacionDTO = hacerEstacionDTO(estacion);
            estacionDTOs.add(estacionDTO);
        }
        return estacionDTOs;
    }

    public List<EstacionDTO> obtenerListaPorTroncal(TroncalDTO troncalDTO) {
        List<EstacionDTO> estacionesDTO = new ArrayList<EstacionDTO>();
        List<Estacion> estaciones = estacionDAO.obtenerListaPorTroncal(troncalDTO.getId());
        for (Estacion estacion : estaciones) {
            EstacionDTO estacionDTO = hacerEstacionDTO(estacion);
            estacionesDTO.add(estacionDTO);
        }

        return estacionesDTO;
    }

    public EstacionDTO hacerEstacionDTO(Estacion estacion) {

        EstacionDTO estacionDTO = new EstacionDTO();
        TroncalServicio troncalServicio = new TroncalServicio();
        estacionDTO.setId(estacion.getId());
        estacionDTO.setNombre(estacion.getNombre());
        estacionDTO.setDireccion(estacion.getDireccion());
        estacionDTO.setPlano(estacion.getPlano());
        estacionDTO.setEstado(estacion.getEstado());
        estacionDTO.setTroncalDTO(troncalServicio.hacerTroncalDTO(estacion.getTroncalId()));

        return estacionDTO;
    }

    public EstacionDTO obtenerPorId(int id) {
        EstacionDTO estacionDTO = new EstacionDTO();
        Estacion estacion = estacionDAO.obtenerPorId(id);

        if (estacion == null) {
            return null;
        }
        /*troncalDTO.setId(troncal.getId());
         troncalDTO.setNombre(troncal.getNombre());
         troncalDTO.setEstado(troncal.getEstado());
         */
        TroncalServicio troncalServicio = new TroncalServicio();
        estacionDTO.setId(estacion.getId());
        estacionDTO.setNombre(estacion.getNombre());
        estacionDTO.setDireccion(estacion.getDireccion());
        estacionDTO.setPlano(estacion.getPlano());
        estacionDTO.setTroncalDTO((troncalServicio.hacerTroncalDTO(estacion.getTroncalId())));

        return estacionDTO;
    }
    
    public Estacion obtenerEstacionPorId(int id) {
        Estacion estacion = estacionDAO.obtenerPorId(id);

        if (estacion == null) {
            return null;
        }
        
        return estacion;
    }

    public Integer insertarEstacion(EstacionDTO estacionDTO) {
        Estacion estacion = new Estacion();
        Troncal troncal = new Troncal();
        troncal.setId(estacionDTO.getIdTroncal());
        estacion.setId(estacionDTO.getId());
        estacion.setTroncalId(troncal);
        estacion.setNombre(estacionDTO.getNombre());
        estacion.setDireccion(estacionDTO.getDireccion());
        estacion.setPlano(estacionDTO.getPlano());
        estacion.setEstado(estacionDTO.getEstado());
        estacionDAO.guardar(estacion);

        return estacion.getId();

    }

    public EstacionDTO actualizarEstacion(EstacionDTO estacionDTO) {
        Estacion estacion = estacionDAO.obtenerPorId(estacionDTO.getId());
        estacion.setNombre(estacionDTO.getNombre());
        estacion.setEstado(estacionDTO.getEstado());
        estacion.setDireccion(estacionDTO.getDireccion());
        estacion.setPlano(estacionDTO.getPlano());
        estacion.setTroncalId(estacionDTO.getTroncal());

        estacionDAO.actualizar(estacion);
        return obtenerPorId(estacion.getId());
    }
    
    public List <String> buscarRuta(int idEncontrado){
    List <String> rutas= new ArrayList();
    
    rutas=estacionDAO.consultar(idEncontrado);
       
    return rutas;
    }
    
    
    

    public boolean eliminarEstacion(int id) {
        Estacion estacion = estacionDAO.obtenerPorId(id);
        if (estacion == null) {
            return false;
        }
        estacionDAO.eliminar(estacion);
        return true;
    }
}
