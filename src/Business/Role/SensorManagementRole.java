/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.EnvironmentSensorOrganization;
import Business.Oragnization.Organization;
import Business.UserAccount.UserAccount;

import userinterface.EnvironmentSensorEnterprise.SensorManagement.SensorManagementWorkArea;
import javax.swing.JPanel;


/**
 *
 * @author aishw
 */
public class SensorManagementRole extends Roles {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SensorManagementWorkArea(userProcessContainer, account, (EnvironmentSensorOrganization)organization, enterprise, business);
    }
}
