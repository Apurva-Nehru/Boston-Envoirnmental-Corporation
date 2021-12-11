/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import Business.Sensor.Sensor.SensorType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apurv
 */
public class SensorDirectory {
    private ArrayList<Sensor> sensorList;
    
    private Map<String, Float> airPollutionSensorResponseValues = new HashMap<>();
    private Map<String, Float> noisePollutionSensorResponseValues = new HashMap<>();
    private Map<String, Float> floodManagementSensorResponseValues = new HashMap<>();
    private Map<String, Float> wasteSensorResponseValues = new HashMap<>();    
    
    public SensorDirectory()
    {
        sensorList = new ArrayList<Sensor>();
    }
    
    public Sensor createSensor(SensorType type)
    {
        Sensor sensor = null;
        
        if (type.getValue().equals(SensorType.AirPollutionSensor.getValue())){
            sensor = new AirPollutionSensor();
            sensorList.add(sensor);
        }
        
        else if (type.getValue().equals(SensorType.FloodManagementSensor.getValue())){
            sensor = new FloodManagementSensor();
            sensorList.add(sensor);
        }
        
        else if (type.getValue().equals(SensorType.WasteSensor.getValue())){
            sensor = new WasteSensor();
            sensorList.add(sensor);
        }
        
        else if (type.getValue().equals(SensorType.NoisePollutionSensor.getValue())){
            sensor = new NoisePollutionSensor();
            sensorList.add(sensor);
        }        
        return sensor;
    }

    public Map<String, Float> getAirPollutionSensorResponseValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof AirPollutionSensor)
            {
                AirPollutionSensor ap = (AirPollutionSensor) sensorList.get(i);
                airPollutionSensorResponseValues.put(ap.getZipcode(), ap.getAirQualityIndex());
            }
        }
        return airPollutionSensorResponseValues;
    }
    

    public Map<String, Float> getNoisePollutionSensorResponseValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof NoisePollutionSensor)
            {
                NoisePollutionSensor np = (NoisePollutionSensor) sensorList.get(i);
                noisePollutionSensorResponseValues.put(np.getZipcode(), np.getNoiseLevelInDecibel());
            }
        }
        return noisePollutionSensorResponseValues;
    }

    public Map<String, Float> getFloodManagementSensorResponseValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof FloodManagementSensor)
            {
                FloodManagementSensor fm = (FloodManagementSensor) sensorList.get(i);
                floodManagementSensorResponseValues.put(fm.getZipcode(), fm.getCurrentlevel());
            }
        }
        return floodManagementSensorResponseValues;
    }

    public Map<String, Float> getWasteManagementSensorResponseValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof WasteSensor)
            {
                WasteSensor ws = (WasteSensor) sensorList.get(i);
                wasteSensorResponseValues.put(ws.getZipcode(), ws.getCurrentlevel());
            }
        }        
        return wasteSensorResponseValues;
    }




}
