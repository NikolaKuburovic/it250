/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import com.mycompany.methotels.data.Role;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author ubuntu
 */
@Entity
@XmlRootElement
@Table(name = "User")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "User_ID")
    private Integer userID;
    @Basic(optional = false)
    @Column(name = "User_name")
    private String username;
    @XmlTransient
    @Basic(optional = false)
    @Column(name = "User_password")
    private String userpassword;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "User_rola")
    private Role userrola;
    @Column(name = "FACEBOOK_ID")
    private String facebookId;

    @Inject
    public User() {
    }

    public User(Integer userID) {
        this.userID = userID;
    }
    
    public User(String username, String userpassword, Role userrola, String facebookId
) {
        this.username = username;
        this.userpassword = userpassword;
        this.userrola = userrola;
        this.facebookId = facebookId;

    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Role getUserrola() {
        return userrola;
    }

    public void setUserrola(Role userrola) {
        this.userrola = userrola;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.User[ userID=" + userID + " ]";
    }

}
