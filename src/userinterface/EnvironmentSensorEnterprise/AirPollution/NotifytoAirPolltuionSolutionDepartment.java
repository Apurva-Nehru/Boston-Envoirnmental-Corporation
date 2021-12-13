/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvironmentSensorEnterprise.AirPollution;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Network.Network;
import Business.Oragnization.AirPollutionOrganization;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Sensor.AirPollutionSensor;
import Business.Sensor.SensorDirectory;
import Business.Sensor.Sensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AirPollutionWorkRequest;
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
public class NotifytoAirPolltuionSolutionDepartment extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Enterprise enterprise; 
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory; 
    private EnvironmentSensorOrganization organization;
    /**
     * Creates new form NotifytoAirPolltuionSolutionDepartment
     */
    public NotifytoAirPolltuionSolutionDepartment(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.organizationDirectory = organizationDirectory;
        this.organization = organization;
        this.enterprise = enterprise;
        
        readFromCSV();
        populateTable();
    }
    public void readFromCSV() throws IOException
    {
        ArrayList<Sensor> sensorList = null;
        String csvFile = "src\\CSV_Files\\AirPollution.csv";
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
                                for(Organization orgn : organizationDirectory.getOrganizationList())
                                {
                                    if (orgn instanceof EnvironmentSensorOrganization){
                                        EnvironmentSensorOrganization envso = (EnvironmentSensorOrganization)orgn;
                                        SensorDirectory sensedirect = envso.getSensorDirectory();
                                        String valuesOfArray2[] = dataCsvArr.get(i);
                                        if(sensedirect.AirPollutionSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor sense = sensedirect.createSensor(Sensor.SensorType.AirPollutionSensor);
                                        AirPollutionSensor airps = (AirPollutionSensor) sense;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        airps.setLocation(valuesOfArray[0]);
                                        airps.setZipcode(valuesOfArray[1]);
                                        airps.setLatitude(valuesOfArray[2]);
                                        airps.setLongitude(valuesOfArray[3]);
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
    public void populateTable()
    {
        ArrayList<AirPollutionSensor> tempAirPollutionSensorList = new ArrayList<AirPollutionSensor>();

        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgzn : enterprise.getOrganizationDirectory().getOrganizationList())
            {
            if(orgzn instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((EnvironmentSensorOrganization) orgzn).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof AirPollutionSensor)
                    {
                        AirPollutionSensor airps = (AirPollutionSensor)sense;
                        tempAirPollutionSensorList.add(airps);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) AirPollutionReadingsJTable.getModel();
        model.setRowCount(0);
        
        for(AirPollutionSensor airps : tempAirPollutionSensorList)
                {
                Object[] row = new Object[3];
                row[0] = airps;
                row[1] = airps.getZipcode();
                row[2] = airps.getAirQualityIndex();
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
        AirPollutionReadingsJTable = new javax.swing.JTable();
        btnHighlyAirPollutedAreas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HighlyAirPollutedReadingsJTable = new javax.swing.JTable();
        btnNotifyGov = new javax.swing.JButton();
        btnNotifyAirPollution = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Air Pollution Sensor Readings");

        AirPollutionReadingsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Pollution Readings"
            }
        ));
        jScrollPane1.setViewportView(AirPollutionReadingsJTable);

        btnHighlyAirPollutedAreas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHighlyAirPollutedAreas.setText("Get Highly Air Polluted Areas");
        btnHighlyAirPollutedAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighlyAirPollutedAreasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Polluted Sensor Readings with Zipcode");

        HighlyAirPollutedReadingsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Pollution Reading"
            }
        ));
        jScrollPane2.setViewportView(HighlyAirPollutedReadingsJTable);

        btnNotifyGov.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNotifyGov.setText("Send Sensor Information to Government");
        btnNotifyGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyGovActionPerformed(evt);
            }
        });

        btnNotifyAirPollution.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNotifyAirPollution.setText("Send Request to Air Pollution Department");
        btnNotifyAirPollution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyAirPollutionActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/noise_reading.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(134, 134, 134)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnHighlyAirPollutedAreas)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNotifyAirPollution)
                            .addGap(18, 18, 18)
                            .addComponent(btnNotifyGov, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(318, 318, 318)
                            .addComponent(btnBack))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnHighlyAirPollutedAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNotifyAirPollution, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNotifyGov, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNotifyAirPollutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyAirPollutionActionPerformed
        // TODO add your handling code here:
        int row = HighlyAirPollutedReadingsJTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);
        
        Sensor airPollutionSenso = (Sensor)HighlyAirPollutedReadingsJTable.getValueAt(row, 0);
        
        AirPollutionSensor airPollutionSensor = (AirPollutionSensor) airPollutionSenso;
        AirPollutionWorkRequest reques = new AirPollutionWorkRequest();
        reques.setAirPollutionSensor(airPollutionSensor);
        reques.setSender(userAccount);
        reques.setStatus("Sent");
        reques.setMsg("Air Pollution is detriorating please have a look");
        
        Organization orgzn = null;
        Organization orgzn1 = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgn : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if (orgn instanceof AirPollutionOrganization){
                        orgzn = orgn;
                        break;
                    }
           
                } 
                for(Organization orgn1 : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if(orgn1 instanceof EnvironmentSensorOrganization){
                    orgzn1 = orgn1;
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
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Air Pollution Solution Department");
            }
            else
            {
            for(WorkRequest request1 : orgzn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof AirPollutionWorkRequest)
                {
                    AirPollutionWorkRequest reque = (AirPollutionWorkRequest) request1; 
                    sensorIDsArray.add(reque.getAirPollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getAirPollutionSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about the respective sensor to the Air Pollution Department");
                    }
                    else
                    {
                        orgzn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Air Pollution Department successfully");
                    }
                }
            }

        if (orgzn1!=null){
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
            if(orgzn1.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgzn1.getWorkQueue().getWorkRequestList().add(reques);
                userAccount.getWorkQ().getWorkRequestList().add(reques);
            }
            else
            {
            for(WorkRequest request1 : orgzn1.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof AirPollutionWorkRequest)
                {
                    AirPollutionWorkRequest reque = (AirPollutionWorkRequest) request1; 
                    sensorIDsArray.add(reque.getAirPollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getAirPollutionSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(!(workRequestAlreadyPresent))                    
                    {
                        orgzn1.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                    }
                }
        }
        }
    }//GEN-LAST:event_btnNotifyAirPollutionActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        JPanel panel = new AirPollutionSensorJPanel(userProcessContainer,userAccount,organization,enterprise,business);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnHighlyAirPollutedAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighlyAirPollutedAreasActionPerformed
        // TODO add your handling code here:
        ArrayList<AirPollutionSensor> tempAirPollutionSensorList = new ArrayList<AirPollutionSensor>();

        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgzn : enterprise.getOrganizationDirectory().getOrganizationList())
            {
            if(orgzn instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((EnvironmentSensorOrganization) orgzn).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof AirPollutionSensor)
                    {
                        AirPollutionSensor airp = (AirPollutionSensor)sense;
                        tempAirPollutionSensorList.add(airp);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) HighlyAirPollutedReadingsJTable.getModel();
        model.setRowCount(0);
        
        for(AirPollutionSensor airps : tempAirPollutionSensorList)
                {
                    if(airps.getAirQualityIndex()>150)
                    {
                        Object[] row = new Object[4];
                        row[0] = airps;
                        row[1] = airps.getZipcode();
                        row[2] = airps.getAirQualityIndex();
                        model.addRow(row);
                    }
                }
    }//GEN-LAST:event_btnHighlyAirPollutedAreasActionPerformed

    private void btnNotifyGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyGovActionPerformed
        // TODO add your handling code here:
        NotifyToGovernmentJPanel notifyToGovernmentJPanel = new NotifyToGovernmentJPanel(userProcessContainer, userAccount, business, organizationDirectory);
        userProcessContainer.add("sendRequestToGovernmentJPanel", notifyToGovernmentJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnNotifyGovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AirPollutionReadingsJTable;
    private javax.swing.JTable HighlyAirPollutedReadingsJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHighlyAirPollutedAreas;
    private javax.swing.JButton btnNotifyAirPollution;
    private javax.swing.JButton btnNotifyGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
