# ☕ Multiple Inheritance in Java — A Deep Dive

## 🔍 Overview
**Inheritance** allows one class to acquire the properties and methods of another.  
However, when a class tries to inherit from **more than one parent class**, it is called **Multiple Inheritance**.

In Java, **multiple inheritance using classes is not supported** to avoid **ambiguity** and **complexity** —  
but it **is supported via interfaces**.

---

## 🧠 What is Multiple Inheritance?

### 📖 Definition
> Multiple Inheritance is a feature in which a single class can **inherit from more than one parent class**, thereby acquiring the members of all parent classes.

---

## ⚠️ Why Java Does Not Support Multiple Inheritance (with Classes)

Consider this example 👇

```java
class A {
    void show() {
        System.out.println("Class A");
    }
}

class B {
    void show() {
        System.out.println("Class B");
    }
}

// ❌ This is illegal in Java
class C extends A, B {
    // Error: Java does not support multiple inheritance
}

```

## Due To Multiple Inheritance not supported in Java  *Interface* Cames into picture 

## 🧩 The Diamond Problem (Reason for Restriction)
        A
       / \
      B   C
       \ /
        D

If both B and C inherit from A, and D inherits from both B and C,
and all classes define a method show(), then:

❓ Which show() should D inherit? From B or C?

This ambiguity is known as the Diamond Problem.
Java avoids this problem by disallowing multiple inheritance of classes.

✅ How Java Solves This — Interfaces!
While Java does not allow multiple inheritance with classes,
it allows it with interfaces, because interfaces don’t carry implementation, only method declarations.

So there’s no ambiguity — only contracts to implement.

## ⚙️ Example: Multiple Inheritance Using Interfaces

```java
interface A {
    void display();
}

interface B {
    void display();
}

class C implements A, B {
    @Override
    public void display() {
        System.out.println("Display method implemented in class C");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.display();
    }
}
✅ Output:
Display method implemented in class C
🧠 Explanation:
        •	Both interfaces A and B declare display().
        •	Class C implements both and provides a single implementation, resolving ambiguity.
```
## 🧩 Example: Multiple Inheritance via Interface + Class
```java

class A {
    void show() {
        System.out.println("Show from class A");
    }
}

interface B {
    void print();
}

class C extends A implements B {
    @Override
    public void print() {
        System.out.println("Print from interface B implemented in class C");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
        obj.print();
    }
}
✅ Output:
Show from class A
Print from interface B implemented in class C
```
## 🧩 Multiple Inheritance with Default Methods (Java 8+)
From Java 8 onward, interfaces can have default methods (methods with implementation).
This brings back the potential for ambiguity — but Java provides clear rules.

### ⚙️ Example
```java

interface A {
    default void greet() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void greet() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    @Override
    public void greet() {
        // Must explicitly choose one or override
        A.super.greet();
        System.out.println("Hello from C");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.greet();
    }
}
✅ Output:
Hello from A
Hello from C
```
