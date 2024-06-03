/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admindashboard;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import utilities.Connection;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Dell
 */
public class EditInstructorForm extends javax.swing.JFrame {

    /**
     * Creates new form EditInstructorForm
     */
    public EditInstructorForm() {
    	getContentPane().setBackground(new Color(175, 162, 187));
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

        jLabel3 = new javax.swing.JLabel();
        instructorConfirmPassword = new javax.swing.JTextField();
        instructorFirstname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        instructorLastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        instructorUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        instructorEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
        instructorPassword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        instructorId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Firstname");

        jLabel8.setText("Confirm Password");

        jLabel4.setText("Lastname");

        jLabel5.setText("Username");

        jLabel6.setText("Email");

        jButton1.setText("Edit Instructor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Password");

        jLabel1.setText("Edit Instructor Form");

        jLabel9.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(31)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(1)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        										.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        									.addPreferredGap(ComponentPlacement.RELATED))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        									.addGap(26)))
        							.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jLabel8)
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addGroup(layout.createSequentialGroup()
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(instructorConfirmPassword, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
        							.addComponent(instructorPassword, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
        						.addGroup(Alignment.TRAILING, layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(instructorUsername, Alignment.TRAILING)
        							.addComponent(instructorId, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        							.addComponent(instructorLastname)
        							.addComponent(instructorFirstname, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        							.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(instructorEmail))))
        					.addGap(76))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(270, Short.MAX_VALUE))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(90)
        			.addComponent(jButton1)
        			.addContainerGap(145, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(98)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(24)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel9)
        				.addComponent(instructorId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(instructorFirstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(instructorLastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(instructorUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(8)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(instructorEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(instructorPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(instructorConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(35)
        			.addComponent(jButton1)
        			.addContainerGap(39, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            String instructorid = instructorId.getText();
            String firstname = instructorFirstname.getText();
            String latname = instructorLastname.getText();
            String username = instructorUsername.getText();
            String email = instructorEmail.getText();
            String password = instructorPassword.getText();
            String confirmPassword = instructorConfirmPassword.getText();

            java.sql.Connection conn = Connection.getConnection();
            String sql = "update instructor set firstname = ?, lastname = ?, username = ?, email = ?, password = ?, confirm_password = ? where id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, firstname);
            preparedStmt.setString(2, latname);
            preparedStmt.setString(3, username);
            preparedStmt.setString(4, email);
            preparedStmt.setString(5, password);
            preparedStmt.setString(6, confirmPassword);
            preparedStmt.setString(7, instructorid);

            boolean success = preparedStmt.execute();

            if (!success) {
                JOptionPane.showMessageDialog(this, "Instructor Successfully Edited!");
                dispose();
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("EXCEPTION:: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditInstructorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditInstructorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditInstructorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditInstructorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditInstructorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField instructorConfirmPassword;
    private javax.swing.JTextField instructorEmail;
    private javax.swing.JTextField instructorFirstname;
    private javax.swing.JTextField instructorId;
    private javax.swing.JTextField instructorLastname;
    private javax.swing.JTextField instructorPassword;
    private javax.swing.JTextField instructorUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}