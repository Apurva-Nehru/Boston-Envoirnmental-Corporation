/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessWorkQueue;

import Business.Sensor.WasteSensor;


/**
 *
 * @author aishw
 */
public class WasteManagementWorkRequest extends WorkRequest{
    private WasteSensor wastesensor;
    private String msg; 

    public WasteSensor getWastesensor() {
        return wastesensor;
    }

    public void setWastesensor(WasteSensor wastesensor) {
        this.wastesensor = wastesensor;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
