/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import antlr.StringUtils;
import com.uniquebook.dao.BookDao;
import com.uniquebook.dao.CustomerDao;
import com.uniquebook.dao.DeliveryDao;
import com.uniquebook.dao.FictionalBooksDao;
import com.uniquebook.dao.KidsBookDao;
import com.uniquebook.dao.ManagerDao;
import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.dao.OrderDao;
import com.uniquebook.models.Book;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Delivery;
import com.uniquebook.models.Location;
import com.uniquebook.models.Manager;
import com.uniquebook.models.Product;
import java.util.Date;

/**
 *
 * @author edris
 */
public class testDao {

    public static void main(String[] args) throws Exception {
        
        
        OrderDao orderDao = new OrderDao();
        orderDao.updateOrderStatus("1", "approved","pending");
        
        
        //20000 leagues under the sea by jules verne 1 copy-131x199.png
        //20000 Leagues Under the Sea by Jules Verne 1 copy-131x199.png
        
//        System.out.println(Integer.parseInt(null));
//        BookDao bookDao = new BookDao();

        //productNumber=22&category=Teens
//        
//        Book b = bookDao.getBookbyProductNumber(22, "Teens");
//
//        System.out.println("what now :"+b.toString());

//        OrderDao od = new OrderDao();
//        System.out.println(od.getOrderCount());
//        Product p = new Product();
//        p.setProductNumber(2);
//        
//        BookDao bb  = new BookDao();
//        System.out.println("book"+bb.getSubjectName(p));
//        
        /**
         * test location Dao
         *
         * r:uavzmgafmksuziacsomfnkmoekqlhhdpchojd a r:Sale ; r:hasProduct
         * r:truefale ; r:hasProductSalesQuantity "1"^^xsd:nonNegativeInteger .
         *
         * r:gbcyzxoqsuajzmwxpqr a r:Delivery ; r:hasDeliveryDate "Wed Aug 23
         * 19:43:23 EAT 2017"^^xsd:dateTime ; r:hasLocation r:null .
         *
         * r:mftkpeadgwhhhsyuphxowbpookqwewwvneeievnrgeyj a r:Order ;
         * r:hasCustomer r:edia ; r:hasDelivery r:gbcyzxoqsuajzmwxpqr ;
         * r:hasSales r:uavzmgafmksuziacsomfnkmoekqlhhdpchojd ; r:hasTotalPrice
         * "28.0"^^xsd:nonNegativeInteger ; r:orderNumber
         * "f3252e6b-1364-4e3d-bf21-658e64bd4dcd" ; r:orderStatus "pending" .
         */
//        Manager c = new Manager();
//        ManagerDao cd = new ManagerDao();
//        
//        c = cd.getManagerByEmailAndPassword("edi@gmail.com", "ed");
//        
//        System.out.println("manager data is:"+c.toString());
//        
        Customer c = new Customer();
        CustomerDao cd = new CustomerDao();

//        String name = cd.getSubjectName("fljori@gmail.com");
//        System.out.println("The  subject is: "+name);
//        cd.checkCustomerEmailIsFree("fljori@gmail.com");
        Location l = new Location();
        l.setAddress("Kirstinharju 1b 21");
        l.setCity("Espoo");
        l.setCountry("Finland");
        l.setPostalCode("20590");

        //how to XSD date and time to Java date and time
//        Date d = new Date("2017", "09", "09", "10", "20", "15");
//        Delivery d = new Delivery("2017-09-09T10:20:15", l);
//        DeliveryDao dd = new  DeliveryDao();
//        dd.addDelivery(delivery);
//        c = cd.getCustomerByEmailAndPassword("fljori@gmail.com", "fljori");
//        
//        System.out.println("manager data is:"+c.toString());
        NonFictionalBooksDao nonficational = new NonFictionalBooksDao();
        //test can get non ficitonal list of books by category
        //System.out.println("non fictional book model list"+nonficational.getAllNonFictionalBookByCategory("Biography"));
        //System.out.println("nonfictional books  model list:"+bi.getAllNonFictionalBook());

        //test can search and list book by category for kids books
//        KidsBookDao b = new KidsBookDao();
        //System.out.println("Kids book model list"+b.getAllKidsBookByCategory("Teen"));
        // System.out.println("Kids books model list:"+b.getAllKidsBook());

        FictionalBooksDao bw = new FictionalBooksDao();
        //System.out.println("Fictional books stored in Db are:"+bw.getAllFictionalBookByCategory("Romance"));
        // System.out.println("Kids books model list:"+b.getAllKidsBook());
        //System.out.println("Fictional booss model list"+bw.getAllFictionalBook());
        //System.out.println(bw.getFictionalBookByISBN("1394044949"));
        //System.out.println(nonficational.getNonFictionalBookByISBN("1373883389"));
        //System.out.println(nonficational.getNonFictionalByProductNumber(11));

        //System.out.println(b.getKidsBookByISBN("172343883389"));
        // System.out.println(bw.getFictionalBookByProductNumber(8));
        //System.out.println(b.getKidsBookByISBN("172343883389"));
        //System.out.println(b.getKidBookByProductNumber(20));
        Date deliveryDate = new Date();
//
//        FictionalBook bbn = new FictionalBook();
//        bbn.setAuthor("jango");
//        bbn.setImagepath("./image/The Complete Works of William Shakespeare 1 copy-131x199.png");
//        bbn.setIsbn("1394029492");
//        bbn.setPublishedYear(deliveryDate);
//        bbn.setPublisher("maman");
//        bbn.setQuantity(100);
//        bbn.setDescription("a book product");
//        bbn.setPrice(12);
//        bbn.setQuantity(2);
//        bbn.setProductNumber(30);
//        bbn.setCategory("Romance");
//        //System.out.println("the book you added is:" + bbn.toString());
//        bw.addFictionalBooks(bbn);

//        System.out.println("the book you added is:" + bbn.toString());
//        
//        /**
//         * test can delete a book given producer consumer
//         */
        BookDao nnd = new BookDao();
//        Product bb = nnd.getProductbyProductNumber(2, "Mistry");
        // System.out.println("the product is :"+bb );
        //  nnd.deleteBooks(bbn.getProductNumber());
        // System.out.println("you deleted a book" + bw.getFictionalBookByProductNumber(bbn.getProductNumber()));
//          
        //System.out.println(nnd.getAllBooksbyCategory("History").toString());
//          
//          List<Book> books = new ArrayList<Book>();

//        bc=  nnd.getBookbyProductNumber(7);
//        System.out.println("Fiction book"+bc.getImagepath()+bc.getIsbn());
//        bc=  nnd.getBookbyProductNumber(22);
//        System.out.println("Kids book"+bc.getImagepath()+bc.getIsbn());
        // System.out.println("you have added a book" + bw.getFictionalBookByISBN(bbn.getIsbn()));
//        NonFictionalBook c = new NonFictionalBook();
//        c.setAuthor("jango");
//        c.setImagepath("path");
//        c.setIsbn("1394029492");
//        c.setPublishedYear(deliveryDate);
//        c.setPublisher("maman");
//        c.setQuantity(100);
//        c.setDescription("a book product");
//        c.setPrice(12);
//        c.setQuantity(2);
//        c.setProductNumber(30);
//        c.setCategory("Business Books");
//        nonficational.addNonFictionalBooks(c);
//        
//        System.out.println("you have added a book" + nonficational.getNonFictionalByProductNumber(c.getProductNumber()));
//    
//        KidsBook c =new KidsBook();
//        c.setAuthor("jango");
//        c.setImagepath("path");
//        c.setIsbn("1394029492");
//        c.setPublishedYear(deliveryDate);
//        c.setPublisher("maman");
//        c.setQuantity(100);
//        c.setDescription("a book product");
//        c.setPrice(12);
//        c.setQuantity(2);
//        c.setProductNumber(30);
//        c.setCategory("Teens");
//        b.addKidsBook(c);
//        
//       System.out.println("you have added a book" + b.getKidBookByProductNumber(c.getProductNumber()));
    }

}
