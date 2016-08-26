
import javax.swing.JOptionPane;

/**
 *
 * @author Abhishek Karan
 */
public class Employee {

    double salary;
    String name;

    Employee() {
        this.name="Abhi";
        this.salary=100000;
    }//cons()

    static void getInfo(Employee obj) {
        JOptionPane.showMessageDialog(null, "Name:" + obj.name + "\nSalary:" + obj.salary);
    }
    
    static void salChange(double amt,char stat,Employee obj){
        if(stat=='I'){
            obj.salary+=amt;
        }else if(stat=='D'){
            obj.salary-=amt;
        }
    }
    

    public static void main(String[] args) {

        Employee emp = new Employee();
        getInfo(emp);
        salChange(49921, 'I', emp);
        getInfo(emp);
        salChange(505921, 'D', emp);
        getInfo(emp);
        
        
        
        
    }//main()

}//class
