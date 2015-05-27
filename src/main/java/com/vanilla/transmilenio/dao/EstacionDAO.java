/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.dao;

import com.vanilla.transmilenio.dao.inter.EstacionDAOInterface;
import com.vanilla.transmilenio.entidad.Estacion;
import com.vanilla.transmilenio.entidad.Troncal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sala1
 */
public class EstacionDAO implements EstacionDAOInterface {

    private EntityManager em = Persistence.createEntityManagerFactory( "transmi" ).createEntityManager();

    @Override
    public List<Estacion> obtenerLista() {
        return (List<Estacion>) em.createNamedQuery("Estacion.findAll").getResultList();
    }
    
    @Override
    public List<Estacion> obtenerListaPorTroncal(int idTroncal) {
        return em.find(Troncal.class, idTroncal).getEstacionList();
    }

    @Override
    public Estacion obtenerPorId(int id) {
        return em.find(Estacion.class, id);
    }

    @Override
    public void guardar(Estacion estacion) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(estacion);
        et.commit();
    }

    @Override
    public void actualizar(Estacion estacion) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(estacion);
        et.commit();
    }

    @Override
    public void eliminar(Estacion estacion) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(estacion);
        et.commit();
    }
    
    public List <String> consultar(int idEncontrado){
        List <String>query=new ArrayList();
        String consulta="select numero from estacion e, estacion_has_ruta,ruta r where(estacion_id="+idEncontrado+") and(e.id="+idEncontrado+")and (r.id=ruta_id);";
        EntityTransaction et = em.getTransaction();
        et.begin();
        query=em.createNativeQuery(consulta).getResultList();
        et.commit();
        
        return query;
    }
    
    

}
