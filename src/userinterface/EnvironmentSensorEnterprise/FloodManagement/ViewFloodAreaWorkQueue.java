/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvironmentSensorEnterprise.FloodManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Network.Network;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.Oragnization.GovOrg;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Sensor.AirPollutionSensor;
import Business.Sensor.FloodManagementSensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AirPollutionWorkRequest;
import Business.WorkQueue.FloodManagementWorkRequest;
import Business.WorkQueue.GovWorkRequest;
import Business.WorkQueue.NoisePollutionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aishw
 */
public class ViewFloodAreaWorkQueue extends javax.swing.JPanel {
    private OrganizationDirectory organizationDirectory;
    private UserAccount account;
    private JPanel userProcessContainer;
    private EcoSystem business;
    /**
     * Creates new form ViewFloodAreaWorkQueue
     */
    public ViewFloodAreaWorkQueue(JPanel userProcessContainer, UserAccount account, OrganizationDirectory organizationDirectory, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organizationDirectory = organizationDirectory ;
        this.business = business;
        populateTable();
    }
    
      public String convertListToCSV(ArrayList<String> ZipcodeList)
    {
        String zipcodesCommaSeparated = ZipcodeList.stream().collect(Collectors.joining(","));     
        return zipcodesCommaSeparated;
    }
    
