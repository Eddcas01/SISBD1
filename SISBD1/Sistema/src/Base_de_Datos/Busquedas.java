
package Base_de_Datos;

import Manejadora.PRINCIPAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Busquedas {
    
 conexionBD con = new conexionBD();
 Connection cn = con.conexion();
 Cliente cl = new Cliente();
    
    
      
      
      
      public String Campo2 (String campo){
       String bus="";
       if (campo.equals("Id")){bus="IdCliente";}else{
       if (campo.equals("1er.Nombre")){bus="Nombre1_clt";}else{ 
           if (campo.equals("2do.Nombre")){bus="Nombre2_clt";}else{
            if (campo.equals("3er.Nombre")){bus="Nombre3_clt";}else{
            if (campo.equals("1er.Apellido")){bus="Apellido1_clt";}else{
            if (campo.equals("2do.Apellido")){bus="Apellido2_clt";}
            else{JOptionPane.showMessageDialog(null, "ERROR ");}}}}}}
      
       return bus;
    }
      
      
      public String Campo3 (String campo){
       String bus="";
       if (campo.equals("Id")){bus="IdCliente_vhl";}else{
       if (campo.equals("Poliza")){bus="NoPoliza_vhl";}else{ 
           if (campo.equals("Placa")){bus="Placa_vhl";}else{
            if (campo.equals("Marca")){bus="Marca_vhl";}else{
            if (campo.equals("Linea")){bus="Linea_vhl";}else{
            if (campo.equals("Modelo")){bus="Modelo_vhl";}else{
            if (campo.equals("Cliente")){bus="Asegurado_vhl";}else{
           JOptionPane.showMessageDialog(null, "ERROR ");}}}}}}}
      
       return bus;
    }
      
      
      public String Campo4 (String campo){
       String bus="";
       if (campo.equals("Id")){bus="IdCliente_gm";}else{
       if (campo.equals("Poliza")){bus="NoPoliza_gm";}else{ 
           if (campo.equals("Certificado")){bus="NoCertificado_gm";}else{
            if (campo.equals("plan")){bus="NombrePlan_gm";}else{
            if (campo.equals("Cobertura")){bus="Cobertura_gm";}else{
            if (campo.equals("Tipo")){bus="TipoPoliza_gm";}else{
           
           JOptionPane.showMessageDialog(null, "ERROR ");}}}}}}
      
       return bus;
    }
      
      public void Buscar1(String campo,String Buscar){ DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");  
     modelo1.addColumn("PRIMER APELLIDO");
       modelo1.addColumn("SEGUNDO APELLIDO");
       modelo1.addColumn("APELLDO DE CASADA");
       modelo1.addColumn("PRIMER NOMBRE");
       modelo1.addColumn("SEGUNDO NOMBRE");
       modelo1.addColumn("TERCER NOMBRE");
       modelo1.addColumn("No. DPI");
       modelo1.addColumn("EDAD");
       modelo1.addColumn("NIT");
       modelo1.addColumn("TEL. CASA");
       modelo1.addColumn("TEL. OFICINA");
       modelo1.addColumn("TEL.CELULAR");
       Manejadora.CLIENTES.TblCC1.setModel(modelo1);
      
       String sql ="SELECT * FROM  tbl_clientes WHERE "+campo+" = '"+Buscar+"'";
      
       String datos[] = new String[8];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){  
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            datos[6]= rs.getString(7);
            datos[7]= rs.getString(9);
            modelo1.addRow(datos);
        }
           Manejadora.CLIENTES.TblCC1.setModel(modelo1); 
            Manejadora.CLIENTES.TblCC1.setModel(modelo1); 
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(0).setPreferredWidth(75);
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(1).setPreferredWidth(150);
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(2).setPreferredWidth(149);
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(3).setPreferredWidth(149);
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(4).setPreferredWidth(149);
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(5).setPreferredWidth(149);
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(6).setPreferredWidth(149);
            Manejadora.CLIENTES.TblCC1.getColumnModel().getColumn(7).setPreferredWidth(149);
            
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
      
      public void Buscar2(String campo,String Buscar){ DefaultTableModel modelo1 = new DefaultTableModel();
       
         modelo1.addColumn("ID ClIENTE");
       modelo1.addColumn("POLIZA No.");
       modelo1.addColumn("CERTIFICADO No.");
       modelo1.addColumn("PLACA");
       modelo1.addColumn("MARCA");
       modelo1.addColumn("LINEA");
       modelo1.addColumn("MODELO");
       modelo1.addColumn("CLIENTE ");

      
       Manejadora.VEHICULOS.TblCV1.setModel(modelo1);
       
       String sql ="SELECT * FROM  tbl_vehiculos WHERE "+campo+"='"+Buscar+"'";
      
    
       String datos[] = new String[8];
       Statement st;
      
        try {
            st = cn.createStatement();
          
            ResultSet rs = st.executeQuery(sql);
           
            while(rs.next()){
            datos[0]= rs.getString(8);
            datos[1]= rs.getString(3);
            datos[2]= rs.getString(4);
            datos[3]= rs.getString(15);
            datos[4]= rs.getString(12);
            datos[5]= rs.getString(13);
            datos[6]= rs.getString(14);
            datos[7]=cl.datosClt(rs.getString(8));
            modelo1.addRow(datos);
        }
           Manejadora.VEHICULOS.TblCV1.setModel(modelo1); 
            Manejadora.VEHICULOS.TblCV1.setModel(modelo1); 
            Manejadora.VEHICULOS.TblCV1.setModel(modelo1); 
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(0).setPreferredWidth(75);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(1).setPreferredWidth(100);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(2).setPreferredWidth(120);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(3).setPreferredWidth(150);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(4).setPreferredWidth(150);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(5).setPreferredWidth(150);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(6).setPreferredWidth(80);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(7).setPreferredWidth(299);
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
      
      public  void Buscar3(String campo,String Buscar){ DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID ClIENTE");
       modelo1.addColumn("POLIZA No.");
       modelo1.addColumn("CERTIFICADO No.");
       modelo1.addColumn("PLAN");
       modelo1.addColumn("COBERTURA");
       modelo1.addColumn("TIPO");
       modelo1.addColumn("CLIENTE");

      
       Manejadora.GASTOS_MEDICOS.TblGM1.setModel(modelo1);
       
       String sql ="SELECT * FROM  tbl_gastos_medicos WHERE "+campo+"='"+Buscar+"'";
      
    
       String datos[] = new String[7];
       Statement st;
      
        try {
            st = cn.createStatement();
          
            ResultSet rs = st.executeQuery(sql);
           
            while(rs.next()){
            datos[0]= rs.getString(2);
            datos[1]= rs.getString(3);
            datos[2]= rs.getString(4);
            datos[3]= rs.getString(5);
            datos[4]= rs.getString(6);
            datos[5]= rs.getString(8);
            datos[6]= cl.datosClt(rs.getString(2));
          
            modelo1.addRow(datos);
        }
           Manejadora.GASTOS_MEDICOS.TblGM1.setModel(modelo1); 
            
       
            Manejadora.GASTOS_MEDICOS.TblGM1.getColumnModel().getColumn(0).setPreferredWidth(75);
            Manejadora.GASTOS_MEDICOS.TblGM1.getColumnModel().getColumn(1).setPreferredWidth(100);
            Manejadora.GASTOS_MEDICOS.TblGM1.getColumnModel().getColumn(2).setPreferredWidth(120);
            Manejadora.GASTOS_MEDICOS.TblGM1.getColumnModel().getColumn(3).setPreferredWidth(149);
            Manejadora.GASTOS_MEDICOS.TblGM1.getColumnModel().getColumn(4).setPreferredWidth(149);
            Manejadora.GASTOS_MEDICOS.TblGM1.getColumnModel().getColumn(5).setPreferredWidth(149);
            Manejadora.GASTOS_MEDICOS.TblGM1.getColumnModel().getColumn(6).setPreferredWidth(299);
           
            
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
      
      public void Busquedavd(String campo, String id){

       DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id Cliente");
       modelo1.addColumn("Poliza");
       modelo1.addColumn("Aseguradora");
       modelo1.addColumn("Cliente");
       modelo1.addColumn("Estado");
    
       if(campo.equals("IdAseguradora_vd"))
       {
           Cliente as = new Cliente();
           id =as.datosvd2(id);
           
       }
       String sql ="SELECT * FROM tbl_Vida WHERE "+campo+"='"+id+"'";
       String datos[] = new String[5];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){   
             datos[0]= rs.getString(1);
             datos[1]= rs.getString(3);
             datos[2]= cl.datosAs(rs.getString(2));
             datos[3]= cl.datosClt(rs.getString(1));
             datos[4]= rs.getString(10);
            modelo1.addRow(datos);
             
            
        }
     Manejadora.VIDA.TBL_VD.setModel(modelo1); 
     Manejadora.VIDA.TBL_VD.getColumnModel().getColumn(0).setPreferredWidth(74);
     Manejadora.VIDA.TBL_VD.getColumnModel().getColumn(1).setPreferredWidth(99);
    Manejadora.VIDA.TBL_VD.getColumnModel().getColumn(2).setPreferredWidth(174);
    Manejadora.VIDA.TBL_VD.getColumnModel().getColumn(3).setPreferredWidth(356);
    Manejadora.VIDA.TBL_VD.getColumnModel().getColumn(4).setPreferredWidth(148);

        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void Busquedaee(String campo, String nopol){
       DefaultTableModel modelo1 = new DefaultTableModel();
     
     modelo1.addColumn("ID");  
     modelo1.addColumn("POLIZA");
       modelo1.addColumn("CERTIFICADO");
       modelo1.addColumn("ASEGURADORA");
       modelo1.addColumn("FACTURA");
       modelo1.addColumn("SERIE");
       modelo1.addColumn("ESTADO");

    if(campo.equals("IdAseguradora_ee"))
       {
           Cliente as = new Cliente();
           nopol =as.datosvd2(nopol);
           
       }
       
       String sql ="SELECT * FROM  tbl_equipo_electronico WHERE "+campo+"="+nopol+"";
       String datos[] = new String[7];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            datos[0]= rs.getString(3);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(4);
            datos[3]= cl.datosAs(rs.getString(1));
            datos[4]= rs.getString(9);
            datos[5]= rs.getString(10);
            datos[6]= rs.getString(13);
            modelo1.addRow(datos);
        }
           Manejadora.EQUIPO_E.TBL_EE.setModel(modelo1); 
            Manejadora.EQUIPO_E.TBL_EE.setModel(modelo1); 
            Manejadora.EQUIPO_E.TBL_EE.getColumnModel().getColumn(0).setPreferredWidth(75);
            Manejadora.EQUIPO_E.TBL_EE.getColumnModel().getColumn(1).setPreferredWidth(147);
            Manejadora.EQUIPO_E.TBL_EE.getColumnModel().getColumn(2).setPreferredWidth(149);
            Manejadora.EQUIPO_E.TBL_EE.getColumnModel().getColumn(3).setPreferredWidth(249);
            Manejadora.EQUIPO_E.TBL_EE.getColumnModel().getColumn(4).setPreferredWidth(146);
            Manejadora.EQUIPO_E.TBL_EE.getColumnModel().getColumn(5).setPreferredWidth(149);
            Manejadora.EQUIPO_E.TBL_EE.getColumnModel().getColumn(6).setPreferredWidth(149);
           
            
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
      
}
