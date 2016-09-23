
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author Abhishek Karan
 */
public class InterfaceImpl3 extends UnicastRemoteObject implements RemoteInterface3{

    public InterfaceImpl3() throws RemoteException {
   
    }

    @Override
    public int[] bbSort(int[] arr) throws RemoteException {
     
	int temp;
	for(int i=0;i<arr.length-1;i++){
		for(int j=0;j<arr.length-i-1;j++){
			if(arr[j]>arr[j+1])
			{
			  temp=arr[j+1];
			  arr[j+1]=arr[j];
			  arr[j]=temp;	  	
			}
		}
	}
	return (arr);
    }

}//interfaceImpl
