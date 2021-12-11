/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Roles;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import javax.management.relation.Role;

/**
 *
 * @author aishw
 */
public abstract class Organization {
 private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    
    public enum EnvironmentManagementType {

        EnvironmentManagementAdmin("Environment Management Admin Organization"), 
        AirPollution("Air Pollution Solution Organization"), 
        NoisePollution("Noise Pollution Solution Organization"),
        FloodManagement("Flood Alert Management"),
        WasteManagement("Waste Management");
        private String value;

        private EnvironmentManagementType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public enum GovernmentType {

        GovernmentAdmin("Government Admin Organization"), 
        GovernmentOfficial("Government Official Organization"),
        Resident("Resident Organization");
        
        private String value;

        private GovernmentType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public enum EnvironmentSensorManagementType {

        EnvironmentSensorAdmin("Environment Sensor Admin Organization"), 
        SensorManagement("Sensor Management Organization");
        private String value;

        private EnvironmentSensorManagementType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
       
}
