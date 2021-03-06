/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvironmentSensorEnterprise.FloodManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author aishw
 */
public class FloodManagementSensorJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer; 
    private UserAccount account; 
    private EnvironmentSensorOrganization organization; 
    private Enterprise enterprise; 
    private EcoSystem business;
    /**
     * Creates new form FloodManagementSensorJPanel
     */
    public FloodManagementSensorJPanel(JPanel userProcessContainer, UserAccount account, EnvironmentSensorOrganization organization, Enterprise enterprise, EcoSystem business) {
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
        btnViewSentRequests = new javax.swing.JButton();
        btnSendRequests1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flood Management Sensor");
        add(jLabel1);
        jLabel1.setBounds(252, 31, 428, 52);

        btnViewSentRequests.setBackground(new java.awt.Color(0, 0, 0));
        btnViewSentRequests.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnViewSentRequests.setForeground(new java.awt.Color(0, 153, 153));
        btnViewSentRequests.setText("View Sent Requests");
        btnViewSentRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSentRequestsActionPerformed(evt);
            }
        });
        add(btnViewSentRequests);
        btnViewSentRequests.setBounds(470, 150, 210, 35);

        btnSendRequests1.setBackground(new java.awt.Color(0, 0, 0));
        btnSendRequests1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSendRequests1.setForeground(new java.awt.Color(0, 153, 153));
        btnSendRequests1.setText("Send Requests");
        btnSendRequests1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequests1ActionPerformed(evt);
            }
        });
        add(btnSendRequests1);
        btnSendRequests1.setBounds(223, 147, 210, 35);

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 153, 153));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(430, 270, 57, 35);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Flood.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 10, 1010, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendRequests1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequests1ActionPerformed
        // TODO add your handling code here:
        NotifyToFloodDepartmentJPnel floodsolution;
    try {
        floodsolution = new NotifyToFloodDepartmentJPnel(userProcessContainer, account, business, enterprise.getOrganizationDirectory());
        userProcessContainer.add("floodsolutiondepartment", floodsolution);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    } catch (IOException ex) {
        Logger.getLogger(FloodManagementSensorJPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnSendRequests1ActionPerformed

    private void btnViewSentRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSentRequestsActionPerformed
        // TODO add your handling code here:
        ViewFloodAreaWorkQueue viewfloodAreaWorkQueue = new ViewFloodAreaWorkQueue(userProcessContainer, account, enterprise.getOrganizationDirectory(), business);
        userProcessContainer.add("viewfloodAreaWorkQueue", viewfloodAreaWorkQueue);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewSentRequestsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendRequests1;
    private javax.swing.JButton btnViewSentRequests;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
