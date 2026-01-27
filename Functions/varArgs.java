package Functions;

import java.util.Arrays;

public class varArgs {
    public static void main(String[] args) {
     fun(2,3,4,5,6,7,8,9,9,10);
    }
    static  void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }
}
