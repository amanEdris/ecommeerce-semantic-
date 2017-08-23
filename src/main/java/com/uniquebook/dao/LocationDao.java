/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.Location;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edris
 */
public class LocationDao {

    private HelperUtil helperUtil;

    public LocationDao() {
        helperUtil = new HelperUtil();
    }

    public String addLocation(Location location) {
        String subjectName = helperUtil.generateNames();

        boolean check = checkLocationExists(location);

        if (check) {
            subjectName = this.getSubjectName(location);
        } else {
            try {
                String insertQuery = FusekiClient.PREFIX;
                insertQuery += "INSERT DATA\n"
                        + "{\n"
                        + " r:" + subjectName + "   a   r:Location;\n"
                        + "           r:hasPostalCode \"" + location.getPostalCode() + "\"^^xsd:nonNegativeInteger;\n"
                        + "           r:hasCity \"" + location.getCity() + "\"^^xsd:string ;\n"
                        + "           r:hasCountry \"" + location.getCountry() + "\"^^xsd:string ;\n"
                        + "           r:hasAddress \"" + location.getAddress() + "\"^^xsd:string .\n"
                        + "}";

                FusekiClient.insertFUSEKI(insertQuery);

            } catch (Exception ex) {
                Logger.getLogger(DeliveryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return subjectName;

    }

    public String getSubjectName(Location location) {
        String selectQuery = null;
        String subjectName = null;
        selectQuery = FusekiClient.PREFIX;
        selectQuery += "SELECT  ?l WHERE { "
                + "  ?l a r:Location;\n"
                + "           r:hasPostalCode \"" + location.getPostalCode() + "\"^^xsd:nonNegativeInteger ;\n"
                + "           r:hasCity \"" + location.getCity() + "\"^^xsd:string ;\n"
                + "           r:hasCountry \"" + location.getCountry() + "\"^^xsd:string ;\n"
                + "           r:hasAddress \"" + location.getAddress() + "\"^^xsd:string .\n"
                + "}";

        System.out.println("Location for registerd user delivery: "+selectQuery);
        ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
        while (results.hasNext()) {
            QuerySolution row = results.next();
            subjectName = row.getResource("l").getLocalName();
        }

        return subjectName;
    }

    /**
     * Check address is registered
     *
     * @param location
     * @return
     */
    public boolean checkLocationExists(Location location) {
        boolean check = false;
        String askQuery = FusekiClient.PREFIX;

        askQuery += "ASK{  \n"
                + "    ?location a r:Location;\n"
                + "           r:hasAddress     \"" + location.getAddress() + "\" ;\n"
                + "           r:hasCity        \"" + location.getCity() + "\" ;\n"
                + "        r:hasCountry     \"" + location.getCountry() + "\" ;\n"
                + "        r:hasPostalCode  \"" + location.getPostalCode() + "\"^^xsd:nonNegativeInteger .\n"
                + "}";
        
        System.out.println("Ask query for existing delivery address:"+askQuery);
        check = FusekiClient.askFUSEKI(askQuery);

        return check;
    }
}
