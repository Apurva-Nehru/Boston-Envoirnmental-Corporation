/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.util.ArrayList;
/**
 *
 * @author apurv
 */
public class NoisePollutionSensorDirectory extends Sensor {
       private ArrayList<NoisePollutionSensor>  NoisePollutionSensor;
    
    public NoisePollutionSensorDirectory(){
        NoisePollutionSensor = new ArrayList<NoisePollutionSensor>();
    }

    public ArrayList<NoisePollutionSensor> getNoisePollutionSensor() {
        return NoisePollutionSensor;
    }

    public void setNoisePollutionSensor(ArrayList<NoisePollutionSensor> NoisePollutionSensor) {
        this.NoisePollutionSensor= NoisePollutionSensor;
    }
    
    public NoisePollutionSensor addNoisePollutionSensor()
    {
        NoisePollutionSensor noisePollutionSensor = new NoisePollutionSensor();
        NoisePollutionSensor.add(noisePollutionSensor);
        return noisePollutionSensor;
    }

}
