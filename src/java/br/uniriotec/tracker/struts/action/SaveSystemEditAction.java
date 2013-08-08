/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOSystem;
import br.uniriotec.tracker.struts.form.EditSystemForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author helanio
 */
public class SaveSystemEditAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
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
        EditSystemForm formBean = (EditSystemForm) form;
        String name = formBean.getName();
        int id = formBean.getId();
        String idString = String.valueOf(id);
       
        DAOSystem dao = new DAOSystem();
        
        if(dao.getSystem(idString) == null) {
           return mapping.findForward(FAILURE);
        }
        
        boolean sucess = dao.changeSystemName(name, id);
        
        System.out.println("fiz a chamada" + sucess);
        
        if(sucess){
            return mapping.findForward(SUCCESS);
        } else{
            return mapping.findForward(FAILURE);
        }
    }
}