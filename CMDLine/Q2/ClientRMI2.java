
import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class ClientRMI2 {

    public static void main(String[] args) {

        try {

            String addServerURL = "rmi://localhost/ServerRMI2";
            RemoteInterface2 ri = (RemoteInterface2) Naming.lookup(addServerURL);

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter First String:");
            String str= sc.next();
            System.out.println("Enter Second String:");
	    String str2= sc.next();

            System.out.println("Concatenation:" + ri.con(str, str2));
            System.out.println("Length:" + ri.leng(str));
            System.out.println("Upper Case:" + ri.uCase(str));
            System.out.println("Lower Case:" + ri.lCase(str));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main()

}//Client class
