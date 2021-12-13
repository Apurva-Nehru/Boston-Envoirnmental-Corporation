/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvironmentSensorEnterprise.FloodManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Network.Network;
import Business.Oragnization.Organization;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.Oragnization.GovOrg;
import Business.Oragnization.OrganizationDirectory;
import Business.Oragnization.FloodManagementOrganization;
import Business.Oragnization.NoisePollutionOrganization;
import Business.Sensor.AirPollutionSensor;
import Business.Sensor.FloodManagementSensor;
import Business.Sensor.NoisePollutionSensor;
import Business.Sensor.Sensor;
import Business.Sensor.SensorDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AirPollutionWorkRequest;
import Business.WorkQueue.FloodManagementWorkRequest;
import Business.WorkQueue.NoisePollutionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aishw
 */
public class NotifyToFloodDepartmentJPnel extends javax.swing.JPanel {
    
private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount account;
    private OrganizationDirectory organizationDirectory;
    private ArrayList<FloodManagementSensor> floodManagementSensorList = new ArrayList<FloodManagementSensor>();

    /**
     * Creates new form NotifyToFloodDepartmentJPnel
     */
    public NotifyToFloodDepartmentJPnel(JPanel userProcessContainer, UserAccount account, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.account = account;
        this.organizationDirectory = organizationDirectory;
        
        readFromCSV();
        populateTable();
        
        SelectedFloodReadingsJTable.setVisible(false);
        btnSendRequest.setVisible(false);
        SelectedFloodReadingsJTable.setVisible(false);
        
    }
    public void readFromCSV() throws IOException
    {
        
        
        String csvFile = "src\\\\CSV_Files\\\\FloodedAreasData.csv";
        
	        BufferedReader bufferedReader = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        try {
	            bufferedReader = new BufferedReader(new FileReader(csvFile));
                    ArrayList<String[]> dataCsvArr = new ArrayList();
                    int count = 0;
	            while ((line = bufferedReader.readLine()) != null) {
	                String[] dataFromCsv = line.split(cvsSplitBy);
                        dataCsvArr.add(count,dataFromCsv);
                        count++;
	            }
                    for(int i=1;i<dataCsvArr.size();i++){ 
                                for(Organization o : organizationDirectory.getOrganizationList())
                                {
                                    if (o instanceof EnvironmentSensorOrganization){
                                        EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
                                        SensorDirectory sd = eo.getSensorDirectory();
                                        String valuesOfArray2[] = dataCsvArr.get(i);
                                        if(sd.FloodManagementSensorSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor s = sd.createSensor(Sensor.SensorType.FloodManagementSensor);
                                        FloodManagementSensor fas = (FloodManagementSensor) s;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        fas.setLocation(valuesOfArray[0]);
                                        fas.setZipcode(valuesOfArray[1]);
                                        fas.setLatitude(valuesOfArray[2]);
                                        fas.setLongitude(valuesOfArray[3]);
                                        }
                                    }
                                }
                            }
                        bufferedReader.close();
                }
	         catch (FileNotFoundException e) {
	            e.printStackTrace();
                }
    }
    public void populateTable(){
     ArrayList<FloodManagementSensor> floodManagementlist = new ArrayList<FloodManagementSensor>();
          for (Organization organization : organizationDirectory.getOrganizationList()) {
            if(organization instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((EnvironmentSensorOrganization) organization).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof FloodManagementSensor)
                    {
                        FloodManagementSensor floodm = (FloodManagementSensor)sense;
                        floodManagementlist.add(floodm);
                    }
                }
            }
        }
         
           DefaultTableModel model = (DefaultTableModel) FloodManagementReadingsJTable.getModel();
        model.setRowCount(0);
        
        for(FloodManagementSensor  fms :floodManagementlist )
                {
                Object[] row = new Object[4];
                row[0] = fms.getSensorId();
                row[1] = fms.getZipcode();
                row[2] = fms.getCurrentlevel();
                model.addRow(row);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        SelectedFloodReadingsJTable = new javax.swing.JTable();
        btnSendRequest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        FloodManagementReadingsJTable = new javax.swing.JTable();
        btnSendSensoreInfroGov = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnCheckFloodReadings = new javax.swing.JButton();
        lblFloodMessage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Flood Management Sensore Readings");

        SelectedFloodReadingsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Current Water Level"
            }
        ));
        jScrollPane1.setViewportView(SelectedFloodReadingsJTable);

        btnSendRequest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSendRequest.setText("Send Request to Flood Management Department");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });

        FloodManagementReadingsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Current Water Level"
            }
        ));
        jScrollPane2.setViewportView(FloodManagementReadingsJTable);

        btnSendSensoreInfroGov.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSendSensoreInfroGov.setText("Send Sensor Information to Government");
        btnSendSensoreInfroGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendSensoreInfroGovActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCheckFloodReadings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCheckFloodReadings.setText("Check Flood Data Sensor Readings");
        btnCheckFloodReadings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckFloodReadingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSendSensoreInfroGov)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSendRequest)
                                .addGap(86, 86, 86)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCheckFloodReadings)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFloodMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloodMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckFloodReadings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendSensoreInfroGov, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed
        // TODO add your handling code here:
        FloodManagementWorkRequest reques = new FloodManagementWorkRequest();
        reques.setFloodManagementSensor(floodManagementSensorList);
        reques.setSender(account);
        reques.setStatus("Sent");
        reques.setMessage("Areas Sorrounding the River are on high risk of being flooded");

        Organization orgzn = null;
        Organization orgzn1 = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    //System.out.println(org.getName());
                    if (org instanceof FloodManagementOrganization){
                        orgzn = org;
                        break;
                    }

                }
                for(Organization org1 : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if(org1 instanceof EnvironmentSensorOrganization){
                        orgzn1 = org1;
                        break;
                    }
                }

            } }
        
        
            if (orgzn!=null){
            
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
            if(orgzn.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgzn.getWorkQueue().getWorkRequestList().add(reques);
                account.getWorkQ().getWorkRequestList().add(reques);
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Flood Alert Solution Department");
            }
            else
            {
            for(WorkRequest request1 : orgzn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof FloodManagementWorkRequest)
                {
                    FloodManagementWorkRequest reque = (FloodManagementWorkRequest) request1; 
                    
                        if(reques.getFloodManagementSensor().equals(reque.getFloodManagementSensor()))
                        {
                            workRequestAlreadyPresent = true;
                        }

                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about this sensor to the Flood Alert Solution Department");
                    }
                    else
                    {
                        orgzn.getWorkQueue().getWorkRequestList().add(reques);
                        account.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Flood Alert Solution Department successfully");
                    }
                }
            }

            if (orgzn1!=null)
            {
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
            if(orgzn1.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgzn1.getWorkQueue().getWorkRequestList().add(reques);
                account.getWorkQ().getWorkRequestList().add(reques);
            }
            else
            {
            for(WorkRequest request1 : orgzn1.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof FloodManagementWorkRequest)
                {
                    FloodManagementWorkRequest reque = (FloodManagementWorkRequest) request1; 
                        if(reques.getFloodManagementSensor().equals(reque.getFloodManagementSensor()))
                        {
                            workRequestAlreadyPresent = true;
                        }
                }
            }
                    if(!(workRequestAlreadyPresent))                    
                    {
                        orgzn1.getWorkQueue().getWorkRequestList().add(reques);
                        account.getWorkQ().getWorkRequestList().add(reques);
                    }
                }
        }
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void btnCheckFloodReadingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckFloodReadingsActionPerformed
        // TODO add your handling code here:
        ArrayList<FloodManagementSensor> floodManagementlist = new ArrayList<FloodManagementSensor>();
       
       int count = 0 ;
       
        for (Organization organization : organizationDirectory.getOrganizationList()) {
            if(organization instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((EnvironmentSensorOrganization) organization).getSensorDirectory();

                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof FloodManagementSensor)
                    {
                        FloodManagementSensor floodm = (FloodManagementSensor)sense;
                        floodManagementlist.add(floodm);
                    }
                }
            }
        }
        
        for(int i=0; i<floodManagementlist.size(); i++)
            System.out.println(floodManagementlist.get(i).getZipcode()+"\n");
        DefaultTableModel model = (DefaultTableModel) FloodManagementReadingsJTable.getModel();
        model.setRowCount(0);

        for(FloodManagementSensor  fms :floodManagementlist ){
        if(fms.getCurrentlevel()>200)
            {
                count++;
                Object[] row = new Object[4];
                row[0] = fms;
                row[1] = fms.getZipcode();
                row[2] = fms.getCurrentlevel();
                model.addRow(row);
            }
        }
        
            if(count>=2)
            {
                for(FloodManagementSensor floodms : floodManagementlist)
                {
                    floodManagementSensorList.add(floodms);
                }
                lblFloodMessage.setText("Areas Sorrounding the river are under high risk of being flooded due to rise in water lavels in the river");
                SelectedFloodReadingsJTable.setVisible(true);
                btnSendRequest.setVisible(true);
                btnSendSensoreInfroGov.setVisible(true);
            }
            
            else
            {
                SelectedFloodReadingsJTable.setVisible(false);
                btnSendRequest.setVisible(false);
                btnSendSensoreInfroGov.setVisible(false);
            }
    }//GEN-LAST:event_btnCheckFloodReadingsActionPerformed

    private void btnSendSensoreInfroGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendSensoreInfroGovActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSendSensoreInfroGovActionPerformed

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
    private javax.swing.JTable FloodManagementReadingsJTable;
    private javax.swing.JTable SelectedFloodReadingsJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckFloodReadings;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton btnSendSensoreInfroGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFloodMessage;
    // End of variables declaration//GEN-END:variables
}
