/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.models.Customer;
import com.uniquebook.models.Delivery;
import com.uniquebook.models.FictionalBook;
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
            
            Customer p = new Customer(l);
            p.setEmail("dd@mail.com");
            p.setFirstName("man");
            p.setGender("amle");
            p.setLastName("dandy");
            p.setPassword("password");
            p.setPhone("82938928988");
                        
            Date deliveryDate = new Date();
            //Create delivery
            Delivery  d= new Delivery(deliveryDate, l);
            
       
            
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
            b.setCategory("string");//how to handle category 
            //b.category(); set book category
            
            
            //Create sales data
            Sale s= new Sale(12,b);
            Sale[] sales ={s};
            
            Order o = new Order();
            o.setOrderstatus("delivered");
            o.setSales(sales);
            o.setCusotmer(p);
            o.setOrderNumber(12);
            o.setTotalPrice((float) 12.50);
            o.setDelivery(d);                  
            System.out.println(o.toString());

       }

}







    /***
    public static final String RDF_DATA_MODEL_PATH = "src/onto/data.ttl";

    private Model model = null;
    //the url of rdf individuals created 
    private static String dataUrl = "http://localhost:8080/UniqueBookApp/onto/data.ttl";

    public static Model createModelFromUrl() {

        Model model = null;
        try {
            URL u = new URL(dataUrl);
            model = FileManager.get().loadModel(u.toString(), "TTL");
        } catch (MalformedURLException ex) {
        }
        return model;
    }**/