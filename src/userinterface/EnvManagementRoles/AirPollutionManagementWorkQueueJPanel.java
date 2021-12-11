/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvManagementRoles;
import Business.Oragnization.Organization;
import Business.WorkQueue.AirPollutionWorkRequest;
import Business.Oragnization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import BusinessWorkQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class AirPollutionManagementWorkQueueJPanel extends javax.swing.JPanel {
private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    /**
     * Creates new form AirPollutionManagementWorkQueueJPanel
     * @param userProcessContainer
     */
    public AirPollutionManagementWorkQueueJPanel(JPanel userProcessContainer, UserAccount userAccount, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        
        populateTable();
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
        tbl_WorkQueue = new javax.swing.JTable();
        btn_Back = new javax.swing.JButton();
        btn_Resolve = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Air Pollution Management Work Queue");

        tbl_WorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Work_Request", "Sender", "Sensor_Id", "Zip"
            }
        ));
        jScrollPane1.setViewportView(tbl_WorkQueue);

        btn_Back.setText("<<Back");

        btn_Resolve.setText("Resolve");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Resolve, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Back)
                    .addComponent(btn_Resolve))
                .addContainerGap(258, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Resolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_WorkQueue;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
          AirPollutionWorkRequest air_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tbl_WorkQueue.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof AirPollutionWorkRequest) {
                air_wrs = (AirPollutionWorkRequest)wr;
            
                Object[] row = new Object[8];
                row[0] = air_wrs;
                row[1] = air_wrs.getSender();
                row[2] = air_wrs.getAirPollutionSensor().getSensorId();
                row[3] = air_wrs.getAirPollutionSensor().getZipcode();
                row[4] = air_wrs.getStatus();
                row[5] = air_wrs.getMessage();
                row[6] = air_wrs.getRequestDate();
                row[7] = air_wrs.getResolveDate();
                model.addRow(row);
            }
        }
        }

    }
    
}
