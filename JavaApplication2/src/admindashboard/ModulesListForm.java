/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admindashboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import studentdashboard.StudentDashboard;
import utilities.Connection;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

/**
 *
 * @author Dell
 */
public class ModulesListForm extends javax.swing.JFrame {

    private String courseId;
    

    /**
     * Creates new form ModulesListForm
     */
    public ModulesListForm() {
    	getContentPane().setBackground(new Color(175, 167, 187));
        initComponents();
    }

    public ModulesListForm(String courseId) {
        this.courseId = courseId;
        initComponents();
        myInitComponentFirst();
        courseIdLabel.setText(courseId);

    }

    private void myInitComponentFirst() {
        setupTableValues();
        setupInstructorsTableValues();
    }

    private void setupTableValues() {

        try {
            java.sql.Connection conn = Connection.getConnection();

            String sql = "SELECT * from modules where course_id = ? ";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, this.courseId);

            ResultSet rs = preparedStmt.executeQuery();

            System.out.println(rs);
            while (rs.next()) {
                String moduleId = String.valueOf(rs.getString("id"));
                String moduleName = String.valueOf(rs.getString("name"));
                String moduleLevel = rs.getString("level");
                String moduleInstructor = rs.getString("instructor_id");

                String tbData[] = {moduleId, moduleName, moduleLevel, moduleInstructor};
                DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
                tbl.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setupInstructorsTableValues() {

        try {
            java.sql.Connection conn = Connection.getConnection();

            String sql = "SELECT * from instructor";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);

            ResultSet rs = preparedStmt.executeQuery();

            System.out.println(rs);
            while (rs.next()) {
                String instructorId = String.valueOf(rs.getString("id"));
                String instructorFirstName = String.valueOf(rs.getString("firstname"));
                String instructorLastName = rs.getString("lastname");

                String tbData[] = {instructorId, instructorFirstName, instructorLastName};
                DefaultTableModel tbl = (DefaultTableModel) jTable2.getModel();
                tbl.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
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

        addModuleButton = new javax.swing.JButton();
        editModuleButton = new javax.swing.JButton();
        deleteModuleButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        courseIdLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addModuleButton.setText("Add Module");
        addModuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addModuleButtonActionPerformed(evt);
            }
        });

        editModuleButton.setText("Edit Module");
        editModuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editModuleButtonActionPerformed(evt);
            }
        });

        deleteModuleButton.setText("Delete Module");
        deleteModuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteModuleButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module ID", "Name", "Duration", "Assigned Instructor ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("List of Instructors");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "InstructorId ID", "First Name", "Last Name"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("List Of Modules for Selected Course ID: ");

        courseIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        courseIdLabel.setText("");
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(83)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(addModuleButton)
        							.addGap(18)
        							.addComponent(editModuleButton)
        							.addGap(18)
        							.addComponent(deleteModuleButton)))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(85)
        					.addComponent(jLabel3)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(courseIdLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(courseIdLabel)
        					.addGap(23))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel3)
        					.addPreferredGap(ComponentPlacement.UNRELATED)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(editModuleButton)
        						.addComponent(deleteModuleButton)
        						.addComponent(addModuleButton))
        					.addGap(30)
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addGap(18)
        					.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        					.addGap(112)))
        			.addContainerGap(78, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addModuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addModuleButtonActionPerformed

        
        AddModuleForm addModuleForm = new AddModuleForm();
        addModuleForm.setLocationRelativeTo(null);
        addModuleForm.setVisible(true);
    }//GEN-LAST:event_addModuleButtonActionPerformed

    private void editModuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editModuleButtonActionPerformed

        
        EditModuleForm editModuleForm = new EditModuleForm();
        editModuleForm.setLocationRelativeTo(null);
        editModuleForm.setVisible(true);
    }//GEN-LAST:event_editModuleButtonActionPerformed

    private void deleteModuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteModuleButtonActionPerformed

        try {

            String id = JOptionPane.showInputDialog("Enter Module ID to Delete !");

            java.sql.Connection conn = Connection.getConnection();
            String sql = "DELETE FROM MODULES WHERE ID = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, id);

            boolean success = preparedStmt.execute();
            System.out.println(success);

            if (!success) {
                JOptionPane.showMessageDialog(this, "Module Successfully Deleted!");
                dispose();
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("EXCEPTION:: " + e.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_deleteModuleButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(ModulesListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModulesListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModulesListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModulesListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModulesListForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addModuleButton;
    private javax.swing.JLabel courseIdLabel;
    private javax.swing.JButton deleteModuleButton;
    private javax.swing.JButton editModuleButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}