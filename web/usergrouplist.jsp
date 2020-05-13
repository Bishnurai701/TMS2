<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 10-05-2020
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List" %>
<%@page import="com.tms.model.UserGroup" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin | TMS UserGroup List</title>
    <style type="text/css">
        <%@include file="bootstrap/css/bootstrap.css" %>
        <%@include file="bootstrap/css/bootstrap.min.css" %>
        <%@include file="bootstrap/css/hover-min.css" %>
        <%@include file="bootstrap/css/stylesheet.css" %>
    </style>

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/stylesheet.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/hover.css" />
    <link rel="stylesheet" type="text/css" href="Hover-master/css/hover-min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/sweetalert.css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>


    <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"/>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js" />
    <script type="text/javascript" src="bootstrap/js/sweetalert.min.js"/>
    <script>
        CKEDITOR.replace( 'editor1' );
    </script>

</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home"></span> TMS<small> | Time Management System</small></a>
        </div>


        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#"> Dashboard</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-bell"></span>  Profile</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-question-sign"></span>  Help</a></li>
            </ul>
            <form class="navbar-form navbar-right" id="search">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav><!--Header part-->
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="index.jsp" class="main-color-bg"> <span class="glyphicon glyphicon-th-large"></span> Dashbaord <span class="sr-only">(current)</span></a></li>
                <li><a href="userlist.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View Users</a></li>
                <li><a href="userform.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View Users</a></li>
                <li><a href="#"> <span class="glyphicon glyphicon-paperclip"></span>  Export</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item</a></li>
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
                <li><a href="">More navigation</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
            </ul>
        </div><!--Sidebar end-->

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-md-4 col-xs-4">
                    <div class="page-heading">
                        <h3 style="color:#0269A4">
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / UserGroup List
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="ConfigurationDashBoard.jsp">Configuration</a> <span class="divider"></span></li>
                        <li class="active"><a href="usergrouplist.jsp">UserGroupList</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>


            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">
                <!--<div class="alert alert-success" >{{message}}</div>-->
                <div class="row">
                    <div class="form-group" style="color:#0269A4">
                        <label class="col-md-12   control-label">
                            <h3> List of UserGroup </h3>
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label class="col-md-1 control-label">
                            <a href="<%=request.getContextPath()%>/newgroup" class="btn btn-success">Add New UseGroup</a>
                        </label>
                    </div>
                </div>
                <hr>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>UserGroup Name</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="usergroup" items="${listUserGroup}">
                        <tr>
                            <td><c:out value="${usergroup.UserGroup_id}" /></td>
                            <td><c:out value="${usergroup.UserGroupName}" /></td>

                            <td>
                                <a href="edit?UserGroup_id=<c:out value='${usergroup.UserGroup_id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?UserGroup_id=<c:out value='${usergroup.UserGroup_id}' />">Delete</a>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
