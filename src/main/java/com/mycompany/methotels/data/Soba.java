/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.data;

import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class Soba {

    private String imeSobe;
    private String sprat;
    private String tv;
    private String internet;
    private String djakuzi;

    @Inject
    public Soba() {

    }

    public Soba(String imeSobe, String sprat, String tv, String internet,
            String djakuzi) {
        this.imeSobe = imeSobe;
        this.sprat = sprat;
        this.tv = tv;
        this.internet = internet;
        this.djakuzi = djakuzi;
    }

    /**
     * @return the imeSobe
     */
    public String getImeSobe() {
        return imeSobe;
    }

    /**
     * @param imeSobe the imeSobe to set
     */
    public void setImeSobe(String imeSobe) {
        this.imeSobe = imeSobe;
    }

    /**
     * @return the sprat
     */
    public String getSprat() {
        return sprat;
    }

    /**
     * @param sprat the sprat to set
     */
    public void setSprat(String sprat) {
        this.sprat = sprat;
    }

    /**
     * @return the tv
     */
    public String getTv() {
        return tv;
    }

    /**
     * @param tv the tv to set
     */
    public void setTv(String tv) {
        this.tv = tv;
    }

    /**
     * @return the internet
     */
    public String getInternet() {
        return internet;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(String internet) {
        this.internet = internet;
    }

    /**
     * @return the djakuzi
     */
    public String getDjakuzi() {
        return djakuzi;
    }

    /**
     * @param djakuzi the djakuzi to set
     */
    public void setDjakuzi(String    djakuzi) {
        this.djakuzi = djakuzi;
    }

}
