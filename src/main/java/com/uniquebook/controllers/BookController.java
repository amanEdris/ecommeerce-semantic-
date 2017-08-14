/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.uniquebook.models.*;
import com.uniquebook.dao.BookDao;
import com.uniquebook.dao.FictionalBooksDao;
import com.uniquebook.dao.KidsBookDao;
import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.models.Book;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edris
 */
@WebServlet(name = "BookController", urlPatterns = {"/book"})
public class BookController extends HttpServlet {

    private FictionalBooksDao fictionDao;
    private NonFictionalBooksDao nonFcitionDao;
    private KidsBookDao kidDao;
    private BookDao bookDao;

    private static String INSERT_OR_EDIT = "/view/book.jsp";
    private static String LIST_Books = "/view/listBook.jsp";
    private static String SHOW_Books = "/view/showBook.jsp";

    public BookController() {
        super();
        fictionDao = new FictionalBooksDao();
        nonFcitionDao = new NonFictionalBooksDao();
        kidDao = new KidsBookDao();
        bookDao = new BookDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            //delete book 
            forward = LIST_Books;
            //get all books 
            //forward to  book list jsp
            request.setAttribute("books", kidDao.getAllKidsBook());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            //getBookby product number
            //set to request

        } else if (action.equalsIgnoreCase("show")) {
            Book b = new Book();
            forward = SHOW_Books;
            int productId = Integer.parseInt(request.getParameter("productNo"));
            String category = (request.getParameter("category"));

            b = bookDao.getBookbyProductNumber(productId, category);
            request.setAttribute("book", b);
        } else if (action.equalsIgnoreCase("listBooks")) {
            forward = LIST_Books;
            String category = (request.getParameter("category"));
            request.setAttribute("category",category);
            if (category != null) {
                if (NonFictionalBook.NonFictionalCategory.getEnumByString(category) != null) {
                    request.setAttribute("cat", 1);               
                    request.setAttribute("nonfibooks", nonFcitionDao.getAllNonFictionalBookByCategory(category));
                } else if (category.equals("Kids Book")) {
                     request.setAttribute("cat", 2);
                    request.setAttribute("kidbooks", kidDao.getAllKidsBook());
                } else {
                     request.setAttribute("cat", 3);
                    request.setAttribute("books", fictionDao.getAllFictionalBookByCategory(category));
                }
            } else {
                request.setAttribute("category", category);
                request.setAttribute("nonfibooks", nonFcitionDao.getAllNonFictionalBook());
                request.setAttribute("kidbooks", kidDao.getAllKidsBook());
                request.setAttribute("books", fictionDao.getAllFictionalBook());

            }

        } else {

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
