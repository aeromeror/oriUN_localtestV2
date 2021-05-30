package com.oriun.oriun.Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ElementoDTO {
    private int ID_ELEMENT;
    private String ELEMENT_NAME;

    public int getID_ELEMENT() {
        return ID_ELEMENT;
    }
    public void setID_ELEMENT(int ID_ELEMENT) {
        this.ID_ELEMENT = ID_ELEMENT;
    }
    public String getELEMENT_NAME() {
        return ELEMENT_NAME;
    }
    public void setELEMENT_NAME(String ELEMENT_NAME) {
        this.ELEMENT_NAME = ELEMENT_NAME;
    }

    public ElementoDTO(int ID_ELEMENT, String ELEMENT_NAME) {
        super();
        this.ID_ELEMENT = ID_ELEMENT;
        this.ELEMENT_NAME = ELEMENT_NAME;
    }
}
