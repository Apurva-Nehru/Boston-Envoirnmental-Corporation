/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import Business.Oragnization.GovOrg;
import Business.UserAccount.UserAccount;
import userinterface.GovOfficialOrgRole.GovernmentOfficialWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author apurv
 */
public class GovernmentOfficialRole extends Roles{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new GovernmentOfficialWorkAreaJPanel(userProcessContainer, account, (GovOrg)organization, enterprise, business); //To change body of generated methods, choose Tools | Templates.
    }
    
}
