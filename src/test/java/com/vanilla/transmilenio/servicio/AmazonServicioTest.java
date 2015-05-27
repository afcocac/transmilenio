/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmazonServicioTest {
    
    /**
     * Test of guardarArchivo method, of class AmazonServicio.
     */
    @Test
    public void testGuardarArchivo_File_String() throws IOException {
        
        AmazonServicio amazonServicio = new AmazonServicio();
        File file = File.createTempFile("pruebaFile", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("Prueba File\n");
        writer.close();
        
        String url = amazonServicio.guardarArchivo(file, "pruebaFile.txt");
        String urlEsperada = "https://s3.amazonaws.com/transmifacil/pruebaFile.txt";
        
        assertEquals(urlEsperada, url);
        amazonServicio.eliminarArchivo("pruebaFile.txt");
        
    }

    /**
     * Test of guardarArchivo method, of class AmazonServicio.
     */
    @Test
    public void testGuardarArchivo_InputStream_String() throws IOException {
        AmazonServicio amazonServicio = new AmazonServicio();
        File file = File.createTempFile("pruebaInput", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("Prueba Input\n");
        writer.close();
        FileInputStream stream = new FileInputStream(file);
        
        String url = amazonServicio.guardarArchivo(stream, "pruebaInput.txt");
        String urlEsperada = "https://s3.amazonaws.com/transmifacil/pruebaInput.txt";
        
        assertEquals(urlEsperada, url);
        amazonServicio.eliminarArchivo("pruebaInput.txt");
    }
    
}
