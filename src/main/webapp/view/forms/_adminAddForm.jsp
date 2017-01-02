<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default">
  <div class="panel-heading">
    Edit/Add admin data
  </div>
  <!-- /.panel-heading -->
  <div class="panel-body">
<div class="col-lg-6">
<c:if  test="${empty User}">
    <b style="color: red">${message}</b> <h1><b style="color: lawngreen">${goodmessage}</b></h1>
    <form class="form-horizontal" action="addManager" method="post"  id="register" role="form">
    </c:if>
    <c:if  test="${!empty User}">
        <form class="form-horizontal" action="updateManager" method="post"  id="register" role="form">  
        </c:if>
        
        
            <div class="form-group">
                <label>* First Name:</label>
                <input class="form-control" type="text" name="firstname" value="${User.firstName}">
            </div>

            <div class="form-group">
                <label>* Last Name:</label>
                <input class="form-control" type="text" name="lastname" value="${User.lastName}">
            </div>

            <div class="form-group"><!--if gender male or female select-->
                <label>* Gender</label>
                <c:set var="malechecked" value="" scope="page" />
                <c:if test="${User.gender =='male' && !empty User.gender}">                                
                    <c:set var="malechecked" value='checked="checked"' scope="page" />
                </c:if> 
                <div class="radio"><label>
                        <input id="optionsRadios1" type="radio" name="male" value="male" ${malechecked} />  Male</label> </div>
                        <c:set var="femalechecked" value="" scope="page" />
                        <c:if test="${User.gender =='female' && !empty User.gender}">
                            <c:set var="femalechecked" value='checked="checked"'  scope="page" />
                        </c:if>
                <div class="radio"><label> <input id="optionsRadios2" type="radio" name="male" value="female" ${femalechecked}/>
                        Female </label> </div>
            </div>


            <div class="form-group">
                <label>* E-Mail:</label>
                <input class="form-control" type="email" name="email" value="${User.email}">
            </div>

            <div class="form-group">
                <label>* Telephone:</label>
                <input class="form-control" type="text" name="telephone" value="${User.phone}">
            </div>
            <div class="form-group">
                <label>*Password:</label>
                <input class="form-control" type="password" name="password" value="${User.password}">
            </div>

            <div class="form-group">
                <label>* Password Confirm:</label>
                <input class="form-control" type="password" name="confirm" value="${User.password}">
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
            