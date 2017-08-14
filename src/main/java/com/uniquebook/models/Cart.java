/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author edris
 */
public class Cart {
    private final int key = 0;
    public Cart() {
        this.products = new HashMap<>();
        this.cart = new ArrayList<>();
    }
    private Map<Integer, Product> products = null;
    private ArrayList<Map<Integer, Product>> cart;

    public ArrayList<Map<Integer, Product>> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Map<Integer, Product>> cart) {
        this.cart = cart;
    }

   
    
    public void addToCart(Product p, Integer quantity) throws Exception{
        if(quantity.equals(null)){
           throw new Exception("zero quntity product can't be added");
        }
        products.put(quantity, p);
        this.cart.add(key,products);
    }
    
    public float getTotalPrice(){
        float totalPrice= 0;
        if(cart.size()>0){
          Map<Integer,Product>   p = cart.get(key);
          //get the key and value
          //get the price and mutiply and sum
        }
        return totalPrice;      
    }
    
    

}
