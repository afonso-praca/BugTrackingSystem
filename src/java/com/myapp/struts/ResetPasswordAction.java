/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import br.uniriotec.tracker.dao.DAOUser;
import br.uniriotec.tracker.dao.DAOFactory;
import java.util.Properties;
import java.util.UUID;
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

        // perform validation
        if ((email == null) || // name parameter does not exist
                email.indexOf("@") == -1) {   // email lacks '@'

            formBean.setError();
            return mapping.findForward(FAILURE);
        } else {
            
            // gera o token
            
            String token = UUID.randomUUID().toString().substring(0, 8);
            System.out.println(token);
            DAOUser dao = DAOFactory.getDAOUser();
            dao.createAccessToken(email, token);
            
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

        return mapping.findForward(SUCCESS);
    }
    
}
