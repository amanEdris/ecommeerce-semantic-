/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author edris
 */
public class Book extends Product{


    public Book(){
    }
    private String isbn;  
    private String author;
    private String publisher;
    private String title;
    private Date publishedYear;
    private String revisionNo;

    public String getRevisionNo() {
        return revisionNo;
    }

    public void setRevisionNo(String revisionNo) {
        this.revisionNo = revisionNo;
    }
    

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    

    public String getStringPublishedYear() {
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(publishedYear);
    }
    
    public Date getPublishedYear(){
        return publishedYear;
    }

    public void setPublishedYear(Date publishedYear) {
        this.publishedYear = publishedYear;
    }
    
    
    
    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", author=" + author + ", publisher=" + publisher + ", title=" + title + ", publishedYear=" + publishedYear + '}'+super.toString();
    }
}
