/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;




import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Network.Network;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization{
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    
    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUsernameIsUnique(String username) {

        for (UserAccount user : this.getUserAccountDirectory().getUserAccountList()) {
          
            if (user.getUsername().equals(username)) {
                return false;
            }
            for (Network network : this.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount useraccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    
                        if (useraccount.getUsername().equals(username)) {
                            return false;
                        }
                        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            for (UserAccount accOrg : org.getUserAccountDirectory().getUserAccountList()) {
                               
                                if (accOrg.getUsername().equals(username)) {
                                    return false;
                                }
                            }

                        }
                    }

                }
            }

        }
        return true;
    }
    
    public boolean checkIfCityNameisUnique(String cityName) {

        for (Network n : this.networkList) {
            if (n.getName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }
    
    public void DeleteCity(Network n) {
        networkList.remove(n);
    }
     
    
}
