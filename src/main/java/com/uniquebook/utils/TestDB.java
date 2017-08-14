/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.utils;

import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.models.NonFictionalBook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RIOT;

/**
 *
 * @author edris
 */
public class TestDB {

    public static void main(String[] args) {
        FileOutputStream out = null;
        InputStream in = Utils.getResourceAsStream("onto/data.ttl");
        RIOT.init();
        Model model = ModelFactory.createDefaultModel(); // creates an in-memory Jena Model
        model.read(in, null, "TURTLE"); // parses an InputStream assuming RDF in Turtle format
        //System.out.println("out the shit you aint alone" + m.toString());
        NonFictionalBooksDao b = new NonFictionalBooksDao();
        Date deliveryDate = new Date();
        //System.out.println("no woman no cry" + b.getAllNonFictionalBook());
        NonFictionalBook c = new NonFictionalBook();
        c.setAuthor("jango");
        c.setImagepath("path");
        c.setIsbn("1394029492");
        c.setPublishedYear(deliveryDate);
        c.setPublisher("maman");
        c.setQuantity(100);
        c.setDescription("a book product");
        c.setPrice(12);
        c.setQuantity(2);
        c.setProductNumber(30);
        c.setCategory("Business Books");
        
        
        b.addNonFictionalBooks(c);
        c.setAuthor("jango");
        c.setImagepath("path");
        c.setIsbn("1394029492");
        c.setPublishedYear(deliveryDate);
        c.setPublisher("maman");
        c.setQuantity(100);
        c.setDescription("a book product");
        c.setPrice(12);
        c.setQuantity(2);
        c.setProductNumber(52);
        c.setCategory("Business Books");
        b.addNonFictionalBooks(c);

        
	       FileWriter output = null;

	try {

                
		output = new FileWriter("/Users/edris/Desktop/data.ttl");;

                model.write(output,"N3");
	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
    }

}
