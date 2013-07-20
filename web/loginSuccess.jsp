<%-- 
    Document   : success
    Created on : Jul 20, 2013, 1:56:47 PM
    Author     : afonso
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<jsp:include page="header.jsp" />

        <h1>Congratulations!</h1>
        <p>You have successfully logged in.</p>
        <p>Your user is: <bean:write name="LoginForm" property="email" />.</p>
        <p>Your password address is: <bean:write name="LoginForm" property="password" />.</p>

<jsp:include page="footer.jsp" />