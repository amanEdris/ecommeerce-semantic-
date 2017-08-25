/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.utils;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.update.UpdateExecutionFactory;

/**
 *
 * Class for handling query to FusekiDatabase
 */
public class FusekiClient {

    /**
     * Prefix used for all Data access objects to query
     */
    public static String PREFIX = "prefix r: <http://localhost:8080/UniqueBookshop/onto/Ecommerce.owl/>\n"
            + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
            + "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n"
            + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> ";

    public static final String QUERY_FUSEKI_CLIENT_URL = "http://localhost:3030/ds/query";
    public static final String UPDATE_FUSEKI_CLIENT_URL = "http://localhost:3030/ds/update";

    /**
     * 
     * @param BooksQuery
     * @return Result set from Db
     */
    public static ResultSet queryFUSEKI(String BooksQuery) throws Exception{
        Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
        QueryExecution qe = QueryExecutionFactory.sparqlService(QUERY_FUSEKI_CLIENT_URL, query);
        ResultSet results = qe.execSelect();
        return results;
    }
    
     public static boolean askFUSEKI(String BooksQuery) {
        Query query = QueryFactory.create(BooksQuery, Syntax.syntaxARQ);
        QueryExecution qe = QueryExecutionFactory.sparqlService(QUERY_FUSEKI_CLIENT_URL, query);
        boolean results = qe.execAsk();
        return results;
    }
    
    /**
     * 
     * @param updateQuery 
     */
    public static void insertFUSEKI(String updateQuery) throws Exception{
        ParameterizedSparqlString s = new ParameterizedSparqlString();
        s.setCommandText(updateQuery);
        org.apache.jena.update.UpdateRequest update = s.asUpdate();
        org.apache.jena.update.UpdateProcessor proc =  UpdateExecutionFactory.createRemote(update, UPDATE_FUSEKI_CLIENT_URL);
        proc.execute();
    }

}
