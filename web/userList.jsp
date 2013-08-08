<%-- 
    Document   : systemList
    Created on : Aug 7, 2013, 2:48:34 AM
    Author     : afonso
--%>

<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.List"%>
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
            <h3 class="pull-left">Users</h3>

        </div>

        <form class="form-search" action="/BugTrackingSystem/userList.do">
            <input type="text" class="input-medium search-query " name="filter">
            <button type="submit" class="btn btn-mini" >Search</button>
        </form>




        <table class="table table-bordered table-striped table-clickable table-sticky table-hover-options">
            <thead>
            <th>
                User Information
            </th>

            </thead>
            <tbody>  

                <%
                    List<User> list = (List) request.getAttribute("users");
                    for (int i = 0; i < list.size(); i++) {

                %>
                <tr>
                    <td>
                        <%
                            out.print(list.get(i).getName());
                        %>


                    </td>
                    
                     <td>
                        <%
                            out.print(list.get(i).getEmail());
                        %>


                    </td>


                    <td>
                        <%
                            out.print(list.get(i).getType());
                        %>
                        
                        <div class="btn-group pull-right">
                            <%


                                out.print("<a class='promote' href='javascript:void(0);' data-filter=" + list.get(i).getEmail() + ">");
                                out.print("<button class='left-space btn btn-mini btn-info'>Promote User</button>");
                                out.print("</a>");




                            %>

                    </td>





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

    $('.promote').on('click', function() {
        var email = ($(this).data('email'));
        location.href = "promote.do?name=" + email;
    });


</script>

<jsp:include page="footer.jsp" />