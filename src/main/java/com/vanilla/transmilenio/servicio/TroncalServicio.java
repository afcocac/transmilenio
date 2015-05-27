/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.vanilla.transmilenio.dao.TroncalDAO;
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
public class TroncalServicio {

    private TroncalDAO troncalDAO;
    private List<TroncalDTO> troncalDTOs;

    public TroncalServicio() {
        troncalDAO = new TroncalDAO();
    }

    public List<TroncalDTO> obtenerLista() {
        troncalDTOs = new ArrayList<TroncalDTO>();
        List<Troncal> troncales = troncalDAO.obtenerLista();
        for (Troncal troncal : troncales) {
            TroncalDTO troncalDTO = hacerTroncalDTO(troncal);
            troncalDTOs.add(troncalDTO);
        }
        return troncalDTOs;
    }

    public TroncalDTO hacerTroncalDTO(Troncal troncal) {

        TroncalDTO troncalDTO = new TroncalDTO();
        troncalDTO.setId(troncal.getId());
        troncalDTO.setNombre(troncal.getNombre());
        troncalDTO.setEstado(troncal.getEstado());
        List<EstacionDTO> estacionesDTO = new ArrayList<EstacionDTO>();
        List<Estacion> estaciones = troncal.getEstacionList();
        for (Estacion estacion : estaciones) {
            EstacionDTO estacionDTO = new EstacionDTO();
            estacionDTO.setId(estacion.getId());
            estacionDTO.setNombre(estacion.getNombre());
            estacionDTO.setDireccion(estacion.getDireccion());
            estacionDTO.setPlano(estacion.getPlano());
            estacionDTO.setEstado(estacion.getEstado());
            
            estacionesDTO.add(estacionDTO);
        }
        
        troncalDTO.setEstacionesDTO(estacionesDTO);
        
        return troncalDTO;
    }

    public TroncalDTO obtenerPorId(int id) {
        TroncalDTO troncalDTO = new TroncalDTO();
        Troncal troncal = troncalDAO.obtenerPorId(id);
        
        if ( troncal == null)
           return null;
        troncalDTO.setId(troncal.getId());
        troncalDTO.setNombre(troncal.getNombre());
        troncalDTO.setEstado(troncal.getEstado());
        
       
        return troncalDTO;
    }
    
    public Troncal obtenerTroncalPorId(int id) {
        Troncal troncal = troncalDAO.obtenerPorId(id);
        
        if (troncal == null)
           return null;
       
        return troncal;
    }

    public TroncalDTO actualizarTroncal(TroncalDTO troncalDTO) {
        Troncal troncal = troncalDAO.obtenerPorId(troncalDTO.getId());
        troncal.setNombre(troncalDTO.getNombre());
        troncal.setEstado(troncalDTO.getEstado());

        troncalDAO.actualizar(troncal);
        return obtenerPorId(troncal.getId());
    }

    public Integer insertarTroncal(TroncalDTO troncalDTO) {
        Troncal troncal = new Troncal();
        troncal.setId(troncalDTO.getId());
        troncal.setNombre(troncalDTO.getNombre());
        troncal.setEstado(troncalDTO.getEstado());
        troncalDAO.guardar(troncal);
        return troncal.getId();

    }
    public boolean verificarTroncal(List <TroncalDTO> lista,String nombre){
    for(int i=0;i<lista.size();i++){
    if(nombre.equals(lista.get(i).getNombre())){
        
     return true;
    }
    }
    return false;
    }
    public boolean eliminarTroncal(int id) {
        Troncal troncal = troncalDAO.obtenerPorId(id);
        if (troncal == null) {
            return false;
        }
        troncalDAO.eliminar(troncal);
        return true;
    }
    public List <String> buscar_Ruta_Por_Troncal(int idEncontrado){
    List <String> rutas= new ArrayList();
    
    rutas=troncalDAO.consultar_Por_Troncal(idEncontrado);
       
    return rutas;
    }
            
}
