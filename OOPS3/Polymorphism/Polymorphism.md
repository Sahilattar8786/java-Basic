# ☕ Polymorphism in Java — A Deep Dive

## 🔍 Overview

**Polymorphism** is one of the **four main pillars** of Object-Oriented Programming (OOP) —
along with **Encapsulation**, **Inheritance**, and **Abstraction**.

The term *Polymorphism* comes from Greek words:

> **Poly** = many
> **Morph** = forms

So, **Polymorphism means "many forms"** —
it allows a single action or method to behave differently based on the object it acts upon.

---

## 🧩 Definition

> **Polymorphism** in Java is the ability of an object to take on **many forms**.
> It allows methods to perform **different tasks** depending on the object that invokes them.

---

## 🧠 Types of Polymorphism in Java

Java supports **two types** of polymorphism:

| Type                          | When it occurs  | Also Known As                       | Example                                |
| ----------------------------- | --------------- | ----------------------------------- | -------------------------------------- |
| **Compile-time polymorphism** | At compile-time | Static Binding / Method Overloading | Same method name, different parameters |
| **Runtime polymorphism**      | At runtime      | Dynamic Binding / Method Overriding | Parent reference calling child method  |

---

# ⚙️ 1️⃣ Compile-Time Polymorphism (Method Overloading)

## 📖 Definition

Compile-time polymorphism occurs when multiple methods in the same class
have the **same name** but **different parameter lists**.

🔗 The method to be called is determined **at compile time**.

---

## 🧩 Example: Method Overloading

```java
class Calculator {
    // Overloaded methods
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));          // Calls int version
        System.out.println(calc.add(2.5, 3.5));      // Calls double version
        System.out.println(calc.add(1, 2, 3));       // Calls 3-argument version
    }
}
```

✅ **Output:**

```
5
6.0
6
```

---

## 🧠 Key Points of Compile-Time Polymorphism

| Feature       | Description                                    |
| ------------- | ---------------------------------------------- |
| Achieved by   | Method Overloading                             |
| Binding       | Static (at compile-time)                       |
| Determined by | Method signature (name + parameters)           |
| Return type   | Can differ, but not sufficient alone           |
| Example       | Constructors, static methods can be overloaded |
| Performance   | Faster (resolved during compilation)           |

---

# ⚙️ 2️⃣ Runtime Polymorphism (Method Overriding)

## 📖 Definition

Runtime polymorphism occurs when a subclass provides a **specific implementation**
of a method that is already defined in its parent class.

🔗 The method call is resolved **at runtime**, not during compilation.

---

## 🧩 Example: Method Overriding

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a;        // reference variable of parent class
        a = new Dog();   // Dog object
        a.sound();       // Dog's version of sound()

        a = new Cat();   // Cat object
        a.sound();       // Cat's version of sound()
    }
}
```

✅ **Output:**

```
Dog barks
Cat meows
```

---

## 🧠 Key Points of Runtime Polymorphism

| Feature       | Description                                 |
| ------------- | ------------------------------------------- |
| Achieved by   | Method Overriding                           |
| Binding       | Dynamic (at runtime)                        |
| Determined by | Actual object type (not reference)          |
| Requires      | Inheritance + Upcasting                     |
| Example       | Parent reference → Child object             |
| Performance   | Slightly slower (resolved during execution) |

---

## 🧩 Example: Using `super` in Overriding

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle starting...");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        super.start(); // calls parent version
        System.out.println("Car engine starting...");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
    }
}
```

✅ **Output:**

```
Vehicle starting...
Car engine starting...
```

---

## ⚙️ Upcasting and Runtime Polymorphism

Polymorphism occurs when a **parent class reference** points to a **child class object**.

Example:

```java
Parent p = new Child(); // Upcasting
p.show(); // calls overridden method in Child
```

✅ The compiler only checks if `show()` exists in `Parent`,
but **JVM executes the version** in `Child` during runtime.

---

## 🧩 Example: Polymorphism with Parameters

