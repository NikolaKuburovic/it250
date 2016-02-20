/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import com.mycompany.methotels.data.Rezervacija;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;  
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Entity
@Table(name = "soba")
@NamedQueries({
    @NamedQuery(name = "Soba.findAll", query = "SELECT s FROM Soba s")})
public class Soba extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /*@Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;*/
    @Basic(optional = false)
    @Column(name = "Ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "Sprat")
    private int sprat;
    @Basic(optional = false)
    @Column(name = "TV")
    private String tv;
    @Basic(optional = false)
    @Column(name = "Internet")
    private String internet;
    @Basic(optional = false)
    @Column(name = "Djakuzi")
    private String djakuzi;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "Rezervacija")
    private Rezervacija rezervacija;

    @Inject
    public Soba() {
    }

    public Soba(Integer iDSoba) {
        this.id = iDSoba;
    }

    public Soba(Integer iDSoba, String ime, int sprat, String tv, String internet, String djakuzi, Rezervacija rezervacija) {
        this.id = iDSoba;
        this.ime = ime;
        this.sprat = sprat;
        this.tv = tv;
        this.internet = internet;
        this.djakuzi = djakuzi;
        this.rezervacija = rezervacija;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer iDSoba) {
        this.id = iDSoba;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getDjakuzi() {
        return djakuzi;
    }

    public void setDjakuzi(String djakuzi) {
        this.djakuzi = djakuzi;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        /*return "com.mycompany.methotels.entities.Soba[ iDSoba=" + id + " ]";*/
        return getIme();
    }
    
}
