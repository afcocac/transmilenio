/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.vanilla.transmilenio.dao.UsuarioDAO;
import com.vanilla.transmilenio.dto.UsuarioDTO;
import com.vanilla.transmilenio.entidad.Usuario;

/**
 *
 * @author sala2
 */
public class UsuarioServicio {
    
    private UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public UsuarioDTO obtenerPorUsername(String username) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Usuario usuario = usuarioDAO.obtenerPorUsername(username);
        
        if (usuario == null)
           return null;
        
        
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setEstado(usuario.getEstado());
        
        return usuarioDTO;
    }
    
    public boolean verificarUsuario(String username, String password) {
        UsuarioDTO usuarioDTO = obtenerPorUsername(username);
        
        if (usuarioDTO == null) {
            return false;
        }
        
        return usuarioDTO.getPassword().equals(password);
    }
    
}
