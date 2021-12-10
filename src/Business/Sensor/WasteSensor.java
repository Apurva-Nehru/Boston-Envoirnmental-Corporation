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
public class WasteSensor extends Sensor {
    private float WasteContainerThreshholdValue = 200;
    Random rndm = new Random();
    private float currentlevel = 50+rndm.nextInt(300);
    
    private Map<Date, Float> sensorResponseValues = new HashMap<>();
    
    public WasteSensor()
   {
       Date dte = new Date();
       sensorResponseValues.put(dte, currentlevel);
   }

    public float getCurrentlevel() {
        return currentlevel;
    }

    public void setCurrentlevel(float currentlevel) {
        Date dte = new Date();
        sensorResponseValues.put(dte, currentlevel);
        this.currentlevel = currentlevel;
    }    

    public float getWasteContainerThreshholdValue() {
        return WasteContainerThreshholdValue;
    }

    public void setWasteContainerThreshholdValue (float WasteContainerThreshholdValue) {
        this. WasteContainerThreshholdValue = WasteContainerThreshholdValue;
    }

    public Map<Date, Float> getsensorResponseValues() {
        return sensorResponseValues;
    }

    public void setSensorValues(Map<Date, Float> sensorResponseValues) {
        this.sensorResponseValues = sensorResponseValues;
    }

}
