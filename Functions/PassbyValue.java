package Functions;


import java.util.Arrays;

/*
   Java is always “pass-by-value.”
   But when you pass an object, the “value” being passed is the reference (memory address), not the actual object.
   public class Test {
    public static void main(String[] args) {
        int a = 10;
        changeValue(a);
        System.out.println(a);  // 👉 10 (unchanged)
    }

    static void changeValue(int x) {
        x = 20; // only local copy changes
    }
    class Person {
    String name;
}

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Alice";

        changeName(p);
        System.out.println(p.name);  // 👉 Bob (changed)

        reassignReference(p);
        System.out.println(p.name);  // 👉 Bob (not Charlie)
    }

    static void changeName(Person person) {
        person.name = "Bob"; // modifies the object contents
    }

    static void reassignReference(Person person) {
        person = new Person(); // new object
        person.name = "Charlie";
    }
}

}

*/
public class PassbyValue {
    public static void main(String[] args) {
      int[] numbers={1,2,3,4,56,7};
      Change(numbers);
      System.out.println(Arrays.toString(numbers)); // [99, 2, 3, 4, 56, 7]
    }

    static  void Change(int[] arr){
        arr[0]=99;
    }
}
