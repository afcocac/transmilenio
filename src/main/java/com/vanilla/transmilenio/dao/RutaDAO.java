/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.dao;

import com.vanilla.transmilenio.dao.inter.RutaDAOInterface;
import com.vanilla.transmilenio.entidad.Ruta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ANDCO
 */
public class RutaDAO implements RutaDAOInterface {

    private EntityManager em = Persistence.createEntityManagerFactory( "transmi" ).createEntityManager();
    
    @Override
    public List<Ruta> obtenerLista() {
        return (List<Ruta>) em.createNamedQuery("Ruta.findAll").getResultList();
    }

    @Override
    public Ruta obtenerPorId(int id) {
        return em.find(Ruta.class, id);
    }

    @Override
    public void guardar(Ruta ruta) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(ruta);
        et.commit();
    }

    @Override
    public void actualizar(Ruta ruta) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(ruta);
        et.commit();
    }

    @Override
    public void eliminar(Ruta ruta) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(ruta);
        et.commit();
    }
    public List <String> consultar(int idEncontrado){
    List <String>listaRutas=new ArrayList();
    String consulta="select estacion.nombre from estacion,ruta,estacion_has_ruta where(ruta.id="+idEncontrado+") and(estacion_id=estacion.id) and (ruta.id=ruta_id) ;";
    EntityTransaction et = em.getTransaction();
    et.begin();
    listaRutas=em.createNativeQuery(consulta).getResultList();
    et.commit();
    return listaRutas;
    }
    
}
