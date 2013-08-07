/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helanio
 */
public class DAOComponent extends DAOMysqlConector {

    public boolean VerifyUserType(String email) {
        try {
       

            String sqlVerifyUserType = "";
            sqlVerifyUserType += "SELECT type FROM ticketManager.USER";
            sqlVerifyUserType += " WHERE email = " + "'" + email + "'";

            Statement st = conn.createStatement();
            System.out.println(sqlVerifyUserType);
            ResultSet rs = st.executeQuery(sqlVerifyUserType);
            if (rs.next()) {
                System.out.println("USUARIO EXISTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
                System.out.println(rs.getString("type"));
                if ((rs.getString("type").equalsIgnoreCase("USR"))) {
                    return true;
                }

            } else {
                System.out.println("USUARIO NAO EXISTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
                return false;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOComponent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    public int VerifySystem(String systemName) {
        try {
            System.out.println(systemName);

            String sqlVerifySystem = "";
            sqlVerifySystem += "SELECT * FROM ticketManager.SYSTEM";
            sqlVerifySystem += " WHERE systemName = " + "'" + systemName + "'";

            Statement st = conn.createStatement();
            System.out.println(sqlVerifySystem);
            ResultSet rs = st.executeQuery(sqlVerifySystem);
            if (rs.next()) {
                System.out.println("SISTEMA EXISTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");

                return rs.getInt("id");


            } else {
                System.out.println("SISTEMA NAO EXISTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
                return -1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOComponent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public boolean createComponent(String name, String systemName, String operatorEmail) {


        abrirConexao();

        if (!VerifyUserType(operatorEmail)) {
            return false;
        }
        
        int systemId = VerifySystem(systemName);

        if (systemId == -1) {
            return false;
        }
        
        

        String sqlVerifyComponent = "";
        sqlVerifyComponent += "SELECT * FROM ticketManager.COMPONENT";
        sqlVerifyComponent += " WHERE componentName = " + "'" + name + "'";



        String sqlCreateComponent = "";
        sqlCreateComponent += "INSERT INTO ticketManager.COMPONENT (componentName,operadorEmail,systemId )";
        sqlCreateComponent += "VALUES (" + "'"
                + name + "','"
                + operatorEmail + "','"
                + systemId + "')";




        System.out.println("sqlVerifyComponent");
        System.out.println(sqlVerifyComponent);

        System.out.println("sqlCreateComponent");
        System.out.println(sqlCreateComponent);




        try {
            Statement st = conn.createStatement();
            System.out.println(sqlVerifyComponent);
            ResultSet rs = st.executeQuery(sqlVerifyComponent);
            if (rs.next()) {
                System.out.println("COMPONENT JA ESTA CADASTRADO");
                return false;
            } else {
                System.out.println("COMPONENT NAO EXISTE E VAI SER CRIADO");
                System.out.println(sqlCreateComponent);
                Statement stUser = conn.createStatement();
                int rsUser = stUser.executeUpdate(sqlCreateComponent);
                if (rsUser == 1) {
                    System.out.println("GRAVOU O NOVO COMPONENT!");
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }





//        String sqlVerifyComponent = "";
//        sqlVerifyComponent += "SELECT * FROM ticketManager.COMPONENT";
//        sqlVerifyComponent += " WHERE componentName = " + "'" + componentName + "'";
//
//        String sqlCreateComponent = "";
//        sqlCreateComponent += "INSERT INTO ticketManager.COMPONENT (componentName)";
//        sqlCreateComponent += "VALUES (" + "'"
//                + componentName + "')";
//
//        try {
//            Statement st = conn.createStatement();
//            System.out.println(sqlVerifyComponent);
//            ResultSet rs = st.executeQuery(sqlVerifyComponent);
//            if (rs.next()) {
//                System.out.println("COMPONENT JA ESTA CADASTRADO");
//                return false;
//            } else {
//                System.out.println("COMPONENT NAO EXISTE E VAI SER CRIADO");
//                System.out.println(sqlCreateComponent);
//                Statement stUser = conn.createStatement();
//                int rsUser = stUser.executeUpdate(sqlCreateComponent);
//                if (rsUser == 1) {
//                    System.out.println("GRAVOU O NOVO COMPONENT!");
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            System.err.println(e);
//        }

        fecharConexao();
        return false;
    }

    public boolean ComponentBelongsToSystem(String componentName, String systemName) {
        abrirConexao();

        String sqlQuery = "SELECT componentName FROM COMPONENT where systemName = '" + systemName + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()) {
                if (rs.getString("componentName").equals(componentName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        fecharConexao();

        return false;
    }

    public String getOperator(String componentName) {
        abrirConexao();
        String sqlQuery = "SELECT operadorEmail FROM COMPONENT WHERE componentName = '" + componentName + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()) {
                return rs.getString("operadorEmail");
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        fecharConexao();

        return null;

    }
}
