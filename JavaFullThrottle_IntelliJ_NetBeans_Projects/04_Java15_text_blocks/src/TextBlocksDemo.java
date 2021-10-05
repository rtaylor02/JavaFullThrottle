public class TextBlocksDemo {
   public static void main(String[] args) {
      /* 
         1. Opening """ must be followed by only whitespace and a line break.
         2. Compiler ignores whitespace to the left of the block.
         3. Great for embedding lengthy HTML/XML/SQL strings in code.
         4. If you need \n at end of last line, move closing """ to next line.
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
