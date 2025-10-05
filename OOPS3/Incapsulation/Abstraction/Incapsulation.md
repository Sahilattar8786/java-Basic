☕ Encapsulation in Java — A Deep Dive

🔍 Overview

Encapsulation is one of the four main pillars of Object-Oriented Programming (OOP), along with:
	•	Inheritance
	•	Polymorphism
	•	Abstraction

In simple terms, Encapsulation means binding data (variables) and methods (functions) that operate on that data into a single unit, and restricting access to some of the object’s components.

It is also referred to as data hiding.

⸻

🧩 Definition

Encapsulation is the process of wrapping data and code together into a single unit (class) and controlling access to that data using access modifiers.

⸻

⚙️ Key Idea

In Java, encapsulation is achieved by:
	1.	Making the data members (variables) private.
	2.	Providing public getter and setter methods to access and update the data.

This ensures that the internal representation of an object is hidden from the outside.

⸻

📘 Example: Encapsulation in Java

class Employee {
    // private data members
    private String name;
    private int age;
    private double salary;

    // public getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18) {
            this.age = age;
        } else {
            System.out.println("Age must be above 18.");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();

        emp.setName("John");
        emp.setAge(25);
        emp.setSalary(50000);

        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: " + emp.getSalary());
    }
}

✅ Output:

Name: John
Age: 25
Salary: 50000.0


⸻

🧠 Why Use Encapsulation?

Encapsulation helps in:

Benefit	Description
Data Hiding	Prevents direct access to data — keeps it safe from misuse.
Controlled Access	You decide how fields can be read or modified via getters/setters.
Flexibility	You can change the internal implementation later without affecting external code.
Maintainability	Code becomes modular and easier to manage.
Security	Sensitive data can be validated before modification.


⸻

⚙️ Example: Validation Using Setters

class BankAccount {
    private double balance;

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setBalance(-1000); // invalid
        account.setBalance(2000);  // valid
        System.out.println("Balance: " + account.getBalance());
    }
}

✅ Output:

Invalid balance amount.
Balance: 2000.0

🧩 Encapsulation ensures data integrity — you can’t set invalid values directly.

⸻

⚙️ Example Without Encapsulation (Bad Practice)

class Account {
    public double balance;
}

public class Main {
    public static void main(String[] args) {
        Account a = new Account();
        a.balance = -5000; // ❌ Invalid directly assigned value
        System.out.println(a.balance);
    }
}

✅ Output:

-5000.0

⚠️ Problem:
	•	Anyone can modify the balance field.
	•	No validation → inconsistent or insecure data.

✅ Solution: Use private fields + getter/setter = Encapsulation.

⸻

⚙️ Access Modifiers and Encapsulation

Modifier	Scope	Used For
private	Within the same class only	To hide data members
public	Everywhere	For getter/setter methods
protected	Same package + subclass	Used when inheritance is involved
default	Package level	Used within the same package


⸻

🧩 Encapsulation vs Data Hiding

Concept	Definition
Encapsulation	Binding data and methods together in one class
Data Hiding	Restricting access to internal data using access modifiers

💡 Encapsulation is the mechanism, and data hiding is one of its outcomes.

⸻

⚙️ Real-world Example: ATM Machine

Imagine an ATM Machine:
	•	You access your balance using a card and PIN (public interface).
	•	You cannot directly access or change internal code or data — it’s encapsulated.

In Java:

class ATM {
    private double balance = 10000;

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdraw(2000);
        atm.withdraw(9000);
    }
}

✅ Output:

Withdrawal successful. Remaining balance: 8000.0
Insufficient balance!


⸻

🧭 In Short

Encapsulation = Data + Methods bound together + Restricted access = Secure & Maintainable Code

⸻

✅ Summary

Concept	Description
Definition	Wrapping data and methods that operate on it into one class
Achieved by	Using private variables and public getter/setter methods
Purpose	Data hiding and controlled access
Benefits	Security, maintainability, flexibility
Access modifiers used	private (fields) and public (methods)


⸻

