package com.oriun.oriun.Models;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;
@Embeddable
public class User_sportsPK implements Serializable{
    
    @Column(unique = true, nullable = false)
    private String USER_NAME;
    @Column(unique = true, nullable = false)
    private String NAME_SPORT;
	
	public String getNAME_SPORT() {
		return this.NAME_SPORT;
	}

	public void setNAME_SPORT(String NAME_SPORT) {
		this.NAME_SPORT = NAME_SPORT;
	}


	public String getUSER_NAME() {
		return this.USER_NAME;
	}

	public void setUSER_NAME(String USER_NAME) {
		this.USER_NAME = USER_NAME;
	}

	


}