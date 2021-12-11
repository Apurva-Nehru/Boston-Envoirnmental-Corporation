/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Role.Roles;
import Business.Role.FloodManagementRole;
import Business.Role.SensorManagementRole;
import Business.Sensor.AirPollutionSesnorDirectory;
import Business.Sensor.FloodManagementSensorDirectory;
import Business.Sensor.WasteSensorDirectory;
import Business.Sensor.NoisePollutionSensorDirectory;
import Business.Sensor.SensorDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author apurv
 */
public abstract class EnvironmentSensorOrganization extends Organization{
    
    
    private SensorDirectory sensorDirectory;
    
    private WorkQueue GovernmentworkQueue;
    
    public EnvironmentSensorOrganization() {
        super(EnvironmentSensorManagementType.SensorManagement.getValue());
        
        sensorDirectory = new SensorDirectory();
    }

    public SensorDirectory getSensorDirectory() {
        return sensorDirectory;
    }

    public void setSensorDirectory(SensorDirectory sensorDirectory) {
        this.sensorDirectory = sensorDirectory;
    }

    public WorkQueue getGovernmentworkQueue() {
        return GovernmentworkQueue;
    }

    public void setGovernmentworkQueue(WorkQueue GovernmentworkQueue) {
        this.GovernmentworkQueue = GovernmentworkQueue;
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new SensorManagementRole());
        return roles;
    }
    
}
