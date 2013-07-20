/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import br.uniriotec.tracker.dao.DAO;
import br.uniriotec.tracker.dao.DAOFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
         try {
            System.out.println("I'll try to connect DB - Login Action");
            DAO dao = DAOFactory.getDAO();
            dao.gravarNoBD();
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }

        // extract user data
        LoginForm formBean = (LoginForm) form;
        String email = formBean.getEmail();
        String password = formBean.getPassword();

        
        // perform validation
        if ((email == null) || // name parameter does not exist
                password == null || // email parameter does not exist
                password.equals("") || // name parameter is empty
                email.indexOf("@") == -1) {   // email lacks '@'

            formBean.setError();
            return mapping.findForward(FAILURE);
        }
        else{
            
            DAO dao = DAOFactory.getDAO();
            dao.verificaUsuario(email, password);
        }

        return mapping.findForward(SUCCESS);
    }
    
}
