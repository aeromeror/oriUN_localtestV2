package com.oriun.oriun.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name = "notifications")
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int ID_NOTIFICATION;

    @Column(columnDefinition="text")
    private String USER_NAME;

    @Column(columnDefinition="text")
    private String NAME_SPORT;
    
    private int ID_EVENT;
    
    private LocalDate NOTIFICATION_DATE;
    
    private LocalDateTime TIME_NOTIFICATION;
    
    private LocalDateTime EXPIRATION_TIME;

    @Column(columnDefinition="text")
    private String NOTIFICATION_DESCRIPTION;

    public NotificationModel() {
    }

    public NotificationModel(int ID_NOTIFICATION, String USER_NAME, String NAME_SPORT, int ID_EVENT, LocalDate NOTIFICATION_DATE, LocalDateTime TIME_NOTIFICATION, LocalDateTime EXPIRATION_TIME, String NOTIFICATION_DESCRIPTION) {
        this.ID_NOTIFICATION = ID_NOTIFICATION;
        this.USER_NAME = USER_NAME;
        this.NAME_SPORT = NAME_SPORT;
        this.ID_EVENT = ID_EVENT;
        this.NOTIFICATION_DATE = NOTIFICATION_DATE;
        this.TIME_NOTIFICATION = TIME_NOTIFICATION;
        this.EXPIRATION_TIME = EXPIRATION_TIME;
        this.NOTIFICATION_DESCRIPTION = NOTIFICATION_DESCRIPTION;
    }

    public int getID_NOTIFICATION() {
        return ID_NOTIFICATION;
    }

    public void setID_NOTIFICATION(int ID_NOTIFICATION) {
        this.ID_NOTIFICATION = ID_NOTIFICATION;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getNAME_SPORT() {
        return NAME_SPORT;
    }

    public void setNAME_SPORT(String NAME_SPORT) {
        this.NAME_SPORT = NAME_SPORT;
    }

    public int getID_EVENT() {
        return ID_EVENT;
    }

    public void setID_EVENT(int ID_EVENT) {
        this.ID_EVENT = ID_EVENT;
    }

    public LocalDate getNOTIFICATION_DATE() {
        return NOTIFICATION_DATE;
    }

    public void setNOTIFICATION_DATE(LocalDate NOTIFICATION_DATE) {
        this.NOTIFICATION_DATE = NOTIFICATION_DATE;
    }

    public LocalDateTime getTIME_NOTIFICATION() {
        return TIME_NOTIFICATION;
    }

    public void setTIME_NOTIFICATION(LocalDateTime TIME_NOTIFICATION) {
        this.TIME_NOTIFICATION = TIME_NOTIFICATION;
    }

    public LocalDateTime getEXPIRATION_TIME() {
        return EXPIRATION_TIME;
    }

    public void setEXPIRATION_TIME(LocalDateTime EXPIRATION_TIME) {
        this.EXPIRATION_TIME = EXPIRATION_TIME;
    }

    public String getNOTIFICATION_DESCRIPTION() {
        return NOTIFICATION_DESCRIPTION;
    }

    public void setNOTIFICATION_DESCRIPTION(String NOTIFICATION_DESCRIPTION) {
        this.NOTIFICATION_DESCRIPTION = NOTIFICATION_DESCRIPTION;
    }
    
    
    
    
}
