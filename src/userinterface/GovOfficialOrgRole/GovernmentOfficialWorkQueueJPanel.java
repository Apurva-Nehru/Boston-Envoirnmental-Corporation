/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovOfficialOrgRole;

import java.util.Properties;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.Oragnization.Organization;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.Oragnization.GovOrg;
import Business.Oragnization.OrganizationDirectory;
import Business.Oragnization.ResidentOrganization;
import Business.Sensor.AirPollutionSensor;
import Business.Sensor.Sensor;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.ResidentWorkRequest;
import Business.WorkQueue.GovWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class GovernmentOfficialWorkQueueJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    /**
     * Creates new form GovernmentOfficialWorkQueueJPanel
     */
    public GovernmentOfficialWorkQueueJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        this.enterprise = enterprise;
        
        populateTable();
    }

    public void populateTable(){
        GovWorkRequest gov_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tbl_Gov_wrd_queue.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof GovWorkRequest)
            {                
                gov_wrs = (GovWorkRequest)wr;
            
                if(gov_wrs.getAirPollutionSensor() != null)
                {
                Object[] row = new Object[3];
                row[0] = gov_wrs;
                row[1] = gov_wrs.getSender();
                row[2] = gov_wrs.getAirPollutionMessage();
                model.addRow(row);
                }
            }
        }
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

        jLabel1 = new javax.swing.JLabel();
        backjButton1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        MessagejLabel = new javax.swing.JLabel();
        CitizenNotificationjButton = new javax.swing.JButton();
        CitizenNotificationjButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Gov_wrd_queue = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Government Official Work Queue");

        backjButton1.setBackground(new java.awt.Color(0, 0, 204));
        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Complete Message");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        MessagejLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        MessagejLabel.setForeground(new java.awt.Color(255, 0, 51));

        CitizenNotificationjButton.setBackground(new java.awt.Color(255, 0, 51));
        CitizenNotificationjButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CitizenNotificationjButton.setForeground(new java.awt.Color(255, 255, 255));
        CitizenNotificationjButton.setText("Send Alert Notificatication to Citizens");
        CitizenNotificationjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CitizenNotificationjButtonActionPerformed(evt);
            }
        });

        CitizenNotificationjButton1.setBackground(new java.awt.Color(0, 204, 0));
        CitizenNotificationjButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CitizenNotificationjButton1.setForeground(new java.awt.Color(255, 255, 255));
        CitizenNotificationjButton1.setText("Send Resolve Notificatication to Citizens");
        CitizenNotificationjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CitizenNotificationjButton1ActionPerformed(evt);
            }
        });

        tbl_Gov_wrd_queue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Work_request_Id", "Sender", "Mesage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Gov_wrd_queue);

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View complete Message");

        jButton4.setText("Send Resolved Notification");

        jButton5.setText("Send Alert Notification to citizen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 145, Short.MAX_VALUE)
                .addComponent(CitizenNotificationjButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CitizenNotificationjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(344, 344, 344))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(336, 336, 336))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(663, 663, 663)
                        .addComponent(MessagejLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton2)
                        .addGap(64, 64, 64)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(86, 86, 86)
                .addComponent(MessagejLabel)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CitizenNotificationjButton)
                    .addComponent(CitizenNotificationjButton1))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int row = tbl_Gov_wrd_queue.getSelectedRow();
        try
        {
         GovWorkRequest request = (GovWorkRequest)tbl_Gov_wrd_queue.getValueAt(row, 0);
         MessagejLabel.setText(request.getAirPollutionMessage());
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CitizenNotificationjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CitizenNotificationjButtonActionPerformed
        // TODO add your handling code here:
        int row = tbl_Gov_wrd_queue.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        
        GovWorkRequest request = (GovWorkRequest)tbl_Gov_wrd_queue.getValueAt(row, 0);
        
        ResidentWorkRequest citizenWorkRequest = new ResidentWorkRequest();
        
        citizenWorkRequest.setAirPollutionSensor(request.getAirPollutionSensor());
        citizenWorkRequest.setAirPollutionMessage("The Area bearing pincode "+request.getAirPollutionSensor().getZipcode()+" has bad air quality please avoid this area until further notice");
        citizenWorkRequest.setSender(userAccount);
        citizenWorkRequest.setStatus("Message Sent to Citizens");
        
        Organization orgn = null;
        Organization orgn1 = null;
                for(Organization org : directory.getOrganizationList())
                {
            //System.out.println(org.getName());
            if (org instanceof GovOrg){
                orgn = org;
                break;
            }
           
            } 
                for(Organization org1 : directory.getOrganizationList())
                {
                if(org1 instanceof ResidentOrganization){
                orgn1 = org1;
                break;
            
            } }
        if (orgn!=null){
            orgn.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQ().getWorkRequestList().add(citizenWorkRequest);
        }
        
        if (orgn1!=null){            
            orgn1.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQ().getWorkRequestList().add(citizenWorkRequest);
        }
         JOptionPane.showMessageDialog(null, "Request Sent to Citizen");
        }
    }//GEN-LAST:event_CitizenNotificationjButtonActionPerformed

    private void CitizenNotificationjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CitizenNotificationjButton1ActionPerformed
        // TODO add your handling code here:
        int row = tbl_Gov_wrd_queue.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        
        GovWorkRequest request = (GovWorkRequest)tbl_Gov_wrd_queue.getValueAt(row, 0);
        
        ResidentWorkRequest citizenWorkRequest = new ResidentWorkRequest();
        
        citizenWorkRequest.setAirPollutionSensor(request.getAirPollutionSensor());
        citizenWorkRequest.setAirPollutionMessage("The Area bearing pincode "+request.getAirPollutionSensor().getZipcode()+"'s air quality has now improved.");
        citizenWorkRequest.setSender(userAccount);
        citizenWorkRequest.setStatus("Message Sent to Citizens");
        
        Organization orgn = null;
        Organization orgn1 = null;
                for(Organization org : directory.getOrganizationList())
                {
            //System.out.println(org.getName());
            if (org instanceof GovOrg){
                orgn = org;
                break;
            }
           
            } 
                for(Organization org1 : directory.getOrganizationList())
                {
                if(org1 instanceof ResidentOrganization){
                orgn1 = org1;
                break;
            
            } }
        if (orgn!=null){
            orgn.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQ().getWorkRequestList().add(citizenWorkRequest);
        }
        
        if (orgn1!=null){            
            orgn1.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQ().getWorkRequestList().add(citizenWorkRequest);
        }
         JOptionPane.showMessageDialog(null, "Request Sent to Citizen");
        }
    }//GEN-LAST:event_CitizenNotificationjButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CitizenNotificationjButton;
    private javax.swing.JButton CitizenNotificationjButton1;
    private javax.swing.JLabel MessagejLabel;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_Gov_wrd_queue;
    // End of variables declaration//GEN-END:variables
}