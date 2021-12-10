/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.util.ArrayList;

/**
 *
 * @author aishw
 */
public class HeadSensorDirectory {
    private ArrayList<Sensor>  Sensor;
    
    public HeadSensorDirectory()
    {
        Sensor = new ArrayList<Sensor>();
    }

    public ArrayList<Sensor> getSensor() {
        return Sensor;
    }

    public void setSensor(ArrayList<Sensor> Sensor) {
        this.Sensor = Sensor;
    }

}
