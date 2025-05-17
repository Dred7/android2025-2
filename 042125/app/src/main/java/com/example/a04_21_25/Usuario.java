package com.example.a04_21_25;

import androidx.annotation.Nullable;

import java.util.Date;

public class Usuario {

    private String id;
    private String name;
    private String email;

    AuthToken authToken = null;

    public Usuario(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthToken(@Nullable AuthToken newToken){
        this.authToken = newToken;
    }

    public Boolean isExpired(){
        Date exp = usuario.authToken.expiration;
        Date now = new Date();
        long diff = exp.getTime() - now.getTime();
        return diff > 0;
    }
}
