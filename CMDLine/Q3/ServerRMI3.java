
import java.rmi.Naming;

/**
 *
 * @author Abhishek Karan
 */
public class ServerRMI3 {

    public static void main(String[] args) {

        try {
            InterfaceImpl3 ii = new InterfaceImpl3();
            Naming.rebind("ServerRMI3", ii);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//try-catch
    }//main()
}//Server class
