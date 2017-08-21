/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Location;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * getting individual customer
 *
 * @author edris
 */
public class CustomerDao {

    private HelperUtil helperUtil;

    public CustomerDao() {
        helperUtil = new HelperUtil();
    }

    public void addCustomer(Customer b) {
        try {
            Location l = b.getLocation();
            String locationSubject = helperUtil.generateNames();
            String insertQuery = FusekiClient.PREFIX;
            insertQuery += "INSERT DATA"
                    + "{"
                    + ""
                    + " r:" + helperUtil.generateNames() + " a r:Customer;\n"
                    + "           r:hasPhone \"" + b.getPhone() + "\"^^xsd:string ;\n"
                    + "           r:hasPassword \"" + b.getPassword() + "\"^^xsd:string ;\n\n"
                    + "           r:hasEmail  \"" + b.getEmail() + "\"^^xsd:string ;\n"
                    + "           r:hasLastName  \"" + b.getLastName() + "\"^^xsd:string ;\n"
                    + "           r:hasFirstName \"" + b.getFirstName() + "\"^^xsd:string ;\n"
                    + "           r:hasGender  \"" + b.getGender() + "\"^^xsd:string ;\n"
                    + "           r:hasLocation r:" + locationSubject + " .\n"
                    + "       r:" + locationSubject + "  rdf:type r:Location;\n"
                    + "         r:" + locationSubject + "  r:hasPostalCode \"" + l.getPostalCode() + "\"^^xsd:string ;\n"
                    + "          r:" + locationSubject + " r:hasCity \"" + l.getCity() + "\"^^xsd:string ;\n"
                    + "         r:" + locationSubject + "  r:hasCountry \"" + l.getCountry() + "\"^^xsd:string ;\n"
                    + "          r:" + locationSubject + "   r:hasAddress \"" + l.getAddress() + "\"^^xsd:string ;\n"
                    + "}";

            FusekiClient.insertFUSEKI(insertQuery);
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteCustomer(int productNumber) {

    }

    public boolean updateCustomer(Customer b, Customer c) {
        String  updateCustomerQuery = null;
        try {
            Location l = b.getLocation();
           
            updateCustomerQuery = FusekiClient.PREFIX;
            updateCustomerQuery += "DELETE"
                    + "{"
                    + "  ?location a r:Location;\n"
                    + "     r:hasPostalCode ?postalCode; \n"
                    + "     r:hasCity ?city ;\n"
                    + "     r:hasCountry ?country ; \n"
                    + "     r:hasAddress ?address. \n"
                    + "  ?c a   r:Customer;\n"
                    + "     r:hasPhone ?phone;\n"
                    + "     r:hasPassword ?password;\n"
                    + "     r:hasEmail   ?email;\n"
                    + "     r:hasLastName   ?lastname;\n"
                    + "     r:hasFirstName  ?firstname;\n"
                    + "     r:hasGender     ?gender.\n"
                    + "}INSERT "
                    + "{"
                    + "	?location a r:Location;\n"
                    + "  		r:hasPostalCode \""+l.getPostalCode()+"\"^^xsd:nonNegativeInteger ;\n"
                    + "             r:hasCity \""+l.getCity()+"\"^^xsd:string ;\n"
                    + "  		r:hasCountry \""+l.getCountry()+"\"^^xsd:string ;\n"
                    + "  	        r:hasAddress \""+l.getAddress()+"\"^^xsd:string.\n"
                    + "     ?c   a   r:Customer;\n"
                    + " r:hasPhone \"" + b.getPhone() + "\"^^xsd:string ; \n"
                    + " r:hasPassword \"" + b.getPassword() + "\"^^xsd:string ;\n"
                    + " r:hasEmail \"" + b.getEmail() + "\"^^xsd:string ;\n"
                    + " r:hasLastName \"" + b.getLastName() + "\"^^xsd:string ;\n"
                    + " r:hasFirstName \"" + b.getFirstName() + "\"^^xsd:string; \n"
                    + " r:hasGender \"" + b.getGender() + "\"^^xsd:string .\n"
                    + "}"
                    + " WHERE { \n"
                    + " ?c rdf:type r:Customer.\n"
                    + " ?c r:hasEmail ?email.\n"
                    + " ?c r:hasPassword ?password.\n"
                    + " ?c r:hasLocation ?location.\n"
                    + " ?location a r:Location.\n"
                    + "  FILTER (?email = \""+c.getEmail()+"\"^^xsd:string ) \n"
                    + "}";
            
            FusekiClient.insertFUSEKI(updateCustomerQuery);
        } catch (Exception ex) {
             System.err.println("Error"+ex.getLocalizedMessage());
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public List<Customer> getAllCustomer() {
        return null;

    }

    public Customer getCustomerByEmailAndPassword(String email, String password) {
        Customer c = new Customer();

        String customerQuery = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
                + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
                + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
                + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "\n"
                + "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + "     ?x a r:Customer.\n"
                + "          ?x r:hasPhone ?phone.\n"
                + "          ?x  r:hasPassword ?password.\n"
                + "          ?x  r:hasEmail  ?email.\n"
                + "          ?x  r:hasLastName  ?lastName.\n"
                + "          ?x  r:hasFirstName  ?firstName.\n"
                + "          ?x  r:hasGender  ?gender.\n"
                + "          ?x r:hasLocation ?location.\n"
                + "          ?location rdf:type r:Location.\n"
                + "          ?location r:hasPostalCode ?postalcode.\n"
                + "          ?location r:hasCity ?city.\n"
                + "          ?location r:hasCountry ?country.\n"
                + "          ?location  r:hasAddress ?address.\n"
                + "   FILTER (?email  = \"" + email + "\"^^xsd:string && ?password = \"" + password + "\" )\n"
                + "}";
        queryCustomer(customerQuery, c);
        return c;

    }

    private void queryCustomer(String customerQuery, Customer customer) {
        Location customerLocation = new Location();
        ResultSet results = FusekiClient.queryFUSEKI(customerQuery);
        while (results.hasNext()) {
            QuerySolution row = results.next();

            customerLocation.setAddress(row.getLiteral("address").getString());
            customerLocation.setCity(row.getLiteral("city").getString());
            customerLocation.setCountry(row.getLiteral("country").getString());
            customerLocation.setPostalCode(row.getLiteral("postalcode").getString());

            customer.setLocation(customerLocation);
            customer.setEmail(row.getLiteral("email").getString());
            customer.setFirstName(row.getLiteral("firstName").getString());
            customer.setLastName(row.getLiteral("lastName").getString());
            customer.setPassword(row.getLiteral("password").getString());
            customer.setPhone(row.getLiteral("phone").getString());
            customer.setGender(row.getLiteral("gender").getString());
        }
    }

}
