/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Soba;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class SobaDaoImpl implements SobaDao {

    @Inject
    private Session session;

    @Override
    public List<Soba> getListaSvihSoba() {
        return session.createCriteria(Soba.class).list();

    }

    @Override
    public Soba getSobaById(Integer id) {
        System.out.println("Integer je " + id);
        return (Soba) session.createCriteria(Soba.class).add(Restrictions.eq("id", id)).uniqueResult();

    }

    @Override
    public void dodajSobu(Soba soba) {
        session.persist(soba);

    }

    @Override
    public void obrisiSobu(Integer id) {
        Soba soba = (Soba) session.createCriteria(Soba.class).add(Restrictions.eq("id",
                id)).uniqueResult();
        session.delete(soba);

    }

    @Override
    public void dodajIzmeniSobu(Soba soba) {
        session.merge(soba);
    }

}
