/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.update.UpdateAction;
import com.uniquebook.models.FictionalBook;
import com.uniquebook.utils.HelperUtil;
import com.uniquebook.utils.RdfModelUtil;
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
public class FictionalBooksDao {

    private Model model;
    private HelperUtil helperUtil;

    public FictionalBooksDao() {
        model = RdfModelUtil.createModelFromUrl();
        helperUtil = new HelperUtil();
    }

    /**
     * How to presist model changes to remote file upate and delete function
     * @param b 
     */
    public void addFictionalBooks(FictionalBook b) {

        String insertQuery = RdfModelUtil.PREFIX;
        insertQuery += "INSERT\n"
                + "{\n"
                + " r:" + helperUtil.generateNames() + "   a   r:FictionAndLiterature;\n"
                + "          r:productNumber \"" + b.getProductNumber() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasISBN \"" + b.getIsbn() + "\"^^xsd:string ;\n"
                + "          r:hasPrice \"" + b.getPrice() + "\"^^xsd:float ;\n"
                + "          r:hasQuantity \"" + b.getQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasPublisher \"" + b.getPublisher() + "\"^^xsd:string ;\n"
                + "          r:hasPublishedYear \"" + b.getStringPublishedYear() + "\"^^xsd:date ;\n"
                + "          r:hasFictionalCategory \"" + b.getCategory() + "\"^^xsd:string ;\n"
                + "          r:hasAuthor \"" + b.getAuthor() + "\"^^xsd:string ;\n"
                + "          r:hasDescription \"" + b.getDescription() + "\"^^xsd:string ;\n"
                + "          r:hasTitle \"" + b.getTitle() + "\"^^xsd:string ;\n"
                + "          r:hasImage \"" + b.getImagepath() + "\"^^xsd:string ."
                + "}";

        System.out.println(insertQuery);
        UpdateAction.parseExecute(insertQuery, model);
        
    }

    public void updateFictionalBooks(FictionalBook b) {

    }

    public List<FictionalBook> getAllFictionalBook() {
        List<FictionalBook> books = new ArrayList<FictionalBook>();
        String BooksQuery = RdfModelUtil.PREFIX;
        BooksQuery += "SELECT  * WHERE{\n"
                + "   ?x a r:FictionAndLiterature;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasFictionalCategory ?fictionalCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .   \n"
                + "}";
        try {
            Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {

                QuerySolution row = results.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                FictionalBook b = new FictionalBook();

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
                System.out.println(row.getLiteral("fictionalCategory").getValue().toString());
                b.setCategory(FictionalBook.FictionalCategory.getEnumByString(row.getLiteral("fictionalCategory").getValue().toString()));
                books.add(b);

            }
        } catch (ParseException ex) {
            Logger.getLogger(FictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;

    }

    public List<FictionalBook> getAllFictionalBookByCategory(String category) {
        List<FictionalBook> books = new ArrayList<FictionalBook>();
        String BooksQuery = RdfModelUtil.PREFIX;
        BooksQuery += "SELECT  * WHERE{\n"
                + "   ?x a r:FictionAndLiterature;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasFictionalCategory ?fictionalCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .   \n"
                + "   FILTER regex(?fictionalCategory, \"" + category + "\", \"i\")\n"
                + "}";
        try {
            Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {

                QuerySolution row = results.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                FictionalBook b = new FictionalBook();

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
                System.out.println(row.getLiteral("fictionalCategory").getValue().toString());
                b.setCategory(FictionalBook.FictionalCategory.getEnumByString(row.getLiteral("fictionalCategory").getValue().toString()));
                books.add(b);

            }
        } catch (ParseException ex) {
            Logger.getLogger(FictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;

    }

    public FictionalBook getFictionalBookByISBN(String ISBN) {
        FictionalBook book = new FictionalBook();
        String booksQuery = RdfModelUtil.PREFIX;

        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:FictionAndLiterature;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasFictionalCategory ?fictionalCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image ;\n"
                + "   FILTER (sameTerm(?isbn ,\"" + ISBN + "\"^^xsd:string))\n"
                + "\n"
                + " }";

        queryBook(booksQuery, book);
        return book;

    }

    public FictionalBook getFictionalBookByProductNumber(int productNumber) {
        FictionalBook book = new FictionalBook();
        String booksQuery = RdfModelUtil.PREFIX;

        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:FictionAndLiterature;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasFictionalCategory ?fictionalCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image ;\n"
                + "   FILTER (?productNumber  = " + productNumber + " )\n"
                + "\n"
                + " }";

        System.out.println("get book query+" + booksQuery);

        queryBook(booksQuery, book);
        return book;

    }

    private void queryBook(String booksQuery, FictionalBook book) {
        try {
            Query query = QueryFactory.create(booksQuery, Syntax.syntaxARQ);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();

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
                System.out.println(row.getLiteral("fictionalCategory").getValue().toString());
                book.setCategory(FictionalBook.FictionalCategory.getEnumByString(row.getLiteral("fictionalCategory").getValue().toString()));

            }
        } catch (ParseException ex) {
            Logger.getLogger(FictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
