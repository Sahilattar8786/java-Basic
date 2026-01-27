package Functions;

public class Returns {
    public static void main(String[] args) {
        // calling string
        String greet= greet();
        System.out.println(greet);

        int ans= sum(10,20);
        System.out.println(ans);

        String mygreet=mygreet("Rehan");
        System.out.println(mygreet);
    }

    // return type int
    static  int sum(){
         return 1;
    }
    // return type String
    static  String greet(){
         String greet="Hello";
         return  greet;
    }

    // parameter integer function
    static  int sum(int a,int b){
         return a+b;
    }
    static String mygreet(String name){
         String greet= "Hello "+name;
         return  greet;
    }
}
