package com.oriun.oriun.Models;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "element")
public class ElementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int ID_ELEMENT;
	@Column(columnDefinition="text")
    private String NAME_LOCATION;
	@Column(columnDefinition="text")
    private String NAME_SPORT;
    private boolean AVAILABLE;
    @Column(columnDefinition="text")
    private String DESCRIPTION;
    @Column(columnDefinition="text")
    private String ELEMENT_NAME;
	@Lob
    private byte[] ELEMENT_IMAGE;


	public int getID_ELEMENT() {
		return this.ID_ELEMENT;
	}

	public void setID_ELEMENT(int ID_ELEMENT) {
		this.ID_ELEMENT = ID_ELEMENT;
	}

	public String getNAME_LOCATION() {
		return this.NAME_LOCATION;
	}

	public void setNAME_LOCATION(String NAME_LOCATION) {
		this.NAME_LOCATION = NAME_LOCATION;
	}

	public String getNAME_SPORT() {
		return this.NAME_SPORT;
	}

	public void setNAME_SPORT(String NAME_SPORT) {
		this.NAME_SPORT = NAME_SPORT;
	}

	public boolean isAVAILABLE() {
		return this.AVAILABLE;
	}

	public void setAVAILABLE(boolean AVAILABLE) {
		this.AVAILABLE = AVAILABLE;
	}

	public String getDESCRIPTION() {
		return this.DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}

	public String getELEMENT_NAME() {
		return this.ELEMENT_NAME;
	}

	public void setELEMENT_NAME(String ELEMENT_NAME) {
		this.ELEMENT_NAME = ELEMENT_NAME;
	}

	public byte[] getELEMENT_IMAGE() {
		return this.ELEMENT_IMAGE;
	}

	public void setELEMENT_IMAGE(byte[] ELEMENT_IMAGE) {
		this.ELEMENT_IMAGE = ELEMENT_IMAGE;
	}

	public ElementModel(){
	}
    public ElementModel(int id_element,boolean available,String description,
    String element_name,String name_location,String name_sport,byte[] element_image){
        this.ID_ELEMENT=id_element;
        this.AVAILABLE=available;
        this.DESCRIPTION=description;
        this.ELEMENT_NAME=element_name;
		this.NAME_LOCATION=name_location;
		this.NAME_SPORT=name_sport;
		this.ELEMENT_IMAGE=element_image;
    }
	public ElementModel(int id_element,boolean available,String description,
						String element_name,String name_location,String name_sport){
		this.ID_ELEMENT=id_element;
		this.AVAILABLE=available;
		this.DESCRIPTION=description;
		this.ELEMENT_NAME=element_name;
		this.NAME_LOCATION=name_location;
		this.NAME_SPORT=name_sport;
	}

	

}