
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class ChatClient {

    Socket clientsock = null;// new Socket("localhost", 1121);
    DataOutputStream dos = null;
    Scanner sc = new Scanner(System.in);
    DataInputStream dis = null;
    String str = null;//sc.nextLine();

    public void Send() {

        Thread ts = new Thread() {

            public void run() {

                while (clientsock.isConnected()) {
                    try {
                        System.out.println("Enter Message:");
                        str = sc.nextLine();
                        synchronized (clientsock) {
                            dos.writeUTF(str);
                        }
                        Thread.sleep(400);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }//try-catch
                }//while
            }//run
        };//threads

        ts.setPriority(Thread.MAX_PRIORITY);
        ts.start();

    }//send()

    public void Receive() {

        Thread tr = new Thread() {

            public void run() {

                while (clientsock.isConnected()) {
                    try {
                        str = dis.readUTF();
                        System.out.println("Message from Server:" + str);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }//try-catch
                }//while
            }//run
        };//threads

        tr.setPriority(Thread.MAX_PRIORITY);
        tr.start();
    }//Receive()

    public void createConnection() {
        try {
            clientsock = new Socket("localhost", 1121);
            dos = new DataOutputStream(clientsock.getOutputStream());
            dis = new DataInputStream(clientsock.getInputStream());
            Receive();
            Send();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//try-catch

    }//createConnection()

    public static void main(String[] args) {

        ChatClient cc = new ChatClient();
        cc.createConnection();

    }//main()

}//class
