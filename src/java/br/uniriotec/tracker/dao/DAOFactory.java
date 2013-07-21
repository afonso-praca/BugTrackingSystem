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
    
    private static DAOUser dao;
    
    public static DAOUser getDAOUser(){
        if (dao == null)
            dao = new DAOUser();
        
        return dao;
    }
}
