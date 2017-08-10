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

    public Model createModelFromUrl(String url) {
        Model model = null;
        try {
            URL u = new URL(url);
            model = FileManager.get().loadModel(u.toString(), "TTL");
        } catch (MalformedURLException ex) {
        }
        return model;
    }
    
}