    public void populateTable(){
        ArrayList<String> ZipcodeList = new ArrayList<String>();
        FloodManagementWorkRequest noise_works = null;
        DefaultTableModel model = (DefaultTableModel) FloodWorkQueueJTable.getModel();
        model.setRowCount(0);
        
        for(Organization organization : organizationDirectory.getOrganizationList())
        {
            if(organization instanceof EnvironmentSensorOrganization)
            {
                for (WorkRequest workr : organization.getWorkQueue().getWorkRequestList()) {
                    if (workr instanceof FloodManagementWorkRequest) {
                        noise_works = (FloodManagementWorkRequest)workr;
            
                        for(FloodManagementSensor fas : noise_works.getFloodManagementSensor())
                        {
                        ZipcodeList.add(fas.getZipcode());
                        }
                        Object[] row = new Object[7];
                        row[0] = noise_works;
                        row[1] = noise_works.getSender();                        
                        row[2] = convertListToCSV(ZipcodeList);
                        row[3] = noise_works.getStatus();
                        row[4] = noise_works.getMessage();
                        row[5] = noise_works.getRqstDate();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        FloodWorkQueueJTable = new javax.swing.JTable();
        lblPending = new javax.swing.JLabel();
        btnPendingRequest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PendingReqJTable = new javax.swing.JTable();
        lblresolve = new javax.swing.JLabel();
        btnResolved = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ResolvedJTable = new javax.swing.JTable();
        btnResolvedMessageGov = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flood Management Work Request");
        add(jLabel1);
        jLabel1.setBounds(151, 18, 516, 42);

        FloodWorkQueueJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FloodWorkQueueJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Work Request ID", "Sender", "Sensor ID", "Zipcode", "Status", "Message", "Sent Date"
            }
        ));
        jScrollPane2.setViewportView(FloodWorkQueueJTable);

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 59, 937, 160);

        lblPending.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPending.setText("Pending Requests");
        add(lblPending);
        lblPending.setBounds(10, 229, 156, 29);

        btnPendingRequest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPendingRequest.setForeground(new java.awt.Color(0, 0, 255));
        btnPendingRequest.setText("Get Pending Requests");
        btnPendingRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendingRequestActionPerformed(evt);
            }
        });
        add(btnPendingRequest);
        btnPendingRequest.setBounds(336, 229, 227, 31);

        PendingReqJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PendingReqJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Work Request ID", "Sender", "Sensor ID", "Zipcode", "Status", "Message", "Sent Date"
            }
        ));
        jScrollPane1.setViewportView(PendingReqJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 267, 937, 121);

        lblresolve.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblresolve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblresolve.setText("Resolved Requests");
        add(lblresolve);
        lblresolve.setBounds(10, 398, 156, 29);

        btnResolved.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnResolved.setForeground(new java.awt.Color(0, 204, 51));
        btnResolved.setText("Get Resolved Work Requests");
        btnResolved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolvedActionPerformed(evt);
            }
        });
        add(btnResolved);
        btnResolved.setBounds(244, 398, 227, 31);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(810, 230, 104, 32);

        ResolvedJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResolvedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Work Request ID", "Sender", "Sensor ID", "Zipcode", "Status", "Message", "Sent Date"
            }
        ));
        jScrollPane3.setViewportView(ResolvedJTable);

        add(jScrollPane3);
        jScrollPane3.setBounds(10, 442, 937, 130);

        btnResolvedMessageGov.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnResolvedMessageGov.setForeground(new java.awt.Color(0, 204, 0));
        btnResolvedMessageGov.setText("Send Resolution Message to Government");
        btnResolvedMessageGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolvedMessageGovActionPerformed(evt);
            }
        });
        add(btnResolvedMessageGov);
        btnResolvedMessageGov.setBounds(530, 398, 302, 31);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/floodboston.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, -60, 1150, 770);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPendingRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendingRequestActionPerformed
        // TODO add your handling code here:
        AirPollutionWorkRequest air_works = null;
        DefaultTableModel model = (DefaultTableModel) PendingReqJTable.getModel();
        model.setRowCount(0);

        for(Organization organization : organizationDirectory.getOrganizationList())
        {
            if(organization instanceof EnvironmentSensorOrganization)
            {
                for (WorkRequest workr : organization.getWorkQueue().getWorkRequestList()) {
                    if (workr instanceof AirPollutionWorkRequest)  {
                        air_works = (AirPollutionWorkRequest)workr;

                        if(!air_works.getStatus().equalsIgnoreCase("Resolved"))
                        {
                            Object[] row = new Object[7];
                            row[0] = air_works;
                            row[1] = air_works.getSender();
                            row[2] = air_works.getAirPollutionSensor().getSensorId();
                            row[3] = air_works.getAirPollutionSensor().getZipcode();
                            row[4] = air_works.getStatus();
                            row[5] = air_works.getMsg();
                            row[6] = air_works.getRqstDate();
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnPendingRequestActionPerformed

    private void btnResolvedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolvedActionPerformed
        // TODO add your handling code here:
        AirPollutionWorkRequest air_works = null;
        DefaultTableModel model = (DefaultTableModel) ResolvedJTable.getModel();
        model.setRowCount(0);

        for(Organization organization : organizationDirectory   .getOrganizationList())
        {
            if(organization instanceof EnvironmentSensorOrganization)
            {
                for (WorkRequest workr : organization.getWorkQueue().getWorkRequestList()) {
                    if (workr instanceof AirPollutionWorkRequest)
                    {
                        air_works = (AirPollutionWorkRequest)workr;

                        if(air_works.getStatus().equalsIgnoreCase("Resolved"))
                        {
                            Object[] row = new Object[8];
                            row[0] = air_works;
                            row[1] = air_works.getSender();
                            row[2] = air_works.getAirPollutionSensor().getSensorId();
                            row[3] = air_works.getAirPollutionSensor().getZipcode();
                            row[4] = air_works.getStatus();
                            row[5] = air_works.getMsg();
                            row[6] = air_works.getRqstDate();
                            row[7] = air_works.getRslvDate();
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnResolvedActionPerformed

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

    private void btnResolvedMessageGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolvedMessageGovActionPerformed
        // TODO add your handling code here:
        ArrayList<String> ZipcodeList = new ArrayList<String>();
        int row = ResolvedJTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }
        else
        {
            //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);

//            Sensor airPollutionSenso = (Sensor)ResolvedWorkQueuejTable.getValueAt(row, 0);
            
            FloodManagementWorkRequest reques = (FloodManagementWorkRequest)ResolvedJTable.getValueAt(row, 0);

            for(FloodManagementSensor fas : reques.getFloodManagementSensor())
            {
            ZipcodeList.add(fas.getZipcode());
            }
            
            ArrayList<FloodManagementSensor> floodAlertSensorList = reques.getFloodManagementSensor();
            GovWorkRequest govWorkRequest = new GovWorkRequest();
            govWorkRequest.setFloodManagementSensorList(floodAlertSensorList);
            govWorkRequest.setFloodManagementMessage("The Area bearing pincodes "+ZipcodeList.stream().collect(Collectors.joining(","))+"'are now out of danger for floods.");
            govWorkRequest.setSender(account);
            govWorkRequest.setStatus("Resolution Message Sent to Government");

            Organization orgzn = null;
            for(Network ntwk: business.getNetworkList())
            {
                for(Enterprise entprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
                {
                    for(Organization org : entprise.getOrganizationDirectory().getOrganizationList())
                    {
                        //System.out.println(org.getName());
                        if (org instanceof GovOrg){
                            orgzn = org;
                            break;
                        }
                    }
                }
            }
            if (orgzn!=null)
            {

                ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
                boolean workRequestAlreadyPresent = false;

                    orgzn.getWorkQueue().getWorkRequestList().add(govWorkRequest);
                    account.getWorkQ().getWorkRequestList().add(govWorkRequest);
                    JOptionPane.showMessageDialog(null, "Request sent to Government successfully");
            }
             
          }
    }//GEN-LAST:event_btnResolvedMessageGovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FloodWorkQueueJTable;
    private javax.swing.JTable PendingReqJTable;
    private javax.swing.JTable ResolvedJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPendingRequest;
    private javax.swing.JButton btnResolved;
    private javax.swing.JButton btnResolvedMessageGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPending;
    private javax.swing.JLabel lblresolve;
    // End of variables declaration//GEN-END:variables
}
