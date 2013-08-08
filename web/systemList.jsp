<%-- 
    Document   : systemList
    Created on : Aug 7, 2013, 2:48:34 AM
    Author     : afonso
--%>

<%@page import="br.uniriotec.tracker.model.User"%>
<%@page import="br.uniriotec.tracker.model.BugTrackerSystem"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@page import="br.uniriotec.tracker.dao.DAOFactory"%>
<%@page import="br.uniriotec.tracker.dao.DAOSystem"%>
<%@page import="br.uniriotec.tracker.model.BugTrackerSystem"%>

<%@include file="header.jsp"%>

<div class="row">
    <div class="span8">


        <div class="clearfix">
            <h3 class="pull-left">Systems</h3>
            <div class="pull-left title-options">
                <div class="btn-group">

                    <%
                        User user = (User) session.getAttribute("loginUser");
                        System.out.println("user.getType() :");
                        System.out.println(user.getType().toString());

                        if (user.getType().equalsIgnoreCase("ADM")) {
                    %>
                    
                    <a href="newSystem.jsp">
                        <button class="btn btn-success btn-mini pull-left" type="button">New System</button>
                    </a>
                    
                    <%
                        } 
                    %>
                </div>
            </div>
        </div>
                
            <form class="form-search">
                <input type="text" class="input-medium search-query">
                <button type="submit" class="btn btn-mini">Search</button>
            </form>


        <table class="table table-bordered table-striped table-clickable table-sticky table-hover-options">
            <thead>
            <th>
                System Name
            </th>
            </thead>




            <tbody> 


                <%
                    DAOSystem daoSystem = DAOFactory.getDAOSystem();
                    ArrayList<BugTrackerSystem> list = daoSystem.getSystemList();
                    for (int i = 0; i < list.size(); i++) {
                %>
                <tr>
                    <td>
                        <%
                        out.print(list.get(i).getName());
                         %>
                        <div class="btn-group pull-right">
                        <%
                        
                        out.print("<a class='edit' href='javascript:void(0);' data-id=" + list.get(i).getId() + ">");
                        out.print("<button class='left-space btn btn-mini'>Edit</button>");
                        out.print("</a>");
                        
                        out.print("<a class='delete' href='javascript:void(0);' data-id=" + list.get(i).getId() + ">");
                        if (user.getType().equals("ADM")){
                            out.print("<button class='left-space btn btn-mini btn-danger'>Delete</button>");
                            out.print("</a>");
                        }
                        
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
                

<script>
    
    $('.edit').on('click', function() {
        var id = ($(this).data('id'));
        location.href = "editSystem.do?id=" + id;
    });
    
    $('.delete').on('click', function() {
        var id = ($(this).data('id'));
        location.href = "deleteSystem.do?id=" + id;
    });
    
</script>

<jsp:include page="footer.jsp" />