<%-- 
    Document   : newSystem
    Created on : Jul 23, 2013, 7:22:52 PM
    Author     : afonso
--%>


<%@page import="java.beans.Beans"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

<div class="row">

            <html:form action="/saveEditSystem">
            <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Edit System</h4>
                    
                    <div class="control-group">
                      <label class="control-label">Name</label>
                      <div class="controls">
                          <html:text property="name"/>
                      </div>
                    </div>
                      
                      <html:hidden property="id" />
                      
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-primary" value="Edit" />
                        <span><bean:write name="EditSystemForm" property="error" filter="false"/></span>
                      </div>
                    </div>
                </form>
                      
            </div>
            </html:form>
    
            <div class="span5 pull-right">
		
                            
             </div>
    
</div>

<jsp:include page="footer.jsp" />