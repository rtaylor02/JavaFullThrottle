// compile: javac -source 14 --enable-preview *.java
// run: java --enable-preview TextBlockDemo
public class TextBlockDemo {
   public static void main(String[] args) {
      /* 
         1. The opening """ must be followed by only whitespace and a line break.
         2. Compiler ignores whitespace to the left of the block.
         3. Great for embedding lengthy HTML/XML/SQL strings in code.
      */
      String text_block = """
                          This is\na multiline
                          text block.""";
              
      System.out.println("*******************");
      System.out.println(text_block);
      System.out.println("*******************\n");
      
      String old_query = 
         "INSERT INTO Addresses " +                           
         "(FirstName, LastName, Email, PhoneNumber) " +     
         "VALUES (?, ?, ?, ?)";                           

      String new_query = """
         INSERT INTO Addresses 
         (FirstName, LastName, Email, PhoneNumber) 
         VALUES (?, ?, ?, ?)""";
      
      System.out.printf("old:%n%s%n%n", old_query);
      System.out.printf("new:%n%s%n", new_query);              
   }
}
