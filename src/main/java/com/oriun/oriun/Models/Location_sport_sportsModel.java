package com.oriun.oriun.Models;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "location_sport_sports")
public class Location_sport_sportsModel {
    @EmbeddedId
    private Location_sportsPK location_sportsPK;

	public String getNAME_LOC_SPORT() {
		return this.location_sportsPK.getNAME_LOC_SPORT();
	}

	public void setNAME_LOC_SPORT(String NAME_LOC_SPORT) {
		this.location_sportsPK.setNAME_LOC_SPORT(NAME_LOC_SPORT); 
	}
	
	public String getNAME_SPORT() {
		return this.location_sportsPK.getNAME_SPORT();
	}

	public void setNAME_SPORT(String NAME_SPORT) {
		this.location_sportsPK.setNAME_SPORT(NAME_SPORT);
	}


    public Location_sport_sportsModel(Location_sportsPK loc_sportPK){
            this.location_sportsPK=loc_sportPK;
    }

	
}