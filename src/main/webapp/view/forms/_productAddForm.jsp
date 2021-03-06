<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        Add New Product      <b style="color: red">${message}</b> <h1><b style="color: lawngreen">${goodmessage}</b></h1>

    </div>

    <!-- /.panel-heading -->
    <div class="panel-body">
        <div class="col-lg-6">
            <form role="form" action="addProduct" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label>Title:</label>
                    <input class="form-control" name="title" type="text" value="${book.title}">
                    <c:if test="${update == true }">
                        <input type="hidden" name="productNumber" value="${book.productNumber}">

                    </c:if>
                        <c:if test="${update == false }">
                        <input type="hidden" name="productNumber" value="0">

                    </c:if>
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Price:</label>
                    <input class="form-control" name="productPrice" type="text" value="${book.price}">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>ISBN:</label>
                    <input class="form-control" name="bookISBN" type="text" value="${book.isbn}">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Book Revision No:</label>
                    <input class="form-control" name="bookRevisionNo" type="text" value="${book.revisionNo}">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input class="form-control" name="quantity" type="number" value="${book.quantity}" >
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Publisher:</label>
                    <input class="form-control" name="publisher" type="text" value="${book.publisher}">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Published Year:</label> 
                    <input class="form-control" name="PublishedYear" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${book.publishedYear}"/>">
                    <p class="help-block">eg. 2005-01-01</p>
                </div>

                <div class="form-group">
                    <label>Author:</label>
                    <input class="form-control" name="author" value="${book.author}">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                    <label>Image:</label>
                    <input type="file" name="imagePath">
                    <c:if test="${update == true }">
                        <input type="text" name="imagepath" disabled="disabled" value="${book.imagepath}" size="70" > 
                        <input type="hidden" name="imagepath"  value="${book.imagepath}" >                         
                        
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Product description</label>
                    <textarea class="form-control" rows="3" name="productDetail">${book.description}</textarea>
                </div>

                <div class="form-group">
                    <label>category</label>
                    <select class="form-control" name="maincategory" id="maincategory">
                        <option value="kids">Kids book</option>
                        <option value="fictional">fictional</option>
                        <option value="nonfictioanl">nonfictional</option>
                    </select>
                </div>
                <div class="fictional box form-group">
                    <label>Sub category</label>
                    <select class="form-control" name="fiction" id="fictional">
                        <c:forEach items="${fictionalCategory}" var="fiction">
                            <option value="${book.category}" selected="selected">${book.category}</option>
                            <option value="${fiction.name}">${fiction.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="nonfictioanl box form-group">
                    <label>Sub category</label>
                    <select class="form-control" name="nonfiction" id="nonfictional">
                        <c:forEach items="${nonfictionCategory}" var="nonfiction">
                            <option value="${book.category}" selected="selected">${book.category}</option>
                            <option value="${nonfiction.name}">${nonfiction.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="kids  box form-group">
                    <label>Sub category</label>
                    <select class="form-control" name="kidbook" id="kidsbook">
                        <c:forEach items="${kidsCategory}" var="kidsbook">

                            <option value="${book.category}" selected="selected">${book.category}</option>
                            <option value="${kidsbook.name}">${kidsbook.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Submit Button</button>
                <button type="reset" class="btn btn-default">Reset Button</button>
            </form>
        </div>

    </div>
</div>
