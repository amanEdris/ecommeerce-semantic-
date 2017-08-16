/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

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
@WebServlet(name = "AccountController", urlPatterns = {"/account"})
public class AccountController extends HttpServlet {
  

    private static String INSERT_OR_EDIT = "/view/registeraccount.jsp";
    private static String LOGIN_PAGE = "/view/login.jsp";
    public AccountController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            //TODO: delete account for customer 
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            //TODO: Edit customer data

        } else if (action.equalsIgnoreCase("login")) {
            forward = LOGIN_PAGE;
            // TODO: implement autenticate and login
       
        } else if (action.equalsIgnoreCase("update")) {
            // TODO:implement update to customer account

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
