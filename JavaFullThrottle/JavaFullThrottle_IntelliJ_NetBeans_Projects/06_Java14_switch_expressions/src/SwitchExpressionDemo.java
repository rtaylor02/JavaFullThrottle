// 
import java.util.Scanner;

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