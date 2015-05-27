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
import com.vanilla.transmilenio.entidad.Troncal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastian
 */
public class RutaServicioTest {

    public RutaServicioTest() {
    }

    /**
     * Test of obtenerPorId method, of class RutaServicio.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        int id = 1;
        RutaServicio instance = new RutaServicio();
        String expResult = "c19";
        String result = instance.obtenerPorId(id).getNumero();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of insertarRuta method, of class RutaServicio.
     */
    @Test
    public void testInsertarRuta() {
        System.out.println("insertarRuta");
        List<EstacionDTO> estacionDTOList = new ArrayList<EstacionDTO>();
        RutaDTO rutaDTO = new RutaDTO();
        rutaDTO.setNumero("b72");
        rutaDTO.setHorarioLunVie("04:00 am- 11:30 pm");
        rutaDTO.setHorarioDomFes("00:07 am-06:00 pm");
        rutaDTO.setHorarioDomFes("no");
        rutaDTO.setImagen("asas");
        rutaDTO.setEstado(1);
        EstacionDTO estacionDTO = new EstacionDTO();
        estacionDTO.setId(2);
        estacionDTO.setNombre("estacion");
        estacionDTO.setDireccion("calle 10");
        estacionDTO.setPlano("plano");
        estacionDTO.setEstado(1);
        estacionDTOList.add(estacionDTO);

        rutaDTO.setEstacionDTOList(estacionDTOList);

        RutaServicio instance = new RutaServicio();

        int result = instance.insertarRuta(rutaDTO);
        assertTrue(result > 0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of actualizarRuta method, of class RutaServicio.
     */
    @Test
    public void testActualizarRuta() {
        System.out.println("actualizarRuta");

        RutaDTO rutaDTO = new RutaDTO();
        rutaDTO.setId(4);
        rutaDTO.setNumero("b90");
        rutaDTO.setImagen("imagen");
        rutaDTO.setHorarioLunVie("lun");
        rutaDTO.setHorarioSab("sab");
        rutaDTO.setHorarioDomFes("dom");

        RutaServicio instance = new RutaServicio();
        instance.actualizarRuta(rutaDTO);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of obtenerLista method, of class RutaServicio.
     */
    @Test
    public void testObtenerLista() {
        System.out.println("obtenerLista");
        RutaServicio instance = new RutaServicio();
        int expResult = 7;
        int result = instance.obtenerLista().size();
        assertTrue(result>0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of hacerRutaDTO method, of class RutaServicio.
     */
    @Test
    public void testHacerRutaDTO() {
        System.out.println("hacerRutaDTO");
        
        Ruta ruta = new Ruta();
        ruta.setId(1);
        ruta.setNumero("B18");
        ruta.setHorarioLunVie("07:00 am -02:00pm");
        ruta.setHorarioSab("05:00 am -01:00pm");
        ruta.setHorarioDomFes("08:00 am -01:00pm");
        ruta.setImagen("imagen");
        ruta.setEstado(1);
        
        RutaServicio rutaServicio = new RutaServicio();

        RutaDTO rutaDTO = rutaServicio.hacerRutaDTO(ruta);

        assertEquals(ruta.getId(), rutaDTO.getId());
        assertTrue(rutaDTO.getNumero().equals(ruta.getNumero()));
        assertTrue(rutaDTO.getHorarioLunVie().equals(ruta.getHorarioLunVie()));
        assertTrue(rutaDTO.getHorarioSab().equals(ruta.getHorarioSab()));
        assertTrue(rutaDTO.getHorarioDomFes().equals(ruta.getHorarioDomFes()));
        assertTrue(rutaDTO.getImagen().equals(ruta.getImagen()));
        assertEquals(ruta.getEstado(), rutaDTO.getEstado());
                
    }

    /**
     * Test of eliminarRuta method, of class RutaServicio.
     */
    @Test
    public void testEliminarRuta() {
        System.out.println("eliminarRuta");
        int id = 30;
        RutaServicio instance = new RutaServicio();
        boolean expResult = false;
        boolean result = instance.eliminarRuta(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
     @Test
     public void test(){}
    

}
