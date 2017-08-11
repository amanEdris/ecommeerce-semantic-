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
        //test can list kids book
        KidsBookDao b = new KidsBookDao();
        System.out.println("Kids books model list:"+b.getAllKidsBook());
        
        //test can list non fictional books
        NonFictionalBooksDao bi= new NonFictionalBooksDao();
        System.out.println("nonfictional books  model list:"+bi.getAllNonFictionalBook());

        //test can list fictional books
        FictionalBooksDao bw = new FictionalBooksDao();
        System.out.println("Fictional booss model list"+bw.getAllFictionalBook());
        //NonFictionalBooksDao bb= new NonFictionalBooksDao();
        //System.out.println("why you will never scceceed"+bb.getAllNonFictionalBookByCategory("Biography"));
    }
    
    
    
}
