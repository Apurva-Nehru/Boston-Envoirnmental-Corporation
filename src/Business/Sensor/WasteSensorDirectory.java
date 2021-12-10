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
public class WasteSensorDirectory extends Sensor{
    private ArrayList<WasteSensor>  WasteSensor;
    
    public WasteSensorDirectory()
    {
        WasteSensor = new ArrayList< WasteSensor>();
    }

    public ArrayList< WasteSensor> getWasteSensor() {
        return WasteSensor;
    }

    public void setWasteSensor(ArrayList<WasteSensor> WasteSensor) {
        this. WasteSensor = WasteSensor;
    }
    
    public WasteSensor addWasteSensor()
    {
        WasteSensor wasteSensor = new WasteSensor();
        WasteSensor.add(wasteSensor);
        return wasteSensor;
    }

}
