/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Role.ResidentRole;
import Business.Role.GovernmentOfficialRole;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author aishw
 */
public class ResidentOrganization extends Organization {
    public ResidentOrganization(){
    super (GovernmentType.Resident.getValue());
   }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ResidentRole());
        return roles;
    }
    
}
