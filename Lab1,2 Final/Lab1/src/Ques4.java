
import java.io.*;

/**
 *
 * @author Abhishek Karan
 */
public class Ques4 {

    public static void main(String[] args) {

        try {
            BufferedReader fin = new BufferedReader(new FileReader("D:\\Netbeans\\AJP1\\src\\in.txt"));
            BufferedWriter fout = new BufferedWriter(new FileWriter("D:\\Netbeans\\AJP1\\src\\out.txt"));

            String str = "";
            while ((str = fin.readLine()) != null) {
                fout.write(str);
                System.out.println(str);
            }//while()
            System.out.println("Completed!");
            fin.close();
            fout.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main()

}//class
