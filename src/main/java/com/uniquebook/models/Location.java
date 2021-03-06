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
public class Location {

    public Location() {
    }
    
    @Override
    public String toString() {
        return "Location{" + "city=" + city + ", country=" + country + ", address=" + address + '}';
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    
    private String city;
    private String country;
    private String address;
    private String postalCode;

    public void clone(Location location) {
        this.city = location.getCity();
        this.address = location.getAddress();
        this.country = location.getCountry();
        this.postalCode = location.getPostalCode();
    }
    
}
