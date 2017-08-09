/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.models.Customer;
import com.uniquebook.models.Delivery;
import com.uniquebook.models.Location;
import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.models.NonFictionalBook.NonFictionalCategory;
import com.uniquebook.models.Order;
import com.uniquebook.models.Person;
import com.uniquebook.models.Sale;
import java.util.Date;

/**
 *
 * @author edris
 */
public class testOrder {
       public static void main(String[] args) throws Exception {
            Location l = new Location();
            l.setAddress("this address");
            l.setCity("this city");
            l.setCountry("this country");
            
            Person p = new Person();
            p.setEmail("dd@mail.com");
            p.setFirstName("man");
            p.setGender("amle");
            p.setLastName("dandy");
            p.setPassword("password");
            p.setPhone("82938928988");
            
            //Create customer
            Customer c= new Customer(l, p);
            
            Date deliveryDate = new Date("12-12-12");
            //Create delivery
            Delivery  d= new Delivery(deliveryDate, l);
            
        
            
            //create book product
            NonFictionalBook b = new NonFictionalBook();
            b.setAuthor("jango");
            b.setImagepath("path");
            b.setIsbn("isbn");
            b.setPublishedYear(deliveryDate);
            b.setPublisher("maman");
            b.setQuantity(100);
            b.setDescription("a book product");
            b.setPrice(12);
            b.setQuantity(2);
            b.setProductNumber(30);
            b.setCategory(NonFictionalCategory.ACTIVITY__GAME_BOOKS);//how to handle category 
            //b.category(); set book category
            
            
            //Create sales data
            Sale s= new Sale();
            s.setProduct(b);
            s.setProductQuantity(12);
            
            Order o = new Order();
            o.setCusotmer(c);
            o.setOrderNumber(12);
            o.setTotalPrice((float) 12.50);
            o.setDelivery(d);
            
            
            
           
           
       }

}
