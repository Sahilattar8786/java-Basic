# ☕ Method Overriding in Java — A Deep Dive

## 🔍 Overview

**Method Overriding** is an OOP concept in Java where a **child class redefines** a method of its **parent class** —
**with the same name, return type, and parameters.**

It allows the subclass to provide its **own version** of a behavior already defined by the superclass.

---

## 🧩 Definition

> When a subclass provides a **specific implementation** of a method that is already defined in its parent class,
> it is known as **method overriding**.

---

## ⚙️ Example: Basic Method Overriding

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() { // overriding parent method
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog(); // upcasting
        a.sound();            // calls Dog's version
    }
}
```

✅ **Output:**

```
Dog barks
```

---

## 🧠 What Happened?

* `Animal` defines `sound()`.
* `Dog` **overrides** `sound()` with its own implementation.
*  Even though the reference type is `Animal`, the **actual object is Dog**.
*  Hence, the **Dog’s version** executes — this is **Runtime Polymorphism**.

---

## 🧩 The `@Override` Annotation

```java
@Override
void sound() {
    System.out.println("Dog barks");
}
```

✅ It’s **optional**, but highly recommended.

### Why use it?

* Helps **compiler verify** that a method is actually overriding a superclass method.
* Prevents subtle errors like mistyped method names or incorrect parameters.

Example (without `@Override`):

```java
void sounds() {}  // typo, won't override
```

No compile-time error — but `sounds()` doesn’t override anything.

With `@Override`, Java will give a **compile-time error** ✅

---

## ⚙️ Rules for Method Overriding in Java

| Rule                      | Description                                                             |
| ------------------------- | ----------------------------------------------------------------------- |
| 1️⃣ Same Method Signature | Method name and parameters must be identical.                           |
| 2️⃣ Return Type           | Must be the same or **covariant** (child type of parent’s return type). |
| 3️⃣ Access Modifier       | Can be same or **less restrictive**, but not more.                      |
| 4️⃣ Static Methods        | ❌ Cannot be overridden (they are hidden).                               |
| 5️⃣ Final Methods         | ❌ Cannot be overridden.                                                 |
| 6️⃣ Constructors          | ❌ Cannot be overridden.                                                 |
| 7️⃣ Private Methods       | ❌ Not inherited → cannot be overridden.                                 |
| 8️⃣ Exception Handling    | Subclass method cannot throw broader checked exceptions.                |

---

## ⚙️ Example: Covariant Return Type

```java
class Animal {
    Animal getAnimal() {
        return this;
    }
}

class Dog extends Animal {
    @Override
    Dog getAnimal() { // return type changed (child class)
        return this;
    }
}
```

✅ This is valid — because `Dog` is a **subtype** of `Animal`.

---

## ⚙️ Example: Access Modifier Rule

```java
class Parent {
    protected void show() {
        System.out.println("Parent show()");
    }
}

class Child extends Parent {
    @Override
    public void show() { // ✅ allowed: public > protected
        System.out.println("Child show()");
    }
}
```

❌ The opposite (making it **more restrictive**) is **not allowed**:

```java
// ERROR
class Child extends Parent {
    private void show() {} // ❌ Cannot reduce visibility
}
```

---

## ⚙️ Example: Static Methods Are Not Overridden

```java
class Parent {
    static void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    static void greet() {
        System.out.println("Hello from Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent.greet(); // Hello from Parent
        Child.greet();  // Hello from Child

        Parent obj = new Child();
        obj.greet(); // still calls Parent's greet() (method hiding)
    }
}
```

🧠 **Static methods are hidden, not overridden.**

---

## ⚙️ Example: Exception Handling in Overriding

```java
class Parent {
    void display() throws Exception {
        System.out.println("Parent display()");
    }
}

class Child extends Parent {
    @Override
    void display() throws ArithmeticException { // ✅ allowed (narrower exception)
        System.out.println("Child display()");
    }
}
```

❌ Not allowed:

```java
class Child extends Parent {
    @Override
    void display() throws IOException { // ❌ broader exception
        System.out.println("Error");
    }
}
```

---

## ⚙️ Example: Using `super` Keyword in Overriding

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        super.start(); // calls Vehicle's version
        System.out.println("Car starts too!");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
    }
}
```

✅ **Output:**

```
Vehicle starts
Car starts too!
```

---

## ⚙️ Overriding vs Overloading

| Feature           | **Overriding**                          | **Overloading**                                   |
| ----------------- | --------------------------------------- | ------------------------------------------------- |
| Definition        | Redefining parent method in child class | Multiple methods with same name, different params |
| Occurs in         | Different classes (inheritance)         | Same class                                        |
| Binding           | Runtime                                 | Compile-time                                      |
| Return type       | Same or covariant                       | Can differ                                        |
| Access modifier   | Can be same or less restrictive         | Can be any                                        |
| `@Override` used? | ✅ Yes                                   | ❌ No                                              |
| Purpose           | Change inherited behavior               | Provide multiple versions of method               |

---

## ⚙️ Example: Both in One

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void sound(String type) { // overloaded
        System.out.println("Dog barks: " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();          // overridden
        d.sound("loudly");  // overloaded
    }
}
```

✅ **Output:**

```
Dog barks
Dog barks: loudly
```

---

## ⚙️ Real-world Example: Payment System

```java
class Payment {
    void process() {
        System.out.println("Processing generic payment...");
    }
}

class CreditCardPayment extends Payment {
    @Override
    void process() {
        System.out.println("Processing credit card payment...");
    }
}

class UpiPayment extends Payment {
    @Override
    void process() {
        System.out.println("Processing UPI payment...");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p;

        p = new CreditCardPayment();
        p.process();

        p = new UpiPayment();
        p.process();
    }
}
```

✅ **Output:**

```
Processing credit card payment...
Processing UPI payment...
```

🧠 This is **Runtime Polymorphism** —
same `process()` method, different behaviors depending on the actual object.

---

## 🧭 In Short

> Method Overriding = Redefining parent’s behavior in child class
> → Enables **Runtime Polymorphism** and **Dynamic Method Dispatch**

---

## ✅ Summary

| Concept                          | Description                                            |
| -------------------------------- | ------------------------------------------------------ |
| **Definition**                   | Redefining a superclass method in a subclass           |
| **Type**                         | Runtime Polymorphism                                   |
| **Keywords Used**                | `@Override`, `super`                                   |
| **Rules**                        | Same signature, same return type, not more restrictive |
| **Static/final/private methods** | ❌ Cannot be overridden                                 |
| **Use Case**                     | To modify or specialize parent behavior                |

---

