/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.util.ArrayList;
/**
 *
 * @author apurv
 */
public class FloodManagementSensorDirectory {
    private ArrayList<FloodManagementSensor>  FloodManagementSensor;
    
    public FloodManagementSensorDirectory()
    {
        FloodManagementSensor = new ArrayList< FloodManagementSensor>();
    }

    public ArrayList< FloodManagementSensor > getFloodManagementSensor () {
        return FloodManagementSensor;
    }

    public void setFloodManagementSensor (ArrayList<FloodManagementSensor> FloodManagementSensor) {
        this. FloodManagementSensor = FloodManagementSensor;
    }
    
    public FloodManagementSensor addFloodManagementSensor()
    {
        FloodManagementSensor floodManagementSensor = new FloodManagementSensor ();
        FloodManagementSensor.add(floodManagementSensor);
        return floodManagementSensor;
    }

}
