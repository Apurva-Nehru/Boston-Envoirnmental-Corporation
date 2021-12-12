/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

//import Business.Oragnization.Organization.EnvironmentManagementType;
import Business.Role.NoisePollutionManagementRole;
import Business.Role.Roles;
import java.util.ArrayList;
import javax.management.relation.Role;

/**
 *
 * @author apurv
 */
public class NoisePollutionOrganization extends Organization{
    public NoisePollutionOrganization() {
        super(EnvironmentManagementType.NoisePollution.getValue());
    }
    
   
    
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new NoisePollutionManagementRole());
        return roles;
    }
}
