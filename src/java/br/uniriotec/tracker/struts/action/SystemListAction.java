/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOSystem;
import br.uniriotec.tracker.dao.DAOTicket;
import br.uniriotec.tracker.model.BugTrackerSystem;
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
 * @author afonso
 */
public class SystemListAction extends org.apache.struts.action.Action {
    
     /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        DAOSystem dao = new DAOSystem();
        List<BugTrackerSystem> systems = dao.getSystemList();
        
        String filter = request.getParameter("filter");
        
        
        if (filter == null || filter.isEmpty()){
            request.setAttribute("systems", systems);
        }
        
        else{
            Iterator<BugTrackerSystem> iterator = systems.iterator();
           
            while (iterator.hasNext()) {
                    if (! iterator.next().getName().equals(filter) ){
                        iterator.remove();
                    }
            }
            request.setAttribute("systems", systems);
        }
        
        
  
        
        
        
        
        return mapping.findForward(SUCCESS);
    }
    
}
