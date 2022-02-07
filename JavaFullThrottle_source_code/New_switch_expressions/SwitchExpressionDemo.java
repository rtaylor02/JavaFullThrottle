import java.util.Scanner;

interface Shape { }
record Rectangle(double length, double width) implements Shape { }
record Circle(double radius) implements Shape { }

public class SwitchExpressionDemo {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter a grade 0-100: ");
      int grade = input.nextInt();
      
      /*
         1. Expression format shown here may not contain return.
         2. Can also use this format as a standalone statement.
         3. Cases with -> cannot fall through to the next case.
         4. Can still use cases with :, which do allow fallthrough.
         5. Cases may contain a block of code, in which case you use yield
            to specify the case's value.
         6. Cases support individual values or comma-separated lists of values
            of integer types, enum types or Strings.
         7. https://openjdk.java.net/jeps/361 and 
            https://docs.oracle.com/en/java/javase/14/language/switch-expressions.html
         8. Eventually, there will be pattern matching support. See
            http://cr.openjdk.java.net/~briangoetz/amber/pattern-match.html 
         9. More future language enhancements: https://openjdk.java.net/projects/amber/
      */
      
      String letterGrade = switch (grade / 10) {
         case 9, 10 -> "A";
         case 8 -> "B";
         case 7 -> "C";
         case 6 -> "D";
         default -> {
             System.out.printf("Failing grade: %d%n", grade);
             yield "F";
         }
      };
      
      System.out.printf("Letter grade: %s%n", letterGrade);  
      
      /*
         Pattern Matching switch: https://openjdk.java.net/jeps/406 
         
      */
      
      Rectangle r = new Rectangle(10, 5);
      Circle c = new Circle(10);
      System.out.printf("\n(if version) Perimeter of r: %f%n", getPerimeter(r));  
      System.out.printf("(if version) Perimeter of c: %f%n", getPerimeter(c));  
      System.out.printf("\n(switch version) Perimeter of r: %f%n", getPerimeterSwitch(r));  
      System.out.printf("(switch version) Perimeter of c: %f%n", getPerimeterSwitch(c));  
   }
   
   public static double getPerimeter(Shape shape) throws IllegalArgumentException {
      if (shape instanceof Rectangle r) {
         return 2 * r.length() + 2 * r.width();
      } else if (shape instanceof Circle c) {
         return 2 * c.radius() * Math.PI;
      } else {
         throw new IllegalArgumentException("Unrecognized shape");
      }
   }  
   
   public static double getPerimeterSwitch(Shape shape) throws IllegalArgumentException {
      return switch (shape) {
         case Rectangle r -> 2 * r.length() + 2 * r.width();
         case Circle c -> 2 * c.radius() * Math.PI;
         default -> throw new IllegalArgumentException("Unrecognized shape");
      };
   }
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/