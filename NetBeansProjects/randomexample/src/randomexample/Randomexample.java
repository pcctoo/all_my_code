
package randomexample;

import java.util.Random;


public class Randomexample {

    public static void main(String[] args) {
   Random generator = new Random ();
   int i = generator.nextInt(100);
   System.out.println(i);
      int b = generator.nextInt(100);
   System.out.println(b);
      int k = generator.nextInt(100);
   System.out.println(k);
    }
    
}
