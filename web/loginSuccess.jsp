<%-- 
    Document   : success
    Created on : Jul 20, 2013, 1:56:47 PM
    Author     : afonso
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<jsp:include page="header.jsp" />

        <h1>Congratulations!</h1>
        <p>You have successfully logged in.</p>
        <p>Your user is: <bean:write name="LoginForm" property="email" />.</p>
        <p>Your password address is: <bean:write name="LoginForm" property="password" />.</p>
        
        
        <ul class="nav nav-list">
            <li class="nav-header">Tickets</li>
            <logic:iterate name="titles" id="titles_id">
            <li><a href="http://localhost:8080/BugTrackingSystem/getTicket.do"><bean:write name="titles_id"/></a></li>
            </logic:iterate>
            ...
        </ul>

<jsp:include page="footer.jsp" />