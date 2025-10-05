package OOPS3.Polymorphism;

public class Shape {
    void area(){
        System.out.println(" Area of Shape");
    }
}

class Circle extends Shape {
    void area() {
        System.out.println("Area of Circle");
    }
}
class Rectangle extends Shape {
    void area() {
        System.out.println("Area of Rectangle");
    }
}