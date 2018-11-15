
package stringbuilder;

public class Stringbuilder {

    public static void main(String[] args) {
  
        String forward = "this is a test.";
        StringBuilder sb = new StringBuilder();
        sb.append(forward);
      String reverse =  sb.reverse().toString();
      System.out.println(forward);
      System.out.println(reverse);
      
    }
    
}
