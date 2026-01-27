package Functions;

public class Overloading {
    public static void main(String[] args) {
        sum(3,4);
        sum(2,5,7);
    }
    static  void sum(int a, int b){
        System.out.println(a+b);
    }
    static  void sum(int a, int b,int c){
        System.out.println(a+b+c);
    }
}
