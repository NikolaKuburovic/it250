/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Drzava;
import com.mycompany.methotels.entities.Gost;
import com.mycompany.methotels.services.DrzavaDao;
import com.mycompany.methotels.services.GostDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class DodavanjeGost {

    @Property
    @Persist
    private Gost gost;
    @Property
    private Gost onegost;
    @Inject
    private DrzavaDao drzaveDao;
    @Inject
    private GostDao gostiDao;
    @Property
    private Drzava drzId;
    @Property
    @Persist
    private List<Drzava> drzave;

    public ValueEncoder getEncoder() {
        return new ValueEncoder<Drzava>() {
            @Override
            public String toClient(Drzava v) {
                return String.valueOf(v.getId());
            }

            @Override
            public Drzava toValue(String string) {
                Drzava drz = drzaveDao.getDrzavaById(Integer.parseInt(string));
                return drz;
            }
        };
    }
    @Property
    private List<Gost> gosti;

    
        
    void onActivate() {
        gost = new Gost();
        if (gosti == null) {
            gosti = new ArrayList<Gost>();
        }
        gosti = gostiDao.getListaSvihGostiju();
        drzave = drzaveDao.getListaSvihDrzava();
    }

    
    @CommitAfter
    Object onSuccess() {
        gost.setDrzID(drzId);
        gostiDao.dodajIzmeniGost(gost);
        gost = new Gost();
        return this;
    }

    public String getDrzava() {
        if (onegost.getDrzID() != null) {
            return onegost.getDrzID().getIme();
        } else {
                return "";
        }
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        gostiDao.obrisiGosta(id);
        return this;
    }
    
    @CommitAfter
    Object onActionFromEdit(Gost gosti) {
        gost = gosti;
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
