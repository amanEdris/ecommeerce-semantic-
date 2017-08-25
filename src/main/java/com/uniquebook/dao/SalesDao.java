/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.uniquebook.models.Product;
import com.uniquebook.models.Sale;
import com.uniquebook.utils.FusekiClient;
import com.uniquebook.utils.HelperUtil;
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
                    + " ?s r:hasQuantity  \"" +s.getProduct().getQuantity()+ "\"^^xsd:nonNegativeInteger;\n"
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
            System.out.println("insert query for sale stock quantituy: "+queryUpdate);
        } catch (Exception ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteSales(int orderNumber) {

    }

    public void updateSales(Sale b) {

    }

    public List<Sale> getAllSalesByOrderNumber() {
        return null;

    }

    public List<Sale> getSalesByOrder() {
        return null;

    }

}
