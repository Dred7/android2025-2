package com.example.a04_21_25;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

public class AuthTest {
    static Usuario create(){
        Random random = new Random();
        String id = String.valueOf(random.nextLong());
        String id2 = String.valueOf(random.nextLong());
        Date exp = new Date();
        AuthToken token = new AuthToken(id2,exp);
        return new Usuario(id, "Mario","c@gmail.com",token);
    }

    @Test
    public void testUser(){

        Usuario usuario = new Usuario();

        Assert.assertEquals(usuario.getName(),"Mario");
        Assert.assertEquals(usuario.getEmail(),"c@gmail.com");
        Assert.assertNotNull(usuario.authToken);
    }
    @Test
    public void testTokenExpired(){


    }

    @Test
    public void testTokenNotExpired(){

    }

    @Test
    public void testTokenSuccess(){

    }
    @Test
    public void testUserIsLogged(){
        Usuario usuario = AuthTest.create();
        Authenticator.getInstance().logIn(usuario);
        Assert.assertTrue(Authenticator.getInstance().isLogged(usuario));

    }
    @Test
    public void testUserIsNotLogged(){
        Usuario usuario = AuthTest.create();
        Assert.assertFalse(Authenticator.getInstance().isLogged(usuario));

    }

    //generar login y logout,
}
