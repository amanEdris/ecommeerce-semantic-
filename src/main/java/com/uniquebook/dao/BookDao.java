/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.uniquebook.models.Book;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.models.Product;

/**
 *
 * @author edris
 */
public class BookDao {

    private FictionalBooksDao fictionDao;
    private NonFictionalBooksDao nonFcitionDao;
    private KidsBookDao kidDao;

    public BookDao() {
        fictionDao = new FictionalBooksDao();
        nonFcitionDao = new NonFictionalBooksDao();
        kidDao = new KidsBookDao();
    }

    /**
     * public void deleteBooks(int productNumber) { FileOutputStream stream =
     * null; try { String deleteQuery = FusekiClient.PREFIX; deleteQuery +=
     * "DELETE {?s ?p ?o}\n" + " \n" + "WHERE { ?s ?p ?o ." + " ?s
     * r:productNumber ?r. \n" + " FILTER (?o = " + productNumber + ") \n" + "}
     * "; System.out.println(deleteQuery);
     * UpdateAction.parseExecute(deleteQuery, model); File file = new
     * File(FusekiClient.RDF_DATA_MODEL_PATH); stream = new
     * FileOutputStream(file); model.write(stream, "TTL"); } catch
     * (FileNotFoundException ex) {
     * Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex); }
     * finally { try { stream.close(); } catch (IOException ex) {
     * Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex); }
     * }
    }*
     */
    public Book getBookbyProductNumber(int productNumber, String category) {
        Book b = new Book();

        if (NonFictionalBook.NonFictionalCategory.getEnumByString(category) != null) {
            b = nonFcitionDao.getNonFictionalByProductNumber(productNumber);
            return b;
        } else if (KidsBook.kidsBookCategory.getEnumByString(category) != null) {
            b = kidDao.getKidBookByProductNumber(productNumber);

        } else {
            b = fictionDao.getFictionalBookByProductNumber(productNumber);

        }

        return b;
    }

    public Product getProductbyProductNumber(int productNumber, String category) throws Exception {
        if(productNumber == 0 || category == null){
           throw new Exception("the product doesn't exist in our system!");
        }
        Book b = this.getBookbyProductNumber(productNumber, category);
        Product p = new Product();
        p.setDescription(b.getDescription());
        p.setImagepath(b.getImagepath());
        p.setPrice(b.getPrice());
        p.setProductName(b.getTitle());
        p.setProductNumber(b.getProductNumber());
        p.setQuantity(b.getQuantity());
        return p;
    }

}
