/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.struts.form.NewUserForm;
import br.uniriotec.tracker.dao.DAOUser;
import br.uniriotec.tracker.dao.DAOFactory;
import br.uniriotec.tracker.dao.DAOSystem;
import br.uniriotec.tracker.dao.DAOTicket;
import br.uniriotec.tracker.model.BugTrackerSystem;
import br.uniriotec.tracker.model.Ticket;
import br.uniriotec.tracker.model.User;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author afonso
 */
public class UserListAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("GET USER ACTION!!!!!!!!!!!!!!!!");

        //DAOSystem dao = new DAOSystem();
        DAOUser dao = new DAOUser();
        List<User> users = dao.getSystemList();
        System.out.println("1");

        String filter = request.getParameter("filter");

        System.out.println("2");
        if (filter == null || filter.isEmpty()) {
            System.out.println("3");
            System.out.println(users.get(0).getEmail());
            request.setAttribute("users", users);
            
        } else {
            System.out.println("4");
            Iterator<User> iterator = users.iterator();

            while (iterator.hasNext()) {
                System.out.println("5");
                if (!iterator.next().getName().contains((CharSequence) filter)) {
                    System.out.println("6");
                    iterator.remove();
                }
            }
            request.setAttribute("users", users);
        }







        return mapping.findForward(SUCCESS);
    }
}
