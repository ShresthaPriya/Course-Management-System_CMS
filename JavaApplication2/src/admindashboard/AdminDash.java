/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admindashboard;

import loginsignup.LoginForm;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Dell
 */
public class AdminDash extends javax.swing.JFrame {
	

    /**
     * Creates new form AdminDash
     */
    public AdminDash() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void setButtonHoverEffect(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 255, 128)); // Change the background color when mouse enters
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 255, 255)); // Change the background color when mouse exits
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetButtonColors();
            }
        });
    }

    private void resetButtonColors() {
        viewCoursesButton.setBackground(new Color(255, 255, 128));
        logoutButton.setBackground(new Color(255, 255, 128));
        dashboardButton1.setBackground(new Color(255, 255, 128));
        viewCoursesButton1.setBackground(new Color(255, 255, 128));
        viewInstructorsButton.setBackground(new Color(255, 255, 128));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dashboardHeader1 = new javax.swing.JLabel();
        dashboardSubheader1 = new javax.swing.JLabel();
        dashboardSubheader1.setFont(new Font("Tahoma", Font.BOLD, 11));
        viewCoursesButton = new javax.swing.JButton();
        viewCoursesButton.setBackground(new Color(255, 255, 255));
        viewCoursesButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\course.png"));
        logoutButton = new javax.swing.JButton();
        logoutButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\logout12.png"));
        dashboardButton1 = new javax.swing.JButton();
        dashboardButton1.setBackground(new Color(255, 255, 128));
        dashboardButton1.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\icons8-dashboard-48.png"));
        viewCoursesButton1 = new javax.swing.JButton();
        viewCoursesButton1.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\Another.png"));
        viewInstructorsButton = new javax.swing.JButton();
        viewInstructorsButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\CMS-main\\teacher_icon.png"));
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        
        setButtonHoverEffect(viewCoursesButton);
        setButtonHoverEffect(logoutButton);
        setButtonHoverEffect(dashboardButton1);
        setButtonHoverEffect(viewCoursesButton1);
        setButtonHoverEffect(viewInstructorsButton);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(966, 730));
        setResizable(false);

        jPanel1.setBackground(new Color(175, 162, 187));

        dashboardHeader1.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        dashboardHeader1.setText("COURSE MANAGEMENT SYSTEM");

        dashboardSubheader1.setText("Course Administrator");
        dashboardSubheader1.setToolTipText("");

        viewCoursesButton.setText("VIEW COURSES");
        viewCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCoursesButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        dashboardButton1.setText("DASHBOARD");

        viewCoursesButton1.setText("VIEW STUDENTS");
        viewCoursesButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCoursesButton1ActionPerformed(evt);
            }
        });

        viewInstructorsButton.setText("VIEW TUTORS");
        viewInstructorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewInstructorsButtonActionPerformed(evt);
            }
        });
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\admin-settings-male-48.png"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(14, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(dashboardHeader1)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(dashboardSubheader1)
        					.addGap(24)))
        			.addGap(15))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(31)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(logoutButton, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(viewInstructorsButton, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        					.addComponent(viewCoursesButton1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        					.addComponent(viewCoursesButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        					.addComponent(dashboardButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(dashboardHeader1)
        			.addGap(15)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_2)
        				.addComponent(dashboardSubheader1))
        			.addGap(135)
        			.addComponent(dashboardButton1)
        			.addGap(26)
        			.addComponent(viewCoursesButton)
        			.addGap(28)
        			.addComponent(viewCoursesButton1)
        			.addGap(27)
        			.addComponent(viewInstructorsButton)
        			.addGap(32)
        			.addComponent(logoutButton)
        			.addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Welcome Admin !!!");
        
        JLabel lblNewLabel = new JLabel("Herald College Kathmandu");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        JLabel lblNewLabel_1 = new JLabel("Naxal, Kathmandu");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(249)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(236)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(252, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap(285, Short.MAX_VALUE)
        			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        			.addGap(270))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_1)
        			.addGap(92)
        			.addComponent(jLabel1)
        			.addContainerGap(481, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCoursesButtonActionPerformed

        CoursesForm coursesForm = new CoursesForm();
        coursesForm.setLocationRelativeTo(null);
        coursesForm.setVisible(true);
    }//GEN-LAST:event_viewCoursesButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        LoginForm loginForm = new LoginForm();
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void viewCoursesButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCoursesButton1ActionPerformed
        StudentsListForm studentsListForm = new StudentsListForm();
        studentsListForm.setLocationRelativeTo(null);
        studentsListForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_viewCoursesButton1ActionPerformed

    private void viewInstructorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewInstructorsButtonActionPerformed
        InstructorsListForm instructorsListForm = new InstructorsListForm();
        instructorsListForm.setLocationRelativeTo(null);
        instructorsListForm.setVisible(true);
    }//GEN-LAST:event_viewInstructorsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashboardButton1;
    private javax.swing.JLabel dashboardHeader1;
    private javax.swing.JLabel dashboardSubheader1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton viewCoursesButton;
    private javax.swing.JButton viewCoursesButton1;
    private javax.swing.JButton viewInstructorsButton;
    private JLabel lblNewLabel_2;
}