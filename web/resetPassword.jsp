<%-- 
    Document   : resetPassword
    Created on : Jul 21, 2013, 9:56:41 AM
    Author     : afonso
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

        
    <div class="row">

    <html:form action="/resetPassword">
    <div class="well span6 pull-left">

        <form class="form-horizontal">
            <h4>Please, fulfill this form to reset your password</h4>

            <div class="control-group">
              <label class="control-label">Email</label>
              <div class="controls">
                <html:text property="email" />
              </div>
            </div>
              
            <div class="control-group">
              <label class="control-label">Token</label>
              <div class="controls">
                <html:text property="token" />
              </div>
            </div>
              
            <div class="control-group">
              <label class="control-label">New Password</label>
              <div class="controls">
                <html:password property="password" />
              </div>
            </div>
              
            <div class="control-group">
              <label class="control-label">Confirm New Password</label>
              <div class="controls">
                <html:password property="confirmPassword" />
              </div>
            </div>

            <div class="control-group">
              <div class="controls">
                <html:submit styleClass="btn btn-large btn-primary" value="Reset Password" />
                <span><bean:write name="ResetPasswordForm" property="error" filter="false"/></span>
              </div>

            </div>
        </form>

    </div>
     </html:form>
        
    </div>

<jsp:include page="footer.jsp" />