/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GovOfficialOrgRole;

import Business.Enterprise.Enterprise;
import Business.Oragnization.ResidentOrganization;
import Business.Oragnization.GovOrg;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Sensor.FloodManagementSensor;
import Business.Sensor.FloodManagementSensor;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.ResidentWorkRequest;

import Business.WorkQueue.GovWorkRequest;
import Business.WorkQueue.GovWorkRequest;

import Business.WorkQueue.ResidentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class GovernmentOfficialWorkQueue2JPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    /**
     * Creates new form GovernmentOfficialWorkQueueJPanel
     */
    public GovernmentOfficialWorkQueue2JPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        this.enterprise = enterprise;
        
        populateTable();
    }
    
    public void populateTable(){
        GovWorkRequest gov_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tbl_flood.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
            for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) 
            {
                if (wr instanceof GovWorkRequest)
                {
                    gov_wrs = (GovWorkRequest)wr;
            
                    if(gov_wrs.getFloodManagementSensorList()!= null)
                    {
                    Object[] row = new Object[3];
                    row[0] = gov_wrs;
                    row[1] = gov_wrs.getSender();
                    row[2] = gov_wrs.getFloodManagementMessage();
                    model.addRow(row);
                    }
                }
            }
        }
   }
    
    /**
     * Creates new form GovernmentOfficialWorkQueue2JPanel
     */
    public GovernmentOfficialWorkQueue2JPanel() {
        initComponents();
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
        MessageLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_flood = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_Notification = new javax.swing.JButton();
        btn_Resident_Notification = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Government Official Work Queue");

        MessageLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MessageLabel.setForeground(new java.awt.Color(255, 0, 0));

        tbl_flood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "work_Request_ID", "Sender", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_flood);

        btn_back.setText("<<Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jButton2.setText("View Complete Message");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_Notification.setText("Send Notification to residents");
        btn_Notification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotificationActionPerformed(evt);
            }
        });

        btn_Resident_Notification.setText("Send Resolve Notification to Residents");
        btn_Resident_Notification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Resident_NotificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(934, 934, 934)
                        .addComponent(MessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(btn_Notification, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btn_Resident_Notification, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(MessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(btn_Notification))
                        .addGap(64, 64, 64)
                        .addComponent(btn_Resident_Notification)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_backActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int row = tbl_flood.getSelectedRow();

        GovWorkRequest request = (GovWorkRequest)tbl_flood.getValueAt(row, 0);
        MessageLabel.setText(request.getFloodManagementMessage());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_NotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotificationActionPerformed
        // TODO add your handling code here:
       ArrayList<String> ZipcodeList = new ArrayList<String>();
        int row = tbl_flood.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }
        else
        {
            GovWorkRequest request = (GovWorkRequest)tbl_flood.getValueAt(row, 0);

            ResidentWorkRequest citizenWorkRequest = new ResidentWorkRequest();
            
            for(FloodManagementSensor fas : request.getFloodManagementSensorList())
            {
            ZipcodeList.add(fas.getZipcode());
            }
         citizenWorkRequest.setFloodManagementSensorList(request.getFloodManagementSensorList());
            
            citizenWorkRequest.setFloodManagementMessage("The Areas bearing pincodes "+ZipcodeList.stream().collect(Collectors.joining(","))+" are under high risk of flood. Please stay indoors until further notice.");
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
    }//GEN-LAST:event_btn_NotificationActionPerformed

    private void btn_Resident_NotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Resident_NotificationActionPerformed
        // TODO add your handling code here:
        ArrayList<String> ZipcodeList = new ArrayList<String>();
        int row = tbl_flood.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }
        else
        {
            GovWorkRequest request = (GovWorkRequest)tbl_flood.getValueAt(row, 0);

            ResidentWorkRequest citizenWorkRequest = new ResidentWorkRequest();
            
            for(FloodManagementSensor fas : request.getFloodManagementSensorList())
            {
            ZipcodeList.add(fas.getZipcode());
            }
            
            citizenWorkRequest.setFloodManagementSensorList(request.getFloodManagementSensorList());
            citizenWorkRequest.setFloodManagementMessage("The Areas bearing pincodes "+ZipcodeList.stream().collect(Collectors.joining(","))+" are out of risk of flood. Since water levels in the River are under control");
            citizenWorkRequest.setSender(userAccount);
            citizenWorkRequest.setStatus("Resolution message sent to Citizens");

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
    }                                                           

      

                           

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
       ArrayList<String> ZipcodeList = new ArrayList<String>();
        int row = tbl_flood.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }
        else
        {
            GovWorkRequest request = (GovWorkRequest)tbl_flood.getValueAt(row, 0);

            ResidentWorkRequest citizenWorkRequest = new ResidentWorkRequest();
            
            for(FloodManagementSensor fas : request.getFloodManagementSensorList())
            {
            ZipcodeList.add(fas.getZipcode());
            }
         citizenWorkRequest.setFloodManagementSensorList(request.getFloodManagementSensorList());
            
            citizenWorkRequest.setFloodManagementMessage("The Areas bearing pincodes "+ZipcodeList.stream().collect(Collectors.joining(","))+" are under high risk of flood. Please stay indoors until further notice.");
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

    }//GEN-LAST:event_btn_Resident_NotificationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MessageLabel;
    private javax.swing.JButton btn_Notification;
    private javax.swing.JButton btn_Resident_Notification;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_flood;
    // End of variables declaration//GEN-END:variables
}
