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
public class ShoppingCartItem {

   
    private Product p;
    private int quantity;

    public ShoppingCartItem(Product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return p;
    }

    public void setProduct(Product p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(this.quantity > 0){
           this.quantity += quantity;
        }else{
           this.quantity = quantity;
        }
    }
              
    public ShoppingCartItem() {
    }
    
     @Override
    public String toString() {
        return "ShoppingCartItem{" + "p=" + p + ", quantity=" + quantity + '}';
    }
    
}
