/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.models.Book;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.Product;

/**
 *
 * @author edris
 */
public class testProduct {

    public static void main(String[] args) throws Exception {
        Product product = new Product();
        product.setDescription("lide is awesome");
        product.setImagepath("/iamge/upload");
        product.setPrice(0);
        product.setProductName("no body");
        product.setQuantity(Integer.SIZE);
        

        Book b = new Book();
        b.setAuthor("aman");
        b.setPublisher("better than ever");
        
        KidsBook kid = new KidsBook();
        kid.copyProduct(product);
        kid.copyBook(b);
        
        System.out.println("the conetent of the book product is : "+b.toString());
    }

}
