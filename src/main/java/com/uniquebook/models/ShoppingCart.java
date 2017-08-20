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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
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
                if (items.get(i).getProduct().getProductNumber() == (p.getProduct().getProductNumber())) {
                    if (p.getQuantity() != 0) {
                        total += p.getProduct().getPrice() * p.getQuantity();
                        int tempCurrentQuantity = items.get(i).getQuantity();
                        int totalQuantity = tempCurrentQuantity + p.getQuantity();
                        items.get(i).setTotal(totalQuantity * p.getProduct().getPrice());
                        items.get(i).setQuantity(totalQuantity);
                        numberOfItems += p.getQuantity();
                    } else {
                        this.removeItem(p.getProduct().getProductNumber());
                    }
                    flag = true;
                }
            }

            if (flag == false) {
                p.setTotal(p.getQuantity() * p.getProduct().getPrice());
                items.add(p);
                total += p.getProduct().getPrice() * p.getQuantity();
                numberOfItems += p.getQuantity();

            }

        } else {
            p.setTotal(p.getQuantity() * p.getProduct().getPrice());
            items.add(p);
            total += p.getProduct().getPrice() * p.getQuantity();
            numberOfItems += p.getQuantity();

        }

    }

    public synchronized void updateItem(ShoppingCartItem p) {
        boolean flag = false;
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getProduct().getProductNumber() == (p.getProduct().getProductNumber())) {
                    if (p.getQuantity() != 0) {
                        if (p.getQuantity() > items.get(i).getQuantity()) {
                            //add the differnce of update total to all cost
                            total += p.getProduct().getPrice() * p.getQuantity()
                                    - items.get(i).getTotal();
                            int totalQuantity = p.getQuantity();
                            numberOfItems += totalQuantity - items.get(i).getQuantity();

                            items.get(i).setTotal(totalQuantity * p.getProduct().getPrice());
                            items.get(i).setQuantity(totalQuantity);

                        } else {
                            total -= items.get(i).getTotal();
                            total += p.getProduct().getPrice() * p.getQuantity();

                            int totalQuantity = p.getQuantity();
                            numberOfItems -= items.get(i).getQuantity();
                            numberOfItems += totalQuantity;

                            items.get(i).setTotal(totalQuantity * p.getProduct().getPrice());
                            items.get(i).setQuantity(totalQuantity);

                        }

                    } else {
                        this.removeItem(p.getProduct().getProductNumber());
                    }
                    flag = true;
                }
            }

            if (flag == false) {
                p.setTotal(p.getQuantity() * p.getProduct().getPrice());
                items.add(p);
                total += p.getProduct().getPrice() * p.getQuantity();
                numberOfItems += 1;

            }

        } else {
            p.setTotal(p.getQuantity() * p.getProduct().getPrice());
            items.add(p);
            total += p.getProduct().getPrice() * p.getQuantity();
            numberOfItems += 1;

        }

    }

    public void removeItem(int productNumber) {
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getProduct().getProductNumber() == (productNumber)) {
                    numberOfItems -= items.get(i).getQuantity();
                    total -= items.get(i).getTotal();
                    items.remove(i);
                }
            }

        }
    }

    public void removeAllItems() {
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                this.removeItem(items.get(i).getProduct().getProductNumber());
            }
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
