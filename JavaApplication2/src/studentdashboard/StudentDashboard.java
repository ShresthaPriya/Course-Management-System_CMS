/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentdashboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loginsignup.LoginForm;
import model.Student;
import utilities.Connection;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

/**
 *
 * @author Dell
 */
public class StudentDashboard extends javax.swing.JFrame {

    private String username;
    private String userType;
    private String sql = "";
    private Student student;

    /**
     * Creates new form StudentDashboard
     */
    public StudentDashboard(String username, String userType) {
        this.username = username;
        this.userType = userType;
        initComponents();
        myInitComponentFirst();
        studentFullnameValue.setText(student.getFirstName().toUpperCase() + " " + student.getLastName().toUpperCase());
        studentEmailValue.setText(student.getEmail());
        studentUsernameValue.setText(username);
    }

    public StudentDashboard() {
        initComponents();
    }

    private void myInitComponentFirst() {

        student = getAllStudentValues();
        setupTableValues();
        getAllCourseValues();

    }

    private void setupTableValues() {

        try {
            java.sql.Connection conn = Connection.getConnection();

            String sql = "SELECT \n"
                    + "course.name as courseName, \n"
                    + "modules.name as moduleName, \n"
                    + "modules.level as level\n"
                    + "FROM enrolled_course \n"
                    + "INNER JOIN COURSE on course.id = enrolled_course.course_id \n"
                    + "INNER JOIN modules ON enrolled_course.module_id = modules.id\n"
                    + "INNER JOIN student on enrolled_course.student_id = student.id\n"
                    + "WHERE student.id = " + this.student.getId();

            PreparedStatement preparedStmt = conn.prepareStatement(sql);

            ResultSet rs = preparedStmt.executeQuery();

            System.out.println(rs);
            while (rs.next()) {
//                String courseId = String.valueOf(rs.getString("courseId"));
//                String moduleId = String.valueOf(rs.getString("moduleId"));
                String courseName = rs.getString("courseName");
                String moduleName = rs.getString("moduleName");
                String moduleLevel = String.valueOf(rs.getString("level"));

                String tbData[] = {courseName, moduleName, moduleLevel};
                DefaultTableModel tbl = (DefaultTableModel) jTable2.getModel();
                tbl.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Student getAllStudentValues() {
        Student std = new Student();
        try {
            java.sql.Connection conn = Connection.getConnection();

            if (userType.toLowerCase().equals("student")) {
                sql = "SELECT * FROM STUDENT WHERE USERNAME =? AND USER_TYPE =?";
            } else if (userType.toLowerCase().equals("course administrator")) {
                sql = "SELECT * FROM COURSE_ADMINISTRATOR WHERE USERNAME =? AND USER_TYPE =?";
            } else {
                sql = "SELECT * FROM INSTRUCTOR WHERE USERNAME =? AND USER_TYPE =?";
            }

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, userType.toLowerCase());

            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next()) {
                std.setFirstName(rs.getString("firstname"));
                std.setLastName(rs.getString("lastname"));
                std.setEmail(rs.getString("email"));
                std.setId(rs.getInt("id"));
                std.setCourse(rs.getString("course"));
                return std;
            } else {
                JOptionPane.showMessageDialog(this, "Details not found !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return std;
    }

    public void getAllCourseValues() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainDashboardPanel = new javax.swing.JPanel();
        dashboardHeader = new javax.swing.JLabel();
        dashboardButton = new javax.swing.JButton();
        dashboardButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\icons8-dashboard-48.png"));
        logoutButton = new javax.swing.JButton();
        logoutButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\logout12.png"));
        stdEnrollCourseButton = new javax.swing.JButton();
        stdEnrollCourseButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\icons8-enrollment11-64.png"));
        dashboardSubheader = new javax.swing.JLabel();
        dashboardSubheader.setFont(new Font("Tahoma", Font.BOLD, 14));
        jPanel1 = new javax.swing.JPanel();
        studentFullnameLabel = new javax.swing.JLabel();
        studentFullnameValue = new javax.swing.JLabel();
        studentUsernameValue = new javax.swing.JLabel();
        studentUsernameLabel = new javax.swing.JLabel();
        studentEmailValue = new javax.swing.JLabel();
        studentEmailLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        mainDashboardPanel.setBackground(new java.awt.Color(175, 167, 187));

        dashboardHeader.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        dashboardHeader.setText("COURSE MANAGEMENT SYSTEM");

        dashboardButton.setText("DASHBOARD");

        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        stdEnrollCourseButton.setText("ENROLL ");
        stdEnrollCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdEnrollCourseButtonActionPerformed(evt);
            }
        });

        dashboardSubheader.setText("Student");
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\online-education-7545.png"));

        javax.swing.GroupLayout mainDashboardPanelLayout = new javax.swing.GroupLayout(mainDashboardPanel);
        mainDashboardPanelLayout.setHorizontalGroup(
        	mainDashboardPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(mainDashboardPanelLayout.createSequentialGroup()
        			.addGap(19)
        			.addComponent(dashboardHeader)
        			.addContainerGap(28, Short.MAX_VALUE))
        		.addGroup(mainDashboardPanelLayout.createSequentialGroup()
        			.addContainerGap(50, Short.MAX_VALUE)
        			.addGroup(mainDashboardPanelLayout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(dashboardButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(stdEnrollCourseButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 152, Short.MAX_VALUE)
        				.addComponent(logoutButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(52))
        		.addGroup(mainDashboardPanelLayout.createSequentialGroup()
        			.addGap(53)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(dashboardSubheader, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(81, Short.MAX_VALUE))
        );
        mainDashboardPanelLayout.setVerticalGroup(
        	mainDashboardPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(mainDashboardPanelLayout.createSequentialGroup()
        			.addGap(54)
        			.addComponent(dashboardHeader)
        			.addGap(20)
        			.addGroup(mainDashboardPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel)
        				.addComponent(dashboardSubheader))
        			.addGap(136)
        			.addComponent(dashboardButton)
        			.addGap(42)
        			.addComponent(stdEnrollCourseButton)
        			.addGap(40)
        			.addComponent(logoutButton)
        			.addContainerGap(283, Short.MAX_VALUE))
        );
        mainDashboardPanel.setLayout(mainDashboardPanelLayout);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        studentFullnameLabel.setForeground(new java.awt.Color(0, 0, 0));
        studentFullnameLabel.setText("Student FullName: ");

        studentFullnameValue.setForeground(new java.awt.Color(0, 0, 0));

        studentUsernameValue.setForeground(new java.awt.Color(0, 0, 0));

        studentUsernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        studentUsernameLabel.setText("Student Username: ");

        studentEmailValue.setForeground(new java.awt.Color(0, 0, 0));

        studentEmailLabel.setForeground(new java.awt.Color(0, 0, 0));
        studentEmailLabel.setText("Student Email: ");
        studentEmailLabel.setToolTipText("");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Name", "Module Name", "Level"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Enrolled Courses");
        
        lblNewLabel_1 = new JLabel("Herald College Kathmandu");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\icons8-enrollment-64.png"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(49)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(studentFullnameLabel)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(studentFullnameValue, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(studentEmailLabel)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(studentEmailValue, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
        							.addGap(18)
        							.addComponent(studentUsernameLabel)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(studentUsernameValue, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(270)
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(36)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(studentFullnameLabel)
        				.addComponent(studentFullnameValue, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        				.addComponent(studentUsernameValue, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        				.addComponent(studentUsernameLabel))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(studentEmailLabel)
        				.addComponent(studentEmailValue, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
        			.addGap(44)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_2)
        				.addComponent(jLabel1))
        			.addGap(18)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainDashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainDashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stdEnrollCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdEnrollCourseButtonActionPerformed
        String level = JOptionPane.showInputDialog("What year/level course you want to lookup [4/5/6] ?");
        if (level == null) {
            return;
        }
        EnrollInModuleForm enrollForm = new EnrollInModuleForm(level, student.getId(), this.username, this.userType, student.getCourse());
        dispose();
        enrollForm.setLocationRelativeTo(null);
        enrollForm.setVisible(true);
    }//GEN-LAST:event_stdEnrollCourseButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        LoginForm loginForm = new LoginForm();
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JLabel dashboardHeader;
    private javax.swing.JLabel dashboardSubheader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel mainDashboardPanel;
    private javax.swing.JButton stdEnrollCourseButton;
    private javax.swing.JLabel studentEmailLabel;
    private javax.swing.JLabel studentEmailValue;
    private javax.swing.JLabel studentFullnameLabel;
    private javax.swing.JLabel studentFullnameValue;
    private javax.swing.JLabel studentUsernameLabel;
    private javax.swing.JLabel studentUsernameValue;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    // End of variables declaration//GEN-END:variables

}