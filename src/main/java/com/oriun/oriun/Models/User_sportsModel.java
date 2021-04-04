package com.oriun.oriun.Models;

import javax.persistence.*;


@Entity
@Table(name = "user_sports")
public class User_sportsModel{
    @EmbeddedId
    private User_sportsPK user_sportsPK;

    public String getUSER_NAME() {
		return this.user_sportsPK.getUSER_NAME();
	}

	public void setUSER_NAME(String USER_NAME) {
		this.user_sportsPK.setUSER_NAME(USER_NAME);;
	}
    
	public String getNAME_SPORT() {
		return this.user_sportsPK.getNAME_SPORT();
	}

	public void setNAME_SPORT(String NAME_SPORT) {
		this.user_sportsPK.setNAME_SPORT(NAME_SPORT);;
	}

}