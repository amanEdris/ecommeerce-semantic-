/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.update.UpdateAction;
import com.uniquebook.models.Book;
import com.uniquebook.utils.RdfModelUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edris
 */
public class BookDao {

    private FictionalBooksDao fictionDao;
    private NonFictionalBooksDao nonFcitionDao;
    private KidsBookDao kidDao;

    private Model model;

    public BookDao() {
        model = RdfModelUtil.createModelFromUrl();
        fictionDao = new FictionalBooksDao();
        nonFcitionDao = new NonFictionalBooksDao();
        kidDao = new KidsBookDao();
    }

    public void deleteBooks(int productNumber) {
        FileOutputStream stream = null;
        try {
            String deleteQuery = RdfModelUtil.PREFIX;
            deleteQuery += "DELETE {?s ?p ?o}\n"
                    + "       \n"
                    + "WHERE  { ?s ?p ?o ."
                    + "         ?s r:productNumber ?r. \n"
                    + "         FILTER (?o = " + productNumber + ") \n"
                    + "}	";
            System.out.println(deleteQuery);
            UpdateAction.parseExecute(deleteQuery, model);
            File file = new File(RdfModelUtil.RDF_DATA_MODEL_PATH);
            stream = new FileOutputStream(file);
            model.write(stream, "TTL");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Book getBookbyProductNumber(int productNumber) {
        Book b = new Book();
        b = nonFcitionDao.getNonFictionalByProductNumber(productNumber);
        if(b.equals(null)){
           b =  kidDao.getKidBookByProductNumber(productNumber);
        }else{
           b = fictionDao.getFictionalBookByProductNumber(productNumber);
        }
        return b;
    }

}
