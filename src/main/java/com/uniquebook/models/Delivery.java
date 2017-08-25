/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.util.Date;


/**
 *
 * @author edris
 */
public class Delivery {
    
    private Date deliveryDate;
    private Location location;
 
    @Override
    public String toString() {
        return "Delivery{" + "deliveryDate=" + deliveryDate + ", location=" + location + '}';
    }

    public Delivery(Date deliveryDate, Location location) {
        this.deliveryDate = deliveryDate;
        this.location = location;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
