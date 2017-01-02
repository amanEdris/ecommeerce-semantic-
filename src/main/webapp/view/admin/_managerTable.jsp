<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        Customers   List       <span class="btn-block"> <a href="/UniqueBookApp/dashboard?action=AddManager">[Add Admin]</a></span>
    </div>
    <!-- /.panel-heading -->
    <div class="panel-body">



        <table width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                    <th>Phone</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>.</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="manager" items="${managers}">
                    <tr>
                        <td>${manager.firstName} </td>
                        <td>${manager.lastName}</td>
                        <td>${manager.gender}</td>
                        <td>${manager.phone}</td>
                        <td>${manager.password}</td>
                        <td>${manager.email}</td>
                        <td>
                            <a href="/UniqueBookApp/dashboard?action=editManager&email=${manager.email}">
                                <i class="fa fa-edit fa-2x"></i> </a>
                            <br>
                            <a href="/UniqueBookApp/dashboard?action=deleteManager&email=${manager.email}">
                                <i class="fa fa-trash-o-o  fa-2x"></i> </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
