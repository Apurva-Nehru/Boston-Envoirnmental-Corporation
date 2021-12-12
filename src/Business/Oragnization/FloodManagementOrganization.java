/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Role.FloodManagementRole;
import Business.Role.Roles;
import java.util.ArrayList;
/**
 *
 * @author aishw
 */
public class FloodManagementOrganization extends Organization {
    public FloodManagementOrganization() {
        super(EnvironmentManagementType.FloodManagement.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new FloodManagementRole());
        return roles;
    } 
}
