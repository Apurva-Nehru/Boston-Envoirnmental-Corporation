/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Oragnization;

import Business.Oragnization.Organization.EnvironmentManagementType;
import static Business.Oragnization.Organization.EnvironmentManagementType.AirPollution;
import Business.Oragnization.Organization.EnvironmentSensorManagementType;
import Business.Oragnization.Organization.GovernmentType;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author apurv
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
     public Organization createEnvironmentManagement(EnvironmentManagementType type){
        Organization organization = null; 


        boolean isOrganizationOfAirPollutionExist = false;
        boolean isOrganizationOfNoisePollutionExist = false;
        boolean isOrganizatonOfWasteManagementExist = false;
        boolean isOrganizatonOfFloodManagementExist = false;
        
        for (Organization orgzn : organizationList) {
            if (orgzn instanceof AirPollutionOrganization) {
                isOrganizationOfAirPollutionExist = true;
                break;
            } else {
                isOrganizationOfAirPollutionExist = false;
            }
        }
        
        for (Organization orgzn : organizationList) {
            if (orgzn instanceof NoisePollutionOrganization) {
                isOrganizationOfNoisePollutionExist = true;
                break;
            } else {
                isOrganizationOfNoisePollutionExist = false;
            }
        }
        
        for (Organization orgzn : organizationList) {
            if (orgzn instanceof WasteManagementOrganization) {
                isOrganizatonOfWasteManagementExist = true;
                break;
            } else {
                isOrganizatonOfWasteManagementExist = false;
            }
        }
        
        for (Organization orgzn : organizationList) {
            if (orgzn instanceof FloodManagementOrganization) {
                isOrganizatonOfFloodManagementExist = true;
                break;
            } else {
                isOrganizatonOfFloodManagementExist = false;
            }
        }
        
        if (type.getValue().equals(EnvironmentManagementType.AirPollution.getValue())){
            if (!isOrganizationOfAirPollutionExist) {
            organization = new AirPollutionOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Air Pollution Solution Organization for one Enterprise");
            }
        }
        else if (type.getValue().equals(EnvironmentManagementType.NoisePollution.getValue())){
            if(!isOrganizationOfNoisePollutionExist) {
            organization = new NoisePollutionOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Noise Pollution Organization for one Enterprise");
            }
        }
        else if (type.getValue().equals(EnvironmentManagementType.WasteManagement.getValue())){
            if(!isOrganizatonOfWasteManagementExist) {
            organization = new WasteManagementOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Waste Management Organization for one Enterprise");
            }
        }
        else if (type.getValue().equals(EnvironmentManagementType.FloodManagement.getValue())){
            if(!isOrganizatonOfFloodManagementExist) {
            organization = new FloodManagementOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Flood Management Organization for one Enterprise");
            }
        }
        return organization;
    }
    
     public Organization createGovernmentOfficial(GovernmentType type){
         Organization organization = null;
         
         boolean isOrganizationOfGovernmentExist = false;
         boolean isOrganizationOfResidentExist = false;
         
         for (Organization org : organizationList) {
            if (org instanceof GovOrg) {
                isOrganizationOfGovernmentExist = true;
                break;
            } else {
                isOrganizationOfGovernmentExist = false;
            }
        }
         
         for (Organization org : organizationList) {
            if (org instanceof ResidentOrganization) {
                isOrganizationOfResidentExist = true;
                break;
            } else {
                isOrganizationOfResidentExist = false;
            }
        }
         
        if (type.getValue().equals(GovernmentType.GovernmentOfficial.getValue())){
            if(!isOrganizationOfGovernmentExist) {
            organization = new GovOrg();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Government Organization for one Enterprise");
            }
        }
        
        else if (type.getValue().equals(GovernmentType.Resident.getValue())){
            if(!isOrganizationOfResidentExist) {
            organization = new ResidentOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Resident Organization for one Enterprise");
            }
        }
        
        return organization;
     }
     
     public Organization createEnvironmentSensorManagement(EnvironmentSensorManagementType type){
         Organization organization = null;
         
         boolean isOrganizationOfEnvironmentSensorExist = false;
         
         for (Organization org : organizationList) {
            if (org instanceof EnvironmentSensorOrganization) {
                isOrganizationOfEnvironmentSensorExist = true;
                break;
            } else {
                isOrganizationOfEnvironmentSensorExist = false;
            }
        }
         
        if (type.getValue().equals(EnvironmentSensorManagementType.SensorManagement.getValue())){
            if(!isOrganizationOfEnvironmentSensorExist) {
            organization = new EnvironmentSensorOrganization();
            organizationList.add(organization);
            //JOptionPane.showMessageDialog(null, "Organization added Succesfully");
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Environment Sensor Management Organization for one Enterprise");
            }
        }
        
        return organization;
     }
     
     public void DeleteOrganization(Organization org) {
        organizationList.remove(org);
    }
     
}
