/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

/**
 *
 * @author edris
 */
public class Manager extends Person{



    public Manager(Person p ) {
        super.setEmail(p.getEmail());
        super.setPassword(p.getPassword());
        super.setFirstName(p.getFirstName());
        super.setLastName(p.getLastName());
        super.setPhone(p.getPhone());
        super.setGender(p.getGender());
    }
    
        @Override
    public String toString() {
        return "Manager{" + '}'+super.toString();
    }
}
