/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Role.AirPollutionManagementRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aishw
 */
public class AirPollutionOrganization extends Organization{
     public AirPollutionOrganization() {
        super(EnvironmentManagementType.AirPollutionSolution.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AirPollutionManagementRole());
        return roles;
    } 
}
