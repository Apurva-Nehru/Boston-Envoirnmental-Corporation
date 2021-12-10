/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author apurv
 */
public class Employee {
    
    private String Name;
    private int id;
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    
    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name;
    }
    
    
}
