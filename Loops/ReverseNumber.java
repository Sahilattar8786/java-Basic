package Loops;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number=in.nextInt();

        int reversenumber=0;

        while(number>0){
            int rem=number%10;
            number=number/10;
            reversenumber=(reversenumber*10)+rem;
        }
        System.out.println(reversenumber);
    }


}
