package basicfileio;

import java.io.*;
import java.util.Scanner;

public class Basicfileio {

    public static void main(String[] args) {
        File file = new File("testtext.txt");
        try {
            PrintWriter output = new PrintWriter(file);
            output.println("death");
            output.println(42);
            output.close();
        } catch (IOException ex) {
            System.out.printf("error: %s\n", ex);
        }
        try {
            Scanner input = new Scanner(file);
            String name = input.nextLine();
            int age = input.nextInt();

            System.out.printf("name: %s. \n age: %d\n", name, age);
        }catch (FileNotFoundException ex) {
            System.out.println("erroe: file not found");
        }
    }

}
