/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Delivery;
import com.uniquebook.models.Location;
import com.uniquebook.models.Order;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edris
 */
public class OrderDao {

    private HelperUtil helperUtil;
    private DeliveryDao deliveryDao;
    private CustomerDao customerDao;
    private SalesDao salesDao;

    public OrderDao() {
        helperUtil = new HelperUtil();
        deliveryDao = new DeliveryDao();
        customerDao = new CustomerDao();
        salesDao = new SalesDao();
    }

    public String addOrder(Order b) {
        String orderSubject, insertQuery = null;
        try {
            String deliverySubjectName = deliveryDao.addDelivery(b.getDelivery());
            String customerSubjectName = customerDao.getSubjectName(b.getCusotmer().getEmail());
            String[] salesSubjectNames = salesDao.addSales(b.getSales());

            orderSubject = helperUtil.generateNames();
            insertQuery = FusekiClient.PREFIX;
            insertQuery += "INSERT DATA"
                    + "{"
                    + ""
                    + " r:" + orderSubject + " a r:Order;\n"
                    + "             r:orderNumber \"" + b.getOrderNumber() + "\"^^xsd:string ;\n"
                    + "             r:hasTotalPrice \"" + b.getTotalPrice() + "\"^^xsd:float ;\n"
                    + "             r:orderStatus \"" + b.getOrderStatus() + "\"^^xsd:string ;\n"
                    + "             r:hasCustomer r:" + customerSubjectName + " ;\n"
                    + "             r:hasDelivery r:" + deliverySubjectName + " ;\n"
                    + "             r:hasSales " + this.getSalesInsertSubjects(salesSubjectNames) + "."
                    + "}";
            FusekiClient.insertFUSEKI(insertQuery);
        } catch (Exception ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertQuery;
    }

    public void deleteOrder(String orderNumber) {
        try {
            //get order subject name
            String orderSubjectName = this.getSubjectNameByID(orderNumber.trim());
            //get delivery subjectName
            String deliverySubjectName = deliveryDao.getSubjectNameByOrderId(orderNumber);
            String[] salesSubjectNames = salesDao.getSalesByOrder(orderNumber.trim());

            String getSalesSubjectPredicateObject = this.getSalesOrderPredicateObjects(salesSubjectNames);
            String deleteCustomerQuery = FusekiClient.PREFIX + "DELETE" //r:hasDelivery r:hasSales
                    + "{"
                    + "  r:" + orderSubjectName + " ?p ?o.\n"
                    + "  r:" + orderSubjectName + " r:hasDelivery  r:" + deliverySubjectName + "."
                    + "  r:" + deliverySubjectName + "  ?r ?j. \n"
                    + "  r:" + orderSubjectName + " r:hasSales  " + this.getSalesInsertSubjects(salesSubjectNames) + "."
                    + " " + this.getSalesOrderPredicateObjects(salesSubjectNames) + " "
                    + "} WHERE { \n"
                    + "  r:" + orderSubjectName + " ?p ?o.\n"
                    + "  r:" + orderSubjectName + " r:hasDelivery  r:" + deliverySubjectName + "."
                    + "  r:" + deliverySubjectName + "  ?r ?j. \n"
                    + "  r:" + orderSubjectName + " r:hasSales  " + this.getSalesInsertSubjects(salesSubjectNames) + "."
                    + " " + this.getSalesOrderPredicateObjects(salesSubjectNames) + " "
                    + "}";

            System.out.println("Order delete query" + deleteCustomerQuery);
            FusekiClient.insertFUSEKI(deleteCustomerQuery);
        } catch (Exception ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Generate predicate and object for sales of order For example.
     * x:saleSubject ?p ?o.
     *
     * @param salesSubjectNames
     * @return
     */
    private String getSalesOrderPredicateObjects(String[] salesSubjectNames) {
        StringBuilder insertPart = new StringBuilder();
        for (int i = 0; i < salesSubjectNames.length; i++) {
            insertPart.append("r:" + salesSubjectNames[i] + " ?" + helperUtil.generateNames() + " ?" + helperUtil.generateNames() + " .");
        }
        return insertPart.toString();
    }

    public String getSubjectNameByID(String orderNumber) {
        String subjectName = null;
        try {
            String selectQuery = null;

            selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT  ?o "
                    + "WHERE { \n"
                    + " ?o rdf:type r:Order.\n"
                    + " ?o r:orderNumber ?orderNumber.\n"
                    + "  FILTER ( ?orderNumber = \"" + orderNumber + "\") \n"
                    + "}"
                    + "";

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                subjectName = row.getResource("o").getLocalName();
            }

        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectName;
    }

    public void updateOrder(Order b) {

    }

    //get all orders by status
    public List<Order> getAllOrderBystatus(String orderStatus) {
        List<Order> orders = new ArrayList<Order>();
        try {
            String query = FusekiClient.PREFIX;
            query += "SELECT  * WHERE{\n"
                    + "            ?o  a r:Order.\n"
                    + "             ?o     r:orderNumber ?orderNumber.\n"
                    + "             ?o     r:orderStatus ?status.\n"
                    + "            ?o      r:hasTotalPrice ?totalPrice.\n"
                    + "           ?o   r:hasCustomer ?customer.\n"
                    + "{\n"
                    + "select * WHERE{\n"
                    + "         ?customer r:customerId   ?customerId.\n"
                    + "         ?customer r:hasPassword ?password.\n"
                    + "         ?customer r:hasEmail   ?email.\n"
                    + "}\n"
                    + "}\n"
                    + "           ?o           r:hasDelivery ?delivery.\n"
                    + "{\n"
                    + "select * WHERE{\n"
                    + "        ?delivery  r:hasDeliveryDate  ?deliveryDate.\n"
                    + "        ?delivery  r:hasLocation  ?location;\n"
                    + "}\n"
                    + "}\n"
                    + "{\n"
                    + "select * WHERE{\n"
                    + "        ?location  r:hasCity  ?city.\n"
                    + "        ?location  r:hasCountry  ?country.\n"
                    + "        ?location  r:hasAddress   ?address.\n"
                    + "        ?location  r:hasPostalCode ?postalcode. \n"
                    + "}\n"
                    + "}\n"
                    + "  FILTER (?status = \"" + orderStatus + "\"^^xsd:string ) \n"
                    + "}"
                    + "order by(?deliveryDate)"
                    + "";

            System.out.println("customer orde query: \n" + query);
            ResultSet results = FusekiClient.queryFUSEKI(query);
            while (results.hasNext()) {
                Location deliveryLocation = new Location();
                Order order = new Order();
                QuerySolution row = results.next();

                deliveryLocation.setAddress(row.getLiteral("address").getString());
                deliveryLocation.setCity(row.getLiteral("city").getString());
                deliveryLocation.setCountry(row.getLiteral("country").getString());
                deliveryLocation.setPostalCode(row.getLiteral("postalcode").getString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date deliveryDate = sdf.parse(row.getLiteral("deliveryDate").getValue().toString());
                Delivery delivery = new Delivery(deliveryDate, deliveryLocation);
                order.setDelivery(delivery);
                order.setCusotmer(customerDao.getCustomerByEmailAndPassword(row.getLiteral("email").getString(),
                        row.getLiteral("password").getString()));
                order.setOrderNumber(row.getLiteral("orderNumber").getString());
                order.setOrderStatus(row.getLiteral("status").getString());
                order.setSales(salesDao.getAllSalesByOrderNumber(row.getLiteral("orderNumber").getString()));
                order.setTotalPrice(row.getLiteral("totalPrice").getFloat());
                orders.add(order);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    /**
     * Get customer order list
     *
     * @param customer
     * @return
     */
    public List<Order> getCustomerOrders(Customer customer) {
        List<Order> orders = new ArrayList<Order>();
        try {
            String query = FusekiClient.PREFIX;
            query += "SELECT  * WHERE{\n"
                    + "            ?o  a r:Order.\n"
                    + "             ?o     r:orderNumber ?orderNumber.\n"
                    + "             ?o     r:orderStatus ?status.\n"
                    + "            ?o      r:hasTotalPrice ?totalPrice.\n"
                    + "           ?o   r:hasCustomer ?customer.\n"
                    + "{\n"
                    + "select * WHERE{\n"
                    + "         ?customer  r:customerId   ?customerId.\n"
                    + "}\n"
                    + "}\n"
                    + "           ?o           r:hasDelivery ?delivery.\n"
                    + "{\n"
                    + "select * WHERE{\n"
                    + "        ?delivery  r:hasDeliveryDate  ?deliveryDate.\n"
                    + "        ?delivery  r:hasLocation  ?location;\n"
                    + "}\n"
                    + "}\n"
                    + "{\n"
                    + "select * WHERE{\n"
                    + "        ?location  r:hasCity  ?city.\n"
                    + "        ?location  r:hasCountry  ?country.\n"
                    + "        ?location  r:hasAddress   ?address.\n"
                    + "        ?location  r:hasPostalCode ?postalcode. \n"
                    + "}\n"
                    + "}\n"
                    + "  FILTER (?customerId = \"" + customer.getCustomerId() + "\"^^xsd:string ) \n"
                    + "}"
                    + "order by(?deliveryDate)"
                    + "";

            System.out.println("customer orde query: \n" + query);
            ResultSet results = FusekiClient.queryFUSEKI(query);
            while (results.hasNext()) {
                Location deliveryLocation = new Location();
                Order order = new Order();
                QuerySolution row = results.next();

                deliveryLocation.setAddress(row.getLiteral("address").getString());
                deliveryLocation.setCity(row.getLiteral("city").getString());
                deliveryLocation.setCountry(row.getLiteral("country").getString());
                deliveryLocation.setPostalCode(row.getLiteral("postalcode").getString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date deliveryDate = sdf.parse(row.getLiteral("deliveryDate").getValue().toString());
                Delivery delivery = new Delivery(deliveryDate, deliveryLocation);
                order.setDelivery(delivery);
                order.setCusotmer(customer);
                order.setOrderNumber(row.getLiteral("orderNumber").getString());
                order.setOrderStatus(row.getLiteral("status").getString());
                order.setSales(salesDao.getAllSalesByOrderNumber(row.getLiteral("orderNumber").getString()));
                order.setTotalPrice(row.getLiteral("totalPrice").getFloat());
                orders.add(order);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    private String getSalesInsertSubjects(String[] salesSubjectNames) {
        StringBuilder insertPart = new StringBuilder();
        for (int i = 0; i < salesSubjectNames.length; i++) {
            if (i != salesSubjectNames.length - 1) {
                insertPart.append("r:" + salesSubjectNames[i] + ", ");
            } else {
                insertPart.append("r:" + salesSubjectNames[i]);
            }
        }
        return insertPart.toString();
    }

    public int getOrderCount() {
        int count = 0;
        try {
            String selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT (count(?c) As ?orders)\n"
                    + "where{\n"
                    + "	?c a r:Order.\n"
                    + "}";

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                count = row.getLiteral("orders").getInt();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
   

    public boolean updateOrderStatus(String orderId, String orderStatus, String previousOrderStatus) {
        boolean check = false;
        try {
            String updateQuery = FusekiClient.PREFIX;
            updateQuery += "PREFIX r:<http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
                    + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "\n"
                    + "DELETE\n"
                    + "{\n"
                    + " ?o r:orderStatus  \""+previousOrderStatus+"\"^^xsd:string;\n"
                    + "}\n"
                    + "INSERT\n"
                    + "{\n"
                    + " ?o r:orderStatus  \""+orderStatus+"\"^^xsd:string;\n"
                    + "}\n"
                    + "WHERE \n"
                    + "{  \n"
                    + " ?o r:orderNumber \""+orderId+"\"^^xsd:string ;\n"
                    + "}";
            
            FusekiClient.insertFUSEKI(updateQuery);
            check = true;
        } catch (Exception ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
            check= false;
        }
        return check;

    }

}
