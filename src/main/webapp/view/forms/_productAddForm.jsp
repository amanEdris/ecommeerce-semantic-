<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
  <div class="panel-heading">
    Add New Product
  </div>
  <!-- /.panel-heading -->
  <div class="panel-body">
    <div class="col-lg-6">
      <form role="form" action="addProduct">
        <div class="form-group">
          <label>Product Name:</label>
          <input class="form-control" name="productName" type="text">
            <!-- <p class="help-block">Example block-level help text here.</p>-->
          </div>
          <div class="form-group">
            <label>Product price:</label>
            <input class="form-control" name="productPrice" type="text">
              <!-- <p class="help-block">Example block-level help text here.</p>-->
            </div>
            <div class="form-group">
              <label>ISBN:</label>
              <input class="form-control" name="bookISBN" type="text">
                <!-- <p class="help-block">Example block-level help text here.</p>-->
              </div>
              <div class="form-group">
                <label>Book Revision No:</label>
                <input class="form-control" name="bookRevisionNo" type="text">
                  <!-- <p class="help-block">Example block-level help text here.</p>-->
                </div>
                <div class="form-group">
                  <label>Quantity</label>
                  <input class="form-control" name="quantity" type="number">
                    <!-- <p class="help-block">Example block-level help text here.</p>-->
                  </div>
                  <div class="form-group">
                    <label>Publisher:</label>
                    <input class="form-control" name="publisher" type="text">
                      <!-- <p class="help-block">Example block-level help text here.</p>-->
                    </div>
                    <div class="form-group">
                      <label>Publisher:</label>
                      <input class="form-control" name="publisher" type="text">
                        <!-- <p class="help-block">Example block-level help text here.</p>-->
                      </div>
                      <div class="form-group">
                        <label>Published Year:</label>
                        <input class="form-control" name="PublishedYear" type="year">
                          <!-- <p class="help-block">Example block-level help text here.</p>-->
                        </div>
                        <div class="form-group">
                          <label>Title:</label>
                          <input class="form-control" name="title" type="text">
                            <!-- <p class="help-block">Example block-level help text here.</p>-->
                          </div>
                          <div class="form-group">
                            <label>Author:</label>
                            <input class="form-control" name="author">
                              <!-- <p class="help-block">Example block-level help text here.</p>-->
                            </div>
                            <div class="form-group">
                              <label>Image:</label>
                              <input type="file" name="imagePath"></div>
                              <div class="form-group">
                                <label>Product description</label>
                                <textarea class="form-control" rows="3" name="productDetail" type="text"></textarea>
                              </div>

                              <div class="form-group">
                                <label>category</label>
                                <select class="form-control" name="maincategory">
                                  <option value="kids">Kids book</option>
                                  <option value="fictional">fictional</option>
                                  <option value="nonfictioanl">nonfictional</option>
                                </select>
                              </div>
                              <div class="form-group">
                                <label>Sub category</label>
                                <select class="form-control" name="category" id="fictional">
                                  <c:forEach items="${fictionalCategory}" var="fiction">
                                    <option value="${fiction.name}">${fiction.name}</option>
                                  </c:forEach>
                                </select>
                              </div>
                              <div class="form-group">
                                <label>Sub category</label>
                                <select class="form-control" name="category" id="nonfictional">
                                  <c:forEach items="${nonfictionCategory}" var="nonfiction">
                                    <option value="${nonfiction.name}">${nonfiction.name}</option>
                                  </c:forEach>
                                </select>
                              </div>
                              <div class="form-group">
                                <label>Sub category</label>
                                <select class="form-control" name="category" id="kidsbook">
                                  <c:forEach items="${kidsCategory}" var="kidsbook">
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
