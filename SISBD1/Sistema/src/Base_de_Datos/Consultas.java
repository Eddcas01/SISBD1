
package Base_de_Datos;

import Manejadora.PRINCIPAL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Consultas {
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    Cliente cl = new Cliente();
    /////////////////////////////////////////////////////////////////////////////////////
      public void mostrar_tabla1()
    { DefaultTableModel modelo1 = new DefaultTableModel();
     TableColumnModel mod = Manejadora.CLIENTES.TblCC1.getColumnModel();
     
     modelo1.addColumn("ID");  
     modelo1.addColumn("PRIMER APELLIDO");
       modelo1.addColumn("SEGUNDO APELLIDO");
       modelo1.addColumn("APELLDO DE CASADA");
       modelo1.addColumn("PRIMER NOMBRE");
       modelo1.addColumn("SEGUNDO NOMBRE");
       modelo1.addColumn("TERCER NOMBRE");
       modelo1.addColumn("No. DPI");
    
       
       String sql ="SELECT * FROM  tbl_clientes";
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
   ////////////////////////////////////////////////////////////////////////////////////////
  public void mostrar_tabla2()
    { DefaultTableModel modelo1 = new DefaultTableModel();
       modelo1.addColumn("ID ClIENTE");
       modelo1.addColumn("POLIZA No.");
       modelo1.addColumn("CERTIFICADO No.");
       modelo1.addColumn("PLACA");
       modelo1.addColumn("MARCA");
       modelo1.addColumn("LINEA");
       modelo1.addColumn("MODELO");
       modelo1.addColumn("CLIENTE ");

      
       Manejadora.VEHICULOS.TblCV1.setModel(modelo1);
       
       String sql ="SELECT * FROM  tbl_vehiculos";
      
    
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
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(3).setPreferredWidth(100);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(4).setPreferredWidth(150);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(5).setPreferredWidth(150);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(6).setPreferredWidth(80);
            Manejadora.VEHICULOS.TblCV1.getColumnModel().getColumn(7).setPreferredWidth(350);
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
  /////////////////////////////////////////////////////////////////////////////////////////
   public void mostrar_tabla3()
    { DefaultTableModel modelo1 = new DefaultTableModel();
       modelo1.addColumn("ID ClIENTE");
       modelo1.addColumn("POLIZA No.");
       modelo1.addColumn("CERTIFICADO No.");
       modelo1.addColumn("PLAN");
       modelo1.addColumn("COBERTURA");
       modelo1.addColumn("TIPO");
       modelo1.addColumn("CLIENTE");

      
       Manejadora.GASTOS_MEDICOS.TblGM1.setModel(modelo1);
       
       String sql ="SELECT * FROM  tbl_gastos_medicos";
      
    
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
    public void mostrar_tabla4(){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id ");
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Cargo");
       
    
       
       String sql ="SELECT * FROM tbl_contacto_aseguradora";
       String datos[] = new String[3];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
             datos[0]= rs.getString(1);
             datos[1]= rs.getString(2);
           
             datos[2]= rs.getString(4);
            
               
            modelo1.addRow(datos);
             
            
        }
     Manejadora.CONTACTO.TBL_CTO.setModel(modelo1); 
     Manejadora.CONTACTO.TBL_CTO.getColumnModel().getColumn(0).setPreferredWidth(75);
     Manejadora.CONTACTO.TBL_CTO.getColumnModel().getColumn(1).setPreferredWidth(356);
    Manejadora.CONTACTO.TBL_CTO.getColumnModel().getColumn(2).setPreferredWidth(200);
     

      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   public void mostrar_tabla5(){

       DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id ");
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Nit");

       String sql ="SELECT * FROM tbl_aseguradora";
       String datos[] = new String[3];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){   
             datos[0]= rs.getString(1);
             datos[1]= rs.getString(2);
             datos[2]= rs.getString(3);
            modelo1.addRow(datos);
             
            
        }
     Manejadora.ASEGURADORA.TBL_AS.setModel(modelo1); 
     Manejadora.ASEGURADORA.TBL_AS.getColumnModel().getColumn(0).setPreferredWidth(75);
     Manejadora.ASEGURADORA.TBL_AS.getColumnModel().getColumn(1).setPreferredWidth(356);
    Manejadora.ASEGURADORA.TBL_AS.getColumnModel().getColumn(2).setPreferredWidth(200);

        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void mostrar_tabla6(){

       DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id Cliente");
       modelo1.addColumn("Poliza");
       modelo1.addColumn("Aseguradora");
       modelo1.addColumn("Cliente");
       modelo1.addColumn("Estado");
    

       String sql ="SELECT * FROM tbl_Vida";
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
   ////////////////////////////////////////////////////////////////////////////////////////
   public void mostrar_tabla7()
    { DefaultTableModel modelo1 = new DefaultTableModel();
     
     modelo1.addColumn("ID");  
     modelo1.addColumn("POLIZA");
       modelo1.addColumn("CERTIFICADO");
       modelo1.addColumn("ASEGURADORA");
       modelo1.addColumn("FACTURA");
       modelo1.addColumn("SERIE");
       modelo1.addColumn("ESTADO");

    
       
       String sql ="SELECT * FROM  tbl_equipo_electronico";
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
   ///////////////////////////////////////////////////////////////////////////////////////
  public void cc2(String Id){
         
        int i =1, j =0;
       
        String[] Campo =new String[18]; 
        Campo[0] = "Id";
        Campo[1] = "1er. Apellido";
        Campo[2] = "2do. Apellido";
        Campo[3] = "Apellido de casada";
        Campo[4] = "1er. Nombre";
        Campo[5] = "2do. Nombre";
        Campo[6] = "3er. Nombre";
        Campo[7] = "Estado Civil";
        Campo[8] = "Dpi no.";
        Campo[9] = "Fecha de nacimiento";
        Campo[10] = "Edad";
        Campo[11] = "Profesion";
        Campo[12] = "Dir. Domicilio";
        Campo[13] = "Dir. Cobro";
        Campo[14] = "Nit";
        Campo[15] = "Tel. Casa";
        Campo[16] = "Tel. Oficina";
        Campo[17] = "Tel Celular";
        
       
           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("CLIENTE");  
       modelo1.addColumn("INFORMACION");
 
       String sql ="SELECT * FROM  tbl_clientes WHERE IdCliente="+Id+"";
       String datos[] = new String[2];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
             for(int k =0; k<18;k++){
             datos[0]= Campo[j];
            datos[1]= rs.getString(i);
            j++;
            i++;  
            modelo1.addRow(datos);
             }   
            
        }
           Manejadora.CLIENTES.TblCC2.setModel(modelo1); 
            Manejadora.CLIENTES.TblCC2.getColumnModel().getColumn(0).setPreferredWidth(269);
            Manejadora.CLIENTES.TblCC2.getColumnModel().getColumn(1).setPreferredWidth(270);
            
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   ////////////////////////////////////////////////////////////////////////////////////////
   public void cv2(String Id){
         
        int i =1, j =0;
       
        String[] Campo =new String[20]; 
        Campo[0] = "Aseguradora";
        Campo[1] = "Id poliza";
        Campo[2] = "No. poliza";
        Campo[3] = "No. Certificado";
        Campo[4] = "Vigencia Inicio";
        Campo[5] = "Vigencia Final";
        Campo[6] = "Contratante";
        Campo[7] = "Id Cliente";
        Campo[8] = "Asegurado";
        Campo[9] = "Dirreccion";
        Campo[10] = "Nit";
        Campo[11] = "Marca";
        Campo[12] = "Linea";
        Campo[13] = "Modelo";
        Campo[14] = "Placa";
        Campo[15] = "Color";
        Campo[16] = "No. Chasis";
        Campo[17] = "No. Motor";
        Campo[18] = "Pasajeros";
        Campo[19] = "Tipo Vehiculo";
     

           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("POLIZA");  
       modelo1.addColumn("INFORMACION");
 
       String sql ="SELECT * FROM tbl_vehiculos WHERE NoPoliza_vhl='"+Id+"'";
       String datos[] = new String[2];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
             for(int k =0; k<20;k++){
             datos[0]= Campo[j];
            datos[1]= rs.getString(i);
            j++;
            i++;  
            
            modelo1.addRow(datos);
             }   
            
        }
           Manejadora.VEHICULOS.TblCV2.setModel(modelo1); 
            Manejadora.VEHICULOS.TblCV2.getColumnModel().getColumn(0).setPreferredWidth(299);
            Manejadora.VEHICULOS.TblCV2.getColumnModel().getColumn(1).setPreferredWidth(300);
      
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   /////////////////////////////////////////////////////////////////////////////
   public void cv3(String Id){
         
        int i =23, j =0;
       
        String[] Campo =new String[9]; 
        
        Campo[0] = "SumaVehiculo";
        Campo[1] = "Suma RC";
        Campo[2] = "Deducible daños propios";
        Campo[3] = "Deducible Robo";
        Campo[4] = "Conductores menores";
        Campo[5] = "Conductores Mayores";
        Campo[6] = "Tarifa";
        Campo[7] = "Estado de la poliza";
        Campo[8] = "Cobertura";

           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("COBERTURA");  
       modelo1.addColumn("INFORMACION");
 
       String sql ="SELECT * FROM tbl_vehiculos WHERE NoPoliza_vhl="+Id+"";
       String datos[] = new String[2];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
             for(int k =0; k<9;k++){
             datos[0]= Campo[j];
            datos[1]= rs.getString(i);
            j++;
            i++;  
            if(i==31){
                i=21;
            }
            Manejadora.VEHICULOS.IV2Desc1.setText(rs.getString(22));
            modelo1.addRow(datos);
             }   
            
        }
           Manejadora.VEHICULOS.TblCV4.setModel(modelo1); 
            Manejadora.VEHICULOS.TblCV4.getColumnModel().getColumn(0).setPreferredWidth(260);
            Manejadora.VEHICULOS.TblCV4.getColumnModel().getColumn(1).setPreferredWidth(260);
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
   public void cv4(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Cliente");  
       modelo1.addColumn("Id Poliza");
       modelo1.addColumn("No. Poliza");
       modelo1.addColumn("No. Requerimiento");  
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Prima");  
       modelo1.addColumn("No. Pago");
       modelo1.addColumn("Estado");
    

       String sql ="SELECT * FROM tbl_cobros_vhl WHERE NoPoliza_cbr="+nopol+"";
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
             datos[7]= rs.getString(8);
            modelo1.addRow(datos);
             
            
        }
           Manejadora.VEHICULOS.TblCV3.setModel(modelo1); 
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(0).setPreferredWidth(75);
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(1).setPreferredWidth(80);
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(2).setPreferredWidth(105);
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(3).setPreferredWidth(118);
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(4).setPreferredWidth(123);
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(5).setPreferredWidth(120);
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(6).setPreferredWidth(100);
    Manejadora.VEHICULOS.TblCV3.getColumnModel().getColumn(7).setPreferredWidth(120);

          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   ////////////////////////////////////////////////////////////////////////////////////////////////
   public void cgm(String nopol){
         int i =1, j =0;
       
        String[] Campo =new String[13]; 
        Campo[0] = "Aseguradora";
        Campo[1] = "Id Cliente";
        Campo[2] = "No. Poliza";
        Campo[3] = "No. Certificado";
        Campo[4] = "Plan";
        Campo[5] = "Cobertura";
        Campo[6] = "Tipo de Poliza";
        Campo[7] = "Fecha efectiva Inicio";
        Campo[8] = "Fecha efectiva Final";
        Campo[9] = "Maximo Vitalicio";
        Campo[10] = "Suma asegurada Vida";
        Campo[11] = "Plan dental";
        Campo[12] = "Estado";

           DefaultTableModel modelo1 = new DefaultTableModel();

       modelo1.addColumn("POLIZA");  
       modelo1.addColumn("INFORMACION");
 
       String sql ="SELECT * FROM  tbl_gastos_medicos WHERE NoPoliza_gm='"+nopol+"'";
       String datos[] = new String[2];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
             for(int k =0; k<13;k++){
             datos[0]= Campo[j];
            datos[1]= rs.getString(i);
            j++;
            i++;  
            if(i==7){i=8;}
           
            modelo1.addRow(datos);
             }   
            Manejadora.GASTOS_MEDICOS.IIGM1DescTxt1.setText(rs.getString(7)); 
        }
          Manejadora.GASTOS_MEDICOS.TblGM2.setModel(modelo1); 
       
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
    //////////////////////////////////////////////////////////////////////////////////////
   public void cgm2(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Cliente");  
       modelo1.addColumn("No. Poliza");
       modelo1.addColumn("No. Requerimiento");  
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Prima");  
       modelo1.addColumn("No. Pago");
       modelo1.addColumn("Estado");

       String sql ="SELECT * FROM tbl_cobros_gm WHERE NoPoliza_cbrgm="+nopol+"";
       String datos[] = new String[7];
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
            modelo1.addRow(datos);
             
            
        }
           Manejadora.GASTOS_MEDICOS.TblCGM3.setModel(modelo1); 
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   //////////////////////////////////////////////////////////////////////////////////
   public void cgm3(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id Cliente");
       modelo1.addColumn("Id Familiar");
       modelo1.addColumn("No. Poliza");
       modelo1.addColumn("Fecha Inicio");  
       modelo1.addColumn("Fecha Fin"); 
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Fecha nacimiento");  
       modelo1.addColumn("Edad");
       modelo1.addColumn("Parentesco");
       
       
       String sql ="SELECT * FROM tbl_familiares WHERE NoPoliza_fm="+nopol+"";
       String datos[] = new String[9];
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
             datos[5]= rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+"  "+rs.getString(9);
             datos[6]= rs.getString(10);
             datos[7]= rs.getString(11);
             datos[8]= rs.getString(12);
            modelo1.addRow(datos);
             
            
        }
     Manejadora.GASTOS_MEDICOS.TblCGM4.setModel(modelo1); 
     Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(0).setPreferredWidth(75);
     Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(1).setPreferredWidth(80);
    Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(2).setPreferredWidth(105);
    Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(3).setPreferredWidth(118);
    Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(4).setPreferredWidth(118);
    Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(5).setPreferredWidth(300);
    Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(6).setPreferredWidth(118);
    Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(7).setPreferredWidth(45);
    Manejadora.GASTOS_MEDICOS.TblCGM4.getColumnModel().getColumn(8).setPreferredWidth(105);
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   //////////////////////////////////////////////////////////////////////////////////////
   public void mostrar_textfield4(String id){

       String sql ="SELECT * FROM tbl_contacto_aseguradora WHERE IdContacto="+id+"";
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
                Manejadora.CONTACTO.TEL_CTO1.setText(rs.getString(3));
  
        }
    
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   /////////////////////////////////////////////////////////////////////////////////////////
   public void mostrar_textfield5(String id){

       String sql ="SELECT * FROM tbl_aseguradora WHERE IdAseguradora="+id+"";
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
                Manejadora.ASEGURADORA.TEL_AS2.setText(rs.getString(4));
                Manejadora.ASEGURADORA.TEL_AS1.setText(rs.getString(5));
  
        }
    
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   ////////////////////////////////////////////////////////////////////////////////////////
    public void cvd(String nopol){
         int i =1, j =0;
       
        String[] Campo =new String[9]; 
        
        Campo[0] = "Id Cliente";
        Campo[1] = "Aseguradora";
        Campo[2] = "No. Poliza";
        Campo[3] = "Inicio";
        Campo[4] = "Fin";
        Campo[5] = "Suma Asegurada";
        Campo[6] = "Cobertura";
        Campo[7] = "Prima";
        Campo[8] = "Estado";
   
           DefaultTableModel modelo1 = new DefaultTableModel();

       modelo1.addColumn("POLIZA");  
       modelo1.addColumn("INFORMACION");
 
       String sql ="SELECT * FROM  tbl_vida WHERE NoPoliza_vd='"+nopol+"'";
       String datos[] = new String[2];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
             for(int k =0; k<9;k++){
              if(i==2){
            datos[0]= Campo[j];
            datos[1]= cl.datosAs(rs.getString(i));
            j++;
            i++;  
              }else{datos[0]= Campo[j];
            datos[1]= rs.getString(i);
            j++;
            i++;  
            if(i==8){i=9;}}
            
           
            modelo1.addRow(datos);
             }   
            Manejadora.VIDA.DESC_VD2.setText(rs.getString(8)); 
        }
          Manejadora.VIDA.TBL_VD2.setModel(modelo1); 
          Manejadora.VIDA.TBL_VD2.getColumnModel().getColumn(0).setPreferredWidth(299);
          Manejadora.VIDA.TBL_VD2.getColumnModel().getColumn(1).setPreferredWidth(300);
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public void cvd2(String nopol){


        DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id ");
       modelo1.addColumn("No. Poliza");
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Fecha nacimiento");  
       modelo1.addColumn("Dpi");
       modelo1.addColumn("Parentesco");
       
       
       String sql ="SELECT * FROM tbl_beneficiarios WHERE NoPolizaVd_bfs="+nopol+"";
       String datos[] = new String[6];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
             datos[0]= rs.getString(2);
             datos[1]= rs.getString(1);
             datos[2]= rs.getString(3);
             datos[3]= rs.getString(5);
             datos[4]= rs.getString(4);
             datos[5]= rs.getString(6);

            modelo1.addRow(datos);
             
            
        }
     Manejadora.VIDA.TBL_BENEFICIARIOS.setModel(modelo1); 
     Manejadora.VIDA.TBL_BENEFICIARIOS.getColumnModel().getColumn(0).setPreferredWidth(75);
     Manejadora.VIDA.TBL_BENEFICIARIOS.getColumnModel().getColumn(1).setPreferredWidth(80);
    Manejadora.VIDA.TBL_BENEFICIARIOS.getColumnModel().getColumn(2).setPreferredWidth(300);
    Manejadora.VIDA.TBL_BENEFICIARIOS.getColumnModel().getColumn(3).setPreferredWidth(100);
    Manejadora.VIDA.TBL_BENEFICIARIOS.getColumnModel().getColumn(4).setPreferredWidth(100);
    Manejadora.VIDA.TBL_BENEFICIARIOS.getColumnModel().getColumn(5).setPreferredWidth(300);
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
      public void cvd3(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Cliente");  
       modelo1.addColumn("No. Poliza");
       modelo1.addColumn("No. Requerimiento");  
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Prima");  
       modelo1.addColumn("Años");
       modelo1.addColumn("Estado");

       String sql ="SELECT * FROM tbl_cobros_vd WHERE NoPoliza_cbrvd="+nopol+"";
       String datos[] = new String[7];
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
            modelo1.addRow(datos);
             
            
        }
           Manejadora.VIDA.TBL_CBR_VIDA.setModel(modelo1); 
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
   public void cee(String Id){
        int i =1, j =0;
        String[] Campo =new String[12]; 
        Campo[0] = "Aseguradora";
        Campo[1] = "Poliza";
        Campo[3] = "Certificado";
        Campo[2] = "Cliente";
        Campo[4] = "Inicio";
        Campo[5] = "Fin";
        Campo[6] = "Cobertura";
        Campo[7] = "Factura";
        Campo[8] = "Serie";
        Campo[9] = "Suma Asegurada";
        Campo[10] = "Deducible robo";
        Campo[11] = "Estado";
           DefaultTableModel modelo1 = new DefaultTableModel();
       modelo1.addColumn("CAMPO");  
       modelo1.addColumn("INFORMACION");
       String sql ="SELECT * FROM tbl_equipo_electronico WHERE NoPoliza_ee="+Id+"";
       String datos[] = new String[2];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
             for(int k =0; k<12;k++){
             if (i==1){
            datos[0]= Campo[j];
            datos[1]= cl.datosAs(rs.getString(i));
            j++;
            i++;}else
             {
             if (i==3){
            datos[0]= Campo[j];
            datos[1]= cl.datosClt(rs.getString(i));
            j++;
            i++;  }else
             {
             datos[0]= Campo[j];
            datos[1]= rs.getString(i);
            j++;
            i++;  
            if(i==8){
                i=9;
            }
            }
            }
            Manejadora.EQUIPO_E.DESC_EE2.setText(rs.getString(8));
            modelo1.addRow(datos);
             }   
        }
           Manejadora.EQUIPO_E.TBL_EE2.setModel(modelo1); 
            Manejadora.EQUIPO_E.TBL_EE2.getColumnModel().getColumn(0).setPreferredWidth(200);
            Manejadora.EQUIPO_E.TBL_EE2.getColumnModel().getColumn(1).setPreferredWidth(320);
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void cee2(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Cliente");  
       modelo1.addColumn("No. Poliza");
       modelo1.addColumn("No. Requerimiento");  
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Prima");  
       modelo1.addColumn("numero de pago");
       modelo1.addColumn("Estado");

       String sql ="SELECT * FROM tbl_cobros_ee WHERE NoPoliza_cbree="+nopol+"";
       String datos[] = new String[7];
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
            modelo1.addRow(datos);
             
            
        }
           Manejadora.EQUIPO_E.TBL_EE3.setModel(modelo1); 
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
