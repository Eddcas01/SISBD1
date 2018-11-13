/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadora;

import Base_de_Datos.Busquedas;
import Base_de_Datos.Cliente;
import Base_de_Datos.Consultas;
import Base_de_Datos.Eliminar;
import Base_de_Datos.Ingresos;
import Base_de_Datos.conexionBD;

import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author gganp
 */
public class VEHICULOS extends javax.swing.JInternalFrame {

    /**
     * Creates new form VEHICULOS
     */
    
     Consultas consulta = new Consultas();
    Busquedas src = new Busquedas();
    public static int tipo=0;
    
    Eliminar del =new Eliminar();
    Cliente cl = new Cliente();
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    public VEHICULOS() {
        initComponents();
        VEHICULOS.setEnabled(false);
         if(tipo==2){ModificacionMenu2Btn.setEnabled(false);
       EliminarMenu2Btn.setEnabled(false);
       CVModBtn1.setEnabled(false);
       CVElimBtn1.setEnabled(false);
       }
        mostrar_tabla1();
        consulta.mostrar_tabla2();

        
        IV1ComboBox.addItem("Automovil");
        IV1ComboBox.addItem("Pick Up");
        IV1ComboBox.addItem("Panel");
        IV1ComboBox.addItem("Camion");
        IV1ComboBox.addItem("Cabezal");
        IV1ComboBox.addItem("Microbus");
        IV1ComboBox.addItem("Moto");
        
        IV2TipoCoberturaCbx.addItem("Completo");
        IV2TipoCoberturaCbx.addItem("Solo Terceros");
        
        CM.addItem("Incluido");
        CM.addItem("No Incluido");
        
        Cm.addItem("Incluido");
        Cm.addItem("No Incluido");
        
        Cclt1ComboBox.addItem("Id");
        Cclt1ComboBox.addItem("1er.Nombre");
        Cclt1ComboBox.addItem("2do.Nombre");
        Cclt1ComboBox.addItem("3er.Nombre");
        Cclt1ComboBox.addItem("1er.Apellido");
        Cclt1ComboBox.addItem("2do.Apellido");
        
        CVBusquedaCbx.addItem("Id");
        CVBusquedaCbx.addItem("Poliza");
        CVBusquedaCbx.addItem("Placa");
        CVBusquedaCbx.addItem("Marca");
        CVBusquedaCbx.addItem("Linea");
        CVBusquedaCbx.addItem("Modelo");
        CVBusquedaCbx.addItem("Cliente");
        
        
    }
    
