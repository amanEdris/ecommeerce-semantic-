/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.hp.hpl.jena.sparql.util.Utils;
import com.uniquebook.dao.BookDao;
import com.uniquebook.dao.CustomerDao;
import com.uniquebook.dao.FictionalBooksDao;
import com.uniquebook.dao.KidsBookDao;
import com.uniquebook.dao.ManagerDao;
import com.uniquebook.dao.NonFictionalBooksDao;
import com.uniquebook.dao.OrderDao;
import com.uniquebook.models.Book;
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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import org.apache.commons.lang.StringUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author edris
 */
@WebServlet(name = "DashBoardController", urlPatterns = {"/updateOrder", "/dashboard", "/addProduct", "/addCustomer", "/updateCustomer", "/addManager", "/updateManager"})
public class DashBoardController extends HttpServlet {

    private static final String DASHBOARD_PAGE_ADMIN = "/view/admin/admindashboard.jsp";
    private static final String DASHBOARD_PAGE_CUSTOMER = "/view/dashboard.jsp";
    private static final String LOGIN_ADMIN_PAGE = "/view/admin/login.jsp";
    private static final String ADD_PRODUCT_PAGE = "/view/forms/_productAddForm.jsp";
    private static final String INSERT_OR_EDIT = "/view/forms/_customerAddAdminForm.jsp";

    private CustomerDao customerDao;
    private OrderDao orderDao;
    private FictionalBooksDao fictionBookDao;
    private NonFictionalBooksDao nonFictionBookDao;
    private KidsBookDao kidbookDao;
    private BookDao bookDao;
    private ManagerDao managerDao;

    //private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "image";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; 	// 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private String filePath;

