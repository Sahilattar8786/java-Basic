package Loops;

public class LargestNumber {
    public static void main(String[] args) {
         int num1=14;
         int num2=24;
         int num3=23;

         if(num1>num2 && num1>num3){
             System.out.println("Largest number is: "+num1);
         }else if (num2 > num1 && num2 > num3){
             System.out.println("Largest number is: " + num2);
         }else {
             System.out.println("Largest number is: " + num3);
         }

    }
}
