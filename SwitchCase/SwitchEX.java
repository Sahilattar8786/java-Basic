package SwitchCase;

import java.util.Scanner;

public class SwitchEX {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
//        System.out.println("Enter Fruit");
//        String fruit=in.nextLine().toLowerCase();
//
//        switch (fruit){
//            case "apple":
//                System.out.println("Apple is red");
//                break;
//            case "banana":
//                System.out.println("Banana is Yellow");
//                break;
//            default:
//                System.out.println("Enter valid Fruit");
//        }
        System.out.println("Enter Day");
        int num=in.nextInt();

        switch (num){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wenesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid Day");
        }

    }
}
