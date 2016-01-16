/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Gost;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class GostDaoImpl implements GostDao {

    @Inject
    private Session session;

    @Override
    public List<Gost> getListaSvihGostiju() {
        return session.createCriteria(Gost.class).list();

    }

    @Override
    public Gost getGostById(Integer id) {
        System.out.println("Integer je " + id);
        return (Gost) session.createCriteria(Gost.class).add(Restrictions.eq("id", id)).uniqueResult();

    }

    @Override
    public void dodajGosta(Gost gost) {
        session.persist(gost);

    }

    @Override
    public void obrisiGosta(Integer id) {
        Gost gost = (Gost) session.createCriteria(Gost.class).add(Restrictions.eq("id",
                id)).uniqueResult();
        session.delete(gost);

    }

}
