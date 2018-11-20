package dao;
import java.sql.*;

 
public class UsuarioDao  {     
    
     public static boolean login(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConexionDao.Conectar();
            ps = con.prepareStatement(
                    "select user, password from usuarios where user= ? and password= ? ");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            ConexionDao.close(con);
        }
        
     
    }
 
    
        
}