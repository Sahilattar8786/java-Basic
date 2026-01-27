package Loops;

import java.util.Scanner;

public class AdditionOfNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number=in.nextInt();

        int sum=0;

        while(number>0){
            int rem=number%10;
            number=number/10;
            sum=sum+rem;
        }
        System.out.println(sum);

    }
}

