/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.util.ArrayList;
/**
 *
 * @author aishw
 */
public class AirPollutionSesnorDirectory {
    private ArrayList<AirPollutionSensor>  AirPollutionSensor;
    
    public AirPollutionSesnorDirectory()
    {
        AirPollutionSensor = new ArrayList<AirPollutionSensor>();
    }

    public ArrayList<AirPollutionSensor> getAirPollutionSensor() {
        return AirPollutionSensor;
    }

    public void setAirPollutionSensor(ArrayList<AirPollutionSensor> AirPollutionSensors) {
        this.AirPollutionSensor = AirPollutionSensor;
    }
    
    public AirPollutionSensor addAirPollutionSensor()
    {
        AirPollutionSensor airPollutionSensor = new AirPollutionSensor();
        AirPollutionSensor.add(airPollutionSensor);
        return airPollutionSensor;
    }
}
