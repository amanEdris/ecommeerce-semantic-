/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Manager;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edris
 */
public class ManagerDao {

    private HelperUtil helperUtil;

    public ManagerDao() {
        helperUtil = new HelperUtil();
    }

    public boolean addManager(Manager b) {
        String id = UUID.randomUUID().toString();
        boolean flagCustomerExist = false;
        try {
            boolean check = this.checkManagerEmailIsFree(b.getEmail());
            if (check) {
                flagCustomerExist = check;
            } else {
                String insertQuery = FusekiClient.PREFIX;
                insertQuery += "INSERT DATA"
                        + "{"
                        + ""
                        + " r:" + helperUtil.generateNames() + " a r:Manager;\n"
                        + "           r:hasPhone \"" + b.getPhone() + "\"^^xsd:string ;\n"
                        + "           r:hasPassword \"" + b.getPassword() + "\"^^xsd:string ;\n\n"
                        + "           r:hasEmail  \"" + b.getEmail() + "\"^^xsd:string ;\n"
                        + "           r:hasLastName  \"" + b.getLastName() + "\"^^xsd:string ;\n"
                        + "           r:hasFirstName \"" + b.getFirstName() + "\"^^xsd:string ;\n"
                        + "           r:hasGender  \"" + b.getGender() + "\"^^xsd:string .\n"
                        + "}";

                FusekiClient.insertFUSEKI(insertQuery);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flagCustomerExist;
    }

    public boolean updateManager(Manager m) {
        String updateManagerQuery = null;
        try {
            updateManagerQuery = FusekiClient.PREFIX;
            updateManagerQuery += "DELETE"
                    + "{"
                    + "  ?c r:hasPhone ?phone;\n"
                    + "     r:hasPassword ?password;\n"
                    + "     r:hasEmail   ?email;\n"
                    + "     r:hasLastName   ?lastname;\n"
                    + "     r:hasFirstName  ?firstname;\n"
                    + "     r:hasGender     ?gender.\n"
                    + "}"
                    + "INSERT "
                    + "{"
                    + "  ?c   a   r:Manager;\n"
                    + "     r:hasPhone \"" + m.getPhone() + "\"^^xsd:string ; \n"
                    + "     r:hasPassword \"" + m.getPassword() + "\"^^xsd:string ;\n"
                    + "     r:hasEmail \"" + m.getEmail() + "\"^^xsd:string ;\n"
                    + "     r:hasLastName \"" + m.getLastName() + "\"^^xsd:string ;\n"
                    + "     r:hasFirstName \"" + m.getFirstName() + "\"^^xsd:string; \n"
                    + "     r:hasGender \"" + m.getGender() + "\"^^xsd:string .\n"
                    + ""
                    + "} WHERE { \n"
                    + " ?c rdf:type r:Manager.\n"
                    + " ?c r:hasEmail ?email.\n"
                    + " ?c r:hasLastName   ?lastname.\n"
                    + " ?c r:hasPhone ?phone."
                    + " ?c r:hasPassword ?password."
                    + " ?c r:hasFirstName  ?firstname."
                    + "?c r:hasGender     ?gender.\n"
                    + "  FILTER (?email = \"" + m.getEmail() + "\"^^xsd:string ) \n"
                    + "}";
            System.out.println("Update manager query is: " + updateManagerQuery);
            FusekiClient.insertFUSEKI(updateManagerQuery);
        } catch (Exception ex) {
            System.err.println("Error" + ex.getLocalizedMessage());
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public void deleteManager(String email) throws Exception {

        String subjectCustomer = this.getSubjectName(email);
        String deleteCustomerQuery = FusekiClient.PREFIX + "DELETE"
                + "{"
                + "  r:" + subjectCustomer + " ?p ?o.\n"
                + "} WHERE { \n"
                + "  r:" + subjectCustomer + " ?p ?o.\n"
                + "}";

        System.out.println("Cutomer deleet query" + deleteCustomerQuery);
        FusekiClient.insertFUSEKI(deleteCustomerQuery);

    }

    public String getSubjectName(String email) {
        String subjectName = null;
        try {
            String selectQuery = null;

            selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT  ?c "
                    + "WHERE { \n"
                    + " ?c rdf:type r:Manager.\n"
                    + " ?c r:hasEmail ?email.\n"
                    + "  FILTER (?email = \"" + email + "\"^^xsd:string ) \n"
                    + "}"
                    + "";

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                subjectName = row.getResource("c").getLocalName();
            }

        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectName;
    }
    
    

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
                + "   FILTER (?email  = \"" + email + "\"^^xsd:string && ?password = \"" + password + "\" )\n"
                + "}";

        queryManager(managerQuery, m);
        return m;

    }

    public Manager getManagerByEmail(String email) {
        Manager manager = new Manager();
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
                + "          ?x  r:hasPhone ?phone.\n"
                + "          ?x  r:hasPassword ?password.\n"
                + "          ?x  r:hasEmail  ?email.\n"
                + "          ?x  r:hasLastName  ?lastName.\n"
                + "          ?x  r:hasFirstName  ?firstName.\n"
                + "          ?x  r:hasGender  ?gender.\n"
                + "  FILTER ( ?email = \"" + email + "\") \n"
                + "}";
        queryManager(managerQuery, manager);
        return manager;
    }

    private void queryManager(String managerQuery, Manager manager) {
        try {
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
        } catch (Exception ex) {
            Logger.getLogger(ManagerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getManagerCount() {
        int count = 0;
        try {
            String selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT (count(?c) As ?manager)\n"
                    + "where{\n"
                    + "	?c a r:Manager.\n"
                    + "}";

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                count = row.getLiteral("manager").getInt();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public List<Manager> getAllManager() {
        List<Manager> managers = new ArrayList<Manager>();

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
                + "}";
        queryAllManagers(managerQuery, managers);
        return managers;

    }

    private void queryAllManagers(String managerQuery, List<Manager> managers) {
        try {
            ResultSet results = FusekiClient.queryFUSEKI(managerQuery);

            while (results.hasNext()) {
                Manager manager = new Manager();

                QuerySolution row = results.next();
                setManagerDataFromResult(row, manager);
                managers.add(manager);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setManagerDataFromResult(QuerySolution row, Manager manager) {

        manager.setEmail(row.getLiteral("email").getString());
        manager.setFirstName(row.getLiteral("firstName").getString());
        manager.setLastName(row.getLiteral("lastName").getString());
        manager.setPassword(row.getLiteral("password").getString());
        manager.setPhone(row.getLiteral("phone").getString());
        manager.setGender(row.getLiteral("gender").getString());
    }

    /**
     * Check manager email not reserved
     *
     * @param email
     * @return
     */
    public boolean checkManagerEmailIsFree(String email) {
        boolean check = false;
        String askQuery = FusekiClient.PREFIX + "ASK{  ?c a r:Manager.\n"
                + " ?c r:hasEmail ?email.\n"
                + "  FILTER (?email = \"" + email + "\"^^xsd:string ) \n"
                + "}";
        check = FusekiClient.askFUSEKI(askQuery);

        return check;
    }
}
