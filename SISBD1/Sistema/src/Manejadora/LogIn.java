/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manejadora;
import Base_de_Datos.conexionBD;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author gganp
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
      conexionBD con = new conexionBD();
    Connection cn = con.conexion();
      public  static int tipo=0;  
    public LogIn() {
        initComponents();
          setIconImage (new ImageIcon(getClass().getResource("/ICONS/logo.png")).getImage());
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        INGRESO = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        USER = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PASS = new javax.swing.JPasswordField();
        AceptarIngresoBtn = new javax.swing.JButton();
        LimpiarIngresoBtn = new javax.swing.JButton();
        SalirIngresoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(600, 250));
        setUndecorated(true);

        INGRESO.setBackground(new java.awt.Color(0, 51, 51));
        INGRESO.setAutoscrolls(true);
        INGRESO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        USER.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        USER.setForeground(new java.awt.Color(0, 51, 102));
        USER.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        USER.setBorder(null);
        USER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contraseña");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ingreso");
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PASS.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        PASS.setForeground(new java.awt.Color(0, 51, 102));
        PASS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PASS.setBorder(null);
        PASS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PASSActionPerformed(evt);
            }
        });

        AceptarIngresoBtn.setBackground(new java.awt.Color(0, 0, 0));
        AceptarIngresoBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        AceptarIngresoBtn.setForeground(new java.awt.Color(255, 255, 255));
        AceptarIngresoBtn.setText("ACEPTAR");
        AceptarIngresoBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AceptarIngresoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarIngresoBtnActionPerformed(evt);
            }
        });

        LimpiarIngresoBtn.setBackground(new java.awt.Color(0, 0, 0));
        LimpiarIngresoBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        LimpiarIngresoBtn.setForeground(new java.awt.Color(255, 255, 255));
        LimpiarIngresoBtn.setText("LIMPIAR");
        LimpiarIngresoBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        LimpiarIngresoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarIngresoBtnActionPerformed(evt);
            }
        });

        SalirIngresoBtn.setBackground(new java.awt.Color(51, 0, 0));
        SalirIngresoBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        SalirIngresoBtn.setForeground(new java.awt.Color(255, 255, 255));
        SalirIngresoBtn.setText("SALIR");
        SalirIngresoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirIngresoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout INGRESOLayout = new javax.swing.GroupLayout(INGRESO);
        INGRESO.setLayout(INGRESOLayout);
        INGRESOLayout.setHorizontalGroup(
            INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INGRESOLayout.createSequentialGroup()
                .addGroup(INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(INGRESOLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(INGRESOLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(INGRESOLayout.createSequentialGroup()
                                .addComponent(SalirIngresoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AceptarIngresoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LimpiarIngresoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(INGRESOLayout.createSequentialGroup()
                                .addGroup(INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(INGRESOLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(INGRESOLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PASS, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        INGRESOLayout.setVerticalGroup(
            INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INGRESOLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PASS, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(INGRESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarIngresoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LimpiarIngresoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalirIngresoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(INGRESO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(INGRESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void USERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USERActionPerformed

    private void PASSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PASSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PASSActionPerformed

    private void AceptarIngresoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarIngresoBtnActionPerformed
      
        Statement st;
        ResultSet rs;
        
        String user, pass;
        user = USER.getText();
        pass = PASS.getText();
       
        
        
        try
        {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT Tipo FROM usuarios WHERE (User = '"+user+"' and  Pass ='"+pass+"')");
            if(rs == null){
               
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTA..");
            }
           else if(rs != null){
            if(rs.next()){
                switch(rs.getString("Tipo"))
        {
            case "Admin":
            this.tipo=1;
            
                
                PRINCIPAL f = new PRINCIPAL();
                
                f.setVisible(true);
                f.setExtendedState(MAXIMIZED_BOTH);
                f.tipo=this.tipo;
                this.setVisible(false);
            break;
            case "User":
                
            this.tipo =2;
                 
                 PRINCIPAL fu = new PRINCIPAL();
                  fu.tipo=this.tipo;
                fu.setVisible(true);
                 fu.setExtendedState(MAXIMIZED_BOTH);
                 this.setVisible(false);
            break;
            default :
                
        }
            
            }
            } else { JOptionPane.showMessageDialog(null, " USUARIO O CONTRASEÑA INCORRECTA..");}
        }catch (SQLException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        
        
        
    }//GEN-LAST:event_AceptarIngresoBtnActionPerformed
    }
    private void LimpiarIngresoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarIngresoBtnActionPerformed
        USER.setText("");
        PASS.setText("");
    }//GEN-LAST:event_LimpiarIngresoBtnActionPerformed

    private void SalirIngresoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirIngresoBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirIngresoBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarIngresoBtn;
    private javax.swing.JPanel INGRESO;
    private javax.swing.JButton LimpiarIngresoBtn;
    private javax.swing.JPasswordField PASS;
    private javax.swing.JButton SalirIngresoBtn;
    private javax.swing.JTextField USER;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
