<%-- 
    Document   : login
    Created on : Jul 20, 2013, 1:46:44 PM
    Author     : afonso
--%>

<%@page import="br.uniriotec.tracker.struts.form.AccountEditForm"%>
<%@page import="br.uniriotec.tracker.model.User"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

        <jsp:include page="header.jsp" />
        
            <%
                User user = (User) session.getAttribute("loginUser");
            %>

        
            <div class="row">
                
            <html:form action="/accountEdit">
            <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Edit your account</h4>
                    
                    <div class="control-group">
                      <label class="control-label">Name</label>
                      <div class="controls">
                        <html:text property="name" />
                      </div>
                    </div>
                    <div class="control-group">
                      <label class="control-label">Last Name</label>
                      <div class="controls">
                        <html:text property="lastName" />
                      </div>
                    </div>
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Save" />
                        <span><bean:write name="AccountEditForm" property="error" filter="false"/></span>
                      </div>
                    </div>
                </form>
                      
            </div>
            </html:form>
                
            </div>
        
        <jsp:include page="footer.jsp" />