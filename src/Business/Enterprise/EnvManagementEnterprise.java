/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.EnvironmentManagementAdminRole;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author apurv
 */
public class EnvManagementEnterprise extends Enterprise{
    public EnvManagementEnterprise(String name, Enterprise.EnterpriseType type) {
        super(name, type.EnvManagement);
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new EnvironmentManagementAdminRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
}
