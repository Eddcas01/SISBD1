
package Base_de_Datos;

import Manejadora.PRINCIPAL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Cliente {
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    
   public String datosClt(String id)
    { DefaultTableModel modelo1 = new DefaultTableModel();
       
       String sql1 ="SELECT * FROM  tbl_clientes WHERE 	IdCliente ="+ id+"";
       String DatosClt= "";
       Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
           DatosClt= rs1.getString(5) +" "+ rs1.getString(6) + " "+rs1.getString(2)+" " +rs1.getString(3);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatosClt;
    }
   public String datosClt2(String id)
    { DefaultTableModel modelo1 = new DefaultTableModel();
       
       String sql1 ="SELECT * FROM  tbl_clientes WHERE 	IdCliente ="+ id+"";
       String DatosClt= "";
       Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
           DatosClt= rs1.getString(9);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatosClt;
    }
   public String datosClt3(String id)
    { DefaultTableModel modelo1 = new DefaultTableModel();
       
       String sql1 ="SELECT * FROM  tbl_clientes WHERE 	IdCliente ="+ id+"";
       String DatosClt= "";
       Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
           DatosClt= rs1.getString(15);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatosClt;
    }
    public String datosAs(String id)
    { 
       
       String sql1 ="SELECT * FROM  tbl_aseguradora WHERE IdAseguradora ="+ id+"";
       String DatosAs= "";
       Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
           DatosAs= rs1.getString(2);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatosAs;
    }
    public String datosvd(String id)
    { 
       
       String sql1 ="SELECT * FROM  tbl_vida WHERE NoPoliza_vd ="+ id+"";
       String DatosVd= "";
       Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
           DatosVd= rs1.getString(2);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatosVd;
        
      
    }
     public String datosvd2(String id)
    { 
       
       String sql1 ="SELECT * FROM  tbl_aseguradora WHERE Nombre_as ='"+ id+"'";
       String DatosVd= "";
       Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
           DatosVd= rs1.getString(1);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatosVd;
        
      
    }
    
}
