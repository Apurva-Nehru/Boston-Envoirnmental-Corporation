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
    
   public boolean AirPollutionSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<AirPollutionSensor> airPollutionSensorList = new ArrayList<AirPollutionSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof AirPollutionSensor)
            {
                AirPollutionSensor airp = (AirPollutionSensor) sensorList.get(i);
                airPollutionSensorList.add(airp);
            }
        }
        
        for(int i=0; i<airPollutionSensorList.size(); i++)
        {
            if(zipcode.equals(airPollutionSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
   
   public boolean NoisePollutionSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<NoisePollutionSensor> noisePollutionSensorList = new ArrayList<NoisePollutionSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof NoisePollutionSensor)
            {
                NoisePollutionSensor noisep = (NoisePollutionSensor) sensorList.get(i);
                noisePollutionSensorList.add(noisep);
            }
        }
        
        for(int i=0; i<noisePollutionSensorList.size(); i++)
        {
            if(zipcode.equals(noisePollutionSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
   
   public boolean FloodManagementSensorSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<FloodManagementSensor> floodManagementSensorList = new ArrayList<FloodManagementSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof FloodManagementSensor)
            {
                FloodManagementSensor flood = (FloodManagementSensor) sensorList.get(i);
                floodManagementSensorList.add(flood);
            }
        }
        
        for(int i=0; i<floodManagementSensorList.size(); i++)
        {
            if(zipcode.equals(floodManagementSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
   public boolean WasteManagementSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<WasteSensor> wasteSensorList = new ArrayList<WasteSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof WasteSensor)
            {
                WasteSensor wastes = (WasteSensor) sensorList.get(i);
                wasteSensorList.add(wastes);
            }
        }
        
        for(int i=0; i<wasteSensorList.size(); i++)
        {
            if(zipcode.equals(wasteSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
    
    
    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(ArrayList<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

}
