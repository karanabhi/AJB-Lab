
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan
 */
public class ChatServer {

    ServerSocket serversock = null;//new ServerSocket(1121);
    Socket sock = null;// new Socket("localhost", 1121);
    DataOutputStream dos = null;
    Scanner sc = new Scanner(System.in);
    DataInputStream dis = null;
    String str = null;//sc.nextLine();

    public void Send() {

        Thread ts = new Thread() {

            public void run() {

                while (sock.isConnected()) {
                    try {
                        System.out.println("Enter Message:");
                        str = sc.nextLine();
                        synchronized (sock) {
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

                while (sock.isConnected()) {
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
            serversock = new ServerSocket(1121);
            while (true) {
                sock = serversock.accept();
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
                Receive();
                Send();
            }//while
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//try-catch

    }//createConnection()

    public static void main(String[] args) {

        ChatServer cs = new ChatServer();
        cs.createConnection();

    }//main()

}//class
