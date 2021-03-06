<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        ${type} Orders
    </div>
    <!-- /.panel-heading -->
    <div class="panel-body">

        <table width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
                <tr>
                    <th>Order Number</th>
                    <th>Item</th>
                    <th>Quantity
                        <i class="fa fa-times"></i>
                        price</th>
                    <th>Customer</th>
                    <th>order Status</th>
                    <th>Delivery Address</th>
                    <th>Delivery Date</th>
                    <th>Total price</th>
                    <th>.</th>
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
                                        ${product.price}
                                        <i class="fa fa-times"></i>
                                        ${sale.productQuantity}</li>
                                    </c:forEach>
                            </ol>
                        </td>
                        <c:set var="customer" value="${order.cusotmer}"/>
                        <td>
                            <i class="fa fa-key">
                                Customer ID:${customer.customerId}</i><br/>
                            <i class="fa fa-user">
                                ${customer.firstName} ${customer.lastName}</i><br/>
                            <i class="fa fa-envelope-o">
                                ${customer.email}
                            </i>
                            <br/>
                            <i class="fa fa-phone">
                                ${customer.phone}
                            </i>
                        </td>
                        <td>${order.orderStatus}</td>
                        <c:set var="delivery" value="${order.delivery}"/>
                        <c:set var="location" value="${delivery.location}"/>
                        <td>
                            <i class="fa fa-globe">
                                ${location.city}<br/>
                                ${location.country}<br/>
                                ${location.address}<br/>
                                ${location.postalCode}
                            </i>
                        </td>
                        <td>
                            <fmt:formatDate pattern="yyyy-MMM-dd" value="${delivery.deliveryDate}"/>

                        </td>
                        <td>
                            ${order.totalPrice}
                        </td>
                        <td>
                                <a href="/UniqueBookApp/dashboard?action=editOrder&orderNumber=${order.orderNumber}&orderStatus=${order.orderStatus}"  >
                                    <i class="fa fa-edit fa-2x"></i>
                                </a>
                            <br>
                            <c:if test="${type == 'pending' }">
                                <a href="/UniqueBookApp/dashboard?action=deleteOrder&orderNumber=${order.orderNumber}">
                                    <i class="fa fa-trash-o-o  fa-2x"></i>
                                </a>
                            </c:if>

                        </td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>

    </div>
</div>
