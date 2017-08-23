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
        <c:set var="urlRequest" value="/UniqueBookApp/book?" scope="page" />
        <div id="body">
            <div class="swipe" style="height: 330px;">
                   <div class="swipe-menu">
                    <ul class="links">
                        <li class="first"><a class="active" href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><a class="" href="#"><i class="fa fa-user"></i>My Account</a></li>
                        <li><a class="" href="#"><i class="fa fa-shopping-cart"></i>Shopping Cart</a></li>
                        <li><a class="" href="#"><i class="fa fa-check"></i>Checkout</a></li>
                        <li><a href="#"><i class="fa fa-user"></i>Create an account</a></li><li class="login_h"><a href="#"><i class="fa fa-lock"></i>Login</a></li>   					</ul>

               

                  

                    <ul class="foot">
                        <li><a href="#about">About</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms &amp; Conditions</a></li>
                    </ul>
                    <ul class="foot foot-1">
                        <li><a href="#">Contact Us</a></li>
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

                            <div class="box-container">


                                <div id="container">
                                    <div  class="container">
                                        <div class="row"><div class="col-sm-9 col-sm-12    right" id="content">
                                                <div class="breadcrumb">
                                                <c:url var="url" value="/deleteCart?action=clear">
                                                </c:url>
                                                <c:if test="${!empty cart && cart.numberOfItems != 0}">
                                                    <a href="${url}" class="bubble hMargin"><b>CLEAR CART</b></a>
                                                </c:if>
                                                <span style="margin-right:190px;margin-left:220px">
                                                    <a href="/UniqueBookApp/" class="bubble hMargin"><b>CONTINUE SHOPPING</b></a>
                                                </span>
                                                <span style="margin-left:0px ">
                                                    <c:url var="uyrl" value="/order?action=checkout">
                                                </c:url>
                                                    <a href="${uyrl}"><b>CHECKOUT</b> </a>
                                                </span>
                                            </div>  <%-- clear cart widget --%>

                                            <div class="clear"></div>
                                            <div class="clear"></div>
                                            <c:if test="${empty cart}">
                                                <p>Your shopping cart contains 0 items. and total price => 0$</p>
                                            </c:if>
                                            <c:if test="${!empty cart}"> 
                                                <p>Your shopping cart contains <c:out value="${cart.numberOfItems}" /> items. and total price => <c:out value="${cart.total}" /></p>
                                            </c:if>
                                            <div class="content">
                                                <table border="1" class="form">
                                                    <thead>
                                                        <tr>
                                                            <th>Product</th>
                                                            <th>Name</th>
                                                            <th>Price</th>
                                                            <th>Quantity</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
                                                            <c:set var="product" value="${cartItem.product}"/>
                                                            <tr  style="background-color: ${((iter.index % 2) == 0) ? 'seashell' : '#DDDDDD'}">
                                                                <td><img src="${product.imagepath}"
                                                                         alt="${product.productName}"></td>
                                                                <td>${product.productName}</td>
                                                                <td>${cartItem.total}$<br/> ${product.price} /unit</td>
                                                                <td>
                                                                    <form  action="updateCart" method="post">
                                                                        <div class="cart-top-padd form-inline">
                                                                            <label>Qty: <input class="q-mini" type="text" name="quantity" size="2" value="${cartItem.quantity}">  </label>
                                                                        </div>
                                                                        <div class="extra-button">
                                                                            <input type="hidden" type="text" name="productNo" size="2" value="${product.productNumber}">
                                                                            <input type="hidden" name="category" value="<c:out value="${category}"/>" />

                                                                            <button style="border: 1px;background: white"
                                                                                    ><span>Update</span>
                                                                                <i class="fa fa-shopping-cart"></i>
                                                                            </button>
                                                                    </form>        
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>

                                            </div>

                                        </div></div></div></div>


                        </div>
                        <div class="clear"></div>
                    </section>
                    <jsp:include page="includesPages/_footer.jsp"></jsp:include>

                </div>
            </div>
    </body>
</html>
