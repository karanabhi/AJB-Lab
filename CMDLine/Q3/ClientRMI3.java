
import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class ClientRMI3 {

    public static void main(String[] args) {

        try {

            String addServerURL = "rmi://localhost/ServerRMI3";
            RemoteInterface3 ri = (RemoteInterface3) Naming.lookup(addServerURL);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Array Elements:");
	    int n=sc.nextInt();
	    int arr[]=new int[n];
            System.out.print("Elements:");
		for(int i=0;i<n;i++)
		{
		  arr[i]=sc.nextInt();
		}

	      int[] arr2=ri.bbSort(arr);
		System.out.println("Output:");
		for(int i=0;i<n;i++)
		{
		System.out.print(arr2[i]+"\t");
		}           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main()

}//Client class
