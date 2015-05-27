/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio.integration;

import com.vanilla.transmilenio.dto.TroncalDTO;
import com.vanilla.transmilenio.entidad.Troncal;
import com.vanilla.transmilenio.servicio.TroncalServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author ANDCO
 */
public class GestionTroncalTest {

    @Test
    public void gestionTroncal() {
        TroncalServicio troncalServicio = new TroncalServicio();
        
        Troncal troncal = new Troncal();
        troncal.setId(21);
        troncal.setNombre("Suba");
        troncal.setEstado(1);
        
        TroncalDTO troncalDTOEsperado = new TroncalDTO();
        troncalDTOEsperado.setId(21);
        troncalDTOEsperado.setNombre("Suba");
        troncalDTOEsperado.setEstado(1);
        
        TroncalDTO troncalDTO = troncalServicio.hacerTroncalDTO(troncal);
        
        assertTrue(Objects.equals(troncalDTO.getId(), troncalDTOEsperado.getId()));
        assertTrue(troncalDTO.getNombre().equals(troncalDTOEsperado.getNombre()));
        assertTrue(troncalDTO.getEstado() == troncalDTOEsperado.getEstado());
        
        int idTroncal = troncalServicio.insertarTroncal(troncalDTO);
        
        assertTrue(21 == idTroncal);
        
        troncalDTO = troncalServicio.obtenerPorId(idTroncal);
        
        assertTrue(Objects.equals(troncalDTO.getId(), troncalDTOEsperado.getId()));
        assertTrue(troncalDTO.getNombre().equals(troncalDTOEsperado.getNombre()));
        assertTrue(troncalDTO.getEstado() == troncalDTOEsperado.getEstado());
        
        TroncalDTO troncalDTOActualizadaEsperada = new TroncalDTO();
        troncalDTOActualizadaEsperada.setId(21);
        troncalDTOActualizadaEsperada.setNombre("Caracas");
        troncalDTOActualizadaEsperada.setEstado(1);
        
        troncalDTO.setNombre("Caracas");
        TroncalDTO troncalDTOActualizada = troncalServicio.actualizarTroncal(troncalDTO);
        
        assertTrue(Objects.equals(troncalDTOActualizada.getId(), troncalDTOActualizadaEsperada.getId()));
        assertTrue(troncalDTOActualizada.getNombre().equals(troncalDTOActualizadaEsperada.getNombre()));
        assertTrue(troncalDTOActualizada.getEstado() == troncalDTOActualizadaEsperada.getEstado());
        
        
        List<TroncalDTO> listaTroncalDTOEsperada = new ArrayList<TroncalDTO>();
        TroncalDTO troncalDTO1 = new TroncalDTO();
        troncalDTO1.setId(1);
        troncalDTO1.setNombre("Calle 80");
        troncalDTO1.setEstado(1);
        listaTroncalDTOEsperada.add(troncalDTO1);
        TroncalDTO troncalDTO2 = new TroncalDTO();
        troncalDTO2.setId(2);
        troncalDTO2.setNombre("Americas");
        troncalDTO2.setEstado(1);
        listaTroncalDTOEsperada.add(troncalDTO2);
        TroncalDTO troncalDTO3 = new TroncalDTO();
        troncalDTO3.setId(21);
        troncalDTO3.setNombre("Caracas");
        troncalDTO3.setEstado(1);
        listaTroncalDTOEsperada.add(troncalDTO3);
        
        List<TroncalDTO> listaTroncalDTO = troncalServicio.obtenerLista();
        
        for (int i = 0; i < listaTroncalDTO.size(); i++) {
            TroncalDTO troncalDTOActual = listaTroncalDTO.get(i);
            troncalDTOEsperado = listaTroncalDTOEsperada.get(i);
            assertTrue(Objects.equals(troncalDTOEsperado.getId(), troncalDTOActual.getId()));
            assertTrue(troncalDTOEsperado.getNombre().equals(troncalDTOActual.getNombre()));
            assertTrue(troncalDTOEsperado.getEstado() == troncalDTOActual.getEstado());
        }
        
        troncalServicio.eliminarTroncal(idTroncal);
        
        assertNull(troncalServicio.obtenerPorId(idTroncal));
                
    }
}
