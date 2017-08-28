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
public class Customer extends Person {

    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private Location location;

    public Customer() {

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
//
//    public String getCutomerId() {
//        return customerId;
//    }
//
//    public void setCutomerId(String cutomerId) {
//        this.customerId = cutomerId;
//    }

    @Override
    public String toString() {
        return "Customer{" + "location=" + location + '}' + super.toString()+this.customerId;
    }

    public void clone(Customer c) {
        this.setEmail(c.getEmail());
        this.setFirstName(c.getFirstName());
        this.setLastName(c.getLastName());
        this.setGender(c.getGender());
        this.setPassword(c.getPassword());
        this.setPhone(c.getPhone());
        this.setLocation(c.getLocation());
        this.setCustomerId(c.getCustomerId());
    }

}
