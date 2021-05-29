package com.oriun.oriun.Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface ElementBasic {
    int getID_ELEMENT();
    String getELEMENT_NAME();
    String getNAME_LOCATION();
    /*private int ID_ELEMENT;
    private String ELEMENT_NAME;
    private String NAME_LOCATION;
    ElementBasic(int ID_ELEMENT, String ELEMENT_NAME,String NAME_LOCATION) {
        //super();
        this.ID_ELEMENT = ID_ELEMENT;
        this.ELEMENT_NAME = ELEMENT_NAME;
        this.NAME_LOCATION = NAME_LOCATION;
    }

    public String getNAME_LOCATION() {
        return this.NAME_LOCATION;
    }
    public String getELEMENT_NAME() {
        return this.ELEMENT_NAME;
    }

    public int getID_ELEMENT() {
        return this.ID_ELEMENT;
    }

    /*public void setID_ELEMENT(int ID_ELEMENT) {
        this.ID_ELEMENT = ID_ELEMENT;
    }
    /*public void setELEMENT_NAME(String ELEMENT_NAME) {
        this.ELEMENT_NAME = ELEMENT_NAME;
    }*/
}
