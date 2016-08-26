package Ques1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class TCPServer {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(1121);
            Socket sock = ss.accept();
            DataInputStream dis = new DataInputStream(sock.getInputStream());

            String str = (String) dis.readUTF();
            System.out.println("Server:" + str);
            System.out.println("Enter Message:");

            str = sc.nextLine();
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            dos.writeUTF(str);

            sock.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main

}//class
