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
import com.uniquebook.models.Sale;
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
                    + "             r:hasTotalPrice \"" + b.getTotalPrice() + "\"^^xsd:nonNegativeInteger ;\n"
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

    }

    public void updateOrder(Order b) {

    }

    public List<Order> getAllOrder() {
        //for a customer
        //for admin
        return null;

    }

    public List<Order> getCustomerOrders(Customer customer) {
        List<Order> orders = new ArrayList<Order>();
        try {
            String query = FusekiClient.PREFIX;
            query += "SELECT  * WHERE{\n"
                    + "            ?o  a r:Order;\n"
                    + "                  r:orderNumber ?orderNumber;\n"
                    + "                  r:orderStatus ?status.\n"
                    + "                  r:hasTotalPrice ?totalPrice.\n"
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
                    + "        ?location  r:hasAddress   ?address;\n"
                    + "        ?location  r:hasPostalCode ?postalcode. \n"
                    + "}\n"
                    + "}\n"
                    + "  FILTER (?customerId = \"" + customer.getCutomerId() + "\"^^xsd:string ) \n"
                    + "}"
                    + "order by(?deliveryDate)"
                    + "";
            
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

}
