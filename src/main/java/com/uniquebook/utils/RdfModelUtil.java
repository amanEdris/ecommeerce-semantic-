/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.utils;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * create local data store model
 */
public class RdfModelUtil {
    /**
     * Prefix used for all Data access objects to query 
     */
    public static String PREFIX = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
            + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
            + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
            + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> ";
    
    public static  final String RDF_DATA_MODEL_PATH = "src/onto/data.ttl";

    
    
    private Model model = null;
    //the url of rdf individuals created 
    private static String dataUrl = "http://localhost:8080/UniqueBookApp/onto/data.ttl";

    public static Model createModelFromUrl() {
        
        Model model = null;
        try {
            URL u = new URL(dataUrl); 
            model = FileManager.get().loadModel(u.toString(), "TTL");
        } catch (MalformedURLException ex) {
        }
        return model;
    }
    
    
    
    

}
