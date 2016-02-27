package com.mycompany.methotels.pages;

import com.mycompany.methotels.components.GenericEditor;
import com.mycompany.methotels.data.Rezervacija;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.GenericDao;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.got5.tapestry5.jquery.components.InPlaceEditor;

/**
 *
 * @author Nikola Kuburovic 1095
 */
/*@ProtectedPage
 @RolesAllowed(value={"Admin"})*/
public class DodavanjeSoba {

    @Property
    @Persist
    private Soba soba;

    @Property
    private Soba onesoba;

    @Inject
    private GenericDao genericDao;

    @Property
    private List<Soba> sobe;

    @InjectComponent
    private Zone zoneSobe;

    @InjectComponent
    private Zone formZone;

    @Inject
    private Request request;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    @Inject
    private ComponentResources _componentResources;

    @Property
    private Class cls;

    public DodavanjeSoba() {
        cls = Soba.class;
    }

    void onActivate() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
        sobe = genericDao.loadAllActive(cls);
    }

    @CommitAfter
    Object onSuccess() {
        genericDao.merge(soba);
        sobe = genericDao.loadAllActive(cls);
        soba = new Soba();
        if (request.isXHR()) {
            ajaxResponseRenderer.addRender(zoneSobe).addRender(formZone);
        }
        return request.isXHR() ? zoneSobe.getBody() : null;
    }

    @CommitAfter
    @OnEvent(component = "ime", value = InPlaceEditor.SAVE_EVENT)
    void setIme(Long id, String value) {
        Soba soba = (Soba) genericDao.getElementById(id.intValue(), cls);
        soba.setIme(value);
        System.out.println("cuvam sobu");
        genericDao.merge(soba);
    }

    @CommitAfter
    @OnEvent(component = "sprat", value = InPlaceEditor.SAVE_EVENT)
    void setSprat(Long id, int value) {
        Soba soba = (Soba) genericDao.getElementById(id.intValue(), cls);
        soba.setSprat(value);
        System.out.println("cuvam sobu");
        genericDao.merge(soba);
    }

    @CommitAfter
    @OnEvent(component = "tv", value = InPlaceEditor.SAVE_EVENT)
    void setTv(Long id, String value) {
        Soba soba = (Soba) genericDao.getElementById(id.intValue(), cls);
        soba.setTv(value);
        System.out.println("cuvam sobu");
        genericDao.merge(soba);
    }

    @CommitAfter
    @OnEvent(component = "internet", value = InPlaceEditor.SAVE_EVENT)
    void setInternet(Long id, String value) {
        Soba soba = (Soba) genericDao.getElementById(id.intValue(), cls);
        soba.setInternet(value);
        System.out.println("cuvam sobu");
        genericDao.merge(soba);
    }

    @CommitAfter
    @OnEvent(component = "djakuzi", value = InPlaceEditor.SAVE_EVENT)
    void setDjakuzi(Long id, String value) {
        Soba soba = (Soba) genericDao.getElementById(id.intValue(), cls);
        soba.setDjakuzi(value);
        System.out.println("cuvam sobu");
        genericDao.merge(soba);
    }

    @CommitAfter
    @OnEvent(component = "rezervacija", value = InPlaceEditor.SAVE_EVENT)
    void setRezervacija(Long id, Rezervacija value) {
        Soba soba = (Soba) genericDao.getElementById(id.intValue(), cls);
        soba.setRezervacija(value);
        System.out.println("cuvam sobu");
        genericDao.merge(soba);
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        genericDao.delete(id, cls);
        sobe = genericDao.loadAllActive(cls);
        return request.isXHR() ? zoneSobe.getBody() : null;

    }

    @CommitAfter
    Object onActionFromEdit(Soba sobe) {
        soba = sobe;
        return request.isXHR() ? formZone.getBody() : null;

    }
}
