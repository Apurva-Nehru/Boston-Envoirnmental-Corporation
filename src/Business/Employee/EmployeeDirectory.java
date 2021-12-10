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
        Employee employee = new Employee();
        employee.setName(name);
        employee_List.add(employee);
        return employee;
    }
    public ArrayList<Employee> getEmployeeList() {
        return employee_List;
    }
    
    
}