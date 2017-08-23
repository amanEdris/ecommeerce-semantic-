
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="header">
    <div class="top-line">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="toprow">
                        <ul class="links">

                            <li class="first"><a class="active" href="/UniqueBookApp"><i class="fa fa-home"></i>Home</a></li>
                            <c:if  test="${!empty User}">
                               <li><a class="" href="/UniqueBookApp/account?action=edit&data=show"><i class="fa fa-user"></i>My Account</a></li>
                            </c:if>
                            
                            <li><a class="" href="/UniqueBookApp/viewCart"><i class="fa fa-shopping-cart"></i>Shopping Cart</a></li>
                            <c:if  test="${!empty cart}">
                                <li><a class="" href="/UniqueBookApp/order?action=checkout"><i class="fa fa-check"></i>Checkout</a></li>
                            </c:if> 
                            <c:if  test="${empty User}">
                             <li><a href="/UniqueBookApp/account?action=edit"><i class="fa fa-user"></i>Create an account</a></li>
                             <li class="login_h last"> <a href="/UniqueBookApp/account?action=login&type=show"><i class="fa fa-lock"></i>Login</a></li>
                            </c:if>
                            <c:if  test="${!empty User}">
                            <li class="login_h last"> <a href="/UniqueBookApp/account?action=logout"><i class="fa fa-lock"></i>Logout</a> <i>${User.lastName}</i></li>
                            </c:if>
                        </ul>
                        <div class="clear"></div>
                    </div>
                    <div class="cart-position">
                        <div class="cart-inner"><div id="cart">
                                <div class="heading">
                                    <span class="link_a">
                                        <i class="fa fa-shopping-cart"></i>
                                        <b>Cart:</b>
                                        <span class="sc-button"></span>
                                        <c:if test="${empty cart}">
                                            <span id="cart-total">0 item(s) 0.00$</span>
                                        </c:if>          
                                        <c:if test="${!empty cart}">
                                            <span id="cart-total">
                                                ${cart.numberOfItems} item(s) ${cart.total} $
                                            </span>
                                        </c:if>

                                        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">   
                                            <c:set var="product" value="${cartItem.product}"/>
                                        </c:forEach>
                                        <i class="fa fa-angle-down"></i>
                                        <span class="clear"></span>
                                    </span>
                                </div>

                                <div class="content">
                                    <div class="content-scroll">
                                        <c:if test="${empty cart}"> 
                                            <div class="empty">Your shopping cart is empty!</div> 
                                        </c:if>
                                        <div class="mini-cart-info">  
                                            <table class="cart">
                                                <tbody>
                                                    <c:forEach var="cartItem" items="${cart.items}" varStatus="iter"> 
                                                        <c:set var="product" value="${cartItem.product}"/>


                                                        <tr class="first">
                                                            <td class="image">	
                                                                <a href="/UniqueBookApp/book?action=show&productNo=<c:out value="${product.productNumber}" />&category=<c:out value="${category}"/>">
                                                                    <img src="${product.imagepath}" alt="${product.productName}" title="${product.productName}">
                                                                </a>
                                                            </td>
                                                            <td class="name"><a href="">${product.productName}</a>
                                                                <div>
                                                                </div>
                                                                <span class="quantity">${cartItem.quantity}</span>item
                                                                <span class="total">subtotal:${cartItem.total}</span>

                                                            </td>

                                                        </tr>
                                                    </c:forEach>    
                                                </tbody>
                                            </table>
                                            <c:if test="${empty cart}">
                                                total: ${cart.total} 
                                            </c:if>
                                        </div>  
                                            
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="top_color">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">

                    <div id="logo"><a href="#home"><img src="./image/logo-copy.png" title="RealBooks" alt="Uniquebooks"></a></div>

                    <div id="search">
                        <div class="inner">
                            <div class="button-search">
                                <i class="fa fa-search"></i>
                                <span>Search</span>
                            </div>
                            <input type="text" name="search" placeholder="" value="">
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="toprow-1">
                    <a class="swipe-control" href="#test"><i class="fa fa-align-justify"></i></a>
                    <div class="top-search">
                        <i class="fa fa-search"></i>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">

                <div id="menu-gadget">
                    <div id="menu-icon">Categories</div>
                    <ul id="nav" class="sf-menu-phone">
                        <li class="parent"><a href="/UniqueBookApp/book?action=listBooks&category=Fiction">Fiction</a>
                            <ul>
                                <li>
                                    <a href="/UniqueBookApp/book?action=listBooks&category=Comics">Comics</a>
                                </li>
                                <li class="parent">
                                    <a href="/UniqueBookApp/book?action=listBooks&category=Graphical Novel">Graphical Novel</a>
                                    <ul>
                                        <li>
                                            <a href="/UniqueBookApp/book?action=listBooks&category=Literature">Literature</a>
                                        </li>
                                        <li>
                                            <a href="/UniqueBookApp/book?action=listBooks&category=Poetry">Poetry </a>
                                        </li>
                                        <li>
                                            <a href="/UniqueBookApp/book?action=listBooks&category=Romance">Romance </a>
                                        </li>
                                    </ul>
                                    <i class="fa fa-angle-down"></i><i class="fa fa-angle-down"></i></li>
                                <li><a href="/UniqueBookApp/book?action=listBooks&category=Kids Book">Kids Book</a>
                                </li>
                                <li><a href="/book?action=listBooks&category=Biography">Biography</a>
                                </li>
                                <li><a href="/UniqueBookApp/book?action=listBooks&category=Health Fitness">Health Fitness</a>
                                </li>
                                <li><a href="/UniqueBookApp/book?action=listBooks&category=Cook Books">Cook Books</a>
                                </li>
                                <li><a href="/UniqueBookApp/book?action=listBooks&category=Religion">Religion</a>
                                </li>
                            </ul>
                            </div>

                            <div id="menu" class="">

                                <ul class="sf-menu">
                                    <li class="cat_1">
                                        <a href="/UniqueBookApp/book?action=listBooks&category=Fiction" class="">Fiction</a>
                                        <div class="sf-mega" style="display: none;">
                                            <ul class="sf-mega-section">
                                                <li>
                                                    <a class="screenshot1" href="/UniqueBookApp/book?action=listBooks&category=Graphical Novel">Graphical Novel</a>
                                                </li>
                                                <li>
                                                    <a class="screenshot1" href="/UniqueBookApp/book?action=listBooks&category=Comics">Comics</a>
                                                </li>
                                                <li>
                                                    <a class="screenshot1" href="/UniqueBookApp/book?action=listBooks&category=Poetry">Poetry</a>
                                                </li>
                                                <li>
                                                    <a class="screenshot1" href="/UniqueBookApp/book?action=listBooks&category=Romance">Romance</a>
                                                </li>
                                                <li>
                                                    <a class="screenshot1" href="/UniqueBookApp/book?action=listBooks&category=Literature">Literature</a>
                                                </li>

                                            </ul>
                                        </div>
                                    </li>
                                    <li class="cat_2">
                                        <a href="/UniqueBookApp/book?action=listBooks&category=Poetry">Poetry</a>
                                    </li>
                                    <li class="cat_3">
                                        <a href="/UniqueBookApp/book?action=listBooks&category=Health Fitness">Health &amp; Fitness</a>
                                    </li>
                                    <li class="cat_4">
                                        <a href="/UniqueBookApp/book?action=listBooks&category=History">History</a>
                                    </li>
                                    <li class="cat_5">
                                        <a href="/UniqueBookApp/book?action=listBooks&category=Mistry">Mystery</a>
                                    </li>
                                    <li class="cat_6">
                                        <a href="/UniqueBookApp/book?action=listBooks&Politics &amp; Current Affairs">Politics &amp; Current Affairs</a>
                                    </li>
                                    <li class="cat_7">
                                        <a href="/UniqueBookApp/book?action=listBooks&Religion">Religion</a>
                                    </li>
                                    <li class="cat_8">
                                        <a href="/UniqueBookApp/book?action=listBooks&category=Kids Book">Kids Book</a>
                                    </li>
                                </ul>

                                <div class="clear"></div>

                            </div>

                            </div>
                            </div>
                            </div>

                            </header>