```java
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Drawing square");
    }
}

public class Main {
    static void printShape(Shape s) {
        s.draw(); // runtime binding
    }

    public static void main(String[] args) {
        printShape(new Circle());
        printShape(new Square());
    }
}
```

✅ **Output:**

```
Drawing circle
Drawing square
```

---

# 🼁 Constructor Polymorphism

Constructors can be **overloaded** but **not overridden**.

```java
class Student {
    String name;
    int age;

    Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob", 22);
        s1.display();
        s2.display();
    }
}
```

✅ **Output:**

```
Alice 0
Bob 22
```

---

# ⚙️ Operator Polymorphism (Example: `+`)

In Java, the `+` operator is overloaded internally by the compiler.

Example:

```java
int x = 5, y = 10;
String a = "Hello ", b = "World!";

System.out.println(x + y);   // arithmetic addition
System.out.println(a + b);   // string concatenation
```

✅ **Output:**

```
15
Hello World!
```

---

# 🗳 Rules for Method Overriding (Runtime Polymorphism)

| Rule               | Description                              |
| ------------------ | ---------------------------------------- |
| Method signature   | Must be the same in parent and child     |
| Return type        | Same or covariant (child of parent type) |
| Access modifier    | Cannot be more restrictive               |
| Static methods     | Cannot be overridden (only hidden)       |
| Final methods      | Cannot be overridden                     |
| Constructors       | Not inherited, hence not overridden      |
| Exception handling | Subclass cannot throw broader exceptions |

---

## 🧠 Why Polymorphism is Useful

| Advantage            | Description                                     |
| -------------------- | ----------------------------------------------- |
| **Code Reusability** | Common interface for multiple behaviors         |
| **Flexibility**      | Easily extend or modify behavior via overriding |
| **Scalability**      | Add new subclasses without changing parent code |
| **Maintainability**  | Cleaner, modular, and organized structure       |
| **Runtime Decision** | JVM decides method version dynamically          |

---

## 🗾 Real-World Example: Payment System

```java
class Payment {
    void processPayment() {
        System.out.println("Processing general payment...");
    }
}

class CreditCardPayment extends Payment {
    void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class UpiPayment extends Payment {
    void processPayment() {
        System.out.println("Processing UPI payment...");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p;

        p = new CreditCardPayment();
        p.processPayment();

        p = new UpiPayment();
        p.processPayment();
    }
}
```

✅ **Output:**

```
Processing credit card payment...
Processing UPI payment...
```

---

# ⚙️ Polymorphism in Interfaces

When a class implements an interface,
the same interface reference can point to multiple class objects.

```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a;

        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();
    }
}
```

✅ **Output:**

```
Dog barks
Cat meows
```

---

## 🧽 In Short

> Polymorphism = One interface, multiple implementations.
> It allows Java to support **dynamic method dispatch**,
> where method execution depends on the **actual object**, not the reference type.

---

## ✅ Summary

| Type                      | Mechanism          | Binding Time | Example                                  | Keyword   |
| ------------------------- | ------------------ | ------------ | ---------------------------------------- | --------- |
| Compile-time Polymorphism | Method Overloading | Compile-time | `add(int, int)` vs `add(double, double)` | `this()`  |
| Runtime Polymorphism      | Method Overriding  | Runtime      | Parent ref → Child object                | `super()` |

---

## ⚙️ Key Differences Between Compile-time & Runtime Polymorphism

| Feature              | Compile-time       | Runtime                      |
| -------------------- | ------------------ | ---------------------------- |
| Achieved by          | Method Overloading | Method Overriding            |
| Binding              | Static             | Dynamic                      |
| Decision made        | At compile-time    | At runtime                   |
| Access specifier     | Can be any         | Should not reduce visibility |
| Performance          | Faster             | Slightly slower              |
| Involves inheritance | ❌ Not mandatory    | ✅ Mandatory                  |
| Example              | Same class         | Parent–child relationship    |

---

## 🧽 In Summary

> **Compile-time polymorphism** = method overloading → decided at compile time
> **Runtime polymorphism** = method overriding → decided at runtime

Both together make Java **flexible**, **extensible**, and **object-oriented**.

---



---
