package makeexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Makeexception {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i;
        System.out.print("enter a number between 1 and 10: ");
        try {
            i = input.nextInt();
            if (i < 1 || i > 10) throw new IntergerOutOfRangeException();
            
        } catch (InputMismatchException ex) {
            System.out.println("you did not enter a integer...");

        } catch (IntergerOutOfRangeException ex) {
            System.out.println("your input value is not in the spesified range...");
        }

    }

}
