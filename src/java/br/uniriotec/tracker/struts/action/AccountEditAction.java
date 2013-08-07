/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOFactory;
import br.uniriotec.tracker.dao.DAOUser;
import br.uniriotec.tracker.model.User;
import br.uniriotec.tracker.struts.form.AccountEditForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author afonso
 */
public class AccountEditAction extends org.apache.struts.action.Action  {
    
     /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // extract user data
        AccountEditForm formBean = (AccountEditForm) form;
        String name = formBean.getName();
        String lastName = formBean.getLastName();
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");

        // perform validation
        if ((name == null) || lastName == null) {
            formBean.setError();
            return mapping.findForward(FAILURE);
        }
        else{
            DAOUser dao = DAOFactory.getDAOUser();
            boolean retorno = dao.setName(user.getEmail(), name, lastName);
            
            if (retorno == true){
                user.setName(name);
                user.setLastName(lastName);
                session.setAttribute("loginUser", user);
                return mapping.findForward(SUCCESS);
            } else {
                formBean.setError();
                return mapping.findForward(FAILURE);
            }
        }
    }
}