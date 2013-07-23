<%-- 
    Document   : header
    Created on : Jul 20, 2013, 2:46:58 PM
    Author     : afonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/libs/bootstrap.min.css">
        <link rel="stylesheet" href="styles/libs/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="styles/style.css">
        
        <script src="scripts/libs/jquery.js" type="text/javascript" ></script>
        <script src="scripts/libs/bootstrap.min.js" type="text/javascript" ></script>
        <script src="scripts/app.js" type="text/javascript" ></script>
        
        <title>Bug Tracking System</title>
    </head>
    <body>
    
    <!-- HEADER -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="/BugTrackingSystem">Bug Tracking System</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li>
                <a href="login.jsp">Home</a>
              </li>
              <li>
                <a href="newSystem.jsp">Systems</a>
              </li>
              <li>
                <a href="#">Components</a>
              </li>
              <li>
                <a href="#">Tickets</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    
    <!-- CONTAINER -->
    <div class="container">
    