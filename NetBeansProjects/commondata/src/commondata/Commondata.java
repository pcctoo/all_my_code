
package commondata;

import java.util.Scanner;


public class Commondata {

    public static void main(String[] args) {
        
     Scanner input = new Scanner (System.in);
     String name, heshe = "";
     int age = 41, retirement = 70, yearstill = 0;
     double gpa = 3.9 ;
     boolean isFemale;
     
     
     System.out.print("enter student name : ");
     name = input.nextLine();
     System.out.print("enter student's age : ");
     age = input.nextInt();
     System.out.print("enter student's gpa : ");
     gpa = input.nextDouble();
    System.out.print("are you fwmale ? (true/false) : ");
    isFemale = input.nextBoolean();
   yearstill = retirement - age;
     heshe= isFemale ? "she" : "he";
     System.out.printf("%s is %d years old.(%d years till retirement) %s has a %4.3f gpa.\n" 
     , name, age, yearstill , heshe, gpa);
    }
    
}
