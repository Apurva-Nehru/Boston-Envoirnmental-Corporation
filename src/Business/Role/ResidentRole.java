/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.ResidentOrganization;
import Business.Oragnization.GovOrg;
import Business.Oragnization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.ResidentOrganization.ResidentWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author aishw
 */
public class ResidentRole extends Roles{
    
@Override
public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
return new ResidentWorkAreaJPanel(userProcessContainer, account, (ResidentOrganization) organization, enterprise, system);
}
}
