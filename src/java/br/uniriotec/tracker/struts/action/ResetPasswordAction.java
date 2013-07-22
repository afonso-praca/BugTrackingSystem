/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.struts.action;

import br.uniriotec.tracker.struts.form.ResetPasswordForm;
import br.uniriotec.tracker.dao.DAOUser;
import br.uniriotec.tracker.dao.DAOFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.MessagingException;

/**
 *
 * @author afonso
 */
public class ResetPasswordAction extends org.apache.struts.action.Action {
    
     /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        // extract user data
        ResetPasswordForm formBean = (ResetPasswordForm) form;
        String email = formBean.getEmail();
        String password = formBean.getPassword();
        String confimPassword = formBean.getConfirmPassword();
        String token = formBean.getToken();
        
        // perform validation
        if (email == null || // name parameter does not exist
                token == null || // name parameter does not exist
                password == null || // email parameter does not exist
                confimPassword == null ||
                password.equals("") || // name parameter is empty
                !password.equals(confimPassword) || // name parameter is empty
                email.indexOf("@") == -1) {   // email lacks '@'

            formBean.setError();
            return mapping.findForward(FAILURE);
            
        } else {
            
            // gera o token
            System.out.println("Lets change password!");
            
           DAOUser dao = DAOFactory.getDAOUser();
           if (dao.resetPassword(email, token, password, confimPassword) == true) {
               System.out.println("Resetou");
               return mapping.findForward(SUCCESS);
           } else {
               formBean.setError();
               System.out.println(" Não Resetou");
               return mapping.findForward(FAILURE);
           }
            
            // envia email
            /*Properties props = new Properties();
            props.put("mail.host", "gmail.com");
            props.put("mail.user", "afonsoinfo");
            Session mailSession = Session.getDefaultInstance(props, null);
            
            MimeMessage msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress("afonsoinfo@gmail.com", "Afonso Info"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("afonsoinfo@gmail.com", "Jeff Hanson"));
            msg.setSubject("This is the email message subject");
            msg.setText("This is the email message body");
           
            Transport.send(msg);*/
        }
    }
    
}
