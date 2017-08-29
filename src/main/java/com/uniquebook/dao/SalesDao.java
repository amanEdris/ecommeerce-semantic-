/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.Product;
import com.uniquebook.models.Sale;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edris
 */
public class SalesDao {

    private HelperUtil helperUtil;
    private BookDao bookDao;

    public SalesDao() {
        helperUtil = new HelperUtil();
        bookDao = new BookDao();
    }

    public void addSale(Sale b) {

    }

    public String[] addSales(List<Sale> sales) {
        String salesSubjectNames[] = new String[sales.size()];
        int i = 0;
        for (Sale sale : sales) {

            try {
                String tempsalesSubject = helperUtil.generateNames();
                String tempproductSubjectName = bookDao.getSubjectName(sale.getProduct());
                String insertQuery = FusekiClient.PREFIX;
                insertQuery += "INSERT DATA\n"
                        + "{\n"
                        + " r:" + tempsalesSubject + "   a   r:Sale;\n"
                        + "            r:hasProductSalesQuantity \"" + sale.getProductQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                        + "            r:hasProduct r:" + tempproductSubjectName + "."
                        + "}";
                FusekiClient.insertFUSEKI(insertQuery);
                salesSubjectNames[i] = tempsalesSubject;
                i++;

            } catch (Exception ex) {
                Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return salesSubjectNames;

    }

    /**
     * Decrement quantity when delivery is processed!
     */
    public void decrementStock(Sale s) {

        try {
            int stockQuantity = s.getProduct().getQuantity() - s.getProductQuantity();
            if (stockQuantity < 0) {
                stockQuantity = 0;
            }

            String queryUpdate = FusekiClient.PREFIX;
            queryUpdate += "DELETE\n"
                    + "{\n"
                    + " ?s r:hasQuantity  \"" + s.getProduct().getQuantity() + "\"^^xsd:nonNegativeInteger;\n"
                    + "}\n"
                    + "INSERT\n"
                    + "{\n"
                    + " ?s r:hasQuantity   \"" + stockQuantity + "\"^^xsd:nonNegativeInteger;\n"
                    + "}\n"
                    + "WHERE \n"
                    + "{  \n"
                    + " ?s r:productNumber  \"" + s.getProduct().getProductNumber() + "\"^^xsd:nonNegativeInteger;\n"
                    + "}\n"
                    + "";
            FusekiClient.insertFUSEKI(queryUpdate);
            System.out.println("insert query for sale stock quantituy: " + queryUpdate);
        } catch (Exception ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteSales(int orderNumber) {

    }

    public void updateSales(Sale b) {

    }

    public List<Sale> getAllSalesByOrderNumber(String orderNumber) {
        List<Sale> sales = new ArrayList<Sale>();
        try {
            String querySales = FusekiClient.PREFIX;
            querySales += "SELECT  DISTINCT ?description ?quantity ?image ?price ?title ?productNumber ?productQuantity\n"
                    + "{\n"
                    + "     ?o  a r:Order.\n"
                    + "  	?o r:orderNumber ?orderNumber.\n"
                    + "    ?o r:hasSales ?sale.\n"
                    + "    ?sale r:hasProductSalesQuantity  ?productQuantity.\n"
                    + "    ?sale  r:hasProduct  ?product.\n"
                    + "     ?product r:productNumber ?productNumber.\n"
                    + "  ?product  r:hasTitle  ?title.\n"
                    + "  ?product    r:hasPrice ?price.\n"
                    + "   ?product r:hasImage ?image.\n"
                    + "  ?product   r:hasDescription ?description.\n"
                    + "   ?product r:hasQuantity ?quantity.\n"
                    + "  \n"
                    + "   FILTER (?orderNumber = \"" + orderNumber + "\"^^xsd:string )\n"
                    + "\n"
                    + "}";

            ResultSet results = FusekiClient.queryFUSEKI(querySales);
            int tempProductNumber = 0;
            while (results.hasNext()) {
                QuerySolution row = results.next();

                Product p = new Product();
                p.setDescription(row.getLiteral("description").getString());
                p.setImagepath(row.getLiteral("image").getString());
                p.setPrice(row.getLiteral("price").getFloat());
                p.setProductName(row.getLiteral("title").getString());
                p.setProductNumber(row.getLiteral("productNumber").getInt());
                p.setQuantity(row.getLiteral("quantity").getInt());

                Sale sale = new Sale(row.getLiteral("productQuantity").getInt(), p);
                if (tempProductNumber == row.getLiteral("productNumber").getInt()) {

                } else {
                    if (sales.contains(sale) == false) {
                        sales.add(sale);
                        tempProductNumber = row.getLiteral("productNumber").getInt();
                    }
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;
    }

    public int getSalesCountForByOrderNumber(String orderNumber) {
        int count = 0;
        try {
            
            
            String salesQuery = FusekiClient.PREFIX;
            salesQuery += "SELECT (count(?o) As ?salesCount)"
                    + "   WHERE { "
                    + "   ?o rdf:type r:Order."
                    + "   ?o r:orderNumber ?orderNumber.\n"
                    + "    ?o r:hasSales ?sale.\n"
                    + "    ?sale r:hasProductSalesQuantity  ?productQuantity.\n"
                    + "    ?sale  r:hasProduct  ?product.\n"
                    + "  FILTER ( ?orderNumber = \"" + orderNumber + "\") \n"
                    + "}";
            ResultSet results = FusekiClient.queryFUSEKI(salesQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                count = row.getLiteral("salesCount").getInt();
            }
        } catch (Exception ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public String[] getSalesByOrder(String orderNumber) {
        String salesSubjectNames[] = new String[this.getSalesCountForByOrderNumber(orderNumber)];

        try {
            String salesSubjectQuery = FusekiClient.PREFIX;
            salesSubjectQuery += "SELECT  ?sale "
                    + "   WHERE { "
                    + "   ?o rdf:type r:Order."
                    + "   ?o r:orderNumber ?orderNumber.\n"
                    + "    ?o r:hasSales ?sale.\n"
                    + "    ?sale r:hasProductSalesQuantity  ?productQuantity.\n"
                    + "    ?sale  r:hasProduct  ?product.\n"
                    + "  FILTER ( ?orderNumber = \"" + orderNumber + "\") \n"
                    + "}";
            ResultSet results = FusekiClient.queryFUSEKI(salesSubjectQuery);
            int i = 0;
            while (results.hasNext()) {
                QuerySolution row = results.next();
                 salesSubjectNames[i]  = row.getResource("sale").getLocalName();
                i++;
            }

        } catch (Exception ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesSubjectNames;

    }

}
