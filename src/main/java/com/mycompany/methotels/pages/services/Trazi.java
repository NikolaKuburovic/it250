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
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.util.TextStreamResponse;

/**
 *
 * @author Nikola Kuburovic 1095
 * @param <T>
 */
public class Trazi <T extends AbstractEntity> {

    @Inject
    private Request request;
    @Property
    private List<T> lista;
    @Property
    private T t;
    @Inject
    private GenericDao genericDao;

    Object onActivate(@RequestParameter("ime") String ime) {
        if (lista == null) {
            lista = new ArrayList<T>();
        }
        String response = "<table class=\"navigation\" > <th>\n"
                + "Ime\n" + " </th>\n"+ " ";
        lista = genericDao.getElementsByNames(ime);
        for (T lst : lista) {
            response += (" <tr>\n"
                    +"<td> " + lst.toString() + " </td>\n"
                    +"</tr>");
}
        response += "</table>";
        return new TextStreamResponse("text/plain", response);
    }

}
