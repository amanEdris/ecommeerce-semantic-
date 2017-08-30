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
public class KidsBook extends Book {

    private String category;

    public KidsBook() {

    }

    public void copyProduct(Product product) {
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setQuantity(product.getQuantity());
        this.setProductNumber(product.getProductNumber());
        this.setProductName(product.getProductName());
        this.setImagepath(product.getImagepath());
    }

    public void copyBook(Book b) {
        this.setIsbn(b.getIsbn());
        this.setAuthor(b.getAuthor());
        this.setPublisher(b.getPublisher());
        this.setTitle(b.getTitle());
        this.setPublishedYear(b.getPublishedYear());
        this.setRevisionNo(b.getRevisionNo());
    }

    public enum kidsBookCategory {
        AGE0_2("Age 0-2"), AGE3_5("Age 3-5"), AGE6_8("Age 6-8"),
        AGES9_12("Ages 9-12"), TEENS("Teens");

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private kidsBookCategory(String stringVal) {
            name = stringVal;
        }

        public String toString() {
            return name;
        }

        public static String getEnumByString(String code) {
            for (kidsBookCategory e : kidsBookCategory.values()) {
                if (code.equals(e.name)) {
                    return e.name();
                }
            }
            return null;
        }

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "KidsBook{" + "book=" + category + "--" + super.toString();
    }

}
