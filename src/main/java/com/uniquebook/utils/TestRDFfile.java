/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.utils;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.models.NonFictionalBook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author edris
 */
public class TestRDFfile {

    /**
     * Prefix used for all Data access objects to query
     */
    public static String PREFIX = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
            + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
            + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
            + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> ";

    public static final String RDF_DATA_MODEL_PATH = "src/onto/data.ttl";

    private Model model = null;
    //the url of rdf individuals created 
    private static String dataUrl = "onto/data.ttl";
    //File datafile = new File(PMML_file_path);

    public static Model createModelFromUrl() throws Exception {

        Model model = null;

        //URL u = new URL(dataUrl); 
        //model = RDFDataMgr.loadModel(dataUrl, "TTL");
//        model = ModelFactory.createDefaultModel();
//        model.read(dataUrl, null, "TTL");
        return model;
    }

    public static void main(String[] args) {
        try {
            FileOutputStream outstream = null;
            Model m = TestRDFfile.createModelFromUrl();
            if (m.isEmpty()) {
                System.out.println("what is read=>"+m.toString());
            }
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
            //System.out.println("you have added a book" + b.getNonFictionalByProductNumber(c.getProductNumber()));
            TestRDFfile testwrite = new TestRDFfile();
            testwrite.writeToModelFile(m, dataUrl);
            m.write(System.out, "N3");
        } catch (Exception ex) {
            Logger.getLogger(TestRDFfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void writeToModelFile(Model m, String filePath) {
        OutputStream output = null;
        try {
            System.out.println("got into class" + filePath);
            // ClassLoader classLoader = getClass().getClassLoader();
            System.out.println("loaded class" + filePath);
            // File file = new File(classLoader.getResource(filePath).getFile());
            File file = new File("data.ttl");
            System.out.println("the is read" + file.toString());
            output = new FileOutputStream(file);
            m.write(System.out, "N3");
            System.out.println("reasched here");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestRDFfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(TestRDFfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
