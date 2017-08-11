/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.dao.FictionalBooksDao;
import com.uniquebook.dao.KidsBookDao;
import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.models.FictionalBook;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.NonFictionalBook;
import java.util.Date;

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
        System.out.println(nonficational.getNonFictionalBookByISBN("1373883389"));
        System.out.println(nonficational.getNonFictionalByProductNumber(11));

        //System.out.println(b.getKidsBookByISBN("172343883389"));
        // System.out.println(bw.getFictionalBookByProductNumber(8));
        //System.out.println(b.getKidsBookByISBN("172343883389"));
        //System.out.println(b.getKidBookByProductNumber(20));
        Date deliveryDate = new Date();

        FictionalBook bbn = new FictionalBook();
        bbn.setAuthor("jango");
        bbn.setImagepath("path");
        bbn.setIsbn("1394029492");
        bbn.setPublishedYear(deliveryDate);
        bbn.setPublisher("maman");
        bbn.setQuantity(100);
        bbn.setDescription("a book product");
        bbn.setPrice(12);
        bbn.setQuantity(2);
        bbn.setProductNumber(30);
        bbn.setCategory("Romance");
        System.out.println("the book you added is:" + bbn.toString());
        bw.addFictionalBooks(bbn);
        System.out.println("you have added a book" + bw.getFictionalBookByISBN(bbn.getIsbn()));

        bw.deleteFictionalBooks(30);
        
        System.out.println("you deleted a book" + bw.getFictionalBookByProductNumber(30));

    }

}
