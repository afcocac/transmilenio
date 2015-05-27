/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.vanilla.transmilenio.dto.UsuarioDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ANDCO
 */
public class UsuarioServicioTest {

    /**
     * Test of obtenerPorUsername method, of class UsuarioServicio.
     */
    @Test
    public void testObtenerPorUsername() {
        System.out.println("obtenerPorUsername");
        String username = "admin";
        UsuarioServicio instance = new UsuarioServicio();
        UsuarioDTO result = instance.obtenerPorUsername(username);
        assertNotNull(result);
    }

    /**
     * Test of verificarUsuario method, of class UsuarioServicio.
     */
    @Test
    public void testVerificarUsuario() {
        System.out.println("verificarUsuario");
        String username = "admin";
        String password = "admin";
        UsuarioServicio instance = new UsuarioServicio();
        boolean expResult = true;
        boolean result = instance.verificarUsuario(username, password);
        assertEquals(expResult, result);
    }
    
}
