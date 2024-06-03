/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package instructordashboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import studentdashboard.StudentDashboard;
import utilities.Connection;
import java.awt.Color;

/**
 *
 * @author Dell
 */
public class StudentInModuleListForm extends javax.swing.JFrame {

    private String courseId;
    private String moduleId;
    private String courseName;
    private String moduleName;
    private String level;

    /**
     * Creates new form StudentInModuleListForm
     */
    public StudentInModuleListForm() {
        initComponents();
    }

    public StudentInModuleListForm(String courseId, String moduleId, String courseName, String moduleName, String level) {
        this.courseId = courseId;
        this.moduleId = moduleId;
        this.courseName = courseName;
        this.moduleName = moduleName;
        this.level = level;
        initComponents();
        myInitComponentFirst();

    }

    private void myInitComponentFirst() {
        setupTableValues();
    }

//    private void setupTableValues() {
//        try {
//            java.sql.Connection conn = Connection.getConnection();
//
//            String sql = "SELECT\n"
//                    + "     student.firstname AS studentFirstName,\n"
//                    + "    student.lastname AS studentLastName,\n"
//                    + "    student.id AS studentId,\n"
//                    + "    marks.marks AS marks\n"
//                    + "FROM\n"
//                    + "    modules\n"
//                    + "INNER JOIN enrolled_course ON modules.id = enrolled_course.module_id\n"
//                    + "INNER JOIN student ON enrolled_course.student_id = student.id\n"
//                    + "INNER JOIN marks ON modules.id = marks.module_id\n"
//                    + "WHERE\n"
//                    + "    enrolled_course.module_id =" + this.moduleId;
//
//            PreparedStatement preparedStmt = conn.prepareStatement(sql);
//
//            ResultSet rs = preparedStmt.executeQuery();
//
//            System.out.println(rs);
//            while (rs.next()) {
////                String courseId = String.valueOf(rs.getString("courseId"));
////                String moduleId = String.valueOf(rs.getString("moduleId"));
//                String studentId = rs.getString("studentId");
//                String marks = rs.getString("marks");
//                String firstname = rs.getString("studentFirstName");
//                String lastname = rs.getString("studentLastName");
//
//                String tbData[] = {studentId, firstname, lastname, marks};
//                DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
//                tbl.addRow(tbData);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    private void setupTableValues() {
        try {
            java.sql.Connection conn = Connection.getConnection();

            // Updated SQL query to retrieve students for both mandatory and optional modules
            String sql = "SELECT "
                    + "student.id AS studentId, "
                    + "student.firstname AS studentFirstName, "
                    + "student.lastname AS studentLastName, "
                    + "marks.marks AS marks "
                    + "FROM enrolled_course "
                    + "INNER JOIN student ON enrolled_course.student_id = student.id "
                    + "LEFT JOIN marks ON enrolled_course.module_id = marks.module_id AND enrolled_course.student_id = marks.student_id "
                    + "WHERE enrolled_course.module_id = " + this.moduleId;

            PreparedStatement preparedStmt = conn.prepareStatement(sql);

            ResultSet rs = preparedStmt.executeQuery();

            DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
            tbl.setRowCount(0); // Clear existing rows

            while (rs.next()) {
                String studentId = rs.getString("studentId");
                String marks = rs.getString("marks");
                String firstname = rs.getString("studentFirstName");
                String lastname = rs.getString("studentLastName");

                Object[] rowData = {studentId, firstname, lastname, marks};
                tbl.addRow(rowData);
            }

            conn.close();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(175, 167, 187));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Module Name: ");

//        jLabel2.setText("jLabel2");
        jLabel2.setText(moduleName); // Set the module name dynamically
        setupTableValues();
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Student's Enrolled List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Marks"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int column = 0;
        int row = jTable1.getSelectedRow();
        String studentId = jTable1.getValueAt(row, 0).toString();
        String value = JOptionPane.showInputDialog(this, "Enter Marks for the student");

        try {
            java.sql.Connection conn = Connection.getConnection();

            String sql = "UPDATE marks set marks = ? where student_id = ? and module_id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, value);
            preparedStmt.setString(2, studentId);
            preparedStmt.setString(3, moduleId);
            boolean success = preparedStmt.execute();
            System.out.println(success);

            if (!success) {
                JOptionPane.showMessageDialog(this, "Successfully Entered !");
                dispose();
                setupTableValues();

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(StudentInModuleListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentInModuleListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentInModuleListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentInModuleListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentInModuleListForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
