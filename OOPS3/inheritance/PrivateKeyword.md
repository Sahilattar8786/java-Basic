# ☕ Private Keyword in Java

## 🔒 Overview
The `private` keyword in Java is an **access modifier** used to **restrict visibility** of class members (variables, methods, and constructors) so they are **accessible only within the same class**.

## 🧩 Key Points
- `private` members **cannot be accessed** directly from:
    - Other classes
    - Subclasses (even in the same package)
    - Objects of the same class type

- It ensures **encapsulation**, a core OOP principle — keeping internal data hidden and secure.


## 🧠 Syntax Example

```java
class Example {
    private int secretNumber = 42;

    private void showSecret() {
        System.out.println("Secret: " + secretNumber);
    }

    public void accessSecret() {
        // ✅ allowed: private members are accessible inside the same class
        showSecret();
    }
}

public class Main {
    public static void main(String[] args) {
        Example e = new Example();

        // ❌ Not allowed — private member access outside the class
        // System.out.println(e.secretNumber);
        // e.showSecret();

        // ✅ Access via public method
        e.accessSecret();
    }
}
