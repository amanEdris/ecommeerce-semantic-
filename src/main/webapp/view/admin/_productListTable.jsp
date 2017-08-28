<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        Products   List
    </div>
    <!-- /.panel-heading -->
    <div class="panel-body">
        <table width="100%" aria-describedby="dataTables-example_info" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-customerOrder" role="grid">
            <thead>
             <tr>
                    <th>Product Number</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Author</th>
                    <th>ISBN</th>
                    <th>Image path</th>
                    <th>Published Year</th>
                    <th>Publisher</th>
                    <th>Category</th>
                    <th>Revision</th>
            </tr>
            </thead>

            <tbody>
              <c:forEach var="fictionalbook" items="${fictional}">
                <tr>
                    <td>${fictionalbook.productNumber}</td>
                    <td>${fictionalbook.title}</td>
                    <td>${fictionalbook.description}</td>
                    <td>${fictionalbook.price}</td>
                    <td>${fictionalbook.quantity}</td>
                    <td>${fictionalbook.author}</td>
                    <td>${fictionalbook.isbn}</td>
                    <td>${fictionalbook.imagepath}</td>
                    <td> <fmt:formatDate pattern="yyyy-MMM-dd" value="${fictionalbook.publishedYear}"/></td>
                    <td>${fictionalbook.publisher}</td>
                    <td>${fictionalbook.category}</td>
                    <td> </td>
                </tr>
              </c:forEach>
              <c:forEach var="nonfiction" items="${nonfiction}">
                <tr>
                    <td>${nonfiction.productNumber}</td>
                    <td>${nonfiction.title}</td>
                    <td>${nonfiction.description}</td>
                    <td>${nonfiction.price}</td>
                    <td>${nonfiction.quantity}</td>
                    <td>${nonfiction.author}</td>
                    <td>${nonfiction.isbn}</td>
                    <td>${nonfiction.imagepath}</td>
                    <td>  <fmt:formatDate pattern="yyyy-MMM-dd" value="${nonfiction.publishedYear}"/></td>
                    <td>${nonfiction.publisher}</td>
                    <td>${nonfiction.category}</td>
                    <td> </td>
                </tr>
              </c:forEach>
              <c:forEach var="kidbooks" items="${kidbooks}">
                <tr>
                    <td>${kidbooks.productNumber}</td>
                    <td>${kidbooks.title}</td>
                    <td>${kidbooks.description}</td>
                    <td>${kidbooks.price}</td>
                    <td>${kidbooks.quantity}</td>
                    <td>${kidbooks.author}</td>
                    <td>${kidbooks.isbn}</td>
                    <td>${kidbooks.imagepath}</td>
                    <td>  <fmt:formatDate pattern="yyyy-MMM-dd" value="${kidbooks.publishedYear}"/></td>
                    <td>${kidbooks.publisher}</td>
                    <td>${kidbooks.category}</td>
                    <td> </td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
    </div>
</div>
