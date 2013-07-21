/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.abrirConexao;
import static br.uniriotec.tracker.dao.DAOMysqlConector.conn;
import static br.uniriotec.tracker.dao.DAOMysqlConector.fecharConexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author afonso
 */
public class DAOUser extends DAOMysqlConector {
    
    public final static String TYPE_USUER = "USR";
    public final static String TYPE_OPERATOR = "OPR";
    public final static String TYPE_ADNISTRATOR = "ADM";

    // VERIFICA EXISTENCIA DO USUARIO E SENHA
    public boolean verificaUsuario(String email, String password) {

        abrirConexao();

        String sql = "";
        sql += "SELECT * FROM ticketManager.USER";
        sql += " WHERE email = " + "'" + email + "'";
        sql += " AND password = " + "'" + password + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                System.out.println("EXISTE USUARIO");
                return true;
            }
            else{
                System.out.println("NAO EXISTE USUARIO");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        fecharConexao();
        return false;
    }
    
    // CREATE ACCESS TOKEN
    public boolean createAccessToken(String email, String token) throws SQLException{
        abrirConexao();
        
        String sql = "";
        sql += "UPDATE ticketManager.USER SET token = " + "'" + token + "'";
        sql += " WHERE email = " + "'" + email + "'";
        System.out.println(sql);
        
        Statement st = conn.createStatement();
        int rs = st.executeUpdate(sql);
        System.out.println(rs);
        
        fecharConexao();
        
        if(rs == 1){
            System.out.println("Gravou Token");
            return true;
        } else {
            return false;
        }
    }
    
    // CREATE NEW USER
    public boolean createUser(String email, String password, String name, String lastName) {

        abrirConexao();

        String sqlVerifyUser = "";
        sqlVerifyUser += "SELECT * FROM ticketManager.USER";
        sqlVerifyUser += " WHERE email = " + "'" + email + "'";
        
        String sqlCreateUser = "";
        sqlCreateUser += "INSERT INTO ticketManager.USER (name, lastName, email,type, password,isActive,forcePassReset,shouldChangePassword)";
        sqlCreateUser += "VALUES ("+"'" 
                + name + "','" 
                + lastName + "','" 
                + email + "','"
                + TYPE_USUER + "','"
                + password +  "','" 
                + 0 + "','"
                + 1 + "','"
                + 1 + "')";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlVerifyUser);
            if(rs.next()){
                System.out.println("EXISTE USUARIO");
                return false;
            }
            else {
                System.out.println("NAO EXISTE USUARIO, LETS CREATE IT");
                System.out.println(sqlCreateUser);
                Statement stUser = conn.createStatement();
                int rsUser = stUser.executeUpdate(sqlCreateUser);
                if(rsUser == 0){
                    System.out.println("Gravou");
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        fecharConexao();
        return false;
    }
}