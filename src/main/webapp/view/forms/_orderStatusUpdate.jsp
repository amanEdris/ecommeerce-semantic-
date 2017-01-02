<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default">
    <div class="panel-heading">
        Update Order status 
    </div>
    <!-- /.panel-heading -->
    <div class="panel-body">
        <div class="col-lg-6">
            <b style="color: red">${message}</b> <h1><b style="color: lawngreen">${goodmessage}</b></h1>
            <form class="form-horizontal" action="updateOrder" method="post"  id="register" role="form">
                <div class="form-group">
                    <label>Order status</label>
                    <input type="hidden" name="orderNumber" value="${orderNumber}">
                    <input type="hidden" name="previousOrderstatus" value="${orderstatus}">
                    <select name="orderstatus">
                        <option value="${orderstatus}"  selected="selected">${orderstatus}</option>
                        <c:forEach items="${ordersStatus}" var="oderstatus">
                            <option value="${oderstatus.name}">${oderstatus.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="buttons">
                    <div class="right">
                        <input type="submit" value="Submit" class="buttons"/>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
