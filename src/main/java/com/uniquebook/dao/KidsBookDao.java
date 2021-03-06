/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.dao;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.Product;
import com.uniquebook.utils.HelperUtil;
import com.uniquebook.utils.FusekiClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edris
 */
public class KidsBookDao {

    private HelperUtil helperUtil;

    public KidsBookDao() {
        helperUtil = new HelperUtil();
    }

    /**
     * @todo max product number for ID
     * @param b
     * @throws Exception
     */
    public void addKidsBook(KidsBook b) throws Exception {
        BookDao bookDao;
        bookDao = new BookDao();
        b.setProductNumber(bookDao.getMaxProductNumberForBook() + 1);
        String insertQuery = FusekiClient.PREFIX;
        insertQuery += "INSERT DATA\n"
                + "{\n"
                + " r:" + helperUtil.generateNames() + "   a   r:KidsBook;\n"
                + "          r:productNumber \"" + b.getProductNumber() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasISBN \"" + b.getIsbn() + "\"^^xsd:string ;\n"
                + "          r:hasPrice \"" + b.getPrice() + "\"^^xsd:float ;\n"
                + "          r:hasBookRevisionNo \"" + b.getRevisionNo() + "\"^^xsd:string;\n"
                + "          r:hasQuantity \"" + b.getQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasPublisher \"" + b.getPublisher() + "\"^^xsd:string ;\n"
                + "          r:hasPublishedYear \"" + b.getStringPublishedYear() + "\"^^xsd:date ;\n"
                + "          r:hasKidsBookCategory \"" + b.getCategory() + "\"^^xsd:string ;\n"
                + "          r:hasAuthor \"" + b.getAuthor() + "\"^^xsd:string ;\n"
                + "          r:hasDescription \"" + b.getDescription() + "\"^^xsd:string ;\n"
                + "          r:hasTitle \"" + b.getTitle() + "\"^^xsd:string ;\n"
                + "          r:hasImage \"" + b.getImagepath() + "\"^^xsd:string ."
                + "}";

        FusekiClient.insertFUSEKI(insertQuery);

    }

    public void updateKidsBook(KidsBook b) throws Exception {
        String updateBookQuery = null;
        String subjetBook = this.getSubjectName(b);
        KidsBook k = this.getKidBookByProductNumber(b.getProductNumber());
        updateBookQuery = FusekiClient.PREFIX;
        updateBookQuery += "DELETE"
                + "{"
                + " r:" + subjetBook + "   a   r:KidsBook;\n"
                + "          r:productNumber \"" + k.getProductNumber() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasISBN \"" + k.getIsbn() + "\"^^xsd:string ;\n"
                + "          r:hasPrice \"" + k.getPrice() + "\"^^xsd:float ;\n"
                + "          r:hasBookRevisionNo \"" + k.getRevisionNo() + "\"^^xsd:string;\n"
                + "          r:hasQuantity \"" + k.getQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasPublisher \"" + k.getPublisher() + "\"^^xsd:string ;\n"
                + "          r:hasPublishedYear \"" + k.getStringPublishedYear() + "\"^^xsd:date ;\n"
                + "          r:hasKidsBookCategory \"" + k.getCategory() + "\"^^xsd:string ;\n"
                + "          r:hasAuthor \"" + k.getAuthor() + "\"^^xsd:string ;\n"
                + "          r:hasDescription \"" + k.getDescription() + "\"^^xsd:string ;\n"
                + "          r:hasTitle \"" + k.getTitle() + "\"^^xsd:string ;\n"
                + "          r:hasImage \"" + k.getImagepath() + "\"^^xsd:string ."
                + "}"
                + "INSERT "
                + "{"
                + " r:" + subjetBook + "   a   r:KidsBook;\n"
                + "          r:productNumber \"" + b.getProductNumber() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasISBN \"" + b.getIsbn() + "\"^^xsd:string ;\n"
                + "          r:hasPrice \"" + b.getPrice() + "\"^^xsd:float ;\n"
                + "          r:hasBookRevisionNo \"" + b.getRevisionNo() + "\"^^xsd:string;\n"
                + "          r:hasQuantity \"" + b.getQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasPublisher \"" + b.getPublisher() + "\"^^xsd:string ;\n"
                + "          r:hasPublishedYear \"" + b.getStringPublishedYear() + "\"^^xsd:date ;\n"
                + "          r:hasKidsBookCategory \"" + b.getCategory() + "\"^^xsd:string ;\n"
                + "          r:hasAuthor \"" + b.getAuthor() + "\"^^xsd:string ;\n"
                + "          r:hasDescription \"" + b.getDescription() + "\"^^xsd:string ;\n"
                + "          r:hasTitle \"" + b.getTitle() + "\"^^xsd:string ;\n"
                + "          r:hasImage \"" + b.getImagepath() + "\"^^xsd:string ."
                + ""
                + "} WHERE { \n"
                + " r:" + subjetBook + "   a   r:KidsBook;\n"
                + "          r:productNumber \"" + k.getProductNumber() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasISBN \"" + k.getIsbn() + "\"^^xsd:string ;\n"
                + "          r:hasPrice \"" + k.getPrice() + "\"^^xsd:float ;\n"
                + "          r:hasBookRevisionNo \"" + k.getRevisionNo() + "\"^^xsd:string;\n"
                + "          r:hasQuantity \"" + k.getQuantity() + "\"^^xsd:nonNegativeInteger ;\n"
                + "          r:hasPublisher \"" + k.getPublisher() + "\"^^xsd:string ;\n"
                + "          r:hasPublishedYear \"" + k.getStringPublishedYear() + "\"^^xsd:date ;\n"
                + "          r:hasKidsBookCategory \"" + k.getCategory() + "\"^^xsd:string ;\n"
                + "          r:hasAuthor \"" + k.getAuthor() + "\"^^xsd:string ;\n"
                + "          r:hasDescription \"" + k.getDescription() + "\"^^xsd:string ;\n"
                + "          r:hasTitle \"" + k.getTitle() + "\"^^xsd:string ;\n"
                + "          r:hasImage \"" + k.getImagepath() + "\"^^xsd:string ."
                + "}";
        System.out.println("Update customer query is: " + updateBookQuery);
        FusekiClient.insertFUSEKI(updateBookQuery);

    }

