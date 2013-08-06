/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.abrirConexao;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author helanio
 */
public class DAOTicket extends DAOMysqlConector{
    
    public boolean existSystem (String systemName){
        return this.ExistColumnElementInTable("SYSTEM", "systemName", systemName);
    }
    
    public boolean existComponent(String componentName){
        return this.ExistColumnElementInTable("COMPONENT", "componentName", componentName);
    }
    
    public boolean addTicket(String title, String system, String component, String description, String operator){
        abrirConexao();
        
        String sqlCreatTiket = "INSERT INTO ticketManager.TICKET (title, systemKey, componentKey,"
                + " description, status, operador)";
        sqlCreatTiket += "VALUES (" + "'"
                + title + "','"
                + system + "','"
                + component + "','"
                + description + "',"
                + "'novo'" + ",'"
                + operator + "')";
        
         try {
                Statement addTicket = conn.createStatement();
                int rs = addTicket.executeUpdate(sqlCreatTiket);
                if (rs == 1) {
                    return true;
                } else {
                    return false;
                }
                } catch (Exception e) {
                    System.err.println(e);
           }
         fecharConexao();
         return false;
    }
    
}
