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
import com.vanilla.transmilenio.servicio.RutaServicio;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author sala6
 */
public class GestionRutaTest {

    @Test
    public void gestionRuta() {
        int id = 1;
        RutaServicio instance = new RutaServicio();
        String expResult = "c19";
        String result = instance.obtenerPorId(id).getNumero();

        assertEquals(expResult, result);
        
        
    }
}
