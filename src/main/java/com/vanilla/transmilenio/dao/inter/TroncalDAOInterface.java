package com.vanilla.transmilenio.dao.inter;

import com.vanilla.transmilenio.entidad.Troncal;
import java.util.List;

public interface TroncalDAOInterface {
    
        List<Troncal> obtenerLista();
        Troncal obtenerPorId(int id);
        void guardar(Troncal troncal);
        void actualizar(Troncal troncal);
        void eliminar(Troncal troncal);
}
