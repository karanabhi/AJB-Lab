

/**
 *
 * @author Abhishek Karan
 */

class A{
    void method(){
        System.out.println("This is class A.");
    }
    void method(int x){
        System.out.println("Overloaded with values of X:"+x);
    }
}

public class Ques1 extends A{
    
    public static void main(String[] args){
        System.out.println("THis is Class Ques1.");
        //A a=new A();
        //a.method();
        Ques1 q=new Ques1();
        q.print();
    }//main()
    
    void print(){
        method();
        method(100);
    }
}//class

