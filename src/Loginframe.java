
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Defangga
 */
public class Loginframe extends javax.swing.JFrame {
Connection con=null;
       ResultSet rs=null;
       PreparedStatement pst=null;
    /**
     * Creates new form Loginframe
     */
    public Loginframe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldPassword = new javax.swing.JPasswordField();
        empty = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setText("Username:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 330, 70, 30);

        jTextFieldUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUsernameMouseClicked(evt);
            }
        });
        jPanel1.add(jTextFieldUsername);
        jTextFieldUsername.setBounds(240, 330, 130, 30);

        jLabelPassword.setText("Password:");
        jPanel1.add(jLabelPassword);
        jLabelPassword.setBounds(100, 370, 60, 30);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(180, 420, 100, 23);

        jTextFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPasswordActionPerformed(evt);
            }
        });
        jTextFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldPassword);
        jTextFieldPassword.setBounds(240, 370, 130, 30);

        empty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login(1).png"))); // NOI18N
        jPanel1.add(empty);
        empty.setBounds(-30, 0, 460, 460);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection con=null;
       ResultSet rs=null;
       PreparedStatement pst=null;
       if (jTextFieldUsername.getText().equals("")) {
           JOptionPane.showMessageDialog( this, "Please enter user name");
           return;
        }
    
        if (jTextFieldPassword.getText().equals("")) {
           JOptionPane.showMessageDialog( this, "Please enter password");
           return;
          
            }
        con=Connect.ConnectDB();
        String sq1= "select * from users where user_name= '" + jTextFieldUsername.getText() + "' and password ='" + jTextFieldPassword.getText() + "'";
        try{
            pst=con.prepareStatement(sq1);
            rs= pst.executeQuery();
            if (rs.next()){
             this.hide();
             Main frm=new Main();
             frm.setVisible(true);
           }
           else{
              //JOptionPane.showMessageDialog(null, "Login Failed..Id & Password doesnot matched !");
              JOptionPane.showMessageDialog( this, "Id & Password didn't matched !","Login Failed", JOptionPane.ERROR_MESSAGE);
          }
        }catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
                  // TODO add your handling code here:
    }                                        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPasswordKeyReleased
        
    }//GEN-LAST:event_jTextFieldPasswordKeyReleased

    private void jTextFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPasswordActionPerformed

    private void jTextFieldUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUsernameMouseClicked
      
    }//GEN-LAST:event_jTextFieldUsernameMouseClicked

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
            java.util.logging.Logger.getLogger(Loginframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel empty;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
