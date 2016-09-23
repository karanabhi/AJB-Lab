
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author student
 */
public interface RemoteInterface extends Remote{

    double add(double num1, double num2) throws RemoteException;

    double sub(double num1, double num2) throws RemoteException;

    double mul(double num1, double num2) throws RemoteException;

    double div(double num1, double num2) throws RemoteException;

    double power(double num1, double num2) throws RemoteException;

}//RemoteInterface
