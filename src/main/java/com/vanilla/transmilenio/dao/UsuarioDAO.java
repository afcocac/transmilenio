/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.dao;

import com.vanilla.transmilenio.dao.inter.UsuarioDAOInterface;
import com.vanilla.transmilenio.entidad.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sala2
 */
public class UsuarioDAO implements UsuarioDAOInterface {
    
    private EntityManager em = Persistence.createEntityManagerFactory( "transmi" ).createEntityManager();

    @Override
    public List<Usuario> obtenerLista() {
        return (List<Usuario>) em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario obtenerPorId(int id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public void guardar(Usuario usuario) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(usuario);
        et.commit();
    }

    @Override
    public void actualizar(Usuario usuario) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(usuario);
        et.commit();
    }

    @Override
    public void eliminar(Usuario usuario) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(usuario);
        et.commit();
    }
    
    public Usuario obtenerPorUsername(String username) {
        List<Usuario> listUsuario = em.createNamedQuery("Usuario.findByUsername").setParameter("username", username).getResultList();
        return (listUsuario.isEmpty()) ? null : listUsuario.get(0);
    }
    
}
