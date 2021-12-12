/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.EnvSensorWorkArea.EnvironmentSensorAdminWorkAreaJPanel;
import javax.swing.JPanel;


/**
 *
 * @author aishw
 */
public class EnvironmentSensorAdminRole extends Roles {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new EnvironmentSensorAdminWorkAreaJPanel(userProcessContainer, enterprise, business);
    }

}
