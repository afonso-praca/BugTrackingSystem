/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author afonso
 */
public class ResetPasswordForm extends org.apache.struts.action.ActionForm {
    
    private String email;
    
    // error message
    private String error;

    public String getError() {
        return error;
    }

    public void setError() {
        this.error =
                "<span style='color:red'>Please provide valid entries for all fields</span>";
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param string
     */
    public void setEmail(String string) {
        email = string;
    }

    /**
     *
     */
    public ResetPasswordForm() {
        super();
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getEmail()== null) {
            errors.add("email", new ActionMessage("error.email.required"));
            // TODO: add 'error.email.required' key to your resources
        }
        return errors;
    }
}
