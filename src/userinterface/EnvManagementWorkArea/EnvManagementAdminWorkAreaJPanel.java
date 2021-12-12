/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvManagementWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author aishw
 */
public class EnvManagementAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    
    /**
     * Creates new form EnvironmentManagementAdminWorkAreaJPanel
     */
    public EnvManagementAdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        valueLabel.setText(enterprise.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        manageOrganizationJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        userJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Environment Management Admin Work Area");
        add(jLabel1);
        jLabel1.setBounds(110, 100, 530, 29);

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel);
        enterpriseLabel.setBounds(150, 160, 120, 30);

        valueLabel.setBackground(new java.awt.Color(255, 255, 255));
        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(0, 0, 51));
        valueLabel.setText("<value>");
        add(valueLabel);
        valueLabel.setBounds(330, 160, 406, 22);

        manageOrganizationJButton.setBackground(new java.awt.Color(0, 0, 204));
        manageOrganizationJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageOrganizationJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });
        add(manageOrganizationJButton);
        manageOrganizationJButton.setBounds(250, 230, 220, 25);

        manageEmployeeJButton.setBackground(new java.awt.Color(0, 0, 204));
        manageEmployeeJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageEmployeeJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });
        add(manageEmployeeJButton);
        manageEmployeeJButton.setBounds(260, 340, 220, 25);

        userJButton.setBackground(new java.awt.Color(0, 0, 204));
        userJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userJButton.setForeground(new java.awt.Color(255, 255, 255));
        userJButton.setText("Manage User");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });
        add(userJButton);
        userJButton.setBounds(260, 460, 220, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin_work_area.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 790, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        EnvManagementOrganizationJPanel environmentManagementOrganizationJPanel = new EnvManagementOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("environmentManagementOrganizationJPanel", environmentManagementOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        EnvManagementEmployeeJPanel environmentManagementEmployeeJPanel = new EnvManagementEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("environmentManagementEmployeeJPanel", environmentManagementEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        EnvManagementUserJPanel environmentManagementUserJPanel = new EnvManagementUserJPanel(userProcessContainer, enterprise,business);
        userProcessContainer.add("environmentManagementUserJPanel", environmentManagementUserJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
