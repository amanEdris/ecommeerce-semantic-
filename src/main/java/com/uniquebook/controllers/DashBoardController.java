/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.ctc.wstx.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.uniquebook.dao.CustomerDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Location;
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

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        List<Customer> customersList = customerDao.getAllCustomer();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        response.setContentType("application/json");
        if (StringUtils.isNotEmpty(action)) {
            try {
                if (action.equals("listcustomer")) {

                    // Fetch Data from User Table
                    int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));
                    int recordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));

                    // Fetch Data from Student Table
                    customersList = customerDao.getAllCustomer(startPageIndex, recordsPerPage);
                    // Get Total Record Count for Pagination
                    int customerCount = customerDao.getCustomerCount();

                    // Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", customersList);
                    JSONROOT.put("TotalRecordCount", customerCount);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("createcustomer") || action.equals("updatecustomer")) {

                    Customer c = new Customer();
                    Location l = new Location();
                    l.setAddress(request.getParameter("address"));
                    l.setCity(request.getParameter("city"));
                    l.setCountry(request.getParameter("country"));
                    l.setPostalCode(request.getParameter("postalCode"));
                    c.setLocation(l);
                    c.setEmail(request.getParameter("email"));
                    c.setFirstName(request.getParameter("firstName"));
                    c.setLastName(request.getParameter("lastName"));
                    c.setPassword(request.getParameter("password"));
                    c.setGender(request.getParameter("gender"));
                    c.setPhone(request.getParameter("phone"));
                    c.setCutomerId(request.getParameter("customerId"));

                    if (action.equals("createcustomer")) {
                        boolean check = customerDao.addCustomer(c);
                        if (check) {
                            JSONROOT.put("Result", "ERROR");
                            JSONROOT.put("Message", "Email  regitered please use different Email!");
                        } else {
                            JSONROOT.put("Result", "OK");
                            JSONROOT.put("Record", c);
                        }
                    } else if (action.equals("updatecustomer")) {
                        Customer cc = new Customer();
                        cc.clone(c);
                        boolean check = customerDao.updateCustomer(c, cc);
                        if (check) {
                            JSONROOT.put("Result", "OK");
                            JSONROOT.put("Record", c);
                        } else {
                            JSONROOT.put("Result", "ERROR");
                            JSONROOT.put("Message", "Unable to update please check all values!");
                        }
                    }

                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("deletecustomer")) {
                    // Delete record
                    if (StringUtils.isNotEmpty(request.getParameter("customerId"))) {
                        String customerId = request.getParameter("customerId");
                        customerDao.deleteCustomer(customerId);

                        JSONROOT.put("Result", "OK");

                        String jsonArray = gson.toJson(JSONROOT);
                        response.getWriter().print(jsonArray);
                    }
                } else if (action.equals("listcustomer")) {

                    // Fetch Data from User Table
                    int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));
                    int recordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));

                    // Fetch Data from Student Table
                    customersList = customerDao.getAllCustomer(startPageIndex, recordsPerPage);
                    // Get Total Record Count for Pagination
                    int customerCount = customerDao.getCustomerCount();

                    // Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", customersList);
                    JSONROOT.put("TotalRecordCount", customerCount);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("create") || action.equals("update")) {

                    Customer c = new Customer();
                    Location l = new Location();
                    l.setAddress(request.getParameter("address"));
                    l.setCity(request.getParameter("city"));
                    l.setCountry(request.getParameter("country"));
                    l.setPostalCode(request.getParameter("postalCode"));
                    c.setLocation(l);
                    c.setEmail(request.getParameter("email"));
                    c.setFirstName(request.getParameter("firstName"));
                    c.setLastName(request.getParameter("lastName"));
                    c.setPassword(request.getParameter("password"));
                    c.setGender(request.getParameter("gender"));
                    c.setPhone(request.getParameter("phone"));
                    c.setCutomerId(request.getParameter("customerId"));

                    if (action.equals("createcustomer")) {
                        boolean check = customerDao.addCustomer(c);
                        if (check) {
                            JSONROOT.put("Result", "ERROR");
                            JSONROOT.put("Message", "Email  regitered please use different Email!");
                        } else {
                            JSONROOT.put("Result", "OK");
                            JSONROOT.put("Record", c);
                        }
                    } else if (action.equals("updatecustomer")) {
                        Customer cc = new Customer();
                        cc.clone(c);
                        boolean check = customerDao.updateCustomer(c, cc);
                        if (check) {
                            JSONROOT.put("Result", "OK");
                            JSONROOT.put("Record", c);
                        } else {
                            JSONROOT.put("Result", "ERROR");
                            JSONROOT.put("Message", "Unable to update please check all values!");
                        }
                    }

                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("deletecustomer")) {
                    // Delete record
                    if (StringUtils.isNotEmpty(request.getParameter("customerId"))) {
                        String customerId = request.getParameter("customerId");
                        customerDao.deleteCustomer(customerId);

                        JSONROOT.put("Result", "OK");

                        String jsonArray = gson.toJson(JSONROOT);
                        response.getWriter().print(jsonArray);
                    }
                }
            } catch (Exception ex) {
                JSONROOT.put("Result", "ERROR");
                JSONROOT.put("Message", ex.getMessage());
                String error = gson.toJson(JSONROOT);
                response.getWriter().print(error);
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
