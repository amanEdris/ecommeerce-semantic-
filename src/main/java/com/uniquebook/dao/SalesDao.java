/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.rdf.model.Model;
import com.uniquebook.models.Sale;
import com.uniquebook.utils.RdfModelUtil;
import java.util.List;

/**
 *
 * @author edris
 */
public class SalesDao {
    
    
    private Model model;
            
    public SalesDao() {
        model = RdfModelUtil.createModelFromUrl();
    }
    
    public void addSales(Sale b){
        
    }
    
    
    public void deleteSales(int orderNumber){
        
    }
    
    public void updateSales(Sale b){
        
    }
    
    public List<Sale> getAllSalesByOrderNumber(){
        return null;
        
    }
    
    public List<Sale> getSalesByOrder(){
        return null;
        
    }
    
    
    
}
