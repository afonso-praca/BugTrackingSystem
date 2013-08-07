<%-- 
    Document   : systemList
    Created on : Aug 7, 2013, 2:48:34 AM
    Author     : afonso
--%>

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
                    <a href="newComponent.jsp">
                        <button class="btn btn-success btn-mini pull-left" type="button">New Component</button>
                    </a>
                </div>
            </div>
        </div>
        
        
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
            </thead>
            <tbody> <%
                    DAOComponent daoSystem = DAOFactory.getDAOComponent();
                    ArrayList<Component> list = daoSystem.getComponentList();
                    
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
                          out.print(daoSystem.getSystemName(list.get(i).getSystemName()));
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
    $('.edit').on('click', function (){
        var id = ($(this).attr('id'));
        location.href="editSystem.jsp?id=" + id;
    });
</script>

<jsp:include page="footer.jsp" />