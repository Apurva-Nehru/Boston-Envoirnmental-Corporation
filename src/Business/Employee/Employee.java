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
    private  static int count=1;
    
    public Employee(){
        id = count;
        count++;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

   

    @Override
    public String toString() {
        return Name;
    }
    
    
}
