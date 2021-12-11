/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvManagementRoles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.FloodManagementOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author apurv
 */
public class FloodAlertManagementWorkAreaJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final UserAccount account;
    private final Enterprise enterprise;
    private final EcoSystem business;
    private final FloodManagementOrganization organization;

    /**
     * Creates new form FloodAlertManagementWorkAreaJPanel
     */
    public FloodAlertManagementWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, FloodManagementOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
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
        btn_View_Work_Queue = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Flood Alert Management Work Area");

        btn_View_Work_Queue.setText("View Work Queue");
        btn_View_Work_Queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_View_Work_QueueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(btn_View_Work_Queue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btn_View_Work_Queue)
                .addContainerGap(362, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_View_Work_QueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_View_Work_QueueActionPerformed
        // TODO add your handling code here:
FloodPollutionManagementWorkQueueJPanel floodmanagementWorkQueue = new FloodPollutionManagementWorkQueueJPanel(userProcessContainer, account, enterprise.getOrganizationDirectory());        userProcessContainer.add("floodManagementWorkQueue", floodmanagementWorkQueue);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_View_Work_QueueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_View_Work_Queue;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
