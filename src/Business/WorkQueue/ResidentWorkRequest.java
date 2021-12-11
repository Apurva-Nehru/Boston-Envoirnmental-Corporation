/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensor.AirPollutionSensor;
import Business.Sensor.FloodManagementSensor;
import java.util.ArrayList;
/**
 *
 * @author aishw
 */
public class ResidentWorkRequest extends WorkRequest{
    private AirPollutionSensor airPollutionSensor;
    private ArrayList<FloodManagementSensor> floodManagementSensorList;
    private String AirPollutionMessage;
    private String FloodManagementMessage; 

    public AirPollutionSensor getAirPollutionSensor() {
        return airPollutionSensor;
    }

    public void setAirPollutionSensor(AirPollutionSensor airPollutionSensor) {
        this.airPollutionSensor = airPollutionSensor;
    }

    public String getAirPollutionMessage() {
        return AirPollutionMessage;
    }

    public void setAirPollutionMessage(String AirPollutionMessage) {
        this.AirPollutionMessage = AirPollutionMessage;
    }

    public String getFloodManagementMessage() {
        return FloodManagementMessage;
    }

    public void setFloodManagementMessage(String FloodManagementMessage) {
        this.FloodManagementMessage = FloodManagementMessage;
    }
    
    public ArrayList<FloodManagementSensor> getFloodManagementSensorList() {
        return floodManagementSensorList;
    }

    public void setFloodManagementSensorList(ArrayList<FloodManagementSensor> floodManagementSensorList) {
        this.floodManagementSensorList = floodManagementSensorList;
    }
    
}
