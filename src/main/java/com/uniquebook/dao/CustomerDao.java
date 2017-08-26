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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * getting individual customer
 *
 * @author edris
 */
public class CustomerDao {

    private HelperUtil helperUtil;
    private LocationDao locationDao;

    public CustomerDao() {
        helperUtil = new HelperUtil();
        locationDao = new LocationDao();
    }

    public boolean addCustomer(Customer b) {
        String id = UUID.randomUUID().toString();
        boolean flagCustomerExist = false;
        try {
            boolean check = this.checkCustomerEmailIsFree(b.getEmail());
            if (check) {
                flagCustomerExist = check;
            } else {
                Location location = b.getLocation();
                String LocationSubjectName = locationDao.addLocation(location);
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
                        + "           r:customerId  \"" + id + "\"^^xsd:string ;\n"
                        + "           r:hasLocation r:" + LocationSubjectName + " .\n"
                        + "}";

                FusekiClient.insertFUSEKI(insertQuery);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flagCustomerExist;
    }

    public boolean updateCustomer(Customer b, Customer c) {
        String updateCustomerQuery = null;
        try {
            Location l = b.getLocation();

            updateCustomerQuery = FusekiClient.PREFIX;
            updateCustomerQuery += "DELETE"
                    + "{"
                    + "  ?c r:hasPhone ?phone;\n"
                    + "     r:hasPassword ?password;\n"
                    + "     r:hasEmail   ?email;\n"
                    + "     r:hasLastName   ?lastname;\n"
                    + "     r:hasFirstName  ?firstname;\n"
                    + "     r:hasGender     ?gender.\n"
                    + "  ?location   r:hasPostalCode ?postalCode; \n"
                    + "     r:hasCity ?city ;\n"
                    + "     r:hasCountry ?country ; \n"
                    + "     r:hasAddress ?address. \n"
                    + "}"
                    + "INSERT "
                    + "{"
                    + "	?location a r:Location;\n"
                    + "  		r:hasPostalCode \"" + l.getPostalCode() + "\"^^xsd:nonNegativeInteger ;\n"
                    + "             r:hasCity \"" + l.getCity() + "\"^^xsd:string ;\n"
                    + "  		r:hasCountry \"" + l.getCountry() + "\"^^xsd:string ;\n"
                    + "  	        r:hasAddress \"" + l.getAddress() + "\"^^xsd:string.\n"
                    + "     ?c   a   r:Customer;\n"
                    + " r:hasPhone \"" + b.getPhone() + "\"^^xsd:string ; \n"
                    + " r:hasPassword \"" + b.getPassword() + "\"^^xsd:string ;\n"
                    + " r:hasEmail \"" + b.getEmail() + "\"^^xsd:string ;\n"
                    + " r:hasLastName \"" + b.getLastName() + "\"^^xsd:string ;\n"
                    + " r:hasFirstName \"" + b.getFirstName() + "\"^^xsd:string; \n"
                    + " r:hasGender \"" + b.getGender() + "\"^^xsd:string .\n"
                    + ""
                    + "} WHERE { \n"
                    + " ?c rdf:type r:Customer.\n"
                    + " ?c r:hasEmail ?email.\n"
                    + " ?c r:hasLastName   ?lastname.\n"
                    + " ?c r:hasPhone ?phone."
                    + " ?c r:hasPassword ?password."
                    + " ?c r:hasFirstName  ?firstname."
                    + " ?c  r:customerId   ?customerId."
                    + " ?c r:hasLocation ?location."
                    + "?c r:hasGender     ?gender.\n"
                    + " ?location a r:Location.\n"
                    + " ?location   r:hasPostalCode ?postalCode. \n"
                    + " ?location   r:hasCity ?city.\n"
                    + " ?location   r:hasCountry ?country . \n"
                    + " ?location   r:hasAddress ?address. \n"
                    + "  FILTER (?customerId = \"" + b.getCutomerId() + "\"^^xsd:string ) \n"
                    + "}";
            System.out.println("Update customer query is: " + updateCustomerQuery);
            FusekiClient.insertFUSEKI(updateCustomerQuery);
        } catch (Exception ex) {
            System.err.println("Error" + ex.getLocalizedMessage());
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public String getSubjectName(String email) {
        String subjectName = null;
        try {
            String selectQuery = null;

            selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT  ?c "
                    + "WHERE { \n"
                    + " ?c rdf:type r:Customer.\n"
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
     * Check customer email not reserved
     *
     * @param email
     * @return
     */
    public boolean checkCustomerEmailIsFree(String email) {
        boolean check = false;
        String askQuery = FusekiClient.PREFIX + "ASK{  ?c a r:Customer.\n"
                + " ?c r:hasEmail ?email.\n"
                + "  FILTER (?email = \"" + email + "\"^^xsd:string ) \n"
                + "}";
        check = FusekiClient.askFUSEKI(askQuery);

        return check;
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
                + "          ?x  r:hasPhone ?phone.\n"
                + "          ?x  r:hasPassword ?password.\n"
                + "          ?x  r:hasEmail  ?email.\n"
                + "          ?x  r:hasLastName  ?lastName.\n"
                + "          ?x  r:hasFirstName  ?firstName.\n"
                + "          ?x  r:hasGender  ?gender.\n"
                + "          ?x  r:hasLocation ?location.\n"
                + "          ?x  r:customerId   ?customerId."
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

    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<Customer>();

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
                + "          ?x  r:customerId   ?customerId."
                + "          ?x  r:hasGender  ?gender.\n"
                + "          ?x r:hasLocation ?location.\n"
                + "          ?location rdf:type r:Location.\n"
                + "          ?location r:hasPostalCode ?postalcode.\n"
                + "          ?location r:hasCity ?city.\n"
                + "          ?location r:hasCountry ?country.\n"
                + "          ?location  r:hasAddress ?address.\n"
                + "}";
        queryAllCustomers(customerQuery, customers);
        return customers;

    }

    public void deleteCustomer(String customerId) throws Exception {
        String deleteCustomerQuery = FusekiClient.PREFIX;
        deleteCustomerQuery += "DELETE"
                + "{"
                + "  ?c r:hasPhone ?phone;\n"
                + "     r:hasPassword ?password;\n"
                + "     r:hasEmail   ?email;\n"
                + "     r:hasLastName   ?lastname;\n"
                + "     r:hasFirstName  ?firstname;\n"
                + "     r:hasGender     ?gender.\n"
                + "  ?location   r:hasPostalCode ?postalCode; \n"
                + "     r:hasCity ?city ;\n"
                + "     r:hasCountry ?country ; \n"
                + "     r:hasAddress ?address. \n"
                + "} WHERE { \n"
                + " ?c rdf:type r:Customer.\n"
                + " ?c r:hasEmail ?email.\n"
                + " ?c r:hasLastName   ?lastname.\n"
                + " ?c r:hasPhone ?phone."
                + " ?c r:hasPassword ?password."
                + " ?c  r:customerId   ?customerId."
                + " ?c r:hasFirstName  ?firstname."
                + " ?c r:hasLocation ?location."
                + "?c r:hasGender     ?gender.\n"
                + " ?location a r:Location.\n"
                + " ?location   r:hasPostalCode ?postalCode. \n"
                + " ?location   r:hasCity ?city.\n"
                + " ?location   r:hasCountry ?country . \n"
                + " ?location   r:hasAddress ?address. \n"
                + "  FILTER (?customerId = \"" + customerId + "\"^^xsd:string ) \n"
                + "}";

        System.out.println("Cutomer deleet query" + deleteCustomerQuery);
        FusekiClient.insertFUSEKI(deleteCustomerQuery);

    }

    public void queryCustomer(String customerQuery, Customer customer) {
        try {
            Location customerLocation = new Location();
            ResultSet results = FusekiClient.queryFUSEKI(customerQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();

                setCustomerDataFromResult(customerLocation, row, customer);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCustomerCount() {
        int count = 0;
        try {
            String selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT (count(?c) As ?customers)\n"
                    + "where{\n"
                    + "	?c a r:Customer.\n"
                    + "}";

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                count = row.getLiteral("customers").getInt();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    private void queryAllCustomers(String customerQuery, List<Customer> customers) {
        try {
            ResultSet results = FusekiClient.queryFUSEKI(customerQuery);

            while (results.hasNext()) {
                Location customerLocation = new Location();
                Customer customer = new Customer();

                QuerySolution row = results.next();
                setCustomerDataFromResult(customerLocation, row, customer);
                customers.add(customer);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCustomerDataFromResult(Location customerLocation, QuerySolution row, Customer customer) {
        
        customerLocation.setAddress(row.getLiteral("address").getString());
        customerLocation.setCity(row.getLiteral("city").getString());
        customerLocation.setCountry(row.getLiteral("country").getString());
        customerLocation.setPostalCode(row.getLiteral("postalcode").getString());
        customer.setCutomerId(row.getLiteral("customerId").getString());
        customer.setLocation(customerLocation);
        customer.setEmail(row.getLiteral("email").getString());
        customer.setFirstName(row.getLiteral("firstName").getString());
        customer.setLastName(row.getLiteral("lastName").getString());
        customer.setPassword(row.getLiteral("password").getString());
        customer.setPhone(row.getLiteral("phone").getString());
        customer.setGender(row.getLiteral("gender").getString());
    }

    public List<Customer> getAllCustomer(int startPageIndex, int recordsPerPage) {
        List<Customer> customers = new ArrayList<Customer>();
        int offset;
        if (startPageIndex == 1 || startPageIndex == 0) {
            offset = 0;
        } else {
            offset = ((startPageIndex - 1) * (recordsPerPage) + 1);
        }

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
                + "          ?x  r:customerId   ?customerId."
                + "          ?x  r:hasGender  ?gender.\n"
                + "          ?x r:hasLocation ?location.\n"
                + "          ?location rdf:type r:Location.\n"
                + "          ?location r:hasPostalCode ?postalcode.\n"
                + "          ?location r:hasCity ?city.\n"
                + "          ?location r:hasCountry ?country.\n"
                + "          ?location  r:hasAddress ?address.\n"
                + "}"
                + "LIMIT " + recordsPerPage + "\n"
                + "OFFSET" + offset + ""
                + "";
        queryAllCustomers(customerQuery, customers);
        System.out.println("the query for customer data is:" + customerQuery.toString());
        return customers;
    }
}
