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
    private double total;

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public ShoppingCartItem(Product p, int quantity) {
        this.total = 0.00;
        this.quantity =0;
        this.p = p;
        this.setQuantity(quantity);
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
           this.quantity = quantity;
          
    }
              
    public ShoppingCartItem() {
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" + "p=" + p + ", quantity=" + quantity + ", total=" + total + '}';
    }
    
   
    
}
