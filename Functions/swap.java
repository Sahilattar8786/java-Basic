package Functions;

import java.util.Scanner;
/*
 Note : In Java We dont have pass by reference we have only pass by value
*/

public class swap {
    public static void main(String[] args) {
       int fnum=10;
       int SecNum=20;
       swap(fnum,SecNum);
        System.out.println(fnum+""+SecNum);
    }

    static  void swap(int a, int b){
        int temp=a;
         a=b;
         b=temp;
        System.out.println("First Number:"+a+" Second Number:"+b);
    }
}
