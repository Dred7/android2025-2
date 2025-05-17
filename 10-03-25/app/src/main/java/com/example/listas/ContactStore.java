package com.example.listas;

import java.util.ArrayList;
import java.util.List;

public class ContactStore {


    private List<Contact> cache;

    public List<Contact> getCache() {
        return cache;
    }
    public ContactStore(){
        this.cache = ContactStore.createContanto();
    }

    public Contact  get(int position){
        return cache.get(position);
    }
    public  int size(){
        return cache.size();
    }

    public Contact findContactByPhone(String phoneNumber){
        for(Contact c: cache){
            if (c.phone.equals(phoneNumber)){
                return c;
            }
        }
        return null;
    }
    public static List<Contact> createContanto(){
        List<Contact> contact = new ArrayList<>();
        contact.add(new Contact("hola", "6666"));
        contact.add(new Contact("hola2", "66666"));
        contact.add(new Contact("hola3", "666666"));

        return contact;
    }
}
