/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.abrirConexao;
import static br.uniriotec.tracker.dao.DAOMysqlConector.conn;
import static br.uniriotec.tracker.dao.DAOMysqlConector.fecharConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author afonso
 */
public class DAO extends DAOMysqlConector {

    public void gravarNoBD() throws SQLException {

        abrirConexao();

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USER");
        //stmt.setMaxRows(100);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        fecharConexao();
    }

    public void verificaUsuario(String login, String senha) {


        abrirConexao();


        String sql = "";
        sql += "SELECT * FROM ticketManager.USER";
        sql += " WHERE email = " + "'" + login + "'";
        sql += " AND password = " + "'" + senha + "'";
        System.out.println(sql);
        try {
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                System.out.println("EXISTE USUARIO");
            }
            else{
                System.out.println("NAO EXISTE USUARIO");
            }
                
            
            
        System.out.println("AAAAAAAAAAAAAAAAAA");    
        } catch (Exception e) {
            System.err.println(e);
        }
        fecharConexao();
    }
}