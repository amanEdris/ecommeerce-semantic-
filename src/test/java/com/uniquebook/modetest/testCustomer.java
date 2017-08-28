/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.dao.CustomerDao;
import com.uniquebook.dao.OrderDao;
import com.uniquebook.dao.SalesDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Location;
import com.uniquebook.models.Order;
import com.uniquebook.models.Person;
import java.util.List;
import org.apache.xmlbeans.impl.inst2xsd.SalamiSliceStrategy;

/**
 *
 * @author edris
 */
public class testCustomer {

    public static void main(String[] args) throws Exception {
        OrderDao ordeDao = new OrderDao();
        ordeDao.getAllOrderBystatus("pending");
        
        SalesDao saleDao =  new SalesDao();
        saleDao.getAllSalesByOrderNumber("17184258-ee6a-4ded-b96d-703eab3adbae");
        
                
//        Customer c= new Customer();
//        Location location = new Location();
//        location.setAddress("Kirstinharju 1b 21");
//        location.setCity("Espoo");
//        location.setCountry("Finland");
//        location.setPostalCode("20590");
//        c.setCutomerId("dfsf1dddasdeefd");
//        c.setEmail("edi@gmail.com");
//        c.setFirstName("dd");
//        c.setLastName("bnb");
//        c.setGender("male");
//        c.setPassword("ed");
//        c.setPhone("edi@gmail.com");
//        c.setLocation(location);
//        List<Order> orders = ordeDao.getCustomerOrders(c);
//        
//        System.out.println("the orders are :"+orders.toString());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        Location l = new Location();
//        l.setAddress("this address");
//        l.setCity("this city");
//        l.setCountry("this country");
//
//        Customer p = new Customer();
//        String queryCustomer = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
//        + "          ?x  r:hasGender  ?gender.\n"
//                + "          ?x  r:hasLocation ?location.\n"
//                + "          ?x  r:customerId   ?customerId.          ?location rdf:type r:Location.\n"
//                + "          ?location r:hasPostalCode ?postalcode.\n"
//                + "          ?location r:hasCity ?city.\n"
//                + "          ?location r:hasCountry ?country.\n"
//                + "          ?location  r:hasAddress ?address.\n"
//                + "   FILTER (?email  = \"edi@gmail.com\"^^xsd:string && ?password = \"ed\" )\n"
//                + "}"
//                + "";
//        
//        CustomerDao customer = new CustomerDao();
//
//        customer.queryCustomer(queryCustomer, p);           + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
//                + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
//                + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
//                + "\n"
//                + "SELECT  *\n"
//                + "\n"
//                + "WHERE\n"
//                + "{\n"
//                + "     ?x a r:Customer.\n"
//                + "          ?x  r:hasPhone ?phone.\n"
//                + "          ?x  r:hasPassword ?password.\n"
//                + "          ?x  r:hasEmail  ?email.\n"
//                + "          ?x  r:hasLastName  ?lastName.\n"
//                + "          ?x  r:hasFirstName  ?firstName.\n"
//                + "          ?x  r:hasGender  ?gender.\n"
//                + "          ?x  r:hasLocation ?location.\n"
//                + "          ?x  r:customerId   ?customerId.          ?location rdf:type r:Location.\n"
//                + "          ?location r:hasPostalCode ?postalcode.\n"
//                + "          ?location r:hasCity ?city.\n"
//                + "          ?location r:hasCountry ?country.\n"
//                + "          ?location  r:hasAddress ?address.\n"
//                + "   FILTER (?email  = \"edi@gmail.com\"^^xsd:string && ?password = \"ed\" )\n"
//                + "}"
//                + "";
//        
//        CustomerDao customer = new CustomerDao();
//
//        customer.queryCustomer(queryCustomer, p);
//        
//        System.out.println("the customer is:"+p.toString());
//        
    }

}
