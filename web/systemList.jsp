<%-- 
    Document   : systemList
    Created on : Aug 7, 2013, 2:48:34 AM
    Author     : afonso
--%>

<%@page import="br.uniriotec.tracker.model.BugTrackerSystem"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@page import="br.uniriotec.tracker.dao.DAOFactory"%>
<%@page import="br.uniriotec.tracker.dao.DAOSystem"%>
<%@page import="br.uniriotec.tracker.model.BugTrackerSystem"%>

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
                    ArrayList<BugTrackerSystem> list = daoSystem.getSystemList();
                    
                    for (int i =0; i < list.size(); i++){
                   %>
                   <tr>
                   <td>
                   <%
                        out.print(list.get(i).getName());
                   %>
                   <div class="btn-group pull-right">
                   <%
                        out.print("<a class='edit' href='javascript:void(0);' id=" + list.get(i).getId() + ">");
                        out.print("<button class='btn'>Edit</button>");
                        out.print("</a>");
                   %>
                       
<!--                    <a href="editSystem.jsp">
                        <button class="btn">Component List</button>
                    </a>-->
                   
                   </div>
                   </td>
                   </tr>
                   <%
                    }
                   %>
            </tbody>
        </table>
    </div>    
</div>
            
            <script>
                
                $('.edit').on('click', function (){
                    var id = ($(this).attr('id'));
                    location.href="editSystem.jsp?id=" + id;
                });
                
            </script>
            

<jsp:include page="footer.jsp" />