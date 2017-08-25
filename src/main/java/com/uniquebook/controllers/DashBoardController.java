/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.ctc.wstx.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.uniquebook.dao.CustomerDao;
import com.uniquebook.models.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "DashBoardController", urlPatterns = {"/dashboard"})
public class DashBoardController extends HttpServlet {

    private static String DASHBOARD_PAGE_CUSTOMER = "/view/dashboard.jsp";
    private CustomerDao customerDao;
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();


    public DashBoardController() {
        super();
        customerDao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String userPath = request.getServletPath();

        if (userPath.equals("/dashboard")) {
            String forward = DASHBOARD_PAGE_CUSTOMER;
            response.setContentType("application/json");

            if (StringUtils.isNotEmpty(action)) {
                if (action.equals("listCustomer")) {
                    List<Customer> customersList = customerDao.getAllCustomer();
                    Gson gson = new Gson();
                    JsonElement element = gson.toJsonTree(customersList, new TypeToken<List<Customer>>() {
                    }.getType());
                    JsonArray jsonArray = element.getAsJsonArray();
                    String listData = jsonArray.toString();

                    listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
                    response.getWriter().print(listData);
                    System.out.println(listData);
                }

            } else {
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }

        }

        //convert to json and write to webpage
        //Orders
        //Books list handle conditions
        //Order list handle conditions
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");
        String userPath = request.getServletPath();

        if (userPath.equals("/dashboard")) {
            String forward = DASHBOARD_PAGE_CUSTOMER;
            response.setContentType("application/json");

            if (StringUtils.isNotEmpty(action)) {
                if (action.equals("listCustomer")) {
                    List<Customer> customersList = customerDao.getAllCustomer();
                    Gson gson = new Gson();
                    JsonElement element = gson.toJsonTree(customersList, new TypeToken<List<Customer>>() {
                    }.getType());
                    JsonArray jsonArray = element.getAsJsonArray();
                    String listData = jsonArray.toString();

                    listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
                    response.getWriter().print(listData);
                    System.out.println(listData);
                }

            } else {
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }

        }
    }

}

/**
 * *
 * response.setContentType("text/html;charset=UTF-8");
 *
 * try (PrintWriter out = response.getWriter()) { /* TODO output your page here.
 * You may use following sample code.
 */
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Servlet OrderController</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    out.println("<h1>the quantities are  " + ordername +"</h1>");
//                    out.println("</body>");
//                    out.println("</html>");
//                }
