package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.AbstractEntity;
import com.mycompany.methotels.entities.Drzava;
import java.util.Collections;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nikola Kuburovic 1095
 * @param <T>
 */
public class GenericDaoImpl<T extends AbstractEntity> implements GenericDao<T> {

    @Inject
    private Session hibernate;
    
    private Class cls;
    
    public GenericDaoImpl(){
        cls = Drzava.class;
    }

    @Override
    public AbstractEntity merge(AbstractEntity obj) {
        return (T) hibernate.merge(obj);
    }

    @Override
    public T delete(Integer idOfObj, Class klasa) {
        AbstractEntity tmpEntity = (AbstractEntity) hibernate.createCriteria(klasa)
                .add(Restrictions.eq("id",idOfObj)).list().get(0);
        hibernate.delete((T) tmpEntity);
        hibernate.flush();
        return (T) tmpEntity;
    }

    @Override
    public T getElementById(Integer id, Class klasa) {
        AbstractEntity tmpEntity = (AbstractEntity) hibernate.createCriteria(klasa)
                .add(Restrictions.eq("id",id)).list().get(0);
        return (T) tmpEntity;
    }

    @Override
    public List<T> loadAllActive(Class klasa) {
        List<T> lista = hibernate.createCriteria(klasa).setResultTransformer(
                Criteria.DISTINCT_ROOT_ENTITY).list();
        Collections.sort(lista);
        return lista;
    }

    @Override
    public List<T> getElementsByNames(String ime) {
        return hibernate.createCriteria(cls)
                .add(Restrictions.ilike("ime", ime + "%")).list();

    }

    @Override
    public int allActiveSize() {
        Long l = (Long) hibernate.createCriteria(cls)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        return l.intValue();

    }

    @Override
    public List<T> loadActiveFromTo(int from) {
        int page = (from - 1) * 10;
        List<T> lista
                = hibernate.createCriteria(cls)
                        .setFirstResult(page)
                        .setMaxResults(10)
                        .addOrder(Order.asc("id"))
                        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                        .list();
        return lista;

    }
}
