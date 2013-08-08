/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.dao.DAOComponent;
import br.uniriotec.tracker.dao.DAOFactory;
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
public class ComponentEditSaveAction extends org.apache.struts.action.Action {

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
        NewComponentForm formBean = (NewComponentForm) form;
        String name = formBean.getName();
        String operatorEmail = formBean.getOperatorEmail();
        String systemName = formBean.getSystemName();
        String oldComponentName = formBean.getOldName();

        
        System.out.println("name");
        System.out.println(name);
        
         System.out.println("systemName");
        System.out.println(systemName);
        
            System.out.println("operatorEmail");
        System.out.println(operatorEmail);

        
        
        
        // perform validation
        if (((name == null)
                || (operatorEmail == null)
                || (systemName == null))) {   // email lacks '@'
            formBean.setError();
            System.out.println("Deu reuim!");
            return mapping.findForward(FAILURE);
        }
        
        DAOComponent dao = DAOFactory.getDAOComponent();
        
        
        int systemId = dao.VerifySystem(systemName);

        if (systemId == -1) {
            System.out.println("system nao verificado");
            return mapping.findForward(FAILURE);
        } else {
            
            if (dao.updateComponent(oldComponentName, name,systemId,operatorEmail) == true) {
                return mapping.findForward(SUCCESS);
            } else {
                System.out.println("Erro ao fazer update de componente.");
                formBean.setError();
                return mapping.findForward(FAILURE);
            }
        }
        
    }
}
