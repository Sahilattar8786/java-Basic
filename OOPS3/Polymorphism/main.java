package OOPS3.Polymorphism;

public class main {
    public static void main(String[] args) {
       Number number = new Number();
       number.sum(3,4);
       Dog animal = new Dog();
       animal.sound();
    }
}

// method overloading  - Compile Time Polymorphism
class Number{
    void sum(double a , double b){
        System.out.println(a+b);
    }
    void sum(int a , int b){
        System.out.println(a+b);
    }
}

class Animal {
    void sound(){
        System.out.println("Animal sound");
    }
}
class Dog extends Animal {
    @Override // annotation
    void sound(){
        System.out.println("Dog sound");
    }
    // static and final keyword cann't be override

}