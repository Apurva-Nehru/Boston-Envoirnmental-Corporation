/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Roles;
import Business.WorkQueue.WorkQueue;
/**
 *
 * @author aishw
 */
public class UserAccount {
    private String usname;
    private String pswd;
    private Employee emp;
    private Roles role;
    private WorkQueue workQ;

    
    public UserAccount() {
        workQ = new WorkQueue();
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
    
    public WorkQueue getWorkQ() {
        return workQ;
    }

    public void setWorkQ(WorkQueue workQ) {
        this.workQ = workQ;
    }
}
