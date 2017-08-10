/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.models.Sale;

/**
 *
 * @author edris
 */
public class testSales {
           public static void main(String[] args) throws Exception {
                           
            //create book product
            NonFictionalBook b = new NonFictionalBook();
            b.setAuthor("jango");
            b.setImagepath("path");
            b.setIsbn("isbn");
            b.setPublishedYear(null);
            b.setPublisher("maman");
            b.setQuantity(100);
            b.setDescription("a book product");
            b.setPrice(12);
            b.setQuantity(2);
            b.setProductNumber(30);
            b.setCategory("String");//how to handle category 
            //b.category(); set book category
            
            
            //Create sales data
            Sale s= new Sale(12,b);
            System.out.print(s.toString());
           }

               
    
}
