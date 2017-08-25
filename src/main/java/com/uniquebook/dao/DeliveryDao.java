/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.Delivery;
import com.uniquebook.models.Location;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openrdf.model.datatypes.XMLDatatypeUtil;

/**
 *
 * @author edris
 */
public class DeliveryDao {

    private HelperUtil helperUtil;
    private LocationDao locationDao;
    private final int DEFAULT_DELIVERY_PERIOD_IN_DAYS = 7;

    public DeliveryDao() {
        helperUtil = new HelperUtil();
        locationDao = new LocationDao();

    }

    /**
     *
     * @param delivery
     * @return
     */
    public String addDelivery(Delivery delivery) {
        boolean check = false;
        String LocationSubjectName = null;
        String subjectName = helperUtil.generateNames();

        Location location = delivery.getLocation();
        LocationSubjectName = locationDao.addLocation(location);

        check = this.checkDeliveryExists(delivery, LocationSubjectName);

        if (check) {
            subjectName = this.getSubjectName(delivery, LocationSubjectName);
        } else {
            try {
                String insertQuery = FusekiClient.PREFIX;
                insertQuery += "INSERT DATA\n"
                        + "{\n"
                        + "   r:" + subjectName + "   a r:Delivery;\n"
                        + "          r:hasDeliveryDate \"" + this.generateXSDDateTime(delivery.getDeliveryDate()) + "\"^^xsd:dateTime;\n"
                        + "          r:hasLocation r:" + LocationSubjectName + " .\n"
                        + "}";

                FusekiClient.insertFUSEKI(insertQuery);

            } catch (Exception ex) {
                Logger.getLogger(DeliveryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return subjectName;

    }

    public String generateXSDDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date tempDateStartMax = new Date(date.getTime() + DEFAULT_DELIVERY_PERIOD_IN_DAYS * 24 * 3600 * 1000);
        String deliverydate = XMLDatatypeUtil.normalizeDateTime(sdf.format(tempDateStartMax));
        return deliverydate;
    }

    /**
     *
     *
     * @param location
     * @return
     */
    public String getSubjectName(Delivery delivery, String locationSubjectName) {
        String subjectName = null;
        try {
            String selectQuery = null;

            selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT  ?d "
                    + "   WHERE { "
                    + "   ?d rdf:type r:Delivery;\n"
                    + "          r:hasDeliveryDate \"" + delivery.getDeliveryDate() + "\"^^xsd:dateTime;\n"
                    + "          r:hasLocation r:" + locationSubjectName + " .\n"
                    + "}";

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                subjectName = row.getResource("l").getLocalName();
            }

        } catch (Exception ex) {
            Logger.getLogger(DeliveryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectName;
    }

    /**
     * Check address is registered
     *
     * @param location
     * @return
     */
    public boolean checkDeliveryExists(Delivery delivery, String locationSubjectName) {
        boolean check = false;
        String askQuery = FusekiClient.PREFIX
                + "ASK{  ?c rdf:type r:Delivery.\n"
                + "            ?c  r:hasDeliveryDate \"" + delivery.getDeliveryDate() + "\"^^xsd:dateTime;\n"
                + "                r:hasLocation r:" + locationSubjectName + ";"
                + "}";
        check = FusekiClient.askFUSEKI(askQuery);

        return check;
    }
    
    //Delivery count 

}
