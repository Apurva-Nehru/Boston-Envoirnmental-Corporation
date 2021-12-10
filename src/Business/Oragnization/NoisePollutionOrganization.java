/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

//import Business.Oragnization.Organization.EnvironmentManagementType;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author apurv
 */
public class NoisePollutionOrganization {
    public NoisePollutionOrganization() {
        super(EnvironmentManagementType.NoisePollutionSolution.getValue());
    }
    
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NoisePollutionManagementRole());
        return roles;
    }
}
