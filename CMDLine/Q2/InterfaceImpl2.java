
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author Abhishek Karan
 */
public class InterfaceImpl2 extends UnicastRemoteObject implements RemoteInterface2 {

    public InterfaceImpl2() throws RemoteException {

    }

    @Override
    public String con(String str, String str2) throws RemoteException {
       return ((str + str2));
    }

    @Override
    public int leng(String str) throws RemoteException {
        return (str.length());
    }

    @Override
    public String uCase(String str) throws RemoteException {
        return (str.toUpperCase());
    }

    @Override
    public String lCase(String str) throws RemoteException {
       return (str.toLowerCase());
    }
}//interfaceImpl
