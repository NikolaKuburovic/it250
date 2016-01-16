/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Entity
@Table(name = "Drzava")
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d")})
public class Drzava implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Id
    @Basic(optional = false)
    @Column(name = "Ime")
    private String ime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drzIme")
    private List<Gost> gostList;

    @Inject
    public Drzava() {
    }

    public Drzava(String ime) {
        this.ime = ime;
    }

    public Drzava(String ime, int id) {
        this.ime = ime;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public List<Gost> getGostList() {
        return gostList;
    }

    public void setGostList(List<Gost> gostList) {
        this.gostList = gostList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ime != null ? ime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.ime == null && other.ime != null) || (this.ime != null && !this.ime.equals(other.ime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Drzava[ ime=" + ime + " ]";
    }

}
