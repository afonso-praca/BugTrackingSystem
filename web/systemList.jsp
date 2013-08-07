<%-- 
    Document   : systemList
    Created on : Aug 7, 2013, 2:48:34 AM
    Author     : afonso
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@page import="br.uniriotec.tracker.dao.DAOFactory"%>
<%@page import="br.uniriotec.tracker.dao.DAOSystem"%>

<jsp:include page="header.jsp" />

<div class="row">
    <div class="span8">
        
        
        <div class="clearfix">
            <h3 class="pull-left">Systems</h3>
            <div class="pull-left title-options">
                <div class="btn-group">
                    <a href="newSystem.jsp">
                        <button class="btn btn-success btn-mini pull-left" type="button">New System</button>
                    </a>
                </div>
            </div>
        </div>
        
        
        <table class="table table-bordered table-striped table-clickable table-sticky table-hover-options">
            <thead>
                <th>
                    System Name
                </th>
            </thead>
            <tbody> <%
                    DAOSystem daoSystem = DAOFactory.getDAOSystem();
                    ArrayList<String> list = daoSystem.getSystemList();
                    
                    System.out.println("hahah");
                    
                    for (int i =0; i < list.size(); i++){
                   %>
                   <tr>
                   <td>
                   <%
                        
                        out.print(list.get(i));
                   %>
                   </td>
                   </tr>
                   <%
                    }
                   %>
            </tbody>
        </table>
    </div>    
</div>

<jsp:include page="footer.jsp" />