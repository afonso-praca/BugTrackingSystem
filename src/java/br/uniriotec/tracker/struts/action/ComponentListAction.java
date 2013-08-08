/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOComponent;
import br.uniriotec.tracker.dao.DAOSystem;
import br.uniriotec.tracker.model.Component;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author helanio
 */
public class ComponentListAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        
        DAOComponent dao = new DAOComponent();
        List<Component> components = dao.getComponentList();
        
        String filter = request.getParameter("filter");
        
        
        if (filter == null || filter.isEmpty()){
            request.setAttribute("components", components);
        }
        
        else{
            DAOSystem daoSystem = new DAOSystem();
            String systemName = "";
            Component component = null;
            Iterator<Component> iterator = components.iterator();
            while (iterator.hasNext()) {
                    component = iterator.next();
                    systemName = daoSystem.getSystem(Integer.toString(component.getSystemName())).getName();
                    if (! (component.getName().contains((CharSequence)filter) || systemName.equals(filter)) ){
                        iterator.remove();
                    }
            }
            request.setAttribute("components", components);
        }
        
        return mapping.findForward(SUCCESS);
    }
}
