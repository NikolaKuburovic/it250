/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Drzava;
import com.mycompany.methotels.services.DrzavaDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class DodavanjeDrzava {

    @Property
    @Persist
    private Drzava drzava;
    @Property
    private Drzava onedrzava;
    @Inject
    private DrzavaDao drzaveDao;
    @Property
    private List<Drzava> drzave;

    void onActivate() {
        if (drzave == null) {
            drzave = new ArrayList<Drzava>();
        }
        drzave = drzaveDao.getListaSvihDrzava();
    }

    @CommitAfter
    Object onSuccess() {
        drzaveDao.dodajIzmeniDrzavu(drzava);
        drzava = new Drzava();
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        drzaveDao.obrisiDrzavu(id);
        return this;
    }

    @CommitAfter
    Object onActionFromEdit(Drzava drzave) {
        drzava = drzave;
        return this;
    }

    public JSONObject getOptions() {
        JSONObject json = new JSONObject();
        json.put("bJQueryUI", "true");
        json.put("bStateSave", true);
        json.put("bAutoWidth", true);
        return json;
    }

}
