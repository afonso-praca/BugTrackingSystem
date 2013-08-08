<%-- 
    Document   : systemList
    Created on : Aug 7, 2013, 2:48:34 AM
    Author     : afonso
--%>

<%@page import="java.util.List"%>
<%@page import="br.uniriotec.tracker.model.User"%>
<%@page import="br.uniriotec.tracker.model.Component"%>
<%@page import="br.uniriotec.tracker.dao.DAOComponent"%>
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
            <h3 class="pull-left">Components</h3>
            <div class="pull-left title-options">
                     <div class="btn-group">

                            <%
                                User user = (User) session.getAttribute("loginUser");
                                System.out.println("user.getType() :");
                                System.out.println(user.getType().toString());
                                if (user.getType().equalsIgnoreCase("ADM")) {
                            %>
                            <a href="newComponent.jsp">
                                <button class="btn btn-success btn-mini pull-left" type="button">New Component</button>
                            </a>
                            <%                        }
                            %>
                        </div>
                                
            </div>
        </div>
                        
        <form class="form-search" action="/BugTrackingSystem/componentList.do">
            <input type="text" class="input-medium search-query" name="filter">
            <button type="submit" class="btn btn-mini">Search</button>
        </form>
        
        
        <table class="table table-bordered table-striped table-clickable table-sticky table-hover-options">
            <thead>
                <th>
                    Component Name
                </th>
                 <th>
                    Operator
                </th>
                <th>
                    System Name
                </th>
                <th style="width: 100px;">
                    Actions
                </th>
            </thead>
            <tbody> <%
                     DAOComponent dao = new DAOComponent();
                     List<Component> list = (List) request.getAttribute("components");
                    for (int i =0; i < list.size(); i++){
                   %>
                   <tr>
                    <td>
                     <%
                          out.print(list.get(i).getName());
                     %>
                    </td>
                    <td>
                     <%
                          out.print(list.get(i).getOperatorEmail());
                     %>
                    </td>
                     <td>
                     <%
                          out.print(dao.getSystemName(list.get(i).getSystemName()));
                      %>  
                      </td>
                      <td>
                          <div class="btn-group pull-right">
                      <%
                        if (user.getType().equals("ADM")){
                            out.print("<a class='edit' href='javascript:void(0);' data-id=" + list.get(i).getName() + ">");
                            out.print("<button class='left-space btn btn-mini'>Edit</button>");
                            out.print("</a>");
                            
                            out.print("<a class='delete' href='javascript:void(0);' data-id=" + list.get(i).getName()+ ">");
                            out.print("<button class='left-space btn btn-mini btn-danger'>Delete</button>");
                            out.print("</a>");
                            
                            System.out.println("nome === "+list.get(i).getName());
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
        location.href = "componentEdit.do?idComponent=" + id;
    });
</script>

<jsp:include page="footer.jsp" />