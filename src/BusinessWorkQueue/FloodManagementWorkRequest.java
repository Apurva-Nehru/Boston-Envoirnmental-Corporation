/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessWorkQueue;

import Business.Sensor.FloodManagementSensor;
import java.util.ArrayList;
/**
 *
 * @author aishw
 */
public class FloodManagementWorkRequest {
    private ArrayList<FloodManagementSensor> floodManagementsensor;
    private String msg;

    public ArrayList<FloodManagementSensor> getFloodManagementSensor() {
        return floodManagementsensor;
    }

    public void setFloodManagementSensor(ArrayList<FloodManagementSensor> floodManagementSensor) {
        this.floodManagementsensor = floodManagementsensor;
    }
    
    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = msg;
    }
   
}
