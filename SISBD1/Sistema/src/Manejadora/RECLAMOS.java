
package Manejadora;
import Base_de_Datos.Busquedas;
import Base_de_Datos.Cliente;
import Base_de_Datos.Consultas;
import Base_de_Datos.Eliminar;
import Base_de_Datos.conexionBD;
import Base_de_Datos.Ingresos;
import java.sql.Connection;
import static java.lang.String.valueOf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import Base_de_Datos.Ingresos;
/**
 *
 * @author gganp
 */
public class RECLAMOS extends javax.swing.JInternalFrame {

    /*;
     * Creates new form RECLAMOS
     */
    
     int menu=0;
    int i =0;
    int Ingresos=0;
    int Cobros = 0;
     conexionBD cone = new conexionBD();
    Connection cne = cone.conexion();
     Consultas consulta = new Consultas();
    Busquedas src = new Busquedas();
    public static int tipo=0;
    Eliminar del =new Eliminar();
    Cliente cl = new Cliente();
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    public RECLAMOS() {
        initComponents();
    }
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

      
       TBLC_COBROS.setModel(modelo1);
       
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
            TBLC_COBROS.setModel(modelo1); 
            TBLC_COBROS.setModel(modelo1); 
            TBLC_COBROS.setModel(modelo1); 
            TBLC_COBROS.getColumnModel().getColumn(0).setPreferredWidth(75);
            TBLC_COBROS.getColumnModel().getColumn(1).setPreferredWidth(100);
            TBLC_COBROS.getColumnModel().getColumn(2).setPreferredWidth(120);
            TBLC_COBROS.getColumnModel().getColumn(3).setPreferredWidth(100);
            TBLC_COBROS.getColumnModel().getColumn(4).setPreferredWidth(150);
            TBLC_COBROS.getColumnModel().getColumn(5).setPreferredWidth(150);
            TBLC_COBROS.getColumnModel().getColumn(6).setPreferredWidth(80);
            TBLC_COBROS.getColumnModel().getColumn(7).setPreferredWidth(350);
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     
     public void mostrar_tabla3()
    { DefaultTableModel modelo1 = new DefaultTableModel();
       modelo1.addColumn("ID ClIENTE");
       modelo1.addColumn("POLIZA No.");
       modelo1.addColumn("CERTIFICADO No.");
       modelo1.addColumn("PLAN");
       modelo1.addColumn("COBERTURA");
       modelo1.addColumn("TIPO");
       modelo1.addColumn("CLIENTE");

      
       TBLC_COBROS.setModel(modelo1);
       
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
           
            TBLC_COBROS.setModel(modelo1); 
       
            TBLC_COBROS.getColumnModel().getColumn(0).setPreferredWidth(75);
            TBLC_COBROS.getColumnModel().getColumn(1).setPreferredWidth(100);
            TBLC_COBROS.getColumnModel().getColumn(2).setPreferredWidth(120);
            TBLC_COBROS.getColumnModel().getColumn(3).setPreferredWidth(149);
            TBLC_COBROS.getColumnModel().getColumn(4).setPreferredWidth(149);
            TBLC_COBROS.getColumnModel().getColumn(5).setPreferredWidth(149);
            TBLC_COBROS.getColumnModel().getColumn(6).setPreferredWidth(299);
           
            
      
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
     TBLC_COBROS.setModel(modelo1); 
     TBLC_COBROS.getColumnModel().getColumn(0).setPreferredWidth(74);
     TBLC_COBROS.getColumnModel().getColumn(1).setPreferredWidth(99);
     TBLC_COBROS.getColumnModel().getColumn(2).setPreferredWidth(174);
     TBLC_COBROS.getColumnModel().getColumn(3).setPreferredWidth(356);
     TBLC_COBROS.getColumnModel().getColumn(4).setPreferredWidth(148);

        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
           TBLC_COBROS.setModel(modelo1); 
           TBLC_COBROS.setModel(modelo1); 
           TBLC_COBROS.getColumnModel().getColumn(0).setPreferredWidth(75);
           TBLC_COBROS.getColumnModel().getColumn(1).setPreferredWidth(147);
           TBLC_COBROS.getColumnModel().getColumn(2).setPreferredWidth(149);
           TBLC_COBROS.getColumnModel().getColumn(3).setPreferredWidth(249);
           TBLC_COBROS.getColumnModel().getColumn(4).setPreferredWidth(146);
           TBLC_COBROS.getColumnModel().getColumn(5).setPreferredWidth(149);
           TBLC_COBROS.getColumnModel().getColumn(6).setPreferredWidth(149);
           
            
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
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
           TblCV2.setModel(modelo1); 
            TblCV2.getColumnModel().getColumn(0).setPreferredWidth(299);
            TblCV2.getColumnModel().getColumn(1).setPreferredWidth(300);
      
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
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
            IIGM1DescTxt1.setText(rs.getString(7)); 
        }
          TblGM2.setModel(modelo1); 
       
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
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
           DESC_VD2.setText(rs.getString(8)); 
        }
          TBL_VD2.setModel(modelo1); 
          TBL_VD2.getColumnModel().getColumn(0).setPreferredWidth(299);
          TBL_VD2.getColumnModel().getColumn(1).setPreferredWidth(300);
           
      
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
            DESC_EE2.setText(rs.getString(8));
            modelo1.addRow(datos);
             }   
        }
          TBL_EE2.setModel(modelo1); 
          TBL_EE2.getColumnModel().getColumn(0).setPreferredWidth(200);
          TBL_EE2.getColumnModel().getColumn(1).setPreferredWidth(320);
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        public void cv4(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Reclamo");  
       modelo1.addColumn("Id Poliza");
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Id Cliente");
       modelo1.addColumn("Tipo"); 
       modelo1.addColumn("Descripcion"); 
       String sql ="SELECT * FROM tbl_reclamos_vhl WHERE IdPolizaRcl_vhl = "+nopol+"";
       String datos[] = new String[6];
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
            modelo1.addRow(datos);
             
            
        }
           TBL_CBR.setModel(modelo1); 
    TBL_CBR.getColumnModel().getColumn(0).setPreferredWidth(75);
    TBL_CBR.getColumnModel().getColumn(1).setPreferredWidth(80);
    TBL_CBR.getColumnModel().getColumn(2).setPreferredWidth(105);
    TBL_CBR.getColumnModel().getColumn(3).setPreferredWidth(118);
    TBL_CBR.getColumnModel().getColumn(4).setPreferredWidth(123);
    TBL_CBR.getColumnModel().getColumn(5).setPreferredWidth(120);

        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
         public void cgm2(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Reclamo");  
       modelo1.addColumn("Id Poliza");
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Id Cliente");
       modelo1.addColumn("Tipo"); 
       modelo1.addColumn("Descripcion"); 
       String sql ="SELECT * FROM tbl_reclamos_gm WHERE IdPolizaRcl_gm="+nopol+"";
       String datos[] = new String[6];
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
            modelo1.addRow(datos);
             
            
        }
           TBL_CBR.setModel(modelo1); 
    TBL_CBR.getColumnModel().getColumn(0).setPreferredWidth(75);
    TBL_CBR.getColumnModel().getColumn(1).setPreferredWidth(80);
    TBL_CBR.getColumnModel().getColumn(2).setPreferredWidth(105);
    TBL_CBR.getColumnModel().getColumn(3).setPreferredWidth(118);
    TBL_CBR.getColumnModel().getColumn(4).setPreferredWidth(123);
    TBL_CBR.getColumnModel().getColumn(5).setPreferredWidth(120);
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
         public void cvd2(String nopol){

DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Reclamo");  
       modelo1.addColumn("Id Poliza");
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Id Cliente");
       modelo1.addColumn("Tipo"); 
       modelo1.addColumn("Descripcion"); 
       String sql ="SELECT * FROM tbl_reclamos_vd WHERE IdPolizaRcl_vd="+nopol+"";
       String datos[] = new String[6];
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
            modelo1.addRow(datos);
             
            
        }
           TBL_CBR.setModel(modelo1); 
    TBL_CBR.getColumnModel().getColumn(0).setPreferredWidth(75);
    TBL_CBR.getColumnModel().getColumn(1).setPreferredWidth(80);
    TBL_CBR.getColumnModel().getColumn(2).setPreferredWidth(105);
    TBL_CBR.getColumnModel().getColumn(3).setPreferredWidth(118);
    TBL_CBR.getColumnModel().getColumn(4).setPreferredWidth(123);
    TBL_CBR.getColumnModel().getColumn(5).setPreferredWidth(120);
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
         public void cee2(String nopol){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
     
       modelo1.addColumn("Id Reclamo");  
       modelo1.addColumn("Id Poliza");
       modelo1.addColumn("Fecha de pago");
       modelo1.addColumn("Id Cliente");
       modelo1.addColumn("Tipo"); 
       modelo1.addColumn("Descripcion"); 
       String sql ="SELECT * FROM tbl_reclamos_ee WHERE IdPolizaRcl_ee="+nopol+"";
       String datos[] = new String[6];
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
            modelo1.addRow(datos);
             
            
        }
           TBL_CBR.setModel(modelo1); 
    TBL_CBR.getColumnModel().getColumn(0).setPreferredWidth(75);
    TBL_CBR.getColumnModel().getColumn(1).setPreferredWidth(80);
    TBL_CBR.getColumnModel().getColumn(2).setPreferredWidth(105);
    TBL_CBR.getColumnModel().getColumn(3).setPreferredWidth(118);
    TBL_CBR.getColumnModel().getColumn(4).setPreferredWidth(123);
    TBL_CBR.getColumnModel().getColumn(5).setPreferredWidth(120);
          
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
          public void ingresoReclamosV(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_vhl`("
                +" `IdPolizaRcl_vhl`,`FechaRcl_vhl`, `ClienteRcl_vhl`, "
                +"`TipoPolizaRcl_vhl`, `DescripcionRcl_vhl`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
            public void ingresoReclamosGM(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_gm`("
                +" `IdPolizaRcl_gm`,`FechaRcl_gm`, `ClienteRcl_gm`, "
                +"`TipoPolizaRcl_gm`, `DescripcionRcl_gm`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
                  public void ingresoReclamosEE(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_ee`("
                +" `IdPolizaRcl_ee`,`FechaRcl_ee`, `ClienteRcl_ee`, "
                +"`TipoPolizaRcl_ee`, `DescripcionRcl_ee`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
      public void ingresoReclamosVD(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_vd`("
                +" `IdPolizaRcl_vd`,`FechaRcl_vd`, `ClienteRcl_vd`, "
                +"`TipoPolizaRcl_vd`, `DescripcionRcl_vd`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        COBRO = new javax.swing.JTabbedPane();
        MENU3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        VehiculosMenuBtn1 = new javax.swing.JButton();
        GastosMedMenuBtn1 = new javax.swing.JButton();
        EquiposMenuBtn1 = new javax.swing.JButton();
        SegVidaBtn1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        MENU2 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        IngresosMenu2Btn = new javax.swing.JButton();
        EliminarMenu2Btn = new javax.swing.JButton();
        ConsultaMenu2Btn = new javax.swing.JButton();
        ModificacionMenu2Btn = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        CerrarSesionMenu2Btn = new javax.swing.JButton();
        SalirMenu2Btn = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        COBROS = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        IV2IngresarPBtn = new javax.swing.JButton();
        FECHA_COBRO = new javax.swing.JTextField();
        IV2AtrasBtn1 = new javax.swing.JButton();
        IV2AtrasBtn2 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        TEL_CTO1 = new javax.swing.JTextArea();
        C_GM1 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TBLC_COBROS = new javax.swing.JTable();
        CGM2VolverBtn4 = new javax.swing.JButton();
        C_GM2 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        CGM2VolverBtn = new javax.swing.JButton();
        CGM2AtrasBtn = new javax.swing.JButton();
        CGMSalirBtn = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn1 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        TblGM2 = new javax.swing.JTable();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        IIGM1DescTxt1 = new javax.swing.JTextArea();
        jPanel46 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        CGM2VolverBtn2 = new javax.swing.JButton();
        CGM2AtrasBtn2 = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn2 = new javax.swing.JButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        TBL_VD2 = new javax.swing.JTable();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        DESC_VD2 = new javax.swing.JTextArea();
        C_VEHICULOS2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblCV2 = new javax.swing.JTable();
        CGM2AtrasBtn6 = new javax.swing.JButton();
        CGM2VolverBtn3 = new javax.swing.JButton();
        C_GM4 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        CGM2VolverBtn1 = new javax.swing.JButton();
        CGM2AtrasBtn3 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn3 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        TBL_EE2 = new javax.swing.JTable();
        jLabel89 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        DESC_EE2 = new javax.swing.JTextArea();
        C_GM3 = new javax.swing.JPanel();
        CGM2AtrasBtn1 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TBL_CBR = new javax.swing.JTable();
        CGM2AtrasBtn4 = new javax.swing.JButton();
        CGM2AtrasBtn5 = new javax.swing.JButton();

        setClosable(true);
        setTitle("RECLAMOS");

        COBRO.setBackground(new java.awt.Color(255, 204, 102));
        COBRO.setForeground(new java.awt.Color(255, 255, 255));
        COBRO.setEnabled(false);

        MENU3.setBackground(new java.awt.Color(255, 204, 102));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setOpaque(false);

        VehiculosMenuBtn1.setBackground(new java.awt.Color(0, 0, 0));
        VehiculosMenuBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        VehiculosMenuBtn1.setForeground(new java.awt.Color(255, 255, 255));
        VehiculosMenuBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/coche (1).png"))); // NOI18N
        VehiculosMenuBtn1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        VehiculosMenuBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculosMenuBtnActionPerformed(evt);
            }
        });

        GastosMedMenuBtn1.setBackground(new java.awt.Color(0, 0, 0));
        GastosMedMenuBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        GastosMedMenuBtn1.setForeground(new java.awt.Color(255, 255, 255));
        GastosMedMenuBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/botiquin-de-primeros-auxilios (2).png"))); // NOI18N
        GastosMedMenuBtn1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        GastosMedMenuBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GastosMedMenuBtnActionPerformed(evt);
            }
        });

        EquiposMenuBtn1.setBackground(new java.awt.Color(0, 0, 0));
        EquiposMenuBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        EquiposMenuBtn1.setForeground(new java.awt.Color(255, 255, 255));
        EquiposMenuBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/maquinaria.png"))); // NOI18N
        EquiposMenuBtn1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EquiposMenuBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquiposMenuBtnActionPerformed(evt);
            }
        });

        SegVidaBtn1.setBackground(new java.awt.Color(0, 0, 0));
        SegVidaBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        SegVidaBtn1.setForeground(new java.awt.Color(255, 255, 255));
        SegVidaBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/corazon (3).png"))); // NOI18N
        SegVidaBtn1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        SegVidaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegVidaBtnActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(0, 0, 51));
        jLabel21.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("VEHICULOS");
        jLabel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel62.setBackground(new java.awt.Color(0, 0, 51));
        jLabel62.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("EQUIPOS");
        jLabel62.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel65.setBackground(new java.awt.Color(0, 0, 51));
        jLabel65.setFont(new java.awt.Font("Segoe UI Historic", 1, 26)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("GASTOS MEDICOS");
        jLabel65.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel81.setBackground(new java.awt.Color(0, 0, 51));
        jLabel81.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("SEG. DE VIDA");
        jLabel81.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EquiposMenuBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(VehiculosMenuBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GastosMedMenuBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SegVidaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GastosMedMenuBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175))
                            .addComponent(SegVidaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(VehiculosMenuBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(EquiposMenuBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel12.setBackground(new java.awt.Color(0, 0, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI Historic", 1, 40)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Menú");
        jLabel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout MENU3Layout = new javax.swing.GroupLayout(MENU3);
        MENU3.setLayout(MENU3Layout);
        MENU3Layout.setHorizontalGroup(
            MENU3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU3Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
            .addGroup(MENU3Layout.createSequentialGroup()
                .addGap(468, 468, 468)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MENU3Layout.setVerticalGroup(
            MENU3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        COBRO.addTab("MENU", MENU3);

        MENU2.setBackground(new java.awt.Color(255, 204, 102));

        jPanel25.setBackground(new java.awt.Color(0, 0, 0));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel25.setOpaque(false);

        IngresosMenu2Btn.setBackground(new java.awt.Color(0, 0, 0));
        IngresosMenu2Btn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IngresosMenu2Btn.setForeground(new java.awt.Color(255, 255, 255));
        IngresosMenu2Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/disquete (2).png"))); // NOI18N
        IngresosMenu2Btn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        IngresosMenu2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresosMenu2BtnActionPerformed(evt);
            }
        });

        EliminarMenu2Btn.setBackground(new java.awt.Color(0, 0, 0));
        EliminarMenu2Btn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        EliminarMenu2Btn.setForeground(new java.awt.Color(255, 255, 255));
        EliminarMenu2Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/boton-eliminar.png"))); // NOI18N
        EliminarMenu2Btn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EliminarMenu2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarMenu2BtnActionPerformed(evt);
            }
        });

        ConsultaMenu2Btn.setBackground(new java.awt.Color(0, 0, 0));
        ConsultaMenu2Btn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        ConsultaMenu2Btn.setForeground(new java.awt.Color(255, 255, 255));
        ConsultaMenu2Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/enfocar (2).png"))); // NOI18N
        ConsultaMenu2Btn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ConsultaMenu2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaMenu2BtnActionPerformed(evt);
            }
        });

        ModificacionMenu2Btn.setBackground(new java.awt.Color(0, 0, 0));
        ModificacionMenu2Btn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        ModificacionMenu2Btn.setForeground(new java.awt.Color(255, 255, 255));
        ModificacionMenu2Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/goma-de-borrar.png"))); // NOI18N
        ModificacionMenu2Btn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ModificacionMenu2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificacionMenu2BtnActionPerformed(evt);
            }
        });

        jLabel75.setBackground(new java.awt.Color(0, 0, 51));
        jLabel75.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("INGRESO");
        jLabel75.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel76.setBackground(new java.awt.Color(0, 0, 51));
        jLabel76.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("ELIMINACION");
        jLabel76.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel77.setBackground(new java.awt.Color(0, 0, 51));
        jLabel77.setFont(new java.awt.Font("Segoe UI Historic", 1, 31)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("MODIFICAR");
        jLabel77.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel78.setBackground(new java.awt.Color(0, 0, 51));
        jLabel78.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("CONSULTA");
        jLabel78.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IngresosMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConsultaMenu2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(ModificacionMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EliminarMenu2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(EliminarMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConsultaMenu2Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(IngresosMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ModificacionMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        CerrarSesionMenu2Btn.setBackground(new java.awt.Color(0, 0, 51));
        CerrarSesionMenu2Btn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CerrarSesionMenu2Btn.setForeground(new java.awt.Color(255, 255, 255));
        CerrarSesionMenu2Btn.setText("CERRAR SESIÓN");
        CerrarSesionMenu2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionMenu2BtnActionPerformed(evt);
            }
        });

        SalirMenu2Btn.setBackground(new java.awt.Color(51, 0, 0));
        SalirMenu2Btn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        SalirMenu2Btn.setForeground(new java.awt.Color(255, 255, 255));
        SalirMenu2Btn.setText("SALIR");
        SalirMenu2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirMenu2BtnActionPerformed(evt);
            }
        });

        jLabel79.setBackground(new java.awt.Color(0, 0, 51));
        jLabel79.setFont(new java.awt.Font("Segoe UI Historic", 1, 40)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Menú");
        jLabel79.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout MENU2Layout = new javax.swing.GroupLayout(MENU2);
        MENU2.setLayout(MENU2Layout);
        MENU2Layout.setHorizontalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU2Layout.createSequentialGroup()
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(697, 697, 697))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU2Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SalirMenu2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CerrarSesionMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );
        MENU2Layout.setVerticalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CerrarSesionMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SalirMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        COBRO.addTab("MENU 2", MENU2);

        COBROS.setBackground(new java.awt.Color(255, 204, 102));

        jLabel57.setBackground(new java.awt.Color(0, 0, 51));
        jLabel57.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("INGRESO DE RECLAMOS");
        jLabel57.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel29.setBackground(new java.awt.Color(0, 0, 51));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel29.setOpaque(false);

        jLabel126.setBackground(new java.awt.Color(0, 0, 51));
        jLabel126.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("DESCRPCION");
        jLabel126.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel121.setBackground(new java.awt.Color(0, 0, 51));
        jLabel121.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 0));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("FECHA DE RECLAMO");
        jLabel121.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2IngresarPBtn.setBackground(new java.awt.Color(0, 0, 0));
        IV2IngresarPBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2IngresarPBtn.setForeground(new java.awt.Color(255, 255, 255));
        IV2IngresarPBtn.setText("INGRESAR RECLAMO");
        IV2IngresarPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2IngresarPBtnActionPerformed(evt);
            }
        });

        FECHA_COBRO.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        FECHA_COBRO.setForeground(new java.awt.Color(0, 0, 51));
        FECHA_COBRO.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IV2AtrasBtn1.setBackground(new java.awt.Color(0, 0, 0));
        IV2AtrasBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2AtrasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        IV2AtrasBtn1.setText("ATRAS");
        IV2AtrasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2AtrasBtn1ActionPerformed(evt);
            }
        });

        IV2AtrasBtn2.setBackground(new java.awt.Color(0, 0, 0));
        IV2AtrasBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2AtrasBtn2.setForeground(new java.awt.Color(255, 255, 255));
        IV2AtrasBtn2.setText("ACTUALIZAR");
        IV2AtrasBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2AtrasBtn2ActionPerformed(evt);
            }
        });

        TEL_CTO1.setColumns(20);
        TEL_CTO1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        TEL_CTO1.setRows(5);
        jScrollPane20.setViewportView(TEL_CTO1);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IV2AtrasBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IV2IngresarPBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(IV2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FECHA_COBRO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FECHA_COBRO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IV2IngresarPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IV2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IV2AtrasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout COBROSLayout = new javax.swing.GroupLayout(COBROS);
        COBROS.setLayout(COBROSLayout);
        COBROSLayout.setHorizontalGroup(
            COBROSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(COBROSLayout.createSequentialGroup()
                .addGroup(COBROSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(COBROSLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(COBROSLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        COBROSLayout.setVerticalGroup(
            COBROSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(COBROSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        COBRO.addTab("RECLAMOS", COBROS);

        C_GM1.setBackground(new java.awt.Color(255, 204, 102));
        C_GM1.setPreferredSize(new java.awt.Dimension(1530, 950));

        jLabel67.setBackground(new java.awt.Color(0, 0, 51));
        jLabel67.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("SELECCION DE POLIZA");
        jLabel67.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TBLC_COBROS.setBackground(new java.awt.Color(0, 0, 51));
        TBLC_COBROS.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBLC_COBROS.setForeground(new java.awt.Color(255, 255, 255));
        TBLC_COBROS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBLC_COBROS.setAlignmentX(1.0F);
        TBLC_COBROS.setAlignmentY(1.0F);
        TBLC_COBROS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBLC_COBROS.setGridColor(new java.awt.Color(0, 153, 204));
        TBLC_COBROS.setRowHeight(30);
        TBLC_COBROS.setSelectionBackground(new java.awt.Color(0, 102, 204));
        TBLC_COBROS.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TBLC_COBROS.setShowVerticalLines(false);
        TBLC_COBROS.getTableHeader().setReorderingAllowed(false);
        TBLC_COBROS.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TBLC_COBROSAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TBLC_COBROS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLC_COBROSMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(TBLC_COBROS);

        CGM2VolverBtn4.setBackground(new java.awt.Color(0, 0, 0));
        CGM2VolverBtn4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2VolverBtn4.setForeground(new java.awt.Color(255, 255, 255));
        CGM2VolverBtn4.setText("VOLVER A MENÚ");
        CGM2VolverBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2VolverBtn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout C_GM1Layout = new javax.swing.GroupLayout(C_GM1);
        C_GM1.setLayout(C_GM1Layout);
        C_GM1Layout.setHorizontalGroup(
            C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM1Layout.createSequentialGroup()
                .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(620, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CGM2VolverBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        C_GM1Layout.setVerticalGroup(
            C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(CGM2VolverBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        COBRO.addTab("CONSULTA", C_GM1);

        C_GM2.setBackground(new java.awt.Color(255, 204, 102));

        jLabel68.setBackground(new java.awt.Color(0, 0, 51));
        jLabel68.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("GASTOS MEDICOS");
        jLabel68.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CGM2VolverBtn.setBackground(new java.awt.Color(0, 0, 0));
        CGM2VolverBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2VolverBtn.setForeground(new java.awt.Color(255, 255, 255));
        CGM2VolverBtn.setText("VOLVER A MENÚ");
        CGM2VolverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2VolverBtnActionPerformed(evt);
            }
        });

        CGM2AtrasBtn.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn.setText("ATRAS");
        CGM2AtrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtnActionPerformed(evt);
            }
        });

        CGMSalirBtn.setBackground(new java.awt.Color(51, 0, 0));
        CGMSalirBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMSalirBtn.setForeground(new java.awt.Color(255, 255, 255));
        CGMSalirBtn.setText("SALIR");
        CGMSalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMSalirBtnActionPerformed(evt);
            }
        });

        jLabel69.setBackground(new java.awt.Color(0, 0, 51));
        jLabel69.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("INFORMACION");
        jLabel69.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV2CoberturasyCobBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CV2CoberturasyCobBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2CoberturasyCobBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CV2CoberturasyCobBtn1.setText("CONTINUAR");
        CV2CoberturasyCobBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2CoberturasyCobBtn1ActionPerformed(evt);
            }
        });

        TblGM2.setBackground(new java.awt.Color(0, 0, 51));
        TblGM2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblGM2.setForeground(new java.awt.Color(255, 255, 255));
        TblGM2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblGM2.setAlignmentX(1.0F);
        TblGM2.setAlignmentY(1.0F);
        TblGM2.setColumnSelectionAllowed(true);
        TblGM2.setEnabled(false);
        TblGM2.setGridColor(new java.awt.Color(0, 102, 204));
        TblGM2.setRowHeight(30);
        TblGM2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane9.setViewportView(TblGM2);

        jLabel88.setBackground(new java.awt.Color(0, 0, 51));
        jLabel88.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 0));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("DESCRIPCION COBERTURAS");
        jLabel88.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IIGM1DescTxt1.setColumns(20);
        IIGM1DescTxt1.setRows(5);
        jScrollPane15.setViewportView(IIGM1DescTxt1);

        javax.swing.GroupLayout C_GM2Layout = new javax.swing.GroupLayout(C_GM2);
        C_GM2.setLayout(C_GM2Layout);
        C_GM2Layout.setHorizontalGroup(
            C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(C_GM2Layout.createSequentialGroup()
                                .addGap(0, 381, Short.MAX_VALUE)
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(C_GM2Layout.createSequentialGroup()
                                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane15))
                                .addGap(26, 26, 26)
                                .addComponent(CV2CoberturasyCobBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(47, 47, 47))
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CGMSalirBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CGM2AtrasBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CGM2VolverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(412, 412, 412))
        );
        C_GM2Layout.setVerticalGroup(
            C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM2Layout.createSequentialGroup()
                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CV2CoberturasyCobBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(CGM2VolverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGMSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        COBRO.addTab("GASTOS MED", C_GM2);

        jPanel46.setBackground(new java.awt.Color(255, 204, 102));
        jPanel46.setMaximumSize(new java.awt.Dimension(1530, 943));
        jPanel46.setPreferredSize(new java.awt.Dimension(1530, 943));

        jLabel94.setBackground(new java.awt.Color(0, 0, 51));
        jLabel94.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("SEGUROS DE VIDA");
        jLabel94.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CGM2VolverBtn2.setBackground(new java.awt.Color(0, 0, 0));
        CGM2VolverBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2VolverBtn2.setForeground(new java.awt.Color(255, 255, 255));
        CGM2VolverBtn2.setText("VOLVER A MENÚ");
        CGM2VolverBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2VolverBtn2ActionPerformed(evt);
            }
        });

        CGM2AtrasBtn2.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn2.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn2.setText("ATRAS");
        CGM2AtrasBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn2ActionPerformed(evt);
            }
        });

        jLabel96.setBackground(new java.awt.Color(0, 0, 51));
        jLabel96.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 0, 0));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("INFORMACION");
        jLabel96.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV2CoberturasyCobBtn2.setBackground(new java.awt.Color(0, 0, 0));
        CV2CoberturasyCobBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2CoberturasyCobBtn2.setForeground(new java.awt.Color(255, 255, 255));
        CV2CoberturasyCobBtn2.setText("CONTINUAR");
        CV2CoberturasyCobBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2CoberturasyCobBtn2ActionPerformed(evt);
            }
        });

        TBL_VD2.setBackground(new java.awt.Color(0, 0, 51));
        TBL_VD2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_VD2.setForeground(new java.awt.Color(255, 255, 255));
        TBL_VD2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_VD2.setAlignmentX(1.0F);
        TBL_VD2.setAlignmentY(1.0F);
        TBL_VD2.setEnabled(false);
        TBL_VD2.setGridColor(new java.awt.Color(0, 102, 204));
        TBL_VD2.setRowHeight(30);
        TBL_VD2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane25.setViewportView(TBL_VD2);

        jLabel98.setBackground(new java.awt.Color(0, 0, 51));
        jLabel98.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 0, 0));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("DESCRIPCION COBERTURAS");
        jLabel98.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DESC_VD2.setColumns(20);
        DESC_VD2.setRows(5);
        jScrollPane26.setViewportView(DESC_VD2);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(473, 1062, Short.MAX_VALUE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CGM2AtrasBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CGM2VolverBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CV2CoberturasyCobBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                        .addGap(427, 427, 427))))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(CGM2VolverBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CV2CoberturasyCobBtn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        COBRO.addTab("VIDA", jPanel46);

        C_VEHICULOS2.setBackground(new java.awt.Color(255, 204, 102));

        jLabel16.setBackground(new java.awt.Color(0, 0, 51));
        jLabel16.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("VEHICULOS");
        jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV2CoberturasyCobBtn.setBackground(new java.awt.Color(0, 0, 0));
        CV2CoberturasyCobBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2CoberturasyCobBtn.setForeground(new java.awt.Color(255, 255, 255));
        CV2CoberturasyCobBtn.setText("CONTINUAR");
        CV2CoberturasyCobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2CoberturasyCobBtnActionPerformed(evt);
            }
        });

        TblCV2.setBackground(new java.awt.Color(0, 0, 0));
        TblCV2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TblCV2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCV2.setForeground(new java.awt.Color(255, 255, 255));
        TblCV2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCV2.setAlignmentX(1.0F);
        TblCV2.setAlignmentY(1.0F);
        TblCV2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCV2.setColumnSelectionAllowed(true);
        TblCV2.setRowHeight(30);
        TblCV2.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TblCV2);

        CGM2AtrasBtn6.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn6.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn6.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn6.setText("ATRAS");
        CGM2AtrasBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn6ActionPerformed(evt);
            }
        });

        CGM2VolverBtn3.setBackground(new java.awt.Color(0, 0, 0));
        CGM2VolverBtn3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2VolverBtn3.setForeground(new java.awt.Color(255, 255, 255));
        CGM2VolverBtn3.setText("VOLVER A MENÚ");
        CGM2VolverBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2VolverBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout C_VEHICULOS2Layout = new javax.swing.GroupLayout(C_VEHICULOS2);
        C_VEHICULOS2.setLayout(C_VEHICULOS2Layout);
        C_VEHICULOS2Layout.setHorizontalGroup(
            C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(681, 681, 681))
            .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CV2CoberturasyCobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CGM2AtrasBtn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CGM2VolverBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(423, 423, 423))
        );
        C_VEHICULOS2Layout.setVerticalGroup(
            C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                .addGroup(C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                                .addComponent(CGM2VolverBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CGM2AtrasBtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(CV2CoberturasyCobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        COBRO.addTab("VEHICULOS", C_VEHICULOS2);

        C_GM4.setBackground(new java.awt.Color(255, 204, 102));

        jLabel70.setBackground(new java.awt.Color(0, 0, 51));
        jLabel70.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 0));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("EQUIPO ELECTRONICO");
        jLabel70.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CGM2VolverBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGM2VolverBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2VolverBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGM2VolverBtn1.setText("VOLVER A MENÚ");
        CGM2VolverBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2VolverBtn1ActionPerformed(evt);
            }
        });

        CGM2AtrasBtn3.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn3.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn3.setText("ATRAS");
        CGM2AtrasBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn3ActionPerformed(evt);
            }
        });

        jLabel71.setBackground(new java.awt.Color(0, 0, 51));
        jLabel71.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("INFORMACION");
        jLabel71.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV2CoberturasyCobBtn3.setBackground(new java.awt.Color(0, 0, 0));
        CV2CoberturasyCobBtn3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2CoberturasyCobBtn3.setForeground(new java.awt.Color(255, 255, 255));
        CV2CoberturasyCobBtn3.setText("CONTINUAR");
        CV2CoberturasyCobBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2CoberturasyCobBtn3ActionPerformed(evt);
            }
        });

        TBL_EE2.setBackground(new java.awt.Color(0, 0, 51));
        TBL_EE2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_EE2.setForeground(new java.awt.Color(255, 255, 255));
        TBL_EE2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_EE2.setAlignmentX(1.0F);
        TBL_EE2.setAlignmentY(1.0F);
        TBL_EE2.setColumnSelectionAllowed(true);
        TBL_EE2.setEnabled(false);
        TBL_EE2.setGridColor(new java.awt.Color(0, 102, 204));
        TBL_EE2.setRowHeight(30);
        TBL_EE2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane11.setViewportView(TBL_EE2);

        jLabel89.setBackground(new java.awt.Color(0, 0, 51));
        jLabel89.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 0, 0));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("DESCRIPCION COBERTURAS");
        jLabel89.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DESC_EE2.setColumns(20);
        DESC_EE2.setRows(5);
        jScrollPane16.setViewportView(DESC_EE2);

        javax.swing.GroupLayout C_GM4Layout = new javax.swing.GroupLayout(C_GM4);
        C_GM4.setLayout(C_GM4Layout);
        C_GM4Layout.setHorizontalGroup(
            C_GM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM4Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(C_GM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, C_GM4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, C_GM4Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(C_GM4Layout.createSequentialGroup()
                        .addGroup(C_GM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CV2CoberturasyCobBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)))
                .addGroup(C_GM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CGM2AtrasBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CGM2VolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(412, 412, 412))
        );
        C_GM4Layout.setVerticalGroup(
            C_GM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM4Layout.createSequentialGroup()
                .addGroup(C_GM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_GM4Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(CGM2VolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(CV2CoberturasyCobBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        COBRO.addTab("EQUIPO ELECTRONICO", C_GM4);

        C_GM3.setBackground(new java.awt.Color(255, 204, 102));

        CGM2AtrasBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn1.setText("ATRAS");
        CGM2AtrasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn1ActionPerformed(evt);
            }
        });

        jLabel82.setBackground(new java.awt.Color(204, 102, 0));
        jLabel82.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("RECLAMOS");

        TBL_CBR.setBackground(new java.awt.Color(0, 0, 51));
        TBL_CBR.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_CBR.setForeground(new java.awt.Color(255, 255, 255));
        TBL_CBR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_CBR.setAlignmentX(1.0F);
        TBL_CBR.setAlignmentY(1.0F);
        TBL_CBR.setRowHeight(30);
        TBL_CBR.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TBL_CBR.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setViewportView(TBL_CBR);

        CGM2AtrasBtn4.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn4.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn4.setText("MODIFICAR");
        CGM2AtrasBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn4ActionPerformed(evt);
            }
        });

        CGM2AtrasBtn5.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn5.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn5.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn5.setText("ELIMINAR");
        CGM2AtrasBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout C_GM3Layout = new javax.swing.GroupLayout(C_GM3);
        C_GM3.setLayout(C_GM3Layout);
        C_GM3Layout.setHorizontalGroup(
            C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM3Layout.createSequentialGroup()
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CGM2AtrasBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CGM2AtrasBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(599, Short.MAX_VALUE))
        );
        C_GM3Layout.setVerticalGroup(
            C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM3Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CGM2AtrasBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CGM2AtrasBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(261, Short.MAX_VALUE))
        );

        COBRO.addTab("C. COBROS", C_GM3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(COBRO, javax.swing.GroupLayout.PREFERRED_SIZE, 1332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(COBRO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VehiculosMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculosMenuBtnActionPerformed
        menu =1;
        Ingresos = 0;
        COBRO.setSelectedIndex(1);
    }//GEN-LAST:event_VehiculosMenuBtnActionPerformed

    private void GastosMedMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GastosMedMenuBtnActionPerformed
        menu =2;
        Ingresos = 0;
        COBRO.setSelectedIndex(1);
    }//GEN-LAST:event_GastosMedMenuBtnActionPerformed

    private void EquiposMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquiposMenuBtnActionPerformed
        menu =3;
        Ingresos = 0;
        COBRO.setSelectedIndex(1);
    }//GEN-LAST:event_EquiposMenuBtnActionPerformed

    private void SegVidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SegVidaBtnActionPerformed
        menu =4;
        Ingresos = 0;
        COBRO.setSelectedIndex(1);
    }//GEN-LAST:event_SegVidaBtnActionPerformed

    private void IngresosMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosMenu2BtnActionPerformed
        Ingresos = 1;
        IV2AtrasBtn2.setEnabled(false);
        IV2IngresarPBtn.setEnabled(true);
        switch(menu)
        {
            case 1:
            mostrar_tabla2();
            COBRO.setSelectedIndex(3); break;
            case 2:
            mostrar_tabla3();
            COBRO.setSelectedIndex(3);break;
            case 3:
            mostrar_tabla7();
            COBRO.setSelectedIndex(3); break;
            case 4:
            mostrar_tabla6();
            COBRO.setSelectedIndex(3); break;
        }

    }//GEN-LAST:event_IngresosMenu2BtnActionPerformed

    private void EliminarMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMenu2BtnActionPerformed
        switch(menu)
        {
            case 1:
            mostrar_tabla2();
            COBRO.setSelectedIndex(3); break;
            case 2:
            mostrar_tabla3();
            COBRO.setSelectedIndex(3);break;
            case 3:
            mostrar_tabla7();
            COBRO.setSelectedIndex(3); break;
            case 4:
            mostrar_tabla6();
            COBRO.setSelectedIndex(3); break;
        }
    }//GEN-LAST:event_EliminarMenu2BtnActionPerformed

    private void ConsultaMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaMenu2BtnActionPerformed
        switch(menu)
        {
            case 1:
            mostrar_tabla2();
            COBRO.setSelectedIndex(3);break;
            case 2:
            mostrar_tabla3();
            COBRO.setSelectedIndex(3); break;
            case 3:
            mostrar_tabla7();
            COBRO.setSelectedIndex(3); break;
            case 4:
            mostrar_tabla6();
            COBRO.setSelectedIndex(3); break;
        }
    }//GEN-LAST:event_ConsultaMenu2BtnActionPerformed

    private void ModificacionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificacionMenu2BtnActionPerformed

        switch(menu)
        {
            case 1:
            mostrar_tabla2();

            COBRO.setSelectedIndex(3);break;
            case 2:
            mostrar_tabla3();
            COBRO.setSelectedIndex(3); break;
            case 3:
            mostrar_tabla7();
            COBRO.setSelectedIndex(3);break;
            case 4:
            mostrar_tabla6();
            COBRO.setSelectedIndex(3);break;
        }
    }//GEN-LAST:event_ModificacionMenu2BtnActionPerformed

    private void CerrarSesionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionMenu2BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CerrarSesionMenu2BtnActionPerformed

    private void SalirMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirMenu2BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirMenu2BtnActionPerformed

    private void IV2IngresarPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2IngresarPBtnActionPerformed
        
        if(FECHA_COBRO.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- No Requerimiento.\n- Fecha.");
        }else{
            switch(menu)
            {
                case 1:
                mostrar_tabla2();
                ingresoReclamosV(TblCV2.getValueAt(2, 1).toString(),TblCV2.getValueAt(7, 1).toString(),"Vehiculos");
                COBRO.setSelectedIndex(3);
                break;
                
                case 2:
                mostrar_tabla3();
                ingresoReclamosGM(TblGM2.getValueAt(2, 1).toString(),TblGM2.getValueAt(1, 1).toString(),"Gastos Medicos");
                COBRO.setSelectedIndex(3); break;
                
                case 3:
                ingresoReclamosEE(TBLC_COBROS.getValueAt(TBLC_COBROS.getSelectedRow(),1).toString(),TBLC_COBROS.getValueAt(TBLC_COBROS.getSelectedRow(),0).toString(),"Equipo Electronico");
                COBRO.setSelectedIndex(3);
                mostrar_tabla7();break;
                case 4:
                ingresoReclamosVD(TBL_VD2.getValueAt(2, 1).toString(),TBL_VD2.getValueAt(0, 1).toString(),"Vida");
                COBRO.setSelectedIndex(3);break;
            }}
    }//GEN-LAST:event_IV2IngresarPBtnActionPerformed

    private void IV2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2AtrasBtn1ActionPerformed
        COBRO.setSelectedIndex(3);
        i=0;
    }//GEN-LAST:event_IV2AtrasBtn1ActionPerformed

    private void IV2AtrasBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2AtrasBtn2ActionPerformed

        if( FECHA_COBRO.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- No Requerimiento.\n- Fecha.");
        }else{
            switch(menu)
            {
                case 1:
                try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                  String sql = "UPDATE tbl_reclamos_vhl SET "
                    + "FechaRcl_vhl='"+FECHA_COBRO.getText()
                    + "',DescripcionRcl_vhl='"+TEL_CTO1.getText()
                    + "' WHERE IdReclamo_vhl ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }

                int filavhl  = TBL_CBR.getSelectedRow();
                String NoPol;

                NoPol = valueOf(TBL_CBR.getValueAt(filavhl, 1));
                cv4(NoPol);
                COBRO.setSelectedIndex(8);break;

                case 2:

                try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "UPDATE tbl_reclamos_gm SET "
                    + "FechaRcl_gm='"+FECHA_COBRO.getText()
                    + "',DescripcionRcl_gm='"+TEL_CTO1.getText()
                    + "' WHERE IdReclamo_gm ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();

                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }
                int filagm  = TBL_CBR.getSelectedRow();
                String NoPolgm;

                NoPolgm = valueOf(TBL_CBR.getValueAt(filagm, 1));
                cgm2(NoPolgm);
                COBRO.setSelectedIndex(8);
                break;
                case 3:
                try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "UPDATE tbl_reclamos_ee SET "
                    + "FechaRcl_ee='"+FECHA_COBRO.getText()
                    + "',DescripcionRcl_ee='"+TEL_CTO1.getText()
                    + "' WHERE IdReclamo_ee ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();

                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }
                int filaee  = TBL_CBR.getSelectedRow();
                String NoPolee;

                NoPolee = valueOf(TBL_CBR.getValueAt(filaee, 1));
                cee2(NoPolee);
                COBRO.setSelectedIndex(8);
                break;
                case 4:
                try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                     String sql = "UPDATE tbl_reclamos_vd SET "
                    + "FechaRcl_vd='"+FECHA_COBRO.getText()
                    + "',DescripcionRcl_vd='"+TEL_CTO1.getText()
                    + "' WHERE IdReclamo_vd ="+id+"";


                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();

                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }
                int filavd  = TBL_CBR.getSelectedRow();
                String NoPolvd;

                NoPolvd = valueOf(TBL_CBR.getValueAt(filavd, 1));
                cvd2(NoPolvd);
                COBRO.setSelectedIndex(8);
                break;

            }
        }

    }//GEN-LAST:event_IV2AtrasBtn2ActionPerformed

    private void TBLC_COBROSAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TBLC_COBROSAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TBLC_COBROSAncestorAdded

    private void TBLC_COBROSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLC_COBROSMouseClicked

        switch(menu)
        {
            case 1:
            int filav  = TBLC_COBROS.getSelectedRow(); String Id;
            if (filav>=0){
                Id = valueOf(TBLC_COBROS.getValueAt(filav, 1));
                cv2(Id);
                COBRO.setSelectedIndex(6);
            }else{
                JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
            }
            break;
            case 2:
            int filagm  = TBLC_COBROS.getSelectedRow(); String Idgm;
            if (filagm>=0){
                Idgm = valueOf(TBLC_COBROS.getValueAt(filagm, 1));
                cgm(Idgm);
                COBRO.setSelectedIndex(4);
            }else{
                JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
            }
            break;
            case 3:
            int filaee  = TBLC_COBROS.getSelectedRow(); String Idee;
            if (filaee>=0){
                Idee = TBLC_COBROS.getValueAt(filaee, 1).toString();
                System.out.print(Idee);
                cee(Idee);
                COBRO.setSelectedIndex(7);
            }else{
                JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
            }

            break;
            case 4:
            int filavd  = TBLC_COBROS.getSelectedRow(); String Idvd;
            if (filavd>=0){
                Idvd = valueOf(TBLC_COBROS.getValueAt(filavd, 1));
                cvd(Idvd);
                COBRO.setSelectedIndex(5);
            }else{
                JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
            }
            mostrar_tabla7();
            break;
        }

    }//GEN-LAST:event_TBLC_COBROSMouseClicked

    private void CGM2VolverBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn4ActionPerformed
        COBRO.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn4ActionPerformed

    private void CGM2VolverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtnActionPerformed
        COBRO.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtnActionPerformed

    private void CGM2AtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtnActionPerformed
        COBRO.setSelectedIndex(3);
    }//GEN-LAST:event_CGM2AtrasBtnActionPerformed

    private void CGMSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMSalirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CGMSalirBtnActionPerformed

    private void CV2CoberturasyCobBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtn1ActionPerformed

        switch(Ingresos)
        {
            case 1:
            mostrar_tabla2();
            COBRO.setSelectedIndex(2); break;
            default:
            int fila  =TBLC_COBROS.getSelectedRow();
            String NoPol;
            if (fila>=0){
                NoPol = valueOf(TBLC_COBROS.getValueAt(fila, 1));
                cgm2(NoPol);

                COBRO.setSelectedIndex(8);
            }else{
                JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");break;
            }
        }

    }//GEN-LAST:event_CV2CoberturasyCobBtn1ActionPerformed

    private void CGM2VolverBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn2ActionPerformed
        COBRO.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn2ActionPerformed

    private void CGM2AtrasBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn2ActionPerformed
        COBRO.setSelectedIndex(3);
    }//GEN-LAST:event_CGM2AtrasBtn2ActionPerformed

    private void CV2CoberturasyCobBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtn2ActionPerformed

        switch(Ingresos)
        {
            case 1:
            mostrar_tabla2();
            COBRO.setSelectedIndex(2); break;
            default:
            String id = TBL_VD2.getValueAt(2,1).toString();
            cvd2(id);
            COBRO.setSelectedIndex(8);
        }

    }//GEN-LAST:event_CV2CoberturasyCobBtn2ActionPerformed

    private void CV2CoberturasyCobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtnActionPerformed
        switch(Ingresos)
        {
            case 1:
            mostrar_tabla2();
            COBRO.setSelectedIndex(2); break;
            default:
            String NoPol;
            NoPol = valueOf(TblCV2.getValueAt(2, 1));
            cv4(NoPol);
            COBRO.setSelectedIndex(8);
        }

    }//GEN-LAST:event_CV2CoberturasyCobBtnActionPerformed

    private void CGM2AtrasBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn6ActionPerformed
        COBRO.setSelectedIndex(3);
    }//GEN-LAST:event_CGM2AtrasBtn6ActionPerformed

    private void CGM2VolverBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn3ActionPerformed
        COBRO.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn3ActionPerformed

    private void CGM2VolverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn1ActionPerformed
        COBRO.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn1ActionPerformed

    private void CGM2AtrasBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn3ActionPerformed
        COBRO.setSelectedIndex(3);
    }//GEN-LAST:event_CGM2AtrasBtn3ActionPerformed

    private void CV2CoberturasyCobBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtn3ActionPerformed
        switch(Ingresos)
        {
            case 1:
            COBRO.setSelectedIndex(2); break;
            default:
            int fila  = TBLC_COBROS.getSelectedRow();
            String NoPol;
            if (fila>=0){
                NoPol = valueOf(TBLC_COBROS.getValueAt(fila, 1));

                cee2(NoPol);
                COBRO.setSelectedIndex(8);
            }else{
                JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
            }
        }

    }//GEN-LAST:event_CV2CoberturasyCobBtn3ActionPerformed

    private void CGM2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn1ActionPerformed
        COBRO.setSelectedIndex(3);
    }//GEN-LAST:event_CGM2AtrasBtn1ActionPerformed

    private void CGM2AtrasBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn4ActionPerformed
        if (menu==1){int fila= TBL_CBR.getSelectedRow();
            IV2AtrasBtn2.setEnabled(true);
            IV2IngresarPBtn.setEnabled(false);
            if(fila<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN RECLAMO");}else{
                TEL_CTO1.setText(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(), 5).toString());
                FECHA_COBRO.setText(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(), 2).toString());
                COBRO.setSelectedIndex(2);
              }}else{
            int fila= TBL_CBR.getSelectedRow();
            if(fila<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN RECLAMO");}else{
                TEL_CTO1.setText(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(), 5).toString());
                FECHA_COBRO.setText(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(), 2).toString());
                COBRO.setSelectedIndex(2);}
        }

    }//GEN-LAST:event_CGM2AtrasBtn4ActionPerformed

    private void CGM2AtrasBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn5ActionPerformed

        switch(menu)
        {
            case 1:
            try {

                if(TBL_CBR.getSelectedRow()<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN COBRO");}else{
                    String NoPol;
                    int filavhl  = TBL_CBR.getSelectedRow();
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "DELETE  FROM tbl_reclamos_vhl  WHERE IdReclamo_vhl ="+id+"";
                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ELIMINADO");
                    NoPol = valueOf(TBL_CBR.getValueAt(filavhl, 1));
                    cv4(NoPol);
                    COBRO.setSelectedIndex(8);}

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case 2:

            try {
                int filagm  = TBL_CBR.getSelectedRow();
                String NoPolgm;
                if(filagm<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN COBRO");}else{
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "DELETE FROM tbl_reclamos_gm WHERE IdReclamo_gm ="+id+"";
                    COBRO.setSelectedIndex(8);
                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    NoPolgm = valueOf(TBL_CBR.getValueAt(filagm, 1));
                    cgm2(NoPolgm);
                    JOptionPane.showMessageDialog(null,"ELIMINADO");   }
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case 3:
            try {
                int filaee  = TBL_CBR.getSelectedRow();
                String NoPolee;
                if(filaee<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN COBRO");}else{

                    NoPolee = valueOf(TBL_CBR.getValueAt(filaee, 1));
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "DELETE FROM tbl_reclamos_ee WHERE IdReclamo_ee ="+id+"";
                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    cee2(NoPolee);
                    COBRO.setSelectedIndex(8);

                    JOptionPane.showMessageDialog(null,"ELIMINADO");}
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;
            case 4:
            try {
                int filavd  = TBL_CBR.getSelectedRow();
                String NoPolvd;
                if(filavd<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN COBRO");}else{
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "DELETE FROM tbl_reclamos_vd WHERE IdReclamo_vd ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    NoPolvd = valueOf(TBL_CBR.getValueAt(filavd, 1));
                    cvd2(NoPolvd);
                    COBRO.setSelectedIndex(8);

                    JOptionPane.showMessageDialog(null,"ELIMINADO");}
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

        }
    }//GEN-LAST:event_CGM2AtrasBtn5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CGM2AtrasBtn;
    private javax.swing.JButton CGM2AtrasBtn1;
    private javax.swing.JButton CGM2AtrasBtn2;
    private javax.swing.JButton CGM2AtrasBtn3;
    private javax.swing.JButton CGM2AtrasBtn4;
    private javax.swing.JButton CGM2AtrasBtn5;
    private javax.swing.JButton CGM2AtrasBtn6;
    private javax.swing.JButton CGM2VolverBtn;
    private javax.swing.JButton CGM2VolverBtn1;
    private javax.swing.JButton CGM2VolverBtn2;
    private javax.swing.JButton CGM2VolverBtn3;
    private javax.swing.JButton CGM2VolverBtn4;
    private javax.swing.JButton CGMSalirBtn;
    private javax.swing.JTabbedPane COBRO;
    private javax.swing.JPanel COBROS;
    private javax.swing.JButton CV2CoberturasyCobBtn;
    private javax.swing.JButton CV2CoberturasyCobBtn1;
    private javax.swing.JButton CV2CoberturasyCobBtn2;
    private javax.swing.JButton CV2CoberturasyCobBtn3;
    private javax.swing.JPanel C_GM1;
    private javax.swing.JPanel C_GM2;
    private javax.swing.JPanel C_GM3;
    private javax.swing.JPanel C_GM4;
    private javax.swing.JPanel C_VEHICULOS2;
    private javax.swing.JButton CerrarSesionMenu2Btn;
    private javax.swing.JButton ConsultaMenu2Btn;
    public static javax.swing.JTextArea DESC_EE2;
    public static javax.swing.JTextArea DESC_VD2;
    private javax.swing.JButton EliminarMenu2Btn;
    private javax.swing.JButton EquiposMenuBtn1;
    public static javax.swing.JTextField FECHA_COBRO;
    private javax.swing.JButton GastosMedMenuBtn1;
    public static javax.swing.JTextArea IIGM1DescTxt1;
    private javax.swing.JButton IV2AtrasBtn1;
    private javax.swing.JButton IV2AtrasBtn2;
    private javax.swing.JButton IV2IngresarPBtn;
    private javax.swing.JButton IngresosMenu2Btn;
    private javax.swing.JPanel MENU2;
    private javax.swing.JPanel MENU3;
    private javax.swing.JButton ModificacionMenu2Btn;
    private javax.swing.JButton SalirMenu2Btn;
    private javax.swing.JButton SegVidaBtn1;
    public static javax.swing.JTable TBLC_COBROS;
    public static javax.swing.JTable TBL_CBR;
    public static javax.swing.JTable TBL_EE2;
    public static javax.swing.JTable TBL_VD2;
    public static javax.swing.JTextArea TEL_CTO1;
    public static javax.swing.JTable TblCV2;
    public static javax.swing.JTable TblGM2;
    private javax.swing.JButton VehiculosMenuBtn1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
