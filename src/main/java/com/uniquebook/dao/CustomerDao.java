/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.rdf.model.Model;
import com.uniquebook.models.Customer;
import com.uniquebook.utils.RdfModelUtil;
import java.util.List;

/**
 * getting individual customer
 * @author edris
 */
public class CustomerDao {
    
    private Model model;
            
    public CustomerDao() {
        model = RdfModelUtil.createModelFromUrl();
    }
    
    public void addCustomer(Customer b){
        try {
            
        } catch (Exception e) {
        }
        
    }
    
    
    public void deleteCustomer(int productNumber){
        
    }
    
    public void updateCustomer(Customer b){
        
    }
    
    public List<Customer> getAllCustomer(){
        return null;
        
    }
    
    public List<Customer> getCustomerByName(){
        return null;
        
    }
    
    
}
