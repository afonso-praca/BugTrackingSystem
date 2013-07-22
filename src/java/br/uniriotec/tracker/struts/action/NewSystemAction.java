/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.struts.form.NewSystemForm;
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
public class NewSystemAction extends org.apache.struts.action.Action {
    
     /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        // extract user data
        NewSystemForm formBean = (NewSystemForm) form;
        String name = formBean.getName();

        // perform validation
        if (name == null) {   // email lacks '@'
            formBean.setError();
            return mapping.findForward(FAILURE);
        } else {
//            DAOUser dao = DAOFactory.getDAOUser();
//            if (dao.createUser(email, password, name, lastName) == true){
//                return mapping.findForward(SUCCESS);
//            } else {
//                formBean.setError();
//                return mapping.findForward(FAILURE);
//            }
        }
        return null;
    }
}