/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensor.NoisePollutionSensor;
/**
 *
 * @author aishw
 */
public class NoisePollutionWorkRequest extends WorkRequest{
    private NoisePollutionSensor noisePollutionSensor;
    private String msg; 

    public NoisePollutionSensor getNoisePollutionSensor() {
        return noisePollutionSensor;
    }

    public void setNoisePollutionSensor(NoisePollutionSensor noisePollutionSensor) {
        this.noisePollutionSensor = noisePollutionSensor;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
