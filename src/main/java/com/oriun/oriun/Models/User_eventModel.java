package com.oriun.oriun.Models;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "user_event")
public class User_eventModel implements Serializable{
    @EmbeddedId
    private User_eventPK user_eventPK;

    public String getUSER_NAME() {
		return this.user_eventPK.getUSER_NAME();
	}

	public void setUSER_NAME(String USER_NAME) {
		this.user_eventPK.setUSER_NAME(USER_NAME);;
	}
    
	public int getID_EVENT() {
		return this.user_eventPK.getID_EVENT();
	}

	public void setID_EVENT(int ID_EVENT) {
		this.user_eventPK.setID_EVENT(ID_EVENT);
	}

}