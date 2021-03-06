/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnvSensorWorkArea;

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
public class EnvironmentSensorEmployeeJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    /**
     * Creates new form EnvironmentSensorEmployeeJPanel
     */
    public EnvironmentSensorEmployeeJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDir) {
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
        Combo_organizationEmp.removeAllItems();

        for (Organization organization : organizationDir.getOrganizationList()) {
            Combo_organizationEmp.addItem(organization);
        }
    }
    
    private void populateTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) tbl_emp.getModel();

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
        Combo_organizationEmp = new javax.swing.JComboBox();
        txt_Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_emp = new javax.swing.JTable();
        btn_Back = new javax.swing.JButton();
        btn_create = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("View Employees");
        add(jLabel4);
        jLabel4.setBounds(80, 33, 270, 29);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Organization");
        add(jLabel1);
        jLabel1.setBounds(80, 85, 116, 22);

        combo_Org.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_Org.setForeground(new java.awt.Color(0, 0, 51));
        combo_Org.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_OrgActionPerformed(evt);
            }
        });
        add(combo_Org);
        combo_Org.setBounds(264, 86, 184, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Add Employee");
        add(jLabel5);
        jLabel5.setBounds(80, 336, 280, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Organization");
        add(jLabel3);
        jLabel3.setBounds(80, 398, 160, 22);

        Combo_organizationEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Combo_organizationEmp.setForeground(new java.awt.Color(0, 0, 51));
        Combo_organizationEmp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(Combo_organizationEmp);
        Combo_organizationEmp.setBounds(291, 398, 250, 23);

        txt_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Name.setForeground(new java.awt.Color(0, 0, 51));
        add(txt_Name);
        txt_Name.setBounds(291, 451, 250, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");
        add(jLabel2);
        jLabel2.setBounds(80, 450, 90, 22);

        tbl_emp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_emp);

        add(jScrollPane2);
        jScrollPane2.setBounds(70, 149, 461, 95);

        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back_Final.png"))); // NOI18N
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });
        add(btn_Back);
        btn_Back.setBounds(80, 533, 95, 40);

        btn_create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/create.png"))); // NOI18N
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });
        add(btn_create);
        btn_create.setBounds(408, 533, 120, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_OrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_OrgActionPerformed
        Organization organization = (Organization) combo_Org.getSelectedItem();
        if (organization != null) {
            populateTable(organization);
        }
    }//GEN-LAST:event_combo_OrgActionPerformed

    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization) Combo_organizationEmp.getSelectedItem();
        //        if (organization instanceof ConsumerOrganization) {
            //            JOptionPane.showMessageDialog(null, "You cannot add the consumer that is responsiblity of Global Manager");
            //        } else {
            String name = txt_Name.getText();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "An Employee must have a name");
            } else {
                organization.getEmployeeDirectory().createEmployee(name);
                populateTable(organization);
                JOptionPane.showMessageDialog(null, "Employee created Succefully");
            }
    }//GEN-LAST:event_btn_createActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
           userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_organizationEmp;
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_create;
    private javax.swing.JComboBox combo_Org;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_emp;
    private javax.swing.JTextField txt_Name;
    // End of variables declaration//GEN-END:variables
}
