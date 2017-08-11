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

    public FictionalBooksDao() {
        model = RdfModelUtil.createModelFromUrl();
    }

    public void addFictionalBooks(FictionalBook b) {

    }

    public void deleteFictionalBooks(int productNumber) {

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

    public List<FictionalBook> getAllFictionalBookByCategory() {
        return null;

    }

    public List<FictionalBook> getFictionalBookById() {
        return null;

    }

}