     public void mostrar_tabla1()
    { DefaultTableModel modelo1 = new DefaultTableModel();
     TableColumnModel mod = TblCC1.getColumnModel();
     
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
            TblCC1.setModel(modelo1); 
            TblCC1.setModel(modelo1); 
            TblCC1.getColumnModel().getColumn(0).setPreferredWidth(75);
            TblCC1.getColumnModel().getColumn(1).setPreferredWidth(150);
            TblCC1.getColumnModel().getColumn(2).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(3).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(4).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(5).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(6).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(7).setPreferredWidth(149);
           
            
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
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
           TblCC2.setModel(modelo1); 
            TblCC2.getColumnModel().getColumn(0).setPreferredWidth(269);
            TblCC2.getColumnModel().getColumn(1).setPreferredWidth(270);
            
           
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
       
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
       TblCC1.setModel(modelo1);
      
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
          TblCC1.setModel(modelo1); 
            TblCC1.setModel(modelo1); 
            TblCC1.getColumnModel().getColumn(0).setPreferredWidth(75);
           TblCC1.getColumnModel().getColumn(1).setPreferredWidth(150);
            TblCC1.getColumnModel().getColumn(2).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(3).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(4).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(5).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(6).setPreferredWidth(149);
            TblCC1.getColumnModel().getColumn(7).setPreferredWidth(149);
            
      
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VEHICULOS = new javax.swing.JTabbedPane();
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
        jLabel79 = new javax.swing.JLabel();
        C_CLIENTES1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Cclt1ComboBox = new javax.swing.JComboBox<>();
        Cclt1BusquedaTxt = new javax.swing.JTextField();
        CcltLimpiarBtn = new javax.swing.JButton();
        CcltBuscarBtn = new javax.swing.JButton();
        CcltSalirBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblCC1 = new javax.swing.JTable();
        C_CLIENTES2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Cclt2SalirBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblCC2 = new javax.swing.JTable();
        CcltModificarBtn = new javax.swing.JButton();
        I_VEHICULOS1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        IVAseguradoraTxt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        IVNoPolizaTxt = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        IVNoCertificadoTxt = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        IVVigenciaTxt = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        IVContratanteTxt = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        IVMotorNoTxt = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        IVPasajerosTxt = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        IVMarcaTxt = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        IVLineaTxt = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        IVModeloTxt = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        IVPlacaTxt = new javax.swing.JTextField();
        IVColorTxt = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        IVChasisNoTxt = new javax.swing.JTextField();
        IVAceptarBtn = new javax.swing.JButton();
        IVLimpiiarbtn = new javax.swing.JButton();
        IVNuevaPolizaBtn = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        IV1ComboBox = new javax.swing.JComboBox<>();
        IVIngresarCoberturasbtn = new javax.swing.JButton();
        IVVigenciaTxt1 = new javax.swing.JTextField();
        IVSalirBtn = new javax.swing.JButton();
        IVVolverMenuBtn = new javax.swing.JButton();
        IVAtrasBtn = new javax.swing.JButton();
        I_VEHICULOS2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        IV2SumaAVehiculoTxt = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        IV2SumaARCTxt = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        IV2DeducibleDañoPTxt = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        IV2DeducibleRoboTxt = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        IV2TarifaTxt = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        IV2TipoCoberturaCbx = new javax.swing.JComboBox<>();
        Cm = new javax.swing.JComboBox<>();
        CM = new javax.swing.JComboBox<>();
        jLabel129 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        IV2Desc = new javax.swing.JTextArea();
        jLabel123 = new javax.swing.JLabel();
        IV2EstadoPloTxt = new javax.swing.JTextField();
        IV2AtrasBtn = new javax.swing.JButton();
        C_VEHICULOS1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        CVBusquedaCbx = new javax.swing.JComboBox<>();
        CVBusquedaTxt = new javax.swing.JTextField();
        CVVolavermenuBtn = new javax.swing.JButton();
        CVLimpiarBtn = new javax.swing.JButton();
        CVBuscarBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblCV1 = new javax.swing.JTable();
        C_VEHICULOS2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn = new javax.swing.JButton();
        CV2SalirBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblCV2 = new javax.swing.JTable();
        CVModBtn1 = new javax.swing.JButton();
        CVElimBtn1 = new javax.swing.JButton();
        C_VEHICULOS3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        CV3SalirBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TblCV3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        TblCV4 = new javax.swing.JTable();
        jLabel131 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        IV2Desc1 = new javax.swing.JTextArea();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);
        setTitle("VEHICULOS");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeiconified(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        MENU2.setBackground(new java.awt.Color(0, 51, 102));

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
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("INGRESO");
        jLabel75.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel76.setBackground(new java.awt.Color(0, 0, 51));
        jLabel76.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("ELIMINACION");
        jLabel76.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel77.setBackground(new java.awt.Color(0, 0, 51));
        jLabel77.setFont(new java.awt.Font("Segoe UI Historic", 1, 28)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("MODIFICACION");
        jLabel77.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel78.setBackground(new java.awt.Color(0, 0, 51));
        jLabel78.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(51, 51, 51)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ModificacionMenu2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
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

        jLabel79.setBackground(new java.awt.Color(0, 0, 51));
        jLabel79.setFont(new java.awt.Font("Segoe UI Historic", 1, 40)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("VEHICULOS");
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
                        .addGap(302, 302, 302))))
        );
        MENU2Layout.setVerticalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        VEHICULOS.addTab("MENU", MENU2);

        C_CLIENTES1.setBackground(new java.awt.Color(0, 51, 102));
        C_CLIENTES1.setMaximumSize(new java.awt.Dimension(1517, 895));
        C_CLIENTES1.setPreferredSize(new java.awt.Dimension(1517, 895));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SELECCION DE CLIENTE");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Cclt1ComboBox.setBackground(new java.awt.Color(0, 0, 0));
        Cclt1ComboBox.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Cclt1ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cclt1ComboBoxActionPerformed(evt);
            }
        });

        Cclt1BusquedaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        Cclt1BusquedaTxt.setForeground(new java.awt.Color(0, 0, 51));
        Cclt1BusquedaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cclt1BusquedaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cclt1BusquedaTxtActionPerformed(evt);
            }
        });

        CcltLimpiarBtn.setBackground(new java.awt.Color(0, 0, 0));
        CcltLimpiarBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CcltLimpiarBtn.setForeground(new java.awt.Color(255, 255, 255));
        CcltLimpiarBtn.setText("LIMPIAR");
        CcltLimpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CcltLimpiarBtnActionPerformed(evt);
            }
        });

        CcltBuscarBtn.setBackground(new java.awt.Color(0, 0, 0));
        CcltBuscarBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CcltBuscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        CcltBuscarBtn.setText("BUSCAR ");
        CcltBuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CcltBuscarBtnActionPerformed(evt);
            }
        });

        CcltSalirBtn.setBackground(new java.awt.Color(51, 0, 0));
        CcltSalirBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CcltSalirBtn.setForeground(new java.awt.Color(255, 255, 255));
        CcltSalirBtn.setText("ATRAS");
        CcltSalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CcltSalirBtnActionPerformed(evt);
            }
        });

        TblCC1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCC1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCC1.setAlignmentX(1.0F);
        TblCC1.setAlignmentY(1.0F);
        TblCC1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCC1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TblCC1.setFillsViewportHeight(true);
        TblCC1.setName(""); // NOI18N
        TblCC1.setOpaque(false);
        TblCC1.setRequestFocusEnabled(false);
        TblCC1.setRowHeight(30);
        TblCC1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        TblCC1.getTableHeader().setReorderingAllowed(false);
        TblCC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblCC1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblCC1);

        javax.swing.GroupLayout C_CLIENTES1Layout = new javax.swing.GroupLayout(C_CLIENTES1);
        C_CLIENTES1.setLayout(C_CLIENTES1Layout);
        C_CLIENTES1Layout.setHorizontalGroup(
            C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_CLIENTES1Layout.createSequentialGroup()
                .addContainerGap(453, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374)
                .addComponent(CcltSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(C_CLIENTES1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_CLIENTES1Layout.createSequentialGroup()
                        .addGroup(C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cclt1BusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CcltBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cclt1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CcltLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        C_CLIENTES1Layout.setVerticalGroup(
            C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_CLIENTES1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_CLIENTES1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(CcltSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_CLIENTES1Layout.createSequentialGroup()
                        .addGroup(C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cclt1BusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cclt1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(C_CLIENTES1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CcltLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CcltBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(141, 141, 141))
        );

        VEHICULOS.addTab("C. CLIENTES 1", C_CLIENTES1);

        C_CLIENTES2.setBackground(new java.awt.Color(0, 51, 102));
        C_CLIENTES2.setMaximumSize(new java.awt.Dimension(1517, 895));

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CLIENTE SELECCIONADO");
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Cclt2SalirBtn.setBackground(new java.awt.Color(51, 0, 0));
        Cclt2SalirBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Cclt2SalirBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cclt2SalirBtn.setText("ATRAS");
        Cclt2SalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cclt2SalirBtnActionPerformed(evt);
            }
        });

        TblCC2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCC2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCC2.setAlignmentX(1.0F);
        TblCC2.setAlignmentY(1.0F);
        TblCC2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCC2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TblCC2.setFillsViewportHeight(true);
        TblCC2.setName(""); // NOI18N
        TblCC2.setOpaque(false);
        TblCC2.setRequestFocusEnabled(false);
        TblCC2.setRowHeight(30);
        TblCC2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        TblCC2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TblCC2);

        CcltModificarBtn.setBackground(new java.awt.Color(0, 0, 0));
        CcltModificarBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CcltModificarBtn.setForeground(new java.awt.Color(255, 255, 255));
        CcltModificarBtn.setText("ACEPTAR");
        CcltModificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CcltModificarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout C_CLIENTES2Layout = new javax.swing.GroupLayout(C_CLIENTES2);
        C_CLIENTES2.setLayout(C_CLIENTES2Layout);
        C_CLIENTES2Layout.setHorizontalGroup(
            C_CLIENTES2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_CLIENTES2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(C_CLIENTES2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_CLIENTES2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 536, Short.MAX_VALUE)
                        .addComponent(Cclt2SalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256))
                    .addGroup(C_CLIENTES2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(CcltModificarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        C_CLIENTES2Layout.setVerticalGroup(
            C_CLIENTES2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_CLIENTES2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(C_CLIENTES2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_CLIENTES2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(Cclt2SalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_CLIENTES2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(C_CLIENTES2Layout.createSequentialGroup()
                            .addComponent(CcltModificarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(156, 156, 156))
                        .addGroup(C_CLIENTES2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(148, 148, 148)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        VEHICULOS.addTab("C. CLIENTES 2", C_CLIENTES2);

        I_VEHICULOS1.setBackground(new java.awt.Color(0, 51, 102));
        I_VEHICULOS1.setPreferredSize(new java.awt.Dimension(1880, 824));

        jLabel8.setBackground(new java.awt.Color(0, 0, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("INGRESO VEHICULOS");
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel14.setBackground(new java.awt.Color(0, 0, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel14.setOpaque(false);

        jLabel27.setBackground(new java.awt.Color(0, 0, 51));
        jLabel27.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("DATOS DE PÓLIZA");
        jLabel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVAseguradoraTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVAseguradoraTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVAseguradoraTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel28.setBackground(new java.awt.Color(0, 0, 51));
        jLabel28.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("No. POLIZA");
        jLabel28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVNoPolizaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVNoPolizaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVNoPolizaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel33.setBackground(new java.awt.Color(0, 0, 51));
        jLabel33.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("No. CERTIFICADO");
        jLabel33.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVNoCertificadoTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVNoCertificadoTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVNoCertificadoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel34.setBackground(new java.awt.Color(0, 0, 51));
        jLabel34.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("VIGENCIA");
        jLabel34.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVVigenciaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVVigenciaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVVigenciaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel35.setBackground(new java.awt.Color(0, 0, 51));
        jLabel35.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CONTRATANTE");
        jLabel35.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVContratanteTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVContratanteTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVContratanteTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel46.setBackground(new java.awt.Color(0, 0, 51));
        jLabel46.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("MOTOR No.");
        jLabel46.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVMotorNoTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVMotorNoTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVMotorNoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel47.setBackground(new java.awt.Color(0, 0, 51));
        jLabel47.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("PASAJEROS");
        jLabel47.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVPasajerosTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVPasajerosTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVPasajerosTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel48.setBackground(new java.awt.Color(0, 0, 51));
        jLabel48.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("TIPO DE VEHICULO");
        jLabel48.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel49.setBackground(new java.awt.Color(0, 0, 51));
        jLabel49.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("MARCA");
        jLabel49.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVMarcaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVMarcaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVMarcaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel50.setBackground(new java.awt.Color(0, 0, 51));
        jLabel50.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("LINEA");
        jLabel50.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVLineaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVLineaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVLineaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel51.setBackground(new java.awt.Color(0, 0, 51));
        jLabel51.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("MODELO");
        jLabel51.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVModeloTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVModeloTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVModeloTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel52.setBackground(new java.awt.Color(0, 0, 51));
        jLabel52.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("PLACA");
        jLabel52.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVPlacaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVPlacaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVPlacaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IVColorTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVColorTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVColorTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel53.setBackground(new java.awt.Color(0, 0, 51));
        jLabel53.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("COLOR");
        jLabel53.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel54.setBackground(new java.awt.Color(0, 0, 51));
        jLabel54.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("CHASIS No.");
        jLabel54.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IVChasisNoTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVChasisNoTxt.setForeground(new java.awt.Color(0, 0, 51));
        IVChasisNoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IVAceptarBtn.setBackground(new java.awt.Color(0, 0, 0));
        IVAceptarBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IVAceptarBtn.setForeground(new java.awt.Color(255, 255, 255));
        IVAceptarBtn.setText("ACEPTAR");
        IVAceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVAceptarBtnActionPerformed(evt);
            }
        });

        IVLimpiiarbtn.setBackground(new java.awt.Color(0, 0, 0));
        IVLimpiiarbtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IVLimpiiarbtn.setForeground(new java.awt.Color(255, 255, 255));
        IVLimpiiarbtn.setText("LIMPIAR");
        IVLimpiiarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVLimpiiarbtnActionPerformed(evt);
            }
        });

        IVNuevaPolizaBtn.setBackground(new java.awt.Color(0, 0, 0));
        IVNuevaPolizaBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IVNuevaPolizaBtn.setForeground(new java.awt.Color(255, 255, 255));
        IVNuevaPolizaBtn.setText("ACTUALIZAR");
        IVNuevaPolizaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVNuevaPolizaBtnActionPerformed(evt);
            }
        });

        jLabel55.setBackground(new java.awt.Color(0, 0, 51));
        jLabel55.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("DATOS DEL VEHICULO");
        jLabel55.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel56.setBackground(new java.awt.Color(0, 0, 51));
        jLabel56.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("ASEGURADORA");
        jLabel56.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV1ComboBox.setBackground(new java.awt.Color(204, 204, 204));
        IV1ComboBox.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV1ComboBox.setMaximumRowCount(7);
        IV1ComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N

        IVIngresarCoberturasbtn.setBackground(new java.awt.Color(0, 0, 0));
        IVIngresarCoberturasbtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IVIngresarCoberturasbtn.setForeground(new java.awt.Color(255, 255, 255));
        IVIngresarCoberturasbtn.setText("COBERTURAS");
        IVIngresarCoberturasbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVIngresarCoberturasbtnActionPerformed(evt);
            }
        });

        IVVigenciaTxt1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IVVigenciaTxt1.setForeground(new java.awt.Color(0, 0, 51));
        IVVigenciaTxt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(IVAceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(IVLimpiiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IVAseguradoraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IVNoPolizaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IVNoCertificadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(IVVigenciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IVVigenciaTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IVContratanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IVNuevaPolizaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IVMarcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IVLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IVModeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IVPlacaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IVColorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IVChasisNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IVMotorNoTxt)
                                    .addComponent(IVPasajerosTxt)
                                    .addComponent(IV1ComboBox, 0, 250, Short.MAX_VALUE))))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IVIngresarCoberturasbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(IVMarcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IVLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IVModeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IVPlacaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(IVColorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IVChasisNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(IVMotorNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IVPasajerosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IV1ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IVAseguradoraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IVNoPolizaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IVNoCertificadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IVVigenciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IVVigenciaTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(IVContratanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(127, 127, 127)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IVAceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IVLimpiiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IVNuevaPolizaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IVIngresarCoberturasbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        IVSalirBtn.setBackground(new java.awt.Color(51, 0, 0));
        IVSalirBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IVSalirBtn.setForeground(new java.awt.Color(255, 255, 255));
        IVSalirBtn.setText("SALIR");
        IVSalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVSalirBtnActionPerformed(evt);
            }
        });

        IVVolverMenuBtn.setBackground(new java.awt.Color(0, 0, 0));
        IVVolverMenuBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IVVolverMenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        IVVolverMenuBtn.setText("VOLVER A MENÚ");
        IVVolverMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVVolverMenuBtnActionPerformed(evt);
            }
        });

        IVAtrasBtn.setBackground(new java.awt.Color(0, 0, 0));
        IVAtrasBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IVAtrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        IVAtrasBtn.setText("ATRAS");
        IVAtrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVAtrasBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout I_VEHICULOS1Layout = new javax.swing.GroupLayout(I_VEHICULOS1);
        I_VEHICULOS1.setLayout(I_VEHICULOS1Layout);
        I_VEHICULOS1Layout.setHorizontalGroup(
            I_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_VEHICULOS1Layout.createSequentialGroup()
                .addGroup(I_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_VEHICULOS1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(I_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IVSalirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IVVolverMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IVAtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(I_VEHICULOS1Layout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        I_VEHICULOS1Layout.setVerticalGroup(
            I_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_VEHICULOS1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(I_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(I_VEHICULOS1Layout.createSequentialGroup()
                        .addComponent(IVVolverMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(IVAtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(IVSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        VEHICULOS.addTab("I. VEHICULOS 1", I_VEHICULOS1);

        I_VEHICULOS2.setBackground(new java.awt.Color(0, 51, 102));

        jLabel15.setBackground(new java.awt.Color(0, 0, 51));
        jLabel15.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("INGRESO DE COBERTURAS");
        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel19.setBackground(new java.awt.Color(0, 0, 51));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel19.setOpaque(false);

        jLabel115.setBackground(new java.awt.Color(0, 0, 51));
        jLabel115.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("SUMA ASEGURADA VEHICULO");
        jLabel115.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2SumaAVehiculoTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IV2SumaAVehiculoTxt.setForeground(new java.awt.Color(0, 0, 51));
        IV2SumaAVehiculoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel116.setBackground(new java.awt.Color(0, 0, 51));
        jLabel116.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setText("SUMA ASEGURADA \"RC\"");
        jLabel116.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2SumaARCTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IV2SumaARCTxt.setForeground(new java.awt.Color(0, 0, 51));
        IV2SumaARCTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel117.setBackground(new java.awt.Color(0, 0, 51));
        jLabel117.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("DEDUCIBLE DE DAÑOS PROPIOS");
        jLabel117.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2DeducibleDañoPTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IV2DeducibleDañoPTxt.setForeground(new java.awt.Color(0, 0, 51));
        IV2DeducibleDañoPTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel118.setBackground(new java.awt.Color(0, 0, 51));
        jLabel118.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("DEDUCIBLE ROBO");
        jLabel118.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2DeducibleRoboTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IV2DeducibleRoboTxt.setForeground(new java.awt.Color(0, 0, 51));
        IV2DeducibleRoboTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel119.setBackground(new java.awt.Color(0, 0, 51));
        jLabel119.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("CONDUCTORES -21 Y +18");
        jLabel119.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel124.setBackground(new java.awt.Color(0, 0, 51));
        jLabel124.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setText("CONDUCTORES -18 Y +16");
        jLabel124.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel125.setBackground(new java.awt.Color(0, 0, 51));
        jLabel125.setFont(new java.awt.Font("Segoe UI Historic", 1, 17)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("TARIFA");
        jLabel125.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2TarifaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IV2TarifaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IV2TarifaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel127.setBackground(new java.awt.Color(0, 0, 51));
        jLabel127.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("TIPO DE COBERTURA");
        jLabel127.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2TipoCoberturaCbx.setBackground(new java.awt.Color(102, 102, 102));
        IV2TipoCoberturaCbx.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2TipoCoberturaCbx.setMaximumRowCount(2);
        IV2TipoCoberturaCbx.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N
        IV2TipoCoberturaCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2TipoCoberturaCbxActionPerformed(evt);
            }
        });

        Cm.setBackground(new java.awt.Color(102, 102, 102));
        Cm.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Cm.setMaximumRowCount(2);
        Cm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N
        Cm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmActionPerformed(evt);
            }
        });

        CM.setBackground(new java.awt.Color(102, 102, 102));
        CM.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CM.setMaximumRowCount(2);
        CM.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N
        CM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMActionPerformed(evt);
            }
        });

        jLabel129.setBackground(new java.awt.Color(0, 0, 51));
        jLabel129.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("DESCRIPCION DE COBERTURA");
        jLabel129.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2Desc.setColumns(20);
        IV2Desc.setRows(5);
        jScrollPane13.setViewportView(IV2Desc);

        jLabel123.setBackground(new java.awt.Color(0, 0, 51));
        jLabel123.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("ESTADO POLIZA");
        jLabel123.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2EstadoPloTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IV2EstadoPloTxt.setForeground(new java.awt.Color(0, 0, 51));
        IV2EstadoPloTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IV2SumaAVehiculoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IV2SumaARCTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IV2DeducibleDañoPTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IV2TipoCoberturaCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane13))
                .addGap(244, 244, 244)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IV2DeducibleRoboTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(118, 118, 118))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IV2TarifaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IV2EstadoPloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IV2TipoCoberturaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(IV2DeducibleRoboTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CM))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IV2EstadoPloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IV2TarifaTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(IV2SumaAVehiculoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IV2SumaARCTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IV2DeducibleDañoPTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(225, 225, 225))
        );

        IV2AtrasBtn.setBackground(new java.awt.Color(0, 0, 0));
        IV2AtrasBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2AtrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        IV2AtrasBtn.setText("ATRAS");
        IV2AtrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2AtrasBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout I_VEHICULOS2Layout = new javax.swing.GroupLayout(I_VEHICULOS2);
        I_VEHICULOS2.setLayout(I_VEHICULOS2Layout);
        I_VEHICULOS2Layout.setHorizontalGroup(
            I_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_VEHICULOS2Layout.createSequentialGroup()
                .addGroup(I_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(I_VEHICULOS2Layout.createSequentialGroup()
                        .addGap(495, 495, 495)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IV2AtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        I_VEHICULOS2Layout.setVerticalGroup(
            I_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_VEHICULOS2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(I_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IV2AtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        VEHICULOS.addTab("I VEHICULOS 2", I_VEHICULOS2);

        C_VEHICULOS1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel14.setBackground(new java.awt.Color(0, 0, 51));
        jLabel14.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CONSULTA POLIZAS VEHICULOS");
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CVBusquedaCbx.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CVBusquedaCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVBusquedaCbxActionPerformed(evt);
            }
        });

        CVBusquedaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CVBusquedaTxt.setForeground(new java.awt.Color(0, 0, 51));
        CVBusquedaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CVVolavermenuBtn.setBackground(new java.awt.Color(0, 0, 0));
        CVVolavermenuBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CVVolavermenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        CVVolavermenuBtn.setText("VOLVER A MENÚ");
        CVVolavermenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVVolavermenuBtnActionPerformed(evt);
            }
        });

        CVLimpiarBtn.setBackground(new java.awt.Color(0, 0, 0));
        CVLimpiarBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CVLimpiarBtn.setForeground(new java.awt.Color(255, 255, 255));
        CVLimpiarBtn.setText("LIMPIAR");
        CVLimpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVLimpiarBtnActionPerformed(evt);
            }
        });

        CVBuscarBtn.setBackground(new java.awt.Color(0, 0, 0));
        CVBuscarBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CVBuscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        CVBuscarBtn.setText("BUSCAR ");
        CVBuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVBuscarBtnActionPerformed(evt);
            }
        });

        TblCV1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TblCV1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCV1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCV1.setAlignmentX(1.0F);
        TblCV1.setAlignmentY(1.0F);
        TblCV1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCV1.setColumnSelectionAllowed(true);
        TblCV1.setRowHeight(30);
        TblCV1.getTableHeader().setReorderingAllowed(false);
        TblCV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblCV1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TblCV1);

        javax.swing.GroupLayout C_VEHICULOS1Layout = new javax.swing.GroupLayout(C_VEHICULOS1);
        C_VEHICULOS1.setLayout(C_VEHICULOS1Layout);
        C_VEHICULOS1Layout.setHorizontalGroup(
            C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_VEHICULOS1Layout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322)
                .addComponent(CVVolavermenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(C_VEHICULOS1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_VEHICULOS1Layout.createSequentialGroup()
                        .addGroup(C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CVBusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CVBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CVBusquedaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CVLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        C_VEHICULOS1Layout.setVerticalGroup(
            C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_VEHICULOS1Layout.createSequentialGroup()
                .addGroup(C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_VEHICULOS1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_VEHICULOS1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CVVolavermenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CVBusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CVBusquedaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(C_VEHICULOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CVLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CVBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        VEHICULOS.addTab("C. VEHICULOS 1", C_VEHICULOS1);

        C_VEHICULOS2.setBackground(new java.awt.Color(0, 51, 102));

        jLabel16.setBackground(new java.awt.Color(0, 0, 51));
        jLabel16.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("DATOS DE CERTIFICADO");
        jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV2CoberturasyCobBtn.setBackground(new java.awt.Color(0, 0, 0));
        CV2CoberturasyCobBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2CoberturasyCobBtn.setForeground(new java.awt.Color(255, 255, 255));
        CV2CoberturasyCobBtn.setText("VER COBERTURAS Y COBROS");
        CV2CoberturasyCobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2CoberturasyCobBtnActionPerformed(evt);
            }
        });

        CV2SalirBtn.setBackground(new java.awt.Color(51, 0, 0));
        CV2SalirBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2SalirBtn.setForeground(new java.awt.Color(255, 255, 255));
        CV2SalirBtn.setText("ATRAS");
        CV2SalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2SalirBtnActionPerformed(evt);
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

        CVModBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CVModBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CVModBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CVModBtn1.setText("MODIFICAR POLIZA");
        CVModBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVModBtn1ActionPerformed(evt);
            }
        });

        CVElimBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CVElimBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CVElimBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CVElimBtn1.setText("ELIMINAR POLIZA");
        CVElimBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVElimBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout C_VEHICULOS2Layout = new javax.swing.GroupLayout(C_VEHICULOS2);
        C_VEHICULOS2.setLayout(C_VEHICULOS2Layout);
        C_VEHICULOS2Layout.setHorizontalGroup(
            C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                .addGroup(C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                        .addContainerGap(453, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CV2CoberturasyCobBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(CVModBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CVElimBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)))
                .addComponent(CV2SalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(362, 362, 362))
        );
        C_VEHICULOS2Layout.setVerticalGroup(
            C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                .addGroup(C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_VEHICULOS2Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addGroup(C_VEHICULOS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CV2CoberturasyCobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CV2SalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(CVModBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(CVElimBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        VEHICULOS.addTab("C. VEHICULOS 2", C_VEHICULOS2);

        C_VEHICULOS3.setBackground(new java.awt.Color(0, 51, 102));

        jLabel17.setBackground(new java.awt.Color(0, 0, 51));
        jLabel17.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("COBERTURAS");
        jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV3SalirBtn.setBackground(new java.awt.Color(51, 0, 0));
        CV3SalirBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV3SalirBtn.setForeground(new java.awt.Color(255, 255, 255));
        CV3SalirBtn.setText("ATRAS");
        CV3SalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV3SalirBtnActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(0, 0, 51));
        jLabel18.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("COBROS");
        jLabel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TblCV3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TblCV3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCV3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCV3.setAlignmentX(1.0F);
        TblCV3.setAlignmentY(1.0F);
        TblCV3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCV3.setColumnSelectionAllowed(true);
        TblCV3.setRowHeight(30);
        TblCV3.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(TblCV3);

        TblCV4.setBackground(new java.awt.Color(0, 0, 0));
        TblCV4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TblCV4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCV4.setForeground(new java.awt.Color(255, 255, 255));
        TblCV4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCV4.setAlignmentX(1.0F);
        TblCV4.setAlignmentY(1.0F);
        TblCV4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCV4.setColumnSelectionAllowed(true);
        TblCV4.setRowHeight(30);
        TblCV4.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(TblCV4);

        jLabel131.setBackground(new java.awt.Color(0, 0, 51));
        jLabel131.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("DESCRIPCION DE COBERTURA");
        jLabel131.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2Desc1.setColumns(20);
        IV2Desc1.setRows(5);
        jScrollPane14.setViewportView(IV2Desc1);

        javax.swing.GroupLayout C_VEHICULOS3Layout = new javax.swing.GroupLayout(C_VEHICULOS3);
        C_VEHICULOS3.setLayout(C_VEHICULOS3Layout);
        C_VEHICULOS3Layout.setHorizontalGroup(
            C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_VEHICULOS3Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_VEHICULOS3Layout.createSequentialGroup()
                        .addGroup(C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                            .addComponent(jScrollPane7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CV3SalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)))
                .addContainerGap(554, Short.MAX_VALUE))
        );
        C_VEHICULOS3Layout.setVerticalGroup(
            C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_VEHICULOS3Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV3SalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(C_VEHICULOS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(C_VEHICULOS3Layout.createSequentialGroup()
                        .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        VEHICULOS.addTab("C. VEHICULOS 3", C_VEHICULOS3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VEHICULOS, javax.swing.GroupLayout.PREFERRED_SIZE, 1516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VEHICULOS, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cclt2SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt2SalirBtnActionPerformed
        VEHICULOS.setSelectedIndex(1);
    }//GEN-LAST:event_Cclt2SalirBtnActionPerformed

    private void TblCC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCC1MouseClicked
        int fila  = TblCC1.getSelectedRow();String Id;
        if (fila>=0){
            Id = valueOf(TblCC1.getValueAt(fila, 0));
            cc2(Id);
            VEHICULOS.setSelectedIndex(2);
        }
    }//GEN-LAST:event_TblCC1MouseClicked

    private void CcltSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltSalirBtnActionPerformed
        VEHICULOS.setSelectedIndex(0);
    }//GEN-LAST:event_CcltSalirBtnActionPerformed

    private void CcltBuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltBuscarBtnActionPerformed
        String campo = Cclt1ComboBox.getSelectedItem().toString();

        Buscar1(src.Campo2(campo),Cclt1BusquedaTxt.getText());
    }//GEN-LAST:event_CcltBuscarBtnActionPerformed

    private void CcltLimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltLimpiarBtnActionPerformed
        Cclt1BusquedaTxt.setText("");consulta.mostrar_tabla1();
    }//GEN-LAST:event_CcltLimpiarBtnActionPerformed

    private void Cclt1BusquedaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1BusquedaTxtActionPerformed

    }//GEN-LAST:event_Cclt1BusquedaTxtActionPerformed

    private void Cclt1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cclt1ComboBoxActionPerformed

    private void CV3SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV3SalirBtnActionPerformed
       VEHICULOS.setSelectedIndex(6);
    }//GEN-LAST:event_CV3SalirBtnActionPerformed

    private void CVElimBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVElimBtn1ActionPerformed
         String sql = "DELETE  FROM tbl_vehiculos WHERE NoPoliza_Vhl ="+valueOf(TblCV2.getValueAt(2, 1))+"";
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"POLIZA ELIMINADA");
            
            consulta.mostrar_tabla2();
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        } VEHICULOS.setSelectedIndex(5);
    }//GEN-LAST:event_CVElimBtn1ActionPerformed

    private void CVModBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVModBtn1ActionPerformed
        IVNuevaPolizaBtn.setEnabled(true);
        IVAseguradoraTxt.setText(valueOf(TblCV2.getValueAt(0, 1)));
        IVNoPolizaTxt.setText(valueOf(TblCV2.getValueAt(2, 1)));
        IVNoCertificadoTxt.setText(valueOf(TblCV2.getValueAt(3, 1)));
        IVVigenciaTxt.setText(valueOf(TblCV2.getValueAt(4, 1)));
        IVVigenciaTxt1.setText(valueOf(TblCV2.getValueAt(5, 1)));
        IVContratanteTxt.setText(valueOf(TblCV2.getValueAt(6, 1)));
        IVMarcaTxt.setText(valueOf(TblCV2.getValueAt(11, 1)));
        IVLineaTxt.setText(valueOf(TblCV2.getValueAt(12, 1)));
        IVModeloTxt.setText(valueOf(TblCV2.getValueAt(13, 1)));
        IVPlacaTxt.setText(valueOf(TblCV2.getValueAt(14, 1)));
        IVColorTxt.setText(valueOf(TblCV2.getValueAt(15, 1)));
        IVChasisNoTxt.setText(valueOf(TblCV2.getValueAt(16, 1)));
        IVMotorNoTxt.setText(valueOf(TblCV2.getValueAt(17, 1)));
        IVPasajerosTxt.setText(valueOf(TblCV2.getValueAt(18, 1)));
        IV1ComboBox.setSelectedItem(valueOf(TblCV2.getValueAt(19, 1)));
        IVNoPolizaTxt.setEnabled(false);
        consulta.cv3(TblCV2.getValueAt(2, 1).toString());
        consulta.cv4(TblCV2.getValueAt(2, 1).toString());
        IV2TipoCoberturaCbx.setSelectedItem(valueOf(TblCV4.getValueAt(8, 1)));
        CM.setSelectedItem(valueOf(TblCV4.getValueAt(4, 1)));
        Cm.setSelectedItem(valueOf(TblCV4.getValueAt(5, 1)));
        IV2Desc.setText(IV2Desc1.getText());
        IV2SumaAVehiculoTxt.setText(valueOf(TblCV4.getValueAt(0, 1)));
        IV2SumaARCTxt.setText(valueOf(TblCV4.getValueAt(1, 1)));
        IV2DeducibleDañoPTxt.setText(valueOf(TblCV4.getValueAt(2, 1)));
        IV2TarifaTxt.setText(valueOf(TblCV4.getValueAt(6, 1)));
        IV2DeducibleRoboTxt.setText(valueOf(TblCV4.getValueAt(3, 1)));
        IV2EstadoPloTxt.setText(valueOf(TblCV4.getValueAt(7, 1)));
        IVAceptarBtn.setEnabled(false);
       VEHICULOS.setSelectedIndex(3);
    }//GEN-LAST:event_CVModBtn1ActionPerformed

    private void CV2SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2SalirBtnActionPerformed
        VEHICULOS.setSelectedIndex(5);
    }//GEN-LAST:event_CV2SalirBtnActionPerformed

    private void CV2CoberturasyCobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtnActionPerformed
        String NoPol;
        NoPol = valueOf(TblCV2.getValueAt(2, 1));
        consulta.cv3(NoPol);
        consulta.cv4(NoPol);
        VEHICULOS.setSelectedIndex(7);
    }//GEN-LAST:event_CV2CoberturasyCobBtnActionPerformed

    private void TblCV1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCV1MouseClicked
        int fila  = TblCV1.getSelectedRow();
        String Id;
        if (fila>=0){
            Id = valueOf(TblCV1.getValueAt(fila, 1));
            consulta.cv2(Id);
            VEHICULOS.setSelectedIndex(6);
        }else{
            JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
        }
    }//GEN-LAST:event_TblCV1MouseClicked

    private void CVBuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVBuscarBtnActionPerformed
        src.Buscar2(src.Campo3(CVBusquedaCbx.getSelectedItem().toString()),CVBusquedaTxt.getText());
    }//GEN-LAST:event_CVBuscarBtnActionPerformed

    private void CVLimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVLimpiarBtnActionPerformed
        CVBusquedaTxt.setText("");
        consulta.mostrar_tabla2();
    }//GEN-LAST:event_CVLimpiarBtnActionPerformed

    private void CVVolavermenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVVolavermenuBtnActionPerformed
        VEHICULOS.setSelectedIndex(0);
    }//GEN-LAST:event_CVVolavermenuBtnActionPerformed

    private void CVBusquedaCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVBusquedaCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CVBusquedaCbxActionPerformed

    private void IV2AtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2AtrasBtnActionPerformed
        VEHICULOS.setSelectedIndex(3);
    }//GEN-LAST:event_IV2AtrasBtnActionPerformed

    private void CMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMActionPerformed

    private void CmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmActionPerformed

    private void IV2TipoCoberturaCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2TipoCoberturaCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IV2TipoCoberturaCbxActionPerformed

    private void IVAtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVAtrasBtnActionPerformed
       VEHICULOS.setSelectedIndex(2);
    }//GEN-LAST:event_IVAtrasBtnActionPerformed

    private void IVVolverMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVVolverMenuBtnActionPerformed
        VEHICULOS.setSelectedIndex(0);
    }//GEN-LAST:event_IVVolverMenuBtnActionPerformed

    private void IVSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVSalirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_IVSalirBtnActionPerformed

    private void IVIngresarCoberturasbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVIngresarCoberturasbtnActionPerformed
        VEHICULOS.setSelectedIndex(4);
    }//GEN-LAST:event_IVIngresarCoberturasbtnActionPerformed

    private void IVNuevaPolizaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVNuevaPolizaBtnActionPerformed
         
        if(IVAseguradoraTxt.getText().equals("") || IVNoPolizaTxt.getText().equals("") || IVVigenciaTxt.getText().equals("") || IVVigenciaTxt1.getText().equals("")||IVPasajerosTxt.getText().equals(""))
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Vigencia.\n- Pasajeros.");
        }else{
            try {
           String noPol =IVNoPolizaTxt.getText() ;
           String id =IVNoPolizaTxt.getText() ;
            String sql = "UPDATE `tbl_vehiculos` SET IdAseguradora_vhl='"+valueOf(TblCV2.getValueAt(0, 1))+"',IdPolizaVhl='"+valueOf(TblCV2.getValueAt(1, 1))+"',"
            +"NoPoliza_vhl='"+IVNoPolizaTxt.getText()+"',NoCertificado_vhl='"+IVNoCertificadoTxt.getText()+"',VigenciaInicio_vhl='"+IVVigenciaTxt.getText()+"',VigeciaFin_vhl='"+IVVigenciaTxt1.getText()+"',"
           +"Contratante_vhl='"+IVContratanteTxt.getText()+"',IdCliente_vhl='"+valueOf(TblCV2.getValueAt(7, 1))+"',Asegurado_vhl='"+valueOf(TblCV2.getValueAt(8, 1))+"',Direccion_vhl='"+valueOf(TblCV2.getValueAt(10, 1))+"',"
        +"Nit_vhl='"+valueOf(TblCV2.getValueAt(11, 1))+"',Marca_vhl='"+IVMarcaTxt.getText()+"',Linea_vhl='"+IVLineaTxt.getText()+"',Modelo_vhl='"+IVModeloTxt.getText()+"',Placa_vhl='"+IVPlacaTxt.getText()+"',"
        +"Color_vhl='"+IVColorTxt.getText()+"',NoChasis_vhl='"+IVChasisNoTxt.getText()+"',NoMotor_vhl='"+IVMotorNoTxt.getText()+"',Pasajeros_vhl='"+IVPasajerosTxt.getText()+"',Tipo_vhl='"+IV1ComboBox.getSelectedItem().toString()+"',"
        +"Cobertura_vhl='"+IV2TipoCoberturaCbx.getSelectedItem().toString()+"',DescripcionCobertura_vhl='"+IV2Desc.getText()+"',SumaVehiculo_vhl='"+IV2SumaAVehiculoTxt.getText()+"',SumaRC_vhl='"+IV2SumaARCTxt.getText()+"',"
      + "DeducibleCañosPropios_vhl='"+IV2DeducibleDañoPTxt.getText()+"',DeducibleRobo_vhl='"+IV2DeducibleRoboTxt.getText()+"',ConductoresMenores_vhl='"+CM.getSelectedItem().toString()+"',"
        + "ConductoresMayores_vhl='"+Cm.getSelectedItem().toString()+"',Tarifa_vhl='"+IV2TarifaTxt.getText()+"',EstadoPoliza_vhl='"+IV2EstadoPloTxt.getText()+"' WHERE NoPoliza_Vhl="+id+"";
            
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
          
            JOptionPane.showMessageDialog(null,"ACTUALIZADO");
              consulta.cv2(noPol);
            VEHICULOS.setSelectedIndex(6);
              consulta.mostrar_tabla2();
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        IVAseguradoraTxt.setText("");
        IVNoPolizaTxt.setText("");
        IVNoCertificadoTxt.setText("");
        IVVigenciaTxt.setText("");
        IVVigenciaTxt1.setText("");
        IVContratanteTxt.setText("");
        IVMarcaTxt.setText("");
        IVLineaTxt.setText("");
        IVModeloTxt.setText("");
        IVPlacaTxt.setText("");
        IVColorTxt.setText("");
        IVChasisNoTxt.setText("");
        IVMotorNoTxt.setText("");
        IVPasajerosTxt.setText("");
       
        IV2Desc.setText("");
        IV2SumaAVehiculoTxt.setText("");
        IV2SumaARCTxt.setText("");
        IV2DeducibleDañoPTxt.setText("");
        IV2TarifaTxt.setText("");
        IV2DeducibleRoboTxt.setText("");
        IV2EstadoPloTxt.setText("");
        
        }
    }//GEN-LAST:event_IVNuevaPolizaBtnActionPerformed

    private void IVLimpiiarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVLimpiiarbtnActionPerformed
          IVAseguradoraTxt.setText("");
        IVNoPolizaTxt.setText("");
        IVNoCertificadoTxt.setText("");
        IVVigenciaTxt.setText("");
        IVVigenciaTxt1.setText("");
        IVContratanteTxt.setText("");
        IVMarcaTxt.setText("");
        IVLineaTxt.setText("");
        IVModeloTxt.setText("");
        IVPlacaTxt.setText("");
        IVColorTxt.setText("");
        IVChasisNoTxt.setText("");
        IVMotorNoTxt.setText("");
        IVPasajerosTxt.setText("");
       
        IV2Desc.setText("");
        IV2SumaAVehiculoTxt.setText("");
        IV2SumaARCTxt.setText("");
        IV2DeducibleDañoPTxt.setText("");
        IV2TarifaTxt.setText("");
        IV2DeducibleRoboTxt.setText("");
        IV2EstadoPloTxt.setText("");
    }//GEN-LAST:event_IVLimpiiarbtnActionPerformed

    private void IVAceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVAceptarBtnActionPerformed
        if(IVAseguradoraTxt.getText().equals("") || IVNoPolizaTxt.getText().equals("") || IVVigenciaTxt.getText().equals("") || IVVigenciaTxt1.getText().equals("")||IVPasajerosTxt.getText().equals(""))
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Vigencia.\n- Pasajeros.");
        }else{


        Ingresos Vehiculo = new Ingresos();
        Consultas c= new Consultas();
        Vehiculo.ingresoVehiculos(TblCC2.getValueAt(0, 1).toString(),IV1ComboBox.getSelectedItem().toString()
            ,IV2TipoCoberturaCbx.getSelectedItem().toString(),CM.getSelectedItem().toString(),Cm.getSelectedItem().toString());
        String npol = IVNoPolizaTxt.getText();
        c.cv2(npol);
        consulta.mostrar_tabla2();}
        
        
        IVAseguradoraTxt.setText("");
        IVNoPolizaTxt.setText("");
        IVNoCertificadoTxt.setText("");
        IVVigenciaTxt.setText("");
        IVVigenciaTxt1.setText("");
        IVContratanteTxt.setText("");
        IVMarcaTxt.setText("");
        IVLineaTxt.setText("");
        IVModeloTxt.setText("");
        IVPlacaTxt.setText("");
        IVColorTxt.setText("");
        IVChasisNoTxt.setText("");
        IVMotorNoTxt.setText("");
        IVPasajerosTxt.setText("");
       
        IV2Desc.setText("");
        IV2SumaAVehiculoTxt.setText("");
        IV2SumaARCTxt.setText("");
        IV2DeducibleDañoPTxt.setText("");
        IV2TarifaTxt.setText("");
        IV2DeducibleRoboTxt.setText("");
        IV2EstadoPloTxt.setText("");
        
        
    }//GEN-LAST:event_IVAceptarBtnActionPerformed

    private void ModificacionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificacionMenu2BtnActionPerformed
       VEHICULOS.setSelectedIndex(5);
    }//GEN-LAST:event_ModificacionMenu2BtnActionPerformed

    private void ConsultaMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaMenu2BtnActionPerformed
        VEHICULOS.setSelectedIndex(5);
    }//GEN-LAST:event_ConsultaMenu2BtnActionPerformed

    private void EliminarMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMenu2BtnActionPerformed
        VEHICULOS.setSelectedIndex(5);
    }//GEN-LAST:event_EliminarMenu2BtnActionPerformed

    private void IngresosMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosMenu2BtnActionPerformed
        IVNoPolizaTxt.setEnabled(true);
        IVAceptarBtn.setEnabled(true);
        IVNuevaPolizaBtn.setEnabled(false);
        VEHICULOS.setSelectedIndex(1);
    }//GEN-LAST:event_IngresosMenu2BtnActionPerformed

    private void CcltModificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltModificarBtnActionPerformed
       VEHICULOS.setSelectedIndex(3);
    }//GEN-LAST:event_CcltModificarBtnActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
       this.setSize(1550, 911);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        this.setSize(200, 40);
    }//GEN-LAST:event_formInternalFrameIconified


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> CM;
    private javax.swing.JButton CV2CoberturasyCobBtn;
    private javax.swing.JButton CV2SalirBtn;
    private javax.swing.JButton CV3SalirBtn;
    private javax.swing.JButton CVBuscarBtn;
    public static javax.swing.JComboBox<String> CVBusquedaCbx;
    private javax.swing.JTextField CVBusquedaTxt;
    private javax.swing.JButton CVElimBtn1;
    private javax.swing.JButton CVLimpiarBtn;
    private javax.swing.JButton CVModBtn1;
    private javax.swing.JButton CVVolavermenuBtn;
    private javax.swing.JPanel C_CLIENTES1;
    private javax.swing.JPanel C_CLIENTES2;
    private javax.swing.JPanel C_VEHICULOS1;
    private javax.swing.JPanel C_VEHICULOS2;
    private javax.swing.JPanel C_VEHICULOS3;
    private javax.swing.JTextField Cclt1BusquedaTxt;
    public static javax.swing.JComboBox<String> Cclt1ComboBox;
    private javax.swing.JButton Cclt2SalirBtn;
    private javax.swing.JButton CcltBuscarBtn;
    private javax.swing.JButton CcltLimpiarBtn;
    private javax.swing.JButton CcltModificarBtn;
    private javax.swing.JButton CcltSalirBtn;
    public static javax.swing.JComboBox<String> Cm;
    private javax.swing.JButton ConsultaMenu2Btn;
    private javax.swing.JButton EliminarMenu2Btn;
    public static javax.swing.JComboBox<String> IV1ComboBox;
    private javax.swing.JButton IV2AtrasBtn;
    public static javax.swing.JTextField IV2DeducibleDañoPTxt;
    public static javax.swing.JTextField IV2DeducibleRoboTxt;
    public static javax.swing.JTextArea IV2Desc;
    public static javax.swing.JTextArea IV2Desc1;
    public static javax.swing.JTextField IV2EstadoPloTxt;
    public static javax.swing.JTextField IV2SumaARCTxt;
    public static javax.swing.JTextField IV2SumaAVehiculoTxt;
    public static javax.swing.JTextField IV2TarifaTxt;
    public static javax.swing.JComboBox<String> IV2TipoCoberturaCbx;
    private javax.swing.JButton IVAceptarBtn;
    public static javax.swing.JTextField IVAseguradoraTxt;
    private javax.swing.JButton IVAtrasBtn;
    public static javax.swing.JTextField IVChasisNoTxt;
    public static javax.swing.JTextField IVColorTxt;
    public static javax.swing.JTextField IVContratanteTxt;
    private javax.swing.JButton IVIngresarCoberturasbtn;
    private javax.swing.JButton IVLimpiiarbtn;
    public static javax.swing.JTextField IVLineaTxt;
    public static javax.swing.JTextField IVMarcaTxt;
    public static javax.swing.JTextField IVModeloTxt;
    public static javax.swing.JTextField IVMotorNoTxt;
    public static javax.swing.JTextField IVNoCertificadoTxt;
    public static javax.swing.JTextField IVNoPolizaTxt;
    private javax.swing.JButton IVNuevaPolizaBtn;
    public static javax.swing.JTextField IVPasajerosTxt;
    public static javax.swing.JTextField IVPlacaTxt;
    private javax.swing.JButton IVSalirBtn;
    public static javax.swing.JTextField IVVigenciaTxt;
    public static javax.swing.JTextField IVVigenciaTxt1;
    private javax.swing.JButton IVVolverMenuBtn;
    private javax.swing.JPanel I_VEHICULOS1;
    private javax.swing.JPanel I_VEHICULOS2;
    private javax.swing.JButton IngresosMenu2Btn;
    private javax.swing.JPanel MENU2;
    private javax.swing.JButton ModificacionMenu2Btn;
    public static javax.swing.JTable TblCC1;
    public static javax.swing.JTable TblCC2;
    public static javax.swing.JTable TblCV1;
    public static javax.swing.JTable TblCV2;
    public static javax.swing.JTable TblCV3;
    public static javax.swing.JTable TblCV4;
    private javax.swing.JTabbedPane VEHICULOS;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
