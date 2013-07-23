<%-- 
    Document   : newUser
    Created on : Jul 20, 2013, 4:22:33 PM
    Author     : afonso
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

<div class="row">

            <html:form action="/newUser">
            <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Create an Account</h4>
                    
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
                      <label class="control-label">Email</label>
                      <div class="controls">
                        <html:text property="email" />
                      </div>
                    </div>
                    <div class="control-group">
                      <label class="control-label">Password</label>
                      <div class="controls">
                        <html:password property="password" />
                      </div>
                    </div>
                      
                    <div class="control-group">
                      <label class="control-label">Password Confirm</label>
                      <div class="controls">
                        <html:password property="confirmedPassword" />
                      </div>
                    </div>
                      
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Sign Up" />
                        <span><bean:write name="NewUserForm" property="error" filter="false"/></span>
                      </div>
                    </div>
                </form>
                      
            </div>
            </html:form>
    
            <div class="span5 pull-right">
		
		<p class="pull-left">Already a member?</p><br/><br/>
                <a href="login.jsp">
                    <button class="btn btn-danger btn-large pull-left">Sign In</button><br/><br/>  
                </a>
                <div><img src="img/bug.jpg" class="bug-image"></div>
                            
             </div>
    
</div>

<jsp:include page="footer.jsp" />