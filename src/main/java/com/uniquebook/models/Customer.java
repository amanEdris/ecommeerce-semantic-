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
public class Customer extends Person{

    private Location location;


    public Customer(Location location) {
        this.location = location;
    }
    
    
    
    @Override
    public String toString() {
        return "Customer{" + "location=" + location + '}'+super.toString();
    }
    
}
