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
import java.sql.PreparedStatement;
import java.sql.Connection;
import static java.lang.String.valueOf;
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
public class VIDA extends javax.swing.JInternalFrame {

    /**
     * Creates new form VIDA
     */
    Consultas consulta = new Consultas();
    Busquedas src = new Busquedas();
   public static int tipo=0;
    Eliminar del =new Eliminar();
    Cliente cl = new Cliente();
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    public VIDA() {
        initComponents();
        VIDA.setEnabled(false);
       if(tipo!=1 && tipo!=0){ModificacionMenu2Btn.setEnabled(false);
       EliminarMenu2Btn.setEnabled(false);
       CGMModBtn1.setEnabled(false);
       CGMElimBtn1.setEnabled(false);
       }
        mostrar_tabla1();
        consulta.mostrar_tabla6();
        Cclt1ComboBox.addItem("Id");
        Cclt1ComboBox.addItem("1er.Nombre");
        Cclt1ComboBox.addItem("2do.Nombre");
        Cclt1ComboBox.addItem("3er.Nombre");
        Cclt1ComboBox.addItem("1er.Apellido");
        Cclt1ComboBox.addItem("2do.Apellido");
        COMBO_VD.addItem("Id");
        COMBO_VD.addItem("Aseguradora");
        COMBO_VD.addItem("Poliza");
        COMBO_VD.addItem("Estado");
    }
    
