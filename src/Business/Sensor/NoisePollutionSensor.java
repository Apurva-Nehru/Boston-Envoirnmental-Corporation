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
public class NoisePollutionSensor extends Sensor {
    Random rndm = new Random();
    int minimum = 70;
    int maximum = 145;
    private float noiseLevelInDecibel = rndm.nextInt(maximum - minimum) + minimum;
    
     private Map<Date, Float> sensorResponseValues = new HashMap<>();
     
     public NoisePollutionSensor()
   {
       Date dte = new Date();
       sensorResponseValues.put(dte, noiseLevelInDecibel);
   }
    
    public float getNoiseLevelInDecibel() {
        //setNoiseLevelInDecibel(rn.nextInt(maximum - minimum) + minimum);
        return noiseLevelInDecibel;
    }

    public void setNoiseLevelInDecibel(float noiseLevelInDecibel) {
        Date dte = new Date();
        sensorResponseValues.put(dte, noiseLevelInDecibel);
        this.noiseLevelInDecibel = noiseLevelInDecibel;
    }    

    public Map<Date, Float> getSensorResponseValues() {
        return sensorResponseValues;
    }

    public void setSensorResponseValues(Map<Date, Float> sensorResponseValues) {
        this.sensorResponseValues = sensorResponseValues;
    }
        

}
