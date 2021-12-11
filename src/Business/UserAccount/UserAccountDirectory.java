/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Roles;
import java.util.ArrayList;
/**
 *
 * @author aishw
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }
    
    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount useracc : userAccountList)
            if (useracc.getUsname().equals(usname)) && useracc.getPswd().equals(pswd)){
                return useracc;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Roles role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsname(username);
        userAccount.setPswd(password);
        userAccount.setEmp(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean CheckUniqueUsername(String username){
        for (UserAccount useracc : userAccountList){
            if (useracc.getUsname().equals(username))
                return false;
        }
        return true;
    }
}
