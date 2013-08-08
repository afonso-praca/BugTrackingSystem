<%-- 
    Document   : ticketEdit
    Created on : Aug 6, 2013, 2:19:50 AM
    Author     : helanio
--%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

<div class="row">
    
    <html:form action="/detailTicket">
        <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Ticket Details</h4>
                    
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
                      <label class="control-label">Status</label>
                      <div class="controls">
                          <html:text property="status" />
                      </div>
                      </div>
                      
                      <html:hidden property="idTicket" />
                      
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Edit" />
                        <span><bean:write name="DetailTicketForm" property="error" filter="false"/></span>
                       </div>
                    </div>
                </form>
                      
            </div>
           
        
        
    </html:form>
    
   </div>
    
    

<jsp:include page="footer.jsp" />
