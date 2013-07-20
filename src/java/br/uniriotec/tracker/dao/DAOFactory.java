/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

/**
 *
 * @author afonso
 */
public class DAOFactory {
    
    private static DAO dao;
    
    public static DAO getDAO(){
        if (dao == null)
            dao = new DAO();
        
        return dao;
    }
}
