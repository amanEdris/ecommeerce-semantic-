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
                    <th>Postal code</th>    
            </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
    </div>
</div>
