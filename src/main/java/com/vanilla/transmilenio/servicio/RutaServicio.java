/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.vanilla.transmilenio.dao.RutaDAO;
import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.RutaDTO;
import com.vanilla.transmilenio.entidad.Estacion;
import com.vanilla.transmilenio.entidad.Ruta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andco
 */
public class RutaServicio {

    private RutaDAO rutaDAO;
    private List<RutaDTO> rutaDTOs;

    public RutaServicio() {
        rutaDAO = new RutaDAO();
    }

    public RutaDTO obtenerPorId(int id) {
        RutaDTO rutaDTO = new RutaDTO();
        Ruta ruta = rutaDAO.obtenerPorId(id);

        if (ruta == null) {
            return null;
        }

        rutaDTO.setId(ruta.getId());
        rutaDTO.setNumero(ruta.getNumero());
        rutaDTO.setHorarioLunVie(ruta.getHorarioLunVie());
        rutaDTO.setHorarioSab(ruta.getHorarioSab());
        rutaDTO.setHorarioDomFes(ruta.getHorarioDomFes());
        rutaDTO.setImagen(ruta.getImagen());
        rutaDTO.setEstado(ruta.getEstado());

        List<EstacionDTO> estacionDTOList = new ArrayList<EstacionDTO>();

        for (Estacion estacion : ruta.getEstacionList()) {
            EstacionDTO estacionDTO = new EstacionDTO();
            estacionDTO.setId(estacion.getId());
            estacionDTO.setNombre(estacion.getNombre());
            estacionDTO.setDireccion(estacion.getDireccion());
            estacionDTO.setPlano(estacion.getPlano());
            estacionDTO.setEstado(estacion.getEstado());

            estacionDTOList.add(estacionDTO);
        }

        rutaDTO.setEstacionDTOList(estacionDTOList);

        return rutaDTO;
    }

    public Integer insertarRuta(RutaDTO rutaDTO) {
        Ruta ruta = new Ruta();

        ruta.setId(rutaDTO.getId());
        ruta.setNumero(rutaDTO.getNumero());
        ruta.setHorarioLunVie(rutaDTO.getHorarioLunVie());
        ruta.setHorarioSab(rutaDTO.getHorarioSab());
        ruta.setHorarioDomFes(rutaDTO.getHorarioDomFes());
        ruta.setImagen(rutaDTO.getImagen());
        ruta.setEstado(rutaDTO.getEstado());
        
        List<Estacion> listaEstaciones = new ArrayList<Estacion>();
        EstacionServicio estacionServicio = new EstacionServicio();
        
        
        
        for (EstacionDTO estacionDTO : rutaDTO.getEstacionDTOList()) {
            Estacion estacion = estacionServicio.obtenerEstacionPorId(estacionDTO.getId());
            System.out.println("Estacion: " + estacion.getNombre());
            
            listaEstaciones.add(estacion);
        }
        
        ruta.setEstacionList(listaEstaciones);
        
        rutaDAO.guardar(ruta);
        return ruta.getId();

    }
    
    public void actualizarRuta(RutaDTO rutaDTO) {
        Ruta ruta = rutaDAO.obtenerPorId(rutaDTO.getId());
        
        ruta.setNumero(rutaDTO.getNumero());
        ruta.setHorarioLunVie(rutaDTO.getHorarioLunVie());
        ruta.setHorarioSab(rutaDTO.getHorarioSab());
        ruta.setHorarioDomFes(rutaDTO.getHorarioDomFes());
        ruta.setImagen(rutaDTO.getImagen());
        ruta.setEstado(rutaDTO.getEstado());

        List<Estacion> listaEstaciones = new ArrayList<Estacion>();
        EstacionServicio estacionServicio = new EstacionServicio();
        
        for (EstacionDTO estacionDTO : rutaDTO.getEstacionDTOList()) {
            Estacion estacion = estacionServicio.obtenerEstacionPorId(estacionDTO.getId());
            listaEstaciones.add(estacion);
        }
        
        ruta.setEstacionList(listaEstaciones);
        
        rutaDAO.actualizar(ruta);

    }
      public List<RutaDTO> obtenerLista() {
        rutaDTOs = new ArrayList<RutaDTO>();
        List<Ruta> rutas = rutaDAO.obtenerLista();
        for (Ruta ruta : rutas) {
            RutaDTO rutaDTO = hacerRutaDTO(ruta);
            rutaDTOs.add(rutaDTO);
        }
        return rutaDTOs;
    }
      public RutaDTO hacerRutaDTO(Ruta ruta) {
          
        RutaDTO rutaDTO = new RutaDTO();
        rutaDTO.setId(ruta.getId());
        rutaDTO.setNumero(ruta.getNumero());
        rutaDTO.setHorarioLunVie(ruta.getHorarioLunVie());
        rutaDTO.setHorarioSab(ruta.getHorarioSab());
        rutaDTO.setHorarioDomFes(ruta.getHorarioDomFes());
        rutaDTO.setImagen(ruta.getImagen());
        rutaDTO.setEstado(1);
        return rutaDTO;
        
      
    }
      
       public boolean eliminarRuta(int id){
        Ruta ruta = rutaDAO.obtenerPorId(id);
        if (ruta == null) {
            return false;
        }
        rutaDAO.eliminar(ruta);
        return true;
       
       }
       public List <String> buscarEstacion(int idEncontrado){
           List <String> estaciones= new ArrayList();
           estaciones=rutaDAO.consultar(idEncontrado);
           
           return estaciones;
       }
       
       
     

}
