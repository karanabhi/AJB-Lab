
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Abhishek Karan
 */
public interface RemoteInterface2 extends Remote{

    String con(String str,String str2) throws RemoteException;

    int leng(String str) throws RemoteException;

    String uCase(String str) throws RemoteException;

    String lCase(String str) throws RemoteException;    

}//RemoteInterface
