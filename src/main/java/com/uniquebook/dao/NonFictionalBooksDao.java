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
import com.uniquebook.models.NonFictionalBook;
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
public class NonFictionalBooksDao {

    private Model model;
    private HelperUtil helperUtil;

    public NonFictionalBooksDao() {
        model = RdfModelUtil.createModelFromUrl();
        helperUtil = new HelperUtil();

    }

    public void addNonFictionalBooks(NonFictionalBook b) {
           String insertQuery = RdfModelUtil.PREFIX;
        insertQuery += "INSERT\n"
                + "{\n"
                + " r:"+helperUtil.generateNames() + "   a   r:Nonfiction;\n"
                + "          r:productNumber \"" + b.getProductNumber() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasISBN \"" + b.getIsbn() + "\"^^xsd:string ;\n"
                + "          r:hasPrice \"" + b.getPrice() + "\"^^xsd:float ;\n"
                + "          r:hasQuantity \"" + b.getQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasPublisher \"" + b.getPublisher() + "\"^^xsd:string ;\n"
                + "          r:hasPublishedYear \"" + b.getStringPublishedYear() + "\"^^xsd:date ;\n"
                + "          r:hasNonFictionalCategory \"" + b.getCategory() + "\"^^xsd:string ;\n"
                + "          r:hasAuthor \"" + b.getAuthor() + "\"^^xsd:string ;\n"
                + "          r:hasDescription \"" + b.getDescription() + "\"^^xsd:string ;\n"
                + "          r:hasTitle \"" + b.getTitle() + "\"^^xsd:string ;\n"
                + "          r:hasImage \"" + b.getImagepath() + "\"^^xsd:string ."
                + "}";

        System.out.println(insertQuery);
        UpdateAction.parseExecute(insertQuery, model);
    }

 
    public void updateNonFictionalBooks(NonFictionalBook b) {

    }

    public List<NonFictionalBook> getAllNonFictionalBook() {
        List<NonFictionalBook> books = new ArrayList<NonFictionalBook>();
        String BooksQuery = RdfModelUtil.PREFIX;
        BooksQuery += "select * where{ \n"
                + "  ?x a r:Nonfiction;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasNonFictionalCategory ?nonFictionalCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .\n"
                + "\n"
                + " } ";
        try {
            Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {

                QuerySolution row = results.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                NonFictionalBook b = new NonFictionalBook();

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
                String category = row.getLiteral("nonFictionalCategory").getValue().toString().trim();
                b.setCategory(NonFictionalBook.NonFictionalCategory.getEnumByString(category));
                books.add(b);
                
                System.out.println("book added with category" + b.getCategory()+"where category name is:"+category);

            }
        } catch (ParseException ex) {
            Logger.getLogger(NonFictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;

    }

    public List<NonFictionalBook> getAllNonFictionalBookByCategory(String category) {

        List<NonFictionalBook> books = new ArrayList<NonFictionalBook>();
        String BooksQuery = RdfModelUtil.PREFIX;
        BooksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:Nonfiction;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasNonFictionalCategory ?nonFictionalCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .\n"
                + "\n"
                + "   FILTER regex(?nonFictionalCategory, \""+category+"\", \"i\")\n"
                + "\n"
                + " }";
        try {
            Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {

                QuerySolution row = results.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                NonFictionalBook b = new NonFictionalBook();

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
                String categor = row.getLiteral("nonFictionalCategory").getValue().toString();
                b.setCategory(NonFictionalBook.NonFictionalCategory.getEnumByString(categor));
                books.add(b);

            }
        } catch (ParseException ex) {
            Logger.getLogger(NonFictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;

    }

public NonFictionalBook getNonFictionalBookByISBN(String ISBN) {
        NonFictionalBook book= new   NonFictionalBook();
        String booksQuery = RdfModelUtil.PREFIX;
        
        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:Nonfiction;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasNonFictionalCategory ?nonFictionalCategory ;\n"
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


    public NonFictionalBook getNonFictionalByProductNumber(int productNumber) {
        NonFictionalBook book = new NonFictionalBook();
        String booksQuery = RdfModelUtil.PREFIX;

        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:Nonfiction;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasNonFictionalCategory ?nonFictionalCategory ;\n"
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

    private void queryBook(String booksQuery, NonFictionalBook book) {
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
                System.out.println(row.getLiteral("nonFictionalCategory").getValue().toString());
                book.setCategory(NonFictionalBook.NonFictionalCategory.getEnumByString(row.getLiteral("nonFictionalCategory").getValue().toString()));

            }
        } catch (ParseException ex) {
            Logger.getLogger(FictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
