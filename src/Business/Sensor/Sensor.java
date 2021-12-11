/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apurv
 */
public class Sensor {
    private String sensorIdStr;
    private int sensorId;
    private static int count = 1;
    private String zipcode;
    private String location;
    private String latitude;
    private String longitude;

    int randomVal = 50;
    private Map<Integer, Integer> testMap= new HashMap<Integer, Integer>();
    
    public enum SensorType {

        AirPollutionSensor("Air Pollution Sensor"), 
        NoisePollutionSensor("Noise Pollution Sensor"), 
        WasteSensor("Waste Sensor"),
        FloodManagementSensor("Flood Management Sensor");
        private String value;
        
        private SensorType(String value) {
            this.value = value;
}
        public String getValue() {
            return value;
        }
    }
        public Sensor(){
        sensorId=count;
        count++;
        randomVal+=20;
        
        sensorIdStr = String.valueOf(sensorId);
        testMap.put(sensorId, randomVal);
    }
        public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
     public Map<Integer, Integer> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<Integer, Integer> testMap) {
        this.testMap = testMap;
    }
    @Override
     public String toString(){
         return sensorIdStr;
     }
}