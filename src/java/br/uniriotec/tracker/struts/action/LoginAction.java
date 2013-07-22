/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.struts.form.LoginForm;
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
public class LoginAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
     
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // extract user data
        LoginForm formBean = (LoginForm) form;
        String email = formBean.getEmail();
        String password = formBean.getPassword();
        
        // control var
        boolean userExists;

        // perform validation
        if ((email == null) || // name parameter does not exist
                password == null || // email parameter does not exist
                password.equals("") || // name parameter is empty
                email.indexOf("@") == -1) {   // email lacks '@'

            formBean.setError();
            return mapping.findForward(FAILURE);
        }
        else{
            DAOUser dao = DAOFactory.getDAOUser();
            userExists = dao.verificaUsuario(email, password);
            
            if (userExists){
                return mapping.findForward(SUCCESS);
            } else {
                formBean.setError();
                return mapping.findForward(FAILURE);
            }
        }
    }
}