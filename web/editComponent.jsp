<%-- 
    Document   : newSystem
    Created on : Jul 23, 2013, 7:22:52 PM
    Author     : afonso
--%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

<div class="row">

            <html:form action="/componentEditSave">
            <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Edit Component</h4>
                    
                    <div class="control-group">
                  
                      <label class="control-label">Operator Email</label>
                      <div class="controls">
                            <html:text property="operatorEmail" />
                      </div>
                      
                      <label class="control-label">System Name</label>
                      <div class="controls">
                            <html:text property="systemName" />
                      </div>
                      
                      <label class="control-label">Component Name</label>
                      <div class="controls">
                        <html:text property="name" />
                      </div>
                      
                       <html:hidden property="oldName" />
                                            
                      
                    </div>
                      
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Edit" />
                        <span><bean:write name="NewComponentForm" property="error" filter="false"/></span>
                      </div>
                    </div>
                </form>
                      
            </div>
            </html:form>
    
            <div class="span5 pull-right">
		
                            
             </div>
    
</div>

<jsp:include page="footer.jsp" />