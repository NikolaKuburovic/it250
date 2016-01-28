package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
import com.mycompany.methotels.services.SobaDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;


/**
 *
 * @author nikola kuburovic 1095
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})

public class DodavanjeSoba {

    @Property
    @Persist
    private Soba soba;
    
    @Property
    private Soba onesoba;
       
    @Inject
    private SobaDao sobaDao;
    
    @Property
    @Persist
    private List<Soba> sobe;

    
    void onActivate() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
        sobe = sobaDao.getListaSvihSoba();
    }
    @CommitAfter    
    Object onSuccess() {
        sobaDao.dodajIzmeniSobu(soba);
        soba = new Soba();
        return this;
    }
    @CommitAfter
    Object onActionFromDelete(int id) {
        sobaDao.obrisiSobu(id);
        return this;
    }
    
    @CommitAfter
    Object onActionFromEdit(Soba sobe) {
        soba = sobe;
        return this;
    }
    
    public JSONObject getOptions() {
        JSONObject json = new JSONObject();
        json.put("bJQueryUI", "true");
        json.put("bStateSave", true);
        json.put("bAutoWidth", true);
        return json;
    }

}
