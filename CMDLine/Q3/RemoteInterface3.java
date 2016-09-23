
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author student
 */
public interface RemoteInterface3 extends Remote{

    int[] bbSort(int[] arr) throws RemoteException;

}//RemoteInterface
