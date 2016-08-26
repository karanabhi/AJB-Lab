

/**
 *
 * @author Abhishek Karan
 */
public class Ques2 {
    
    public static void main(String[] args){
       
        try{
            int x=1/0;
            System.out.println("1/0 ="+x);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//main()
}//class
