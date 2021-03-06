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
import Business.Oragnization.GovOrg;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Sensor.AirPollutionSensor;
import Business.Sensor.Sensor;
import Business.Sensor.SensorDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AirPollutionWorkRequest;
import Business.WorkQueue.GovWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.EnvironmentSensorEnterprise.SensorManagement.SensorManagementWorkArea;

/**
 *
 * @author aishw
 */
public class NotifyToGovernmentJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory;
    

    /**
     * Creates new form NotifyToGovernmentJPanel
     */
    public NotifyToGovernmentJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.organizationDirectory = organizationDirectory;
        
        populateTable();
    }
    
    public void populateTable(){
         ArrayList<AirPollutionSensor> tempAirPollutionSensorList = new ArrayList<AirPollutionSensor>();

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
                    if(sense instanceof AirPollutionSensor)
                    {
                        AirPollutionSensor air = (AirPollutionSensor)sense;
                        tempAirPollutionSensorList.add(air);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) HighlyAirPollutedAreasJTable.getModel();
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
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        HighlyAirPollutedAreasJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        HighlyAirPollutedAreasJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Air Pollution Quality Index"
            }
        ));
        jScrollPane1.setViewportView(HighlyAirPollutedAreasJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 150, 695, 110);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Air Pollution Sensor Readings for the Desired Zipcode");
        add(jLabel1);
        jLabel1.setBounds(50, 90, 708, 45);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back_Final.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(20, 300, 115, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Send Request To Government");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(490, 310, 330, 33);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/maxresdefault.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 870, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = HighlyAirPollutedAreasJTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);
        
        Sensor airPollutionSenso = (Sensor)HighlyAirPollutedAreasJTable.getValueAt(row, 0);
        
        AirPollutionSensor airPollutionSensor = (AirPollutionSensor) airPollutionSenso;
        GovWorkRequest reques = new GovWorkRequest();
        reques.setAirPollutionSensor(airPollutionSensor);
        reques.setAirPollutionMessage("The Area bearing pincode "+airPollutionSensor.getZipcode()+" has bad air quality for now, please inform residents to avoid this area until further notice");
        reques.setSender(userAccount);
        reques.setStatus("Successfully Notified to Government");
        
        Organization orgn = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgzn : enterprise.getOrganizationDirectory().getOrganizationList())
                {
            //System.out.println(org.getName());
            if (orgzn instanceof GovOrg){
                orgn = orgzn;
                break;
                    }           
                }
            } 
        }
        if (orgn!=null){
            
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
            if(orgn.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgn.getWorkQueue().getWorkRequestList().add(reques);
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                JOptionPane.showMessageDialog(null, "Request sent to Government successfully");
            }
            else
            {
            for(WorkRequest request1 : orgn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof GovWorkRequest)
                {
                    GovWorkRequest reque = (GovWorkRequest) request1;
                    
                    if(reque.getAirPollutionSensor() != null)
                    {
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
              }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent to Government");
                    }
                    else
                    {
                        orgn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Government successfully");
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        //JPanel panel = new NotifytoAirPolltuionSolutionDepartment(userProcessContainer,userAccount,business,organizationDirectory);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HighlyAirPollutedAreasJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
