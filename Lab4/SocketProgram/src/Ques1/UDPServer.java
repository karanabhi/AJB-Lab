package Ques1;

import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class UDPServer {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            DatagramSocket dgs = new DatagramSocket(1121);
            byte[] buf = new byte[1024];

            DatagramPacket dgp = new DatagramPacket(buf, buf.length);
            dgs.receive(dgp);
            String str = new String(dgp.getData(), 0, dgp.getLength());
            System.out.println("Server:" + str);

            //System.out.println("Enter Message:");
            //str = sc.nextLine();
            dgs.send(dgp);
            dgs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main()

}//class
