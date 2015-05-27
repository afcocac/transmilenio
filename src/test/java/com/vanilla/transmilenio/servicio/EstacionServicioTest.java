/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.vanilla.transmilenio.dto.EstacionDTO;
import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Estacion;
import com.vanilla.transmilenio.entidad.Troncal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EstacionServicioTest {

    /**
     * Test of obtenerLista method, of class EstacionServicio.
     */
    @Test
    public void testObtenerListaNoVacia() {
        EstacionServicio estacionServicio = new EstacionServicio();
        List<EstacionDTO> listaEstaciones = estacionServicio.obtenerLista();
        assertTrue(listaEstaciones.size() > 0);
    }

    /**
     * Test of obtenerListaPorTroncal method, of class EstacionServicio.
     */
    @Test
    public void testObtenerListaNoVaciaPorTroncal() {
        EstacionServicio estacionServicio = new EstacionServicio();
        TroncalDTO troncalDTO = new TroncalDTO();
        troncalDTO.setId(1);
        troncalDTO.setNombre(null);
        troncalDTO.setEstado(1);
        List<EstacionDTO> listaEstaciones = estacionServicio.obtenerListaPorTroncal(troncalDTO);
        assertTrue(listaEstaciones.size() > 0);
    }

    /**
     * Test of hacerEstacionDTO method, of class EstacionServicio.
     */
    @Test
    public void testHacerEstacionDTO() {
        EstacionServicio estacionServicio = new EstacionServicio();
        
        Troncal troncal = new Troncal();
        troncal.setId(1);
        troncal.setNombre("Caracas");
        troncal.setEstado(1);
        troncal.setEstacionList(new ArrayList<Estacion>());
        
        Estacion estacion = new Estacion();
        estacion.setId(1);
        estacion.setNombre("Calle 45");
        estacion.setDireccion("Av. Caracas Calle 45");
        estacion.setPlano("http://www.transmilenio.gov.co/sites/default/files/estacion-calle-45-01.05.2015.jpg");
        estacion.setEstado(1);
        estacion.setTroncalId(troncal);
        
        TroncalDTO troncalDTO = new TroncalDTO();
        troncalDTO.setId(1);
        troncalDTO.setNombre("Caracas");
        troncalDTO.setEstado(1);
        troncalDTO.setEstacionesDTO(new ArrayList<EstacionDTO>());
        
        EstacionDTO estacionDTO = estacionServicio.hacerEstacionDTO(estacion);
                
        EstacionDTO estacionDTOEsperada = new EstacionDTO();
        estacionDTOEsperada.setId(1);
        estacionDTOEsperada.setNombre("Calle 45");
        estacionDTOEsperada.setDireccion("Av. Caracas Calle 45");
        estacionDTOEsperada.setPlano("http://www.transmilenio.gov.co/sites/default/files/estacion-calle-45-01.05.2015.jpg");
        estacionDTOEsperada.setEstado(1);
        estacionDTOEsperada.setTroncalDTO(troncalDTO);
        
        
        
        assertEquals(estacionDTOEsperada.getId(), estacion.getId());
        assertEquals(estacionDTOEsperada.getNombre(), estacion.getNombre());
        assertEquals(estacionDTOEsperada.getDireccion(), estacion.getDireccion());
        assertEquals(estacionDTOEsperada.getPlano(), estacion.getPlano());
        assertEquals(estacionDTOEsperada.getEstado(), estacion.getEstado());
        
    }

    /**
     * Test of obtenerPorId method, of class EstacionServicio.
     */
    @Test
    public void testObtenerPorId() {
        EstacionServicio estacionServicio = new EstacionServicio();
        EstacionDTO estacionDTO = estacionServicio.obtenerPorId(200);
        
        assertNull(estacionDTO);
    }

    /**
     * Test of insertarEstacion method, of class EstacionServicio.
     */
    @Test
    public void testInsertarEstacion() {
        EstacionServicio estacionServicio = new EstacionServicio();
        TroncalServicio troncalServicio = new TroncalServicio();
        
        EstacionDTO estacionDTO = new EstacionDTO();
        estacionDTO.setNombre("Ciudad Universitaria");
        estacionDTO.setDireccion("Calle 26 36");
        estacionDTO.setPlano("url");
        estacionDTO.setEstado(1);
        estacionDTO.setTroncal(troncalServicio.obtenerTroncalPorId(1));
        
        int idEstacion = estacionServicio.insertarEstacion(estacionDTO);
        assertTrue(idEstacion > 0);
        
    }

    /**
     * Test of actualizarEstacion method, of class EstacionServicio.
     */
    @Test
    public void testActualizarEstacion() {
        EstacionServicio estacionServicio = new EstacionServicio();
        
        TroncalDTO troncalDTO = new TroncalDTO();
        troncalDTO.setId(1);
        troncalDTO.setNombre("Calle 26");
        troncalDTO.setEstado(1);
        
        EstacionDTO estacionDTO = new EstacionDTO();
        estacionDTO.setId(1);
        estacionDTO.setNombre("Ciudad Universitaria");
        estacionDTO.setDireccion("Calle 26 36");
        estacionDTO.setPlano("url");
        estacionDTO.setEstado(1);
        estacionDTO.setTroncalDTO(troncalDTO);
        
        estacionDTO = estacionServicio.actualizarEstacion(estacionDTO);
        
        assertTrue(estacionDTO.getId() == 1);
        assertTrue(estacionDTO.getNombre().equals("Ciudad Universitaria"));
        assertTrue(estacionDTO.getDireccion().equals("Calle 26 36"));
        assertTrue(estacionDTO.getPlano().equals("url"));
        assertTrue(estacionDTO.getEstado() == 1);
    }

    /**
     * Test of eliminarEstacion method, of class EstacionServicio.
     */
    @Test
    public void testEliminarEstacionExistente() {
        EstacionServicio estacionServicio = new EstacionServicio();
        boolean elimino = estacionServicio.eliminarEstacion(1);
        
        assertTrue(elimino);
        
    }
    @Test
    public void testBuscarRuta(){
    EstacionServicio estacionServicio = new EstacionServicio();
    assertNotNull(estacionServicio.buscarRuta(1));
    
    }
    
}
