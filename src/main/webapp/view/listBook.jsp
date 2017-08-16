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
        <c:set var="urlRequest" value="http://localhost:8080/UniqueBookApp/book?" scope="page" />
        <div id="body">
            <div class="swipe" style="height: 330px;">
                <div class="swipe-menu">
                    <ul class="links">
                        <li class="first"><a class="active" href="/UniqueBookApp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a class="" href="/UniqueBookApp/account?action=edit&data=show"><i class="fa fa-user"></i>My Account</a></li>
                        <li><a class="" href="/UniqueBookApp/cart?action=show"><i class="fa fa-shopping-cart"></i>Shopping Cart</a></li>
                        <li><a class="" href="/UniqueBookApp/cart?action=checkout"><i class="fa fa-check"></i>Checkout</a></li>
                        <li><a href="/UniqueBookApp/account?action=edit"><i class="fa fa-user"></i>Create an account</a></li><li class="login_h"><a href="#"><i class="fa fa-lock"></i>Login</a></li>   					</ul>

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
                                <input type="hidden" name="redirect" value="https://livedemo00.template-help.com/opencart_47983/index.php?route=common/home">
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
                                <p id="back-top" style="display: none;"> <a href="https://livedemo00.template-help.com/opencart_47983/#top"><span></span></a> </p>
                                <div class="container">
                                    <div id="notification"></div>
                                    <div class="row">
                                        <div class="col-sm-12    right" id="content"><script type="text/javascript">
            if ($('.container').width() > 723) {
                (function ($) {
                    $.fn.equalHeights = function (minHeight, maxHeight) {
                        tallest = (minHeight) ? minHeight : 0;
                        this.each(function () {
                            if ($(this).height() > tallest) {
                                tallest = $(this).height()
                            }
                        });
                        if ((maxHeight) && tallest > maxHeight)
                            tallest = maxHeight;
                        return this.each(function () {
                            $(this).height(tallest)
                        })
                    }
                })(jQuery)
                $(window).load(function () {
                    if ($(".maxheight-feat").length) {
                        $(".maxheight-feat").equalHeights()
                    }
                });
            }
            ;
                                            </script>


                                            <div class="box featured">

                                            
                                            <c:if  test="${cat == 3}">
                                                <div class="breadcrumb">  Fiction Books >><i><c:out value="${category}"/></i>
                                                </div>   
                                            </c:if>

                                            <div class="box-content">
                                                <div class="box-product">
                                                    <c:set var="count" value="0" scope="page" />
                                                    <ul class="row">
                                                        <c:forEach items="${books}" var="book">
                                                            <c:set var="count" value="${count + 1}" />
                                                            <c:choose>
                                                                <c:when test="${count == '1'}">
                                                                    <c:set var="val" value="11"  />

                                                                    <li class="first-in-line  col-sm-2">
                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${book.productNumber}" />&category=<c:out value="${book.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${book.imagepath}" />" alt="<c:out value="${book.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${book.productNumber}" />&category=<c:out value="${book.category}"/>"><c:out value="${book.title}" /></a></div>
                                                                                <div class="description"><c:out value="${book.description}..." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${book.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>
                                                                    </li>
                                                                </c:when>
                                                                <c:when test="${count == 6}">
                                                                    <c:set var="count" value="0"  />
                                                                    <li class="last-in-line   col-sm-2">
                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${book.productNumber}" />&category=<c:out value="${book.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${book.imagepath}" />" alt="<c:out value="${book.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${book.productNumber}" />&category=<c:out value="${book.category}"/>"><c:out value="${book.title}" /></a></div>
                                                                                <div class="description"><c:out value="${book.description}..." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${book.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>
                                                                    </li>

                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:set var="vale" value="${val - 1}" />

                                                                    <li class="col-sm-2">

                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${book.productNumber}" />&category=<c:out value="${book.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${book.imagepath}" />" alt="<c:out value="${book.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="<c:out value="/UniqueBookApp/book?action=show&productNo${book.productNumber}" />&category=<c:out value="${book.category}"/>"><c:out value="${book.title}" /></a></div>
                                                                                <div class="description"><c:out value="${book.description}...." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${book.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>

                                                                    </li>
                                                                </c:otherwise>
                                                            </c:choose>


                                                        </c:forEach>

                                                    </ul>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                        </div>

                                        <div class="box featured">
                                            <c:if  test="${cat == 1}">
                                                <div class="breadcrumb">     Non Fictional Books >> <i><c:out value="${category}"/></i>
                                                </div>  </c:if>

                                                <div class="box-content">
                                                    <div class="box-product">
                                                    <c:set var="count" value="0" scope="page" />
                                                    <ul class="row">
                                                        <c:forEach items="${nonfibooks}" var="nonbook">
                                                            <c:set var="count" value="${count + 1}" />
                                                            <c:choose>
                                                                <c:when test="${count == '1'}">
                                                                    <c:set var="val" value="11"  />

                                                                    <li class="first-in-line  col-sm-2">
                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${nonbook.productNumber}" />&category=<c:out value="${nonbook.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${nonbook.imagepath}" />" alt="<c:out value="${nonbook.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${nonbook.productNumber}" />&category=<c:out value="${nonbook.category}"/>"><c:out value="${nonbook.title}" /></a></div>
                                                                                <div class="description"><c:out value="${nonbook.description}..." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${nonbook.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>
                                                                    </li>
                                                                </c:when>
                                                                <c:when test="${count == 6}">
                                                                    <c:set var="count" value="0"  />
                                                                    <li class="last-in-line   col-sm-2">
                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${nonbook.productNumber}" />&category=<c:out value="${nonbook.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${nonbook.imagepath}" />" alt="<c:out value="${nonbook.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${nonbook.productNumber}" />&category=<c:out value="${nonbook.category}"/>"><c:out value="${nonbook.title}" /></a></div>
                                                                                <div class="description"><c:out value="${nonbook.description}..." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${nonbook.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>
                                                                    </li>

                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:set var="vale" value="${val - 1}" />

                                                                    <li class="col-sm-2">

                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${nonbook.productNumber}" />&category=<c:out value="${nonbook.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${nonbook.imagepath}" />" alt="<c:out value="${nonbook.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="<c:out value="/UniqueBookApp/book?action=show&productNo${nonbook.productNumber}" />&category=<c:out value="${nonbook.category}"/>"><c:out value="${nonbook.title}" /></a></div>
                                                                                <div class="description"><c:out value="${nonbook.description}...." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${nonbook.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>

                                                                    </li>
                                                                </c:otherwise>
                                                            </c:choose>


                                                        </c:forEach>

                                                    </ul>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div class="box featured">
                                            <c:if  test="${cat == 2}">           

                                                <div class="breadcrumb">   Kids Book >><i><c:out value="${category}"/></i>
                                                </div> </c:if>

                                                <div class="box-content">
                                                    <div class="box-product">
                                                    <c:set var="count" value="0" scope="page" />
                                                    <ul class="row">
                                                        <c:forEach items="${kidbooks}" var="kidbook">
                                                            <c:set var="count" value="${count + 1}" />
                                                            <c:choose>
                                                                <c:when test="${count == '1'}">
                                                                    <c:set var="val" value="11"  />

                                                                    <li class="first-in-line  col-sm-2">
                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${kidbook.productNumber}" />&category=<c:out value="${kidbook.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${kidbook.imagepath}" />" alt="<c:out value="${kidbook.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${kidbook.productNumber}" />&category=<c:out value="${kidbook.category}"/>"><c:out value="${kidbook.title}" /></a></div>
                                                                                <div class="description"><c:out value="${kidbook.description}..." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${kidbook.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>
                                                                    </li>
                                                                </c:when>
                                                                <c:when test="${count == 6}">
                                                                    <c:set var="count" value="0"  />
                                                                    <li class="last-in-line   col-sm-2">
                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${kidbook.productNumber}" />&category=<c:out value="${kidbook.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${kidbook.imagepath}" />" alt="<c:out value="${kidbook.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${kidbook.productNumber}" />&category=<c:out value="${kidbook.category}"/>"><c:out value="${kidbook.title}" /></a></div>
                                                                                <div class="description"><c:out value="${kidbook.description}..." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${kidbook.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>
                                                                    </li>

                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:set var="vale" value="${val - 1}" />

                                                                    <li class="col-sm-2">

                                                                        <div class="image2">
                                                                            <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${kidbook.productNumber}" />&category=<c:out value="${kidbook.category}"/>">

                                                                                <img id="img_49" src="<c:out value="${kidbook.imagepath}" />" alt="<c:out value="${kidbook.title}" />">
                                                                            </a>
                                                                        </div>

                                                                        <div class="inner">
                                                                            <div class="f-left maxheight-feat" style="height: 86px;">
                                                                                <div class="name "><a href="<c:out value="/UniqueBookApp/book?action=show&productNo=${kidbook.productNumber}" />&category=<c:out value="${kidbook.category}"/>"><c:out value="${kidbook.title}" /></a></div>
                                                                                <div class="description"><c:out value="${kidbook.description}...." /></div>
                                                                            </div>
                                                                            <div class="cart-button">
                                                                                <div class="price">
                                                                                    <c:out value="${kidbook.price}" />$
                                                                                </div>
                                                                                <div class="cart"><a title="" data-id="49;" class="button addToCart tooltip-1" data-original-title="Add to cart"><i class="fa fa-shopping-cart"></i><span>Add to cart</span></a></div>
                                                                                <span class="clear"></span>
                                                                            </div>

                                                                            <div class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"><div class="clear"></div></div>

                                                                    </li>
                                                                </c:otherwise>
                                                            </c:choose>


                                                        </c:forEach>

                                                    </ul>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <script type="text/javascript">
                                            if ($('.container').width() > 723) {
                                                (function ($) {
                                                    $.fn.equalHeights = function (minHeight, maxHeight) {
                                                        tallest = (minHeight) ? minHeight : 0;
                                                        this.each(function () {
                                                            if ($(this).height() > tallest) {
                                                                tallest = $(this).height()
                                                            }
                                                        });
                                                        if ((maxHeight) && tallest > maxHeight)
                                                            tallest = maxHeight;
                                                        return this.each(function () {
                                                            $(this).height(tallest)
                                                        })
                                                    }
                                                })(jQuery)
                                                $(window).load(function () {
                                                    if ($(".maxheight-spec").length) {
                                                        $(".maxheight-spec").equalHeights()
                                                    }
                                                });
                                            }
                                            ;
                                        </script>

                                    </div>
                                    <h1 style="display: none;">Unique book store</h1>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                </div>
                <div class="clear"></div>
                </section>
                <jsp:include page="includesPages/_footer.jsp"></jsp:include>

            </div>
        </div>
    </div>
</body>
</html>
