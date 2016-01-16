/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Drzava;
import java.util.List;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface DrzavaDao {

    public List<Drzava> getListaSvihDrzava();

    public Drzava getDrzavaById(Integer id);

    public void dodajDrzavu(Drzava drzava);

    public void obrisiDrzavu(Integer id);

}
