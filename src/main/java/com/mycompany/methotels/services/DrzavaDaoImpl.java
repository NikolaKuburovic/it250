/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Drzava;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class DrzavaDaoImpl implements DrzavaDao {

    @Inject
    private Session session;

    @Override
    public List<Drzava> getListaSvihDrzava() {
        return session.createCriteria(Drzava.class).list();

    }

    @Override
    public Drzava getDrzavaById(Integer id) {
        System.out.println("Integer je " + id);
        return (Drzava) session.createCriteria(Drzava.class).add(Restrictions.eq("id", id)).uniqueResult();

    }

    @Override
    public void dodajDrzavu(Drzava drzava) {
        session.persist(drzava);

    }

    @Override
    public void obrisiDrzavu(Integer id) {
        Drzava drzava = (Drzava) session.createCriteria(Drzava.class).add(Restrictions.eq("id",
                id)).uniqueResult();
        session.delete(drzava);

    }

}
