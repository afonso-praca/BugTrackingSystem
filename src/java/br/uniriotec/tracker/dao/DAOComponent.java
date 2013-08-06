/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.conn;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author helanio
 */
public class DAOComponent extends DAOMysqlConector{
    
    public boolean ComponentBelongsToSystem(String componentName, String systemName){
        abrirConexao();
        
        String sqlQuery = "SELECT componentName FROM COMPONENT where systemName = '" + systemName + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()){
                if (rs.getString("componentName").equals(componentName))
                    return true;
            }
        } catch (Exception e) {
                System.err.println(e);
        }
        
        fecharConexao();
                
        return false;
    }
    
    public String getOperator (String componentName){
        abrirConexao();
        String sqlQuery = "SELECT operadorEmail FROM COMPONENT WHERE componentName = '" + componentName + "'";
         try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()){
                return rs.getString("operadorEmail");
            }
        } catch (Exception e) {
                System.err.println(e);
        }
        
        fecharConexao();
                
        return null;
  
    }
    
}
