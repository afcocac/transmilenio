/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.dao.inter;

import com.vanilla.transmilenio.entidad.Usuario;
import java.util.List;

/**
 *
 * @author sala2
 */
public interface UsuarioDAOInterface {

    List<Usuario> obtenerLista();
    Usuario obtenerPorId(int id);
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario);
    void eliminar(Usuario usuario);

}
