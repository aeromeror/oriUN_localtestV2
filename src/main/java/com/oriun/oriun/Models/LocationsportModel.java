package com.oriun.oriun.Models;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "location_sport")
public class LocationsportModel {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String name_loc_sport;

    public LocationsportModel(String name_loc_sport){
            this.name_loc_sport=name_loc_sport;
    }

	public String getName_loc_sport() {
		return this.name_loc_sport;
	}

	public void setName_loc_sport(String name_loc_sport) {
		this.name_loc_sport = name_loc_sport;
	}

    

	

}