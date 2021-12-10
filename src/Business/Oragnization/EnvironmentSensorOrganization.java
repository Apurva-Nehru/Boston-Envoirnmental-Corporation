/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author apurv
 */
public class EnvironmentSensorOrganization extends Organization {
    
    
    private SensorDir sensorDirectory;
    
    private WorkQueue GovernmentworkQueue;
    
    public EnvironmentSensorOrganization() {
        super(EnvironmentSensorManagementType.SensorManagement.getValue());
        
        sensorDirectory = new SensorDir();
    }

    public SensorDir getSensorDirectory() {
        return sensorDirectory;
    }

    public void setSensorDirectory(SensorDir sensorDirectory) {
        this.sensorDirectory = sensorDirectory;
    }

    public WorkQueue getGovernmentworkQueue() {
        return GovernmentworkQueue;
    }

    public void setGovernmentworkQueue(WorkQueue GovernmentworkQueue) {
        this.GovernmentworkQueue = GovernmentworkQueue;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SensorManagementRole());
        return roles;
    }
    
}
