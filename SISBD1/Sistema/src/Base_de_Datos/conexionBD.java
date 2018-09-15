package Base_de_Datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionBD {
    
    Connection cn = null;

   public Connection conexion()   {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                cn = DriverManager.getConnection("jdbc:mysql://localhost/ayaseg_bd","root","");
            } catch (SQLException ex) {
                Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return cn;
      
   }
}
