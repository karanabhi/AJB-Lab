
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author Abhishek Karan
 */
public class InterfaceImpl extends UnicastRemoteObject implements RemoteInterface{

    public InterfaceImpl() throws RemoteException {
        //super();
    }

    @Override
    public double add(double num1, double num2) throws RemoteException {
        return (num1 + num2);
    }

    @Override
    public double sub(double num1, double num2) throws RemoteException {
        return (num1 - num2);
    }

    @Override
    public double mul(double num1, double num2) throws RemoteException {
        return (num1 * num2);
    }

    @Override
    public double div(double num1, double num2) throws RemoteException {
        return (num1 / num2);
    }

    @Override
    public double power(double num1, double num2) throws RemoteException {
        return (Math.pow(num1, num2));
    }

}//interfaceImpl
