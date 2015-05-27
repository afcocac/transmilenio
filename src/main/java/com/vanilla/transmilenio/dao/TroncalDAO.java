/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.dao;

import com.vanilla.transmilenio.dao.inter.TroncalDAOInterface;
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
public class TroncalDAO implements TroncalDAOInterface {

    private EntityManager em = Persistence.createEntityManagerFactory( "transmi" ).createEntityManager();

    @Override
    public List<Troncal> obtenerLista() {
        return (List<Troncal>) em.createNamedQuery("Troncal.findAll").getResultList();
    }

    @Override
    public Troncal obtenerPorId(int id) {
        return em.find(Troncal.class, id);
    }

    @Override
    public void guardar(Troncal troncal) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(troncal);
        et.commit();
    }

    @Override
    public void actualizar(Troncal troncal) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(troncal);
        et.commit();
    }

    @Override
    public void eliminar(Troncal troncal) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(troncal);
        et.commit();
    }
public List <String> consultar_Por_Troncal(int idEncontrado){
     List <String>query=new ArrayList();
        String consulta="select  distinct ruta.numero from ruta, estacion_has_ruta where (estacion_id in( select  estacion.id from troncal, estacion where (troncal.id="+idEncontrado+") and(troncal_id=+"+idEncontrado+")) and (ruta_id=ruta.id));";
        EntityTransaction et = em.getTransaction();
        et.begin();
        query=em.createNativeQuery(consulta).getResultList();
        et.commit();
        
        return query;
    }
}
