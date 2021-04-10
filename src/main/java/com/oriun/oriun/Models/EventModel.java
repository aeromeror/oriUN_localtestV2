package com.oriun.oriun.Models;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
@Entity
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer ID_EVENT;

    @Column(columnDefinition="text")
    private String USER_NAME;

    @Column(columnDefinition="text")
    private String NAME_LOC_SPORT;

    @Column(columnDefinition="text")
    private String NAME_SPORT;

    @Column(columnDefinition="text")
    private String EVENT_DESCRIPTION;

    private Date EVENT_INIT;

    private Date EVENT_END;

    private double CAPACITY;

    @Column(columnDefinition="text")
    private String OTHER_SPORT;

    private Time EVENT_INIT_HOUR;

    private Time EVENT_FINISH_HOUR;

    private String EVENT_TITLE;

	


    public EventModel() {
    }

    public EventModel(Integer ID_EVENT, String USER_NAME, String NAME_LOC_SPORT, String NAME_SPORT, String EVENT_DESCRIPTION, Date EVENT_INIT, Date EVENT_END, double CAPACITY, String OTHER_SPORT, Time EVENT_INIT_HOUR, Time EVENT_FINISH_HOUR) {
        this.ID_EVENT = ID_EVENT;
        this.USER_NAME = USER_NAME;
        this.NAME_LOC_SPORT = NAME_LOC_SPORT;
        this.NAME_SPORT = NAME_SPORT;
        this.EVENT_DESCRIPTION = EVENT_DESCRIPTION;
        this.EVENT_INIT = EVENT_INIT;
        this.EVENT_END = EVENT_END;
        this.CAPACITY = CAPACITY;
        this.OTHER_SPORT = OTHER_SPORT;
        this.EVENT_INIT_HOUR = EVENT_INIT_HOUR;
        this.EVENT_FINISH_HOUR = EVENT_FINISH_HOUR;
    }
    
    public String getEVENT_TITLE() {
		return this.EVENT_TITLE;
	}

	public void setEVENT_TITLE(String EVENT_TITLE) {
		this.EVENT_TITLE = EVENT_TITLE;
	}
    public Integer getID_EVENT() {
        return ID_EVENT;
    }

    public void setID_EVENT(Integer ID_EVENT) {
        this.ID_EVENT = ID_EVENT;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getNAME_LOC_SPORT() {
        return NAME_LOC_SPORT;
    }

    public void setNAME_LOC_SPORT(String NAME_LOC_SPORT) {
        this.NAME_LOC_SPORT = NAME_LOC_SPORT;
    }

    public String getNAME_SPORT() {
        return NAME_SPORT;
    }

    public void setNAME_SPORT(String NAME_SPORT) {
        this.NAME_SPORT = NAME_SPORT;
    }

    public String getEVENT_DESCRIPTION() {
        return EVENT_DESCRIPTION;
    }

    public void setEVENT_DESCRIPTION(String EVENT_DESCRIPTION) {
        this.EVENT_DESCRIPTION = EVENT_DESCRIPTION;
    }

    public Date getEVENT_INIT() {
        return EVENT_INIT;
    }

    public void setEVENT_INIT(Date EVENT_INIT) {
        this.EVENT_INIT = EVENT_INIT;
    }

    public Date getEVENT_END() {
        return EVENT_END;
    }

    public void setEVENT_END(Date EVENT_END) {
        this.EVENT_END = EVENT_END;
    }

    public double getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(double CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public String getOTHER_SPORT() {
        return OTHER_SPORT;
    }

    public void setOTHER_SPORT(String OTHER_SPORT) {
        this.OTHER_SPORT = OTHER_SPORT;
    }

    public Time getEVENT_INIT_HOUR() {
        return EVENT_INIT_HOUR;
    }

    public void setEVENT_INIT_HOUR(Time EVENT_INIT_HOUR) {
        this.EVENT_INIT_HOUR = EVENT_INIT_HOUR;
    }

    public Time getEVENT_FINISH_HOUR() {
        return EVENT_FINISH_HOUR;
    }

    public void setEVENT_FINISH_HOUR(Time EVENT_FINISH_HOUR) {
        this.EVENT_FINISH_HOUR = EVENT_FINISH_HOUR;
    }

    
    
}