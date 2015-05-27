package com.vanilla.transmilenio.dao.inter;

import com.vanilla.transmilenio.entidad.Estacion;
import java.util.List;

public interface EstacionDAOInterface {
    
        List<Estacion> obtenerLista();
        List<Estacion> obtenerListaPorTroncal(int idTroncal);
        Estacion obtenerPorId(int id);
        void guardar(Estacion estacion);
        void actualizar(Estacion estacion);
        void eliminar(Estacion estacion);
}
