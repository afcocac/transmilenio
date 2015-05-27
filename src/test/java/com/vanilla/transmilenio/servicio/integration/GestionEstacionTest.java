/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio.integration;

import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Estacion;
import com.vanilla.transmilenio.servicio.EstacionServicio;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author sala6
 */
public class GestionEstacionTest {

    @Test
    public void gestionEstacion() {
        TroncalServicio troncalServicio = new TroncalServicio();
        EstacionServicio estacionServicio = new EstacionServicio();
        
        TroncalDTO troncalDTO = new TroncalDTO();
        troncalDTO.setNombre("Caracas Sur");
        troncalDTO.setEstado(1);
        
        int idTroncal = troncalServicio.insertarTroncal(troncalDTO);
        
        troncalDTO = troncalServicio.obtenerPorId(idTroncal);
        
        Estacion estacion = new Estacion();
        estacion.setNombre("Molinos");
        estacion.setDireccion("Caracas 80 Sur");
        estacion.setPlano("url");
        estacion.setEstado(1);
        estacion.setTroncalId(troncalServicio.obtenerTroncalPorId(idTroncal));
        
        // Hacer estacionDTO 
        EstacionDTO estacionDTO = estacionServicio.hacerEstacionDTO(estacion);
        
        assertTrue(estacionDTO.getNombre().equals("Molinos"));
        assertTrue(estacionDTO.getDireccion().equals("Caracas 80 Sur"));
        assertTrue(estacionDTO.getPlano().equals("url"));
        assertTrue(estacionDTO.getEstado() == 1);
        
        // insertar estacion 
        int idEstacion = estacionServicio.insertarEstacion(estacionDTO);
        
        assertTrue(idEstacion > 0);
        
        // obtener estacion por id
        estacionDTO = estacionServicio.obtenerPorId(idEstacion);
        
        assertNotNull(estacionDTO);
        
        estacionDTO.setDireccion("Caracas 81 Sur");
        
        // actualizar estacoin 
        estacionDTO = estacionServicio.actualizarEstacion(estacionDTO);
        
        assertTrue(estacionDTO.equals("Caracas 81 Sur"));
        
        // Lista de todas las estaciones 
        List<EstacionDTO> listaTodasEstacionDTO = estacionServicio.obtenerLista();
        assertTrue(listaTodasEstacionDTO.size() > 0);
        
        // Lista de estaciones por Troncal
        List<EstacionDTO> listaEstacionPorTroncal = estacionServicio.obtenerListaPorTroncal(troncalDTO);
        assertTrue(listaTodasEstacionDTO.size() > 0);
        
        //Buscar ruta
        assertNotNull(estacionServicio.buscarRuta(1));
        
        // Eliminar estacion
        for (EstacionDTO estacionDTO2 : listaEstacionPorTroncal) {
            boolean elimino = estacionServicio.eliminarEstacion(estacionDTO2.getId());
            
            assertTrue(elimino);
        }
        
        
        
        
        
    }
}
