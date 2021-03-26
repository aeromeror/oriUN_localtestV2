package com.oriun.oriun.Models;

import javax.persistence.*;


@Entity
@Table(name = "USER")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int ID_USER;

    private int ID_ROL;
    @Column(columnDefinition="text")
    private String USER_NAME;
    @Column(columnDefinition="text")
    private String PASSWORD;
    public UserModel() {
    }

    public UserModel(int id, int id_rol, String user_name, String password) {
        this.ID_USER = id;
        this.ID_ROL = id_rol;
        this.USER_NAME = user_name;
        this.PASSWORD = password;
    }
    public void setPassword(String PASSWORD){
        this.PASSWORD = PASSWORD;
    }

    public String getPassword(){
        return PASSWORD;
    }

    public int getId() {
        return ID_USER;
    }

    public void setId(int id) {
        this.ID_USER = id;
        
    }

    public String getName() {
        return USER_NAME;
    }

    public void setName(String name) {
        this.USER_NAME = name;
    }

    public int getRol() {
        return ID_ROL;
    }

    public void setRol(int rol) {
        this.ID_ROL = rol;
    }
    
}