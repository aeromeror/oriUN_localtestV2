package com.oriun.oriun.Models;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;
@Embeddable
public class Location_sportsPK implements Serializable{
    
    @Column(unique = true, nullable = false)
    private String NAME_LOC_SPORT;
    @Column(unique = true, nullable = false)
    private String NAME_SPORT;

	public String getNAME_LOC_SPORT() {
		return this.NAME_LOC_SPORT;
	}

	public void setNAME_LOC_SPORT(String NAME_LOC_SPORT) {
		this.NAME_LOC_SPORT = NAME_LOC_SPORT;
	}

	public String getNAME_SPORT() {
		return this.NAME_SPORT;
	}

	public void setNAME_SPORT(String NAME_SPORT) {
		this.NAME_SPORT = NAME_SPORT;
	}


}