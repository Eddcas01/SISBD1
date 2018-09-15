
package Base_de_Datos;

import Manejadora.PRINCIPAL;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Eliminar {
 conexionBD con = new conexionBD();
 Connection cn = con.conexion();
 Consultas consulta = new Consultas();
    
     public void Eliminar_Cliente(String id){
           String sql = "DELETE  FROM tbl_clientes WHERE idCliente ="+id+"";
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"CLIENTE ELIMINADO");
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    
}
