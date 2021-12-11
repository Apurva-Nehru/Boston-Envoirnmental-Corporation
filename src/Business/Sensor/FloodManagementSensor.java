/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author apurv
 */
public class FloodManagementSensor extends Sensor {
    private float waterbodyThreshhold = 200;
     Random rndm = new Random();
    private float currentlevel= 50+rndm.nextInt(300);

    private Map<Date, Float> sensorResponseValues = new HashMap<Date, Float>();
    
    public FloodManagementSensor()
   {
       Date dte = new Date();
       sensorResponseValues.put(dte, currentlevel);
   }
    
    public float getWaterbodyThreshhold () {
        return waterbodyThreshhold;
    }

    public void setWaterbodyThreshhold (float waterbodyThreshhold) {
        this. waterbodyThreshhold = waterbodyThreshhold;
    }   

    public float getCurrentlevel() {
        return currentlevel;
    }

    public void setCurrentlevel(float currentlevel) {
        Date dte = new Date();
        sensorResponseValues.put(dte, currentlevel);
        this.currentlevel = currentlevel;
    }

    public Map<Date, Float> getSensorResponseValues() {
        return sensorResponseValues;
    }

    public void setSensorResponseValues(Map<Date, Float> sensorResponseValues) {
        this.sensorResponseValues = sensorResponseValues;
    }

}
