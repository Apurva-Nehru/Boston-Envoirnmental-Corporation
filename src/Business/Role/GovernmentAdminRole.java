/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import javax.swing.JPanel;
import Business.UserAccount.UserAccount;
import userinterface.GovWorkArea.GovernmentAdminWorkAreaJPanel;

/**
 *
 * @author apurv
 */
public class GovernmentAdminRole extends Roles {

   
    public JPanel createWorkArea(JPanel arg0, Object arg1, Organization arg2, Enterprise arg3, EcoSystem arg4) {
        return new GovernmentAdminWorkAreaJPanel(userProcessContainer, enterprise, business); //To change body of generated methods, choose Tools | Templates.
    }
    
}
