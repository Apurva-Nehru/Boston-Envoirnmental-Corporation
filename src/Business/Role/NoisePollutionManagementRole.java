/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.NoisePollutionOrganization;
import Business.Oragnization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.EnvironmentSensorEnterprise.NoisePollutionManagement.ViewNoisePollutionWorkQueueJPanel;
import javax.swing.JPanel;
import userinterface.EnvManagementRoles.NoisePollutionManagementWorkQueueJPanel;
import userinterface.EnvManagementRoles.NoisePollutionWorkAreaJPanel;
/**
 *
 * @author apurv
 */
public class NoisePollutionManagementRole extends Roles{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
      return new NoisePollutionWorkAreaJPanel(userProcessContainer, account, (NoisePollutionOrganization)organization, enterprise,business);
    }
    
}
