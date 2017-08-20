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
import com.uniquebook.models.Manager;
import com.uniquebook.utils.FusekiClient;
import java.text.SimpleDateFormat;

/**
 *
 * @author edris
 */
public class ManagerDao {
    
    /**
     * @param email
     * @param password
     * @return 
     */
    
     public Manager getManagerByEmailAndPassword(String email, String password) {
        Manager m = new Manager();

        String managerQuery = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
                + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
                + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
                + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "\n"
                + "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + "     ?x a r:Manager.\n"
                + "          ?x r:hasPhone ?phone.\n"
                + "          ?x  r:hasPassword ?password.\n"
                + "          ?x  r:hasEmail  ?email.\n"
                + "          ?x  r:hasLastName  ?lastName.\n"
                + "          ?x  r:hasFirstName  ?firstName.\n"
                + "          ?x  r:hasGender  ?gender.\n"
                + "   FILTER (?email  = \""+email+"\"^^xsd:string && ?password = \""+password+"\" )\n"
                + "}";

        return m;

    }

    private void queryManager(String managerQuery, Manager manager) {
        ResultSet results = FusekiClient.queryFUSEKI(managerQuery);
        while (results.hasNext()) {
            QuerySolution row = results.next();
          
            manager.setEmail(row.getLiteral("email").getString());
            manager.setFirstName(row.getLiteral("firstName").getString());
            manager.setLastName(row.getLiteral("lastName").getString());
            manager.setPassword(row.getLiteral("password").getString());
            manager.setPhone(row.getLiteral("phone").getString());     
            manager.setGender(row.getLiteral("gender").getString());
        }
    }
    
}
