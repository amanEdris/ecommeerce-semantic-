<%-- 
    Document   : cart
    Created on : Aug 15, 2017, 4:06:29 PM
    Author     : edris
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Your shopping cart contains ${cart.numberOfItems} items.</p>
        <table>
            <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
                <c:set var="product" value="${cartItem.product}"/>
                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                    <td>
                        <img src="${product.imagepath}"
                             alt="${product.productName}">
                    </td>
                    <td>${product.productName}</td>
                    <td>
                        &euro; ${cartItem.total}
                        <br>
                        <span class="smallText">( &euro; ${product.price} )</span>
                    </td>
                    ... </tr>
                </c:forEach>
        </table>
    </body>
</html>
