/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.uniquebook.dao.CustomerDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Location;
import com.uniquebook.models.ShoppingCart;
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
@WebServlet(name = "AccountController", urlPatterns = {"/account", "/updateAccount", "/login", })
public class AccountController extends HttpServlet {

    private CustomerDao customerDao;
    private static String INSERT_OR_EDIT = "/view/registeraccount.jsp";
    private static String LOGIN_PAGE = "/view/login.jsp";
    private static String CONFIRMATION_PAGE = "/view/confirmation.jsp";

    public AccountController() {
        super();
        customerDao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String userPath = request.getServletPath();

        if (StringUtils.isEmpty(action)) {
            forward = LOGIN_PAGE;
        } else {
            if (action.equalsIgnoreCase("delete")) {
                //TODO: delete account for customer admin 

            } else if (action.equalsIgnoreCase("login")) {
                forward = LOGIN_PAGE;
            } else if (action.equalsIgnoreCase("edit")) {

                forward = INSERT_OR_EDIT;
                //TODO: Edit customer data admin 

            } else if (action.equalsIgnoreCase("logout")) {

                Customer c = (Customer) session.getAttribute("User");
                c = null;
                session.removeAttribute("User");
            } else {

            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String userPath = request.getServletPath();

        if (userPath.equals("/login")) {
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String message = " ";

            Customer customer = customerDao.getCustomerByEmailAndPassword(email, password);

            if (customer.getLocation() == null) {
                message = "Password or Email is not correct";
                request.setAttribute("message", message);
                forward = LOGIN_PAGE;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("User", customer);
                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                if (cart == null) {
                    forward = INSERT_OR_EDIT;
                } else {
                    forward = CONFIRMATION_PAGE;
                }

            }
        } else if (userPath.equals("/updateAccount")) {
            HttpSession session = request.getSession();
            Customer c = new Customer();
            Location l = new Location();
            l.setAddress(request.getParameter("address_1"));
            l.setCity(request.getParameter("city"));
            l.setCountry(request.getParameter("country_id"));
            l.setPostalCode(request.getParameter("postcode"));
            c.setLocation(l);
            c.setEmail(request.getParameter("email"));
            c.setFirstName(request.getParameter("firstname"));
            c.setLastName(request.getParameter("lastname"));
            c.setPassword(request.getParameter("password"));
            c.setGender(request.getParameter("male"));
            c.setPhone(request.getParameter("telephone"));
            
            Customer customerOld = (Customer) session.getAttribute("User");
            c.setCutomerId(customerOld.getCutomerId());
            boolean updated = customerDao.updateCustomer(c, customerOld);

            if (updated) {
                customerOld.clone(c);
            } else {
                request.setAttribute("message", "unable to update account please check all the values");
            }
            forward = INSERT_OR_EDIT;
        } else if (userPath.equals("/account")) {
            String agree = request.getParameter("agree");
            forward = INSERT_OR_EDIT;
            if (agree != null) {
                Customer c = new Customer();
                Location l = new Location();
                l.setAddress(request.getParameter("address_1"));
                l.setCity(request.getParameter("city"));
                l.setCountry(request.getParameter("country_id"));
                l.setPostalCode(request.getParameter("postcode"));
                c.setLocation(l);
                c.setEmail(request.getParameter("email"));
                c.setFirstName(request.getParameter("firstname"));
                c.setLastName(request.getParameter("lastname"));
                c.setPassword(request.getParameter("password"));
                c.setGender(request.getParameter("male"));
                c.setPhone(request.getParameter("telephone"));
                boolean check = customerDao.addCustomer(c);
                if (check) {
                    request.setAttribute("message", "Email  regitered please use different Email!");
                } else {
                    request.setAttribute("goodmessage", "sucessfully registered user!");
                }

            } else {
                request.setAttribute("message", "Unable to register please agree to the Privacy Policy!");
            }

        } else {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

}

//    response.setContentType("text/html;charset=UTF-8");
//
//                try (PrintWriter out = response.getWriter()) {
//                    /* TODO output your page here. You may use following sample code. */
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Servlet OrderController</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    out.println("<h1>the quantities are  "+customer.toString()+ "</h1>");
//                    out.println("</body>");
//                    out.println("</html>");
//                }
