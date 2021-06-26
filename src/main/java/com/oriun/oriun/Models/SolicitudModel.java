package com.oriun.oriun.Models;

import javax.persistence.*;

@Entity
@Table(name = "solicitud")
public class SolicitudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer ID_SOLICITUD;
    @Column(columnDefinition="text")
    private String USER_NAME;
    @Column(columnDefinition="text")
    private String SOLICITUD;

    public SolicitudModel() {
    }
    public SolicitudModel(String USER_NAME, String SOLICITUD) {
        this.USER_NAME = USER_NAME;
        this.SOLICITUD = SOLICITUD;
    }

    public void setID_SOLICITUD(Integer ID_SOLICITUD) {
        this.ID_SOLICITUD = ID_SOLICITUD;
    }
    public String getUSER_NAME() {
        return USER_NAME;
    }
    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }
    public String getSOLICITUD() {
        return SOLICITUD;
    }
    public void setSOLICITUD(String SOLICITUD) {
        this.SOLICITUD = SOLICITUD;
    }
}
