/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author afonso
 */
public class DAO extends DAOMysqlConector {
    
    public void gravarNoBD() throws SQLException{
        
        abrirConexao();
        
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users");
        stmt.setMaxRows(100);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("nome"));
        }
        
        fecharConexao();
    }
}