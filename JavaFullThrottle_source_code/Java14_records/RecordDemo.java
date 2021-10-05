// compile: javac -source 14 --enable-preview *.java
// run: java --enable-preview RecordDemo

/* 
   1. Data-only classes. Syntax could change.
   2. Autogenerates constructor, toString, hashCode, equals and get methods
      with the same names as the data items.
   3. More future language enhancements: https://openjdk.java.net/projects/amber/
*/
record Employee(
        String firstName, 
        String lastName, 
        double salary, 
        String department) {}

public class RecordDemo {
   public static void main(String[] args) {
      Employee e1 = new Employee("Jason", "Red", 5000, "IT");
      Employee e2 = new Employee("Ashley", "Green", 7600, "SALES");
      Employee e3 = new Employee("Ashley", "Green", 7600, "SALES");
      
      System.out.printf("toString:%n%s%n%n", e1);
      System.out.printf("firstName: %s%n", e1.firstName());
      System.out.printf("lastName: %s%n", e1.lastName());
      System.out.printf("salary: %.2f%n", e1.salary());
      System.out.printf("department: %s%n%n", e1.department());
      
      System.out.printf("e1.equals(e2): %b%n", e1.equals(e2));
      System.out.printf("e2.equals(e3): %b%n%n", e2.equals(e3));
   }
}
