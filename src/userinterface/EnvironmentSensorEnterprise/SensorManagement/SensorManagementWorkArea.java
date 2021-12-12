/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvironmentSensorEnterprise.SensorManagement;

import userinterface.EnvironmentSensorEnterprise.AirPollution.NotifytoAirPolltuionSolutionDepartment;
import userinterface.EnvironmentSensorEnterprise.AirPollution.ViewAirPollutionWorkQueue;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.UserAccount.UserAccount;
import userinterface.EnvironmentSensorEnterprise.AirPollution.AirPollutionSensorJPanel;
import userinterface.EnvironmentSensorEnterprise.FloodManagement.FloodManagementSensorJPanel;
import userinterface.EnvironmentSensorEnterprise.WasteManagement.WasteManagementSensor;
import userinterface.EnvironmentSensorEnterprise.NoisePollutionManagement.NoisePollutionManagementSensorJPanel;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
/**
 *
 * @author aishw
 */
public class SensorManagementWorkArea extends javax.swing.JPanel {
    
    private JPanel userProcessContainer; 
    private UserAccount account; 
    private EnvironmentSensorOrganization organization; 
    private Enterprise enterprise; 
    private EcoSystem business;
    /**
     * Creates new form SensorManagementWorkArea
     */
    public SensorManagementWorkArea(JPanel userProcessContainer, UserAccount account, EnvironmentSensorOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
        lblEnterprisevalue.setText(enterprise.getName());
        lblOrganizationvalue.setText(account.getEmp().getName());
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
        lblEnterprise = new javax.swing.JLabel();
        lblOrganizationvalue = new javax.swing.JLabel();
        lblEnterprise2 = new javax.swing.JLabel();
        lblEnterprisevalue = new javax.swing.JLabel();
        btnWasteManagement = new javax.swing.JButton();
        btnAirPollutionManagement1 = new javax.swing.JButton();
        btnNoiePollutionManagement = new javax.swing.JButton();
        btnFloodManagement = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sensor Management Work Area");

        lblEnterprise.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEnterprise.setText("Enterprise");

        lblOrganizationvalue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblOrganizationvalue.setText("<value>");

        lblEnterprise2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEnterprise2.setText("Organization");

        lblEnterprisevalue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEnterprisevalue.setText("<value>");

        btnWasteManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnWasteManagement.setText("Waste Management");
        btnWasteManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWasteManagementActionPerformed(evt);
            }
        });

        btnAirPollutionManagement1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAirPollutionManagement1.setText("Air Pollution Management");
        btnAirPollutionManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAirPollutionManagement1ActionPerformed(evt);
            }
        });

        btnNoiePollutionManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNoiePollutionManagement.setText("Noise Pollution Management");
        btnNoiePollutionManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoiePollutionManagementActionPerformed(evt);
            }
        });

        btnFloodManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFloodManagement.setText("Flood Management");
        btnFloodManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloodManagementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(lblEnterprisevalue, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(lblEnterprise2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOrganizationvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(203, 203, 203))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFloodManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoiePollutionManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWasteManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(194, 194, 194))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(348, Short.MAX_VALUE)
                    .addComponent(btnAirPollutionManagement1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(193, 193, 193)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnterprisevalue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganizationvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnterprise2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnNoiePollutionManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFloodManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnWasteManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(btnAirPollutionManagement1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAirPollutionManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAirPollutionManagement1ActionPerformed
        // TODO add your handling code here:
        AirPollutionSensorJPanel airPollutionSensorManagement = new AirPollutionSensorJPanel(userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("airPollutionSensorJPanel", airPollutionSensorManagement);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAirPollutionManagement1ActionPerformed

    private void btnNoiePollutionManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoiePollutionManagementActionPerformed
        // TODO add your handling code here:
        NoisePollutionManagementSensorJPanel noisePollutionSensorManagement = new NoisePollutionManagementSensorJPanel(userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("noisePollutionSensorManagement", noisePollutionSensorManagement);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnNoiePollutionManagementActionPerformed

    private void btnFloodManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloodManagementActionPerformed
        // TODO add your handling code here:
        FloodManagementSensorJPanel floodsensor = new FloodManagementSensorJPanel(userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("floodsensor", floodsensor);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnFloodManagementActionPerformed

    private void btnWasteManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWasteManagementActionPerformed
        // TODO add your handling code here:
        WasteManagementSensor wasteSensorManagement = new WasteManagementSensor(userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("garbageSensorManagementJPanel", wasteSensorManagement);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnWasteManagementActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAirPollutionManagement1;
    private javax.swing.JButton btnFloodManagement;
    private javax.swing.JButton btnNoiePollutionManagement;
    private javax.swing.JButton btnWasteManagement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblEnterprise2;
    private javax.swing.JLabel lblEnterprisevalue;
    private javax.swing.JLabel lblOrganizationvalue;
    // End of variables declaration//GEN-END:variables
}