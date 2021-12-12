/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;




import Business.Enterprise.Enterprise;
import Business.Oragnization.Organization;
import Business.Role.Roles;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Network.Network;
import java.util.ArrayList;

/**
 *
 * @author apurv
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
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roleList=new ArrayList<Roles>();
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
    
    public boolean UniqueUserName(String username) {

        for (UserAccount user : this.getUserAccountDirectory().getUserAccountList()) {
          
            if (user.getUsname().equals(username)) {
                return false;
            }
            for (Network network : this.getNetworkList()) {
                for (Enterprise entprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount useracc : entprise.getUserAccountDirectory().getUserAccountList()) {
                    
                        if (useracc.getUsname().equals(username)) {
                            return false;
                        }
                        for (Organization org : entprise.getOrganizationDirectory().getOrganizationList()) {
                            for (UserAccount accOrgn : org.getUserAccountDirectory().getUserAccountList()) {
                               
                                if (accOrgn.getUsname().equals(username)) {
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

        for (Network nwk : this.networkList) {
            if (nwk.getName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }
    
    public void DeleteCity(Network net) {
        networkList.remove(net);
    }
     
    
}
