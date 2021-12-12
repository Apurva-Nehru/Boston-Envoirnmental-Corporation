/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovWorkArea;


import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Oragnization.Organization.GovernmentType;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;

/**
 *
 * @author apurv
 */
public class GovernmentOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    /**
     * Creates new form GovernmentEnterpriseJPanel
     */
    public GovernmentOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        
        populateTable();
        populateCombo();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_govorg.getModel();

        model.setRowCount(0);

        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[1];

            row[0] = organization;

            model.addRow(row);
        }
    }
    
    private void populateCombo() {
        combo_org.removeAllItems();
        for (Organization.GovernmentType type : Organization.GovernmentType.values()) {
            if (!type.getValue().equals(Organization.GovernmentType.GovernmentAdmin.getValue())) {
                combo_org.addItem(type);
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
        combo_org = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_govorg = new javax.swing.JTable();
        btn_Add_org = new javax.swing.JButton();
        btn_delete_org = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Organization Type ");

        combo_org.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_org.setForeground(new java.awt.Color(0, 0, 51));
        combo_org.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_orgActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Government Organization");

        tbl_govorg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_govorg);

        btn_Add_org.setText("Add organization");
        btn_Add_org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add_orgActionPerformed(evt);
            }
        });

        btn_delete_org.setText("Delete Organization");
        btn_delete_org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_orgActionPerformed(evt);
            }
        });

        btn_Back.setText("<<BACK");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67)
                                .addComponent(combo_org, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btn_Add_org, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btn_delete_org, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btn_Back))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_org, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Add_org)
                    .addComponent(btn_delete_org))
                .addContainerGap(186, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combo_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_orgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_orgActionPerformed

    private void btn_Add_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add_orgActionPerformed
        // TODO add your handling code here:
         GovernmentType type = (GovernmentType) combo_org.getSelectedItem();

        directory.createGovernmentOfficial(type);
        //directory.createEnvironmentManagement(type);
        populateTable();
    }//GEN-LAST:event_btn_Add_orgActionPerformed

    private void btn_delete_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_orgActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedRow = tbl_govorg.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        Organization org = (Organization) tbl_govorg.getValueAt(selectedRow, 0);
        directory.DeleteOrganization(org);
        populateTable();
        JOptionPane.showMessageDialog(null, "Organization deleted Succesfully");
    }//GEN-LAST:event_btn_delete_orgActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_govorg.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        Organization org = (Organization) tbl_govorg.getValueAt(selectedRow, 0);
        directory.DeleteOrganization(org);
        populateTable();
        JOptionPane.showMessageDialog(null, "Organization deleted Succesfully");
    }//GEN-LAST:event_btn_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add_org;
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_delete_org;
    private javax.swing.JComboBox combo_org;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_govorg;
    // End of variables declaration//GEN-END:variables
}