/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvManagementRoles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Oragnization.WasteManagementOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WasteManagementWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class WasteManagementWorkQueue extends javax.swing.JPanel {
private OrganizationDirectory organizationdirectory;
private WasteManagementOrganization organization; 
    private UserAccount userAccount;
    private JPanel userProcessContainer;
       private Enterprise enterprise; 
    private EcoSystem business;
    
    /**
     * Creates new form WasteManagementWorkQueue
     */
    public WasteManagementWorkQueue(JPanel userProcessContainer, UserAccount account, OrganizationDirectory organizationDirectory) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organizationdirectory = organizationDirectory;
        this.organization = organization;
        this.business = business;
        this.enterprise = enterprise;
        
        populateTable();
    }

     public void populateTable(){
        WasteManagementWorkRequest garbage_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tvl_Waste_Table.getModel();
        model.setRowCount(0);
        
        for(Organization organization : organizationdirectory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof WasteManagementWorkRequest){
                garbage_wrs = (WasteManagementWorkRequest)wr;
            
                Object[] row = new Object[8];
                row[0] = garbage_wrs;
                row[1] = garbage_wrs.getSender();
                row[2] = garbage_wrs.getWastesensor().getSensorId();
                row[3] = garbage_wrs.getWastesensor().getZipcode();
                row[4] = garbage_wrs.getStatus();
                row[5] = garbage_wrs.getMsg();
                row[6] = garbage_wrs.getRqstDate();
                row[7] = garbage_wrs.getRslvDate();
                model.addRow(row);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tvl_Waste_Table = new javax.swing.JTable();
        btn_Back = new javax.swing.JButton();
        btn_Resolve = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Waste Management Work Queue");

        tvl_Waste_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Work_Request_ID", "Sender", "Sensor ID", "Zipcode"
            }
        ));
        jScrollPane1.setViewportView(tvl_Waste_Table);

        btn_Back.setText("<<BAck");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        btn_Resolve.setText("Resolve");
        btn_Resolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResolveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btn_Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Resolve)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Back)
                    .addComponent(btn_Resolve))
                .addContainerGap(275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        JPanel panel = new WasteManagementWorkAreaJPanel(userProcessContainer,userAccount,organization, enterprise,business);
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_BackActionPerformed

    private void btn_ResolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResolveActionPerformed
        // TODO add your handling code here:
        int row = tvl_Waste_Table.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        Random rn = new Random();

        WorkRequest workRequest = (WorkRequest) tvl_Waste_Table.getValueAt(row, 0);

        WasteManagementWorkRequest wasteWorkRequest = (WasteManagementWorkRequest)workRequest;
        wasteWorkRequest.setStatus("Resolved");
        wasteWorkRequest.setRslvDate(new Date());
        wasteWorkRequest.getWastesensor().setCurrentlevel(0);

        populateTable();
        JOptionPane.showMessageDialog(null, "Resolved");
        }
    }//GEN-LAST:event_btn_ResolveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Resolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tvl_Waste_Table;
    // End of variables declaration//GEN-END:variables
}
