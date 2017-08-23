/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.dao.OrderDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Delivery;
import com.uniquebook.models.Location;
import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.models.Order;
import com.uniquebook.models.Sale;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

        Customer p = new Customer();
        p.setEmail("dd@mail.com");
        p.setFirstName("man");
        p.setGender("amle");
        p.setLastName("dandy");
        p.setPassword("password");
        p.setPhone("82938928988");
        p.setLocation(l);

        //create delivery data
        Date deliveryDate = new Date();
        Delivery d = new Delivery(deliveryDate, l);

        //create a product
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
        b.setCategory("Fiction");//how to handle category 

        NonFictionalBook eb = new NonFictionalBook();
        eb.setAuthor("jango");
        eb.setImagepath("path");
        eb.setIsbn("isbn");
        eb.setPublishedYear(null);
        eb.setPublisher("maman");
        eb.setQuantity(100);
        eb.setDescription("a book product");
        eb.setPrice(12);
        eb.setQuantity(2);
        eb.setProductNumber(30);
        eb.setCategory("Fiction");

        //Create sales data
        Sale s = new Sale(12, b);
        Sale sd = new Sale(12, eb);
        List<Sale> sales = new ArrayList<>();
        sales.add(s);
        sales.add(sd);

        //create order data
        Order o = new Order();
        o.setOrderStatus("delivered");
        o.setSales(sales);
        o.setCusotmer(p);
        o.setOrderNumber(UUID.randomUUID().toString());
        o.setTotalPrice((float) 12.50);
        o.setDelivery(d);

        OrderDao orer = new OrderDao();
        orer.addOrder(o);

    }

}

/**
 * r:tgugvxyohtvoattlouwwog a r:Sale ; r:hasProduct r:null ;
 * r:hasProductSalesQuantity "12"^^xsd:nonNegativeInteger .
 *
 * r:fftjhyzwavmeiodyst a r:Order ; r:hasCustomer r:null ; r:hasDelivery
 * r:mrmohlqpgddsoin ; r:hasSales r:tgugvxyohtvoattlouwwog ; r:hasTotalPrice
 * "12.5"^^xsd:nonNegativeInteger ; r:orderNumber
 * "c209d022-85cd-4a0a-90ab-14ec1991554f"^^xsd:nonNegativeInteger ;
 * r:orderStatus "delivered" .
 *
 * r:mrmohlqpgddsoin a r:Delivery ; r:hasDeliveryDate "Wed Aug 23 16:50:34 EAT
 * 2017"^^xsd:dateTime ; r:hasLocation r:exiymiqtbsthvphml .
 *
 * r:exiymiqtbsthvphml a r:Location ; r:hasAddress "this address" ; r:hasCity
 * "this city" ; r:hasCountry "this country" ; r:hasPostalCode "null" .
 */





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
