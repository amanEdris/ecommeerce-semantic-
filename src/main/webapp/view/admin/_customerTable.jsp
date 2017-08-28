<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        Customers   List
    </div>
    <!-- /.panel-heading -->
    <div class="panel-body">



        <table width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
             <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                    <th>Phone</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>City</th>
                    <th>Country</th>
                    <th>Address</th>
                    <th>Postal code</th>
            </tr>
            </thead>
            <tbody>
              <c:forEach var="customer" items="${customers}">
                 <c:set var="location" value="${customer.location}"/>
                  <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.firstName} </td>
                    <td>${customer.lastName}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.password}</td>
                    <td>${customer.email}</td>
                    <td>${location.city}</td>
                    <td>${location.country}</td>
                    <td>${location.address}</td>
                    <td>${location.postalCode}</td>
                  </tr>
              </c:forEach>
            </tbody>
        </table>
    </div>
</div>
