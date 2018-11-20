/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joss
 */
public class ConexionDao {
        private Connection cn;

    public static Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/polleria","root","sailormoon45");       
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database.getConnection() Error al conectarse a incubadora -->" + ex.getMessage());
            return null;
        }
    }
   
  
    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
  
    
    /* +++++++++++++++   */
    /* GETTER Y SETTER   */
    /* +++++++++++++++   */
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
}
