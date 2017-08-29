/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.dao.CustomerDao;
import com.uniquebook.models.Manager;
import com.uniquebook.models.Person;

/**
 *
 * @author edris
 */
public class testManager {
    
       public static void main(String[] args) throws Exception {
           // customer id => c4b8379c-644a-4607-bdd4-432015546c7d
           CustomerDao customer =new CustomerDao();
                   
           
           customer.deleteCustomer("c4b8379c-644a-4607-bdd4-432015546c7d");
           
//            Manager p = new Manager();
//            p.setEmail("dd@mail.com");
//            p.setFirstName("man");
//            p.setGender("amle");
//            p.setLastName("dandy");
//            p.setPassword("password");
//            p.setPhone("82938928988");
//            System.out.println(p.toString());
        }
    
}
