package com.vanilla.transmilenio.dao.inter;

import com.vanilla.transmilenio.entidad.Ruta;
import java.util.List;

public interface RutaDAOInterface {
    
        List<Ruta> obtenerLista();
        Ruta obtenerPorId(int id);
        void guardar(Ruta ruta);
        void actualizar(Ruta ruta);
        void eliminar(Ruta ruta);
}
