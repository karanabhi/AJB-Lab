package Ques1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class TCPClient {

    public static void main(String[] args) {

        try {
            Socket sock = new Socket("localhost", 1121);
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            System.out.println("Enter Message:");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            dos.writeUTF(str);

            DataInputStream dis = new DataInputStream(sock.getInputStream());
            System.out.println("Client:" + (String) dis.readUTF());

            dos.flush();
            dos.close();
            sock.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//main()

}//class
