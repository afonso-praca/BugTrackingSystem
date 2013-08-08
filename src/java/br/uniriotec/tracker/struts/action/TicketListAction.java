/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOTicket;
import br.uniriotec.tracker.model.Ticket;
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
public class TicketListAction extends org.apache.struts.action.Action {

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
        
        DAOTicket dao = new DAOTicket();
        List<Ticket> tickets = dao.getAllTickets();
        
        String filter = request.getParameter("filter");
        
        System.out.println("Filtro = [" + filter + "]");
        
        if (filter == null || filter.isEmpty()){
            request.setAttribute("tickets", tickets);
        }
        
        else{
            Ticket ticket = null;
            Iterator<Ticket> iterator = tickets.iterator();
            while (iterator.hasNext()) {
                    ticket = iterator.next();
                    if (! (ticket.getTitle().equals(filter) || ticket.getSystemKey().equals(filter)) ){
                        iterator.remove();
                    }
            }
            request.setAttribute("tickets", tickets);
        }
        
        
  
        
        
        
        
        return mapping.findForward(SUCCESS);
    }
}
