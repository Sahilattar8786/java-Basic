package OOPS3.inheritance.HerarchicalInheritance;

public class Main {
    public static void main(String[] args) {
       Director d= new Director();

    }
}

class Employee {
    String name;
    int age;
    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    Employee(){
        System.out.println("Default Constructor");
    }
}

class Manager extends Employee {
    String Team;
    Manager(String name, int age, String Team) {
        super(name, age);
        this.Team = Team;
    }
    Manager(){
        System.out.println("Child constructor");
    }
}
class Director extends Employee {
    String Department;
    Director(String name, int age, String Department) {
        super(name, age);
        this.Department = Department;
    }
    Director(){
        super();
        System.out.println("Director Constructor");
    }
}
/*
 Here Parent Class constructor getting called first
*/