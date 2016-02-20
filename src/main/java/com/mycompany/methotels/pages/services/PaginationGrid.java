/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages.services;

import com.mycompany.methotels.entities.AbstractEntity;
import com.mycompany.methotels.services.GenericDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.TextStreamResponse;

/**
 *
 * @author Nikola Kuburovic 1095
 * @param <T>
 */
public class PaginationGrid<T extends AbstractEntity> {

    @Inject
    private GenericDao genericDao;
    private int size = 10;

    Object onActivate(@RequestParameter("page") int page) {
        
        Class<?> act = null;
        
        int sizeOfAll = genericDao.allActiveSize();
        
        List<AbstractEntity> lista = new ArrayList();
        
        String response = "<table class=\"navigation\" >" 
                + "<th>\n"
                + "Ime\n"
                + " </th>\n"
                + " ";
        lista = genericDao.loadActiveFromTo(page);
        
        if( lista.isEmpty()){
            
        }
        for (AbstractEntity d : lista) {
            response += ("<tr>\n"
                    + "<td>" + d.toString() + " </td>\n"
                    + "</tr>");
        }
        response += "</table>";
        
        float ceil = (float) sizeOfAll / (float) 10;
        
        int totalPageSizes = (int) Math.ceil(ceil);
        
        response += "<ul class=\"pagination\">";
        
        for (int i = 1; i <= totalPageSizes; i++) {
            if (page == i) {
                response += ("<li class=\"callservice active\"><a href=\"#\">" + i + "</a></li>\n");
            } else {
                response += ("<li class=\"callservice\"><a href=\"#\">" + i + "</a></li>\n");
            }
        }
        response += "</ul>";
        
        return new TextStreamResponse("text/plain", response);
    }
}
