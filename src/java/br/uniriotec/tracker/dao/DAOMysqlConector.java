/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;

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
    
    
}