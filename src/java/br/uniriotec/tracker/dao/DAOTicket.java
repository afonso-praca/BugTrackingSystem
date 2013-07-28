/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.abrirConexao;
import java.sql.ResultSet;
import java.sql.Statement;
import static br.uniriotec.tracker.dao.DAOMysqlConector.conn;
import static br.uniriotec.tracker.dao.DAOMysqlConector.fecharConexao;

/**
 *
 * @author helanio
 */
public class DAOTicket {
    
    private boolean ExistColumnElementInTable(String tableName, String columnName, String element){
        abrirConexao();
        
        String sqlQuery = "SELECT " + columnName + " FROM " + tableName + " WHERE " + columnName + " = '" + element + "'";
        
        
         try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            return rs.first();
        } catch (Exception e) {
                System.err.println(e);
        }
         
        fecharConexao();
        return false;
        
    }
    
    public boolean existSystem (String systemName){
        return this.ExistColumnElementInTable("SYSTEM", "systemName", systemName);
        
    }
    
    public boolean existComponent(String componentName){
        return this.ExistColumnElementInTable("COMPONENT", "componentName", componentName);
    }
    
    public boolean addTicket(String title, String system, String component, String description){
        abrirConexao();
        
        //DAOComponent = new DAOComponet();
        //String operador = dao.getOperator(component)
        
        String sqlCreatTiket = "INSERT INTO ticketManager.TICKET (title, systemKey, componentKey, description, status)";
        sqlCreatTiket += "VALUES (" + "'"
                + title + "','"
                + system + "','"
                + component + "','"
                + description + "',"
                + "'novo')";
        
         try {
                System.out.println("NAO EXISTE USUARIO, LETS CREATE IT");
                System.out.println(sqlCreatTiket);
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
