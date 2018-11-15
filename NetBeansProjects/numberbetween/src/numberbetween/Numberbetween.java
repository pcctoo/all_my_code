
package numberbetween;
import java.util.Random;
import java.util.Scanner;

public class Numberbetween {

  
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Random generator = new Random();
      int number = generator.nextInt(10) +1;
      int guess = 0;
      int attempt = 1;
      System.out.println("i am thinking of a number between 1 and 10. what is it?");
      while (guess!= number){
          System.out.printf("attempt %d : your guess==> ", attempt);
          guess = input.nextInt();
          attempt++;
          
      }
      System.out.printf("finally! you guessed it. it was %d.\n", guess);
    }
    
}
