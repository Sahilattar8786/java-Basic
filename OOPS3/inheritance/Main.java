package OOPS3.inheritance;

public class Main {
    public static void main(String[] args) {
        BoxWeight box = new BoxWeight(7,2,4,5);
        box.display();
        BoxPrice boxPrice = new BoxPrice(7,2,4);
        boxPrice.display();
        System.out.println("box price is "+boxPrice.cost);
    }
}
