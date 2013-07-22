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
            if (rs.next()) {
                System.out.println("EXISTE USUARIO");
                return true;
            } else {
                System.out.println("NAO EXISTE USUARIO");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        fecharConexao();
        return false;
    }
    
    private boolean userExists(String email) throws SQLException{
        
        String sqlVerifyUser = "";
        sqlVerifyUser += "SELECT * FROM ticketManager.USER";
        sqlVerifyUser += " WHERE email = " + "'" + email + "'";
        
        Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlVerifyUser);
            if (rs.next()) {
                System.out.println("EXISTE USUARIO");
                return true;
            } else {
                System.out.println("NAO EXISTE USUARIO");
                return false;
            }
    }

    // CREATE ACCESS TOKEN
    public boolean createAccessToken(String email, String token) throws SQLException {
        abrirConexao();

        String sql = "";
        sql += "UPDATE ticketManager.USER SET token = " + "'" + token + "'";
        sql += " WHERE email = " + "'" + email + "'";
        System.out.println(sql);

        Statement st = conn.createStatement();
        int rs = st.executeUpdate(sql);
        System.out.println(rs);

        fecharConexao();

        if (rs == 1) {
            System.out.println("Gravou Token");
            return true;
        } else {
            return false;
        }
    }

    // CREATE NEW USER
    public boolean createUser(String email, String password, String name, String lastName) throws SQLException {

        abrirConexao();

        String sqlCreateUser = "";
        sqlCreateUser += "INSERT INTO ticketManager.USER (name, lastName, email,type, password,isActive,forcePassReset,shouldChangePassword)";
        sqlCreateUser += "VALUES (" + "'"
                + name + "','"
                + lastName + "','"
                + email + "','"
                + TYPE_USUER + "','"
                + password + "','"
                + 0 + "','"
                + 1 + "','"
                + 1 + "')";
        
            if (userExists(email)) {
                System.out.println("EXISTE USUARIO");
                return false;
            } else {
                try {
                    System.out.println("NAO EXISTE USUARIO, LETS CREATE IT");
                    System.out.println(sqlCreateUser);
                    Statement stUser = conn.createStatement();
                    int rsUser = stUser.executeUpdate(sqlCreateUser);
                    if (rsUser == 1) {
                        System.out.println("GRAVOU NEW USER");
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
             }

        fecharConexao();
        return false;
    }

    // CHANGE USER NAME 
    public boolean changeUserName(String email, String newName, String newLastName) {

        abrirConexao();

        String sqlVerifyUser = "";
        sqlVerifyUser += "SELECT * FROM ticketManager.USER";
        sqlVerifyUser += " WHERE email = " + "'" + email + "'";

        String sqlChangeUserName = "";
        sqlChangeUserName += "INSERT INTO ticketManager.USER (name, lastName)";
        sqlChangeUserName += "VALUES (" + "'"
                + newName + "','"
                + newLastName + "','"
                + email + "')";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlVerifyUser);
            if (rs.next()) {
                System.out.println("EXISTE USUARIO PARA TROCAR O NOME");
                System.out.println(sqlVerifyUser);
                Statement stUser = conn.createStatement();
                int rsUser = stUser.executeUpdate(sqlChangeUserName);
                if (rsUser == 0) {
                    System.out.println("Gravou");
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("NAO EXISTE USUARIO COM ESTE EMAIL");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        fecharConexao();
        return false;
    }

    // CHANGE USER PASSWORD
    public boolean chnageUserPassword(String email, String oldPass, String newPass, String confirmPass) {

           if(newPass == confirmPass){
                abrirConexao();

                String sqlVerifyUserPass = "";
                sqlVerifyUserPass += "SELECT * FROM ticketManager.USER";
                sqlVerifyUserPass += " WHERE email = " + "'" + email + "'";
                sqlVerifyUserPass += " AND password = " + "'" + oldPass + "'";

                String sqlChangePass = "";
                sqlChangePass += "INSERT INTO ticketManager.USER (password)";
                sqlChangePass += "VALUES (" + "'"
                        + newPass + "')";

                try {
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sqlVerifyUserPass);
                    if (rs.next()) {
                        System.out.println("EXISTE USUARIO COM A SENHA ESPECIFICADA PARA QUE SEJA TROCADA");

                        Statement stUser = conn.createStatement();
                        int rsUser = stUser.executeUpdate(sqlChangePass);

                        if (rsUser == 0) {
                            System.out.println("Gravou a nova senha");
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        System.out.println("NAO EXISTE USUARIO COM ESTA SENHA PARA QUE A MESMA SEJA INFORMADA");
                        return false;
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }

                fecharConexao();
                return false;
           }else{
               System.out.println("A NOVA SENHA E A SENHA DE CONFIRMAÇÃO NAO SÃO IGUAIS.");

               return false;
           }
               
    }
}