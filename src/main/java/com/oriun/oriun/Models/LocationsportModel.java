package com.oriun.oriun.Models;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "location_sport")
public class LocationsportModel {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String NAME_LOC_SPORT;
    public LocationsportModel(){
    }
    public LocationsportModel(String name_loc_sport){
            this.NAME_LOC_SPORT=name_loc_sport;
    }

	public String getNAME_LOC_SPORT() {
		return this.NAME_LOC_SPORT;
	}

	public void setNAME_LOC_SPORT(String name_loc_sport) {
		this.NAME_LOC_SPORT = name_loc_sport;
	}

    

	

}