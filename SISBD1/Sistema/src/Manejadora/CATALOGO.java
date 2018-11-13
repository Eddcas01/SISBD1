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
import Base_de_Datos.Ingresos;


/**
 *
 * @author gganp
 */
public class CATALOGO extends javax.swing.JInternalFrame {

    /**
     * Creates new form CATALOGO
     */
    
       int menu=0;
    int i =0;
    int Ingresos=0;
    int Cobros = 0;
     Consultas consulta = new Consultas();
    Busquedas src = new Busquedas();
    public static int tipo=0;
    Eliminar del =new Eliminar();
    Cliente cl = new Cliente();
    conexionBD con = new conexionBD();
    Connection cn = con.conexion();
    public CATALOGO() {
        initComponents();
    }
public void mostrar_tabla4_vhl(){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("ID ");
       modelo1.addColumn("ASEGURADORA");
       modelo1.addColumn("NOMBRE");
       modelo1.addColumn("CUOTA");
       
    
       
       String sql ="SELECT IdSeguro_vhl, tbl_aseguradora.Nombre_as, Nombre, Cuotas_vhl FROM tbl_vhl, tbl_aseguradora WHERE IdAseguradora = IdAseguradora_vhl ";
       String datos[] = new String[4];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
             datos[0]= rs.getString(1);
             datos[1]= rs.getString(2);
             datos[2]= rs.getString(3);
             datos[3]= rs.getString(4);
 
             modelo1.addRow(datos);      
        }
        TBL_CBR.setModel(modelo1); 
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
public void mostrar_tabla4_gm(){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("ID ");
       modelo1.addColumn("ASEGURADORA");
       modelo1.addColumn("NOMBRE");
       modelo1.addColumn("CUOTA");
       
    
       
       String sql ="SELECT IdSeguro_gm, tbl_aseguradora.Nombre_as, Nombre, Cuotas_gm FROM tbl_gm, tbl_aseguradora WHERE IdAseguradora = IdAseguradora_gm ";
       String datos[] = new String[4];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
             datos[0]= rs.getString(1);
             datos[1]= rs.getString(2);
             datos[2]= rs.getString(3);
             datos[3]= rs.getString(4);
  
            modelo1.addRow(datos);
           
            
        }
        TBL_CBR.setModel(modelo1); 
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
public void mostrar_tabla4_ee(){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("ID ");
       modelo1.addColumn("ASEGURADORA");
       modelo1.addColumn("NOMBRE");
       modelo1.addColumn("CUOTA");
       
    
       
       String sql ="SELECT IdSeguro_ee, tbl_aseguradora.Nombre_as, Nombre, Cuotas_ee FROM tbl_ee, tbl_aseguradora WHERE IdAseguradora = IdAseguradora_ee ";
       String datos[] = new String[4];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
             datos[0]= rs.getString(1);
             datos[1]= rs.getString(2);
             datos[2]= rs.getString(3);
             datos[3]= rs.getString(4);
  
            modelo1.addRow(datos);
            
        }
         TBL_CBR.setModel(modelo1);
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
public void mostrar_tabla4_vd(){


           DefaultTableModel modelo1 = new DefaultTableModel();
     
       modelo1.addColumn("ID ");
       modelo1.addColumn("ASEGURADORA");
       modelo1.addColumn("NOMBRE");
       modelo1.addColumn("CUOTA");
       
    
       
       String sql ="SELECT IdSeguro_vd, tbl_aseguradora.Nombre_as, Nombre, Cuotas_vd FROM tbl_vd, tbl_aseguradora WHERE IdAseguradora = IdAseguradora_vd ";
       String datos[] = new String[4];
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
             datos[0]= rs.getString(1);
             datos[1]= rs.getString(2);
             datos[2]= rs.getString(3);
             datos[3]= rs.getString(4);
  
            modelo1.addRow(datos);
            
        }
     TBL_CBR.setModel(modelo1); 
        } catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     
 public void IngresosVhl( ){
           try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO tbl_vhl (IdAseguradora_vhl, Nombre, Cuotas_vhl, Coberturas_vhl, Requisitos_vhl, Descripcion_vhl"
                 +") VALUES(?,?,?,?,?,?)");
               
                pps.setString(1, ASEG.getText());
                pps.setString(2, NOM.getText());
                pps.setString(3, CUOTAS.getText());
                pps.setString(4, COB.getText());
                pps.setString(5, REQ.getText());
                pps.setString(6, DESC.getText());

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
 public void IngresosGm( ){
           try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO tbl_gm (IdAseguradora_gm, Nombre, Cuotas_gm, Coberturas_gm, Requisitos_gm, Descripcion_gm"
                 +") VALUES(?,?,?,?,?,?)");
               
                pps.setString(1, ASEG.getText());
                pps.setString(2, NOM.getText());
                pps.setString(3, CUOTAS.getText());
                pps.setString(4, COB.getText());
                pps.setString(5, REQ.getText());
                pps.setString(6, DESC.getText());

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
 public void IngresosEe( ){
           try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO tbl_ee (IdAseguradora_ee, Nombre, Cuotas_ee, Coberturas_ee Requisitos_ee, Descripcion_ee"
                 +") VALUES(?,?,?,?,?,?)");
               
                pps.setString(1, ASEG.getText());
                pps.setString(2, NOM.getText());
                pps.setString(3, CUOTAS.getText());
                pps.setString(4, COB.getText());
                pps.setString(5, REQ.getText());
                pps.setString(6, DESC.getText());

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
  public void IngresosVd( ){
           try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO tbl_vd (IdAseguradora_vd, Nombre, Cuotas_vd, Coberturas_vd, Requisitos_vd, Descripcion_vd"
                 +") VALUES(?,?,?,?,?,?)");
               
                pps.setString(1, ASEG.getText());
                pps.setString(2, NOM.getText());
                pps.setString(3, CUOTAS.getText());
                pps.setString(4, COB.getText());
                pps.setString(5, REQ.getText());
                pps.setString(6, DESC.getText());

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
  public void mostrar_textfield(String id,String tbl){

       String sql ="SELECT Coberturas_"+tbl+", Requisitos_"+tbl+", Descripcion_"+tbl+" FROM tbl_"+tbl+" WHERE IdSeguro_vhl="+id+"";
       Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
           
              REQ2.setText(rs.getString(1));
            COB2.setText(rs.getString(2));
            DESC2.setText(rs.getString(3));
  
        }} catch (SQLException ex) {
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

        COBRO = new javax.swing.JTabbedPane();
        MENU1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        VehiculosMenuBtn = new javax.swing.JButton();
        GastosMedMenuBtn = new javax.swing.JButton();
        EquiposMenuBtn = new javax.swing.JButton();
        SegVidaBtn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
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
        IV2AtrasBtn3 = new javax.swing.JButton();
        COBROS = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        ASEG = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        IV2IngresarPBtn = new javax.swing.JButton();
        CUOTAS = new javax.swing.JTextField();
        NOM = new javax.swing.JTextField();
        IV2AtrasBtn2 = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        COB = new javax.swing.JTextArea();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        REQ = new javax.swing.JTextArea();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        DESC = new javax.swing.JTextArea();
        IV2AtrasBtn1 = new javax.swing.JButton();
        C_GM3 = new javax.swing.JPanel();
        CGM2AtrasBtn1 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TBL_CBR = new javax.swing.JTable();
        CGM2AtrasBtn4 = new javax.swing.JButton();
        CGM2AtrasBtn5 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        REQ2 = new javax.swing.JTextArea();
        jScrollPane21 = new javax.swing.JScrollPane();
        COB2 = new javax.swing.JTextArea();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        DESC2 = new javax.swing.JTextArea();

        setClosable(true);

        COBRO.setBackground(new java.awt.Color(51, 51, 51));

        MENU1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setOpaque(false);

        VehiculosMenuBtn.setBackground(new java.awt.Color(0, 0, 0));
        VehiculosMenuBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        VehiculosMenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        VehiculosMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/coche (1).png"))); // NOI18N
        VehiculosMenuBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        VehiculosMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculosMenuBtnActionPerformed(evt);
            }
        });

        GastosMedMenuBtn.setBackground(new java.awt.Color(0, 0, 0));
        GastosMedMenuBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        GastosMedMenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        GastosMedMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/botiquin-de-primeros-auxilios (2).png"))); // NOI18N
        GastosMedMenuBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        GastosMedMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GastosMedMenuBtnActionPerformed(evt);
            }
        });

        EquiposMenuBtn.setBackground(new java.awt.Color(0, 0, 0));
        EquiposMenuBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        EquiposMenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        EquiposMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/maquinaria.png"))); // NOI18N
        EquiposMenuBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EquiposMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquiposMenuBtnActionPerformed(evt);
            }
        });

        SegVidaBtn.setBackground(new java.awt.Color(0, 0, 0));
        SegVidaBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        SegVidaBtn.setForeground(new java.awt.Color(255, 255, 255));
        SegVidaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/corazon (3).png"))); // NOI18N
        SegVidaBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        SegVidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegVidaBtnActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(0, 0, 51));
        jLabel20.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("VEHICULOS");
        jLabel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel61.setBackground(new java.awt.Color(0, 0, 51));
        jLabel61.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("EQUIPOS");
        jLabel61.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel64.setBackground(new java.awt.Color(0, 0, 51));
        jLabel64.setFont(new java.awt.Font("Segoe UI Historic", 1, 26)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("GASTOS MEDICOS");
        jLabel64.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel80.setBackground(new java.awt.Color(0, 0, 51));
        jLabel80.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("SEG. DE VIDA");
        jLabel80.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EquiposMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(VehiculosMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GastosMedMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SegVidaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GastosMedMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175))
                            .addComponent(SegVidaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(VehiculosMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(EquiposMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel12.setBackground(new java.awt.Color(0, 0, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI Historic", 1, 40)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Menú");
        jLabel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout MENU1Layout = new javax.swing.GroupLayout(MENU1);
        MENU1.setLayout(MENU1Layout);
        MENU1Layout.setHorizontalGroup(
            MENU1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU1Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
            .addGroup(MENU1Layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MENU1Layout.setVerticalGroup(
            MENU1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        COBRO.addTab("MENU", MENU1);

        MENU2.setBackground(new java.awt.Color(102, 102, 102));

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
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Menú");
        jLabel79.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2AtrasBtn3.setBackground(new java.awt.Color(0, 0, 0));
        IV2AtrasBtn3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2AtrasBtn3.setForeground(new java.awt.Color(255, 255, 255));
        IV2AtrasBtn3.setText("ATRAS");
        IV2AtrasBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2AtrasBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENU2Layout = new javax.swing.GroupLayout(MENU2);
        MENU2.setLayout(MENU2Layout);
        MENU2Layout.setHorizontalGroup(
            MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU2Layout.createSequentialGroup()
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258)
                        .addComponent(IV2AtrasBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(317, 317, 317))
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
                .addGroup(MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IV2AtrasBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(CerrarSesionMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MENU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SalirMenu2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        COBRO.addTab("MENU 2", MENU2);

        COBROS.setBackground(new java.awt.Color(102, 102, 102));

        jLabel57.setBackground(new java.awt.Color(0, 0, 51));
        jLabel57.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("INGRESO DE SEGUROS");
        jLabel57.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel29.setBackground(new java.awt.Color(0, 0, 51));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel29.setOpaque(false);

        ASEG.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        ASEG.setForeground(new java.awt.Color(0, 0, 51));
        ASEG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ASEG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASEGActionPerformed(evt);
            }
        });

        jLabel120.setBackground(new java.awt.Color(0, 0, 51));
        jLabel120.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("ASEGURADORA");
        jLabel120.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel128.setBackground(new java.awt.Color(0, 0, 51));
        jLabel128.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("CUOTAS");
        jLabel128.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel121.setBackground(new java.awt.Color(0, 0, 51));
        jLabel121.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("NOMBRE");
        jLabel121.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        IV2IngresarPBtn.setBackground(new java.awt.Color(0, 0, 0));
        IV2IngresarPBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2IngresarPBtn.setForeground(new java.awt.Color(255, 255, 255));
        IV2IngresarPBtn.setText("INGRESAR ");
        IV2IngresarPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2IngresarPBtnActionPerformed(evt);
            }
        });

        CUOTAS.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        CUOTAS.setForeground(new java.awt.Color(0, 0, 51));
        CUOTAS.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        NOM.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        NOM.setForeground(new java.awt.Color(0, 0, 51));
        NOM.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        IV2AtrasBtn2.setBackground(new java.awt.Color(0, 0, 0));
        IV2AtrasBtn2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2AtrasBtn2.setForeground(new java.awt.Color(255, 255, 255));
        IV2AtrasBtn2.setText("ACTUALIZAR");
        IV2AtrasBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2AtrasBtn2ActionPerformed(evt);
            }
        });

        jLabel86.setBackground(new java.awt.Color(204, 102, 0));
        jLabel86.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("COBERTURAS");

        COB.setColumns(20);
        COB.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        COB.setRows(5);
        jScrollPane23.setViewportView(COB);

        jLabel87.setBackground(new java.awt.Color(204, 102, 0));
        jLabel87.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("REQUISITOS");

        REQ.setColumns(20);
        REQ.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        REQ.setRows(5);
        jScrollPane24.setViewportView(REQ);

        jLabel88.setBackground(new java.awt.Color(204, 102, 0));
        jLabel88.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("DESCRIPCION");

        DESC.setColumns(20);
        DESC.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        DESC.setRows(5);
        jScrollPane25.setViewportView(DESC);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(IV2IngresarPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(IV2AtrasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jScrollPane25)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel29Layout.createSequentialGroup()
                                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel128, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NOM)
                                            .addComponent(CUOTAS, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ASEG, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel29Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)))
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)))
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASEG, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NOM, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CUOTAS, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel128, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IV2IngresarPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IV2AtrasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        IV2AtrasBtn1.setBackground(new java.awt.Color(0, 0, 0));
        IV2AtrasBtn1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        IV2AtrasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        IV2AtrasBtn1.setText("ATRAS");
        IV2AtrasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IV2AtrasBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout COBROSLayout = new javax.swing.GroupLayout(COBROS);
        COBROS.setLayout(COBROSLayout);
        COBROSLayout.setHorizontalGroup(
            COBROSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(COBROSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248)
                .addComponent(IV2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(COBROSLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        COBROSLayout.setVerticalGroup(
            COBROSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(COBROSLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(COBROSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IV2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        COBRO.addTab("I CATALOGO", COBROS);

        C_GM3.setBackground(new java.awt.Color(102, 102, 102));

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
        jLabel82.setText("COBERTURAS");

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
        TBL_CBR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_CBRMouseClicked(evt);
            }
        });
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

        REQ2.setColumns(20);
        REQ2.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        REQ2.setRows(5);
        jScrollPane20.setViewportView(REQ2);

        COB2.setColumns(20);
        COB2.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        COB2.setRows(5);
        jScrollPane21.setViewportView(COB2);

        jLabel83.setBackground(new java.awt.Color(204, 102, 0));
        jLabel83.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("REQUISITOS");

        jLabel84.setBackground(new java.awt.Color(204, 102, 0));
        jLabel84.setFont(new java.awt.Font("Segoe UI Historic", 1, 26)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("SEGUROS");

        jLabel85.setBackground(new java.awt.Color(204, 102, 0));
        jLabel85.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("DESCRIPCION");

        DESC2.setColumns(20);
        DESC2.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        DESC2.setRows(5);
        jScrollPane22.setViewportView(DESC2);

        javax.swing.GroupLayout C_GM3Layout = new javax.swing.GroupLayout(C_GM3);
        C_GM3.setLayout(C_GM3Layout);
        C_GM3Layout.setHorizontalGroup(
            C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_GM3Layout.createSequentialGroup()
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(CGM2AtrasBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CGM2AtrasBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_GM3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(C_GM3Layout.createSequentialGroup()
                                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(C_GM3Layout.createSequentialGroup()
                                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane20)
                                    .addComponent(jScrollPane22)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(398, 398, 398))
                                    .addComponent(jScrollPane21))
                                .addContainerGap())
                            .addGroup(C_GM3Layout.createSequentialGroup()
                                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(422, 422, 422))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        C_GM3Layout.setVerticalGroup(
            C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CGM2AtrasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(C_GM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CGM2AtrasBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CGM2AtrasBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, C_GM3Layout.createSequentialGroup()
                .addGap(0, 174, Short.MAX_VALUE)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        COBRO.addTab("C. CATALOGO", C_GM3);

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
            .addComponent(COBRO, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresosMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosMenu2BtnActionPerformed
        Ingresos = 1;
        IV2AtrasBtn2.setEnabled(false);
        IV2IngresarPBtn.setEnabled(true);
        
            COBRO.setSelectedIndex(2); 
           

    }//GEN-LAST:event_IngresosMenu2BtnActionPerformed

    private void EliminarMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMenu2BtnActionPerformed

           switch(menu)
        {
            case 1:
            mostrar_tabla4_vhl();

            COBRO.setSelectedIndex(3);break;
            case 2:
            mostrar_tabla4_gm();
            COBRO.setSelectedIndex(3); break;
            case 3:
            mostrar_tabla4_ee();
            COBRO.setSelectedIndex(3);break;
            case 4:
            mostrar_tabla4_vd();
            COBRO.setSelectedIndex(3);break;
        }
        
    }//GEN-LAST:event_EliminarMenu2BtnActionPerformed

    private void ConsultaMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaMenu2BtnActionPerformed
        switch(menu)
        {
            case 1:
            mostrar_tabla4_vhl();

            COBRO.setSelectedIndex(3);break;
            case 2:
            mostrar_tabla4_gm();
            COBRO.setSelectedIndex(3); break;
            case 3:
            mostrar_tabla4_ee();
            COBRO.setSelectedIndex(3);break;
            case 4:
            mostrar_tabla4_vd();
            COBRO.setSelectedIndex(3);break;
        }
    }//GEN-LAST:event_ConsultaMenu2BtnActionPerformed

    private void ModificacionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificacionMenu2BtnActionPerformed

        switch(menu)
        {
            case 1:
            mostrar_tabla4_vhl();

            COBRO.setSelectedIndex(3);break;
            case 2:
            mostrar_tabla4_gm();
            COBRO.setSelectedIndex(3); break;
            case 3:
            mostrar_tabla4_ee();
            COBRO.setSelectedIndex(3);break;
            case 4:
            mostrar_tabla4_vd();
            COBRO.setSelectedIndex(3);break;
        }
    }//GEN-LAST:event_ModificacionMenu2BtnActionPerformed

    private void CerrarSesionMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionMenu2BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CerrarSesionMenu2BtnActionPerformed

    private void SalirMenu2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirMenu2BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirMenu2BtnActionPerformed

    private void ASEGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASEGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASEGActionPerformed

    private void IV2IngresarPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2IngresarPBtnActionPerformed
 ASEG.setEnabled(true);
        if(ASEG.getText().equals("")|| NOM.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- Aseguradora.\n- Nombre.");
        }else{
            switch(menu)
            {
                case 1:
                IngresosVhl();
                break;
                case 2:
              IngresosGm();
              break;
                case 3:
                IngresosEe();break;
                case 4:
               IngresosVd();break;
            }}
    }//GEN-LAST:event_IV2IngresarPBtnActionPerformed

    private void IV2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2AtrasBtn1ActionPerformed
        COBRO.setSelectedIndex(3);
        i=0;
    }//GEN-LAST:event_IV2AtrasBtn1ActionPerformed

    private void IV2AtrasBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2AtrasBtn2ActionPerformed

        if( NOM.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Por favor rellene los siguientes campos:\n- NOMBRE.");
        }else{
            switch(menu)
            {
                case 1:
                try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "UPDATE tbl_vhl SET "
                    + "Nombre='"+NOM.getText()
                    + "',Cuotas_vhl='"+CUOTAS.getText()
                    + "',Requisitos_vhl='"+REQ.getText()
                    + "',Coberturas_vhl='"+COB.getText()
                    + "',Descripcion_vhl='"+DESC.getText()
                    + "' WHERE IdSeguro_vhl ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }
                COBRO.setSelectedIndex(1);break;

                case 2:

                 try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "UPDATE tbl_gm SET "
                    + "Nombre='"+NOM.getText()
                    + "',Cuotas_gm='"+CUOTAS.getText()
                    + "',Requisitos_gm='"+REQ.getText()
                    + "',Coberturas_gm='"+COB.getText()
                    + "',Descripcion_gm='"+DESC.getText()
                    + "' WHERE IdSeguro_gm ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }
                COBRO.setSelectedIndex(1);break;
                case 3:
                        try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "UPDATE tbl_ee SET "
                    + "Nombre='"+NOM.getText()
                    + "',Cuotas_ee='"+CUOTAS.getText()
                    + "',Requisitos_ee='"+REQ.getText()
                    + "',Coberturas_ee='"+COB.getText()
                    + "',Descripcion_ee='"+DESC.getText()
                    + "' WHERE IdSeguro_ee ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }
                COBRO.setSelectedIndex(1);break;
                case 4:
                       try {
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "UPDATE tbl_vd SET "
                    + "Nombre='"+NOM.getText()
                    + "',Cuotas_vd='"+CUOTAS.getText()
                    + "',Requisitos_vd='"+REQ.getText()
                    + "',Coberturas_vd='"+COB.getText()
                    + "',Descripcion_vd='"+DESC.getText()
                    + "' WHERE IdSeguro_vd ="+id+"";

                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ACTUALIZADO");
                } catch (SQLException ex) {
                    Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
                }
                COBRO.setSelectedIndex(1);break;

            }
        }

    }//GEN-LAST:event_IV2AtrasBtn2ActionPerformed

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

    private void CGM2AtrasBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn5ActionPerformed

        switch(menu)
        {
            case 1:
            try {

                if(TBL_CBR.getSelectedRow()<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN COBRO");}else{
          
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "DELETE  FROM tbl_vhl  WHERE IdSeguro_vhl ="+id+"";
                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ELIMINADO");
                    COBRO.setSelectedIndex(1);}

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case 2:

            try {
                int filagm  = TBL_CBR.getSelectedRow();
                if(filagm<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN COBRO");}else{
                    String id = valueOf(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(),0));
                    String sql = "DELETE  FROM tbl_gm  WHERE IdSeguro_gm ="+id+"";
                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ELIMINADO");
                    COBRO.setSelectedIndex(1);}

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
                    String sql = "DELETE  FROM tbl_ee  WHERE IdSeguro_ee ="+id+"";
                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ELIMINADO");
                    COBRO.setSelectedIndex(1);}

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
                    String sql = "DELETE  FROM tbl_vd  WHERE IdSeguro_vd ="+id+"";
                    PreparedStatement pps = cn.prepareStatement(sql);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ELIMINADO");
                    COBRO.setSelectedIndex(1);}

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

        }
    }//GEN-LAST:event_CGM2AtrasBtn5ActionPerformed

    private void CGM2AtrasBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn4ActionPerformed
       int fila= TBL_CBR.getSelectedRow();
       ASEG.setEnabled(false);
            IV2AtrasBtn2.setEnabled(true);
            IV2IngresarPBtn.setEnabled(false);
            if(fila<0){JOptionPane.showMessageDialog(null,"NO HA SELECCIONADO UN SEGURO");}else{
                
                NOM.setText(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(), 2).toString());
                CUOTAS.setText(TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(), 3).toString());
                DESC.setText( DESC2.getText());
                REQ.setText( REQ2.getText());
                COB.setText( COB2.getText());
            
              
                COBRO.setSelectedIndex(2);}
    }//GEN-LAST:event_CGM2AtrasBtn4ActionPerformed

    private void CGM2AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGM2AtrasBtn1ActionPerformed
        COBRO.setSelectedIndex(1);
    }//GEN-LAST:event_CGM2AtrasBtn1ActionPerformed

    private void IV2AtrasBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IV2AtrasBtn3ActionPerformed
       COBRO.setSelectedIndex(0);
    }//GEN-LAST:event_IV2AtrasBtn3ActionPerformed

    private void TBL_CBRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_CBRMouseClicked
      String id = TBL_CBR.getValueAt(TBL_CBR.getSelectedRow(), 0).toString();
      String tbl = "";
      
       switch(menu)
        {
            case 1:
            tbl ="vhl";break;
            case 2:
             tbl ="gm";break;
            case 3:
             tbl ="ee";break;
            case 4:
             tbl ="vd";break;
        }
        mostrar_textfield(id,tbl);
    }//GEN-LAST:event_TBL_CBRMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ASEG;
    private javax.swing.JButton CGM2AtrasBtn1;
    private javax.swing.JButton CGM2AtrasBtn4;
    private javax.swing.JButton CGM2AtrasBtn5;
    public static javax.swing.JTextArea COB;
    public static javax.swing.JTextArea COB2;
    private javax.swing.JTabbedPane COBRO;
    private javax.swing.JPanel COBROS;
    public static javax.swing.JTextField CUOTAS;
    private javax.swing.JPanel C_GM3;
    private javax.swing.JButton CerrarSesionMenu2Btn;
    private javax.swing.JButton ConsultaMenu2Btn;
    public static javax.swing.JTextArea DESC;
    public static javax.swing.JTextArea DESC2;
    private javax.swing.JButton EliminarMenu2Btn;
    private javax.swing.JButton EquiposMenuBtn;
    private javax.swing.JButton GastosMedMenuBtn;
    private javax.swing.JButton IV2AtrasBtn1;
    private javax.swing.JButton IV2AtrasBtn2;
    private javax.swing.JButton IV2AtrasBtn3;
    private javax.swing.JButton IV2IngresarPBtn;
    private javax.swing.JButton IngresosMenu2Btn;
    private javax.swing.JPanel MENU1;
    private javax.swing.JPanel MENU2;
    private javax.swing.JButton ModificacionMenu2Btn;
    public static javax.swing.JTextField NOM;
    public static javax.swing.JTextArea REQ;
    public static javax.swing.JTextArea REQ2;
    private javax.swing.JButton SalirMenu2Btn;
    private javax.swing.JButton SegVidaBtn;
    public static javax.swing.JTable TBL_CBR;
    private javax.swing.JButton VehiculosMenuBtn;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    // End of variables declaration//GEN-END:variables
}
