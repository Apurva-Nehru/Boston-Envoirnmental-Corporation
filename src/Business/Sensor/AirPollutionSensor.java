/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author aishw
 */
public class AirPollutionSensor {
    Random rndm = new Random();
    int minimum = 140;
    int maximum = 200;
    private float airQualityIndex = rndm.nextInt(maximum - minimum) + minimum;
    
    private Map<Date, Float> sensorResponseValues = new HashMap<>();
    
    public AirPollutionSensor()
   {
       Date dat = new Date();
       sensorResponseValues.put(dat, airQualityIndex);
   }
    
    public float getAirQualityIndex() {
        return airQualityIndex;
    }
    
    public void setAirQualityIndex(float airQualityIndex) {
        Date dt = new Date();
        sensorResponseValues.put(dt, airQualityIndex);
        this.airQualityIndex = airQualityIndex;
    }
    public void setAQIOnRequest(float aq){
        airQualityIndex = aq;
    }

    public Map<Date, Float> getSensorResponseValues() {
        return sensorResponseValues;
    }

    public void setSensorResponseValues(Map<Date, Float> sensorResponseValues) {
        this.sensorResponseValues = sensorResponseValues;
    }

}
