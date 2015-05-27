/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio.integration;

import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.RutaDTO;
import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.servicio.EstacionServicio;
import com.vanilla.transmilenio.servicio.RutaServicio;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ANDCO
 */
public class GestionTroncalEstacionRutaTest {
    
    @Test
    public void gestionTroncalEstacionRuta() {
        
        TroncalServicio troncalServicio = new TroncalServicio();
        EstacionServicio estacionServicio = new EstacionServicio();
        RutaServicio rutaServicio = new RutaServicio();
        
        TroncalDTO troncalDTO = new TroncalDTO();
        troncalDTO.setNombre("Av. 68");
        troncalDTO.setEstado(1);
        
        int idTroncalDTO = troncalServicio.insertarTroncal(troncalDTO);
        
        EstacionDTO estacionDTO = new EstacionDTO();
        estacionDTO.setNombre("Cruz Roja");
        estacionDTO.setDireccion("Av 68 70");
        estacionDTO.setIdTroncal(idTroncalDTO);
        estacionDTO.setEstado(1);
        
        int idEstacionDTO = estacionServicio.insertarEstacion(estacionDTO);
        estacionDTO.setId(idEstacionDTO);
        
        RutaDTO rutaDTO = new RutaDTO();
        rutaDTO.setNumero("N1");
        rutaDTO.setHorarioLunVie("5:00am - 10:00pm");
        rutaDTO.setHorarioSab("5:00am - 10:00pm");
        rutaDTO.setHorarioDomFes("5:00am - 10:00pm");
        rutaDTO.setEstado(1);
        
        List<EstacionDTO> listaEstacionesDTO = new ArrayList<EstacionDTO>();
        listaEstacionesDTO.add(estacionDTO);
                
        rutaDTO.setEstacionDTOList(listaEstacionesDTO);
        
        int idRutaDTO = rutaServicio.insertarRuta(rutaDTO);
        
        RutaDTO rutaDTOEsperada = rutaServicio.obtenerPorId(idRutaDTO);
        
        assertNotNull(rutaDTOEsperada);
                
        
    }
}
