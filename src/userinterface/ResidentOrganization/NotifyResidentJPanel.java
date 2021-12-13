/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentOrganization;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.GovOrg;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import Business.Oragnization.ResidentOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ResidentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author apurv
 */
public class NotifyResidentJPanel extends javax.swing.JPanel {
    private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;

    public NotifyResidentJPanel(JPanel userProcessContainer, UserAccount userAccount, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        
        populateTable();
    }
    /**
     * Creates new form NotifyResidentJPanel
     */
    public NotifyResidentJPanel() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_wrk_request = new javax.swing.JTable();
        btn_BACK = new javax.swing.JButton();
        btn_view_Full_Message = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("RESIDENT WORK QUEUE");
        add(jLabel1);
        jLabel1.setBounds(300, 27, 838, 40);

        tbl_wrk_request.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbl_wrk_request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Work_Request_ID", "Sender", "Message"
            }
        ));
        jScrollPane1.setViewportView(tbl_wrk_request);

        add(jScrollPane1);
        jScrollPane1.setBounds(209, 85, 644, 166);

        btn_BACK.setText("<<BACK");
        btn_BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BACKActionPerformed(evt);
            }
        });
        add(btn_BACK);
        btn_BACK.setBounds(730, 275, 123, 21);

        btn_view_Full_Message.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_view_Full_Message.setText("View_Full_Message");
        btn_view_Full_Message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_Full_MessageActionPerformed(evt);
            }
        });
        add(btn_view_Full_Message);
        btn_view_Full_Message.setBounds(380, 280, 199, 40);

        lblMessage.setForeground(new java.awt.Color(255, 0, 0));
        add(lblMessage);
        lblMessage.setBounds(106, 401, 811, 91);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/alert.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-250, -520, 1580, 1350);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BACKActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_BACKActionPerformed

    private void btn_view_Full_MessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_Full_MessageActionPerformed
        // TODO add your handling code here:
        int getSelectedRow = tbl_wrk_request.getSelectedRow();
        if(getSelectedRow <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }
        else
        {
        ResidentWorkRequest request = (ResidentWorkRequest)tbl_wrk_request.getValueAt(getSelectedRow, 0);
        if(request.getAirPollutionSensor() != null){
        lblMessage.setText(request.getAirPollutionMessage());
        }
        else
        {
        lblMessage.setText(request.getFloodManagementMessage());
        }
        }
    }//GEN-LAST:event_btn_view_Full_MessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BACK;
    private javax.swing.JButton btn_view_Full_Message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTable tbl_wrk_request;
    // End of variables declaration//GEN-END:variables

    public void populateTable() {
        ResidentWorkRequest resident_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tbl_wrk_request.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
            if(organization instanceof ResidentOrganization) {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof ResidentWorkRequest) 
            {
                resident_wrs = (ResidentWorkRequest)wr;
            
                if(resident_wrs.getAirPollutionSensor()!=null)
                {
                Object[] row1 = new Object[3];
                row1[0] = resident_wrs;
                row1[1] = resident_wrs.getSender();
                row1[2] = resident_wrs.getAirPollutionMessage();
                model.addRow(row1);
                }
                            
                else if(resident_wrs.getFloodManagementSensorList() != null)
                {
                Object[] row = new Object[3];
                row[0] = resident_wrs;
                row[1] = resident_wrs.getSender();
                row[2] = resident_wrs.getFloodManagementMessage();
                model.addRow(row);
                }
                
            }
        }
      }
        }    }
}
