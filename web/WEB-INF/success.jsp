<%-- 
    Document   : success
    Created on : Jul 20, 2013, 1:56:47 PM
    Author     : afonso
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Congratulations!</h1>

        <p>You have successfully logged in.</p>

        <p>Your name is: <bean:write name="LoginForm" property="name" />.</p>

        <p>Your email address is: <bean:write name="LoginForm" property="email" />.</p>
    </body>
</html>
