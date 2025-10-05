package OOPS3.inheritance.MultilevelInheritance;

public class Main
{
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // from Animal
        d.walk();  // from Mammal
        d.bark();  // from Dog
    }
}

class Animal{
    Animal(){
        System.out.println("Animal Constructor");
    }
    void eat(){
        System.out.println("Animal is eating");
    }
}
class  Mammal extends Animal{
    Mammal(){
        System.out.println("Mammal Constructor");
    }
    void walk(){
        System.out.println("Dog is walking");
    }
}
class Dog extends Mammal{
    Dog(){
        System.out.println("Dog Constructor");
    }
    void bark(){
        System.out.println("Dog is barking");
    }
}

