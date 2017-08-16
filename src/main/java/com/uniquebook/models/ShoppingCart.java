/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edris
 */
public class ShoppingCart {

    private double total;
    private int numberOfItems;
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
        numberOfItems = 0;
        total = 0;
    }

    /**
     * add product to shopping cart
     *
     * @param book
     */
    public synchronized void addItem(ShoppingCartItem p) {
        boolean flag = false;
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getProduct().equals(p.getProduct())) {
                    items.get(i).setQuantity(p.getQuantity());
                    total += p.getProduct().getPrice() * p.getQuantity();
                    flag = true;
                }
            }

            if (flag == false) {
                items.add(p);
                total += p.getProduct().getPrice() * p.getQuantity();
                numberOfItems += 1;
            }

        } else {

            items.add(p);
            total += p.getProduct().getPrice() * p.getQuantity();
            numberOfItems += 1;

        }

    }

    public static void main(String arg[]) {
        Product p = new Product();
        p.setDescription("nothing is well!");
        p.setImagepath("/images/dawg.png");
        p.setPrice(1);
        p.setProductName("Jambo");
        p.setProductNumber(12);
        p.setQuantity(5);

        Product pe = new Product();
        pe.setDescription("nothing is wwell!");
        pe.setImagepath("/images/dawgw.png");
        pe.setPrice(1);
        pe.setQuantity(10);
        pe.setProductName("Jambwo");
        pe.setProductNumber(13);

        ShoppingCart c = new ShoppingCart();
        ShoppingCartItem sc = new ShoppingCartItem(p, 1);
        ShoppingCartItem sd = new ShoppingCartItem(p, 2);
        c.addItem(sc);
        c.addItem(sd);

        ShoppingCartItem snd = new ShoppingCartItem(pe, 2);
        c.addItem(snd);

        System.out.println("shopping cart     =======================:" + c.toString());

    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "total=" + total + ", numberOfItems=" + numberOfItems + ", items=" + items + '}';
    }

}
