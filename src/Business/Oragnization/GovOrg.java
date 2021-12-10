/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Oragnization.Organization.GovernmentType;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author apurv
 */
public class GovOrg extends Organization {
      public GovOrg() {
        super(GovernmentType.GovernmentOfficial.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new GovernmentOfficialRole());
        return roles;
    }
}