     public String Campo5 (String campo){
       String bus="";
       if (campo.equals("Id")){bus="IdCliente_vd";}else{
       if (campo.equals("Poliza")){bus="NoPoliza_vd";}else{ 
           if (campo.equals("Aseguradora")){bus="IdAseguradora_vd";}else{
            if (campo.equals("Estado")){bus="EstadoPoliza_vd";}else{
           JOptionPane.showMessageDialog(null, "ERROR ");}}}}
      
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

        VIDA = new javax.swing.JTabbedPane();
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
        I_VIDA1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        IDAS_VD = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        NOPOL_VD = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        SUMAAS_VD = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        FI_VD = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        PRIMA_VD = new javax.swing.JTextField();
        Btn_aceptar_reg4 = new javax.swing.JButton();
        limpiar10 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        IGMConyugueBtn1 = new javax.swing.JButton();
        FF_VD = new javax.swing.JTextField();
        ESTADO_VD = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        DESCCOBRETURAS_VD = new javax.swing.JTextArea();
        limpiar11 = new javax.swing.JButton();
        COBERTURA_VD = new javax.swing.JTextField();
        IGMvolverBtn1 = new javax.swing.JButton();
        IGMAtrasBtn1 = new javax.swing.JButton();
        I_GM2 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        NOMBRE_BFO = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        DPI_BFO = new javax.swing.JTextField();
        IGM2IngresarPagTxt1 = new javax.swing.JButton();
        FNAC_BFO = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        PARENTESCO_BFO = new javax.swing.JTextField();
        IGM2AtrasBtn1 = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        COMBO_VD = new javax.swing.JComboBox<>();
        BUSCAR_VD = new javax.swing.JTextField();
        CGMVolverBtn1 = new javax.swing.JButton();
        CGMLimpiarBtn1 = new javax.swing.JButton();
        CGMBuscarbtn1 = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        TBL_VD = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        CGM2VolverBtn2 = new javax.swing.JButton();
        CGM2AtrasBtn2 = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        CV2CoberturasyCobBtn2 = new javax.swing.JButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        TBL_VD2 = new javax.swing.JTable();
        CGMElimBtn1 = new javax.swing.JButton();
        CGMModBtn1 = new javax.swing.JButton();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        DESC_VD2 = new javax.swing.JTextArea();
        C_GM3 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        CGM2VolverBtn1 = new javax.swing.JButton();
        CGM2AtrasBtn1 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TBL_CBR_VIDA = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        TBL_BENEFICIARIOS = new javax.swing.JTable();
        CGM2AtrasBtn3 = new javax.swing.JButton();
        CGM2AtrasBtn4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("SEG. VIDA");
        setMaximumSize(new java.awt.Dimension(1530, 943));
        setPreferredSize(new java.awt.Dimension(1530, 943));
        setRequestFocusEnabled(false);
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

        MENU2.setBackground(new java.awt.Color(102, 0, 0));
        MENU2.setMaximumSize(new java.awt.Dimension(1530, 943));
        MENU2.setPreferredSize(new java.awt.Dimension(1530, 943));

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
        jLabel76.setText("ELIMINAR");
        jLabel76.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel77.setBackground(new java.awt.Color(0, 0, 51));
        jLabel77.setFont(new java.awt.Font("Segoe UI Historic", 1, 31)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("MODIFICAR");
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
        jLabel79.setText("SEG. VIDA");
        jLabel79.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout MENU2Layout = new javax.swing.GroupLayout(MENU2);
        MENU2.setLayout(MENU2Layout);
        MENU2Layout.setHorizontalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU2Layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(697, 697, 697))
            .addGroup(MENU2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MENU2Layout.setVerticalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        VIDA.addTab("MENU", MENU2);

        C_CLIENTES1.setBackground(new java.awt.Color(102, 0, 0));
        C_CLIENTES1.setMaximumSize(new java.awt.Dimension(1530, 943));
        C_CLIENTES1.setPreferredSize(new java.awt.Dimension(1530, 943));

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
                .addContainerGap(296, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addGap(141, 141, 141))
        );

        VIDA.addTab("C. CLIENTES 1", C_CLIENTES1);

        C_CLIENTES2.setBackground(new java.awt.Color(102, 0, 0));
        C_CLIENTES2.setMaximumSize(new java.awt.Dimension(1530, 943));
        C_CLIENTES2.setPreferredSize(new java.awt.Dimension(1530, 943));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
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
                .addContainerGap(184, Short.MAX_VALUE))
        );

        VIDA.addTab("C. CLIENTES 2", C_CLIENTES2);

        I_VIDA1.setBackground(new java.awt.Color(102, 0, 0));
        I_VIDA1.setMaximumSize(new java.awt.Dimension(1530, 943));
        I_VIDA1.setPreferredSize(new java.awt.Dimension(1530, 943));

        jLabel10.setBackground(new java.awt.Color(0, 0, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("VIDA");
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel44.setBackground(new java.awt.Color(0, 0, 51));
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel44.setOpaque(false);

        IDAS_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        IDAS_VD.setForeground(new java.awt.Color(0, 0, 51));
        IDAS_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel63.setBackground(new java.awt.Color(0, 0, 51));
        jLabel63.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("No. POLIZA");
        jLabel63.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        NOPOL_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOPOL_VD.setForeground(new java.awt.Color(0, 0, 51));
        NOPOL_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel92.setBackground(new java.awt.Color(0, 0, 51));
        jLabel92.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("SUMA ASEGURADA");
        jLabel92.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        SUMAAS_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        SUMAAS_VD.setForeground(new java.awt.Color(0, 0, 51));
        SUMAAS_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel93.setBackground(new java.awt.Color(0, 0, 51));
        jLabel93.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("COBERTURA");
        jLabel93.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel95.setBackground(new java.awt.Color(0, 0, 51));
        jLabel95.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("FECHA EFECTIVA");
        jLabel95.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        FI_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        FI_VD.setForeground(new java.awt.Color(0, 0, 51));
        FI_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel97.setBackground(new java.awt.Color(0, 0, 51));
        jLabel97.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("PRIMA");
        jLabel97.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PRIMA_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        PRIMA_VD.setForeground(new java.awt.Color(0, 0, 51));
        PRIMA_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Btn_aceptar_reg4.setBackground(new java.awt.Color(0, 0, 0));
        Btn_aceptar_reg4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Btn_aceptar_reg4.setForeground(new java.awt.Color(255, 255, 255));
        Btn_aceptar_reg4.setText("ACEPTAR");
        Btn_aceptar_reg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_aceptar_reg4ActionPerformed(evt);
            }
        });

        limpiar10.setBackground(new java.awt.Color(0, 0, 0));
        limpiar10.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        limpiar10.setForeground(new java.awt.Color(255, 255, 255));
        limpiar10.setText("LIMPIAR");
        limpiar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar10ActionPerformed(evt);
            }
        });

        jLabel99.setBackground(new java.awt.Color(0, 0, 51));
        jLabel99.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("ASEGURADORA");
        jLabel99.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IGMConyugueBtn1.setBackground(new java.awt.Color(0, 0, 0));
        IGMConyugueBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGMConyugueBtn1.setForeground(new java.awt.Color(255, 255, 255));
        IGMConyugueBtn1.setText("BENEFICIARIOS");
        IGMConyugueBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGMConyugueBtn1ActionPerformed(evt);
            }
        });

        FF_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        FF_VD.setForeground(new java.awt.Color(0, 0, 51));
        FF_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ESTADO_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        ESTADO_VD.setForeground(new java.awt.Color(0, 0, 51));
        ESTADO_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel100.setBackground(new java.awt.Color(0, 0, 51));
        jLabel100.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("ESTADO DE POLIZA");
        jLabel100.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel101.setBackground(new java.awt.Color(0, 0, 51));
        jLabel101.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("DESCRIPCION COBERTURAS");
        jLabel101.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DESCCOBRETURAS_VD.setColumns(20);
        DESCCOBRETURAS_VD.setRows(5);
        jScrollPane23.setViewportView(DESCCOBRETURAS_VD);

        limpiar11.setBackground(new java.awt.Color(0, 0, 0));
        limpiar11.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        limpiar11.setForeground(new java.awt.Color(255, 255, 255));
        limpiar11.setText("ACTUALIZAR");
        limpiar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar11ActionPerformed(evt);
            }
        });

        COBERTURA_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        COBERTURA_VD.setForeground(new java.awt.Color(0, 0, 51));
        COBERTURA_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel44Layout.createSequentialGroup()
                            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(IDAS_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NOPOL_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SUMAAS_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel44Layout.createSequentialGroup()
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(COBERTURA_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FI_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FF_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel44Layout.createSequentialGroup()
                            .addComponent(Btn_aceptar_reg4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(limpiar10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel44Layout.createSequentialGroup()
                            .addComponent(limpiar11, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PRIMA_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ESTADO_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IGMConyugueBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IDAS_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NOPOL_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FI_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FF_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PRIMA_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ESTADO_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(SUMAAS_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(COBERTURA_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_aceptar_reg4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limpiar10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(IGMConyugueBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiar11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );

        IGMvolverBtn1.setBackground(new java.awt.Color(0, 0, 0));
        IGMvolverBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGMvolverBtn1.setForeground(new java.awt.Color(255, 255, 255));
        IGMvolverBtn1.setText("VOLVER A MENÚ");
        IGMvolverBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGMvolverBtn1ActionPerformed(evt);
            }
        });

        IGMAtrasBtn1.setBackground(new java.awt.Color(0, 0, 0));
        IGMAtrasBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGMAtrasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        IGMAtrasBtn1.setText("ATRAS");
        IGMAtrasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGMAtrasBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout I_VIDA1Layout = new javax.swing.GroupLayout(I_VIDA1);
        I_VIDA1.setLayout(I_VIDA1Layout);
        I_VIDA1Layout.setHorizontalGroup(
            I_VIDA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_VIDA1Layout.createSequentialGroup()
                .addGroup(I_VIDA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_VIDA1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(I_VIDA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGMvolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGMAtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(I_VIDA1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        I_VIDA1Layout.setVerticalGroup(
            I_VIDA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_VIDA1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(I_VIDA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_VIDA1Layout.createSequentialGroup()
                        .addComponent(IGMvolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(IGMAtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        VIDA.addTab("I VIDA1", I_VIDA1);

        I_GM2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel86.setBackground(new java.awt.Color(0, 0, 51));
        jLabel86.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("BENEFICIARIOS");
        jLabel86.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel36.setBackground(new java.awt.Color(0, 0, 51));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel36.setOpaque(false);

        jLabel160.setBackground(new java.awt.Color(0, 0, 51));
        jLabel160.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel160.setText("DPI NO.");
        jLabel160.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        NOMBRE_BFO.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOMBRE_BFO.setForeground(new java.awt.Color(0, 0, 51));
        NOMBRE_BFO.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel161.setBackground(new java.awt.Color(0, 0, 51));
        jLabel161.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("NOMBRE COMPLETO");
        jLabel161.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DPI_BFO.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        DPI_BFO.setForeground(new java.awt.Color(0, 0, 51));
        DPI_BFO.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        FNAC_BFO.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        FNAC_BFO.setForeground(new java.awt.Color(0, 0, 51));
        FNAC_BFO.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel162.setBackground(new java.awt.Color(0, 0, 51));
        jLabel162.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 255, 255));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel162.setText("FECHA DE NACIMIENTO");
        jLabel162.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel166.setBackground(new java.awt.Color(0, 0, 51));
        jLabel166.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel166.setText("PARENTESCO");
        jLabel166.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PARENTESCO_BFO.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        PARENTESCO_BFO.setForeground(new java.awt.Color(0, 0, 51));
        PARENTESCO_BFO.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                                    .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(FNAC_BFO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel161, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel160, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DPI_BFO, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(NOMBRE_BFO))))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PARENTESCO_BFO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(IGM2IngresarPagTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOMBRE_BFO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DPI_BFO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FNAC_BFO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PARENTESCO_BFO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(IGM2IngresarPagTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
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
                .addGroup(I_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_GM2Layout.createSequentialGroup()
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(I_GM2Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                        .addComponent(IGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
        );
        I_GM2Layout.setVerticalGroup(
            I_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_GM2Layout.createSequentialGroup()
                .addGroup(I_GM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(I_GM2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(IGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(I_GM2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(322, Short.MAX_VALUE))
        );

        VIDA.addTab("I VIDA 2", I_GM2);

        jPanel45.setBackground(new java.awt.Color(102, 0, 0));
        jPanel45.setMaximumSize(new java.awt.Dimension(1530, 943));
        jPanel45.setPreferredSize(new java.awt.Dimension(1530, 943));

        jLabel91.setBackground(new java.awt.Color(0, 0, 51));
        jLabel91.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("SEGUROS DE VIDA");
        jLabel91.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        COMBO_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        COMBO_VD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMBO_VDActionPerformed(evt);
            }
        });

        BUSCAR_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        BUSCAR_VD.setForeground(new java.awt.Color(0, 0, 51));
        BUSCAR_VD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CGMVolverBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGMVolverBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMVolverBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGMVolverBtn1.setText("VOLVER A MENÚ");
        CGMVolverBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMVolverBtn1ActionPerformed(evt);
            }
        });

        CGMLimpiarBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGMLimpiarBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMLimpiarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGMLimpiarBtn1.setText("LIMPIAR");
        CGMLimpiarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMLimpiarBtn1ActionPerformed(evt);
            }
        });

        CGMBuscarbtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGMBuscarbtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMBuscarbtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGMBuscarbtn1.setText("BUSCAR ");
        CGMBuscarbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMBuscarbtn1ActionPerformed(evt);
            }
        });

        TBL_VD.setBackground(new java.awt.Color(0, 0, 51));
        TBL_VD.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_VD.setForeground(new java.awt.Color(255, 255, 255));
        TBL_VD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_VD.setAlignmentX(1.0F);
        TBL_VD.setAlignmentY(1.0F);
        TBL_VD.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBL_VD.setGridColor(new java.awt.Color(0, 153, 204));
        TBL_VD.setRowHeight(30);
        TBL_VD.setSelectionBackground(new java.awt.Color(0, 102, 204));
        TBL_VD.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TBL_VD.setShowVerticalLines(false);
        TBL_VD.getTableHeader().setReorderingAllowed(false);
        TBL_VD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_VDMouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(TBL_VD);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CGMVolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BUSCAR_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMBuscarbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(COMBO_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMLimpiarBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(503, 503, 503)
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(555, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CGMVolverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BUSCAR_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(COMBO_VD, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CGMLimpiarBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CGMBuscarbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(198, 198, 198))
        );

        VIDA.addTab("C VIDA 1", jPanel45);

        jPanel46.setBackground(new java.awt.Color(102, 0, 0));
        jPanel46.setMaximumSize(new java.awt.Dimension(1530, 943));
        jPanel46.setPreferredSize(new java.awt.Dimension(1530, 943));

        jLabel94.setBackground(new java.awt.Color(0, 0, 51));
        jLabel94.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("INFORMACION");
        jLabel96.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CV2CoberturasyCobBtn2.setBackground(new java.awt.Color(0, 0, 0));
        CV2CoberturasyCobBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CV2CoberturasyCobBtn2.setForeground(new java.awt.Color(255, 255, 255));
        CV2CoberturasyCobBtn2.setText("VER COBROS Y ASEGURADOS");
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

        CGMElimBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGMElimBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMElimBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGMElimBtn1.setText("ELIMINAR POLIZA");
        CGMElimBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMElimBtn1ActionPerformed(evt);
            }
        });

        CGMModBtn1.setBackground(new java.awt.Color(0, 0, 0));
        CGMModBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGMModBtn1.setForeground(new java.awt.Color(255, 255, 255));
        CGMModBtn1.setText("MODIFICAR POLIZA");
        CGMModBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGMModBtn1ActionPerformed(evt);
            }
        });

        jLabel98.setBackground(new java.awt.Color(0, 0, 51));
        jLabel98.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane26))
                        .addGap(142, 142, 142)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CGMModBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CV2CoberturasyCobBtn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CGMElimBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CGM2AtrasBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CGM2VolverBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addGap(174, 174, 174))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(CGM2VolverBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGM2AtrasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addComponent(CV2CoberturasyCobBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(CGMModBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(CGMElimBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        VIDA.addTab("C VIDA 2", jPanel46);

        C_GM3.setBackground(new java.awt.Color(102, 0, 0));

        jLabel81.setBackground(new java.awt.Color(255, 255, 255));
        jLabel81.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("SEG. VIDA");
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

        jLabel82.setBackground(new java.awt.Color(204, 102, 0));
        jLabel82.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("COBROS");

        jLabel85.setBackground(new java.awt.Color(204, 102, 0));
        jLabel85.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("BENEFICIARIOS");
        jLabel85.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TBL_CBR_VIDA.setBackground(new java.awt.Color(0, 0, 51));
        TBL_CBR_VIDA.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_CBR_VIDA.setForeground(new java.awt.Color(255, 255, 255));
        TBL_CBR_VIDA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_CBR_VIDA.setAlignmentX(1.0F);
        TBL_CBR_VIDA.setAlignmentY(1.0F);
        TBL_CBR_VIDA.setRowHeight(30);
        TBL_CBR_VIDA.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TBL_CBR_VIDA.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setViewportView(TBL_CBR_VIDA);

        TBL_BENEFICIARIOS.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TBL_BENEFICIARIOS.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_BENEFICIARIOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_BENEFICIARIOS.setAlignmentX(1.0F);
        TBL_BENEFICIARIOS.setAlignmentY(1.0F);
        TBL_BENEFICIARIOS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBL_BENEFICIARIOS.setColumnSelectionAllowed(true);
        TBL_BENEFICIARIOS.setRowHeight(30);
        TBL_BENEFICIARIOS.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(TBL_BENEFICIARIOS);

        CGM2AtrasBtn3.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn3.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn3.setText("NUEVO");
        CGM2AtrasBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn3ActionPerformed(evt);
            }
        });

        CGM2AtrasBtn4.setBackground(new java.awt.Color(0, 0, 0));
        CGM2AtrasBtn4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        CGM2AtrasBtn4.setForeground(new java.awt.Color(255, 255, 255));
        CGM2AtrasBtn4.setText("ELIMINAR");
        CGM2AtrasBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGM2AtrasBtn4ActionPerformed(evt);
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
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CGM2VolverBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                        .addGap(174, 174, 174))
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(C_GM3Layout.createSequentialGroup()
                                .addComponent(CGM2AtrasBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CGM2AtrasBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CGM2AtrasBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CGM2AtrasBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        VIDA.addTab("C. VIDA 3", C_GM3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VIDA, javax.swing.GroupLayout.PREFERRED_SIZE, 1525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VIDA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_aceptar_reg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_aceptar_reg4ActionPerformed
if(IDAS_VD.getText().equals("")|| NOPOL_VD.getText().equals("") || FI_VD.getText().equals("") || FF_VD.getText().equals("") )
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Fecha Efectiva.");
        }else{

        String id = TblCC1.getValueAt(TblCC1.getSelectedRow(),0).toString();
        Ingresos ingreso = new Ingresos();
        IGMConyugueBtn1.setEnabled(false);
        ingreso.ingresoVida(id, IDAS_VD.getText());
        consulta.cvd(NOPOL_VD.getText());
     IDAS_VD.setText("");
     NOPOL_VD.setText("");
     FI_VD.setText("");
     FF_VD.setText("");
     SUMAAS_VD.setText("");
     COBERTURA_VD.setText("");
     PRIMA_VD.setText("");
     ESTADO_VD.setText("");
     DESCCOBRETURAS_VD.setText("");
}
    }//GEN-LAST:event_Btn_aceptar_reg4ActionPerformed

    private void limpiar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar10ActionPerformed
        // TODO add your handling code hereIDAS_VD.setText("");
     NOPOL_VD.setText("");
     FI_VD.setText("");
     FF_VD.setText("");
     SUMAAS_VD.setText("");
     COBERTURA_VD.setText("");
     PRIMA_VD.setText("");
     ESTADO_VD.setText("");
     DESCCOBRETURAS_VD.setText("");
    }//GEN-LAST:event_limpiar10ActionPerformed

    private void IGMConyugueBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMConyugueBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IGMConyugueBtn1ActionPerformed

    private void limpiar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar11ActionPerformed
      if(IDAS_VD.getText().equals("")|| NOPOL_VD.getText().equals("") || FI_VD.getText().equals("") || FF_VD.getText().equals("") )
        {
             JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- No. Poliza.\n- Fecha Efectiva.");
        }else{
        try {
           String id = NOPOL_VD.getText();
            String sql = "UPDATE tbl_vida SET IdAseguradora_vd="+IDAS_VD.getText()
          + ",NoPoliza_vd='"+NOPOL_VD.getText()+"',FechaInicio_vd='"+FI_VD.getText()+"',FechaFin_vd='"+FF_VD.getText()
          + "',SumaAsegurada_vd='"+SUMAAS_VD.getText()+"',Coberturas_vd='"+COBERTURA_VD.getText()
          + "',DescripcionCobertura_vd='"+DESCCOBRETURAS_VD.getText()+"',Prima_vd='"+PRIMA_VD.getText()
          + "',EstadoPoliza_vd='"+ESTADO_VD.getText()+"' WHERE NoPoliza_vd='"+id+"'";
            
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            
            consulta.cvd(id);
            JOptionPane.showMessageDialog(null,"ACTUALIZADO");
            VIDA.setSelectedIndex(6);
              consulta.mostrar_tabla6();
              IDAS_VD.setText("");
     NOPOL_VD.setText("");
     FI_VD.setText("");
     FF_VD.setText("");
     SUMAAS_VD.setText("");
     COBERTURA_VD.setText("");
     PRIMA_VD.setText("");
     ESTADO_VD.setText("");
     DESCCOBRETURAS_VD.setText("");
           
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        } }
    }//GEN-LAST:event_limpiar11ActionPerformed

    private void IGMvolverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMvolverBtn1ActionPerformed
       VIDA.setSelectedIndex(0);
    }//GEN-LAST:event_IGMvolverBtn1ActionPerformed

    private void IGMAtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGMAtrasBtn1ActionPerformed
       VIDA.setSelectedIndex(2);
    }//GEN-LAST:event_IGMAtrasBtn1ActionPerformed

    private void COMBO_VDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMBO_VDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COMBO_VDActionPerformed

    private void CGMVolverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMVolverBtn1ActionPerformed
         VIDA.setSelectedIndex(0);
    }//GEN-LAST:event_CGMVolverBtn1ActionPerformed

    private void CGMLimpiarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMLimpiarBtn1ActionPerformed
      BUSCAR_VD.setText(""); consulta.mostrar_tabla6();
    }//GEN-LAST:event_CGMLimpiarBtn1ActionPerformed

    private void CGMBuscarbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMBuscarbtn1ActionPerformed
       src.Busquedavd(Campo5(COMBO_VD.getSelectedItem().toString()), BUSCAR_VD.getText());
    }//GEN-LAST:event_CGMBuscarbtn1ActionPerformed

    private void TBL_VDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_VDMouseClicked
        int fila  = TBL_VD.getSelectedRow();String Id;
        if (fila>=0){ Id = valueOf(TBL_VD.getValueAt(fila, 1)); consulta.cvd(Id);VIDA.setSelectedIndex(6);
        }else{
            JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO CLIENTE");
        }
    }//GEN-LAST:event_TBL_VDMouseClicked

    private void CGM2VolverBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn2ActionPerformed
         VIDA.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn2ActionPerformed

    private void CGM2AtrasBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn2ActionPerformed
        VIDA.setSelectedIndex(5);
    }//GEN-LAST:event_CGM2AtrasBtn2ActionPerformed

    private void CV2CoberturasyCobBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2CoberturasyCobBtn2ActionPerformed
        String id = TBL_VD2.getValueAt(2,1).toString();
        consulta.cvd2(id);
        consulta.cvd3(id);
        VIDA.setSelectedIndex(7);
    }//GEN-LAST:event_CV2CoberturasyCobBtn2ActionPerformed

    private void CGMElimBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMElimBtn1ActionPerformed
            String sql = "DELETE  FROM tbl_vida WHERE NoPoliza_vd ="+TBL_VD2.getValueAt(2,1).toString()+"";
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"CLIENTE ELIMINADO");
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        consulta.mostrar_tabla6();
        VIDA.setSelectedIndex(5);
    }//GEN-LAST:event_CGMElimBtn1ActionPerformed

    private void CGMModBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGMModBtn1ActionPerformed
     Cliente idas = new Cliente();
     Btn_aceptar_reg4.setEnabled(false);
     limpiar11.setEnabled(true);
     IDAS_VD.setText(idas.datosvd(TBL_VD2.getValueAt(2, 1).toString()));
     NOPOL_VD.setText(TBL_VD2.getValueAt(2, 1).toString());
     FI_VD.setText(TBL_VD2.getValueAt(3, 1).toString());
     FF_VD.setText(TBL_VD2.getValueAt(4, 1).toString());
     SUMAAS_VD.setText(TBL_VD2.getValueAt(5, 1).toString());
     COBERTURA_VD.setText(TBL_VD2.getValueAt(6, 1).toString());
     PRIMA_VD.setText(TBL_VD2.getValueAt(7, 1).toString());
     ESTADO_VD.setText(TBL_VD2.getValueAt(8, 1).toString());
     DESCCOBRETURAS_VD.setText(DESC_VD2.getText());
     VIDA.setSelectedIndex(3);
             
    }//GEN-LAST:event_CGMModBtn1ActionPerformed

    private void Cclt1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cclt1ComboBoxActionPerformed

    private void Cclt1BusquedaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt1BusquedaTxtActionPerformed

    }//GEN-LAST:event_Cclt1BusquedaTxtActionPerformed

    private void CcltLimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltLimpiarBtnActionPerformed
        mostrar_tabla1(); Cclt1BusquedaTxt.setText("");
    }//GEN-LAST:event_CcltLimpiarBtnActionPerformed

    private void CcltBuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltBuscarBtnActionPerformed
        String campo = Cclt1ComboBox.getSelectedItem().toString();

        Buscar1(src.Campo2(campo),Cclt1BusquedaTxt.getText());
    }//GEN-LAST:event_CcltBuscarBtnActionPerformed

    private void CcltSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltSalirBtnActionPerformed
        VIDA.setSelectedIndex(0);
    }//GEN-LAST:event_CcltSalirBtnActionPerformed

    private void TblCC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCC1MouseClicked
        int fila  = TblCC1.getSelectedRow();String Id;
        if (fila>=0){
            Id = valueOf(TblCC1.getValueAt(fila, 0));
            cc2(Id);
            VIDA.setSelectedIndex(2);
        }
    }//GEN-LAST:event_TblCC1MouseClicked

    private void Cclt2SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cclt2SalirBtnActionPerformed
        VIDA.setSelectedIndex(1);
    }//GEN-LAST:event_Cclt2SalirBtnActionPerformed

    private void CcltModificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcltModificarBtnActionPerformed
        VIDA.setSelectedIndex(3);
    }//GEN-LAST:event_CcltModificarBtnActionPerformed

    private void IngresosMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosMenu2BtnActionPerformed
        VIDA.setSelectedIndex(1);limpiar11.setEnabled(false);Btn_aceptar_reg4.setEnabled(true);IGMConyugueBtn1.setEnabled(false);
    }//GEN-LAST:event_IngresosMenu2BtnActionPerformed

    private void EliminarMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMenu2BtnActionPerformed
        VIDA.setSelectedIndex(5);
    }//GEN-LAST:event_EliminarMenu2BtnActionPerformed

    private void ConsultaMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaMenu2BtnActionPerformed
        VIDA.setSelectedIndex(5);
    }//GEN-LAST:event_ConsultaMenu2BtnActionPerformed

    private void ModificacionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificacionMenu2BtnActionPerformed
        VIDA.setSelectedIndex(5);
    }//GEN-LAST:event_ModificacionMenu2BtnActionPerformed

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
       this.setSize(220, 40);
    }//GEN-LAST:event_formInternalFrameIconified

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
       this.setSize(1530, 943);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void IGM2IngresarPagTxt1limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt1limpiar18ActionPerformed
       String id = TBL_VD2.getValueAt(2,1).toString();
       Ingresos bfo = new Ingresos();
       bfo.ingresoBeneficiarios(id);
    }//GEN-LAST:event_IGM2IngresarPagTxt1limpiar18ActionPerformed

    private void IGM2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2AtrasBtn1ActionPerformed
       VIDA.setSelectedIndex(3);
    }//GEN-LAST:event_IGM2AtrasBtn1ActionPerformed

    private void CGM2VolverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2VolverBtn1ActionPerformed
        VIDA.setSelectedIndex(0);
    }//GEN-LAST:event_CGM2VolverBtn1ActionPerformed

    private void CGM2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn1ActionPerformed
        VIDA.setSelectedIndex(6);
    }//GEN-LAST:event_CGM2AtrasBtn1ActionPerformed

    private void CGM2AtrasBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn3ActionPerformed
        VIDA.setSelectedIndex(4);
    }//GEN-LAST:event_CGM2AtrasBtn3ActionPerformed

    private void CGM2AtrasBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn4ActionPerformed
        String id = TBL_BENEFICIARIOS.getValueAt(TBL_BENEFICIARIOS.getSelectedRow(),0).toString();
        String sql = "DELETE  FROM tbl_beneficiarios WHERE IdBeneficiario_bfs ="+id+"";
        String NoPol="";
        if(TBL_BENEFICIARIOS.getSelectedRow()<0){JOptionPane.showMessageDialog(null,"POR FAVOR SELECCIONE UN BENEFICIARIO");}else{
            try {
                PreparedStatement pps = cn.prepareStatement(sql);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null," ELIMINADO");

                NoPol = valueOf(TBL_VD.getValueAt(TBL_VD.getSelectedRow(), 1));
                consulta.cvd2(NoPol);
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }}
    }//GEN-LAST:event_CGM2AtrasBtn4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BUSCAR_VD;
    private javax.swing.JButton Btn_aceptar_reg4;
    private javax.swing.JButton CGM2AtrasBtn1;
    private javax.swing.JButton CGM2AtrasBtn2;
    private javax.swing.JButton CGM2AtrasBtn3;
    private javax.swing.JButton CGM2AtrasBtn4;
    private javax.swing.JButton CGM2VolverBtn1;
    private javax.swing.JButton CGM2VolverBtn2;
    private javax.swing.JButton CGMBuscarbtn1;
    private javax.swing.JButton CGMElimBtn1;
    private javax.swing.JButton CGMLimpiarBtn1;
    private javax.swing.JButton CGMModBtn1;
    private javax.swing.JButton CGMVolverBtn1;
    public static javax.swing.JTextField COBERTURA_VD;
    public static javax.swing.JComboBox<String> COMBO_VD;
    private javax.swing.JButton CV2CoberturasyCobBtn2;
    private javax.swing.JPanel C_CLIENTES1;
    private javax.swing.JPanel C_CLIENTES2;
    private javax.swing.JPanel C_GM3;
    private javax.swing.JTextField Cclt1BusquedaTxt;
    public static javax.swing.JComboBox<String> Cclt1ComboBox;
    private javax.swing.JButton Cclt2SalirBtn;
    private javax.swing.JButton CcltBuscarBtn;
    private javax.swing.JButton CcltLimpiarBtn;
    private javax.swing.JButton CcltModificarBtn;
    private javax.swing.JButton CcltSalirBtn;
    private javax.swing.JButton ConsultaMenu2Btn;
    public static javax.swing.JTextArea DESCCOBRETURAS_VD;
    public static javax.swing.JTextArea DESC_VD2;
    public static javax.swing.JTextField DPI_BFO;
    public static javax.swing.JTextField ESTADO_VD;
    private javax.swing.JButton EliminarMenu2Btn;
    public static javax.swing.JTextField FF_VD;
    public static javax.swing.JTextField FI_VD;
    public static javax.swing.JTextField FNAC_BFO;
    public static javax.swing.JTextField IDAS_VD;
    private javax.swing.JButton IGM2AtrasBtn1;
    private javax.swing.JButton IGM2IngresarPagTxt1;
    private javax.swing.JButton IGMAtrasBtn1;
    private javax.swing.JButton IGMConyugueBtn1;
    private javax.swing.JButton IGMvolverBtn1;
    private javax.swing.JPanel I_GM2;
    private javax.swing.JPanel I_VIDA1;
    private javax.swing.JButton IngresosMenu2Btn;
    private javax.swing.JPanel MENU2;
    private javax.swing.JButton ModificacionMenu2Btn;
    public static javax.swing.JTextField NOMBRE_BFO;
    public static javax.swing.JTextField NOPOL_VD;
    public static javax.swing.JTextField PARENTESCO_BFO;
    public static javax.swing.JTextField PRIMA_VD;
    public static javax.swing.JTextField SUMAAS_VD;
    public static javax.swing.JTable TBL_BENEFICIARIOS;
    public static javax.swing.JTable TBL_CBR_VIDA;
    public static javax.swing.JTable TBL_VD;
    public static javax.swing.JTable TBL_VD2;
    public static javax.swing.JTable TblCC1;
    public static javax.swing.JTable TblCC2;
    private javax.swing.JTabbedPane VIDA;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton limpiar10;
    private javax.swing.JButton limpiar11;
    // End of variables declaration//GEN-END:variables
}
