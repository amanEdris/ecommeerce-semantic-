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
public class Order {

    private String orderstatus;
    private Integer orderNumber;
    private float totalPrice;
    private Customer cusotmer;
    private Delivery delivery;
    private Sale[] sales;

    public Order() {
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCusotmer() {
        return cusotmer;
    }

    public void setCusotmer(Customer cusotmer) {
        this.cusotmer = cusotmer;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Sale[] getSales() {
        return sales;
    }

    public void setSales(Sale[] sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Order{" + "orderstatus=" + orderstatus + ", orderNumber=" + orderNumber + ", totalPrice=" + totalPrice + ", cusotmer=" + cusotmer + ", delivery=" + delivery + ", sales=" + sales + '}';
    }

}