    public DashBoardController() {
        super();
        customerDao = new CustomerDao();
        orderDao = new OrderDao();
        fictionBookDao = new FictionalBooksDao();
        nonFictionBookDao = new NonFictionalBooksDao();
        kidbookDao = new KidsBookDao();
        bookDao = new BookDao();
        managerDao = new ManagerDao();
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
            if (Utils.equal(null, manger)) {
                forward = LOGIN_ADMIN_PAGE;
            }
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
                } else if (action.equals("showProfile")) {
                    Manager mancager = new Manager();
                    mancager = (Manager) session.getAttribute("adminUser");
                    Manager manager = managerDao.getManagerByEmail(mancager.getEmail());
                    request.setAttribute("User", manager);
                    request.setAttribute("type", "createManger");
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
                    request.setAttribute("update", false);
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
                    Book b = bookDao.getBookbyProductNumber(productId, category);
                    request.setAttribute("publisheYear", b.getStringPublishedYear());
                    request.setAttribute("path", ADD_PRODUCT_PAGE);
                    request.setAttribute("type", "Addproducts");
                    request.setAttribute("book", b);
                    request.setAttribute("update", true);

                } else if (action.equals("editCustomer")) {
                    String customerId = request.getParameter("customerId");
                    Customer customer = customerDao.getCustomerByID(customerId);
                    request.setAttribute("User", customer);
                    request.setAttribute("type", "Customeredit");

                } else if (action.equals("listmanagers")) {
                    List<Manager> managers = managerDao.getAllManager();
                    request.setAttribute("managers", managers);
                    request.setAttribute("type", "admin");
                } else if (action.equals("editManager")) {
                    String email = request.getParameter("email");
                    Manager manager = managerDao.getManagerByEmail(email);
                    request.setAttribute("User", manager);
                    request.setAttribute("type", "createManger");

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

                } else if (action.equals("deleteManager")) {
                    try {
                        String email = (request.getParameter("email"));
                        managerDao.deleteManager(email);

                        List<Manager> managers = managerDao.getAllManager();
                        request.setAttribute("managers", managers);
                        request.setAttribute("type", "admin");

                        //delete customer 
                    } catch (Exception ex) {
                        Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (action.equals("createCustomer")) {
                    request.setAttribute("type", "createCustomer");

                } else if (action.equals("AddManager")) {
                    request.setAttribute("type", "createManger");

                } else if (action.equals("deleteOrder")) {
                    String orderNumber = (request.getParameter("orderNumber"));
                    //get order by order number and forward to type order status
                    orderDao.deleteOrder(orderNumber);
                    List<Order> orders = orderDao.getAllOrderBystatus("pending");
                    request.setAttribute("orders", orders);
                    request.setAttribute("type", "pending");
                } else if (action.equals("editOrder")) {
                    String orderNumber = (request.getParameter("orderNumber"));
                    String orderStatus = (request.getParameter("orderStatus"));
                    request.setAttribute("type", "updateOrder");
                    request.setAttribute("orderNumber", orderNumber);
                    request.setAttribute("orderstatus", orderStatus);

                } else {

                }

            }

        } else {
            forward = DASHBOARD_PAGE_ADMIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    /**
     * @Todo item.file name renaming
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();
        String forward = DASHBOARD_PAGE_ADMIN;
        String mainCategory = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String imagePath = null;

        if (userPath.equals("/addProduct")) {
            request.setAttribute("path", ADD_PRODUCT_PAGE);
            request.setAttribute("type", "Addproducts");
            Product product = new Product();
            Book book = new Book();

            // checks if the request actually contains upload file
            if (!ServletFileUpload.isMultipartContent(request)) {
                // if not, we stop here
                PrintWriter writer = response.getWriter();
                writer.println("Error: Form must has enctype=multipart/form-data.");
                writer.flush();
                return;
            }

            // configures upload settings
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // sets memory threshold - beyond which files are stored in disk 
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            // sets temporary location to store files
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);

            // sets maximum size of upload file
            //upload.setFileSizeMax(MAX_FILE_SIZE);
            // sets maximum size of request (include file + form data)
            upload.setSizeMax(MAX_REQUEST_SIZE);

            // constructs the directory path to store upload file
            // this path is relative to application's directory
            String uploadPath = getServletContext().getRealPath("")
                    + File.separator + UPLOAD_DIRECTORY;

            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                // parses the request's content to extract file data
                @SuppressWarnings("unchecked")
                List<FileItem> formItems = upload.parseRequest(request);

                if (formItems != null && formItems.size() > 0) {
                    // iterates over form's fields
                    for (FileItem item : formItems) {
                        // processes only fields that are not form fields
                        if (!item.isFormField()) {

                            String fileName = new File(item.getName()).getName();

                            if (StringUtils.isNotEmpty(fileName)) {
                                //add change file name
                                //@todo check if upload image
                                filePath = uploadPath + File.separator + fileName;
                                File storeFile = new File(filePath);

                                // saves the file on disk
                                item.write(storeFile);
                                request.setAttribute("goodmessage",
                                        "Upload has been done successfully!");

                            }

                        } else {
                            String fieldName = item.getFieldName();
                            String fieldValue = item.getString();

                            if (null == fieldName) {
                                product.setImagepath(filePath);
                            } else {
                                switch (fieldName) {
                                    case "title":
                                        product.setProductName(fieldValue);
                                        book.setTitle(fieldValue);
                                        break;
                                    case "productPrice":
                                        product.setPrice(Float.parseFloat(fieldValue));
                                        break;
                                    case "bookISBN":
                                        book.setIsbn(fieldValue);
                                        break;
                                    case "bookRevisionNo":
                                        book.setRevisionNo(fieldValue);
                                        break;
                                    case "quantity":
                                        product.setQuantity(Integer.parseInt(fieldValue));
                                        book.setQuantity(Integer.parseInt(fieldValue));
                                        break;
                                    case "publisher":
                                        book.setPublisher(fieldValue);
                                        break;
                                    case "PublishedYear":
                                        book.setPublishedYear(sdf.parse(fieldValue));
                                        break;
                                    case "author":
                                        book.setAuthor(fieldValue);
                                        break;
                                    case "productDetail":
                                        book.setDescription(fieldValue);
                                        product.setDescription(fieldValue);
                                        break;
                                    case "fiction":
                                        mainCategory = StringUtils.isNotEmpty(fieldValue) ? fieldValue : mainCategory;
                                        break;
                                    case "nonfiction":
                                        mainCategory = StringUtils.isNotEmpty(fieldValue) ? fieldValue : mainCategory;
                                        break;
                                    case "kidbook":
                                        mainCategory = StringUtils.isNotEmpty(fieldValue) ? fieldValue : mainCategory;
                                        break;
                                    case "imagepath":
                                        imagePath = StringUtils.isEmpty(filePath) ? fieldValue : filePath;
                                        product.setImagepath(imagePath);
                                        break;
                                    case "productNumber":
                                        product.setProductNumber(StringUtils.equals(fieldValue, null) ? 0 : Integer.parseInt(fieldValue));
                                        break;
                                    default:
                                        product.setImagepath(filePath);
                                        break;
                                }
                            }
                        }
                    }

                    if (product.getProductNumber() == 0) {

                        bookDao.createBookProduct(filePath, mainCategory, book, product);
                        filePath = null;
                    } else {

                        bookDao.updateBookProduct(imagePath, mainCategory, book, product);
                    }

                }

            } catch (Exception ex) {
                request.setAttribute("message",
                        "There was an error: " + ex.getLocalizedMessage());
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
        } else if (userPath.equals("/addManager")) {
            Manager c = new Manager();
            c.setEmail(request.getParameter("email"));
            c.setFirstName(request.getParameter("firstname"));
            c.setLastName(request.getParameter("lastname"));
            c.setPassword(request.getParameter("password"));
            c.setGender(request.getParameter("male"));
            c.setPhone(request.getParameter("telephone"));
            boolean check = managerDao.addManager(c);
            request.setAttribute("type", "createManger");

            if (check) {
                request.setAttribute("Message", "Email regitered please use different Email!");
            } else {
                request.setAttribute("goodmessage", "New admin added!");
            }
        } else if (userPath.equals("/addManager")) {
            Manager c = new Manager();
            c.setEmail(request.getParameter("email"));
            c.setFirstName(request.getParameter("firstname"));
            c.setLastName(request.getParameter("lastname"));
            c.setPassword(request.getParameter("password"));
            c.setGender(request.getParameter("male"));
            c.setPhone(request.getParameter("telephone"));
            boolean check = managerDao.addManager(c);
            request.setAttribute("type", "createManger");

            if (check) {
                request.setAttribute("Message", "Email regitered please use different Email!");
            } else {
                request.setAttribute("goodmessage", "New admin added!");
            }
        } else if (userPath.equals("/updateManager")) {
            Manager c = new Manager();
            c.setEmail(request.getParameter("email"));
            c.setFirstName(request.getParameter("firstname"));
            c.setLastName(request.getParameter("lastname"));
            c.setPassword(request.getParameter("password"));
            c.setGender(request.getParameter("male"));
            c.setPhone(request.getParameter("telephone"));
            boolean check = managerDao.updateManager(c);
            request.setAttribute("type", "createManger");

            if (check) {
                request.setAttribute("Message", "Email regitered please use different Email!");
            } else {
                request.setAttribute("goodmessage", "New admin added!");
            }
            Manager manager = managerDao.getManagerByEmail(request.getParameter("email"));
            request.setAttribute("User", manager);
            request.setAttribute("type", "createManger");

            if (check) {

                request.setAttribute("Message", "Email regitered please use different Email!");
            } else {
                request.setAttribute("goodmessage", " Customer data updated!");
            }
        } else if (userPath.equals("/updateOrder")) {
            boolean check = orderDao.updateOrderStatus(request.getParameter("orderNumber"),
                    request.getParameter("orderstatus"), request.getParameter("previousOrderstatus"));
            if (check) {
                List<Order> orders = orderDao.getAllOrderBystatus(request.getParameter("orderstatus"));
                request.setAttribute("orders", orders);
                request.setAttribute("type", request.getParameter("orderstatus"));
                request.setAttribute("goodmessage", "Order Status updated!");
            } else {
                request.setAttribute("Message", "Sorry unable to update order status!");
            }
        } else {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

}

//      response.setContentType("text/html;charset=UTF-8");
//                            try (PrintWriter out = response.getWriter()) {
//
//                                out.println("<!DOCTYPE html>");
//                                out.println("<html>");
//                                out.println("<head>");
//                                out.println("<title>Servlet OrderController</title>");
//                                out.println("</head>");
//                                out.println("<body>");
//                                out.println("<h1>Here is a Book: file path :" + fileName.toString());
//                                out.println("<h1>Here is a Book: file Name :" + item.getName());
//
//                                out.println("</body>");
//                                out.println("</html>");
//        }
//                            
//      response.setContentType("text/html;charset=UTF-8");
//                            try (PrintWriter out = response.getWriter()) {
//
//                                out.println("<!DOCTYPE html>");
//                                out.println("<html>");
//                                out.println("<head>");
//                                out.println("<title>Servlet OrderController</title>");
//                                out.println("</head>");
//                                out.println("<body>");
//                                out.println("<h1>Here is a Book: file Name :" + item.getName());
//
//                                out.println("</body>");
//                                out.println("</html>");
//                            }
