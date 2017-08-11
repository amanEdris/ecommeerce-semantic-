/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.update.UpdateAction;
import com.uniquebook.utils.RdfModelUtil;

/**
 *
 * @author edris
 */
public class BookDao {

    private Model model;

    public BookDao() {
        model = RdfModelUtil.createModelFromUrl();
    }

    public void deleteFictionalBooks(int productNumber) {
        String deleteQuery = RdfModelUtil.PREFIX;
        deleteQuery += "DELETE {?s ?p ?o}\n"
                + "       \n"
                + "WHERE  { ?s ?p ?o ."
                + "         ?s r:productNumber ?r. \n"
                + "         FILTER (?o = " + productNumber + ") \n"
                + "}	";

        System.out.println(deleteQuery);
        UpdateAction.parseExecute(deleteQuery, model);
    }
    
   

}
