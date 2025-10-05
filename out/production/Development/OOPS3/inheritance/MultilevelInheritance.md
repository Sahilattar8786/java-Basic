# ☕ Multilevel Inheritance in Java — A Deep Dive

## 🔍 Overview

**Inheritance** is one of the core principles of Object-Oriented Programming (OOP).  
It allows a class to inherit attributes and methods from another class.

> In **Multilevel Inheritance**, a class is derived from another derived class —  
> forming a **chain** of inheritance levels.

---

## 🧩 What is Multilevel Inheritance?

In **Multilevel Inheritance**,  
a class serves as a **base (parent)** for another class,  
and that derived class acts as a **parent** for yet another class.

### 🧱 Structure:
Grandparent → Parent → Child
### 💡 Example:
```java
class A {
    // Base (grandparent) class
}

class B extends A {
    // Derived (parent) class
}

class C extends B {
    // Derived (child) class
}
Here:
        •	B inherits from A
	•	C inherits from B
	•	Hence, C indirectly inherits from A as well.

```
## ⚙️ Example: Multilevel Inheritance in Action

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Mammal extends Animal {
    void walk() {
        System.out.println("Mammal is walking...");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // from Animal
        d.walk();  // from Mammal
        d.bark();  // from Dog
    }
}
✅ Output:
Animal is eating...
Mammal is walking...
Dog is barking..
```
## 🧠 Explanation
	•	Dog inherits everything from Mammal
	•	Mammal inherits everything from Animal
	•	So Dog gets all properties and methods from both parent and grandparent.

This is transitive inheritance —
the bottom-most child inherits all members from the hierarchy above it.

## 🧩 Constructor Chaining in Multilevel Inheritance

When an object of the most derived class (Dog) is created:
1.	The constructor of the topmost parent (Animal) executes first.
2.	Then the intermediate class (Mammal) constructor runs.
3.	Finally, the child class (Dog) constructor executes.

```java 
class A {
    A() {
        System.out.println("Constructor A called");
    }
}

class B extends A {
    B() {
        System.out.println("Constructor B called");
    }
}

class C extends B {
    C() {
        System.out.println("Constructor C called");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
    }
}
✅output
Constructor A called
Constructor B called
Constructor C called
```
## Using super in Multilevel Inheritance
super is used to:
•	Call the parent class constructor.
•	Access parent class methods or variables that are hidden or overridden.

```java 
class A {
    int num = 10;
    void show() {
        System.out.println("A's show() method");
    }
}

class B extends A {
    int num = 20;
    void show() {
        super.show(); // calls A's show()
        System.out.println("B's show() method");
        System.out.println("A's num = " + super.num);
    }
}

class C extends B {
    void display() {
        super.show(); // calls B's show()
        System.out.println("C's display() method");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.display();
    }
}
class A {
    int num = 10;
    void show() {
        System.out.println("A's show() method");
    }
}

class B extends A {
    int num = 20;
    void show() {
        super.show(); // calls A's show()
        System.out.println("B's show() method");
        System.out.println("A's num = " + super.num);
    }
}

class C extends B {
    void display() {
        super.show(); // calls B's show()
        System.out.println("C's display() method");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.display();
    }
}
```
🧩 Overriding in Multilevel Inheritance
When a method is overridden in a subclass,
the most derived version (lowest child) is called at runtime.

```java
class A {
    void message() {
        System.out.println("Message from A");
    }
}

class B extends A {
    void message() {
        System.out.println("Message from B");
    }
}

class C extends B {
    void message() {
        System.out.println("Message from C");
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new C();
        obj.message(); // dynamic method dispatch
    }
}
✅ Output:
Message from C
```
## 🧩 Multilevel Inheritance with Variables
When variables are redeclared (not overridden),
the reference type determines which variable is used.

```java
class A {
    int x = 10;
}

class B extends A {
    int x = 20;
}

class C extends B {
    int x = 30;
}

public class Main {
    public static void main(String[] args) {
        A obj = new C();
        System.out.println(obj.x); // 10 (reference type decides)
    }
}
 output:10
        🧠 Methods follow runtime binding (actual object decides),
but variables follow compile-time binding (reference type decides).

```

