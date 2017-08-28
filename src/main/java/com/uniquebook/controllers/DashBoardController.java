/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uniquebook.dao.CustomerDao;
import com.uniquebook.dao.FictionalBooksDao;
import com.uniquebook.dao.KidsBookDao;
import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.dao.OrderDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.FictionalBook;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.Location;
import com.uniquebook.models.Manager;
import com.uniquebook.models.NonFictionalBook;
import com.uniquebook.models.Order;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(name = "DashBoardController", urlPatterns = {"/dashboard"})
public class DashBoardController extends HttpServlet {

    private static String DASHBOARD_PAGE_ADMIN = "/view/admin/admindashboard.jsp";
    private static String DASHBOARD_PAGE_CUSTOMER = "/view/dashboard.jsp";
    private static String LOGIN_ADMIN_PAGE = "/view/admin/login.jsp";

    private CustomerDao customerDao;
    private OrderDao orderDao;
    private FictionalBooksDao fictionBookDao;
    private NonFictionalBooksDao nonFictionBookDao;
    private KidsBookDao kidbookDao;

    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    public DashBoardController() {
        super();
        customerDao = new CustomerDao();
        orderDao = new OrderDao();
        fictionBookDao = new FictionalBooksDao();
        nonFictionBookDao = new NonFictionalBooksDao();
        kidbookDao = new KidsBookDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = DASHBOARD_PAGE_ADMIN;
        String action = request.getParameter("action");
        String userPath = request.getServletPath();

        if (userPath.equals("/dashboard")) {
            HttpSession session = request.getSession();
            Manager manger = (Manager) session.getAttribute("adminUser");
            if (manger == null) {
                forward = LOGIN_ADMIN_PAGE;
            }
            forward = DASHBOARD_PAGE_ADMIN;
            if (StringUtils.isNotEmpty(action)) {
                if (action.equals("pendingOrder")) {//dashboard?action=pendingOrder
                    List<Order> orders = orderDao.getAllOrderBystatus("pending");
                    request.setAttribute("orders", orders);
                    request.setAttribute("type", "pending");
                } else if (action.equals("approvedOrder")) {
                    List<Order> orders = orderDao.getAllOrderBystatus("approved");
                    request.setAttribute("orders", orders);
                    request.setAttribute("type", "approved");
                } else if (action.equals("deliveredOrder")) {
                    List<Order> orders = orderDao.getAllOrderBystatus("delivered");
                    request.setAttribute("orders", orders);
                    request.setAttribute("type", "delivered");
                } else if (action.equals("listcustomers")) {
                    List<Customer> customer = customerDao.getAllCustomer();
                    request.setAttribute("customers", customer);
                    request.setAttribute("type", "customer");
                } else if (action.equals("listProduct")) {
                    //list products with each
                    List<FictionalBook>  fictionList = fictionBookDao.getAllFictionalBook();
                    List<NonFictionalBook> nonfiction = nonFictionBookDao.getAllNonFictionalBook();
                    List<KidsBook> kidbooks =  kidbookDao.getAllKidsBook();
                    
                    request.setAttribute("fictional", fictionList);
                    request.setAttribute("nonfiction", nonfiction);
                    request.setAttribute("kidbooks", kidbooks);
                    request.setAttribute("type", "products");
                }
            }

        } else {
            forward = DASHBOARD_PAGE_ADMIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    //convert to json and write to webpage
    //Orders
    //Books list handle conditions
    //Order list handle conditions
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
                    c.setCustomerId(request.getParameter("customerId"));

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
                    c.setCustomerId(request.getParameter("customerId"));

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
