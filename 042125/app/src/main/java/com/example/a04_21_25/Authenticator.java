package com.example.a04_21_25;

import java.util.Date;
import java.util.Random;

public class Authenticator {
    private static Authenticator instance = null;
    private Authenticator(){

    }

    public static Authenticator getInstance(){
        if (instance == null){
            instance = new Authenticator();
        }
        return instance;
    }

    public Boolean isLogged(Usuario usuario){
        if (usuario.authToken == null){
            return false;
        }

    }
    public void logIn(Usuario usuario){
        String id = String.valueOf(new Random().nextLong());
        Date expiration = new Date(System.currentTimeMillis() + 10000000000000);
        usuario.setAuthToken(new AuthToken(id, expiration));
        return usuario;
    }
    public void logOut(Usuario usuario){
        usuario.setAuthToken(null);
    }
}
