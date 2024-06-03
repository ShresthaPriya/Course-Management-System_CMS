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
import javax.swing.table.DefaultTableModel;
import studentdashboard.StudentDashboard;
import utilities.Connection;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Dell
 */
public class StudentReportForm extends javax.swing.JFrame {

    private String studentId;
    

    /**
     * Creates new form StudentReportForm
     */
    public StudentReportForm() {
    	getContentPane().setBackground(new Color(175, 167, 187));
        initComponents();
    }

    public StudentReportForm(String studentId) {
        this.studentId = studentId;
        initComponents();
        myInitComponentFirst();
        setupCourseValues();
        setupTableValues();
        calculateGrades(); 
    }

    private void myInitComponentFirst() {
        setupCourseValues();
        setupTableValues();
     // Check if the "Grade" column already exists before adding
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
        boolean hasGradeColumn = false;
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            if (tbl.getColumnName(i).equals("Grade")) {
                hasGradeColumn = true;
                break;
            }
        }

        // Add the "Grade" column only if it doesn't exist
        if (!hasGradeColumn) {
            tbl.addColumn("Grade");
        }


    }

    private void calculateGrades() {
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < tbl.getRowCount(); i++) {
            Object marksObj = tbl.getValueAt(i, 2);

            // Check if the value is not null and is a valid integer
            if (marksObj != null && marksObj.toString().matches("\\d+")) {
                String marksStr = marksObj.toString();
                int marks = Integer.parseInt(marksStr);

                // Calculate grade based on marks
                String grade;
                if (marks >= 70) {
                    grade = "A-Pass";
                } else if (marks >= 60) {
                    grade = "B-Pass";
                } else if (marks >= 40) {
                    grade = "C-Pass";
                } else {
                    grade = "Fail";
                }

                // Update the grade column in the table
                tbl.setValueAt(grade, i, 3);

                updateGradeInDatabase(studentId, marks, grade);
            }
        }
    }

    private void updateGradeInDatabase(String studentId, int marks, String grade) {
        try {
            java.sql.Connection conn = Connection.getConnection();

            // Assuming 'marks' table has columns: student_id, marks, grade
            String updateSql = "UPDATE marks SET grade = ? WHERE student_id = ? AND marks = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, grade);
            updateStmt.setString(2, studentId);
            updateStmt.setInt(3, marks);

            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Grade updated in the database.");
            } else {
                System.out.println("Failed to update grade in the database.");
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setupCourseValues() {

        try {
            java.sql.Connection conn = Connection.getConnection();

            String sql = "SELECT\n"
                    + "    course.name as courseName\n"
                    + "FROM\n"
                    + "    enrolled_course\n"
                    + "INNER JOIN course ON course.id = enrolled_course.course_id\n"
                    + "inner join student on enrolled_course.student_id = student.id\n"
                    + "where student.id = " + this.studentId;

            PreparedStatement preparedStmt = conn.prepareStatement(sql);

            ResultSet rs = preparedStmt.executeQuery();

            System.out.println(rs);
            if (rs.next()) {
                String courseName = String.valueOf(rs.getString(1));
                this.courseValueLable.setText(courseName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void setupTableValues() {
        try {
            java.sql.Connection conn = Connection.getConnection();

            String sql = "SELECT modules.name, modules.level, COALESCE(marks.marks, 'N/A') AS marks, COALESCE(marks.grade, 'N/A') AS grade " +
                         "FROM enrolled_course " +
                         "INNER JOIN modules ON enrolled_course.module_id = modules.id " +
                         "LEFT JOIN marks ON marks.module_id = modules.id AND marks.student_id = enrolled_course.student_id " +
                         "WHERE enrolled_course.student_id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, studentId);

            ResultSet rs = preparedStmt.executeQuery();

            // Clear existing rows from the table
            DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
            tbl.setRowCount(0);

            while (rs.next()) {
                String moduleName = String.valueOf(rs.getString("name"));
                String moduleLevel = String.valueOf(rs.getString("level"));
                String marks = rs.getString("marks");
                String grade = rs.getString("grade");

                String tbData[] = {moduleName, moduleLevel, marks, grade};
                tbl.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\icons8-certificate-32.png"));
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
        jLabel2 = new javax.swing.JLabel();
        courseValueLable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Student Report");

        jLabel2.setText("Course: ");

        courseValueLable.setText("Course");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module ID", "Level", "Marks", "Grade"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(48)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
        					.addGap(50)
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        					.addGap(35)
        					.addComponent(courseValueLable, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(37)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(jLabel2)
        				.addComponent(courseValueLable))
        			.addGap(32)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(81, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(StudentReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentReportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseValueLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
