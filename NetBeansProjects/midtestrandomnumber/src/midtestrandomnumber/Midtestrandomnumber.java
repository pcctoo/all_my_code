/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtestrandomnumber;

import java.util.Random;
import java.util.Scanner;

public class Midtestrandomnumber {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Random generator = new Random();
      int number = generator.nextInt(10) +1;
      int guess;
      int attempt = 1;
      System.out.println("i am thinking of a number between 1 and 10. what is it?");
      
      while(true) {
             System.out.printf("attempt %d : your guess ==> ", attempt);
          guess = input.nextInt();
          attempt ++;
          
          if(guess == number){
          break;}
      }
      
    }
    
}
