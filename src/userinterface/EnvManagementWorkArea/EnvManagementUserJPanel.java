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

import Business.Role.Roles;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aishw
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

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }
        }
    }
    
    public void populateOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }

    public void populateEmployeeComboBox(Organization organization) {
        employeeJComboBox.removeAllItems();

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            employeeJComboBox.addItem(employee);
        }
    }

    private void populateRoleComboBox(Organization organization) {
        roleJComboBox.removeAllItems();
        for (Roles role : organization.getSupportedRole()) {
            roleJComboBox.addItem(role);
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
        userJTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        backjButton1 = new javax.swing.JButton();
        createUserJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        userJTable.setBackground(new java.awt.Color(234, 234, 249));
        userJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userJTable.setForeground(new java.awt.Color(0, 0, 51));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 71, 537, 190);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Organization");
        add(jLabel5);
        jLabel5.setBounds(50, 313, 140, 22);

        organizationJComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(0, 0, 51));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox);
        organizationJComboBox.setBounds(337, 314, 250, 23);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Employee");
        add(jLabel3);
        jLabel3.setBounds(50, 355, 130, 22);

        employeeJComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        employeeJComboBox.setForeground(new java.awt.Color(0, 0, 51));
        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(employeeJComboBox);
        employeeJComboBox.setBounds(337, 356, 250, 23);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Role");
        add(jLabel4);
        jLabel4.setBounds(50, 397, 100, 22);

        roleJComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roleJComboBox.setForeground(new java.awt.Color(0, 0, 51));
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        add(roleJComboBox);
        roleJComboBox.setBounds(337, 398, 250, 23);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(50, 450, 190, 22);

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(0, 0, 51));
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        add(nameJTextField);
        nameJTextField.setBounds(336, 451, 250, 23);

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 51));
        add(txtPassword);
        txtPassword.setBounds(336, 493, 250, 23);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(50, 492, 110, 22);

        backjButton1.setBackground(new java.awt.Color(255, 255, 255));
        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back_Final.png"))); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1);
        backjButton1.setBounds(50, 546, 80, 50);

        createUserJButton.setBackground(new java.awt.Color(255, 255, 255));
        createUserJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createUserJButton.setForeground(new java.awt.Color(51, 51, 51));
        createUserJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/create.png"))); // NOI18N
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton);
        createUserJButton.setBounds(250, 550, 80, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Environment Management User");
        add(jLabel6);
        jLabel6.setBounds(100, 24, 410, 29);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_employee.png"))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(0, 70, 640, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
          String name = nameJTextField.getText();
        String pss = txtPassword.getText();
            if (name.isEmpty() || pss.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No field should be blank");
            } else {
        String userName = nameJTextField.getText();
        char[] passwordCharArray = txtPassword.getPassword();
        String password = String.valueOf(passwordCharArray);
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        Employee employee = (Employee) employeeJComboBox.getSelectedItem();
        Roles role = (Roles) roleJComboBox.getSelectedItem();
        if (employee == null) {
            JOptionPane.showMessageDialog(null, "You cannot add user account as employee combo box is empty");
        } else if (business.UniqueUserName(userName)) {
            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        } else {
            JOptionPane.showMessageDialog(null, "Username should be unique");

        }
        //enterprise.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        //Add the organization to the enterprise
        populateTable();
        JOptionPane.showMessageDialog(null, "User created Succesfully");
            }
    }//GEN-LAST:event_createUserJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
