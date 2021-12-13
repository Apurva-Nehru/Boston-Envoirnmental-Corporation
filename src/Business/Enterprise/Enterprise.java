/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Roles;
import java.util.ArrayList;
import Business.Oragnization.Organization;
import Business.Oragnization.OrganizationDirectory;


/**
 *
 * @author apurv
 */
public class Enterprise extends Organization{
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
    public ArrayList<Roles> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public enum EnterpriseType {

        EnvManagement("Environmental Management"),
        Government("Government Agency"), 
        SensorManagement("SensorManagement");
        
        private String val;

        private EnterpriseType(String value) {
            this.val = value;
        }

        public String getValue() {
            return val;
        }

        @Override
        public String toString() {
            return val;
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
