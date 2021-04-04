package com.oriun.oriun.Models;

import javax.persistence.*;


@Entity
@Table(name = "user_event")
public class User_eventModel{
    @EmbeddedId
    private User_eventPK user_eventPK;

    public String getUSER_NAME() {
		return this.user_eventPK.getUSER_NAME();
	}

	public void setUSER_NAME(String USER_NAME) {
		this.user_eventPK.setUSER_NAME(USER_NAME);;
	}
    
	public int getID_EVENt() {
		return this.user_eventPK.getID_EVENt();
	}

	public void setID_EVENt(int ID_EVENt) {
		this.user_eventPK.setID_EVENt(ID_EVENt);
	}

}