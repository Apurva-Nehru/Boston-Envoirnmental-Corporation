/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
/**
 *
 * @author aishw
 */
public abstract class Roles {
    public enum RoleType{
        SystemAdmin("Admin"),
        EnvironmentManagementAdmin("Environment Management Admin"),
        EnvironmentSensorAdmin("Environment Sensor Admin"),
        GovernmentAdmin("Government Admin"),
        Resident("Resident"),
        WasteManagement("Waste Management"),
        AirPollutionManagement("Air Pollution Management"),
        NoisePollutionManagement("Noise Pollution Management"),
        FloodManagement("Flood Management"),
        GovernmentOfficial("Government Official");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
