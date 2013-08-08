/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOComponent;
import br.uniriotec.tracker.dao.DAOSystem;
import br.uniriotec.tracker.model.Component;
import br.uniriotec.tracker.struts.form.NewComponentForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author helanio
 */
public class ComponentEditAction extends org.apache.struts.action.Action {

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
        
        String idComponent = (String) request.getParameter("idComponent");
        
        DAOComponent dao = new DAOComponent();
        Component component = dao.getComponent(idComponent);
        if (component == null){
            return mapping.findForward(FAILURE);
        }
        DAOSystem daoSystem = new DAOSystem();
        String systemName = daoSystem.getSystem(Integer.toString(component.getSystemName())).getName();
        
        NewComponentForm formBean = (NewComponentForm) form;
        formBean.setName(component.getName());
        formBean.setOperatorEmail(component.getOperatorEmail());
        formBean.setSystemName(systemName);
        formBean.setOldName(component.getName());
        
        
        
        
        return mapping.findForward(SUCCESS);
        
    }
}
