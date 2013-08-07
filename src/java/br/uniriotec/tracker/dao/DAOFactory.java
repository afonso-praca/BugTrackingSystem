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
    
    private static DAOUser daoUser;
    private static DAOSystem daoSystem;
    
    public static DAOUser getDAOUser(){
        if (daoUser == null)
            daoUser = new DAOUser();
        
        return daoUser;
    }
    
    public static DAOSystem getDAOSystem(){
        if (daoSystem == null)
            daoSystem = new DAOSystem();
        
        return daoSystem;
    }
}
