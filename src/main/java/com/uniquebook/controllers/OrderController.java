/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.uniquebook.dao.OrderDao;
import com.uniquebook.models.Customer;
import com.uniquebook.models.Delivery;
import com.uniquebook.models.Location;
import com.uniquebook.models.Order;
import com.uniquebook.models.ShoppingCart;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
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
@WebServlet(name = "OrderController", urlPatterns = {"/order", "/checkout"})
public class OrderController extends HttpServlet {

    private static String CONFIRMATION_PAGE = "/view/confirmation.jsp";
    private static String LOGIN_PAGE = "/view/login.jsp";
    private static String CHECKOUT_PAGE = "/view/checkout.jsp";
    private final static String NEW_ORDER_STATUS = "pending";
    private final static int DELIVERY_CHARGE = 3;
    private OrderDao orderDao;

    public OrderController() {
        super();
        orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        HttpSession session = request.getSession();
        Customer c = (Customer) session.getAttribute("User");
        String action = request.getParameter("action");

        if(StringUtils.isEmpty(action)){
             forward = LOGIN_PAGE;
        }else{
            if (action.equalsIgnoreCase("checkout")) {
                if (c == null) {
                    forward = LOGIN_PAGE;

                } else {
                    forward = CONFIRMATION_PAGE;
                }

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
        String address, city, postalcode, country, id;
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Customer c = (Customer) session.getAttribute("User");
        Location l = new Location();

        if (userPath.equals("/checkout")) {
            String agree = request.getParameter("agree");

            if (StringUtils.isNotEmpty(agree)) {
                l.clone(c.getLocation());
                Order order = createNewOrder(c, cart, l);
                String ordername = orderDao.addOrder(order);
                if (StringUtils.isNotEmpty(ordername)) {
                    forward = CHECKOUT_PAGE;
                    cart.removeAllItems();
                    cart = null;
                    session.removeAttribute("cart");

                }

            } else {
                address = request.getParameter("address_1");
                city = request.getParameter("city");
                postalcode = request.getParameter("postcode");
                country = request.getParameter("country_id");
                //prepare new delivery location
                l.setAddress(address);
                l.setCity(city);
                l.setCountry(country);
                l.setPostalCode(postalcode);
                Order order = createNewOrder(c, cart, l);
                String ordername = orderDao.addOrder(order);
                if (StringUtils.isNotEmpty(ordername)) {
                    forward = CHECKOUT_PAGE;
                    cart.removeAllItems();
                    cart = null;
                    session.removeAttribute("cart");
                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    private Order createNewOrder(Customer c, ShoppingCart cart, Location l) {
        String id;

        id = UUID.randomUUID().toString();
        //xsd date 
        Date deliveryStartDate = new Date();
        Delivery d = new Delivery(deliveryStartDate, l);
        Order order = new Order();
        order.setCusotmer(c);
        order.setDelivery(d);
        order.setOrderNumber(id);
        order.setTotalPrice(cart.getTotal() + DELIVERY_CHARGE);
        order.setSales(cart.getSalesList());
        order.setOrderStatus(NEW_ORDER_STATUS);

        return order;
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

