<%-- 
    Document   : newSystem
    Created on : Jul 23, 2013, 7:22:52 PM
    Author     : afonso
--%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

<div class="row">

            <html:form action="/editSystem">
            <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    <h4>Edit System</h4>
                    
                    <div class="control-group">
                      <label class="control-label">Name</label>
                      <div class="controls">
                        <html:text property="name" />
                      </div>
                    </div>
                      
                    <div class="control-group">
                      <div class="controls">
                        <html:submit styleClass="btn btn-large btn-primary" value="Create" />
                        <span><bean:write name="EditSystemForm" property="error" filter="false"/></span>
                      </div>
                    </div>
                </form>
                      
            </div>
            </html:form>
    
            <div class="span5 pull-right">
		
                            
             </div>
    
     <script>
        
        function getQuerystringNameValue(name)
        {
            // For example... passing a name parameter of "name1" will return a value of "100", etc.
            // page.htm?name1=100&name2=101&name3=102

            var winURL = window.location.href;
            var queryStringArray = winURL.split("?");
            var queryStringParamArray = queryStringArray[1].split("&");
            var nameValue = null;

            for ( var i=0; i<queryStringParamArray.length; i++ )
            {           
                queryStringNameValueArray = queryStringParamArray[i].split("=");

                if ( name == queryStringNameValueArray[0] )
                {
                    nameValue = queryStringNameValueArray[1];
                }                       
            }

            return nameValue;
        }
        
        console.log(getQuerystringNameValue("id"));

    </script>
    
</div>

<jsp:include page="footer.jsp" />