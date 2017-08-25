/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.hp.hpl.jena.reasoner.rulesys.builtins.Now;
import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.models.Sale;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openrdf.model.datatypes.XMLDatatypeUtil;

/**
 *
 * @author edris
 */
public class testSales {
           public static void main(String[] args) throws Exception {
                           
            //create book product
//            NonFictionalBook b = new NonFictionalBook();
//            b.setAuthor("jango");
//            b.setImagepath("path");
//            b.setIsbn("isbn");
//            b.setPublishedYear(null);
//            b.setPublisher("maman");
//            b.setQuantity(100);
//            b.setDescription("a book product");
//            b.setPrice(12);
//            b.setQuantity(2);
//            b.setProductNumber(30);
//            b.setCategory("String");//how to handle category 
//            //b.category(); set book category
//            
            
//            //Create sales data
//            Sale s= new Sale(12,b);
//            System.out.print(s.toString());

//            Date deliveryDate = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String date = sdf.format(deliveryDate);
//            Date deliver = sdf.parse(date);
            
//            System.out.println("what is date:"+deliver);


            Date deliveryDate = new Date();  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date tempDateStartMax = new Date(deliveryDate.getTime() + 7 * 24 * 3600 * 1000);
            String deliverydate = XMLDatatypeUtil.normalizeDateTime(sdf.format(tempDateStartMax));

            System.out.println("what is date: "+ deliverydate);
           }

               
    
}
