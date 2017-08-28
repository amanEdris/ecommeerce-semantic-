<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

    <head>
        <title>Start Page</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
        <meta name="description" content="RealBooks online store">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- jQuery -->

        <script    src="./javascript/jquery.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script type="text/javascript"   src="./javascript/bootstrap.min.js"></script>
        <script type="text/javascript"  src="./javascript/bootstrap.js"></script>
        <script type="text/javascript"  src="./javascript/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="./javascript/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript"  src="./javascript/dataTables.responsive.js"></script>

        <!--
               <script type="text/javascript"  src="./javascript/jquery-1.10.2.min.js"></script>
                  <script type="text/javascript"  src="./javascript/jquery-migrate-1.2.1.min.js"></script>
                  <script type="text/javascript"   src="./javascript/jquery-1.7.1.min.js"></script>
                  <script type="text/javascript"  src="./javascript/jquery-ui-1.8.16.custom.min.js"></script>-->
        <script type="text/javascript"  src="./javascript/jquery.cookie.js"></script>
        <script type="text/javascript"  src="./javascript/jquery.cycle.js"></script>
        <script type="text/javascript"  src="./javascript/tabs.js"></script>
        <script type="text/javascript" src="./javascript/jQuery.equalHeights.js"></script>
        <script type="text/javascript"  src="./javascript/jquery.elevatezoom.js"></script>
        <script type="text/javascript"  src="./javascript/jquery.prettyPhoto.js"></script>
        <script type="text/javascript"  src="./javascript/jscript_zjquery.anythingslider.js"></script>
        <script type="text/javascript"  src="./javascript/common.js"></script>
        <script type="text/javascript"  src="./javascript/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript"  src="./javascript/jquery.mobile-events.js"></script>
        <script type="text/javascript"  src="./javascript/superfish.js"></script>
        <script type="text/javascript"  src="./javascript/livesearch.js"></script>
        <script type="text/javascript"  src="./javascript/superfish.js"></script>
        <script type="text/javascript"  src="./javascript/script.js"></script>
        <script type="text/javascript" src="./javascript/3ts2ksMwXvKRuG480KNifJ2_JNM.js"></script>
        <script type="text/javascript" src="./javascript/4o300efCt-CXoq1JEC-sVReFz48.js"></script>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/stylesheet.css" rel="stylesheet" type="text/css">
        <link href="./css/superfish.css" rel="stylesheet" type="text/css">
        <link href="./css/responsive.css" rel="stylesheet" type="text/css">
        <link href="./css/font-awesome.css" rel="stylesheet" type="text/css">
        <!--<link href="./css/photoswipe.css" rel="stylesheet" type="text/css">-->
        <link href="./css/cloud-zoom.css" rel="stylesheet" type="text/css">
        <link href="./css/slideshow.css" rel="stylesheet" type="text/css">
        <link href="./css/jquery.prettyPhoto.css" rel="stylesheet" type="text/css">
        <link href="./css/camera.css" rel="stylesheet" type="text/css">
        <link href="./css/photoswipe.css" rel="stylesheet" type="text/css">
        <link href="./css/jquery.bxslider.css" rel="stylesheet" type="text/css">
        <link href="./css/colorbox.css" rel="stylesheet" type="text/css">
        <link href="./css/css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="./css/jquery-ui-1.8.16.custom.css">
        <link rel="stylesheet" type="text/css" href="./css/jquery.fancybox-1.3.4.css" media="screen">
        <!-- DataTables CSS -->
        <link href="./css/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="./css/dataTables.responsive.css" rel="stylesheet">
        <script>
            if (navigator.userAgent.match(/Android/i)) {
                var viewport = document.querySelector("meta[name=viewport]");
            }
            if (navigator.userAgent.match(/Android/i)) {
                window.scrollTo(0, 1);
            }
        </script>


    </head>
    <body class="common-home">
        <c:set var="urlRequest" value="http://localhost:8080/UniqueBookApp/book?" scope="page"/>
        <div id="body">
            <div class="swipe" style="height: 330px;">
                <div class="swipe-menu">
                    <ul class="links">
                        <li class="first">
                            <a class="active" href="#">
                                <i class="fa fa-home"></i>Home</a>
                        </li>
                        <li>
                            <a class="" href="/UniqueBookApp/account?action=show">
                                <i class="fa fa-user"></i>My Account</a>
                        </li>
                        <li>
                            <a class="" href="/UniqueBookApp/cart?action=show">
                                <i class="fa fa-shopping-cart"></i>Shopping Cart</a>
                        </li>
                        <li>
                            <a class="" href="/UniqueBookApp/cart?action=checkout">
                                <i class="fa fa-check"></i>Checkout</a>
                        </li>
                        <li>
                            <a href="/UniqueBookApp/account?action=edit">
                                <i class="fa fa-user"></i>Create an account</a>
                        </li>
                        <li class="login_h">
                            <a href="/UniqueBookApp/account?action=login">
                                <i class="fa fa-lock"></i>Login</a>
                        </li>
                    </ul>

                    <ul class="foot">
                        <li>
                            <a href="#about">About</a>
                        </li>
                        <li>
                            <a href="#">Privacy Policy</a>
                        </li>
                    </ul>
                    <ul class="foot foot-1">
                        <li>
                            <a href="#">Contact Us</a>
                        </li>
                    </ul>
                    <ul class="foot foot-2"></ul>
                    <ul class="foot foot-3">
                        <li>
                            <a href="#">Order History</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div id="page">
                <div id="shadow">
                    <div class="shadow" style="height: 2193px;"></div>
                    <jsp:include page="includesPages/_header.jsp"></jsp:include>
                        <section>
                            <div id="container">
                                <div class="container">
                                    <div class="row">

                                        <div class="col-sm-9 col-sm-12    right" id="content">
                                            <div class="breadcrumb">
                                                <a href="/UniqueBookApp">Home</a>
                                                »
                                                <a href="/UniqueBookApp/viewCart">Order</a>
                                                »
                                                <a href="#" class="last">My orders</a>
                                            </div>
                                            <div class="box-container">
                                                <div class="box-container">
                                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-customerOrder">
                                                        <thead>
                                                            <tr>
                                                                <th>Order Number</th>
                                                                <th>Item</th>
                                                                <th>Quantity * price
                                                                </th>
                                                                <th>order Status</th>
                                                                <th>Delivery Address</th>
                                                                <th>Delivery Date</th>
                                                                <th>Total price
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach var="order" items="${orders}">
                                                            <c:set var="sales" value="${order.sales}"/>
                                                            <tr>
                                                                <td>${order.orderNumber}</td>
                                                                <td>
                                                                    <ol>
                                                                        <c:forEach var="sale" items="${sales}">
                                                                            <c:set var="product" value="${sale.product}"/>
                                                                            <li>
                                                                                ${product.productName}
                                                                            </li>
                                                                        </c:forEach>
                                                                    </ol>
                                                                </td>
                                                                <td>
                                                                    <ol>
                                                                        <c:forEach var="sale" items="${sales}">
                                                                            <c:set var="product" value="${sale.product}"/>

                                                                            <li>
                                                                                ${product.price} * ${sale.productQuantity}</li>
                                                                            </c:forEach>
                                                                    </ol>
                                                                </td>
                                                                <td>${order.orderStatus}</td>
                                                                <c:set var="delivery" value="${order.delivery}"/>
                                                                <c:set var="location" value="${delivery.location}"/>
                                                                <td>
                                                                    ${location.city}<br/>
                                                                    ${location.country}<br/>
                                                                    ${location.address}<br/>
                                                                    ${location.postalCode}
                                                                </td>
                                                                <td>
                                                                    <fmt:formatDate pattern="yyyy-MMM-dd" value="${delivery.deliveryDate}"/>

                                                                </td>
                                                                <td>
                                                                    ${order.totalPrice}
                                                                </td>
                                                            </tr>

                                                        </c:forEach>

                                                    </tbody>
                                                </table>

                                            </div>
                                        </div>
                                    </div>
                                    <aside class="col-sm-2" id="column-right">
                                        <div class="box account">
                                            <div class="box-heading">Account</div>
                                            <div class="box-content">
                                                <ul class="acount">
                                                    <c:if test="${empty User}">
                                                        <li>
                                                            <i class="fa fa-lock"></i>&nbsp;&nbsp;<a href="/UniqueBookApp/account?action=login&type=show">Login</a>
                                                            /
                                                            <a href="http://localhost:8080/UniqueBookApp/account?action=edit">Register</a>
                                                        </li>
                                                    </c:if>
                                                    <c:if test="${!empty User}">
                                                        <li>
                                                            <i class="fa fa-user"></i>&nbsp;&nbsp;<b>
                                                                <a href="/UniqueBookApp/account?action=edit&data=show">My Account</a>
                                                            </b>
                                                        </li>
                                                        <li>
                                                            <i class="fa fa-print"></i>&nbsp;&nbsp;<b>
                                                                <a href="/UniqueBookApp/order?action=show">Order History</a>
                                                            </b>
                                                        </li>
                                                    </c:if>

                                            </div>
                                        </div>
                                    </aside>

                                </div>
                            </div>
                        </div>
                </div>

                <div class="clear"></div>
                </section>
                <jsp:include page="includesPages/_footer.jsp"></jsp:include>

            </div>
        </div>




        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
        <script>
            $(document).ready(function () {
                $('#dataTables-customerOrder').DataTable({responsive: true});
            });
        </script>
    </body>
</html>
