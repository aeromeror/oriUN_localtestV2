package com.oriun.oriun.Models;

import javax.persistence.*;


@Entity
@Table(name = "SPORTS")
public class SportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition="text", unique = true, nullable = false)
    private String NAME_SPORT;

    public SportModel() {
    }

    public SportModel(String name) {
        this.NAME_SPORT = name;
    }

    public String getName() {
        return NAME_SPORT;
    }

    public void setName(String name) {
        this.NAME_SPORT = name;
    }
    
}