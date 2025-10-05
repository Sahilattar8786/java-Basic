# ☕ `super` Keyword in Java

## 🔍 Overview
The `super` keyword in Java is a **reference variable** that refers to the **immediate parent class object**.  
It is mainly used in **inheritance** to access parent class members (variables, methods, and constructors) that are hidden or overridden in the child class.

---

## 🧠 Why use `super`?

When a subclass inherits from a superclass:
- Some variables or methods in the subclass **may override or hide** those in the superclass.
- You can use `super` to **explicitly refer to the parent’s version** of those members.
- It also helps to **call parent class constructors** to reuse initialization logic.

---

## ⚙️ Syntax
```java
super.variableName
super.methodName()
super()   // Calls the parent class constructor
```
---
## 🧩 1. Using super to Access Parent Class Variables
```java 
class Parent {
int value = 10;
}

class Child extends Parent {
int value = 20;

    void showValues() {
        System.out.println("Child value: " + value);        // 20
        System.out.println("Parent value: " + super.value); // 10
    }
}

public class Main {
public static void main(String[] args) {
Child c = new Child();
c.showValues();
}
}
```

---
## 🧩 2. Using super to Call Parent Class Methods

If a subclass overrides a method of its parent class,
the subclass can still call the parent’s version using super.methodName().

```java 
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }

    void displaySound() {
        super.sound(); // calls Animal's sound()
        sound();       // calls Dog's sound()
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.displaySound();
    }
}

```

## 🧩 3. Using super() to Call Parent Class Constructors
	•	super() is used inside a subclass constructor to call the immediate parent class constructor.
	•	It must be the first statement inside the child constructor.
	•	If you don’t explicitly call super(), Java automatically inserts it to call the parent’s default constructor.
```java 
class Box {
    double length, width, height;

    Box(double l, double w, double h) {
        length = l;
        width = w;
        height = h;
        System.out.println("Box constructor called");
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(double l, double w, double h, double weight) {
        super(l, w, h);  // calls Box constructor
        this.weight = weight;
        System.out.println("BoxWeight constructor called");
    }
}

public class Main {
    public static void main(String[] args) {
        BoxWeight box = new BoxWeight(2, 3, 4, 5);
    }
}
```

## ⚠️ Important Rules for super
1.	super() must be the first statement in the subclass constructor.
Otherwise, the compiler will throw an error.
2.	If the parent class has no default constructor,
you must call one of its constructors explicitly using super(arguments).
3.	You cannot use super to access private members of the parent class.
(Use getters/setters instead.)
4.	Every constructor automatically calls either:
•	another constructor in the same class using this(), or
•	a constructor in the superclass using super().

## Why We Need super instead of this 

Because this only refers to the current class, it cannot access:
•	The parent’s hidden variables
•	The parent’s overridden methods
•	The parent’s constructors

That’s where super comes in — it’s like saying:

“Hey, I want to talk to my parent’s version of this.”

```java 

class Parent {
    int value = 10;
}

class Child extends Parent {
    int value = 20;

    void show() {
        System.out.println("Child value: " + this.value);  // 20
        System.out.println("Parent value: " + super.value); // 10
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.show();
    }
}
```