    public List<KidsBook> getAllKidsBook() {
        List<KidsBook> books = new ArrayList<KidsBook>();
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
                + "                   r:hasBookRevisionNo   ?revision ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .\n"
                + "} ";
        queryAllBooks(BooksQuery, books);
        return books;
    }

    public List<KidsBook> getAllKidsBookByCategory(String category) {
        List<KidsBook> books = new ArrayList<KidsBook>();
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
                + "                   r:hasBookRevisionNo   ?revision ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image .\n"
                + " FILTER regex(?kidsCategory, \"" + category + "\", \"i\")\n"
                + "} ";
        queryAllBooks(BooksQuery, books);
        return books;

    }

    public KidsBook getKidsBookByISBN(String Isbn) {
        KidsBook book = new KidsBook();
        String booksQuery = FusekiClient.PREFIX;

        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:KidsBook;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasBookRevisionNo ?revisionNo;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image ;\n"
                + "   FILTER (sameTerm(?isbn ,\"" + Isbn + "\"^^xsd:string))\n"
                + "\n"
                + " }";

        queryBook(booksQuery, book);
        return book;

    }

    public String getSubjectName(Product p) {
        String subjectName = null;
        try {
            String selectQuery = null;

            selectQuery = FusekiClient.PREFIX;
            selectQuery += "SELECT  ?x\n"
                    + "\n"
                    + "WHERE\n"
                    + "{ \n"
                    + "  ?x a ?o;\n"
                    + "     r:productNumber  \"" + p.getProductNumber() + "\"^^xsd:nonNegativeInteger.\n"
                    + "\n"
                    + " }";

            System.out.println("subject query for this product is:  " + selectQuery);

            ResultSet results = FusekiClient.queryFUSEKI(selectQuery);
            while (results.hasNext()) {
                QuerySolution row = results.next();
                subjectName = row.getResource("x").getLocalName();
            }

        } catch (Exception ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectName;
    }

    public KidsBook getKidBookByProductNumber(int productNumber) {
        KidsBook book = new KidsBook();
        String booksQuery = FusekiClient.PREFIX;

        booksQuery += "SELECT  *\n"
                + "\n"
                + "WHERE\n"
                + "{ \n"
                + "  ?x a r:KidsBook;\n"
                + "                  r:hasQuantity ?quantity;\n"
                + "                  r:hasISBN  ?isbn ;\n"
                + "                  r:hasPublishedYear  ?publishedyear ;\n"
                + "                  r:productNumber  ?productNumber;\n"
                + "                  r:hasPrice ?price ;\n"
                + "                  r:hasDescription ?description ;\n"
                + "                  r:hasKidsBookCategory ?kidsCategory ;\n"
                + "                  r:hasPublisher ?publisher ;\n"
                + "                  r:hasAuthor ?author;\n"
                + "                  r:hasBookRevisionNo ?revisionNo;\n"
                + "                  r:hasTitle  ?title ;\n"
                + "                  r:hasImage ?image ;"
                + "                  r:hasBookRevisionNo ?revisionNo;\n"
                + "   FILTER (?productNumber  = " + productNumber + " )\n"
                + "\n"
                + " }";

        //System.out.println("get book query+" + booksQuery);
        queryBook(booksQuery, book);
        return book;

    }

    private void queryBook(String booksQuery, KidsBook book) {
        try {
            ResultSet results = FusekiClient.queryFUSEKI(booksQuery);

            while (results.hasNext()) {

                QuerySolution row = results.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                book.setAuthor(row.getLiteral("author").getString());
                book.setImagepath(row.getLiteral("image").getString());
                book.setIsbn(row.getLiteral("isbn").getString());
                Date deliveryDate = sdf.parse(row.getLiteral("publishedyear").getValue().toString());
                book.setTitle(row.getLiteral("title").getString());
                book.setPublishedYear(deliveryDate);
                book.setPublisher(row.getLiteral("publisher").getString());
                book.setQuantity(row.getLiteral("quantity").getInt());
                book.setDescription(row.getLiteral("description").getString());
                book.setPrice(row.getLiteral("price").getFloat());
                book.setQuantity(row.getLiteral("quantity").getInt());
                book.setProductNumber(row.getLiteral("productNumber").getInt());
                //System.out.println(row.getLiteral("kidsCategory").getValue().toString());
                book.setCategory(row.getLiteral("kidsCategory").getValue().toString());
                book.setRevisionNo(row.getLiteral("revisionNo").getValue().toString());
            }
        } catch (ParseException ex) {
            Logger.getLogger(FictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KidsBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void queryAllBooks(String BooksQuery, List<KidsBook> books) {
        try {
            ResultSet results = FusekiClient.queryFUSEKI(BooksQuery);
            int tempProductNumber = 0;

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
                String category = row.getLiteral("kidsCategory").getValue().toString();
                b.setCategory(category);
                b.setRevisionNo(row.getLiteral("revision").getValue().toString());

                //System.out.println("book added with category" + b.getCategory() + "where category name is:" + category);
                if (tempProductNumber == row.getLiteral("productNumber").getInt()) {

                } else {
                    books.add(b);
                    tempProductNumber = row.getLiteral("productNumber").getInt();
                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(NonFictionalBooksDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KidsBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
