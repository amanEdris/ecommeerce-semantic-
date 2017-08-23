/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.util.List;

/**
 *
 * @author edris
 */
public class Order {

    private String orderNumber;
    private double totalPrice;
    private Customer cusotmer;
    private Delivery delivery;
    private List<Sale> sales;
    private String orderStatus;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public enum Orderstatus {

        PENDING("pending"),
        APPROVED("approved"),
        DELIVERED("delivered");

        private String name;

        private Orderstatus(String stringVal) {
            name = stringVal;
        }

        public String toString() {
            return name;
        }

        public static String getEnumByString(String code) {

            for (Orderstatus e : Orderstatus.values()) {
                if (code.equals(e.name)) {
                    return e.name();
                }
            }
            return null;
        }

    }

    public Order() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Order{" + ", orderNumber=" + orderNumber + ", totalPrice=" + totalPrice + ", cusotmer=" + cusotmer + ", delivery=" + delivery + ", sales=" + sales + '}';
    }

}
