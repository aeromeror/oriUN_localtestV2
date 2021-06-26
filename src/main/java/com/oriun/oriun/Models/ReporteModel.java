package com.oriun.oriun.Models;

import javax.persistence.*;
@Entity
@Table(name = "reporte")
public class ReporteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer ID_REPORTE;
    private Integer ID_EVENT;
    @Column(columnDefinition="text")
    private String USER_NAME;

    public ReporteModel() {
    }

    public ReporteModel(Integer ID_EVENT, String USER_NAME) {
        this.ID_EVENT = ID_EVENT;
        this.USER_NAME = USER_NAME;
    }

    public Integer getID_REPORTE() {
        return ID_REPORTE;
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
}
