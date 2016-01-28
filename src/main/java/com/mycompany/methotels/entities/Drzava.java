/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author ubuntu
 */
@Entity
@Table(name = "Drzava")
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d")})
public class Drzava extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /*@Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;*/
    @Basic(optional = false)
    @Column(name = "Ime")
    private String ime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drzID")
    private List<Gost> gostList;

    @Inject
    public Drzava() {
    }

    public Drzava(Integer id) {
        this.id = id;
    }

    public Drzava(Integer id, String ime) {
        this.id = id;
        this.ime = ime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Drzava[ id=" + id + " ]";
    }
    
}
