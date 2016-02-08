/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.components;

import com.mycompany.methotels.entities.AbstractEntity;
import com.mycompany.methotels.services.GenericDao;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.PropertyConduit;
import org.apache.tapestry5.annotations.PageLoaded;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.PropertyConduitSource;

/**
 *
 * @author Nikola Kuburovic 1095
 * @param <T>
 */
public class GenericEditor<T extends AbstractEntity> {

    @Inject
    private PropertyConduitSource conduit;

    @Inject
    private GenericDao genericDao;
    @Property
    @Persist
    private T bean;
    @Property
    private T row;
    @Inject
    private BeanModelSource beanModelSource;
    @Inject
    private ComponentResources componentResources;
    private Class klasa;
    @Property
    private List<T> lista;

    {
        PropertyConduit conduit1 = conduit.create(getClass(), "bean");
        klasa = conduit1.getPropertyType();
    }

    @PageLoaded
    void pocetna() {
        if (lista == null) {
            lista = new ArrayList();
        }
        lista = genericDao.loadAllActive(klasa);
    }

    public BeanModel<T> getFormModel() {
        return beanModelSource.createEditModel(klasa,
                componentResources.getMessages()).exclude("id");
    }

    public BeanModel<T> getGridModel() {
        return beanModelSource.createDisplayModel(klasa,
                componentResources.getMessages()).exclude("id");
    }

    @CommitAfter
    Object onActionFromBrisanje(int id) {
        lista.remove((T) genericDao.delete(id, klasa));
        return this;
    }

    @CommitAfter
    Object onActionFromEdit(int row) {
        bean = (T) genericDao.getElementById(row, klasa);
        return this;
    }

    @CommitAfter
    public Object onSuccess() {
        brisanjeIzKesa();
        lista.add((T) genericDao.merge(bean));
        try {
            bean = (T) klasa.newInstance();
        } catch (Exception ex) {
        }
        return this;
    }

    public void brisanjeIzKesa() {

        for (int i = lista.size() - 1; i >= 0; i--) {
            if (lista.get(i).equals(bean)) {
                lista.remove(i);
            }
        }

        //Jos jedan moguci nacin brisanja iz lokalnog kesa
        /*ListIterator<T> li = lista.listIterator();
         while (li.hasNext()) {
            if (li.next().compareTo(bean) == 0) {
                li.remove();
            }
         }*/
    }
}
