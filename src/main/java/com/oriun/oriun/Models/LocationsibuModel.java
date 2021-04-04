package com.oriun.oriun.Models;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "locationsibu")
public class LocationsibuModel {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String NAME_LOCATION;
    private boolean OPEN;
    private Blob IMAGE_LOCATION;

	public String getNAME_LOCATION() {
		return this.NAME_LOCATION;
	}

	public void setNAME_LOCATION(String NAME_LOCATION) {
		this.NAME_LOCATION = NAME_LOCATION;
	}

	public boolean isOPEN() {
		return this.OPEN;
	}

	public void setOPEN(boolean OPEN) {
		this.OPEN = OPEN;
	}

	public Blob getIMAGE_LOCATION() {
		return this.IMAGE_LOCATION;
	}

	public void setIMAGE_LOCATION(Blob IMAGE_LOCATION) {
		this.IMAGE_LOCATION = IMAGE_LOCATION;
	}


    public LocationsibuModel(String name_loc_sport, boolean open , Blob image){
            this.NAME_LOCATION=name_loc_sport;
            this.OPEN=open;
            this.IMAGE_LOCATION=image;
    }

	
    

	

}