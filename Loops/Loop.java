package Loops;

public class Loop {
    public static void main(String[] args) {

    // for loop
    //  print number 1 to 5
        for(int i=0;i<=5;i++){
            System.out.println(i);
        }
    // while loop
      int number=1;
      while(number<100){
//          System.out.println(number);
          number=number*3+2;
      }

     // do while
      int number2=1;
     do{
         number2=number2*3;
         System.out.println(number2);
     }while(number2<100);
    }
}
