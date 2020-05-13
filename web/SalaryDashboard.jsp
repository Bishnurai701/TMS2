<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 08-05-2020
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin | TMS Salary Dashboard</title>
    <style type="text/css">
        <%@include file="bootstrap/css/bootstrap.min.css" %>
        <%@include file="bootstrap/css/hover-min.css" %>
        <%@include file="bootstrap/css/stylesheet.css" %>
        <%@include file="fontawesome/css/fontawesome.min.css" %>
    </style>

    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet"  href="/bootstrap/css/stylesheet.css" type="text/css">
    <link rel="stylesheet"  href="/bootstrap/css/hover.css" type="text/css">
    <link rel="stylesheet"  href="/bootstrap/css/hover-min.css" type="text/css">
    <link rel="stylesheet"  href="/bootstrap/css/sweetalert.css" type="text/css">
    <link rel="stylesheet"  href="/bootstrap/css/bootstrap-theme.min.css" type="text/css">



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/sweetalert.min.js"></script>

    <script>
        CKEDITOR.replace( 'editor1' );
    </script>

    <script>
        $('#myDropdown').on('show.bs.dropdown', function () {
            $('.dropdown-toggle').dropdown()
        })
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
            <a class="navbar-brand" href="index.jsp">&nbsp;&nbsp;&nbsp; TMS<small> | Time Management System</small></a>
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
                <li class="active"><a href="index.jsp" class="main-color-bg"> <i class="fas fa-home"></i> Dashbaord <span class="sr-only">(current)</span></a></li>
                <li> <a href="<%=request.getContextPath()%>/show">  Attendance</a></li>
                <li><a href="userform.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  Salary</a></li>
                <li><a href="userform.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  Admin</a></li>
                <li><a href="userform.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  Report</a></li>
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
                <li><a href="ConfigurationDashBoard.jsp">Configuration</a></li>
            </ul>
        </div>



        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-md-4 col-xs-4">
                    <div class="page-heading">
                        <h3 style="color:#0269A4">
                            <span class="glyphicon glyphicon-cog"></span> &nbsp; Welcome Salary Dashboard
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li class="active"><a href="SalaryDashboard.jsp">SalaryDashboard</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>


            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <a href="userlist.jsp">
                        <div class="well dash-box">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Staff Attendance</h4>
                        </div>
                    </a>
                    <h4>Attendance</h4>
                    <span class="text-muted">Daily Staff Attendance</span>
                </div>

                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Salary</h4>
                        </a>
                    </div>
                    <h4>Monthly Salary</h4>
                    <span class="text-muted">Monthly Salary Sheet</span>
                </div>
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Reports</h4>
                        </a>
                    </div>
                    <h4>All Reports</h4>
                    <span class="text-muted">All Reports Daily/Monthly</span>
                </div>
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Admin</h4>
                        </a>
                    </div>
                    <h4>Admin Details</h4>
                    <span class="text-muted">Admin Detail Entry</span>
                </div>
            </div>
            <hr><br>

            <!--Second line icons-->
            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Attendance</h4>
                        </a>
                    </div>
                    <h4>Attendance</h4>
                    <span class="text-muted">Daily Attendance</span>
                </div>
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Salary</h4>
                        </a>
                    </div>
                    <h4>Monthly Salary</h4>
                    <span class="text-muted">Monthly Salary Sheet</span>
                </div>
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Reports</h4>
                        </a>
                    </div>
                    <h4>All Reports</h4>
                    <span class="text-muted">All Reports Daily/Monthly</span>
                </div>
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="ConfigurationDashBoard.jsp">
                            <h3> <span class="glyphicon glyphicon-cog"></span> </h3>
                            <h4>Configuration</h4>
                        </a>
                    </div>
                    <h4>Admin</h4>
                    <span class="text-muted">Configuration</span>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
