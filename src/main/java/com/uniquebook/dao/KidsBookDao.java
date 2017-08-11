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
import com.uniquebook.models.FictionalBook;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.NonFictionalBook;
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
public class KidsBookDao {

    private Model model;

    public KidsBookDao() {
        model = RdfModelUtil.createModelFromUrl();
    }

    public void KidsBookBooks(KidsBook b) {

    }

    public void deleteKidsBook(int productNumber) {

    }

    public void updateKidsBook(KidsBook b) {

    }

    public List<KidsBook> getAllKidsBook() {
        List<KidsBook> books = new ArrayList<KidsBook>();
        String BooksQuery = RdfModelUtil.PREFIX;
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
        try {
            Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();

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
                b.setCategory(KidsBook.kidsBookCategory.getEnumByString(category));

                System.out.println("book added with category" + b.getCategory() + "where category name is:" + category);

                books.add(b);

            }
        } catch (ParseException ex) {
            Logger.getLogger(NonFictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public List<KidsBook> getAllKidsBookByCategory(String category) {
        List<KidsBook> books = new ArrayList<KidsBook>();
        String BooksQuery = RdfModelUtil.PREFIX;
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
        try {
            Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();

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
                String c = row.getLiteral("kidsCategory").getValue().toString();
                b.setCategory(KidsBook.kidsBookCategory.getEnumByString(c));

                System.out.println("book added with category" + b.getCategory() + "where category name is:" + category);
                books.add(b);

            }
        } catch (ParseException ex) {
            Logger.getLogger(NonFictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;

    }

    public KidsBook getKidsBookByISBN(String Isbn) {
        KidsBook book = new KidsBook();
        String booksQuery = RdfModelUtil.PREFIX;

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
                System.out.println(row.getLiteral("kidsCategory").getValue().toString());
                book.setCategory(KidsBook.kidsBookCategory.getEnumByString(row.getLiteral("kidsCategory").getValue().toString()));

            }
        } catch (ParseException ex) {
            Logger.getLogger(FictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;

    }

}
