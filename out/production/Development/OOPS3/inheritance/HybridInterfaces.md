# ☕ Hybrid Inheritance in Java — A Deep Dive

## 🔍 Overview

**Hybrid Inheritance** is a **combination of two or more types of inheritance** (like single, multiple, multilevel, or hierarchical).  
It is used when a class hierarchy involves **multiple inheritance relationships** working together.

However ⚠️, **Java does not support hybrid inheritance with classes** directly — because it leads to **ambiguity** (diamond problem).  
Instead, Java achieves hybrid inheritance **using interfaces**.

---

## 🧩 Definition

> Hybrid Inheritance = Combination of two or more inheritance types in a single program structure.

### Example pattern:
     ┌──────────┐
     │  Class A │
     └─────┬────┘
           │
     ┌─────▼────┐
     │  Class B │
     └─────┬────┘
      ┌────┴────┐
      ▼         ▼
Class C     Interface D
└───────┬────────┘
▼
Class E

Here:
- `A → B → C` forms **multilevel inheritance**
- `D` → used by `E` forms **multiple inheritance** (via interface)

Combined → **Hybrid Inheritance**

---

## 🧠 Why Java Restricts Hybrid Inheritance (with Classes)

Hybrid inheritance with **classes** creates **ambiguity** due to **multiple parent paths** leading to the same ancestor (the **Diamond Problem**).

### ❌ Example of Ambiguity (Conceptually)

```java
class A {
    void show() {
        System.out.println("Class A");
    }
}

class B extends A {
    void show() {
        System.out.println("Class B");
    }
}

class C extends A {
    void show() {
        System.out.println("Class C");
    }
}

// ❌ Illegal: Multiple inheritance via classes not allowed
class D extends B, C {
    // Which show() should D inherit? B or C?
}
✅ Error:
Error: '{' expected
class D extends B, C {
                 ^
```
To prevent such ambiguity, Java disallows multiple inheritance with classes,
but still allows a hybrid model using interfaces.

