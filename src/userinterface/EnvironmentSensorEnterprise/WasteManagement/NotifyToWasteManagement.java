/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvironmentSensorEnterprise.WasteManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Network.Network;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.Oragnization.WasteManagementOrganization;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Sensor.WasteSensor;
import Business.Sensor.Sensor;
import Business.Sensor.SensorDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WasteManagementWorkRequest;
import Business.WorkQueue.NoisePollutionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author aishw
 */
public class NotifyToWasteManagement extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory;

    /**
     * Creates new form NotifyToWasteManagement
     */
    public NotifyToWasteManagement(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException  {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.organizationDirectory = organizationDirectory;
        
        readFromCSV();
        populateTable();
    }
    public void readFromCSV() throws IOException
    {
        //String csvFile = "C:\\Users\\Akshay\\Desktop\\AirPollution.csv";
        
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
                                for(Organization org : organizationDirectory.getOrganizationList())
                                {
                                    if (org instanceof EnvironmentSensorOrganization){
                                        EnvironmentSensorOrganization envso = (EnvironmentSensorOrganization)org;
                                        SensorDirectory sensedirect = envso.getSensorDirectory();
                                        String valuesOfArray2[] = dataCsvArr.get(i);
                                        if(sensedirect.WasteManagementSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor sense = sensedirect.createSensor(Sensor.SensorType.WasteSensor);
                                        WasteSensor wastes = (WasteSensor) sense;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        wastes.setLocation(valuesOfArray[0]);
                                        wastes.setZipcode(valuesOfArray[1]);
                                        wastes.setLatitude(valuesOfArray[2]);
                                        wastes.setLongitude(valuesOfArray[3]);
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
        ArrayList<WasteSensor> wasteSensorList = new ArrayList<WasteSensor>();

        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise entprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : entprise.getOrganizationDirectory().getOrganizationList())
            {
            if(org instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((EnvironmentSensorOrganization) org).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof WasteSensor)
                    {
                        WasteSensor wastes = (WasteSensor)sense;
                        wasteSensorList.add(wastes);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) wasteManagementReadingsJTable.getModel();
        model.setRowCount(0);
        
        for(WasteSensor wastesense : wasteSensorList)
                {
                Object[] row = new Object[3];
                row[0] = wastesense;
                row[1] = wastesense.getZipcode();
                row[2] = wastesense.getCurrentlevel();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        wasteManagementReadingsJTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnDirtyAreas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        WasteAboveThreshold = new javax.swing.JTable();
        btnSendRequest = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));

        wasteManagementReadingsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Garbage Above threshold"
            }
        ));
        jScrollPane2.setViewportView(wasteManagementReadingsJTable);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Waste Management Sensor Readings");

        btnDirtyAreas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDirtyAreas.setText("Get Highly Dirt Polluted Areas");
        btnDirtyAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirtyAreasActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        WasteAboveThreshold.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Garbage Above Threshold"
            }
        ));
        jScrollPane3.setViewportView(WasteAboveThreshold);

        btnSendRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSendRequest.setText("Send Request to Waste Management department");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Wastage Above Threshold level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSendRequest)
                        .addGap(292, 292, 292))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDirtyAreas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDirtyAreas)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendRequest)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDirtyAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirtyAreasActionPerformed
        // TODO add your handling code here:
        ArrayList<WasteSensor> wasteSensorList = new ArrayList<WasteSensor>();

        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise entprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : entprise.getOrganizationDirectory().getOrganizationList())
            {
            if(org instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((EnvironmentSensorOrganization) org).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof WasteSensor)
                    {
                        WasteSensor wastes = (WasteSensor)sense;
                        wasteSensorList.add(wastes);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) WasteAboveThreshold.getModel();
        model.setRowCount(0);
        
        for(WasteSensor wastes : wasteSensorList)
            if(wastes.getCurrentlevel()>200)
                {
                Object[] row = new Object[3];
                row[0] = wastes;
                row[1] = wastes.getZipcode();
                row[2] = wastes.getCurrentlevel();
                model.addRow(row);
                }
    }//GEN-LAST:event_btnDirtyAreasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component cmpnt = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layot = (CardLayout) userProcessContainer.getLayout();
        layot.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed
        // TODO add your handling code here:
        int row = WasteAboveThreshold.getSelectedRow();
         if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);

        Sensor wasteSensor = (Sensor) WasteAboveThreshold.getValueAt(row, 0);

        WasteSensor wasteManagementSensor = (WasteSensor) wasteSensor;
        WasteManagementWorkRequest reques = new WasteManagementWorkRequest();
        reques.setWastesensor(wasteManagementSensor);
        reques.setSender(userAccount);
        reques.setStatus("Sent");
        reques.setMsg("Waste bins are filled ");

        Organization orgzn = null;
        Organization orgzn1 = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    //System.out.println(org.getName());
                    if (org instanceof WasteManagementOrganization){
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
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                JOptionPane.showMessageDialog(null, "Request sent to Waste management Department successfully");
            }
            else
            {
            for(WorkRequest request1 : orgzn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof WasteManagementWorkRequest)
                {
                    WasteManagementWorkRequest reque = (WasteManagementWorkRequest) request1; 
                    sensorIDsArray.add(reque.getWastesensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getWastesensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about this sensor to the Waste management Department");
                    }
                    else
                    {
                        orgzn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Waste management Department successfully");
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
                if(request1 instanceof WasteManagementWorkRequest)
                {
                    WasteManagementWorkRequest reque = (WasteManagementWorkRequest) request1; 
                    sensorIDsArray.add(reque.getWastesensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getWastesensor().getSensorId() == sensorIDsArray.get(i))
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
           
        
    }//GEN-LAST:event_btnSendRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable WasteAboveThreshold;
    private javax.swing.JButton btnDirtyAreas;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable wasteManagementReadingsJTable;
    // End of variables declaration//GEN-END:variables
}
