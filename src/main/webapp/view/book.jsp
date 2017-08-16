<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <title>Start Page</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
        <meta name="description" content="RealBooks online store">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="./javascript/3ts2ksMwXvKRuG480KNifJ2_JNM.js"></script>
        <script type="text/javascript" src="./javascript/4o300efCt-CXoq1JEC-sVReFz48.js"></script>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/stylesheet.css" rel="stylesheet" type="text/css">
        <link href="./css/superfish.css" rel="stylesheet" type="text/css">
        <link href="./css/responsive.css" rel="stylesheet" type="text/css">
        <link href="./css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="./css/photoswipe.css" rel="stylesheet" type="text/css">
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


        <script>
            if (navigator.userAgent.match(/Android/i)) {
                var viewport = document.querySelector("meta[name=viewport]");
            }
            if (navigator.userAgent.match(/Android/i)) {
                window.scrollTo(0, 1);
            }
        </script>


        <script type="text/javascript" src="./javascript/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery-ui-1.8.16.custom.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.cookie.js"></script>
        <script type="text/javascript" src="./javascript/jquery.fancybox-1.3.4.pack.js"></script>
        <script type="text/javascript" src="./javascript/jquery.colorbox.js"></script>
        <script type="text/javascript" src="./javascript/jquery.jcarousel.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.cycle.js"></script>
        <script type="text/javascript" src="./javascript/jquery.bxslider.js"></script>
        <script type="text/javascript" src="./javascript/tabs.js"></script>
        <script type="text/javascript" src="./javascript/jQuery.equalHeights.js"></script>
        <script type="text/JavaScript" src="./javascript/jquery.elevatezoom.js"></script>
        <script type="text/javascript" src="./javascript/jquery.prettyPhoto.js"></script>
        <script type="text/javascript" src="./javascript/jscript_zjquery.anythingslider.js"></script>
        <script type="text/javascript" src="./javascript/common.js"></script>
        <script type="text/javascript" src="./javascript/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript" src="./javascript/jquery.mobile-events.js"></script>
        <script type="text/javascript" src="./javascript/superfish.js"></script>
        <script type="text/javascript" src="./javascript/livesearch.js"></script>
        <script type="text/javascript" src="./javascript/jquery.cookie.js"></script>
        <script type="text/javascript" src="./javascript/superfish.js"></script>
        <script type="text/javascript" src="./javascript/bootstrap.js"></script>
        <script type="text/javascript" src="./javascript/script.js"></script>


    </head>
    <body class="common-home">
        <c:set var="urlRequest" value="http://localhost:8080/UniqueBookApp/book?" scope="page" />
        <div id="body">
            <div class="swipe" style="height: 330px;">
                <div class="swipe-menu">
                    <ul class="links">
                        <li class="first"><a class="active" href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><a class="" href="/UniqueBookApp/account?action=show"><i class="fa fa-user"></i>My Account</a></li>
                        <li><a class="" href="/UniqueBookApp/cart?action=show"><i class="fa fa-shopping-cart"></i>Shopping Cart</a></li>
                        <li><a class="" href="/UniqueBookApp/cart?action=checkout"><i class="fa fa-check"></i>Checkout</a></li>
                        <li><a href="/UniqueBookApp/account?action=edit"><i class="fa fa-user"></i>Create an account</a></li>
                        <li class="login_h"><a href="/UniqueBookApp/account?action=login"><i class="fa fa-lock"></i>Login</a></li>   					</ul>

                    <div id="language" class="header-button">
                        <div class="heading">en<i class="fa fa-angle-down"></i></div>
                        <div class="heading1"><i class="fa fa-globe"></i>Language<i class="fa fa-angle-down"></i></div>
                        <ul>

                        </ul>
                    </div>

                    <div id="currency" class="header-button">
                        <div>
                            <div class="heading-1"><i class="fa fa-money"></i>Currency<i class="fa fa-angle-down"></i></div>
                            <div class="heading">
                                $<i class="fa fa-angle-down"></i>
                            </div>
                        </div>
                        <ul>
                            <form action="#" method="post" enctype="multipart/form-data">
                                <li><a title="US Dollar"><span class="act">$</span></a></li>
                                <input type="hidden" name="currency_code" value="">
                                <input type="hidden" name="redirect" value="">
                            </form>
                        </ul>

                    </div>

                    <ul class="foot">
                        <li><a href="#about">About</a></li>
                        <li><a href="#delivery">Delivery</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms &amp; Conditions</a></li>
                    </ul>
                    <ul class="foot foot-1">
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Returns</a></li>
                    </ul>
                    <ul class="foot foot-2">
                    </ul>
                    <ul class="foot foot-3">
                        <li><a href="#">Order History</a></li>
                    </ul>
                </div>
            </div>
            <div id="page">
                <div id="shadow">
                    <div class="shadow" style="height: 2193px;"></div>
                    <jsp:include page="includesPages/_header.jsp"></jsp:include>
                        <section> 
                            <div id="container">
                                <div  class="container">
                                    <div class="row">

                                        <div class="col-sm-9 col-sm-12    right" id="content">  <div class="breadcrumb">
                                                <a href="/UniqueBookApp">Home</a>
                                                » <a href="/UniqueBookApp/book?action=list">Products</a>
                                                » <a href="/UniqueBookApp/book?action=add" class="last">Add product</a>
                                            </div>
                                            <h1>Add Product </h1>

                                            <div class="box-container">
                                                <p>To go back to Book list <a href="/UniqueBookApp/book?action=list">>> Go Back</a>.</p>
                                                <form class="form-horizontal" action="book" method="post" enctype="multipart/form-data" id="register">
                                                    <h2>Product detail</h2>
                                                    <div class="content">
                                                        <table class="form">      
                                                            <tbody><tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="productName"><span class="required">*</span> Product Name:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="productName" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="productDetail"><span class="required">*</span> Product description:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <textarea class="q1"  name="productDetail" cols="20" rows="15"></textarea>
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                 <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="productPrice"><span class="required">*</span> Product price:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="productPrice" value="">                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="bookISBN"><span class="required">*</span> ISBN:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="bookISBN" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="bookRevisionNo￼"><span class="required">*</span> Book Revision No:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="bookRevisionNo￼" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                               <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="quantity"><span class="required">*</span> quantity:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="quantity" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                               
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="publisher"><span class="required">*</span> Publisher:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="publisher" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="PublishedYear"><span id="required" class="required">*</span> Published Year:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="PublishedYear" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="title"><span id="required" class="required">*</span> Title:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="title" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                 <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="imagePath"><span id="required" class="required">*</span> Image￼ Path:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="imagePath" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                 <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="author"><span id="required" class="required">*</span> Author:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="author" value="">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="category"><span class="required">*</span> Category:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <select name="country_id">
                                                                                    <option value=""> --- Please Select --- </option>
                                                                                    <option value="Romance">Romance</option>
                                                                                    <option value="Fiction">Fiction</option>
                                                                                    <option value="Religion">Religion</option>
                                                                                   
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                
                                                            </tbody></table>
                                                    </div>
                                                  

                                                    <div class="buttons">
                                                        <div class="right">
                                                              <input type="submit" value="Submit" class="buttons"/>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <aside class="col-sm-2" id="column-right">
                                            <div class="box account">
                                                <div class="box-heading">Account</div>
                                                <div class="box-content">
                                                    <ul class="acount">
                                                         <li><a href="/UniqueBookApp/book?action=list">Product</a> 
                                                        <li><a href="/UniqueBookApp/order?action=list">Orders</a></li>
                                                        <li><a href="/UniqueBookApp/order?action=list">Customers</a></li>
                                                        <li><a href="/UniqueBookApp/order?action=list">Admin Accounts</a></li>
                                                    </ul>
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
    </body>
</html>
