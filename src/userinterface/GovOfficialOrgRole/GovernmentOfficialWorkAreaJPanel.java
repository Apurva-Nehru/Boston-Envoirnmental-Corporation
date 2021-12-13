/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GovOfficialOrgRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.GovOrg;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author apurv
 */
public class GovernmentOfficialWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account; 
    private GovOrg organization; 
    private Enterprise enterprise; 
    private EcoSystem business;
    /**
     * Creates new form GovernmentOfficialWorkAreaJPanel
     */
    public GovernmentOfficialWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, GovOrg organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
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
        btn_pollution_wrk_queue = new javax.swing.JButton();
        btn_Flood_queue = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Government Official Work Area");
        add(jLabel1);
        jLabel1.setBounds(90, 10, 510, 29);

        btn_pollution_wrk_queue.setBackground(new java.awt.Color(255, 255, 255));
        btn_pollution_wrk_queue.setForeground(new java.awt.Color(0, 0, 255));
        btn_pollution_wrk_queue.setText("View Air Pollution Work Queue");
        btn_pollution_wrk_queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pollution_wrk_queueActionPerformed(evt);
            }
        });
        add(btn_pollution_wrk_queue);
        btn_pollution_wrk_queue.setBounds(20, 120, 210, 21);

        btn_Flood_queue.setForeground(new java.awt.Color(0, 51, 255));
        btn_Flood_queue.setText("View Flood Alert Work Queue");
        btn_Flood_queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Flood_queueActionPerformed(evt);
            }
        });
        add(btn_Flood_queue);
        btn_Flood_queue.setBounds(370, 120, 210, 21);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gov.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 680, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pollution_wrk_queueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pollution_wrk_queueActionPerformed
        // TODO add your handling code here:
        GovernmentOfficialWorkAirPollutionQueueJPanel governmentOfficialWorkQueueJPanel = new GovernmentOfficialWorkAirPollutionQueueJPanel(userProcessContainer, account, enterprise, enterprise.getOrganizationDirectory());
        userProcessContainer.add("governmentOfficialWorkQueueJPanel", governmentOfficialWorkQueueJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_pollution_wrk_queueActionPerformed

    private void btn_Flood_queueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Flood_queueActionPerformed
        // TODO add your handling code here:
         GovernmentOfficialWorkNoisePolltuionQueue2JPanel governmentOfficialWorkQueue2JPanel = new GovernmentOfficialWorkNoisePolltuionQueue2JPanel(userProcessContainer, account, enterprise, enterprise.getOrganizationDirectory());
        userProcessContainer.add("governmentOfficialWorkQueue2JPanel", governmentOfficialWorkQueue2JPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_Flood_queueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Flood_queue;
    private javax.swing.JButton btn_pollution_wrk_queue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
