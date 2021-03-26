package com.oriun.oriun.Models;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "element")
public class ElementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_element;
    private boolean available;
    @Column(columnDefinition="text")
    private String description;
    @Column(columnDefinition="text")
    private String element_name;
    private Blob element_image;

    public ElementModel(int id_element,boolean available,String description,
    String element_name,Blob element_image){
        this.id_element=id_element;
        this.available=available;
        this.description=description;
        this.element_name=element_name;
        this.element_image=element_image;
    }

	public int getId_element() {
		return this.id_element;
	}

	public void setId_element(int id_element) {
		this.id_element = id_element;
	}

	public boolean isAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getElement_name() {
		return this.element_name;
	}

	public void setElement_name(String element_name) {
		this.element_name = element_name;
	}

	public Blob getElement_image() {
		return this.element_image;
	}

	public void setElement_image(Blob element_image) {
		this.element_image = element_image;
	}


}