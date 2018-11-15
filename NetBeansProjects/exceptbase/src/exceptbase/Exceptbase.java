package exceptbase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptbase {

    public static void main(String[] args) {
        int i = 0;
        boolean done = false;
        do{
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("enter a interger : ");
            i = input.nextInt();
            done = true;
        } catch (InputMismatchException e) {
            System.out.println("error: you did not enter a interger...");

        }
        finally{
            System.out.println("you should die...");
        }
        } while (!done);
        System.out.printf("you entered %d\n", i);

    
        }
    
}
