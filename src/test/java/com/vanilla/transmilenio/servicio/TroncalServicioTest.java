/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Troncal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ANDCO
 */
public class TroncalServicioTest {
    

    /**
     * Test of obtenerLista method, of class TroncalServicio.
     */
    @Test
    public void testObtenerListaNoVacia() {
        
        TroncalServicio troncalServicio = new TroncalServicio();
        List<TroncalDTO> listaTroncalDTO = troncalServicio.obtenerLista();
        
        assertTrue(listaTroncalDTO.size() > 0);
        
    }

    /**
     * Test of hacerTroncalDTO method, of class TroncalServicio.
     */
    @Test
    public void testHacerTroncalDTO() {
        Troncal troncal = new Troncal();
        troncal.setId(1);
        troncal.setNombre("AutoNorte");
        troncal.setEstado(1);
        
        TroncalDTO troncalDTOEsperada = new TroncalDTO();
        troncalDTOEsperada.setId(1);
        troncalDTOEsperada.setNombre("AutoNorte");
        troncalDTOEsperada.setEstado(1);
        
        TroncalServicio troncalServicio = new TroncalServicio();
        TroncalDTO troncalDTO = troncalServicio.hacerTroncalDTO(troncal);
        
        assertTrue(Objects.equals(troncalDTO.getId(), troncalDTOEsperada.getId()));
        assertTrue(troncalDTO.getNombre().equals(troncalDTOEsperada.getNombre()));
        assertTrue(troncalDTO.getEstado() == troncalDTOEsperada.getEstado());

    }

    /**
     * Test of obtenerPorId method, of class TroncalServicio.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        int id = 0;
        TroncalServicio instance = new TroncalServicio();
        TroncalDTO expResult = null;
        TroncalDTO result = instance.obtenerPorId(id);
        
         assertNull(instance.obtenerPorId(48));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actualizarTroncal method, of class TroncalServicio.
     */
    @Test
    public void testActualizarTroncal() {
        
        TroncalDTO troncalDTO = new TroncalDTO();
        troncalDTO.setId(1);
        troncalDTO.setNombre("Calle 80");
        troncalDTO.setEstado(1);
        
        TroncalServicio troncalServicio = new TroncalServicio();
        TroncalDTO troncalDTOEsperada = troncalServicio.actualizarTroncal(troncalDTO);
        
        assertTrue(Objects.equals(troncalDTO.getId(), troncalDTOEsperada.getId()));
        assertTrue(troncalDTO.getNombre().equals(troncalDTOEsperada.getNombre()));
        assertTrue(troncalDTO.getEstado() == troncalDTOEsperada.getEstado());

    }

    /**
     * Test of insertarTroncal method, of class TroncalServicio.
     */
    @Test
    public void testInsertarTroncal() {
        System.out.println("insertarTroncal");
        TroncalDTO troncalDTO = new TroncalDTO();
        TroncalServicio instance = new TroncalServicio();
        Troncal troncal=new Troncal();
        
        troncalDTO.setNombre("Suba");
        troncalDTO.setEstado(1);
        int idTroncal = instance.insertarTroncal(troncalDTO);
        
        assertEquals(29,idTroncal);
        
   
    }

    /**
     * Test of eliminarTroncal method, of class TroncalServicio.
     */
    @Test
    public void testEliminarTroncal() {
        System.out.println("eliminarTroncal");
        int id = 0;
        TroncalServicio instance = new TroncalServicio();
       
        
        
        instance.eliminarTroncal(48);
        assertNull(instance.obtenerPorId(48));
        
        
        
    }
    
}
