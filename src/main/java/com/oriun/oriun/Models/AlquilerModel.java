package com.oriun.oriun.Models;
import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "alquiler")
public class AlquilerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer ID_RENT;
    @Column(columnDefinition="text")
    private String USER_NAME;
    private int ID_ELEMENT;
    private Date RENT_DATE;
    private Time RENT_TIME;
    private Time RENT_DURATION;


    public AlquilerModel(int id_rent, String user_name, int id_element, Date rent_date) {
        this.ID_RENT = id_rent;
        this.USER_NAME = user_name;
        this.ID_ELEMENT = id_element;
        this.RENT_DATE = rent_date;
    }
    public AlquilerModel() {
    }

    public Time getRENT_TIME() {
        return this.RENT_TIME;
    }

    public void setRENT_TIME(Time RENT_TIME) {
        this.RENT_TIME = RENT_TIME;
    }

    public Time getRENT_DURATION() {
        return this.RENT_DURATION;
    }

    public void setRENT_DURATION(Time RENT_DURATION) {
        this.RENT_DURATION = RENT_DURATION;
    }
    
    public Integer getID_RENT() {
        return ID_RENT;
    }
    public void setID_RENT(Integer ID_RENT) {
        this.ID_RENT = ID_RENT;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }
    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public int getID_ELEMENT() {
        return ID_ELEMENT;
    }
    public void setID_ELEMENT(int ID_ELEMENT) {
        this.ID_ELEMENT = ID_ELEMENT;
    }

    public Date getRENT_DATE() {
        return RENT_DATE;
    }
    public void setRENT_DATE(Date RENT_DATE) {
        this.RENT_DATE = RENT_DATE;
    }
}
