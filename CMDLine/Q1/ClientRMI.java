
import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class ClientRMI {

    public static void main(String[] args) {

        try {

            String addServerURL = "rmi://localhost/ServerRMI";
            RemoteInterface ri = (RemoteInterface) Naming.lookup(addServerURL);

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Num1:");
            double num1 = sc.nextDouble();
            System.out.println("Enter Num2:");
            double num2 = sc.nextDouble();

            System.out.println("Addition:" + ri.add(num1, num2));
            System.out.println("Subtraction:" + ri.sub(num1, num2));
            System.out.println("Multiplication:" + ri.mul(num1, num2));
            System.out.println("Division:" + ri.div(num1, num2));
            System.out.println("Power:" + ri.power(num1, num2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main()

}//Client class
