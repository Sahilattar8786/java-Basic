package Functions;

import java.util.Scanner;

public class PrimeNo {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int number=in.nextInt();
        if(checkPrime(number)){
            System.out.println("Is Prime No");
        }else {
            System.out.println("Not Prime");
        }
    }
   static boolean checkPrime(int n){
        if(n<=1) return  false;
        if(n==2 || n==3) return  true;

        for(int i=2;i*i<=n;i++){
            if(n%i==0) {
                return false;
            }
        }
        return true;
   }
}
