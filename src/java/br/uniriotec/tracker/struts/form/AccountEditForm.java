/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.form;

import br.uniriotec.tracker.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.chain.contexts.ActionContext;

/**
 *
 * @author afonso
 */
public class AccountEditForm extends org.apache.struts.action.ActionForm {
    
    private String name;
    private String lastName;
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    // error message
    private String error;
    
    public String getError() {
        return error;
    }

    public void setError() {
        this.error = "<span style='color:red'>Invalid user or password</span>";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     *
     */
    public AccountEditForm() {
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
        if (getName() == null || getLastName() == null) {
            errors.add("email", new ActionMessage("error.email.required"));
        }
        return errors;
    }
    
}
