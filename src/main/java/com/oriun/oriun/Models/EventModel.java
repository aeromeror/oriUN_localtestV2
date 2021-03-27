package com.oriun.oriun.Models;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name = "EVENT")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int ID_EVENT;

    @Column(columnDefinition="text")
    private String USER_NAME;

    @Column(columnDefinition="text")
    private String NAME_LOC_SPORT;

    @Column(columnDefinition="text")
    private String NAME_SPORT;

    @Column(columnDefinition="text")
    private String EVENT_DESCRIPTION;

    private LocalDate EVENT_INIT;

    private LocalDate EVENT_END;

    private double CAPACITY;

    @Column(columnDefinition="text")
    private String OTHER_SPORT;


    private LocalDateTime EVENT_INIT_HOUR;

    private LocalDateTime EVENT_FINISH_HOUR;

    public EventModel() {
    }

    public EventModel(int ID_EVENT, String USER_NAME, String NAME_LOC_SPORT, String NAME_SPORT, String EVENT_DESCRIPTION, LocalDate EVENT_INIT, LocalDate EVENT_END, double CAPACITY, String OTHER_SPORT, LocalDateTime EVENT_INIT_HOUR, LocalDateTime EVENT_FINISH_HOUR) {
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

    public int getID_EVENT() {
        return ID_EVENT;
    }

    public void setID_EVENT(int ID_EVENT) {
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

    public LocalDate getEVENT_INIT() {
        return EVENT_INIT;
    }

    public void setEVENT_INIT(LocalDate EVENT_INIT) {
        this.EVENT_INIT = EVENT_INIT;
    }

    public LocalDate getEVENT_END() {
        return EVENT_END;
    }

    public void setEVENT_END(LocalDate EVENT_END) {
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

    public LocalDateTime getEVENT_INIT_HOUR() {
        return EVENT_INIT_HOUR;
    }

    public void setEVENT_INIT_HOUR(LocalDateTime EVENT_INIT_HOUR) {
        this.EVENT_INIT_HOUR = EVENT_INIT_HOUR;
    }

    public LocalDateTime getEVENT_FINISH_HOUR() {
        return EVENT_FINISH_HOUR;
    }

    public void setEVENT_FINISH_HOUR(LocalDateTime EVENT_FINISH_HOUR) {
        this.EVENT_FINISH_HOUR = EVENT_FINISH_HOUR;
    }

    
    
}