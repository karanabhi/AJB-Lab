
import java.rmi.Naming;

/**
 *
 * @author Abhishek Karan
 */
public class ServerRMI2 {

    public static void main(String[] args) {

        try {
            InterfaceImpl2 ii = new InterfaceImpl2();
            Naming.rebind("ServerRMI2", ii);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//try-catch
    }//main()
}//Server class
