package Ques1;

import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class UDPClient {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Message:");
            String str = sc.nextLine();

            DatagramSocket dgs = new DatagramSocket();

            InetAddress ina = InetAddress.getByName("127.0.0.1");

            DatagramPacket dgp = new DatagramPacket(str.getBytes(), str.length(), ina, 1121);

            dgs.send(dgp);
            dgs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main()

}//class
