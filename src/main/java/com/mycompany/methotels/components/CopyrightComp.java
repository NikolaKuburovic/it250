/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.components;

import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class CopyrightComp {

    @Inject
    public CopyrightComp(){
        
    }
    public String getCopyright() {
        return  "images/nk1095.png";
    }

}
