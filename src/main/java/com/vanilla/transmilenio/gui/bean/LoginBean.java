/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.gui.bean;

import com.vanilla.transmilenio.dto.UsuarioDTO;
import com.vanilla.transmilenio.servicio.UsuarioServicio;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author sala2
 */
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{
    
    private UsuarioServicio usuarioServicio;
    private String username;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        usuarioServicio = new UsuarioServicio();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        FacesMessage message = null;
        boolean loggedIn = usuarioServicio.verificarUsuario(this.username, this.password);
         
        if(loggedIn) {
            return "troncal/lista";
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de inicio de sesión", "Credenciales inválidas");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    }
}
