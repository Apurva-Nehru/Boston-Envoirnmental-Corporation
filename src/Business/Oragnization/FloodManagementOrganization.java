/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

/**
 *
 * @author aishw
 */
public class FloodManagementOrganization extends Organization {
    public FloodManagementOrganization() {
        super(EnvironmentManagementType.FloodManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FloodManagementRole());
        return roles;
    } 
}
