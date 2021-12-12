/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GovWorkArea;

import Business.Employee.Employee;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class GovernmentEmployeeJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    /**
     * Creates new form GovernmentEmployeeJPanel
     */
    public GovernmentEmployeeJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDir) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;

        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
    }
    
    public void populateOrganizationComboBox() {
        combo_Org.removeAllItems();

        for (Organization organization : organizationDir.getOrganizationList()) {
            combo_Org.addItem(organization);
        }
    }

    public void populateOrganizationEmpComboBox() {
        combo_employeeorg.removeAllItems();

        for (Organization organization : organizationDir.getOrganizationList()) {
            combo_employeeorg.addItem(organization);
        }
    }
    
    private void populateTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) tbl_Org.getModel();

        model.setRowCount(0);

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            Object[] row = new Object[1];

            row[0] = employee.getName();
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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo_Org = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo_employeeorg = new javax.swing.JComboBox();
        txt_Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Org = new javax.swing.JTable();
        Btn_Back = new javax.swing.JButton();
        btn_add_employee = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("View Employees");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Organization");

        combo_Org.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_Org.setForeground(new java.awt.Color(0, 0, 51));
        combo_Org.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_OrgActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Add Employee");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Organization");

        combo_employeeorg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_employeeorg.setForeground(new java.awt.Color(0, 0, 51));
        combo_employeeorg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Name.setForeground(new java.awt.Color(0, 0, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");

        tbl_Org.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane2.setViewportView(tbl_Org);

        Btn_Back.setText("<<Back");
        Btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BackActionPerformed(evt);
            }
        });

        btn_add_employee.setText("Created Employee");
        btn_add_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_employeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(combo_employeeorg, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(241, 241, 241)
                                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(295, 295, 295)
                                    .addComponent(btn_add_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(62, 62, 62)
                                .addComponent(combo_Org, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_Org, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_employeeorg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Back)
                    .addComponent(btn_add_employee))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combo_OrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_OrgActionPerformed
        Organization organization = (Organization) combo_Org.getSelectedItem();
        if (organization != null) {
            populateTable(organization);
        }
    }//GEN-LAST:event_combo_OrgActionPerformed

    private void Btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_Btn_BackActionPerformed

    private void btn_add_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_employeeActionPerformed
        // TODO add your handling code here:
         if(txt_Name.equals("")){
               JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
        else{
        Organization organization = (Organization) combo_employeeorg.getSelectedItem();
        //        if (organization instanceof ConsumerOrganization) {
            //            JOptionPane.showMessageDialog(null, "You cannot add the consumer that is responsiblity of Global Manager");
            //        } else {
            String name = txt_Name.getText();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "An Employee must have a name");
            } else {
                organization.getEmployeeDirectory().createEmployee(name);
                
                JOptionPane.showMessageDialog(null, "Employee created Succesfully");
            }
        }
    }//GEN-LAST:event_btn_add_employeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Back;
    private javax.swing.JButton btn_add_employee;
    private javax.swing.JComboBox combo_Org;
    private javax.swing.JComboBox combo_employeeorg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_Org;
    private javax.swing.JTextField txt_Name;
    // End of variables declaration//GEN-END:variables
}
