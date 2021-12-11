/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessWorkQueue;

import Business.Sensor.Sensor;
import Business.UserAccount.UserAccount;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 *
 * @author aishw
 */
public class WorkRequest {
    private String Work_Queue_id;
    private static int count = 1;
    
    private String msg;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date rqstDate;
    private Date rslvDate;
    private Long zipcode;
    
    public WorkRequest(){
       rqstDate = new Date();
       Work_Queue_id = "Work Request "+count++;
    }
    public String getWork_Queue_id() {
        return Work_Queue_id;
    }

    public void setWork_Queue_id(String Work_Queue_id) {
        this.Work_Queue_id = Work_Queue_id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkRequest.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRqstDate() {
        return rqstDate;
    }

    public void setRqstDate(Date rqstDate) {
        this.rqstDate = rqstDate;
    }

    public Date getRslvDate() {
        return rslvDate;
    }

    public void setRslvDate(Date rslvDate) {
        this.rslvDate = rslvDate;
    }

    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }
    @Override
    public String toString() {
        return Work_Queue_id;
    }

}
