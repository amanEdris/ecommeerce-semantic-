/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import java.lang.String;
import com.uniquebook.models.Order;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
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
        String orderSubject,insertQuery = null;
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
    
  
    
    public void deleteOrder(int orderNumber) {
        
    }
    
    public void updateOrder(Order b) {
        
    }
    
    public List<Order> getAllOrder() {
        //for a customer
        //for admin
        return null;
        
    }
    
    public List<Order> getOrderByName() {
        return null;
        
    }
    
    private String getSalesInsertSubjects(String[] salesSubjectNames ) {
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
    
}
