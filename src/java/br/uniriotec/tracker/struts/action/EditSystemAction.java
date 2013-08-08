/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.struts.form.NewSystemForm;
import br.uniriotec.tracker.dao.DAOUser;
import br.uniriotec.tracker.dao.DAOFactory;
import br.uniriotec.tracker.dao.DAOSystem;
import br.uniriotec.tracker.dao.DAOTicket;
import br.uniriotec.tracker.model.BugTrackerSystem;
import br.uniriotec.tracker.model.Ticket;
import br.uniriotec.tracker.struts.form.EditSystemForm;
import br.uniriotec.tracker.struts.form.TicketEditForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author afonso
 */
public class EditSystemAction extends org.apache.struts.action.Action{
    
     /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        String idSystem = (String) request.getParameter("id");
        System.out.println("Id = " + idSystem);
        
        DAOSystem dao = new DAOSystem();
        
        System.out.println("DAO");
        
        BugTrackerSystem system = dao.getSystem(idSystem);
        if (system == null){
            return mapping.findForward(FAILURE);
        }
        
        EditSystemForm formBean = (EditSystemForm) form;
        formBean.setName(system.getName());
        formBean.setId(system.getId());
        
        return mapping.findForward(SUCCESS);
    }
}