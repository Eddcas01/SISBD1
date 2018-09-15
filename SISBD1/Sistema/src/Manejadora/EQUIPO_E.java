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
public class EQUIPO_E extends javax.swing.JInternalFrame {

    /**
     * Creates new form EQUIPO_E
     */
    
     Consultas consulta = new Consultas();
    Busquedas src = new Busquedas();
    public static int tipo=0;
    Eliminar del =new Eliminar();
    Cliente cl = new Cliente();
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    public EQUIPO_E() {
        initComponents();
        EQUIPO.setEnabled(false);
         mostrar_tabla1();
     if(tipo==2){ModificacionMenu2Btn.setEnabled(false);
       EliminarMenu2Btn.setEnabled(false);
      CGMModBtn.setEnabled(false);
      CGMElimBtn.setEnabled(false);
       }
         Cclt1ComboBox.addItem("Id");
        Cclt1ComboBox.addItem("1er.Nombre");
        Cclt1ComboBox.addItem("2do.Nombre");
        Cclt1ComboBox.addItem("3er.Nombre");
        Cclt1ComboBox.addItem("1er.Apellido");
        Cclt1ComboBox.addItem("2do.Apellido");
        
        COMBO_EE.addItem("Id");
        COMBO_EE.addItem("Poliza");
        COMBO_EE.addItem("Aseguradora");
        COMBO_EE.addItem("Factura");
        COMBO_EE.addItem("Serie");
        COMBO_EE.addItem("Estado");
      
        
        CB.addItem("C.A");
        CB.addItem("Mundial");
       consulta.mostrar_tabla7();
        
    }
    public String Campo6 (String campo){
       String bus="";
       if (campo.equals("Id")){bus="IdCliente_ee";}else{
       if (campo.equals("Poliza")){bus="NoPoliza_ee";}else{ 
           if (campo.equals("Aseguradora")){bus="IdAseguradora_ee";}else{
            if (campo.equals("Factura")){bus="NoFactura_ee";}else{
                if (campo.equals("Serie")){bus="NoSerie_ee";}else{
            if (campo.equals("Estado")){bus="EstadoPoliza_ee";}else{
           JOptionPane.showMessageDialog(null, "ERROR ");}}}}}}
      
       return bus;
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

        EQUIPO = new javax.swing.JTabbedPane();
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
        IDAS_EE = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        NOPOL_EE = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        CERTIFICADO_EE = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        FINICIO_EE = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        SERIE_EE = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        SUMAAS_EE = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        Btn_aceptar_reg3 = new javax.swing.JButton();
        limpiar8 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        CB = new javax.swing.JComboBox<>();
        FFIN_EE = new javax.swing.JTextField();
        ESTADO__EE = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        DESC_EE = new javax.swing.JTextArea();
        limpiar9 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        FACT_EE = new javax.swing.JTextField();
        DEDUCIBLE_EE = new javax.swing.JTextField();
        IGMSalirBtn = new javax.swing.JButton();
        IGMvolverBtn = new javax.swing.JButton();
        IGMAtrasBtn = new javax.swing.JButton();
        C_GM1 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        COMBO_EE = new javax.swing.JComboBox<>();
        BUSCAR_EE = new javax.swing.JTextField();
        CGMLimpiarBtn = new javax.swing.JButton();
        CGMBuscarbtn = new javax.swing.JButton();
        CGMSalirbtn = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        TBL_EE = new javax.swing.JTable();
        C_GM2 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        CGM2VolverBtn = new javax.swing.JButton();
        CGM2AtrasBtn = new javax.swing.JButton();
        CGMSalirBtn = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn1 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        TBL_EE2 = new javax.swing.JTable();
        CGMElimBtn = new javax.swing.JButton();
        CGMModBtn = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        DESC_EE2 = new javax.swing.JTextArea();
        C_GM3 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        CGM2VolverBtn1 = new javax.swing.JButton();
        CGM2AtrasBtn1 = new javax.swing.JButton();
        CGMSalirBtn1 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TBL_EE3 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("EQUIPO ELECTRONICO");
        setMaximumSize(new java.awt.Dimension(1542, 820));
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

        MENU2.setBackground(new java.awt.Color(51, 102, 0));

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
        jLabel77.setFont(new java.awt.Font("Segoe UI Historic", 1, 31)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConsultaMenu2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ModificacionMenu2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EliminarMenu2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(ModificacionMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(EliminarMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConsultaMenu2Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IngresosMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jLabel79.setBackground(new java.awt.Color(0, 0, 51));
        jLabel79.setFont(new java.awt.Font("Segoe UI Historic", 1, 40)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("EQUIPO ELECTRONICO");
        jLabel79.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout MENU2Layout = new javax.swing.GroupLayout(MENU2);
        MENU2.setLayout(MENU2Layout);
        MENU2Layout.setHorizontalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(651, 651, 651))
            .addGroup(MENU2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 1197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        MENU2Layout.setVerticalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );

        EQUIPO.addTab("MENU", MENU2);

        C_CLIENTES1.setBackground(new java.awt.Color(51, 102, 0));
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
                .addContainerGap(303, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(141, 141, 141))
        );

        EQUIPO.addTab("C. CLIENTES 1", C_CLIENTES1);

        C_CLIENTES2.setBackground(new java.awt.Color(51, 102, 0));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
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
                .addContainerGap(61, Short.MAX_VALUE))
        );

        EQUIPO.addTab("C. CLIENTES 2", C_CLIENTES2);

        I_GM1.setBackground(new java.awt.Color(51, 102, 0));
        I_GM1.setPreferredSize(new java.awt.Dimension(1880, 824));

        jLabel9.setBackground(new java.awt.Color(0, 0, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EQUIPO ELECTRONICO");
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel27.setBackground(new java.awt.Color(0, 0, 51));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel27.setOpaque(false);

        IDAS_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IDAS_EE.setForeground(new java.awt.Color(0, 0, 51));
        IDAS_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel58.setBackground(new java.awt.Color(0, 0, 51));
        jLabel58.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("No. POLIZA");
        jLabel58.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        NOPOL_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOPOL_EE.setForeground(new java.awt.Color(0, 0, 51));
        NOPOL_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel59.setBackground(new java.awt.Color(0, 0, 51));
        jLabel59.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("No. CERTIFICADO");
        jLabel59.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CERTIFICADO_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CERTIFICADO_EE.setForeground(new java.awt.Color(0, 0, 51));
        CERTIFICADO_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel65.setBackground(new java.awt.Color(0, 0, 51));
        jLabel65.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("COBERTURA");
        jLabel65.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel70.setBackground(new java.awt.Color(0, 0, 51));
        jLabel70.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("FECHA EFECTIVA");
        jLabel70.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        FINICIO_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        FINICIO_EE.setForeground(new java.awt.Color(0, 0, 51));
        FINICIO_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel71.setBackground(new java.awt.Color(0, 0, 51));
        jLabel71.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("NO. SERIE");
        jLabel71.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        SERIE_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        SERIE_EE.setForeground(new java.awt.Color(0, 0, 51));
        SERIE_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel72.setBackground(new java.awt.Color(0, 0, 51));
        jLabel72.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("DEDUCIBLE ROBO");
        jLabel72.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        SUMAAS_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        SUMAAS_EE.setForeground(new java.awt.Color(0, 0, 51));
        SUMAAS_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel73.setBackground(new java.awt.Color(0, 0, 51));
        jLabel73.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("SUMA ASEGURADA");
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

        CB.setBackground(new java.awt.Color(204, 204, 204));
        CB.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CB.setMaximumRowCount(2);
        CB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N

        FFIN_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        FFIN_EE.setForeground(new java.awt.Color(0, 0, 51));
        FFIN_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ESTADO__EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        ESTADO__EE.setForeground(new java.awt.Color(0, 0, 51));
        ESTADO__EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        DESC_EE.setColumns(20);
        DESC_EE.setRows(5);
        jScrollPane8.setViewportView(DESC_EE);

        limpiar9.setBackground(new java.awt.Color(0, 0, 0));
        limpiar9.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        limpiar9.setForeground(new java.awt.Color(255, 255, 255));
        limpiar9.setText("ACTUALIZAR");
        limpiar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar9ActionPerformed(evt);
            }
        });

