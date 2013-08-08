/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author afonso
 */
public class DAOMysqlConector {
    
    public static String dbUrl = "jdbc:mysql://localhost:3306/ticketManager";
    public static Connection conn = null;
    
    @SuppressWarnings("UseSpecificCatch")
    protected static void abrirConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(dbUrl, "root", "beta!@#");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    protected static void fecharConexao() {
        try {
            conn.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    protected boolean ExistColumnElementInTable(String tableName, String columnName, String element){
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
    
    protected boolean ExistColumnElementInTableById(String tableName, String columnName, String element){
        abrirConexao();
        String sqlQuery = "SELECT " + columnName + " FROM " + tableName + " WHERE " + columnName + " = " + element;
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
    
    
}