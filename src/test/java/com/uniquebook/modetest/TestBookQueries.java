/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;
import com.uniquebook.models.FictionalBook;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.utils.RdfModelUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author edris
 */
public class TestBookQueries {

    public static String dataUrl = "http://localhost:8080/UniqueBookApp/onto/data.ttl";
    public static String PREFIX = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
            + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
            + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
            + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> ";

    public static void main(String[] args) throws Exception {
        RdfModelUtil RdfModelUtil = new RdfModelUtil();
        Model rdfDB = RdfModelUtil.createModelFromUrl();
        String cottageQuery;
        cottageQuery = PREFIX + "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
                + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
                + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
                + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "\n"
                + "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{\n"
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
                + " } \n"
                + "UNION\n"
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
                + "}\n"
                + " UNION\n"
                + "{\n"
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
                + "}\n"
                + "}";
        System.out.println(cottageQuery);
        Query query = QueryFactory.create(cottageQuery, Syntax.syntaxARQ);
        QueryExecution qe = QueryExecutionFactory.create(query, rdfDB);
        ResultSet results = qe.execSelect();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        

        while (results.hasNext()) {
            QuerySolution row = results.next();

            if (row.contains("nonFictionalCategory")) {
                System.out.println("non fictional book being constructed");
                System.out.println(row.getLiteral("nonFictionalCategory").getValue().toString());
                System.out.println(NonFictionalBook.NonFictionalCategory.getEnumByString(row.getLiteral("nonFictionalCategory").getValue().toString()));
                          
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
                b.setCategory(NonFictionalBook.NonFictionalCategory.getEnumByString(row.getLiteral("nonFictionalCategory").getValue().toString()));
                
                System.out.println("check out my book" +b.toString());

            }else if (row.contains("kidsCategory")){
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
                b.setCategory(KidsBook.kidsBookCategory.getEnumByString(row.getLiteral("kidsCategory").getValue().toString()));
                System.out.println("check out my book" +b.toString());

            }else{
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
                System.out.println("check out my book" +b.toString());

            }
        }

    }


}
