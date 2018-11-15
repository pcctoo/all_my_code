package ifelsestatment;

import java.util.Scanner;

public class Ifelsestatment {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter a grade number between 0 and 100 : ");
        int grade = input.nextInt();
        //wher rules followed?
        if (grade >= 0 && grade <= 100) {
            System.out.println("you can follow directions");
        } else {
            System.out.println("you have failed me.");
        }
        if (grade < 70) {
            System.out.println("you are stupid!!!");

        }
        if (grade >= 70 && grade <= 79) {
            System.out.println("you are the lowest form of acceptable ok.");

        }
        if (grade >= 80 && grade <= 89) {
            System.out.println("you got a B. but you still suck.");
        }
        if (grade >= 90 && grade <= 99) {
            System.out.println("you got an A. but you still can do better");
        }
        if (grade == 100) {
            System.out.println("you got a perfect score. i still dont like you.");
        }
    }

}
