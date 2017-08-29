/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author edris
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})

public class SearchController extends HttpServlet {

    public SearchController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchPhrase;
        String userPath = request.getServletPath();

        if (userPath.equals("/search")) {
            if (StringUtils.isNotEmpty(request.getParameter("search"))) {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet OrderController</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>the quantities are  " + request.getParameter("search").toString() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }

        //separate the search string by space remove any unwanted character
        //build sparql query
        //lanuch list BOok jsp page
        //I want romantic book
        //subject predicate object
        //Book class(subject)   individual is (object)
        //instance of subject that has predicate relation with object
        //give me cheap book
        //book subject   cheap is related to price (synonyms)
        //instance of subject with price low
        //give me book by alexander
        //subject is Book(class)
        //individual relation to book
        //?b a r:book.
        //   ?p alexander;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchPhrase;
        String userPath = request.getServletPath();

        if (userPath.equals("/search")) {
            if (StringUtils.isNotEmpty(request.getParameter("search"))) {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet OrderController</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>the quantities are  " + request.getParameter("search").toString() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
    }

}

/**
 * *
 * response.setContentType("text/html;charset=UTF-8");
 *
 * try (PrintWriter out = response.getWriter()) { You may use following sample
 * code.
 *
 *
 */
