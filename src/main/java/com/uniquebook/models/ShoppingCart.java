/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.util.ArrayList;
import java.util.List;

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


    public List<Sale> getSalesList(){
         List<Sale> sales = new ArrayList<Sale>();
         if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                Sale tempsale = new Sale(items.get(i).getQuantity(),items.get(i).getProduct());
                sales.add(tempsale);
            }
         }       
         return sales;       
    }
    
    
    @Override
    public String toString() {
        return "ShoppingCart{" + "total=" + total + ", numberOfItems=" + numberOfItems + ", items=" + items + '}';
    }

}
