package arraylessbasic;

import java.util.Scanner;

public class Arraylessbasic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name; 
        int grade;
        
        student[] students = new student[4];
        for(int i =0; i<students.length;i++){
            System.out.printf("enter student grade then name for student #%d   ",i);
            grade = input.nextInt();
            name = input.nextLine();
            students[i] = new student(name, grade);
            
        }
        System.out.printf("#\tname\tgrades\n");
        System.out.printf("-\t--------------\n");

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%d\t%s\t%d\n", i, students[i].name(), students[i].grade());
        }

    }
}