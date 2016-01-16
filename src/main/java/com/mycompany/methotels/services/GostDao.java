/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Gost;
import java.util.List;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface GostDao {

    public List<Gost> getListaSvihGostiju();

    public Gost getGostById(Integer id);

    public void dodajGosta(Gost gost);

    public void obrisiGosta(Integer id);
}
