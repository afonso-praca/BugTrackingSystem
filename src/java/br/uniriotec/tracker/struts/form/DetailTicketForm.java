/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author helanio
 */
public class DetailTicketForm extends org.apache.struts.action.ActionForm {
    
    private int idTicket;
    private String title;
    private String description;
    private String system;
    private String component;
    private String status;
    private String error;
    private String operador;

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    /**
     *
     */
    public DetailTicketForm() {
        super();
         
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//        
//        this.setTitle((String) session.getAttribute("title"));
        
        ActionErrors errors = new ActionErrors();
        if (getTitle().isEmpty()) {
            errors.add("Title", new ActionMessage("errors.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}