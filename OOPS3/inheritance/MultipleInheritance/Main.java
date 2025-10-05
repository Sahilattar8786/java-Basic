package OOPS3.inheritance.MultipleInheritance;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

    }
}

class Father {
    public int number=20;
}
class Mother {
    public int number=30;
}
// Not supported due ambugity issue
/*
class son extends Father,mother{
     System.out.println(number)
}
*/