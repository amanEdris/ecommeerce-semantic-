/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.dao.CustomerDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Location;
import com.uniquebook.models.Person;

/**
 *
 * @author edris
 */
public class testCustomer {

    public static void main(String[] args) throws Exception {
        Location l = new Location();
        l.setAddress("this address");
        l.setCity("this city");
        l.setCountry("this country");

        Customer p = new Customer();
        String queryCustomer = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
                + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
                + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
                + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "\n"
                + "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + "     ?x a r:Customer.\n"
                + "          ?x  r:hasPhone ?phone.\n"
                + "          ?x  r:hasPassword ?password.\n"
                + "          ?x  r:hasEmail  ?email.\n"
                + "          ?x  r:hasLastName  ?lastName.\n"
                + "          ?x  r:hasFirstName  ?firstName.\n"
                + "          ?x  r:hasGender  ?gender.\n"
                + "          ?x  r:hasLocation ?location.\n"
                + "          ?x  r:customerId   ?customerId.          ?location rdf:type r:Location.\n"
                + "          ?location r:hasPostalCode ?postalcode.\n"
                + "          ?location r:hasCity ?city.\n"
                + "          ?location r:hasCountry ?country.\n"
                + "          ?location  r:hasAddress ?address.\n"
                + "   FILTER (?email  = \"edi@gmail.com\"^^xsd:string && ?password = \"ed\" )\n"
                + "}"
                + "";
        
        CustomerDao customer = new CustomerDao();

        customer.queryCustomer(queryCustomer, p);
        
        System.out.println("the customer is:"+p.toString());
        
    }

}
