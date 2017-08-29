/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.Book;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.models.Product;
import com.uniquebook.utils.FusekiClient;
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

    public BookDao() {
        fictionDao = new FictionalBooksDao();
        nonFcitionDao = new NonFictionalBooksDao();
        kidDao = new KidsBookDao();
    }

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
        if (productNumber == 0 || category == null) {
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

    public String getSubjectName(Product p) {
        String subjectName = null;
        try {
            String selectQuery = null;

            selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT  ?x\n"
                    + "\n"
                    + "WHERE\n"
                    + "{ \n"
                    + "  ?x a ?o;\n"
                    + "     r:productNumber  \"" + p.getProductNumber() + "\"^^xsd:nonNegativeInteger.\n"
                    + "\n"
                    + " }";

            System.out.println("subject query for this product is:  " + selectQuery);

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                subjectName = row.getResource("x").getLocalName();
            }

        } catch (Exception ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectName;
    }

    //All Book products count 
    public int getBookProductCount() {
        int count = 0;
        try {
            String selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT (count(?x)+count(?b)+count(?c) As ?products)\n"
                    + "WHERE\n"
                    + "{\n"
                    + "{ \n"
                    + "  ?x a r:Nonfiction.\n"
                    + "\n"
                    + " } \n"
                    + "UNION\n"
                    + "{\n"
                    + " ?b a r:KidsBook.\n"
                    + "}\n"
                    + " UNION\n"
                    + "{\n"
                    + "   ?c a r:FictionAndLiterature.   \n"
                    + "}\n"
                    + "}";

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                count = row.getLiteral("products").getInt();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public boolean deleteBook(String subjetName) {
        boolean result = false;
        
        try {
            String deleteQuery = FusekiClient.PREFIX;
            deleteQuery += "DELETE { r:" + subjetName + " ?p ?o}\n"
                    + "WHERE  { \n"
                    + "       r:"+ subjetName + " ?p ?o . \n"
                    + "\n"
                    + "\n"
                    + "}	";
            
            FusekiClient.insertFUSEKI(deleteQuery);
            result = true;
           
        } catch (Exception ex) {
            result = false;
             System.err.println("for query book delete:"+ex.getLocalizedMessage());
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
