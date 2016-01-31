package com.mycompany.methotels.pages;

import com.mycompany.methotels.components.GenericEditor;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
import javax.annotation.security.RolesAllowed;


/**
 *
 * @author Nikola Kuburovic 1095
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})

public class DodavanjeSoba extends GenericEditor<Soba>{

}
