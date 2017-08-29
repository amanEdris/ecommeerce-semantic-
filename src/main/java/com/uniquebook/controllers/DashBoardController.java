/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.uniquebook.dao.BookDao;
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
import com.uniquebook.models.Product;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author edris
 */
@WebServlet(name = "DashBoardController", urlPatterns = {"/dashboard", "/addProduct", "/addCustomer", "/updateCustomer"})
public class DashBoardController extends HttpServlet {

    private static String DASHBOARD_PAGE_ADMIN = "/view/admin/admindashboard.jsp";
    private static String DASHBOARD_PAGE_CUSTOMER = "/view/dashboard.jsp";
    private static String LOGIN_ADMIN_PAGE = "/view/admin/login.jsp";
    private static String ADD_PRODUCT_PAGE = "/view/forms/_productAddForm.jsp";
    private static String INSERT_OR_EDIT = "/view/forms/_customerAddAdminForm.jsp";

    private CustomerDao customerDao;
    private OrderDao orderDao;
    private FictionalBooksDao fictionBookDao;
    private NonFictionalBooksDao nonFictionBookDao;
    private KidsBookDao kidbookDao;
    private BookDao bookDao;

    //private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
    //handle file
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

    public DashBoardController() {
        super();
        customerDao = new CustomerDao();
        orderDao = new OrderDao();
        fictionBookDao = new FictionalBooksDao();
        nonFictionBookDao = new NonFictionalBooksDao();
        kidbookDao = new KidsBookDao();
        bookDao = new BookDao();
    }

    public void init() {
        // Get the file location where it would be stored. 
        filePath = getServletContext().getInitParameter("src/image");
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
                if (manger == null) {
                    forward = LOGIN_ADMIN_PAGE;
                } else if (action.equals("pendingOrder")) {//dashboard?action=pendingOrder
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
                    List<FictionalBook> fictionList = fictionBookDao.getAllFictionalBook();
                    List<NonFictionalBook> nonfiction = nonFictionBookDao.getAllNonFictionalBook();
                    List<KidsBook> kidbooks = kidbookDao.getAllKidsBook();

                    request.setAttribute("fictional", fictionList);
                    request.setAttribute("nonfiction", nonfiction);
                    request.setAttribute("kidbooks", kidbooks);
                    request.setAttribute("type", "products");
                } else if (action.equals("addProducts")) {
                    request.setAttribute("path", ADD_PRODUCT_PAGE);
                    request.setAttribute("type", "Addproducts");

                } else if (action.equals("deleteProduct")) {
                    int productId = Integer.parseInt(request.getParameter("productNumber"));
                    String category = request.getParameter("category").toString();
                    Product p = bookDao.getBookbyProductNumber(productId, category);
                    String subjectName = bookDao.getSubjectName(p);
                    boolean result = bookDao.deleteBook(subjectName);

                    //send back to the refere
                    //list products with each
                    List<FictionalBook> fictionList = fictionBookDao.getAllFictionalBook();
                    List<NonFictionalBook> nonfiction = nonFictionBookDao.getAllNonFictionalBook();
                    List<KidsBook> kidbooks = kidbookDao.getAllKidsBook();

                    request.setAttribute("fictional", fictionList);
                    request.setAttribute("nonfiction", nonfiction);
                    request.setAttribute("kidbooks", kidbooks);
                    request.setAttribute("type", "products");
                } else if (action.equals("editProduct")) {
                    int productId = Integer.parseInt(request.getParameter("productNumber"));
                    String category = request.getParameter("category").toString();

                } else if (action.equals("editCustomer")) {
                    String customerId = request.getParameter("customerId");
                    Customer customer = customerDao.getCustomerByID(customerId);
                    request.setAttribute("User", customer);
                    request.setAttribute("type", "Customeredit");

                } else if (action.equals("deleteCustomer")) {
                    try {
                        String customerId = (request.getParameter("customerId"));
                        customerDao.deleteCustomer(customerId);

                        List<Customer> customer = customerDao.getAllCustomer();
                        request.setAttribute("customers", customer);
                        request.setAttribute("type", "customer");

                        //delete customer 
                    } catch (Exception ex) {
                        Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (action.equals("createCustomer")) {
                    request.setAttribute("type", "createCustomer");

                } else {
                    //action=deleteOrder&orderNumber=1

                }

            }

        } else {
            forward = DASHBOARD_PAGE_ADMIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }
    
  

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();
        String forward = DASHBOARD_PAGE_ADMIN;

        if (userPath.equals("/addProduct")) {
            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();

                    } else {
// Process form file field (input type="file").
                        String fieldName = item.getFieldName();
                        String fileName = FilenameUtils.getName(item.getName());
                        InputStream fileContent = item.getInputStream();
                        boolean isInMemory = item.isInMemory();
                        long sizeInBytes = item.getSize();

// Write the file
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File("src/image/"
                                    + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File("src/image/" + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        item.write(file);

                        response.setContentType("text/html;charset=UTF-8");

                        try (PrintWriter out = response.getWriter()) {

                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Servlet OrderController</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>GET FILE PATH  " + file.getPath() + "</h1> and file path" + filePath);
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }
                }
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request.", e);
            } catch (Exception ex) {
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (userPath.equals("/addCustomer")) {
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
            c.setCustomerId(request.getParameter("customerId"));
            boolean check = customerDao.addCustomer(c);
            request.setAttribute("type", "createCustomer");

            if (check) {
                request.setAttribute("Message", "Email regitered please use different Email!");
            } else {
                request.setAttribute("goodmessage", "New Customer added!");
            }
        } else if (userPath.equals("/updateCustomer")) {
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
            c.setCustomerId(request.getParameter("customerId"));
            Customer cc = new Customer();
            cc.clone(c);
            boolean check = customerDao.updateCustomer(c, cc);
            String customerId = request.getParameter("customerId");
            Customer customer = customerDao.getCustomerByID(customerId);
            request.setAttribute("User", customer);
            request.setAttribute("type", "Customeredit");

            if (check) {

                request.setAttribute("Message", "Email regitered please use different Email!");
            } else {
                request.setAttribute("goodmessage", " Customer data updated!");
            }
        } else {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

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
