/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import br.uniriotec.tracker.struts.form.NewTicketForm;
import br.uniriotec.tracker.dao.DAOFactory;
import br.uniriotec.tracker.dao.DAOTicket;
import br.uniriotec.tracker.dao.DAOComponent;

/**
 *
 * @author helanio
 */
public class NewTicketAction extends org.apache.struts.action.Action {

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
        NewTicketForm formBean = (NewTicketForm) form;
        String title = formBean.getTitle();
        String description = formBean.getDescription();
        String system = formBean.getSystem();
        String component = formBean.getComponent();
        
        //Valitation
        if (title.isEmpty()) {
            formBean.setError("<span style='color:red'> Title can't be blank.</span>");
            return mapping.findForward(FAILURE);
        }
        
        DAOTicket dao = new DAOTicket();
        
        if(! dao.existSystem(system)) {
            formBean.setError("<span style='color:red'> The given System don't exist.</span>");
            return mapping.findForward(FAILURE);
        }
        
        if(! dao.existComponent(component)){
            formBean.setError("<span style='color:red'> The given Component don't exist.</span>");
            return mapping.findForward(FAILURE);
        }
        
        DAOComponent dao_component = new DAOComponent();
        
        if(! dao_component.ComponentBelongsToSystem(component, system)){
            formBean.setError("<span style='color:red'> The given Component don't belongs to System " + system + ".</span>");
            return mapping.findForward(FAILURE);
        }
        
        String operator = dao_component.getOperator(component);
        if (operator == null){
            System.err.println("ERRO: foi obtido null ao obter operadorEmail da tablela component.");
            return mapping.findForward(FAILURE);
        }
        
        //addTicket
       
        boolean sucess = dao.addTicket(title, system, component, description, operator);
        if(sucess){
            return mapping.findForward(SUCCESS);
        } else{
            return mapping.findForward(FAILURE);
        }
        
        
        
    }
}
