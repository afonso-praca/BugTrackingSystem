<%-- 
    Document   : systemList
    Created on : Aug 7, 2013, 2:48:34 AM
    Author     : afonso
--%>

<%@page import="java.util.List"%>
<%@page import="br.uniriotec.tracker.model.Ticket"%>
<%@page import="br.uniriotec.tracker.dao.DAOTicket"%>
<%@page import="br.uniriotec.tracker.model.BugTrackerSystem"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@page import="br.uniriotec.tracker.dao.DAOFactory"%>
<%@page import="br.uniriotec.tracker.dao.DAOSystem"%>
<%@page import="br.uniriotec.tracker.model.BugTrackerSystem"%>

<jsp:include page="header.jsp" />

<div class="row">
    <div class="span8">
        
        
        <div class="clearfix">
            <h3 class="pull-left">Tickets</h3>
            <div class="pull-left title-options">
                <div class="btn-group">
                    <a href="newTicket.jsp">
                        <button class="btn btn-success btn-mini pull-left" type="button">New Ticket</button>
                    </a>
                </div>
            </div>
        </div>
        
        <form class="form-search" action="/BugTrackingSystem/ticketList.do">
            <input type="text" class="input-medium search-query " name="filter">
            <button type="submit" class="btn btn-mini" >Search</button>
          </form>
        
        <table class="table table-bordered table-striped table-clickable table-sticky table-hover-options">
            <thead>
                <th>
                    Ticket Name
                </th>
            </thead>
            <tbody> <%
                    List<Ticket> list = (List) request.getAttribute("tickets");
                    for (int i =0; i < list.size(); i++){
                   %>
                   <tr>
                   <td>
                   <%
                        out.print(list.get(i).getTitle());
                   %>
                   <div class="btn-group pull-right">
                   <%
                        out.print("<a class='edit' href='javascript:void(0);' id=" + list.get(i).getId() + ">");
                        out.print("<button class='btn'>Edit</button>");
                        out.print("</a>");
                   %>
                   
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
        location.href="getTicket.do?id=" + id;
    });
    
    $
</script>

<jsp:include page="footer.jsp" />