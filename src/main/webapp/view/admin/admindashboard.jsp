<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html dir="ltr" lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Unique Book shop</title>

        <!-- Bootstrap Core CSS -->
        <link href="./css/bootstrap.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="./css/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="./css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="./css/font-awesome.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Unique Bookshop Admin</a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>
                            <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li>
                                <a href="/dashboard?action=showProfile">
                                    <i class="fa fa-user fa-fw"></i>
                                    User Profile</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <c:url var="urllogout" value="/admin?action=logout"></c:url>
                                <a href="${urllogout}">
                                    <i class="fa fa-sign-out fa-fw"></i>
                                    Logout</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">

                            <c:url var="url" value="/admin"></c:url>
                                <li class="active">
                                    <a href="${url}">
                                    <i class="fa fa-dashboard fa-fw"></i>
                                    Dashboard</a>
                            </li>

                            <li>
                                <c:url var="pendingurl" value="/dashboard?action=pendingOrder"></c:url>
                                <a href="${pendingurl}">
                                    <i class="fa fa-shopping-cart fa-fw"></i>Pending Orders</a>
                            </li>
                            <li>
                                <c:url var="approvedorder" value="/dashboard?action=approvedOrder"></c:url>
                                <a href="${approvedorder}">
                                    <i class="fa fa-check fa-fw"></i>Approved Orders</a>
                            </li>
                            <li>
                                <c:url var="deliveredOrder" value="/dashboard?action=deliveredOrder"></c:url>
                                <a href="${deliveredOrder}">
                                    <i class="fa fa-truck fa-fw"></i>Delivered Orders</a>
                            </li>
                            <li>
                                <c:url var="listCustomers" value="/dashboard?action=listcustomers"></c:url>
                                <a href="${listCustomers}">
                                    <i class="fa fa-user fa-fw"></i>Customers</a>
                            </li>
                            <li>
                                <c:url var="listmanagers" value="/dashboard?action=listmanagers"></c:url>
                                <a href="${listmanagers}">
                                    <i class="fa fa-user fa-fw"></i>Admins</a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-sitemap fa-list-alt"></i>
                                    Manage Product<span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="/UniqueBookApp/dashboard?action=listProduct">
                                            <i class="fa fa-table fa-fw"></i>Products List</a>
                                    </li>
                                    <li>
                                        <a href="/UniqueBookApp/dashboard?action=addProducts">
                                            <i class="fa fa-edit fa-fw"></i>Add product</a>
                                    </li>

                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">

                    <div class="row">
                        <c:if test="${empty type}">
                            <div class="col-lg-12">
                                <h1 class="page-header">
                                    Dashboard</h1>
                                <div class="row">
                                    <div class="col-lg-3 col-md-6">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading">
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                                    </div>
                                                    <div class="col-xs-9 text-right">
                                                        <div class="huge">${orderNumber}</div>
                                                        <div>New Orders!</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="/UniqueBookApp/dashboard?action=pendingOrder">
                                                <div class="panel-footer">
                                                    <span class="pull-left">View Details</span>
                                                    <span class="pull-right">
                                                        <i class="fa fa-arrow-circle-right"></i>
                                                    </span>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6">
                                        <div class="panel panel-green">
                                            <div class="panel-heading">
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <i class="fa fa-users fa-5x"></i>
                                                    </div>
                                                    <div class="col-xs-9 text-right">
                                                        <div class="huge">${customersNumber}</div>
                                                        <div>Customers</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="/UniqueBookApp/dashboard?action=listcustomers">
                                                <div class="panel-footer">
                                                    <span class="pull-left">View Details</span>
                                                    <span class="pull-right">
                                                        <i class="fa fa-arrow-circle-right"></i>
                                                    </span>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6">
                                        <div class="panel panel-yellow">
                                            <div class="panel-heading">
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <i class="fa fa-list-alt fa-5x"></i>
                                                    </div>
                                                    <div class="col-xs-9 text-right">
                                                        <div class="huge">${productNumber}</div>
                                                        <div>Products!</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="/UniqueBookApp/dashboard?action=listProduct">
                                                <div class="panel-footer">
                                                    <span class="pull-left">View Details</span>
                                                    <span class="pull-right">
                                                        <i class="fa fa-arrow-circle-right"></i>
                                                    </span>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6">
                                        <div class="panel panel-red">
                                            <div class="panel-heading">
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <i class="fa fa-briefcase fa-users fa-5x"></i>
                                                    </div>
                                                    <div class="col-xs-9 text-right">
                                                        <div class="huge">${productNumber}</div>
                                                        <div>Products!</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="/UniqueBookApp/dashboard?action=listmanagers">
                                                <div class="panel-footer">
                                                    <span class="pull-left">View Details</span>
                                                    <span class="pull-right">
                                                        <i class="fa fa-arrow-circle-right"></i>
                                                    </span>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <!-- /.row -->
                        <div class="col-lg-16">
                            <c:if test="${type == 'pending' }">
                                <jsp:include page="_orderTables.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'approved' }">
                                <jsp:include page="_orderTables.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'delivered' }">
                                <jsp:include page="_orderTables.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'customer' }">
                                <jsp:include page="_customerTable.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'products' }">
                                <jsp:include page="_productListTable.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'Addproducts' }">
                                <jsp:include page="${path}"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'Customeredit' }">
                                <jsp:include page="../forms/_customerAddAdminForm.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'createCustomer' }">
                                <jsp:include page="../forms/_customerAddAdminForm.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'updateOrder' }">
                                <jsp:include page="../forms/_orderStatusUpdate.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'admin' }">
                                <jsp:include page="_managerTable.jsp"></jsp:include>
                            </c:if>
                            <c:if test="${type == 'createManger' }">
                                <jsp:include page="../forms/_adminAddForm.jsp"></jsp:include>
                            </c:if>
                        </div>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="./javascript/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="./javascript/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="./javascript/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="./javascript/sb-admin-2.js"></script>
        <script src="./javascript/bootstrap.js"></script>
        <script type="text/javascript" src="./javascript/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="./javascript/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="./javascript/dataTables.responsive.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-customerOrder').DataTable({responsive: true});
                $("#maincategory").change(function () {
                    $(this).find("option:selected").each(function () {
                        var optionValue = $(this).attr("value");
                        if (optionValue) {
                            $(".box").not("." + optionValue).hide();
                            $("." + optionValue).show();
                        } else {
                            $(".box").hide();
                        }
                    });
                }).change();

            });
        </script>
    </body>

</html>
