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

/**
 *
 * @author gganp
 */
public class GASTOS_MEDICOS extends javax.swing.JInternalFrame {

    /**
     * Creates new form GASTOS_MEDICOS
     */
    public static int tipo=0;
     Consultas consulta = new Consultas();
    Busquedas src = new Busquedas();
    
    Eliminar del =new Eliminar();
    Cliente cl = new Cliente();
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    public GASTOS_MEDICOS() {
        initComponents();
        GM.setEnabled(false);
        mostrar_tabla1();
        consulta.mostrar_tabla3();
        if(tipo==2){ModificacionMenu2Btn.setEnabled(false);
       EliminarMenu2Btn.setEnabled(false);
       CGMModBtn.setEnabled(false);
      CGMElimBtn.setEnabled(false);
       }
        CGMBusquedaCbx.addItem("Id");
        CGMBusquedaCbx.addItem("Poliza");
        CGMBusquedaCbx.addItem("Certificado");
        CGMBusquedaCbx.addItem("Plan");
        CGMBusquedaCbx.addItem("Cobertura");
        CGMBusquedaCbx.addItem("Tipo");
        Cclt1ComboBox.addItem("Id");
        Cclt1ComboBox.addItem("1er.Nombre");
        Cclt1ComboBox.addItem("2do.Nombre");
        Cclt1ComboBox.addItem("3er.Nombre");
        Cclt1ComboBox.addItem("1er.Apellido");
        Cclt1ComboBox.addItem("2do.Apellido");
        PD.addItem("Inclido");
        PD.addItem("No Incluido");
        CB.addItem("C.A.");
        CB.addItem("Mundial");
        TP.addItem("Individual");
        TP.addItem("Familiar");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GM = new javax.swing.JTabbedPane();
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
        I_GM1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        IGMAseguradoraTxt = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        IGMNoPolizaTxt = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        IGMNoCertificadoTxt = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        IGMNomPlanTxt = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        IGMfechaEfecTxt = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        IGMMaxVitaTxt = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        IGmSumaAvidaTxt = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        Btn_aceptar_reg3 = new javax.swing.JButton();
        limpiar8 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        PD = new javax.swing.JComboBox<>();
        CB = new javax.swing.JComboBox<>();
        TP = new javax.swing.JComboBox<>();
        IGMConyugueBtn = new javax.swing.JButton();
        IGMfechaEfecTxt1 = new javax.swing.JTextField();
        IGmEstadoPolTxt = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        IIGM1DescTxt = new javax.swing.JTextArea();
        limpiar9 = new javax.swing.JButton();
        IGMSalirBtn = new javax.swing.JButton();
        IGMvolverBtn = new javax.swing.JButton();
        IGMAtrasBtn = new javax.swing.JButton();
        I_GM2 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        IGM2NoReqTxt1 = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        IGMfechaPTxt1 = new javax.swing.JTextField();
        IGM2PrimaTxt1 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        IGM2IngresarPagTxt1 = new javax.swing.JButton();
        jLabel164 = new javax.swing.JLabel();
        IGMfechaPTxt2 = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        IGM2PrimaTxt2 = new javax.swing.JTextField();
        IGMfechaPTxt3 = new javax.swing.JTextField();
        IGMfechaPTxt4 = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        IGM2PrimaTxt3 = new javax.swing.JTextField();
        IGM2NoReqTxt2 = new javax.swing.JTextField();
        IGM2AtrasBtn1 = new javax.swing.JButton();
        C_GM1 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        CGMBusquedaCbx = new javax.swing.JComboBox<>();
        CGMBusquedaTxt = new javax.swing.JTextField();
        CGMLimpiarBtn = new javax.swing.JButton();
        CGMBuscarbtn = new javax.swing.JButton();
        CGMSalirbtn = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        TblGM1 = new javax.swing.JTable();
        CGM2VolverBtn2 = new javax.swing.JButton();
        C_GM2 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        CGM2VolverBtn = new javax.swing.JButton();
        CGM2AtrasBtn = new javax.swing.JButton();
        CGMSalirBtn = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn1 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        TblGM2 = new javax.swing.JTable();
        CGMElimBtn = new javax.swing.JButton();
        CGMModBtn = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        IIGM1DescTxt1 = new javax.swing.JTextArea();
        C_GM3 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        CGM2VolverBtn1 = new javax.swing.JButton();
        CGM2AtrasBtn1 = new javax.swing.JButton();
        CGMSalirBtn1 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TblCGM3 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        TblCGM4 = new javax.swing.JTable();
        CGM2AtrasBtn2 = new javax.swing.JButton();
        CGM2AtrasBtn3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("GASTOS MEDICOS");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeactivated(evt);
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

        MENU2.setBackground(new java.awt.Color(102, 0, 0));

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
        jLabel79.setText("GASTOS MEDICOS");
        jLabel79.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout MENU2Layout = new javax.swing.GroupLayout(MENU2);
        MENU2.setLayout(MENU2Layout);
        MENU2Layout.setHorizontalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MENU2Layout.createSequentialGroup()
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(407, 407, 407))
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(302, 302, 302))
        );
        MENU2Layout.setVerticalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        GM.addTab("MENU", MENU2);

        C_CLIENTES1.setBackground(new java.awt.Color(102, 0, 0));
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
                .addContainerGap(281, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(141, 141, 141))
        );

        GM.addTab("C. CLIENTES 1", C_CLIENTES1);

        C_CLIENTES2.setBackground(new java.awt.Color(102, 0, 0));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
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
                .addContainerGap(51, Short.MAX_VALUE))
        );

        GM.addTab("C. CLIENTES 2", C_CLIENTES2);

        I_GM1.setBackground(new java.awt.Color(102, 0, 0));
        I_GM1.setPreferredSize(new java.awt.Dimension(1880, 824));

        jLabel9.setBackground(new java.awt.Color(0, 0, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GASTOS MEDICOS");
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel27.setBackground(new java.awt.Color(0, 0, 51));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel27.setOpaque(false);

        IGMAseguradoraTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMAseguradoraTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGMAseguradoraTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel58.setBackground(new java.awt.Color(0, 0, 51));
        jLabel58.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("No. POLIZA");
        jLabel58.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMNoPolizaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMNoPolizaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGMNoPolizaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel59.setBackground(new java.awt.Color(0, 0, 51));
        jLabel59.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("No. CERTIFICADO");
        jLabel59.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMNoCertificadoTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMNoCertificadoTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGMNoCertificadoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel60.setBackground(new java.awt.Color(0, 0, 51));
        jLabel60.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("NOMBRE DEL PLAN");
        jLabel60.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMNomPlanTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMNomPlanTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGMNomPlanTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel65.setBackground(new java.awt.Color(0, 0, 51));
        jLabel65.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("COBERTURA");
        jLabel65.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel66.setBackground(new java.awt.Color(0, 0, 51));
        jLabel66.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("TIPO DE POLIZA");
        jLabel66.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel70.setBackground(new java.awt.Color(0, 0, 51));
        jLabel70.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("FECHA EFECTIVA");
        jLabel70.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMfechaEfecTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMfechaEfecTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGMfechaEfecTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel71.setBackground(new java.awt.Color(0, 0, 51));
        jLabel71.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("MAXIMO VITALICIO");
        jLabel71.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMMaxVitaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMMaxVitaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGMMaxVitaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel72.setBackground(new java.awt.Color(0, 0, 51));
        jLabel72.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("SUMA ASEGURADA VIDA");
        jLabel72.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGmSumaAvidaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGmSumaAvidaTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGmSumaAvidaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel73.setBackground(new java.awt.Color(0, 0, 51));
        jLabel73.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("PLAN DENTAL");
        jLabel73.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Btn_aceptar_reg3.setBackground(new java.awt.Color(0, 0, 0));
        Btn_aceptar_reg3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Btn_aceptar_reg3.setForeground(new java.awt.Color(255, 255, 255));
        Btn_aceptar_reg3.setText("ACEPTAR");
        Btn_aceptar_reg3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_aceptar_reg3ActionPerformed(evt);
            }
        });

        limpiar8.setBackground(new java.awt.Color(0, 0, 0));
        limpiar8.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        limpiar8.setForeground(new java.awt.Color(255, 255, 255));
        limpiar8.setText("LIMPIAR");
        limpiar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar8ActionPerformed(evt);
            }
        });

        jLabel84.setBackground(new java.awt.Color(0, 0, 51));
        jLabel84.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("ASEGURADORA");
        jLabel84.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PD.setBackground(new java.awt.Color(204, 204, 204));
        PD.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        PD.setMaximumRowCount(2);
        PD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N

        CB.setBackground(new java.awt.Color(204, 204, 204));
        CB.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CB.setMaximumRowCount(2);
        CB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N

        TP.setBackground(new java.awt.Color(204, 204, 204));
        TP.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TP.setMaximumRowCount(2);
        TP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N

        IGMConyugueBtn.setBackground(new java.awt.Color(0, 0, 0));
        IGMConyugueBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGMConyugueBtn.setForeground(new java.awt.Color(255, 255, 255));
        IGMConyugueBtn.setText("CONYUGE / HIJOS");
        IGMConyugueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGMConyugueBtnActionPerformed(evt);
            }
        });

        IGMfechaEfecTxt1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMfechaEfecTxt1.setForeground(new java.awt.Color(0, 0, 51));
        IGMfechaEfecTxt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IGmEstadoPolTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGmEstadoPolTxt.setForeground(new java.awt.Color(0, 0, 51));
        IGmEstadoPolTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel74.setBackground(new java.awt.Color(0, 0, 51));
        jLabel74.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("ESTADO DE POLIZA");
        jLabel74.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel87.setBackground(new java.awt.Color(0, 0, 51));
        jLabel87.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("DESCRIPCION COBERTURAS");
        jLabel87.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IIGM1DescTxt.setColumns(20);
        IIGM1DescTxt.setRows(5);
        jScrollPane8.setViewportView(IIGM1DescTxt);

        limpiar9.setBackground(new java.awt.Color(0, 0, 0));
        limpiar9.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        limpiar9.setForeground(new java.awt.Color(255, 255, 255));
        limpiar9.setText("ACTUALIZAR");
        limpiar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGMAseguradoraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGMNoPolizaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGMNoCertificadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGMNomPlanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IGMMaxVitaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IGmSumaAvidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel27Layout.createSequentialGroup()
                                            .addComponent(IGMfechaEfecTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(IGMfechaEfecTxt1))))
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(IGmEstadoPolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(limpiar9, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(Btn_aceptar_reg3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limpiar8, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                            .addComponent(IGMConyugueBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(80, 80, 80))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IGMAseguradoraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IGMNoPolizaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IGMNoCertificadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IGMNomPlanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IGMfechaEfecTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IGMfechaEfecTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IGMMaxVitaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IGmSumaAvidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGmEstadoPolTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_aceptar_reg3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limpiar8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(IGMConyugueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiar9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        IGMSalirBtn.setBackground(new java.awt.Color(51, 0, 0));
        IGMSalirBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGMSalirBtn.setForeground(new java.awt.Color(255, 255, 255));
        IGMSalirBtn.setText("SALIR");
        IGMSalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGMSalirBtnActionPerformed(evt);
            }
        });

        IGMvolverBtn.setBackground(new java.awt.Color(0, 0, 0));
        IGMvolverBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGMvolverBtn.setForeground(new java.awt.Color(255, 255, 255));
        IGMvolverBtn.setText("VOLVER A MENÚ");
        IGMvolverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGMvolverBtnActionPerformed(evt);
            }
        });

        IGMAtrasBtn.setBackground(new java.awt.Color(0, 0, 0));
        IGMAtrasBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGMAtrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        IGMAtrasBtn.setText("ATRAS");
        IGMAtrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGMAtrasBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout I_GM1Layout = new javax.swing.GroupLayout(I_GM1);
        I_GM1.setLayout(I_GM1Layout);
        I_GM1Layout.setHorizontalGroup(
            I_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_GM1Layout.createSequentialGroup()
                .addGroup(I_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_GM1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(I_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IGMSalirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IGMvolverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGMAtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(I_GM1Layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        I_GM1Layout.setVerticalGroup(
            I_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_GM1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(I_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_GM1Layout.createSequentialGroup()
                        .addComponent(IGMvolverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(IGMAtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(IGMSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        GM.addTab("I GASTOS MEDICOS", I_GM1);

        I_GM2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel86.setBackground(new java.awt.Color(0, 0, 51));
        jLabel86.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("FAMILIARES");
        jLabel86.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel36.setBackground(new java.awt.Color(0, 0, 51));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel36.setOpaque(false);

        jLabel160.setBackground(new java.awt.Color(0, 0, 51));
        jLabel160.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel160.setText("FECHA DE EFECTIVA");
        jLabel160.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGM2NoReqTxt1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGM2NoReqTxt1.setForeground(new java.awt.Color(0, 0, 51));
        IGM2NoReqTxt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel161.setBackground(new java.awt.Color(0, 0, 51));
        jLabel161.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("NOMBRES");
        jLabel161.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMfechaPTxt1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMfechaPTxt1.setForeground(new java.awt.Color(0, 0, 51));
        IGMfechaPTxt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IGM2PrimaTxt1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGM2PrimaTxt1.setForeground(new java.awt.Color(0, 0, 51));
        IGM2PrimaTxt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel163.setBackground(new java.awt.Color(0, 0, 51));
        jLabel163.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 255, 255));
        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel163.setText("DATOS");
        jLabel163.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGM2IngresarPagTxt1.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt1.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt1.setText("GUARDAR");
        IGM2IngresarPagTxt1.setBorder(null);
        IGM2IngresarPagTxt1.setBorderPainted(false);
        IGM2IngresarPagTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt1limpiar18ActionPerformed(evt);
            }
        });

        jLabel164.setBackground(new java.awt.Color(0, 0, 51));
        jLabel164.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(255, 255, 255));
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel164.setText("APELLIDOS");
        jLabel164.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMfechaPTxt2.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMfechaPTxt2.setForeground(new java.awt.Color(0, 0, 51));
        IGMfechaPTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel162.setBackground(new java.awt.Color(0, 0, 51));
        jLabel162.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 255, 255));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel162.setText("FECHA DE NACIMIENTO");
        jLabel162.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel165.setBackground(new java.awt.Color(0, 0, 51));
        jLabel165.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 255, 255));
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel165.setText("EDAD");
        jLabel165.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGM2PrimaTxt2.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGM2PrimaTxt2.setForeground(new java.awt.Color(0, 0, 51));
        IGM2PrimaTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IGMfechaPTxt3.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMfechaPTxt3.setForeground(new java.awt.Color(0, 0, 51));
        IGMfechaPTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IGMfechaPTxt4.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGMfechaPTxt4.setForeground(new java.awt.Color(0, 0, 51));
        IGMfechaPTxt4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel166.setBackground(new java.awt.Color(0, 0, 51));
        jLabel166.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel166.setText("PARENTESCO");
        jLabel166.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGM2PrimaTxt3.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGM2PrimaTxt3.setForeground(new java.awt.Color(0, 0, 51));
        IGM2PrimaTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IGM2NoReqTxt2.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IGM2NoReqTxt2.setForeground(new java.awt.Color(0, 0, 51));
        IGM2NoReqTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel166, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IGM2PrimaTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(IGM2IngresarPagTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel165, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jLabel162, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGMfechaPTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2PrimaTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel161, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IGM2PrimaTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(IGMfechaPTxt1)
                            .addComponent(IGM2NoReqTxt1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IGMfechaPTxt3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(IGMfechaPTxt4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(IGM2NoReqTxt2))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IGM2NoReqTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IGM2NoReqTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IGMfechaPTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IGMfechaPTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IGM2PrimaTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IGMfechaPTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IGMfechaPTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IGM2PrimaTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(IGM2IngresarPagTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2PrimaTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        IGM2AtrasBtn1.setBackground(new java.awt.Color(0, 0, 0));
        IGM2AtrasBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2AtrasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        IGM2AtrasBtn1.setText("ATRAS");
        IGM2AtrasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2AtrasBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout I_GM2Layout = new javax.swing.GroupLayout(I_GM2);
        I_GM2.setLayout(I_GM2Layout);
        I_GM2Layout.setHorizontalGroup(
            I_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_GM2Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
            .addGroup(I_GM2Layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        I_GM2Layout.setVerticalGroup(
            I_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_GM2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(I_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_GM2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(I_GM2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GM.addTab("I GASTOS MEDICOS 2", I_GM2);

        C_GM1.setBackground(new java.awt.Color(102, 0, 0));
        C_GM1.setPreferredSize(new java.awt.Dimension(1530, 950));

        jLabel67.setBackground(new java.awt.Color(0, 0, 51));
        jLabel67.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("GASTOS MEDICOS");
        jLabel67.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CGMBusquedaCbx.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMBusquedaCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMBusquedaCbxActionPerformed(evt);
            }
        });

        CGMBusquedaTxt.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CGMBusquedaTxt.setForeground(new java.awt.Color(0, 0, 51));
        CGMBusquedaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CGMLimpiarBtn.setBackground(new java.awt.Color(0, 0, 0));
        CGMLimpiarBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMLimpiarBtn.setForeground(new java.awt.Color(255, 255, 255));
        CGMLimpiarBtn.setText("LIMPIAR");
        CGMLimpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMLimpiarBtnActionPerformed(evt);
            }
        });

        CGMBuscarbtn.setBackground(new java.awt.Color(0, 0, 0));
        CGMBuscarbtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMBuscarbtn.setForeground(new java.awt.Color(255, 255, 255));
        CGMBuscarbtn.setText("BUSCAR ");
        CGMBuscarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMBuscarbtnActionPerformed(evt);
            }
        });

        CGMSalirbtn.setBackground(new java.awt.Color(51, 0, 0));
        CGMSalirbtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMSalirbtn.setForeground(new java.awt.Color(255, 255, 255));
        CGMSalirbtn.setText("SALIR");
        CGMSalirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMSalirbtnActionPerformed(evt);
            }
        });

        TblGM1.setBackground(new java.awt.Color(0, 0, 51));
        TblGM1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblGM1.setForeground(new java.awt.Color(255, 255, 255));
        TblGM1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblGM1.setAlignmentX(1.0F);
        TblGM1.setAlignmentY(1.0F);
        TblGM1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblGM1.setGridColor(new java.awt.Color(0, 153, 204));
        TblGM1.setRowHeight(30);
        TblGM1.setSelectionBackground(new java.awt.Color(0, 102, 204));
        TblGM1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TblGM1.setShowVerticalLines(false);
        TblGM1.getTableHeader().setReorderingAllowed(false);
        TblGM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblGM1MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(TblGM1);

        CGM2VolverBtn2.setBackground(new java.awt.Color(0, 0, 0));
        CGM2VolverBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2VolverBtn2.setForeground(new java.awt.Color(255, 255, 255));
        CGM2VolverBtn2.setText("VOLVER A MENÚ");
        CGM2VolverBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2VolverBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout C_GM1Layout = new javax.swing.GroupLayout(C_GM1);
        C_GM1.setLayout(C_GM1Layout);
        C_GM1Layout.setHorizontalGroup(
            C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(377, Short.MAX_VALUE))
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CGMBusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMBuscarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CGMBusquedaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CGMSalirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGM2VolverBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(C_GM1Layout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        C_GM1Layout.setVerticalGroup(
            C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CGMBusquedaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMBusquedaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CGMLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMBuscarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(CGM2VolverBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CGMSalirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        GM.addTab("C GASTOS MEDICOS", C_GM1);

        C_GM2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel68.setBackground(new java.awt.Color(0, 0, 51));
        jLabel68.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("INFORMACION");
        jLabel69.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV2CoberturasyCobBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CV2CoberturasyCobBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2CoberturasyCobBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CV2CoberturasyCobBtn1.setText("VER COBROS Y ASEGURADOS");
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

        CGMElimBtn.setBackground(new java.awt.Color(0, 0, 0));
        CGMElimBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMElimBtn.setForeground(new java.awt.Color(255, 255, 255));
        CGMElimBtn.setText("ELIMINAR POLIZA");
        CGMElimBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMElimBtnActionPerformed(evt);
            }
        });

        CGMModBtn.setBackground(new java.awt.Color(0, 0, 0));
        CGMModBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMModBtn.setForeground(new java.awt.Color(255, 255, 255));
        CGMModBtn.setText("MODIFICAR POLIZA");
        CGMModBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMModBtnActionPerformed(evt);
            }
        });

        jLabel88.setBackground(new java.awt.Color(0, 0, 51));
        jLabel88.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
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
                                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CGMModBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CGMElimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CV2CoberturasyCobBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(47, 47, 47))
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CGMSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(106, 106, 106)
                        .addComponent(CGM2VolverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(CGMSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(C_GM2Layout.createSequentialGroup()
                                .addComponent(CV2CoberturasyCobBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150))
                            .addGroup(C_GM2Layout.createSequentialGroup()
                                .addComponent(CGMModBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CGMElimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GM.addTab("C GASTOS MEDICOS 2", C_GM2);

        C_GM3.setBackground(new java.awt.Color(102, 0, 0));

        jLabel81.setBackground(new java.awt.Color(255, 255, 255));
        jLabel81.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("GASTOS MEDICOS");
        jLabel81.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CGM2VolverBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGM2VolverBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2VolverBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGM2VolverBtn1.setText("VOLVER A MENÚ");
        CGM2VolverBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2VolverBtn1ActionPerformed(evt);
            }
        });

        CGM2AtrasBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn1.setText("ATRAS");
        CGM2AtrasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn1ActionPerformed(evt);
            }
        });

        CGMSalirBtn1.setBackground(new java.awt.Color(51, 0, 0));
        CGMSalirBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMSalirBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGMSalirBtn1.setText("SALIR");
        CGMSalirBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMSalirBtn1ActionPerformed(evt);
            }
        });

        jLabel82.setBackground(new java.awt.Color(204, 102, 0));
        jLabel82.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("COBROS");

        jLabel85.setBackground(new java.awt.Color(204, 102, 0));
        jLabel85.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("ASEGURADOS");
        jLabel85.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TblCGM3.setBackground(new java.awt.Color(0, 0, 51));
        TblCGM3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCGM3.setForeground(new java.awt.Color(255, 255, 255));
        TblCGM3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCGM3.setAlignmentX(1.0F);
        TblCGM3.setAlignmentY(1.0F);
        TblCGM3.setRowHeight(30);
        TblCGM3.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TblCGM3.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setViewportView(TblCGM3);

        TblCGM4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TblCGM4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TblCGM4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblCGM4.setAlignmentX(1.0F);
        TblCGM4.setAlignmentY(1.0F);
        TblCGM4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCGM4.setColumnSelectionAllowed(true);
        TblCGM4.setRowHeight(30);
        TblCGM4.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(TblCGM4);

        CGM2AtrasBtn2.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn2.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn2.setText("NUEVO");
        CGM2AtrasBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn2ActionPerformed(evt);
            }
        });

        CGM2AtrasBtn3.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn3.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn3.setText("ELIMINAR");
        CGM2AtrasBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout C_GM3Layout = new javax.swing.GroupLayout(C_GM3);
        C_GM3.setLayout(C_GM3Layout);
        C_GM3Layout.setHorizontalGroup(
            C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM3Layout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(C_GM3Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CGMSalirBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CGM2VolverBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                        .addGap(174, 174, 174))
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(C_GM3Layout.createSequentialGroup()
                                .addComponent(CGM2AtrasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CGM2AtrasBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        C_GM3Layout.setVerticalGroup(
            C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM3Layout.createSequentialGroup()
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CGM2VolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CGMSalirBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CGM2AtrasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CGM2AtrasBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        GM.addTab("C. GASTOS MED 3", C_GM3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GM, javax.swing.GroupLayout.PREFERRED_SIZE, 1510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(GM, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_aceptar_reg3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_aceptar_reg3ActionPerformed

if(IGMAseguradoraTxt.getText().equals("") || IGMNoPolizaTxt.getText().equals("") || IGMfechaEfecTxt.getText().equals("") || IGMfechaEfecTxt1.getText().equals(""))
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Fecha Efectiva.");
        }else{

        Ingresos gm= new Ingresos();
        int fila = TblCC1.getSelectedRow();
        gm.ingresoGastosMed(TblCC1.getValueAt(fila,0).toString(),CB.getSelectedItem().toString(),TP.getSelectedItem().toString(),PD.getSelectedItem().toString());
        consulta.cgm(IGMNoPolizaTxt.getText());
        IGMConyugueBtn.setEnabled(true);
         IGMAseguradoraTxt.setText("");
        IGMNoPolizaTxt.setText("");
        IGMNoCertificadoTxt.setText("");
        IGMNomPlanTxt.setText("");
        IIGM1DescTxt.setText("");
        IGMfechaEfecTxt.setText("");
        IGMfechaEfecTxt1.setText("");
        IGMMaxVitaTxt.setText("");
        IGmSumaAvidaTxt.setText("");
        IGmEstadoPolTxt.setText("");
        consulta.mostrar_tabla3();
}
    }//GEN-LAST:event_Btn_aceptar_reg3ActionPerformed

    private void limpiar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar8ActionPerformed
       IGMAseguradoraTxt.setText("");
        IGMNoPolizaTxt.setText("");
        IGMNoCertificadoTxt.setText("");
        IGMNomPlanTxt.setText("");
        IIGM1DescTxt.setText("");
        IGMfechaEfecTxt.setText("");
        IGMfechaEfecTxt1.setText("");
        IGMMaxVitaTxt.setText("");
        IGmSumaAvidaTxt.setText("");
        IGmEstadoPolTxt.setText("");
    }//GEN-LAST:event_limpiar8ActionPerformed

    private void IGMConyugueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMConyugueBtnActionPerformed
        GM.setSelectedIndex(1);
    }//GEN-LAST:event_IGMConyugueBtnActionPerformed

    private void limpiar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar9ActionPerformed
      if(IGMAseguradoraTxt.getText().equals("") || IGMNoPolizaTxt.getText().equals("") || IGMfechaEfecTxt.getText().equals("") || IGMfechaEfecTxt1.getText().equals(""))
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Fecha Efectiva.");
        }else{
        
        try {
           String id = IGMNoPolizaTxt.getText();
            String sql = "UPDATE tbl_gastos_medicos SET IdAseguradora_gm='"+IGMAseguradoraTxt.getText()+"',NoCertificado_gm='"+IGMNoCertificadoTxt.getText()+"',NombrePlan_gm='"+IGMNomPlanTxt.getText()+"',Cobertura_gm='"
           +CB.getSelectedItem()+"',DescripcionCobertura_gm='"+IIGM1DescTxt.getText()+"',TipoPoliza_gm='"+TP.getSelectedItem()+"',FechaEfectivaInicio_gm='"
           +IGMfechaEfecTxt.getText()+"',FechaEfectivaFin_gm='"+IGMfechaEfecTxt1.getText()+"',MaximoVitalicio_gm='"+IGMMaxVitaTxt.getText()+"',SumaVida_gm='"
           +IGmSumaAvidaTxt.getText()+"',PlanDental_gm='"+PD.getSelectedItem()+"',EstadoPoliza_gm='"+IGmEstadoPolTxt.getText()+"' WHERE NoPoliza_gm="+id+"";
            
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            
            consulta.cgm(id);
        IGMAseguradoraTxt.setText("");
        IGMNoPolizaTxt.setText("");
        IGMNoCertificadoTxt.setText("");
        IGMNomPlanTxt.setText("");
        IIGM1DescTxt.setText("");
        IGMfechaEfecTxt.setText("");
        IGMfechaEfecTxt1.setText("");
        IGMMaxVitaTxt.setText("");
        IGmSumaAvidaTxt.setText("");
        IGmEstadoPolTxt.setText("");
            GM.setSelectedIndex(6);
              consulta.mostrar_tabla3();
            JOptionPane.showMessageDialog(null,"ACTUALIZADO");
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        } }
    }//GEN-LAST:event_limpiar9ActionPerformed

    private void IGMSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMSalirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_IGMSalirBtnActionPerformed

    private void IGMvolverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMvolverBtnActionPerformed
        GM.setSelectedIndex(0);
    }//GEN-LAST:event_IGMvolverBtnActionPerformed

    private void IGMAtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMAtrasBtnActionPerformed
        GM.setSelectedIndex(2);
    }//GEN-LAST:event_IGMAtrasBtnActionPerformed

    private void Cclt1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cclt1ComboBoxActionPerformed

    private void Cclt1BusquedaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1BusquedaTxtActionPerformed

    }//GEN-LAST:event_Cclt1BusquedaTxtActionPerformed

    private void CcltLimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltLimpiarBtnActionPerformed
    Cclt1BusquedaTxt.setText("");  consulta.mostrar_tabla1();
    }//GEN-LAST:event_CcltLimpiarBtnActionPerformed

    private void CcltBuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltBuscarBtnActionPerformed
        String campo = Cclt1ComboBox.getSelectedItem().toString();

        Buscar1(src.Campo2(campo),Cclt1BusquedaTxt.getText());
    }//GEN-LAST:event_CcltBuscarBtnActionPerformed

    private void CcltSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltSalirBtnActionPerformed
        GM.setSelectedIndex(0);
    }//GEN-LAST:event_CcltSalirBtnActionPerformed

    private void TblCC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCC1MouseClicked
        int fila  = TblCC1.getSelectedRow();String Id;
        if (fila>=0){
            Id = valueOf(TblCC1.getValueAt(fila, 0));
            cc2(Id);
            GM.setSelectedIndex(2);
        }
    }//GEN-LAST:event_TblCC1MouseClicked

    private void Cclt2SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt2SalirBtnActionPerformed
        GM.setSelectedIndex(1);
    }//GEN-LAST:event_Cclt2SalirBtnActionPerformed

    private void CcltModificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltModificarBtnActionPerformed
        GM.setSelectedIndex(3);
    }//GEN-LAST:event_CcltModificarBtnActionPerformed

    private void IngresosMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosMenu2BtnActionPerformed
        limpiar9.setEnabled(false);
        IGMConyugueBtn.setEnabled(false);
        IGMNoPolizaTxt.setEnabled(true);
         Btn_aceptar_reg3.setEnabled(true);
        GM.setSelectedIndex(1);
    }//GEN-LAST:event_IngresosMenu2BtnActionPerformed

    private void EliminarMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMenu2BtnActionPerformed
        GM.setSelectedIndex(5);
    }//GEN-LAST:event_EliminarMenu2BtnActionPerformed

    private void ConsultaMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaMenu2BtnActionPerformed
       GM.setSelectedIndex(5);
    }//GEN-LAST:event_ConsultaMenu2BtnActionPerformed

    private void ModificacionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificacionMenu2BtnActionPerformed
        GM.setSelectedIndex(5);
    }//GEN-LAST:event_ModificacionMenu2BtnActionPerformed

    private void IGM2IngresarPagTxt1limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt1limpiar18ActionPerformed
        Ingresos fam = new Ingresos();

        fam.IngresosFam(TblGM2.getValueAt(1,1).toString(), TblGM2.getValueAt(2,1).toString());
    }//GEN-LAST:event_IGM2IngresarPagTxt1limpiar18ActionPerformed

    private void IGM2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2AtrasBtn1ActionPerformed
        GM.setSelectedIndex(3);
    }//GEN-LAST:event_IGM2AtrasBtn1ActionPerformed

    private void CGMBusquedaCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMBusquedaCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CGMBusquedaCbxActionPerformed

    private void CGMLimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMLimpiarBtnActionPerformed
               CGMBusquedaTxt.setText(""); consulta.mostrar_tabla3();
    }//GEN-LAST:event_CGMLimpiarBtnActionPerformed

    private void CGMBuscarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMBuscarbtnActionPerformed
        src.Buscar3(src.Campo4(CGMBusquedaCbx.getSelectedItem().toString()),CGMBusquedaTxt.getText());
    }//GEN-LAST:event_CGMBuscarbtnActionPerformed

    private void CGMSalirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMSalirbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CGMSalirbtnActionPerformed

    private void TblGM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblGM1MouseClicked
        int fila  = TblGM1.getSelectedRow(); String Id;
        if (fila>=0){
            Id = valueOf(TblGM1.getValueAt(fila, 1));
            consulta.cgm(Id);
            GM.setSelectedIndex(6);
        }else{
            JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
        }
    }//GEN-LAST:event_TblGM1MouseClicked

    private void CGM2VolverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtnActionPerformed
        GM.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtnActionPerformed

    private void CGM2AtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtnActionPerformed
        GM.setSelectedIndex(5);
    }//GEN-LAST:event_CGM2AtrasBtnActionPerformed

    private void CGMSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMSalirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CGMSalirBtnActionPerformed

    private void CV2CoberturasyCobBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtn1ActionPerformed
        int fila  = TblGM1.getSelectedRow();
        String NoPol;
        if (fila>=0){
            NoPol = valueOf(TblGM1.getValueAt(fila, 1));
            consulta.cgm2(NoPol);
            consulta.cgm3(NoPol);
            GM.setSelectedIndex(7);
        }else{
            JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
        }
    }//GEN-LAST:event_CV2CoberturasyCobBtn1ActionPerformed

    private void CGMElimBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMElimBtnActionPerformed
        GM.setSelectedIndex(5);
        String sql = "DELETE  FROM tbl_gastos_medicos WHERE NoPoliza_gm ="+ TblGM2.getValueAt(2, 1).toString()+"";
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"POLIZA ELIMINADA");
           
            consulta.mostrar_tabla3();
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CGMElimBtnActionPerformed

    private void CGMModBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMModBtnActionPerformed
         Btn_aceptar_reg3.setEnabled(false);
        IGMNoPolizaTxt.setEnabled(false);
        IGMAseguradoraTxt.setText(valueOf(TblGM2.getValueAt(0, 1)));
        IGMNoPolizaTxt.setText(valueOf(TblGM2.getValueAt(2, 1)));
        IGMNoCertificadoTxt.setText(valueOf(TblGM2.getValueAt(3, 1)));
        IGMNomPlanTxt.setText(valueOf(TblGM2.getValueAt(4, 1)));
        CB.setSelectedItem(valueOf(TblGM2.getValueAt(5, 1)));
        PD.setSelectedItem(valueOf(TblGM2.getValueAt(11, 1)));        
        IIGM1DescTxt.setText(IIGM1DescTxt1.getText());
        IGMfechaEfecTxt.setText(valueOf(TblGM2.getValueAt(7, 1)));
        IGMfechaEfecTxt1.setText(valueOf(TblGM2.getValueAt(8, 1)));
        IGMMaxVitaTxt.setText(valueOf(TblGM2.getValueAt(9, 1)));
        IGmSumaAvidaTxt.setText(valueOf(TblGM2.getValueAt(10, 1)));
        IGmEstadoPolTxt.setText(valueOf(TblGM2.getValueAt(12, 1)));
        limpiar9.setEnabled(true);
        GM.setSelectedIndex(3);
    }//GEN-LAST:event_CGMModBtnActionPerformed

    private void CGM2VolverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn1ActionPerformed
        GM.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn1ActionPerformed

    private void CGM2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn1ActionPerformed
        GM.setSelectedIndex(6);
    }//GEN-LAST:event_CGM2AtrasBtn1ActionPerformed

    private void CGMSalirBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMSalirBtn1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_CGMSalirBtn1ActionPerformed

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated
                                               

    }//GEN-LAST:event_formInternalFrameDeactivated

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
       this.setSize(1462, 798);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
       this.setSize(220, 40);
    }//GEN-LAST:event_formInternalFrameIconified

    private void CGM2VolverBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn2ActionPerformed
        GM.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn2ActionPerformed

    private void CGM2AtrasBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn2ActionPerformed
      GM.setSelectedIndex(4);
    }//GEN-LAST:event_CGM2AtrasBtn2ActionPerformed

    private void CGM2AtrasBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn3ActionPerformed
        String id = TblCGM4.getValueAt(TblCGM4.getSelectedRow(),1).toString();
        String sql = "DELETE  FROM tbl_familiares WHERE IdFamiliar ='"+id+"'";
        String NoPol="";
        if(TblGM1.getSelectedRow()<0){JOptionPane.showMessageDialog(null,"POR FAVOR SELECCIONE UN ASEGURADO");}else{
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null," ELIMINADO");
            
            NoPol = valueOf(TblGM1.getValueAt(TblGM1.getSelectedRow(), 1));
            consulta.cgm3(NoPol);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }//GEN-LAST:event_CGM2AtrasBtn3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_aceptar_reg3;
    public static javax.swing.JComboBox<String> CB;
    private javax.swing.JButton CGM2AtrasBtn;
    private javax.swing.JButton CGM2AtrasBtn1;
    private javax.swing.JButton CGM2AtrasBtn2;
    private javax.swing.JButton CGM2AtrasBtn3;
    private javax.swing.JButton CGM2VolverBtn;
    private javax.swing.JButton CGM2VolverBtn1;
    private javax.swing.JButton CGM2VolverBtn2;
    private javax.swing.JButton CGMBuscarbtn;
    public static javax.swing.JComboBox<String> CGMBusquedaCbx;
    private javax.swing.JTextField CGMBusquedaTxt;
    private javax.swing.JButton CGMElimBtn;
    private javax.swing.JButton CGMLimpiarBtn;
    private javax.swing.JButton CGMModBtn;
    private javax.swing.JButton CGMSalirBtn;
    private javax.swing.JButton CGMSalirBtn1;
    private javax.swing.JButton CGMSalirbtn;
    private javax.swing.JButton CV2CoberturasyCobBtn1;
    private javax.swing.JPanel C_CLIENTES1;
    private javax.swing.JPanel C_CLIENTES2;
    private javax.swing.JPanel C_GM1;
    private javax.swing.JPanel C_GM2;
    private javax.swing.JPanel C_GM3;
    private javax.swing.JTextField Cclt1BusquedaTxt;
    public static javax.swing.JComboBox<String> Cclt1ComboBox;
    private javax.swing.JButton Cclt2SalirBtn;
    private javax.swing.JButton CcltBuscarBtn;
    private javax.swing.JButton CcltLimpiarBtn;
    private javax.swing.JButton CcltModificarBtn;
    private javax.swing.JButton CcltSalirBtn;
    private javax.swing.JButton ConsultaMenu2Btn;
    private javax.swing.JButton EliminarMenu2Btn;
    private javax.swing.JTabbedPane GM;
    private javax.swing.JButton IGM2AtrasBtn1;
    private javax.swing.JButton IGM2IngresarPagTxt1;
    public static javax.swing.JTextField IGM2NoReqTxt1;
    public static javax.swing.JTextField IGM2NoReqTxt2;
    public static javax.swing.JTextField IGM2PrimaTxt1;
    public static javax.swing.JTextField IGM2PrimaTxt2;
    public static javax.swing.JTextField IGM2PrimaTxt3;
    public static javax.swing.JTextField IGMAseguradoraTxt;
    private javax.swing.JButton IGMAtrasBtn;
    private javax.swing.JButton IGMConyugueBtn;
    public static javax.swing.JTextField IGMMaxVitaTxt;
    public static javax.swing.JTextField IGMNoCertificadoTxt;
    public static javax.swing.JTextField IGMNoPolizaTxt;
    public static javax.swing.JTextField IGMNomPlanTxt;
    private javax.swing.JButton IGMSalirBtn;
    public static javax.swing.JTextField IGMfechaEfecTxt;
    public static javax.swing.JTextField IGMfechaEfecTxt1;
    public static javax.swing.JTextField IGMfechaPTxt1;
    public static javax.swing.JTextField IGMfechaPTxt2;
    public static javax.swing.JTextField IGMfechaPTxt3;
    public static javax.swing.JTextField IGMfechaPTxt4;
    private javax.swing.JButton IGMvolverBtn;
    public static javax.swing.JTextField IGmEstadoPolTxt;
    public static javax.swing.JTextField IGmSumaAvidaTxt;
    public static javax.swing.JTextArea IIGM1DescTxt;
    public static javax.swing.JTextArea IIGM1DescTxt1;
    private javax.swing.JPanel I_GM1;
    private javax.swing.JPanel I_GM2;
    private javax.swing.JButton IngresosMenu2Btn;
    private javax.swing.JPanel MENU2;
    private javax.swing.JButton ModificacionMenu2Btn;
    public static javax.swing.JComboBox<String> PD;
    public static javax.swing.JComboBox<String> TP;
    public static javax.swing.JTable TblCC1;
    public static javax.swing.JTable TblCC2;
    public static javax.swing.JTable TblCGM3;
    public static javax.swing.JTable TblCGM4;
    public static javax.swing.JTable TblGM1;
    public static javax.swing.JTable TblGM2;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton limpiar8;
    private javax.swing.JButton limpiar9;
    // End of variables declaration//GEN-END:variables
}
