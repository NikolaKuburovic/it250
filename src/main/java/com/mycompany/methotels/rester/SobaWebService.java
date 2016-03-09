/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.rester;

import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.SobaDao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Path("/sobaservice")
public class SobaWebService implements SobaWebServiceInterface {

    @Inject
    private SobaDao sobaDao;

    @GET
    @Produces({"application/json"})
    @Override
    public List<Soba> getAll() {
        return (sobaDao.getListaSvihSoba());
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    @Override
    public Soba getSoba(@PathParam("id") Integer id) {
        return sobaDao.getSobaById(id);
    }

    @Override
    public Response post(Soba soba) {
        sobaDao.dodajSobu(soba);
        return Response.ok().entity(soba).build();
    }

}
