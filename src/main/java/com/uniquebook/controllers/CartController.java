/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.uniquebook.dao.BookDao;
import com.uniquebook.models.Book;
import com.uniquebook.models.Product;
import com.uniquebook.models.ShoppingCart;
import com.uniquebook.models.ShoppingCartItem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edris
 */
@WebServlet(name = "CartController", loadOnStartup = 1, urlPatterns = {"/addToCart", "/updateCart", "/viewCart"})
public class CartController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/view/cart.jsp";
    private BookDao bookDao;

    public CartController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        String forward = "";
        if (userPath.equalsIgnoreCase("delete")) {
            forward = INSERT_OR_EDIT;
            // TODO: implement delete cart items 
        } else if (userPath.equalsIgnoreCase("viewCart")) {
            forward = INSERT_OR_EDIT;
            // TODO: implement update to cart 

        } else {
            // TODO: implement list cart items page

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        String forward = INSERT_OR_EDIT;
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        // if addToCart action is called
        if (userPath.equals("/addToCart")) {
            // TODO: Implement add product to cart action
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }

            int productId = Integer.parseInt(request.getParameter("productNo"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String category = (request.getParameter("category"));
            
            Book b = bookDao.getBookbyProductNumber(productId, category);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet OrderController</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>product number at " + productId + "</h1>");
                out.println("<h1>Quantity at " + quantity+ "</h1>");
                out.println("<h1>category at " + category + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }

//            ShoppingCartItem item = new ShoppingCartItem(p, quantity);
//            cart.addItem(item);
//            session.setAttribute("cart", cart);
//            forward = request.getRequestURL().toString();
        }

//        else if (userPath.equals("/purchase")) {
//            // TODO: Implement purchase action
//            userPath = "/confirmation";
//        }
//
//        RequestDispatcher view = request.getRequestDispatcher(forward);
//        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
