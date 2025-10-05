# ☕ Hierarchical Inheritance in Java — A Deep Dive

## 🔍 Overview

**Hierarchical Inheritance** is a type of inheritance in which **multiple child classes inherit from a single parent class**.

In other words, there is **one superclass** (base class) and **multiple subclasses**, each of which **inherits the properties and methods** of the same parent.

---

## 🧩 Definition

> When **two or more classes** inherit from the **same parent class**,  
> it is called **Hierarchical Inheritance**.

📘 **Syntax:**
```java
class Parent {
    // parent properties and methods
}

class Child1 extends Parent {
    // child1 specific properties and methods
}

class Child2 extends Parent {
    // child2 specific properties and methods
}
```

## ⚙️ Example: Hierarchical Inheritance in Java
```java
class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("The cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // Inherited from Animal
        d.bark(); // Dog's own method

        Cat c = new Cat();
        c.eat();  // Inherited from Animal
        c.meow(); // Cat's own method
    }
}

✅ Output:
This animal eats food
The dog barks
This animal eats food
The cat meows
```

## 🧱 Class Structure Diagram
             ┌────────────┐
             │   Animal   │
             └─────┬──────┘
         ┌─────────┼──────────┐
         ▼                    ▼
┌────────────┐       ┌────────────┐
│    Dog     │       │    Cat     │
└────────────┘       └────────────┘

## 🧩 Constructor Execution Order
Even though there are multiple child classes,
each child class still calls the parent constructor first when creating an object.

```java
class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    Car() {
        System.out.println("Car constructor");
    }
}

class Bike extends Vehicle {
    Bike() {
        System.out.println("Bike constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bike bike = new Bike();
    }
}
✅ Output:
Vehicle constructor
Car constructor
Vehicle constructor
Bike constructor
```
🧠 Each child class calls the parent constructor first, ensuring the parent’s initialization is complete.

## 🧩 Example: Using super Keyword in Hierarchical Inheritance
```java
class Shape {
    double area;

    void show() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        this.radius = r;
        this.area = Math.PI * r * r;
    }

    void display() {
        super.show(); // calling parent method
        System.out.println("Circle area = " + area);
    }
}

class Square extends Shape {
    double side;

    Square(double s) {
        this.side = s;
        this.area = s * s;
    }

    void display() {
        super.show();
        System.out.println("Square area = " + area);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.display();

        Square s = new Square(4);
        s.display();
    }
}
✅ Output:
This is a shape
Circle area = 78.53981633974483
This is a shape
Square area = 16.0
```
