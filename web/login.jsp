<%-- 
    Document   : login
    Created on : Jul 20, 2013, 1:46:44 PM
    Author     : afonso
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

        <jsp:include page="header.jsp" />

        
            <div class="row">
                
            <html:form action="/login">
            <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Sign In</h4>
                    
                    <div class="control-group">
                      <label class="control-label" for="inputEmail">Email</label>
                      <div class="controls">
                        <html:text property="email" />
                      </div>
                    </div>
                    <div class="control-group">
                      <label class="control-label" for="inputPassword">Password</label>
                      <div class="controls">
                        <html:text property="password" />
                      </div>
                    </div>
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Sign In" />
                        <span><bean:write name="LoginForm" property="error" filter="false"/></span>
                      </div>
                      <div style="margin-top: 20px;" class="contol-group">
                          <a href="resetPassword.jsp"><span>I don't know my password</span></a>
                      </div>
                    </div>
                </form>
                      
            </div>
             </html:form>
                        
            <div class="span5 pull-right">
		
		<p class="pull-left">Welcome guy, don't have an account yet?</p><br/><br/>
                <a href="newUser.jsp">
                    <button class="btn btn-danger btn-large pull-left">Creat an account</button><br/><br/>  
                </a>
                <div><img src="img/bug.jpg" ></div>
                            
             </div>
                
            </div>
        
        <jsp:include page="footer.jsp" />