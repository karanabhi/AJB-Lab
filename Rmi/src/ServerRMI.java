
import java.rmi.Naming;

/**
 *
 * @author Abhishek Karan
 */
public class ServerRMI {

    public static void main(String[] args) {

        try {
            InterfaceImpl ii = new InterfaceImpl();
            Naming.rebind("ServerRMI", ii);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//try-catch
    }//main()
}//Server class
