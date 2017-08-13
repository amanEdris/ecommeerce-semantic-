/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.rdf.model.Model;
import com.uniquebook.models.Order;
import com.uniquebook.utils.RdfModelUtil;
import java.util.List;

/**
 *
 * @author edris
 */
public class OrderDao {
    
    private Model model;
            
    public OrderDao() {
        model = RdfModelUtil.createModelFromUrl();
    }
    
    
    public void addOrder(Order b){
        
    }
    
    
    public void deleteOrder(int orderNumber){
        
    }
    
    public void updateOrder(Order b){
        
    }
    
    public List<Order> getAllOrder(){
        return null;
        
    }
    
    public List<Order> getOrderByName(){
        return null;
        
    }
    
    
}
