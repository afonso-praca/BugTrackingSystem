/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOTicket;
import br.uniriotec.tracker.model.Ticket;
import br.uniriotec.tracker.struts.form.DetailTicketForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author afonso
 */
public class DetailTicketAction  extends org.apache.struts.action.Action {

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
        
        String idTicket = (String) request.getParameter("id");
        System.out.println("Id = " + idTicket);
        
        DAOTicket dao = new DAOTicket();
        Ticket ticket = dao.getTicket(idTicket);
        if (ticket == null){
            return mapping.findForward(FAILURE);
        }
        
        DetailTicketForm formBean = (DetailTicketForm) form;
        formBean.setTitle(ticket.getTitle());
        formBean.setDescription(ticket.getDescription());
        formBean.setComponent(ticket.getComponentKey());
        formBean.setSystem(ticket.getSystemKey());
        formBean.setIdTicket(ticket.getId());
        
        
        return mapping.findForward(SUCCESS);
    }
}
