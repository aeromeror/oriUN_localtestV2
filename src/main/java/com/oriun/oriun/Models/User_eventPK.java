package com.oriun.oriun.Models;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;
@Embeddable
public class User_eventPK implements Serializable{
    
    @Column(unique = true, nullable = false)
    private String USER_NAME;
    @Column(unique = true, nullable = false)
    private int ID_EVENT;

	public String getUSER_NAME() {
		return this.USER_NAME;
	}

	public void setUSER_NAME(String USER_NAME) {
		this.USER_NAME = USER_NAME;
	}

	public int getID_EVENT() {
		return this.ID_EVENT;
	}

	public void setID_EVENT(int ID_EVENT) {
		this.ID_EVENT = ID_EVENT;
	}


}