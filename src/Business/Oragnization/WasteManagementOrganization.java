/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;
import Business.Role.Roles;
import java.util.ArrayList;
import Business.Oragnization.Organization.EnvironmentManagementType;
import Business.Role.WasteManagementRole;

/**
 *
 * @author aishw
 */
public class WasteManagementOrganization extends Organization {
    public WasteManagementOrganization() {
        super(EnvironmentManagementType.WasteManagement.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new WasteManagementRole());
        return roles;
}
}
