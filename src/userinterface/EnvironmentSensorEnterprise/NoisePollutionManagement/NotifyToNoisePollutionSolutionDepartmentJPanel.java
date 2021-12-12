/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvironmentSensorEnterprise.NoisePollutionManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Network.Network;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.Oragnization.GovOrg;
import Business.Oragnization.OrganizationDirectory;
import Business.Oragnization.NoisePollutionOrganization;
import Business.Sensor.AirPollutionSensor;
import Business.Sensor.NoisePollutionSensor;
import Business.Sensor.Sensor;
import Business.Sensor.SensorDirectory;
import Business.UserAccount.UserAccount;
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
public class NotifyToNoisePollutionSolutionDepartmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory;
    /**
     * Creates new form SendRequestToNoisePollutionSolutionDepartmentJPanel
     */
    public NotifyToNoisePollutionSolutionDepartmentJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
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
        
        String csvFile = "src\\\\CSV_Files\\\\AirPollution.csv";
        
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
                                        if(sd.NoisePollutionSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor s = sd.createSensor(Sensor.SensorType.NoisePollutionSensor);
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        s.setLocation(valuesOfArray[0]);
                                        s.setZipcode(valuesOfArray[1]);
                                        s.setLatitude(valuesOfArray[2]);
                                        s.setLongitude(valuesOfArray[3]);
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
        ArrayList<NoisePollutionSensor> tempNoisePollutionSensorList = new ArrayList<NoisePollutionSensor>();

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
                    if(sense instanceof NoisePollutionSensor)
                    {
                        NoisePollutionSensor noiseps = (NoisePollutionSensor)sense;
                        tempNoisePollutionSensorList.add(noiseps);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) FloodManagementReadingsJTable.getModel();
        model.setRowCount(0);
        
        for(NoisePollutionSensor noiseps : tempNoisePollutionSensorList)
                {
                Object[] row = new Object[3];
                row[0] = noiseps;
                row[1] = noiseps.getZipcode();
                row[2] = noiseps.getNoiseLevelInDecibel();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        FloodManagementReadingsJTable = new javax.swing.JTable();
        btnHighlyNoisePolluted = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        GetHighlypollutedareasJTable = new javax.swing.JTable();
        btnsendrequests = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Noise Pollution Sensor Readings");

        FloodManagementReadingsJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(FloodManagementReadingsJTable);

        btnHighlyNoisePolluted.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHighlyNoisePolluted.setText("Get Highly Noise Polluted Areas");
        btnHighlyNoisePolluted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighlyNoisePollutedActionPerformed(evt);
            }
        });

        GetHighlypollutedareasJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(GetHighlypollutedareasJTable);

        btnsendrequests.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnsendrequests.setText("Send Request to Noise Pollution department");
        btnsendrequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendrequestsActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnsendrequests)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(408, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHighlyNoisePolluted))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHighlyNoisePolluted)
                    .addComponent(jButton3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnsendrequests)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHighlyNoisePollutedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighlyNoisePollutedActionPerformed
        // TODO add your handling code here:
        ArrayList<NoisePollutionSensor> tempNoisePollutionSensorList = new ArrayList<NoisePollutionSensor>();

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
                            if(sense instanceof NoisePollutionSensor)
                            {
                                NoisePollutionSensor Noiseps = (NoisePollutionSensor)sense;
                                tempNoisePollutionSensorList.add(Noiseps);
                            }
                        }
                    }

                }
            }   }

            DefaultTableModel model = (DefaultTableModel) GetHighlypollutedareasJTable.getModel();
            model.setRowCount(0);

            for(NoisePollutionSensor noiseps : tempNoisePollutionSensorList)
            {
                if(noiseps.getNoiseLevelInDecibel()>90)
                {
                    Object[] row = new Object[4];
                    row[0] = noiseps;
                    row[1] = noiseps.getZipcode();
                    row[2] = noiseps.getNoiseLevelInDecibel();
                    model.addRow(row);
                }
            }
    }//GEN-LAST:event_btnHighlyNoisePollutedActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnsendrequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendrequestsActionPerformed
        // TODO add your handling code here:
        int row = GetHighlypollutedareasJTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);

        Sensor noisePollutionSenso = (Sensor)GetHighlypollutedareasJTable.getValueAt(row, 0);

        NoisePollutionSensor noisePollutionSensor = (NoisePollutionSensor) noisePollutionSenso;
        NoisePollutionWorkRequest reques = new NoisePollutionWorkRequest();
        reques.setNoisePollutionSensor(noisePollutionSensor);
        reques.setSender(userAccount);
        reques.setStatus("Sent");
        reques.setMsg("Please look at the reasons for such loud noise in the locality");

        Organization orgzn = null;
        Organization orgzn1 = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise entprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : entprise.getOrganizationDirectory().getOrganizationList())
                {
                    //System.out.println(org.getName());
                    if (org instanceof NoisePollutionOrganization){
                        orgzn = org;
                        break;
                    }

                }
                for(Organization org1 : entprise.getOrganizationDirectory().getOrganizationList())
                {
                    if(org1 instanceof EnvironmentSensorOrganization){
                        orgzn1 = org1;
                        break;
                    }
                }

            } }
            if (orgzn!=null)
            {
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
            if(orgzn.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgzn.getWorkQueue().getWorkRequestList().add(reques);
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                JOptionPane.showMessageDialog(null, "Request sent to Noise Pollution Solution Department successfully");
            }
            else
            {
            for(WorkRequest request1 : orgzn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof NoisePollutionWorkRequest)
                {
                    NoisePollutionWorkRequest reque = (NoisePollutionWorkRequest) request1; 
                    sensorIDsArray.add(reque.getNoisePollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getNoisePollutionSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about this sensor to the Noise Pollution Department");
                    }
                    else
                    {
                        orgzn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Noise Pollution Department successfully");
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
                if(request1 instanceof NoisePollutionWorkRequest)
                {
                    NoisePollutionWorkRequest req = (NoisePollutionWorkRequest) request1; 
                    sensorIDsArray.add(req.getNoisePollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getNoisePollutionSensor().getSensorId() == sensorIDsArray.get(i))
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
    }//GEN-LAST:event_btnsendrequestsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FloodManagementReadingsJTable;
    private javax.swing.JTable GetHighlypollutedareasJTable;
    private javax.swing.JButton btnHighlyNoisePolluted;
    private javax.swing.JButton btnsendrequests;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
