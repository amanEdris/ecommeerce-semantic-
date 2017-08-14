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
import com.hp.hpl.jena.update.UpdateFactory;
import com.hp.hpl.jena.update.UpdateProcessor;
import com.uniquebook.models.KidsBook;
import com.uniquebook.utils.HelperUtil;
import com.uniquebook.utils.FusekiClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.jena.update.UpdateExecutionFactory;

/**
 *
 * @author edris
 */
public class TestFuseki {

    private static String queryURL = "http://localhost:3030/ds/query";
    private static String updateQueryURL = "http://localhost:3030/ds/update";
    private static  HelperUtil helperUtil;

    public static void main(String[] args) throws Exception {
        List<KidsBook> books = new ArrayList<KidsBook>();
        String category = "Teens";
        String id = UUID.randomUUID().toString();
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
        ResultSet results = queryFUSEKI(BooksQuery);

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
            //String category = row.getLiteral("kidsCategory").getValue().toString();
            b.setCategory(category);

            //System.out.println("book added with category" + b.getCategory() + "where category name is:" + category);
            books.add(b);

        }

        System.out.print("The kids are:" + books.toString());
        Date deliveryDate = new Date();
        KidsBook b = new KidsBook();
        b.setAuthor("jango");
        b.setImagepath("./image/The Complete Works of William Shakespeare 1 copy-131x199.png");
        b.setIsbn("1394029492");
        b.setPublishedYear(deliveryDate);
        b.setPublisher("maman");
        b.setQuantity(100);
        b.setDescription("a book product");
        b.setPrice(12);
        b.setQuantity(2);
        b.setProductNumber(30);
        b.setCategory("Romance");
        
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
        
        
        
//    UpdateProcessor upp = UpdateExecutionFactory.createRemote( UpdateFactory.create(insertQuery),
//    "http://localhost:3030/ds/update"));
  // upp.execute();
        
    }

    private static ResultSet queryFUSEKI(String BooksQuery) {
        Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
        QueryExecution qe = QueryExecutionFactory.sparqlService(queryURL, query);
        ResultSet results = qe.execSelect();
        return results;
    }

}
