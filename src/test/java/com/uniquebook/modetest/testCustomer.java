/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.models.Customer;
import com.uniquebook.models.Location;
import com.uniquebook.models.Person;

/**
 *
 * @author edris
 */
public class testCustomer {
    
        public static void main(String[] args) throws Exception {
            Location l = new Location();
            l.setAddress("this address");
            l.setCity("this city");
            l.setCountry("this country");             
            Customer p = new Customer(l);
            p.setEmail("dd@mail.com");
            p.setFirstName("man");
            p.setGender("amle");
            p.setLastName("dandy");
            p.setPassword("password");
            p.setPhone("82938928988");
            Customer c= new Customer(l);
            System.out.println(c.toString());
        }

    
}
