/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.dao.FictionalBooksDao;
import com.uniquebook.dao.KidsBookDao;
import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.NonFictionalBook;

/**
 *
 * @author edris
 */
public class testDao {
    public static void main(String[] args) throws Exception {
        
        NonFictionalBooksDao nonficational = new NonFictionalBooksDao();
        //test can get non ficitonal list of books by category
        //System.out.println("non fictional book model list"+nonficational.getAllNonFictionalBookByCategory("Biography"));
         //System.out.println("nonfictional books  model list:"+bi.getAllNonFictionalBook());

        //test can search and list book by category for kids books
        KidsBookDao b = new KidsBookDao();
        //System.out.println("Kids book model list"+b.getAllKidsBookByCategory("Teen"));
        // System.out.println("Kids books model list:"+b.getAllKidsBook());

         FictionalBooksDao bw = new FictionalBooksDao();
         //System.out.println(bw.getAllFictionalBookByCategory("Romance"));
         // System.out.println("Kids books model list:"+b.getAllKidsBook());
         //System.out.println("Fictional booss model list"+bw.getAllFictionalBook());
         //System.out.println(bw.getFictionalBookByISBN("1394044949"));
         //System.out.println(nonficational.getNonFictionalBookByISBN("1373883389"));
         //System.out.println(b.getKidsBookByISBN("172343883389"));
    }
    
    
    
}
