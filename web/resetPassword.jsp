<%-- 
    Document   : resetPassword
    Created on : Jul 20, 2013, 8:42:04 PM
    Author     : afonso
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

        <jsp:include page="header.jsp" />

        
            <div class="row">
                
            <html:form action="/resetPassword">
            <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>We will send a token to your email, use it to change your password</h4>
                    
                    <div class="control-group">
                      <label class="control-label">Email</label>
                      <div class="controls">
                        <html:text property="email" />
                      </div>
                    </div>
                      
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Send Token" />
                        <span><bean:write name="ResetPasswordForm" property="error" filter="false"/></span>
                      </div>
                     
                    </div>
                </form>
                      
            </div>
             </html:form>
        
        <jsp:include page="footer.jsp" />