/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author apurv
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employee_List;

    public EmployeeDirectory() {
        employee_List = new ArrayList();
    }

    public Employee createEmployee(String name){
        Employee emp = new Employee();
        emp.setName(name);
        employee_List.add(emp);
        return emp;
    }
    public ArrayList<Employee> getEmployeeList() {
        return employee_List;
    }
    
    
}