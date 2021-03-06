/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Sensor.HeadSensorDirectory;


/**
 *
 * @author apurv
 */
public class Network {
    
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    public boolean setEnterprise(String name) {
        for (Enterprise ent : enterpriseDirectory.getEnterpriseList()) {
            if (ent.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
