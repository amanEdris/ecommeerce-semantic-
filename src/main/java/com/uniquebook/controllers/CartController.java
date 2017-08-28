/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.uniquebook.dao.BookDao;
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
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author edris
 */
@WebServlet(name = "CartController", loadOnStartup = 1, urlPatterns = {"/deleteCart", "/addToCart", "/updateCart", "/viewCart"})
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
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        String action = request.getParameter("action");

        if (userPath.equalsIgnoreCase("/viewCart")) {
            forward = INSERT_OR_EDIT;
        } else {
            if (StringUtils.isNotBlank(action)) {
                if (action.equalsIgnoreCase("clear")) {
                    if (cart != null) {
                        forward = INSERT_OR_EDIT;
                        cart.removeAllItems();
                        cart = null;
                        session.removeAttribute("cart");
                    } else {
                        forward = INSERT_OR_EDIT;
                    }

                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = null;
        String userPath = request.getServletPath();
        String forward = INSERT_OR_EDIT;
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        int productId = Integer.parseInt(request.getParameter("productNo"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String category = request.getParameter("category");
        request.setAttribute("category", category);

        BookDao nnd = new BookDao();
        try {
            product = nnd.getProductbyProductNumber(productId, category);
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            out.println(ex.getLocalizedMessage().toString());
        }

        if (userPath.equals("/addToCart")) {
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            ShoppingCartItem item = new ShoppingCartItem(product, quantity);
            cart.addItem(item);

        } else if (userPath.equals("/updateCart")) {
            ShoppingCartItem item = new ShoppingCartItem(product, quantity);
            cart.updateItem(item);
        } else {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
