<%-- 
    Document   : newTicket
    Created on : Jul 25, 2013, 2:24:03 PM
    Author     : helanio
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

<div class="row">
    <html:form action="/newTicket">
        <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Create New Ticket</h4>
                    
                    <div class="control-group">
                      <label class="control-label">Title</label>
                      <div class="controls">
                        <html:text property="title" />
                      </div>
                    </div>
                      
                      <div class="control-group">
                      <label class="control-label">Description</label>
                      <div class="controls">
                        <html:text property="description" />
                      </div>
                      </div>
                      
                      <div class="control-group">
                      <label class="control-label">System</label>
                      <div class="controls">
                        <html:text property="system" />
                      </div>
                      </div>
                      
                      <div class="control-group">
                      <label class="control-label">Component</label>
                      <div class="controls">
                        <html:text property="component" />
                      </div>
                      </div>
                      
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Create" />
                       </div>
                    </div>
                </form>
                      
            </div>
        
    </html:form>
    
    
</div>

<jsp:include page="footer.jsp" />
