/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import br.uniriotec.tracker.dao.DAOUser;
import br.uniriotec.tracker.dao.DAOFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author afonso
 */
public class ResetPasswordAction extends org.apache.struts.action.Action {
    
     /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

         
        // extract user data
        ResetPasswordForm formBean = (ResetPasswordForm) form;
        String email = formBean.getEmail();

        // perform validation
        if ((email == null) || // name parameter does not exist
                email.indexOf("@") == -1) {   // email lacks '@'

            formBean.setError();
            return mapping.findForward(FAILURE);
        } else {
           
        }

        return mapping.findForward(SUCCESS);
    }
    
}
