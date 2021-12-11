/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvManagementRoles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.AirPollutionOrganization;
import Business.Oragnization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class AirPollutionManagementWorkJPanel extends javax.swing.JPanel {
   private JPanel userProcessContainer;
    private UserAccount account; 
    private AirPollutionOrganization organization; 
    private Enterprise enterprise; 
    private EcoSystem business;
    /**
     * Creates new form AirPollutionManagementWorkJPanel
     */
    public AirPollutionManagementWorkJPanel() {
        this.userProcessContainer = userProcessContainer;
        this.account = account;
       this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
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
        btn_View_Work_request = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Air Pollution Management Work Area");

        btn_View_Work_request.setText("View Work request");
        btn_View_Work_request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_View_Work_requestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btn_View_Work_request)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addComponent(btn_View_Work_request)
                .addContainerGap(339, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_View_Work_requestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_View_Work_requestActionPerformed
        // TODO add your handling code here:
          AirPollutionManagementWorkQueueJPanel airPollutionManagementWorkQueue = new AirPollutionManagementWorkQueueJPanel(userProcessContainer, account, enterprise.getOrganizationDirectory());
        userProcessContainer.add("airPollutionManagementWorkQueue", airPollutionManagementWorkQueue);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_View_Work_requestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_View_Work_request;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
