/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvManagementWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.management.relation.Role;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class EnvManagementUserJPanel extends javax.swing.JPanel {

   private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem business;
    /**
     * Creates new form EnvironmentManagementUserJPanel
     */
    public EnvManagementUserJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        populateTable();
        populateOrganizationComboBox();
        // employeeJComboBox.removeAllItems();        
    }

    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) tbl_User.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) tbl_User.getModel()).addRow(row);
            }
        }
    }
    
    public void populateOrganizationComboBox() {
        combo_Org.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            combo_Org.addItem(organization);
        }
    }

    public void populateEmployeeComboBox(Organization organization) {
        combo_Emp.removeAllItems();

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            combo_Emp.addItem(employee);
        }
    }

    private void populateRoleComboBox(Organization organization) {
        combo_Roles.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            combo_Roles.addItem(role);
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

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_User = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        combo_Org = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        combo_Emp = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        combo_Roles = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_Username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JTextField();
        btn_Back = new javax.swing.JButton();
        btn_Resolve = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Environment Management User");

        tbl_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User_name", "Role"
            }
        ));
        jScrollPane1.setViewportView(tbl_User);

        jLabel1.setText("Organization");

        combo_Org.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_OrgActionPerformed(evt);
            }
        });

        jLabel2.setText("Employee");

        combo_Emp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Roles");

        combo_Roles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("UserNAme");

        txt_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameActionPerformed(evt);
            }
        });

        jLabel5.setText("Password");

        txt_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PasswordActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_Org, 0, 139, Short.MAX_VALUE)
                                    .addComponent(combo_Emp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_Roles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Resolve)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_Org, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(combo_Roles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Back)
                    .addComponent(btn_Resolve))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameActionPerformed

    private void txt_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordActionPerformed

    private void combo_OrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_OrgActionPerformed
        // TODO add your handling code here:
          Organization organization = (Organization) combo_Org.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }

    }//GEN-LAST:event_combo_OrgActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_BackActionPerformed

    private void btn_ResolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResolveActionPerformed
        // TODO add your handling code here:
         String name = txt_Username.getText();
        String pss = txt_Password.getText();
            if (name.isEmpty() || pss.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No field should be blank");
            } else {
        String userName = txt_Username.getText();
        char[] passwordCharArray = txt_Password.getPassword();
        String password = String.valueOf(passwordCharArray);
        Organization organization = (Organization) combo_Org.getSelectedItem();
        Employee employee = (Employee) combo_Emp.getSelectedItem();
        Role role = (Role) combo_Roles.getSelectedItem();
        if (employee == null) {
            JOptionPane.showMessageDialog(null, "You cannot add user account as employee combo box is empty");
        } else if (business.checkIfUsernameIsUnique(userName)) {
            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        } else {
            JOptionPane.showMessageDialog(null, "Username should be unique");

        }
        //enterprise.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        //Add the organization to the enterprise
        populateTable();
        JOptionPane.showMessageDialog(null, "User created Succesfully");
            }
    }//GEN-LAST:event_btn_ResolveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Resolve;
    private javax.swing.JComboBox<String> combo_Emp;
    private javax.swing.JComboBox<String> combo_Org;
    private javax.swing.JComboBox<String> combo_Roles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_User;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}