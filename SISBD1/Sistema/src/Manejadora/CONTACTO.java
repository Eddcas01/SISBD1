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
import java.sql.Connection;
import static java.lang.String.valueOf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author gganp
 */
public class CONTACTO extends javax.swing.JInternalFrame {

    /**
     * Creates new form CONTACTO
     */
          Consultas consulta = new Consultas();
    Busquedas src = new Busquedas();
    public static int tipo=0;
    Eliminar del =new Eliminar();
    Cliente cl = new Cliente();
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    public CONTACTO() {
        initComponents();
        IGM2IngresarPagTxt13.setEnabled(false);
        IGM2IngresarPagTxt17.setEnabled(false);
          IGM2IngresarPagTxt18.setEnabled(false);
            IGM2IngresarPagTxt19.setEnabled(false);
        if(tipo==2){IGM2IngresarPagTxt10.setEnabled(false);
       IGM2IngresarPagTxt13.setEnabled(false);
       }
        
           IGM2IngresarPagTxt14.setEnabled(false);
               ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id ");
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Tel");
       
    
       
       String sql ="SELECT * FROM tbl_telefonos";
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
     TBL_CTO1.setModel(modelo1);     
     TBL_CTO1.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO1.getColumnModel().getColumn(1).setPreferredWidth(600);
     TBL_CTO1.getColumnModel().getColumn(2).setPreferredWidth(300);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        consulta.mostrar_tabla4();
        
                ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo2 = new DefaultTableModel();
     
       modelo2.addColumn("id ");
       modelo2.addColumn("Nombre");
       modelo2.addColumn("Correo");
       
    
       
       String sql2 ="SELECT * FROM correos";
       String datos2[] = new String[3];
       Statement st2;
        try {
            st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(sql2);
            while(rs.next()){
           
             datos2[0]= rs.getString(1);
             datos2[1]= rs.getString(2);
             datos2[2]= rs.getString(3);  
            modelo2.addRow(datos2);
             
            
        }
     TBL_CTO2.setModel(modelo2); 
      TBL_CTO2.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO2.getColumnModel().getColumn(1).setPreferredWidth(600);
     TBL_CTO2.getColumnModel().getColumn(2).setPreferredWidth(300);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
                 ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo3 = new DefaultTableModel();
     
       modelo3.addColumn("id ");
       modelo3.addColumn("Nombre");
       modelo3.addColumn("Direccion");
       
    
       
       String sql3 ="SELECT * FROM direcciones";
       String datos3[] = new String[3];
       Statement st3;
        try {
            st3 = cn.createStatement();
            ResultSet rs = st3.executeQuery(sql3);
            while(rs.next()){
           
             datos3[0]= rs.getString(1);
             datos3[1]= rs.getString(2);
             datos3[2]= rs.getString(3);  
            modelo3.addRow(datos3);
             
            
        }
     TBL_CTO3.setModel(modelo3); 
      TBL_CTO3.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO3.getColumnModel().getColumn(1).setPreferredWidth(200);
     TBL_CTO3.getColumnModel().getColumn(2).setPreferredWidth(700);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_ingreso_cts13 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        NOMBRE_CTO = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        CARGO_CTO = new javax.swing.JTextField();
        jLabel176 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        TEL_CTO = new javax.swing.JTextArea();
        IGM2IngresarPagTxt8 = new javax.swing.JButton();
        IGM2IngresarPagTxt9 = new javax.swing.JButton();
        IGM2IngresarPagTxt10 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        TBL_CTO = new javax.swing.JTable();
        IGM2IngresarPagTxt13 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        TEL_CTO1 = new javax.swing.JTextArea();
        IGM2IngresarPagTxt14 = new javax.swing.JButton();
        panel_ingreso_cts14 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        NOMBRE_CTO1 = new javax.swing.JTextField();
        jLabel175 = new javax.swing.JLabel();
        CARGO_CTO1 = new javax.swing.JTextField();
        IGM2IngresarPagTxt12 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        TBL_CTO1 = new javax.swing.JTable();
        IGM2IngresarPagTxt17 = new javax.swing.JButton();
        panel_ingreso_cts15 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        NOMBRE_CTO2 = new javax.swing.JTextField();
        jLabel177 = new javax.swing.JLabel();
        CARGO_CTO2 = new javax.swing.JTextField();
        IGM2IngresarPagTxt15 = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        TBL_CTO2 = new javax.swing.JTable();
        IGM2IngresarPagTxt18 = new javax.swing.JButton();
        panel_ingreso_cts16 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        NOMBRE_CTO3 = new javax.swing.JTextField();
        jLabel178 = new javax.swing.JLabel();
        CARGO_CTO3 = new javax.swing.JTextField();
        IGM2IngresarPagTxt16 = new javax.swing.JButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        TBL_CTO3 = new javax.swing.JTable();
        IGM2IngresarPagTxt19 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setDoubleBuffered(true);
        setMaximumSize(new java.awt.Dimension(1144, 764));
        setPreferredSize(new java.awt.Dimension(1144, 764));
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

        jTabbedPane1.setEnabled(true);

        panel_ingreso_cts13.setBackground(new java.awt.Color(102, 0, 0));
        panel_ingreso_cts13.setMaximumSize(new java.awt.Dimension(1144, 764));
        panel_ingreso_cts13.setPreferredSize(new java.awt.Dimension(1144, 764));

        jLabel90.setBackground(new java.awt.Color(0, 0, 51));
        jLabel90.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("CONTACTOS");
        jLabel90.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel43.setBackground(new java.awt.Color(0, 0, 51));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel43.setOpaque(false);

        jLabel170.setBackground(new java.awt.Color(0, 0, 51));
        jLabel170.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel170.setText("NOMBRE");
        jLabel170.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        NOMBRE_CTO.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOMBRE_CTO.setForeground(new java.awt.Color(0, 0, 51));
        NOMBRE_CTO.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel174.setBackground(new java.awt.Color(0, 0, 51));
        jLabel174.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel174.setText("CARGO");
        jLabel174.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CARGO_CTO.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CARGO_CTO.setForeground(new java.awt.Color(0, 0, 51));
        CARGO_CTO.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel176.setBackground(new java.awt.Color(0, 0, 51));
        jLabel176.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(255, 255, 255));
        jLabel176.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel176.setText("TELEFONOS / EMAIL");
        jLabel176.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TEL_CTO.setColumns(20);
        TEL_CTO.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        TEL_CTO.setRows(5);
        jScrollPane19.setViewportView(TEL_CTO);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel170, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jLabel174, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CARGO_CTO)
                            .addComponent(NOMBRE_CTO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOMBRE_CTO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CARGO_CTO, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );

        IGM2IngresarPagTxt8.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt8.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt8.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt8.setText("LIMPIAR");
        IGM2IngresarPagTxt8.setBorder(null);
        IGM2IngresarPagTxt8.setBorderPainted(false);
        IGM2IngresarPagTxt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt8limpiar18ActionPerformed(evt);
            }
        });

        IGM2IngresarPagTxt9.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt9.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt9.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt9.setText("GUARDAR");
        IGM2IngresarPagTxt9.setBorder(null);
        IGM2IngresarPagTxt9.setBorderPainted(false);
        IGM2IngresarPagTxt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt9limpiar18ActionPerformed(evt);
            }
        });

        IGM2IngresarPagTxt10.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt10.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt10.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt10.setText("MODIFICAR");
        IGM2IngresarPagTxt10.setBorder(null);
        IGM2IngresarPagTxt10.setBorderPainted(false);
        IGM2IngresarPagTxt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt10limpiar18ActionPerformed(evt);
            }
        });

        TBL_CTO.setBackground(new java.awt.Color(0, 0, 51));
        TBL_CTO.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_CTO.setForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_CTO.setAlignmentX(1.0F);
        TBL_CTO.setAlignmentY(1.0F);
        TBL_CTO.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBL_CTO.setRowHeight(30);
        TBL_CTO.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TBL_CTO.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO.getTableHeader().setReorderingAllowed(false);
        TBL_CTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_CTOMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(TBL_CTO);

        IGM2IngresarPagTxt13.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt13.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt13.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt13.setText("ACTUALIZAR");
        IGM2IngresarPagTxt13.setBorder(null);
        IGM2IngresarPagTxt13.setBorderPainted(false);
        IGM2IngresarPagTxt13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt13limpiar18ActionPerformed(evt);
            }
        });

        TEL_CTO1.setColumns(20);
        TEL_CTO1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        TEL_CTO1.setRows(5);
        jScrollPane20.setViewportView(TEL_CTO1);

        IGM2IngresarPagTxt14.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt14.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt14.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt14.setText("ELIMINAR");
        IGM2IngresarPagTxt14.setBorder(null);
        IGM2IngresarPagTxt14.setBorderPainted(false);
        IGM2IngresarPagTxt14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt14limpiar18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ingreso_cts13Layout = new javax.swing.GroupLayout(panel_ingreso_cts13);
        panel_ingreso_cts13.setLayout(panel_ingreso_cts13Layout);
        panel_ingreso_cts13Layout.setHorizontalGroup(
            panel_ingreso_cts13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts13Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panel_ingreso_cts13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_ingreso_cts13Layout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_ingreso_cts13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGM2IngresarPagTxt13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2IngresarPagTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2IngresarPagTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2IngresarPagTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2IngresarPagTxt14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(363, 363, 363))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_ingreso_cts13Layout.createSequentialGroup()
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ingreso_cts13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        panel_ingreso_cts13Layout.setVerticalGroup(
            panel_ingreso_cts13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_ingreso_cts13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ingreso_cts13Layout.createSequentialGroup()
                        .addComponent(IGM2IngresarPagTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IGM2IngresarPagTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(IGM2IngresarPagTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IGM2IngresarPagTxt13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IGM2IngresarPagTxt14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_ingreso_cts13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ASEGURADORAS", panel_ingreso_cts13);

        panel_ingreso_cts14.setBackground(new java.awt.Color(102, 0, 0));
        panel_ingreso_cts14.setMaximumSize(new java.awt.Dimension(1144, 764));
        panel_ingreso_cts14.setPreferredSize(new java.awt.Dimension(1144, 764));

        jLabel91.setBackground(new java.awt.Color(0, 0, 51));
        jLabel91.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("TELEFONOS");
        jLabel91.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel44.setBackground(new java.awt.Color(0, 0, 51));
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel44.setOpaque(false);

        jLabel171.setBackground(new java.awt.Color(0, 0, 51));
        jLabel171.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setText("NOMBRE");
        jLabel171.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        NOMBRE_CTO1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOMBRE_CTO1.setForeground(new java.awt.Color(0, 0, 51));
        NOMBRE_CTO1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel175.setBackground(new java.awt.Color(0, 0, 51));
        jLabel175.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel175.setText("TELEFONO");
        jLabel175.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CARGO_CTO1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CARGO_CTO1.setForeground(new java.awt.Color(0, 0, 51));
        CARGO_CTO1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel171, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel175, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CARGO_CTO1)
                    .addComponent(NOMBRE_CTO1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOMBRE_CTO1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CARGO_CTO1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IGM2IngresarPagTxt12.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt12.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt12.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt12.setText("GUARDAR");
        IGM2IngresarPagTxt12.setBorder(null);
        IGM2IngresarPagTxt12.setBorderPainted(false);
        IGM2IngresarPagTxt12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt12limpiar18ActionPerformed(evt);
            }
        });

        TBL_CTO1.setBackground(new java.awt.Color(0, 0, 51));
        TBL_CTO1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_CTO1.setForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_CTO1.setAlignmentX(1.0F);
        TBL_CTO1.setAlignmentY(1.0F);
        TBL_CTO1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBL_CTO1.setRowHeight(30);
        TBL_CTO1.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TBL_CTO1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO1.getTableHeader().setReorderingAllowed(false);
        TBL_CTO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_CTO1MouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(TBL_CTO1);

        IGM2IngresarPagTxt17.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt17.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt17.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt17.setText("ELIMINAR");
        IGM2IngresarPagTxt17.setBorder(null);
        IGM2IngresarPagTxt17.setBorderPainted(false);
        IGM2IngresarPagTxt17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt17limpiar18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ingreso_cts14Layout = new javax.swing.GroupLayout(panel_ingreso_cts14);
        panel_ingreso_cts14.setLayout(panel_ingreso_cts14Layout);
        panel_ingreso_cts14Layout.setHorizontalGroup(
            panel_ingreso_cts14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts14Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panel_ingreso_cts14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ingreso_cts14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(panel_ingreso_cts14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_ingreso_cts14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGM2IngresarPagTxt12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2IngresarPagTxt17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        panel_ingreso_cts14Layout.setVerticalGroup(
            panel_ingreso_cts14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts14Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_ingreso_cts14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ingreso_cts14Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(IGM2IngresarPagTxt12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IGM2IngresarPagTxt17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("TELEFONOS", panel_ingreso_cts14);

        panel_ingreso_cts15.setBackground(new java.awt.Color(102, 0, 0));
        panel_ingreso_cts15.setMaximumSize(new java.awt.Dimension(1144, 764));
        panel_ingreso_cts15.setPreferredSize(new java.awt.Dimension(1144, 764));

        jLabel92.setBackground(new java.awt.Color(0, 0, 51));
        jLabel92.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("CORREOS");
        jLabel92.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel45.setBackground(new java.awt.Color(0, 0, 51));
        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel45.setOpaque(false);

        jLabel172.setBackground(new java.awt.Color(0, 0, 51));
        jLabel172.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel172.setText("NOMBRE");
        jLabel172.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        NOMBRE_CTO2.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOMBRE_CTO2.setForeground(new java.awt.Color(0, 0, 51));
        NOMBRE_CTO2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel177.setBackground(new java.awt.Color(0, 0, 51));
        jLabel177.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(255, 255, 255));
        jLabel177.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel177.setText("CORREO");
        jLabel177.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CARGO_CTO2.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CARGO_CTO2.setForeground(new java.awt.Color(0, 0, 51));
        CARGO_CTO2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel172, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel177, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CARGO_CTO2)
                    .addComponent(NOMBRE_CTO2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOMBRE_CTO2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CARGO_CTO2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel177, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IGM2IngresarPagTxt15.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt15.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt15.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt15.setText("GUARDAR");
        IGM2IngresarPagTxt15.setBorder(null);
        IGM2IngresarPagTxt15.setBorderPainted(false);
        IGM2IngresarPagTxt15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt15limpiar18ActionPerformed(evt);
            }
        });

        TBL_CTO2.setBackground(new java.awt.Color(0, 0, 51));
        TBL_CTO2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_CTO2.setForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_CTO2.setAlignmentX(1.0F);
        TBL_CTO2.setAlignmentY(1.0F);
        TBL_CTO2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBL_CTO2.setRowHeight(30);
        TBL_CTO2.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TBL_CTO2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO2.getTableHeader().setReorderingAllowed(false);
        TBL_CTO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_CTO2MouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(TBL_CTO2);

        IGM2IngresarPagTxt18.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt18.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt18.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt18.setText("ELIMINAR");
        IGM2IngresarPagTxt18.setBorder(null);
        IGM2IngresarPagTxt18.setBorderPainted(false);
        IGM2IngresarPagTxt18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt18limpiar18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ingreso_cts15Layout = new javax.swing.GroupLayout(panel_ingreso_cts15);
        panel_ingreso_cts15.setLayout(panel_ingreso_cts15Layout);
        panel_ingreso_cts15Layout.setHorizontalGroup(
            panel_ingreso_cts15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts15Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panel_ingreso_cts15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ingreso_cts15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(panel_ingreso_cts15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_ingreso_cts15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGM2IngresarPagTxt15, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2IngresarPagTxt18, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        panel_ingreso_cts15Layout.setVerticalGroup(
            panel_ingreso_cts15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts15Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_ingreso_cts15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ingreso_cts15Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(IGM2IngresarPagTxt15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IGM2IngresarPagTxt18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CORREOS", panel_ingreso_cts15);

        panel_ingreso_cts16.setBackground(new java.awt.Color(102, 0, 0));
        panel_ingreso_cts16.setMaximumSize(new java.awt.Dimension(1144, 764));
        panel_ingreso_cts16.setPreferredSize(new java.awt.Dimension(1144, 764));

        jLabel93.setBackground(new java.awt.Color(0, 0, 51));
        jLabel93.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("DIRECCIONES");
        jLabel93.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel46.setBackground(new java.awt.Color(0, 0, 51));
        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel46.setOpaque(false);

        jLabel173.setBackground(new java.awt.Color(0, 0, 51));
        jLabel173.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel173.setText("NOMBRE");
        jLabel173.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        NOMBRE_CTO3.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOMBRE_CTO3.setForeground(new java.awt.Color(0, 0, 51));
        NOMBRE_CTO3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel178.setBackground(new java.awt.Color(0, 0, 51));
        jLabel178.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(255, 255, 255));
        jLabel178.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel178.setText("DIRECCION");
        jLabel178.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CARGO_CTO3.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CARGO_CTO3.setForeground(new java.awt.Color(0, 0, 51));
        CARGO_CTO3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel173, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel178, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CARGO_CTO3)
                    .addComponent(NOMBRE_CTO3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOMBRE_CTO3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CARGO_CTO3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IGM2IngresarPagTxt16.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt16.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt16.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt16.setText("GUARDAR");
        IGM2IngresarPagTxt16.setBorder(null);
        IGM2IngresarPagTxt16.setBorderPainted(false);
        IGM2IngresarPagTxt16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt16limpiar18ActionPerformed(evt);
            }
        });

        TBL_CTO3.setBackground(new java.awt.Color(0, 0, 51));
        TBL_CTO3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        TBL_CTO3.setForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBL_CTO3.setAlignmentX(1.0F);
        TBL_CTO3.setAlignmentY(1.0F);
        TBL_CTO3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TBL_CTO3.setRowHeight(30);
        TBL_CTO3.setSelectionBackground(new java.awt.Color(0, 153, 255));
        TBL_CTO3.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TBL_CTO3.getTableHeader().setReorderingAllowed(false);
        TBL_CTO3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_CTO3MouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(TBL_CTO3);

        IGM2IngresarPagTxt19.setBackground(new java.awt.Color(0, 0, 0));
        IGM2IngresarPagTxt19.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IGM2IngresarPagTxt19.setForeground(new java.awt.Color(255, 255, 255));
        IGM2IngresarPagTxt19.setText("ELIMINAR");
        IGM2IngresarPagTxt19.setBorder(null);
        IGM2IngresarPagTxt19.setBorderPainted(false);
        IGM2IngresarPagTxt19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGM2IngresarPagTxt19limpiar18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ingreso_cts16Layout = new javax.swing.GroupLayout(panel_ingreso_cts16);
        panel_ingreso_cts16.setLayout(panel_ingreso_cts16Layout);
        panel_ingreso_cts16Layout.setHorizontalGroup(
            panel_ingreso_cts16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts16Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panel_ingreso_cts16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ingreso_cts16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(panel_ingreso_cts16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(panel_ingreso_cts16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGM2IngresarPagTxt16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IGM2IngresarPagTxt19, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        panel_ingreso_cts16Layout.setVerticalGroup(
            panel_ingreso_cts16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ingreso_cts16Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_ingreso_cts16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ingreso_cts16Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(IGM2IngresarPagTxt16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IGM2IngresarPagTxt19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DIRECCIONES", panel_ingreso_cts16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IGM2IngresarPagTxt8limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt8limpiar18ActionPerformed
        NOMBRE_CTO.setText("");
        CARGO_CTO.setText("");
        TEL_CTO.setText("");
        TEL_CTO1.setText("");
    }//GEN-LAST:event_IGM2IngresarPagTxt8limpiar18ActionPerformed

    private void IGM2IngresarPagTxt9limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt9limpiar18ActionPerformed
        Ingresos contacto =  new Ingresos();
        contacto.IngresosContacto();
        consulta.mostrar_tabla4();
        NOMBRE_CTO.setText("");
        CARGO_CTO.setText("");
        TEL_CTO.setText("");
        TEL_CTO1.setText("");
    }//GEN-LAST:event_IGM2IngresarPagTxt9limpiar18ActionPerformed

    private void IGM2IngresarPagTxt10limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt10limpiar18ActionPerformed
        int fila= TBL_CTO.getSelectedRow();
        if(fila>=0){
            IGM2IngresarPagTxt13.setEnabled(true);
            IGM2IngresarPagTxt9.setEnabled(false);
            NOMBRE_CTO.setText(TBL_CTO.getValueAt(fila,1).toString());
            CARGO_CTO.setText(TBL_CTO.getValueAt(fila,2).toString());
            TEL_CTO.setText(TEL_CTO1.getText());
        }else{ JOptionPane.showMessageDialog(null,"SELECCIONE UN REGISTRO");}
    }//GEN-LAST:event_IGM2IngresarPagTxt10limpiar18ActionPerformed

    private void TBL_CTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_CTOMouseClicked
        consulta.mostrar_textfield4(TBL_CTO.getValueAt(TBL_CTO.getSelectedRow(),0).toString());
    }//GEN-LAST:event_TBL_CTOMouseClicked

    private void IGM2IngresarPagTxt13limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt13limpiar18ActionPerformed
        try {
            String id = valueOf(TBL_CTO.getValueAt(TBL_CTO.getSelectedRow(),0));
            String sql = "UPDATE tbl_contacto_aseguradora SET NombreCompleto_cas='"+NOMBRE_CTO.getText()+"',Telefonos_cas='"+TEL_CTO.getText()+"'"
            + ",Cargo_cas='"+CARGO_CTO.getText()+"' WHERE IdContacto='"+id+"'";

            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();

            consulta.mostrar_tabla4();
            NOMBRE_CTO.setText("");
            CARGO_CTO.setText("");
            TEL_CTO.setText("");
            TEL_CTO1.setText("");
            IGM2IngresarPagTxt9.setEnabled(true);
            IGM2IngresarPagTxt13.setEnabled(false);
            JOptionPane.showMessageDialog(null,"ACTUALIZADO");
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IGM2IngresarPagTxt13limpiar18ActionPerformed

    private void IGM2IngresarPagTxt14limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt14limpiar18ActionPerformed
        int fila= TBL_CTO.getSelectedRow();
        if(fila>=0){
            String sql = "DELETE  FROM tbl_contacto_aseguradora WHERE IdContacto ="+TBL_CTO.getValueAt(fila,0).toString()+"";
            try {
                PreparedStatement pps = cn.prepareStatement(sql);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"CONTACTO ELIMINADO");

                consulta.mostrar_tabla4();
                NOMBRE_CTO.setText("");
                CARGO_CTO.setText("");
                TEL_CTO.setText("");
                TEL_CTO1.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{ JOptionPane.showMessageDialog(null,"SELECCIONE UN REGISTRO");}
    }//GEN-LAST:event_IGM2IngresarPagTxt14limpiar18ActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
       this.setSize(1144, 764);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
         this.setSize(200, 40);
    }//GEN-LAST:event_formInternalFrameIconified

    private void IGM2IngresarPagTxt12limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt12limpiar18ActionPerformed
        try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO tbl_telefonos (Nombre_tel, Telefono) VALUES(?,?)");
                pps.setString(1, NOMBRE_CTO1.getText());
                pps.setString(2, CARGO_CTO1.getText());

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id ");
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Tel");
       
    
       
       String sql ="SELECT * FROM tbl_telefonos";
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
     TBL_CTO1.setModel(modelo1); 
      TBL_CTO1.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO1.getColumnModel().getColumn(1).setPreferredWidth(600);
     TBL_CTO1.getColumnModel().getColumn(2).setPreferredWidth(300);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IGM2IngresarPagTxt12limpiar18ActionPerformed

    private void TBL_CTO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_CTO1MouseClicked
       IGM2IngresarPagTxt17.setEnabled(true);
       
    }//GEN-LAST:event_TBL_CTO1MouseClicked

    private void IGM2IngresarPagTxt17limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt17limpiar18ActionPerformed
            int fila= TBL_CTO1.getSelectedRow();
        if(fila>=0){
            String sql = "DELETE  FROM tbl_telefonos WHERE NoRegistro_tel ="+TBL_CTO1.getValueAt(fila,0).toString()+"";
            try {
                PreparedStatement pps = cn.prepareStatement(sql);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"TELEFONO ELIMINADO");

              
                NOMBRE_CTO1.setText("");
                CARGO_CTO1.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{ JOptionPane.showMessageDialog(null,"SELECCIONE UN REGISTRO");}
            IGM2IngresarPagTxt17.setEnabled(false);
                 ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id ");
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Tel");
       
    
       
       String sql ="SELECT * FROM tbl_telefonos";
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
     TBL_CTO1.setModel(modelo1); 
      TBL_CTO1.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO1.getColumnModel().getColumn(1).setPreferredWidth(600);
     TBL_CTO1.getColumnModel().getColumn(2).setPreferredWidth(300);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IGM2IngresarPagTxt17limpiar18ActionPerformed

    private void IGM2IngresarPagTxt15limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt15limpiar18ActionPerformed
           try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO correos (Nombre_email, Email) VALUES(?,?)");
                pps.setString(1, NOMBRE_CTO2.getText());
                pps.setString(2, CARGO_CTO2.getText());

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("id ");
       modelo1.addColumn("Nombre");
       modelo1.addColumn("Correo");
       
    
       
       String sql ="SELECT * FROM correos";
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
     TBL_CTO2.setModel(modelo1); 
      TBL_CTO2.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO2.getColumnModel().getColumn(1).setPreferredWidth(600);
     TBL_CTO2.getColumnModel().getColumn(2).setPreferredWidth(300);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_IGM2IngresarPagTxt15limpiar18ActionPerformed

    private void TBL_CTO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_CTO2MouseClicked
          IGM2IngresarPagTxt18.setEnabled(true);
    }//GEN-LAST:event_TBL_CTO2MouseClicked

    private void IGM2IngresarPagTxt18limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt18limpiar18ActionPerformed
        int fila= TBL_CTO2.getSelectedRow();
        if(fila>=0){
            String sql = "DELETE  FROM correos WHERE NoRegistro_email ="+TBL_CTO2.getValueAt(fila,0).toString()+"";
            try {
                PreparedStatement pps = cn.prepareStatement(sql);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"TELEFONO ELIMINADO");

              
                NOMBRE_CTO2.setText("");
                CARGO_CTO2.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{ JOptionPane.showMessageDialog(null,"SELECCIONE UN REGISTRO");}
            IGM2IngresarPagTxt18.setEnabled(false);
                        ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo2 = new DefaultTableModel();
     
       modelo2.addColumn("id ");
       modelo2.addColumn("Nombre");
       modelo2.addColumn("Correo");
       
    
       
       String sql2 ="SELECT * FROM correos";
       String datos2[] = new String[3];
       Statement st2;
        try {
            st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(sql2);
            while(rs.next()){
           
             datos2[0]= rs.getString(1);
             datos2[1]= rs.getString(2);
             datos2[2]= rs.getString(3);  
            modelo2.addRow(datos2);
             
            
        }
     TBL_CTO2.setModel(modelo2); 
      TBL_CTO2.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO2.getColumnModel().getColumn(1).setPreferredWidth(600);
     TBL_CTO2.getColumnModel().getColumn(2).setPreferredWidth(300);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IGM2IngresarPagTxt18limpiar18ActionPerformed

    private void IGM2IngresarPagTxt16limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt16limpiar18ActionPerformed
 try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO direcciones (Nombre_dir, Direccion) VALUES(?,?)");
                pps.setString(1, NOMBRE_CTO3.getText());
                pps.setString(2, CARGO_CTO3.getText());

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo3 = new DefaultTableModel();
     
       modelo3.addColumn("id ");
       modelo3.addColumn("Nombre");
       modelo3.addColumn("Direccion");
       
    
       
       String sql3 ="SELECT * FROM direcciones";
       String datos3[] = new String[3];
       Statement st3;
        try {
            st3 = cn.createStatement();
            ResultSet rs = st3.executeQuery(sql3);
            while(rs.next()){
           
             datos3[0]= rs.getString(1);
             datos3[1]= rs.getString(2);
             datos3[2]= rs.getString(3);  
            modelo3.addRow(datos3);
             
            
        }
     TBL_CTO3.setModel(modelo3); 
      TBL_CTO3.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO3.getColumnModel().getColumn(1).setPreferredWidth(200);
     TBL_CTO3.getColumnModel().getColumn(2).setPreferredWidth(700);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IGM2IngresarPagTxt16limpiar18ActionPerformed

    private void TBL_CTO3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_CTO3MouseClicked
     IGM2IngresarPagTxt19.setEnabled(true);
    }//GEN-LAST:event_TBL_CTO3MouseClicked

    private void IGM2IngresarPagTxt19limpiar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGM2IngresarPagTxt19limpiar18ActionPerformed
      int fila= TBL_CTO3.getSelectedRow();
        if(fila>=0){
            String sql = "DELETE  FROM direcciones WHERE NoRegistro_dir ="+TBL_CTO3.getValueAt(fila,0).toString()+"";
            try {
                PreparedStatement pps = cn.prepareStatement(sql);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"TELEFONO ELIMINADO");

              
                NOMBRE_CTO3.setText("");
                CARGO_CTO3.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{ JOptionPane.showMessageDialog(null,"SELECCIONE UN REGISTRO");}
            IGM2IngresarPagTxt19.setEnabled(false);
                     ////////////////////// TABLA ////////////////////////////////////////
        DefaultTableModel modelo3 = new DefaultTableModel();
     
       modelo3.addColumn("id ");
       modelo3.addColumn("Nombre");
       modelo3.addColumn("Direccion");
       
    
       
       String sql3 ="SELECT * FROM direcciones";
       String datos3[] = new String[3];
       Statement st3;
        try {
            st3 = cn.createStatement();
            ResultSet rs = st3.executeQuery(sql3);
            while(rs.next()){
           
             datos3[0]= rs.getString(1);
             datos3[1]= rs.getString(2);
             datos3[2]= rs.getString(3);  
            modelo3.addRow(datos3);
             
            
        }
     TBL_CTO3.setModel(modelo3); 
      TBL_CTO3.getColumnModel().getColumn(0).setPreferredWidth(100);
     TBL_CTO3.getColumnModel().getColumn(1).setPreferredWidth(200);
     TBL_CTO3.getColumnModel().getColumn(2).setPreferredWidth(700);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IGM2IngresarPagTxt19limpiar18ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CARGO_CTO;
    public static javax.swing.JTextField CARGO_CTO1;
    public static javax.swing.JTextField CARGO_CTO2;
    public static javax.swing.JTextField CARGO_CTO3;
    private javax.swing.JButton IGM2IngresarPagTxt10;
    private javax.swing.JButton IGM2IngresarPagTxt12;
    private javax.swing.JButton IGM2IngresarPagTxt13;
    private javax.swing.JButton IGM2IngresarPagTxt14;
    private javax.swing.JButton IGM2IngresarPagTxt15;
    private javax.swing.JButton IGM2IngresarPagTxt16;
    private javax.swing.JButton IGM2IngresarPagTxt17;
    private javax.swing.JButton IGM2IngresarPagTxt18;
    private javax.swing.JButton IGM2IngresarPagTxt19;
    private javax.swing.JButton IGM2IngresarPagTxt8;
    private javax.swing.JButton IGM2IngresarPagTxt9;
    public static javax.swing.JTextField NOMBRE_CTO;
    public static javax.swing.JTextField NOMBRE_CTO1;
    public static javax.swing.JTextField NOMBRE_CTO2;
    public static javax.swing.JTextField NOMBRE_CTO3;
    public static javax.swing.JTable TBL_CTO;
    public static javax.swing.JTable TBL_CTO1;
    public static javax.swing.JTable TBL_CTO2;
    public static javax.swing.JTable TBL_CTO3;
    public static javax.swing.JTextArea TEL_CTO;
    public static javax.swing.JTextArea TEL_CTO1;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel_ingreso_cts13;
    private javax.swing.JPanel panel_ingreso_cts14;
    private javax.swing.JPanel panel_ingreso_cts15;
    private javax.swing.JPanel panel_ingreso_cts16;
    // End of variables declaration//GEN-END:variables
}
