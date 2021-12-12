/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.AirPollutionOrganization;
import Business.Oragnization.Organization;
import Business.UserAccount.UserAccount;
import Business.Role.Roles;
import userinterface.EnvManagementRoles.AirPollutionManagementWorkJPanel;
import javax.swing.JPanel;
import userinterface.EnvManagementRoles.AirPollutionManagementWorkQueueJPanel;
/**
 *
 * @author aishw
 */
public class AirPollutionManagementRole extends Roles{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AirPollutionManagementWorkJPanel(userProcessContainer, account, (AirPollutionOrganization)organization, enterprise, business);
    }
}
