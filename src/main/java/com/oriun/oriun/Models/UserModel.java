package com.oriun.oriun.Models;

import javax.persistence.*;


@Entity
@Table(name = "USER")
public class UserModel {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition="text", unique = true, nullable = false)
    private String USER_NAME;

    @Column(columnDefinition="text")
    private String ROL_NAME;
    @Column(columnDefinition="text")
    private String PASSWORD;

    private String TOKEN;

    public UserModel() {
    }

    public UserModel(String user_name,String rol_name, String password) {
        this.USER_NAME = user_name;
        this.ROL_NAME = rol_name;
        this.PASSWORD = password;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getROL_NAME() {
        return ROL_NAME;
    }

    public void setROL_NAME(String ROL_NAME) {
        this.ROL_NAME = ROL_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN= TOKEN;
    }
    public String getTOKEN() {
        return TOKEN;
    }
    
    
    
}