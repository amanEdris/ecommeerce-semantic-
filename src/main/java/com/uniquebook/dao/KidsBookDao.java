/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.update.UpdateAction;
import com.uniquebook.models.KidsBook;
import com.uniquebook.utils.HelperUtil;
import com.uniquebook.utils.FusekiClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edris
 */
public class KidsBookDao {

    private Model model;
    private HelperUtil helperUtil;

    public KidsBookDao() {
        helperUtil = new HelperUtil();
    }

    public void addKidsBook(KidsBook b) {
        String insertQuery = FusekiClient.PREFIX;
        insertQuery += "INSERT\n"
                + "{\n"
                + " r:" + helperUtil.generateNames() + "   a   r:KidsBook;\n"
                + "          r:productNumber \"" + b.getProductNumber() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasISBN \"" + b.getIsbn() + "\"^^xsd:string ;\n"
                + "          r:hasPrice \"" + b.getPrice() + "\"^^xsd:float ;\n"
                + "          r:hasQuantity \"" + b.getQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasPublisher \"" + b.getPublisher() + "\"^^xsd:string ;\n"
                + "          r:hasPublishedYear \"" + b.getStringPublishedYear() + "\"^^xsd:date ;\n"
                + "          r:hasKidsBookCategory \"" + b.getCategory() + "\"^^xsd:string ;\n"
                + "          r:hasAuthor \"" + b.getAuthor() + "\"^^xsd:string ;\n"
                + "          r:hasDescription \"" + b.getDescription() + "\"^^xsd:string ;\n"
                + "          r:hasTitle \"" + b.getTitle() + "\"^^xsd:string ;\n"
                + "          r:hasImage \"" + b.getImagepath() + "\"^^xsd:string ."
                + "}";

        System.out.println(insertQuery);
        UpdateAction.parseExecute(insertQuery, model);
        
    }

    public void updateKidsBook(KidsBook b) {

    }

    public List<KidsBook> getAllKidsBook() {
        List<KidsBook> books = new ArrayList<KidsBook>();
        String BooksQuery = FusekiClient.PREFIX;
        BooksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + " ?x a r:KidsBook;\n"
                + "          r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber ?productNumber ;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .\n"
                + "} ";
        queryAllBooks(BooksQuery, books);
        return books;
    }

  

    public List<KidsBook> getAllKidsBookByCategory(String category) {
        List<KidsBook> books = new ArrayList<KidsBook>();
        String BooksQuery = FusekiClient.PREFIX;
        BooksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{\n"
                + " ?x a r:KidsBook;\n"
                + "          r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber ?productNumber ;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .\n"
                + " FILTER regex(?kidsCategory, \"" + category + "\", \"i\")\n"
                + "} ";
        queryAllBooks(BooksQuery, books);
        return books;

    }

    public KidsBook getKidsBookByISBN(String Isbn) {
        KidsBook book = new KidsBook();
        String booksQuery = FusekiClient.PREFIX;

        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:KidsBook;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image ;\n"
                + "   FILTER (sameTerm(?isbn ,\"" + Isbn + "\"^^xsd:string))\n"
                + "\n"
                + " }";

        queryBook(booksQuery, book);
        return book;

    }

    public KidsBook getKidBookByProductNumber(int productNumber) {
        KidsBook book = new KidsBook();
        String booksQuery = FusekiClient.PREFIX;

        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:KidsBook;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image ;\n"
                + "   FILTER (?productNumber  = " + productNumber + " )\n"
                + "\n"
                + " }";

        //System.out.println("get book query+" + booksQuery);

        queryBook(booksQuery, book);
        return book;

    }

    private void queryBook(String booksQuery, KidsBook book) {
        try {
            ResultSet results = FusekiClient.queryFUSEKI(booksQuery);
           
            while (results.hasNext()) {

                QuerySolution row = results.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                book.setAuthor(row.getLiteral("author").getString());
                book.setImagepath(row.getLiteral("image").getString());
                book.setIsbn(row.getLiteral("isbn").getString());
                Date deliveryDate = sdf.parse(row.getLiteral("publishedyear").getValue().toString());
                book.setTitle(row.getLiteral("title").getString());
                book.setPublishedYear(deliveryDate);
                book.setPublisher(row.getLiteral("publisher").getString());
                book.setQuantity(row.getLiteral("quantity").getInt());
                book.setDescription(row.getLiteral("description").getString());
                book.setPrice(row.getLiteral("price").getFloat());
                book.setQuantity(row.getLiteral("quantity").getInt());
                book.setProductNumber(row.getLiteral("productNumber").getInt());
                //System.out.println(row.getLiteral("kidsCategory").getValue().toString());
                book.setCategory(row.getLiteral("kidsCategory").getValue().toString());

            }
        } catch (ParseException ex) {
            Logger.getLogger(FictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KidsBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      private void queryAllBooks(String BooksQuery, List<KidsBook> books) {
        try {
            ResultSet results = FusekiClient.queryFUSEKI(BooksQuery);

            while (results.hasNext()) {

                QuerySolution row = results.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                KidsBook b = new KidsBook();
                b.setAuthor(row.getLiteral("author").getString());
                b.setImagepath(row.getLiteral("image").getString());
                b.setIsbn(row.getLiteral("isbn").getString());
                Date deliveryDate = sdf.parse(row.getLiteral("publishedyear").getValue().toString());
                b.setTitle(row.getLiteral("title").getString());
                b.setPublishedYear(deliveryDate);
                b.setPublisher(row.getLiteral("publisher").getString());
                b.setQuantity(row.getLiteral("quantity").getInt());
                b.setDescription(row.getLiteral("description").getString());
                b.setPrice(row.getLiteral("price").getFloat());
                b.setQuantity(row.getLiteral("quantity").getInt());
                b.setProductNumber(row.getLiteral("productNumber").getInt());
                String category = row.getLiteral("kidsCategory").getValue().toString();
                b.setCategory(category);

                //System.out.println("book added with category" + b.getCategory() + "where category name is:" + category);

                books.add(b);

            }
        } catch (ParseException ex) {
            Logger.getLogger(NonFictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KidsBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
