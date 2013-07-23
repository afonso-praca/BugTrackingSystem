/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author afonso
 */
   
public class LoginFilter implements Filter {
 
    private FilterConfig config = null;

    @Override
    public void init (FilterConfig config) throws ServletException{

    this.config = config;

    }

    @Override
    public void destroy(){

    config = null;

    }

    public void doFilter(ServletRequest request,ServletResponse response,
    FilterChain chain) throws
    IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        String loginStatus = (session.getAttribute("loginStatus") == null) ? "" : (String)session.getAttribute("loginStatus");

        if(loginStatus.equals("LOGGED")){

                chain.doFilter(req, response);

        } else {
            res.sendRedirect("login.jsp"); 
        }
    }
}