/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

//import Business.Organization.OrganizationDirectory;
/**
 *
 * @author apurv
 */
public class Enterprise {
     private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum EnterpriseType {

        EnvironmentManagement("Environmental Management"),
        Government("Government Agency"), 
        SensorManagement("SensorManagement");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }


    @Override
    public String toString() {
        return getName();
    }
    

}
