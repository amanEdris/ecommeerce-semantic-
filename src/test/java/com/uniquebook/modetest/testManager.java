/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.models.Manager;
import com.uniquebook.models.Person;

/**
 *
 * @author edris
 */
public class testManager {
    
       public static void main(String[] args) throws Exception {
            Person p = new Person();
            p.setEmail("dd@mail.com");
            p.setFirstName("man");
            p.setGender("amle");
            p.setLastName("dandy");
            p.setPassword("password");
            p.setPhone("82938928988");
            Manager m= new Manager(p);
            System.out.println(m.toString());
        }
    
}
