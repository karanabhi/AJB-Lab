
/**
 *
 * @author Abhishek Karan
 */
class RunnableThread implements Runnable {

    public void run() {
        try {
            System.out.println("Runnable Thread:" + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//run()
}

public class Ques3 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableThread());
        Thread t2 = new Thread(new RunnableThread());

        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//main()

}//class
