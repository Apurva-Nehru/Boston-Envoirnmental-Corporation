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
 * @author apurv
 */
public class EnvManagementAdminWorkAreaJPanel extends javax.swing.JPanel {
 JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    /**
     * Creates new form EnvManagementAdminWorkAreaJPanel
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
        jLabel2 = new javax.swing.JLabel();
        btn_manageorg = new javax.swing.JButton();
        btn_ManageUser = new javax.swing.JButton();
        btn_manageemployee = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Environment Admin Work Area");

        jLabel2.setText("Enterprise");

        btn_manageorg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_manageorg.setText("Manage Organization");
        btn_manageorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageorgActionPerformed(evt);
            }
        });

        btn_ManageUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_ManageUser.setText("Manage User");
        btn_ManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageUserActionPerformed(evt);
            }
        });

        btn_manageemployee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_manageemployee.setText("Manage Employee");
        btn_manageemployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageemployeeActionPerformed(evt);
            }
        });

        valueLabel.setText("<value>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ManageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_manageorg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_manageemployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel))
                .addGap(18, 18, 18)
                .addComponent(btn_manageorg)
                .addGap(18, 18, 18)
                .addComponent(btn_manageemployee)
                .addGap(18, 18, 18)
                .addComponent(btn_ManageUser)
                .addContainerGap(222, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_manageorgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageorgActionPerformed
        // TODO add your handling code here:
        EnvironmentManagementOrganizationJPanel environmentManagementOrganizationJPanel = new EnvironmentManagementOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("environmentManagementOrganizationJPanel", environmentManagementOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_manageorgActionPerformed

    private void btn_ManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ManageUserActionPerformed
        // TODO add your handling code here:
        EnvManagementEmployeeJPanel environmentManagementEmployeeJPanel = new EnvManagementEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("environmentManagementEmployeeJPanel", environmentManagementEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_ManageUserActionPerformed

    private void btn_manageemployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageemployeeActionPerformed
        // TODO add your handling code here:
         EnvironmentManagementUserJPanel environmentManagementUserJPanel = new EnvironmentManagementUserJPanel(userProcessContainer, enterprise,business);
        userProcessContainer.add("environmentManagementUserJPanel", environmentManagementUserJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_manageemployeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ManageUser;
    private javax.swing.JButton btn_manageemployee;
    private javax.swing.JButton btn_manageorg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
