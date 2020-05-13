<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 24-04-2020
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin | TMS Add User </title>

    <style type="text/css">
        <%@include file="bootstrap/css/bootstrap.css" %>
        <%@include file="bootstrap/css/bootstrap.min.css" %>
        <%@include file="bootstrap/css/hover-min.css" %>
        <%@include file="bootstrap/css/stylesheet.css" %>
    </style>



    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/stylesheet.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/hover.css" />
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
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>  Profile</a></li>
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
                <li><a href="viewusers.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View Users</a></li>
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
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / New User
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="ConfigurationDashBoard.jsp">Configuration</a> <span class="divider"></span></li>
                        <li class="active"><a href="userlist.jsp">Users</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>


            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">

               <c:if test="${user !=null}">
                   <form action="update" method="post" class="form-horizontal">
               </c:if>
               <c:if test="${user ==null}">
                   <form action="insert" method="post" class="form-horizontal">
                   </c:if>
                    <div class="form-group" style="color:#0269A4">
                        <div class="col-md-5">
                       <caption>
                           <h4>
                               <c:if test="${user !=null}">
                                   <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Edit User </label>
                               </c:if>
                               <c:if test="${user ==null}">
                                   <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Add New User </label>
                               </c:if>
                           </h4>
                       </caption>
                        </div>
                    </div>
                       <c:if test="${user !=null}">
                       <input type="hidden" name="User_id" value="<c:out value='${user.User_id}' />"/>
                       </c:if>
                        <hr>

                       <div class="form-group" style="color:#0269A4">
                           <label class="col-md-2 control-label">User Name: </label>
                           <div class="col-md-2">
                               <input type="text" value="<c:out value='${user.UserName}' />" class="form-control" name="UserName" placeholder="Enter User Name...">
                           </div>
                       </div>

                        <div class="form-group" style="color:#0269A4">
                            <label class="col-md-2 control-label">Login Name: </label>
                            <div class="col-md-2">
                            <input type="text" value="<c:out value='${user.UserLoginName}' />" class="form-control" name="UserLoginName" placeholder="Enter Login Name...">
                            </div>
                        </div>

                       <div class="form-group" style="color:#0269A4">
                           <label class="col-md-2 control-label">Password: </label>
                           <div class="col-md-2">
                               <input type="password" value="<c:out value='${user.Password}' />" class="form-control" name="Password" placeholder="Enter Password...">
                           </div>
                       </div>


                       <div class="form-group" style="color:#0269A4">
                           <label class="col-md-2 control-label">User Group Name: </label>
                           <div class="col-md-2">
                           <select name="UserGroup_id"  id="UserGroup_id" class="form-control">
                               <c:forEach items="${listUserGroup_id}" var="UGName">
                               <option value="${UGName.UserGroup_id}">${UGName.UserGroup_id}</option>
                               </c:forEach>
                           </select>
                           </div>
                       </div>
                       <div class="form-group">
                           <label class="col-md-2 control-label">
                               <button type="submit" class="btn btn-primary">Save</button>
                           </label>
                           <label class="col-md-1 control-label">
                               <button type="reset" class="btn btn-primary">Cancel</button>
                           </label>
                       </div>
                   </form>


                <!--
                <form class="form-horizontal" action="adduser.jsp" method="post">


                    <div class="form-group">
                        <label class="col-md-2 control-label">Name :</label>
                        <div class="col-md-2">
                            <input type="text" class="form-control"  name="name" id="txtName" placeholder="Enter Your Name...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">Password :</label>
                        <div class="col-md-2">
                            <input type="password" class="form-control" name="password" id="txtpassword" placeholder="Enter Your Password...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">Email :</label>
                        <div class="col-md-2">
                            <input type="email" class="form-control" name="email" id="txtemail" placeholder="Enter Your Email...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">Sex :</label>
                        <div class="col-md-1">
                            <input type="radio"  name="sex" value="male" id="rdmale">  Male
                        </div>
                        <div class="col-md-1">
                            <input type="radio" name="sex" value="female" id="rdfemale">  Female
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">Country :</label>
                        <div class="col-sm-2">
                            <select name="country"  class="form-control" id="ckcountry">
                                <option>Nepal</option>
                                <option>India</option>
                                <option>Pakistan</option>
                                <option>Afghanistan</option>
                                <option>Berma</option>
                                <option>Other</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            <input type="submit" class="btn btn-primary" value="Save">
                        </label>
                        <div class="col-md-4">

                        </div>
                    </div>
                </form>-->

            </div>
        </div>
    </div>
</div>

</body>
</html>
