package Loops;

public class Conditionals {

    public static void main(String[] args) {
        // if else
        int salary=10000;
        if(salary<=5000){
            salary=salary+1000;
        }else{
            salary=salary+2000;
        }
        System.out.println(salary);
        // multiple if-else
        int age=19;
        if(age<=18){
            System.out.println("User cant vote and cant drink");
        }else if(age>18 && age<21){
            System.out.println("User cant drink but vote");
        }else if(age>21){
            System.out.println("User can do both");
        }
    }
}