        jLabel80.setBackground(new java.awt.Color(0, 0, 51));
        jLabel80.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("NO. FACTURA");
        jLabel80.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        FACT_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        FACT_EE.setForeground(new java.awt.Color(0, 0, 51));
        FACT_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        DEDUCIBLE_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        DEDUCIBLE_EE.setForeground(new java.awt.Color(0, 0, 51));
        DEDUCIBLE_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                            .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDAS_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NOPOL_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CERTIFICADO_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(FINICIO_EE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FFIN_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SERIE_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SUMAAS_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DEDUCIBLE_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ESTADO__EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FACT_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limpiar9, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(Btn_aceptar_reg3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limpiar8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap(58, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IDAS_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NOPOL_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CERTIFICADO_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FINICIO_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FFIN_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FACT_EE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addComponent(SERIE_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SUMAAS_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DEDUCIBLE_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ESTADO__EE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_aceptar_reg3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limpiar8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpiar9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
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
                .addContainerGap(58, Short.MAX_VALUE))
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
                .addContainerGap(38, Short.MAX_VALUE))
        );

        EQUIPO.addTab("I EQUIPO E", I_GM1);

        C_GM1.setBackground(new java.awt.Color(51, 102, 0));
        C_GM1.setPreferredSize(new java.awt.Dimension(1530, 950));

        jLabel67.setBackground(new java.awt.Color(0, 0, 51));
        jLabel67.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("EQUIPO ELECTRONICO");
        jLabel67.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        COMBO_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        COMBO_EE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMBO_EEActionPerformed(evt);
            }
        });

        BUSCAR_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        BUSCAR_EE.setForeground(new java.awt.Color(0, 0, 51));
        BUSCAR_EE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        TBL_EE.setBackground(new java.awt.Color(0, 0, 51));
        TBL_EE.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_EE.setForeground(new java.awt.Color(255, 255, 255));
        TBL_EE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_EE.setAlignmentX(1.0F);
        TBL_EE.setAlignmentY(1.0F);
        TBL_EE.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBL_EE.setGridColor(new java.awt.Color(0, 153, 204));
        TBL_EE.setRowHeight(30);
        TBL_EE.setSelectionBackground(new java.awt.Color(0, 102, 204));
        TBL_EE.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TBL_EE.setShowVerticalLines(false);
        TBL_EE.getTableHeader().setReorderingAllowed(false);
        TBL_EE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_EEMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(TBL_EE);

        javax.swing.GroupLayout C_GM1Layout = new javax.swing.GroupLayout(C_GM1);
        C_GM1.setLayout(C_GM1Layout);
        C_GM1Layout.setHorizontalGroup(
            C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BUSCAR_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMBuscarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(COMBO_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(372, 372, 372)
                        .addComponent(CGMSalirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        C_GM1Layout.setVerticalGroup(
            C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BUSCAR_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(COMBO_EE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(C_GM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CGMLimpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMBuscarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(C_GM1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(CGMSalirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        EQUIPO.addTab("C EQUIPO E", C_GM1);

        C_GM2.setBackground(new java.awt.Color(51, 102, 0));

        jLabel68.setBackground(new java.awt.Color(0, 0, 51));
        jLabel68.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("EQUIPO ELECTRONICO");
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
        jScrollPane9.setViewportView(TBL_EE2);

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

        DESC_EE2.setColumns(20);
        DESC_EE2.setRows(5);
        jScrollPane15.setViewportView(DESC_EE2);

        javax.swing.GroupLayout C_GM2Layout = new javax.swing.GroupLayout(C_GM2);
        C_GM2.setLayout(C_GM2Layout);
        C_GM2Layout.setHorizontalGroup(
            C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, C_GM2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, C_GM2Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CV2CoberturasyCobBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMModBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMElimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
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
                        .addGap(59, 59, 59)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(CGM2VolverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CGMSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(CV2CoberturasyCobBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(C_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM2Layout.createSequentialGroup()
                        .addComponent(CGMModBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CGMElimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        EQUIPO.addTab("C EQUIPO E 2", C_GM2);

        C_GM3.setBackground(new java.awt.Color(51, 102, 0));

        jLabel81.setBackground(new java.awt.Color(255, 255, 255));
        jLabel81.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("EQUIPO ELECTRONICO");
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

        TBL_EE3.setBackground(new java.awt.Color(0, 0, 51));
        TBL_EE3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_EE3.setForeground(new java.awt.Color(255, 255, 255));
        TBL_EE3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_EE3.setAlignmentX(1.0F);
        TBL_EE3.setAlignmentY(1.0F);
        TBL_EE3.setRowHeight(30);
        TBL_EE3.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TBL_EE3.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setViewportView(TBL_EE3);

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
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CGMSalirBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CGM2VolverBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                .addGap(174, 174, 174))
        );
        C_GM3Layout.setVerticalGroup(
            C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM3Layout.createSequentialGroup()
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM3Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(CGM2VolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CGMSalirBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(325, Short.MAX_VALUE))
        );

        EQUIPO.addTab("C EQUIPO E 3", C_GM3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(EQUIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 1532, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EQUIPO, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cclt1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cclt1ComboBoxActionPerformed

    private void Cclt1BusquedaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1BusquedaTxtActionPerformed

    }//GEN-LAST:event_Cclt1BusquedaTxtActionPerformed

    private void CcltLimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltLimpiarBtnActionPerformed
        consulta.mostrar_tabla1(); Cclt1BusquedaTxt.setText("");
    }//GEN-LAST:event_CcltLimpiarBtnActionPerformed

    private void CcltBuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltBuscarBtnActionPerformed
        String campo = Cclt1ComboBox.getSelectedItem().toString();

        Buscar1(src.Campo2(campo),Cclt1BusquedaTxt.getText());
    }//GEN-LAST:event_CcltBuscarBtnActionPerformed

    private void CcltSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltSalirBtnActionPerformed
        EQUIPO.setSelectedIndex(0);
    }//GEN-LAST:event_CcltSalirBtnActionPerformed

    private void TblCC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCC1MouseClicked
        int fila  = TblCC1.getSelectedRow();String Id;
        if (fila>=0){
            Id = valueOf(TblCC1.getValueAt(fila, 0));
            cc2(Id);
            EQUIPO.setSelectedIndex(2);
        }
    }//GEN-LAST:event_TblCC1MouseClicked

    private void IngresosMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosMenu2BtnActionPerformed
        EQUIPO.setSelectedIndex(1);limpiar9.setEnabled(false);;Btn_aceptar_reg3.setEnabled(true);
    }//GEN-LAST:event_IngresosMenu2BtnActionPerformed

    private void EliminarMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMenu2BtnActionPerformed
        EQUIPO.setSelectedIndex(5);
    }//GEN-LAST:event_EliminarMenu2BtnActionPerformed

    private void ConsultaMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaMenu2BtnActionPerformed
        EQUIPO.setSelectedIndex(5);
    }//GEN-LAST:event_ConsultaMenu2BtnActionPerformed

    private void ModificacionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificacionMenu2BtnActionPerformed
        EQUIPO.setSelectedIndex(5);
    }//GEN-LAST:event_ModificacionMenu2BtnActionPerformed

    private void Cclt2SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt2SalirBtnActionPerformed
        EQUIPO.setSelectedIndex(1);
    }//GEN-LAST:event_Cclt2SalirBtnActionPerformed

    private void CcltModificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltModificarBtnActionPerformed
        EQUIPO.setSelectedIndex(3);
    }//GEN-LAST:event_CcltModificarBtnActionPerformed

    private void Btn_aceptar_reg3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_aceptar_reg3ActionPerformed

        if(IDAS_EE.getText().equals("")|| NOPOL_EE.getText().equals("") || FINICIO_EE.getText().equals("") || FFIN_EE.getText().equals("") )
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Fecha Efectiva.");
        }else{
        Ingresos ee = new Ingresos();
         ee.ingresoEE(TblCC1.getValueAt(TblCC1.getSelectedRow(),0).toString(), CB.getSelectedItem().toString());
        IDAS_EE.setText("");
        NOPOL_EE.setText("");
        CERTIFICADO_EE.setText("");
        DESC_EE.setText("");
        FINICIO_EE.setText("");
        FFIN_EE.setText("");
        FACT_EE.setText("");
        SERIE_EE.setText("");
        SUMAAS_EE.setText("");
        DEDUCIBLE_EE.setText("");
        ESTADO__EE.setText("");
        }
    }//GEN-LAST:event_Btn_aceptar_reg3ActionPerformed

    private void limpiar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar8ActionPerformed
          IDAS_EE.setText("");
        NOPOL_EE.setText("");
        CERTIFICADO_EE.setText("");
        DESC_EE.setText("");
        FINICIO_EE.setText("");
        FFIN_EE.setText("");
        FACT_EE.setText("");
        SERIE_EE.setText("");
        SUMAAS_EE.setText("");
        DEDUCIBLE_EE.setText("");
        ESTADO__EE.setText("");
    }//GEN-LAST:event_limpiar8ActionPerformed

    private void limpiar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar9ActionPerformed
        if(IDAS_EE.getText().equals("")|| NOPOL_EE.getText().equals("") || FINICIO_EE.getText().equals("") || FFIN_EE.getText().equals("") )
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Fecha Efectiva.");
        }else{
        try {
           String id = TBL_EE.getValueAt(TBL_EE.getSelectedRow(),1).toString();
            String sql = "UPDATE tbl_equipo_electronico SET IdAseguradora_ee='"+IDAS_EE.getText()
                    + "',NoCertificado_ee='"+CERTIFICADO_EE.getText()+"',VigenciaInicio_ee='"+FINICIO_EE.getText()+"',VigenciaFin_ee='"+FFIN_EE.getText()
                    + "',Cobertura_ee='"+CB.getSelectedItem()+"',DescripcionCobertura_ee='"+DESC_EE.getText()+"',NoFactura_ee='"+FACT_EE.getText()+"',NoSerie_ee='"+SERIE_EE.getText()
                    + "',SumaAsegurada_ee='"+SUMAAS_EE.getText()+"',DeducibleRobo_ee='"+DEDUCIBLE_EE.getText()+"',EstadoPoliza_ee='"+ESTADO__EE.getText()+"' WHERE NoPoliza_ee='"+id+"'";
            
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            
            consulta.cee(id);
            JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                EQUIPO.setSelectedIndex(4);
              consulta.mostrar_tabla7();
                IDAS_EE.setText("");
        NOPOL_EE.setText("");
        CERTIFICADO_EE.setText("");
        DESC_EE.setText("");
        FINICIO_EE.setText("");
        FFIN_EE.setText("");
        FACT_EE.setText("");
        SERIE_EE.setText("");
        SUMAAS_EE.setText("");
        DEDUCIBLE_EE.setText("");
        ESTADO__EE.setText("");
           
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);}
        } 
    }//GEN-LAST:event_limpiar9ActionPerformed

    private void IGMSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMSalirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_IGMSalirBtnActionPerformed

    private void IGMvolverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMvolverBtnActionPerformed
        EQUIPO.setSelectedIndex(0);
    }//GEN-LAST:event_IGMvolverBtnActionPerformed

    private void IGMAtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMAtrasBtnActionPerformed
        EQUIPO.setSelectedIndex(2);
    }//GEN-LAST:event_IGMAtrasBtnActionPerformed

    private void COMBO_EEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMBO_EEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COMBO_EEActionPerformed

    private void CGMLimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMLimpiarBtnActionPerformed
     consulta.mostrar_tabla7();BUSCAR_EE.setText("");
    }//GEN-LAST:event_CGMLimpiarBtnActionPerformed

    private void CGMBuscarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMBuscarbtnActionPerformed
        src.Busquedaee(Campo6(COMBO_EE.getSelectedItem().toString()),BUSCAR_EE.getText());
    }//GEN-LAST:event_CGMBuscarbtnActionPerformed

    private void CGMSalirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMSalirbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CGMSalirbtnActionPerformed

    private void TBL_EEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_EEMouseClicked
        int fila  = TBL_EE.getSelectedRow(); String Id;
        if (fila>=0){
            Id = valueOf(TBL_EE.getValueAt(fila, 1));
            consulta.cee(Id);
            EQUIPO.setSelectedIndex(5);
        }else{
            JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
        }
    }//GEN-LAST:event_TBL_EEMouseClicked

    private void CGM2VolverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtnActionPerformed
        EQUIPO.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtnActionPerformed

    private void CGM2AtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtnActionPerformed
        EQUIPO.setSelectedIndex(4);
    }//GEN-LAST:event_CGM2AtrasBtnActionPerformed

    private void CGMSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMSalirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CGMSalirBtnActionPerformed

    private void CV2CoberturasyCobBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtn1ActionPerformed
        int fila  = TBL_EE.getSelectedRow();
        String NoPol;
        if (fila>=0){
            NoPol = valueOf(TBL_EE.getValueAt(fila, 1));
            
            consulta.cee2(NoPol);
           EQUIPO.setSelectedIndex(6);
        }else{
            JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
        }
    }//GEN-LAST:event_CV2CoberturasyCobBtn1ActionPerformed

    private void CGMElimBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMElimBtnActionPerformed
        EQUIPO.setSelectedIndex(4);
        String sql = "DELETE  FROM tbl_equipo_electronico WHERE NoPoliza_ee ="+ TBL_EE2.getValueAt(1, 1).toString()+"";
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"POLIZA ELIMINADA");

            consulta.mostrar_tabla7();
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CGMElimBtnActionPerformed

    private void CGMModBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMModBtnActionPerformed
        Btn_aceptar_reg3.setEnabled(false);
        IDAS_EE.setText(cl.datosvd2(valueOf(TBL_EE2.getValueAt(0, 1))));
        NOPOL_EE.setText(valueOf(TBL_EE2.getValueAt(1, 1)));
        CERTIFICADO_EE.setText(valueOf(TBL_EE2.getValueAt(3, 1)));
        DESC_EE.setText(DESC_EE2.getText());
        FINICIO_EE.setText(valueOf(TBL_EE2.getValueAt(4, 1)));
        FFIN_EE.setText(valueOf(TBL_EE2.getValueAt(5, 1)));
        CB.setSelectedItem(valueOf(TBL_EE2.getValueAt(6, 1)));
        FACT_EE.setText(valueOf(TBL_EE2.getValueAt(7, 1)));
        SERIE_EE.setText(valueOf(TBL_EE2.getValueAt(8, 1)));
        SUMAAS_EE.setText(valueOf(TBL_EE2.getValueAt(9, 1)));
        DEDUCIBLE_EE.setText(valueOf(TBL_EE2.getValueAt(10, 1)));
        ESTADO__EE.setText(valueOf(TBL_EE2.getValueAt(11, 1)));
        limpiar9.setEnabled(true);
        EQUIPO.setSelectedIndex(3);
    }//GEN-LAST:event_CGMModBtnActionPerformed

    private void CGM2VolverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn1ActionPerformed
        EQUIPO.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn1ActionPerformed

    private void CGM2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn1ActionPerformed
        EQUIPO.setSelectedIndex(5);
    }//GEN-LAST:event_CGM2AtrasBtn1ActionPerformed

    private void CGMSalirBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMSalirBtn1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CGMSalirBtn1ActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        this.setSize(1542, 820);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
          this.setSize(250, 40);
    }//GEN-LAST:event_formInternalFrameIconified


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BUSCAR_EE;
    private javax.swing.JButton Btn_aceptar_reg3;
    public static javax.swing.JComboBox<String> CB;
    public static javax.swing.JTextField CERTIFICADO_EE;
    private javax.swing.JButton CGM2AtrasBtn;
    private javax.swing.JButton CGM2AtrasBtn1;
    private javax.swing.JButton CGM2VolverBtn;
    private javax.swing.JButton CGM2VolverBtn1;
    private javax.swing.JButton CGMBuscarbtn;
    private javax.swing.JButton CGMElimBtn;
    private javax.swing.JButton CGMLimpiarBtn;
    private javax.swing.JButton CGMModBtn;
    private javax.swing.JButton CGMSalirBtn;
    private javax.swing.JButton CGMSalirBtn1;
    private javax.swing.JButton CGMSalirbtn;
    public static javax.swing.JComboBox<String> COMBO_EE;
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
    public static javax.swing.JTextField DEDUCIBLE_EE;
    public static javax.swing.JTextArea DESC_EE;
    public static javax.swing.JTextArea DESC_EE2;
    private javax.swing.JTabbedPane EQUIPO;
    public static javax.swing.JTextField ESTADO__EE;
    private javax.swing.JButton EliminarMenu2Btn;
    public static javax.swing.JTextField FACT_EE;
    public static javax.swing.JTextField FFIN_EE;
    public static javax.swing.JTextField FINICIO_EE;
    public static javax.swing.JTextField IDAS_EE;
    private javax.swing.JButton IGMAtrasBtn;
    private javax.swing.JButton IGMSalirBtn;
    private javax.swing.JButton IGMvolverBtn;
    private javax.swing.JPanel I_GM1;
    private javax.swing.JButton IngresosMenu2Btn;
    private javax.swing.JPanel MENU2;
    private javax.swing.JButton ModificacionMenu2Btn;
    public static javax.swing.JTextField NOPOL_EE;
    public static javax.swing.JTextField SERIE_EE;
    public static javax.swing.JTextField SUMAAS_EE;
    public static javax.swing.JTable TBL_EE;
    public static javax.swing.JTable TBL_EE2;
    public static javax.swing.JTable TBL_EE3;
    public static javax.swing.JTable TblCC1;
    public static javax.swing.JTable TblCC2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel65;
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
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JScrollPane jScrollPane10;
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
