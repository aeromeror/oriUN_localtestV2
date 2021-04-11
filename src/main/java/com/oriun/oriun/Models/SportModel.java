package com.oriun.oriun.Models;

import javax.persistence.*;


@Entity
@Table(name = "sports")
public class SportModel {

    @Id
    @Column(columnDefinition="text", unique = true, nullable = false)
    private String NAME_SPORT;

    public SportModel() {
    }

    public SportModel(String name) {
        this.NAME_SPORT = name;
    }

    public String getNAME_SPORT() {
        return NAME_SPORT;
    }

    public void setNAME_SPORT(String name) {
        this.NAME_SPORT = name;
    }
    
}