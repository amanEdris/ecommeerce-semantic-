/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.hp.hpl.jena.sparql.util.Utils;
import com.uniquebook.dao.BookDao;
import com.uniquebook.dao.CustomerDao;
import com.uniquebook.dao.ManagerDao;
import com.uniquebook.dao.OrderDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Location;
import com.uniquebook.models.Manager;
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
 * http://localhost:8080/UniqueBookApp/admin?action=logout 67
 *
 * @author edris
 */
@WebServlet(name = "AccountController", urlPatterns = {"/account", "/updateAccount", "/login", "/admin"})
public class AccountController extends HttpServlet {

    private CustomerDao customerDao;
    private OrderDao orderDao;
    private BookDao bookDao;
    private ManagerDao managerDao;

    private static String DASHBOARD_PAGE_ADMIN = "/view/admin/admindashboard.jsp";
    private static String DASHBOARD_PAGE_CUSTOMER = "/view/dashboard.jsp";
    private static String INSERT_OR_EDIT = "/view/registeraccount.jsp";
    private static String LOGIN_PAGE = "/view/login.jsp";
    private static String CONFIRMATION_PAGE = "/view/confirmation.jsp";
    private static String LOGIN_ADMIN_PAGE = "/view/admin/login.jsp";

    public AccountController() {
        super();
        customerDao = new CustomerDao();
        managerDao = new ManagerDao();
        orderDao = new OrderDao();
        bookDao = new BookDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String userPath = request.getServletPath();

        if (userPath.equals("/admin")) {
            Manager mancager = new Manager();
            mancager = (Manager) session.getAttribute("adminUser");

            if (Utils.equal(null, mancager)) {
                forward = LOGIN_ADMIN_PAGE;
            } else {
                int customerCount = customerDao.getCustomerCount();
                int orderCount = orderDao.getOrderCount();
                int productCount = bookDao.getBookProductCount();
                request.setAttribute("customersNumber", customerCount);
                request.setAttribute("orderNumber", orderCount);
                request.setAttribute("productNumber", productCount);
                forward = DASHBOARD_PAGE_ADMIN;
          
            if (StringUtils.isEmpty(action)) {
                request.setAttribute("customersNumber", customerCount);
                request.setAttribute("orderNumber", orderCount);
                request.setAttribute("productNumber", productCount);
                forward = DASHBOARD_PAGE_ADMIN;
            } else if (action.equalsIgnoreCase("logout")) {
                forward = LOGIN_ADMIN_PAGE;
                Manager manager = (Manager) session.getAttribute("adminUser");
                manager = null;
                session.removeAttribute("adminUser");
            } else {
                request.setAttribute("customersNumber", customerCount);
                request.setAttribute("orderNumber", orderCount);
                request.setAttribute("productNumber", productCount);
                forward = DASHBOARD_PAGE_ADMIN;
             } }
        } else if (userPath.equals("/account")) {
            if (action.equalsIgnoreCase("login")) {
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

        } else if (StringUtils.isEmpty(action)) {
            forward = LOGIN_PAGE;

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
            c.setCustomerId(customerOld.getCustomerId());
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

        } else if (userPath.equals("/admin")) {
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String message = " ";

            Manager manager = managerDao.getManagerByEmailAndPassword(email, password);

            if (manager.getFirstName() == null) {
                message = "Password or Email is not correct";
                request.setAttribute("message", message);
                forward = LOGIN_ADMIN_PAGE;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("adminUser", manager);
                int customerCount = customerDao.getCustomerCount();
                int orderCount = orderDao.getOrderCount();
                int productCount = bookDao.getBookProductCount();
                request.setAttribute("customersNumber", customerCount);
                request.setAttribute("orderNumber", orderCount);
                request.setAttribute("productNumber", productCount);

                forward = DASHBOARD_PAGE_ADMIN;

            }

        } else {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

}
